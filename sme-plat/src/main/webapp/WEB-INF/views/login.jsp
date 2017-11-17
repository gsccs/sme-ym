<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script language="JavaScript" src="${pageContext.request.contextPath}/static/login/jquery.js" type="text/javascript"></script>

<title>身份服务器</title>
<link href="${pageContext.request.contextPath}/static/login/css/login_base_style.css" rel="stylesheet" type="text/css">
<!--[if lte IE 6]>
<script type="text/javascript" src="admin/images/DD_belatedPNG_0.0.8a-min.js"></script>
<script>
 DD_belatedPNG.fix(".logo a img,.l-main h6,.head-pic img,.login-ul li input,.a-login,.l-foot");
</script>
<![endif]-->
<script type="text/javascript">
//刷新验证码功能
function refreshVerifyCode() {
	var verifyCodeHtml = "<a href=\"#\" onClick=\"refreshVerifyCode();\" ><img src=\"/ids/admin/abc.code?random=" + Math.random()+" onClick=\"refreshVerifyCode();\"  width=\"85\" height=\"30\" /></a>"
    $(".x_yzm").html(verifyCodeHtml);
}

//点击显示验证码
function displayVerifyCode() {
	var verifyCodeImgHtml = $("#verifyCodeImg").html();
	if(verifyCodeImgHtml != ""){
		document.getElementById("refreshVerifyCodeDesc").innerHTML = "点击更换验证码";
		return;
	}
	//alert("aaa=" +document.getElementById("verifyCodeImg").innerHTML);
	var verifyCodeHtml = "<a href=\"#\" onClick=\"refreshVerifyCode();\" ><img src=\"/ids/admin/abc.code?random=" + Math.random()+" onClick=\"refreshVerifyCode();\"  width=\"85\" height=\"30\" /></a>"
    
    $("#verifyCodeImg").html( "<img align='middle' src='/ids/admin/abc.code?random=" + Math.random() +"' onclick='refreshVerifyCode();' style='cursor: pointer' />");
	$(".x_yzm").html(verifyCodeHtml);
    document.getElementById("refreshVerifyCodeDesc").innerHTML = "点击更换验证码";
}	


//鼠标单击触发登录事件，兼容IE\FF\Chrame
document.onkeydown=function(event){
	   e = event ? event :(window.event ? window.event : null);
	   if(e.keyCode==13){ 
		   send2FAVerifyCode("true");                        
	   }
}	

//页面加载时，获取焦点
function obtainFocus(){
	if(null != document.getElementById('loginKey'))
		document.getElementById('loginKey').focus();
}

//点击登录按钮或者获取验证码按钮时调用此方法
function send2FAVerifyCode(login){
	var loginKey = $("#loginKey").val(); 
	$("#loginType").val("userName");
	if((/^\d+$/.test(loginKey)) && loginKey.length==11)
	{
		$("#loginType").val("mobile");
	}else{
		//判断身份证数字开头并且是18位
		if($("#loginKey").length==18 && (/^[0-9]+[\s\S]*$/.test(loginKey))){
			$("#loginType").val("creditID");
		}
		if(loginKey.indexOf("@")>=0){
			$("#loginType").val("email");
		}
	}
	var loginTypeObj = document.getElementById("loginType");
	var loginType = "userName";
	if(loginTypeObj != null){
		loginType = Trim(loginTypeObj.value);
	}
	if("admin" == loginKey){
		loginType = "userName";
	}
	if(loginKey == "" || loginKey == "用户名"){
		$("#loginFail").show();
		$("#loginFail").html("登录账号不允许为空!");
		document.getElementById("loginKey").focus();
		return;
	}
	var passwordObj = document.getElementById("password");
	if(passwordObj == null || Trim(passwordObj.value) == ""){
		$("#loginFail").show();
		$("#loginFail").html("密码不允许为空!");
		document.getElementById("password").focus();
		return;
	}
	
	var password = Trim(passwordObj.value);
	var source = document.getElementById("sourceName");
	var sourceName = "ids_internal";
	if(source != null){
		sourceName = source.value;
	}
	var codeObj = document.getElementById("verifycode");
	var codeDivObj = document.getElementById("verifyCode-div");
	var display = "none";
	if(codeDivObj != null){
		display = codeDivObj.style.display;
	}
	var code = "";
	if(null != codeObj && "" == display ){
		code = Trim(codeObj.value);
		if(code == "" || code == "验证码"){
			$("#loginFail").show();
			$("#loginFail").html("验证码不允许为空!");
			document.getElementById("verifycode").focus();
			return;
		}
	}
	
	var myDate = new Date();

	var FAValue = $("#2FAVerifyCode").val();
	var paras = 'loginType='+loginType + '&loginKey=' + loginKey + '&password=' + password + '&sourceName=' + sourceName + '&login=' + login +'&FAValue=' + FAValue +'&verifycode=' +code+'&time=' + myDate.getTime();
	var myAjax = $.ajax({
		type:"POST",
		url:"./admin/sendVerifyCodeFor2FA.jsp",
		data:{"loginType":loginType,"loginKey":loginKey,"password":password,"sourceName":sourceName,"login":login,"FAValue":FAValue,"verifycode":code,"time":myDate.getTime()},
		dataType:"text",
		complete: checkUserFinish
		
	})
}

//处理ajax返回的结果
function checkUserFinish(oXmlHttp) {
	var result = Trim(oXmlHttp.responseText);
	//alert("result="+result);
	
	var display = document.getElementById("2FAVerifyCode-tr").style.display;
	// 如果提示不需要输入验证码，则直接返回true，继续提交表单的操作
	var names = new Array();
	names = result.split("|");
	
	// 如果不需要提交验证码的话
	if("NO" == names[0]){
		// 如果是登录请求，则直接登录
		if( names[1] == "true" ){
			doForm();
			// 否则提示不需要
		}else{
			$("#loginFail").show();
			$("#loginFail").html("不需要填写双因子验证码，请直接点击登录!");
			return;
		}
		// 如果存在异常，则直接弹出提示
	}else if(result.indexOf("YES") < 0){
		$("#loginFail").show();
		$("#loginFail").html(names[0]);
		if(names[2] == 1056 || names[2] == 1052){
			// forward
			var loginTypeObj = document.getElementById("loginType");
			var loginType = "userName";
			if(loginTypeObj != null){
				loginType = loginTypeObj.value;
			}
			var loginKey = document.getElementById("loginKey").value;
			var returnUrl = "http%3A%2F%2Faction.hunan.gov.cn%2Fjact%2Ffront%2Ffront_mailwrite.action%3Fsysid%3D33%26groupid%3D1063%26tempfile%3Dids_mailwrite";
			if("true" == "false"){
				document.location.href="http://service.hunan.gov.cn/ids/account/errorInfoForPwdCheck.jsp&errCode=" + names[2] + "&loginKey=" + loginKey + "&loginType=" + loginType + "&returnUrl=" + returnUrl;
			}else{
				document.location.href="http://service.hunan.gov.cn/ids/account/errorInfoForPwdCheck.jsp?errCode=" + names[2] + "&loginKey=" + loginKey + "&loginType=" + loginType + "&returnUrl=" + returnUrl;
			}
			return;
		}
		if(names[3] == 'true'){
			document.getElementById("verifyCode-div").style.display = "";
		}
		if(document.getElementById("verifycode") != null){
			refreshVerifyCode();
		}
		return;
		// 否则，是提示需要输入验证码
	}else{	
		var login = names[2];
		
		// 如果提示需要输入验证码，但是验证码输入框未显示，则让其显示，并提示，返回false
		if("none" == display && "true" == login){
			document.getElementById("2FAVerifyCode-tr").style.display = "";
			$("#loginFail").show();
			$("#loginFail").html("需要输入双因子验证码，请点击获取!");
			return;
		}
		// 如果双因子验证码显示
		if("block" == display || "" == display){
			 // 如果是登录提交，则校验双因子验证码是否填写
			var FAValue = document.getElementById("2FAVerifyCode").value;
			if(FAValue != "双因子验证码" && FAValue !="" && "true" == login){
				doForm();
				return;
			}
			// 如果没有填写，则提示用户填写
			if((FAValue == "" || FAValue == "双因子验证码")  && "true" == login){
				$("#loginFail").show();
				$("#loginFail").html("需要输入双因子验证码，请点击获取!");
				return;
				
			}
			// 不管有没有填写，如果不是登录则，直接提示
			if("false" == login){
				$("#loginFail").show();
				$("#loginFail").html(names[1]);
				return;
			} 
		}
		return;
	}
}

function doForm(){
	var loginKey = Trim(document.getElementById("loginKey").value); 
	 document.getElementById("loginType").value="userName";
	if((/^\d+$/.test(loginKey)) && loginKey.length==11)
	{
		 document.getElementById("loginType").value="mobile";
	}else{
		//判断身份证数字开头并且是18位
		if(loginKey.length==18 && (/^[0-9]+[\s\S]*$/.test(loginKey))){
		  document.getElementById("loginType").value="creditID";
		}
		if(loginKey.indexOf("@")>=0){
		  document.getElementById("loginType").value="email";
		}
	}
	if("admin" == loginKey){
		document.getElementById("loginType").value="userName";
	}
	document.logon.submit();
}

function showDiv(hideId, showId){
	$("#"+showId).show();
	$("#"+hideId).hide();
}


//-->
</script>

<body>
<div class="logo">
<a href="www.smeym.org/index.html" title="玉门市中小企业服务平台">
	<img src="${pageContext.request.contextPath}/static/login/login_logo.png" alt="玉门市中小企业服务平台" />
</a>
</div>
<div class="l-main">
	<h6>统一身份认证系统</h6>
    <div class="l-box clearfix">
    	<div class="head-pic dis-in-b f-l"><img src="${pageContext.request.contextPath}/static/login/login_user_pic.png"></div>
        <div class="login-box dis-in-b f-r">
			<form id="logon" name="logon" action="http://service.hunan.gov.cn/ids/GlobalLoginServlet" method="post">
			<input type="hidden" name="returnUrl" value="http://action.hunan.gov.cn/jact/front/front_mailwrite.action?sysid=33&amp;groupid=1063&amp;tempfile=ids_mailwrite">
			<input type="hidden" name="loginType" id="loginType" value="userName">
				
			<h1 class="wronginfo"><p id="loginFail" style="display:none;color:red;">不存在该用户</p> </h1>
			
        	<ul class="login-ul">
            	<li class="u-name"><input class="txt" tabindex="1" type="text" name="loginKey" id="loginKey" value="用户名" onfocus="if(value==&#39;用户名&#39;) {value=&#39;&#39;;}" onblur="if(value==&#39;&#39;) {value=&#39;用户名&#39;;}"></li>
				
                <li class="u-password"><input class="txt" tabindex="1" type="password" name="password" id="password"></li>
				<li class="2FAVerifyCode-tr" id="2FAVerifyCode-tr" style="display:none;"><input tabindex="1" onfocus="if(value==&#39;双因子验证码&#39;) {value=&#39;&#39;;this.style.color=&#39;#fff&#39;;}" onblur="if(value==&#39;&#39;) {value=&#39;双因子验证码&#39;;this.style.color=&#39;#fff&#39;;}" type="text" name="2FAVerifyCode" id="2FAVerifyCode" class="xyzhn5" value="双因子验证码">
				<a href="http://service.hunan.gov.cn/ids/globalLoginPage.jsp?coAppName=aGRqbA==&coSessionId=OUUyRDlGMDM3OUNFNEVGRjA3REVBREZENzNEMzQwQjQ=&gSessionId=MTJBNDkxREQwNUQ4MTlBRTE1Q0Y2NTk5QjYxREJENjYtNTkuMjMxLjUuNDE=&surl=aHR0cDovL2FjdGlvbi5odW5hbi5nb3YuY24vamFjdC9mcm9udC9mcm9udF9tYWlsd3JpdGUuYWN0aW9uP3N5c2lkPTMzJmdyb3VwaWQ9MTA2MyZ0ZW1wZmlsZT1pZHNfbWFpbHdyaXRl#" name="sendCode" onclick="send2FAVerifyCode(&#39;false&#39;);" class="x_phone">点击获取</a></li>
                <li class="u-btn">
				<a href="http://service.hunan.gov.cn/ids/globalLoginPage.jsp?coAppName=aGRqbA==&coSessionId=OUUyRDlGMDM3OUNFNEVGRjA3REVBREZENzNEMzQwQjQ=&gSessionId=MTJBNDkxREQwNUQ4MTlBRTE1Q0Y2NTk5QjYxREJENjYtNTkuMjMxLjUuNDE=&surl=aHR0cDovL2FjdGlvbi5odW5hbi5nb3YuY24vamFjdC9mcm9udC9mcm9udF9tYWlsd3JpdGUuYWN0aW9uP3N5c2lkPTMzJmdyb3VwaWQ9MTA2MyZ0ZW1wZmlsZT1pZHNfbWFpbHdyaXRl#" id="submitLoginBtn" onclick="send2FAVerifyCode(&#39;true&#39;)" class="a-login">登录</a>
				 
				<a href="http://service.hunan.gov.cn/ids/admin/userhome/forgetPwd.jsp">忘记密码?</a>
				  
				  
				<a onclick="newWindow(this.href,&#39;&#39;,&#39;720&#39;,&#39;570&#39;,&#39;yes&#39;);return false" href="http://service.hunan.gov.cn/ids/admin/userhome/select_regType.jsp?regFlg=aGRqbA==">注册</a>
				 
				</li>
            </ul>
           <dl class="login-other">
            	<dt>可以使用以下方式登录：</dt>
                <dd>
				<a href="http://service.hunan.gov.cn/ids/globalLoginPage.jsp?coAppName=aGRqbA==&coSessionId=OUUyRDlGMDM3OUNFNEVGRjA3REVBREZENzNEMzQwQjQ=&gSessionId=MTJBNDkxREQwNUQ4MTlBRTE1Q0Y2NTk5QjYxREJENjYtNTkuMjMxLjUuNDE=&surl=aHR0cDovL2FjdGlvbi5odW5hbi5nb3YuY24vamFjdC9mcm9udC9mcm9udF9tYWlsd3JpdGUuYWN0aW9uP3N5c2lkPTMzJmdyb3VwaWQ9MTA2MyZ0ZW1wZmlsZT1pZHNfbWFpbHdyaXRl#" onclick="javascript:window.parent.location.href=&#39;/ids/admin/loginByThird.jsp?regFrom=QQ&amp;returnUrl=&amp;appName=ids&#39;;" class="a2">QQ</a>
				<a href="http://service.hunan.gov.cn/ids/globalLoginPage.jsp?coAppName=aGRqbA==&coSessionId=OUUyRDlGMDM3OUNFNEVGRjA3REVBREZENzNEMzQwQjQ=&gSessionId=MTJBNDkxREQwNUQ4MTlBRTE1Q0Y2NTk5QjYxREJENjYtNTkuMjMxLjUuNDE=&surl=aHR0cDovL2FjdGlvbi5odW5hbi5nb3YuY24vamFjdC9mcm9udC9mcm9udF9tYWlsd3JpdGUuYWN0aW9uP3N5c2lkPTMzJmdyb3VwaWQ9MTA2MyZ0ZW1wZmlsZT1pZHNfbWFpbHdyaXRl#" onclick="javascript:window.parent.location.href=&#39;/ids/admin/loginByThird.jsp?regFrom=sinaWeibo&amp;returnUrl=&amp;appName=ids&#39;;" class="a4">新浪微博</a>
				<a href="http://service.hunan.gov.cn/ids/globalLoginPage.jsp?coAppName=aGRqbA==&coSessionId=OUUyRDlGMDM3OUNFNEVGRjA3REVBREZENzNEMzQwQjQ=&gSessionId=MTJBNDkxREQwNUQ4MTlBRTE1Q0Y2NTk5QjYxREJENjYtNTkuMjMxLjUuNDE=&surl=aHR0cDovL2FjdGlvbi5odW5hbi5nb3YuY24vamFjdC9mcm9udC9mcm9udF9tYWlsd3JpdGUuYWN0aW9uP3N5c2lkPTMzJmdyb3VwaWQ9MTA2MyZ0ZW1wZmlsZT1pZHNfbWFpbHdyaXRl#" onclick="javascript:window.location.href=&#39;http://wsbs.hunan.gov.cn/virtualhall/ids_login.jsp&#39;;" class="a1">办事系统</a>
				</dd>
            </dl>
        </form></div>
  </div>
    <p class="l-foot">承办单位:玉门市工业和信息化局&nbsp;&nbsp;</p>
</div>
<script>
function regNewWindow(mypage, myname, w, h, scroll, toolbar,location){
			var nLeftPos = (screen.width) ? (screen.width-w)/2 : 0;
	var nTopPos = (screen.height) ? (screen.height-h)/2 : 0;
	var settings = 'height='+h+',width='+w+',top='+nTopPos+',left='+nLeftPos+',status=yes,resizable';
	if (scroll == null || scroll == "") {
		scroll = "yes";
	}
	if (location == null || location == "") {
		location = "no";
	}
	settings += ',location=' + location;
	settings += ',scrollbars' + (scroll == 'no' ? '=no' : '');
	if (toolbar) {
		settings += ',toolbar=1';
	}
	mypage +="?isHomePage=1";
	var win = window.open(mypage, myname, settings);
	try{
		win.focus();
	}catch(exception){}
	}
</script>
</body>
</html>