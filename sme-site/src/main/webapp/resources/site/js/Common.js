
//检查用户是否登录
function CheckSession(type) {
    $.post("/checkSession", function (result) {
    	console.log("session",result);
        var strHtml = "";
        if (result.success == false) {
        	if (type == 1) {
        		strHtml += '<a href="javascript:void(0);" onclick="RedirectLogin()" title="登录">请登录</a>|<a href="javascript:void(0);" onclick="RedirectRegist()" title="免费注册">免费注册</a>|';
        	}else{
	        	//strHtml += '<div class="w_ban3_1_1"><img src="/resources/site/images/w_tux.jpg" title="" alt="" />';
	            //strHtml += '<p><em>您好</em>，欢迎访问玉门市<br />中小企业公共服务平台</p></div>';
	            strHtml += '<div class="w_ban3_2"><a href="javascript:void(0);" onclick="RedirectLogin()" title="登录" class="w_ban3_x1">登录</a>';
	            strHtml += '<a href="javascript:void(0);" onclick="RedirectRegist()" title="注册" class="w_ban3_x2">注册</a></div>';
        	}
            $("#hdnLoginStatus").val("OFF");
        } else {
            if (result.data.usertype == "C") {
                if (type == 1) {
                	strHtml += '<a href="/home.html" title="前往企业中心">欢迎您，' + result.data.account + '</a>|';
                } else {
                    strHtml += '<div class="w_ban3_1_1"><img src="/resources/site/images/w_tux.jpg" title="" alt="" />';
                    strHtml += '<div><span>欢迎您</span>，' + CutStr(result.data.account, 12) + '</div><a href="javascript:void(0)" onclick="Logout()">退出</a></div><div class="w_ban3_2">';
                    strHtml += '<a href="/home.html" title="企业管理" class="w_ban3_x3">企业管理</a>';
                    strHtml += '<a href="/home.html" title="发布需求" class="w_ban3_x2" target="_blank">发布需求</a></div>';
                }
                $("#hdnLoginStatus").val("C");
            } else if (result.data.usertype == "S") {
                if (type == 1) {
                    strHtml += '<a href="' + $("#hdnSpUrl").val() + '" title="前往服务机构管理后台">欢迎您，' + result.Data + '</a>|';
                } else {
                    strHtml += '<div class="w_ban3_1_1"><img src="/resources/site/images/w_tux.jpg" title="" alt="" />';
                    strHtml += '<div><span>欢迎您</span>，' + CutStr(result.Data, 12) + '</div><a href="javascript:void(0)" onclick="Logout()">退出</a></div><div class="w_ban3_2">';
                    strHtml += '<a href="' + $("#hdnSpUrl").val() + '" title="完善机构资质" class="w_ban3_x3">完善机构资质</a>';
                    strHtml += '<a href="' + $("#hdnSpUrl").val() + '" title="发布服务项目" class="w_ban3_x2">发布服务项目</a></div>';
                }

                $("#hdnLoginStatus").val("SVC");
            } else if (result.data.usertype == "E") {
                if (type == 1) {
                    strHtml += '<a href="' + $("#hdnSmeUrl").val() + '" title="前往窗口平台管理后台">欢迎您，' + result.Data + '</a>|';
                } else {
                    strHtml += '<div class="w_ban3_1_1"><img src="/resources/site/images/w_tux.jpg" title="" alt="" />';
                    strHtml += '<div><span>欢迎您</span>，' + result.Data + '</div><a href="javascript:void(0)" onclick="Logout()">退出</a></div><div class="w_ban3_2">';
                    strHtml += '<a href="' + $("#hdnSmeUrl").val() + '" title="管理窗口平台" class="w_ban3_x3">管理窗口平台</a>';
                    strHtml += '<a href="' + $("#hdnSmeUrl").val() + '" title="发布服务项目" class="w_ban3_x2">发布服务项目</a></div>';
                }

                $("#hdnLoginStatus").val("SME");
            } else {
                $("#hdnLoginStatus").val("OFF");
            }
        }
        if (type == 1) {
        	$("#spUserInfo").html(strHtml);
        } else {
            $("#UserInfo").html(strHtml);
        }
    });
}

//搜索
function Search() {
    $("#btnSearchSubmit").click(function () {
    	//var q_type= $("#selSearchType").val();
    	var q_type = 1;
    	var q_keyword = $("#txtSearchText").val();
    	if (q_keyword=="" || q_keyword=="请输入关键字"){
    		$("#txtSearchText").focus();
    		$("#txtSearchText").val();
    		return;
    	}
    	window.location.href = $("#hdnWebUrl").val() + 'search.html?s='+q_type+'&k='+q_keyword;
    });
}

//注册
function RedirectRegist(){
	window.location.href = $("#hdnWebUrl").val()+'reg.html';
}

//sme 中心
function RedirectHome(){
	window.location.href = $("#hdnWebUrl").val()+'home.html';
}

//退出登录
function logout() {
    if (confirm("确定退出吗？")) {
    	window.location.href = $("#hdnAccountUrl").val() + 'logout'+"?service=" + encodeURIComponent(location.href);
    }
}

//加载服务分类（大类）
function LoadClass() {
    $.post("/sclassList", { pclassid: 0 }, function (data) {
        var htmlstr = "";
        for (var i = 0; i < data.length; i++) {
            htmlstr += "<option value=\"" + data[i].id + "\">" + data[i].title + "</option>";
        }
        $("#Superclass").html(htmlstr);
        $("#Subclass").html("<option value=\"0\" >--请选择二级类--</option>");
    });
}

//加载服务分类（小类）
function loadSubclass() {
    var Superclassid = $("#Superclass").val();
    if (Superclassid !='') {
        $("#Superclass").css({ color: "black" });
        $("#Subclass").css({ color: "black" });
        $.post("/sclassList", { pclassid: Superclassid }, function (data) {
       	var htmlstr = "";
       	for (var i = 0; i < data.length; i++) {
               htmlstr += "<option value=\"" + data[i].id + "\">" + data[i].title + "</option>";
           }
           $("#Subclass").html(htmlstr);
       });
    }else {
    	$("#Subclass").html("<option value=\"\" >--请选择二级类--</option>");
        $("#Superclass").css({ color: "grey" });
        $("#Subclass").css({ color: "grey" });
    }
    
    
}

//添加服务需求
function AddDemand() {
    var DemandName = $("#DemandName").val();
    var Superclassid = $("#Superclass").val();
    var Subclassid = $("#Subclass").val();
    var LinkMan = $("#LinkMan").val();
    var LinkPhone = $("#LinkPhone").val();
    var Demand_Detailed = $("#Demand_Detailed").val();
    document.getElementById("DemandName").style.borderColor = '#ccc';
    document.getElementById("Superclass").style.borderColor = '#ccc';
    document.getElementById("LinkMan").style.borderColor = '#ccc';
    document.getElementById("LinkPhone").style.borderColor = '#ccc';
    document.getElementById("Demand_Detailed").style.borderColor = '#ccc';

    if (DemandName == "") {
        $("#DemandName").focus();
        document.getElementById("DemandName").style.borderColor = 'red';
        return;
    }
    if (Superclassid == "") {
        $("#Superclass").focus();
        document.getElementById("Superclass").style.borderColor = 'red';
        return;
    }
    if (LinkMan == "") {
        $("#LinkMan").focus();
        document.getElementById("LinkMan").style.borderColor = 'red';
        return;
    }
    if (LinkPhone == "") {
        $("#LinkPhone").focus();
        document.getElementById("LinkPhone").style.borderColor = 'red';
        return;
    } else if (!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(LinkPhone))) {
        document.getElementById("LinkPhone").style.borderColor = 'red';
        document.getElementById("LinkPhone").value = "";
        document.getElementById("LinkPhone").placeholder = '手机号码格式不对';
        $("#LinkPhone").focus();
        return false;
    }
    if (Demand_Detailed == "") {
        $("#Demand_Detailed").focus();
        document.getElementById("Demand_Detailed").style.borderColor = 'red';
        return;
    }
    var sneedData = {
            title: DemandName,
            content: Demand_Detailed,
            linker: LinkMan,
            linktel: LinkPhone,
            scode: Superclassid,
            subscode: Subclassid
    };
    $.ajax({  
        type: "POST",  
        url: "/cp/sneed/add",  
        data: JSON.stringify(sneedData),//将对象序列化成JSON字符串  
        dataType:"json",  
        contentType : 'application/json;charset=utf-8', //设置请求头信息  
        success: function(data){
        	 alert("需求发布成功!");
        	 window.location.href = $("#hdnWebUrl").val();
        },  
        error: function(res){
        	$.messager.alert("友情提示", "添加失败，请您检查", "error");
    	}
    });        
}

$(function () {
    $("img").error(function () {
        this.onerror = null;
        $(this).attr("src", "/resources/site/images/no.png");
    });

    $(window).scroll(function () {
        if ($(window).scrollTop() >= 100) {
            $('.actGotop').fadeIn(300);
        } else {
            $('.actGotop').fadeOut(300);
        }
    });
    $('.actGotop').click(function () {
        $('html,body').animate({ scrollTop: '0px' }, 800);
    });
});

//生成随机数
function Random() {
    var myrandom = Math.round(Math.random() * 100000);
    return myrandom;
}

//获取URL的传值参数
function GetUrlParameter(paramName) {
    var returnVal = "";
    try {
        var paramUrl = window.location.search;

        //处理长度
        if (paramUrl.length > 0) {
            paramUrl = paramUrl.substring(1, paramUrl.length);
            var paramUrlArray = paramUrl.split("&");
            for (var i = 0; i < paramUrlArray.length; i++) {
                if (paramUrlArray[i].toLowerCase().indexOf(paramName.toLowerCase()) != -1) {
                    var temp = paramUrlArray[i].split("=");
                    if (temp[0].toLowerCase() == paramName.toLowerCase()) {
                        returnVal = temp[1];
                        break;
                    }
                }
            }
        }
    }
    catch (e) {
    }
    return returnVal;
}

//去除HTML标记后，截取指定长度的字符串
function CutStr(str, n) {
    str = String(str || '').replace(/<[^>]+>/g, '').replace(/^\s+/g, '');
    var newStr;
    if (str.length > n) {
        newStr = str.substring(0, n) + "…";
    }
    else {
        newStr = str;
    }
    return newStr;
}

//去空格
String.prototype.trim = function () {
    return this.replace(/(^\s*)|(\s*$)/g, "");
}

//跳转到登录页面
function RedirectLogin(accountType) {
	if (accountType=="S"){
		window.location.href = $("#hdnAccountUrl").val() + "?service=" + encodeURIComponent(location.href) + "&accountGuide=" + accountType;
	}
	if (accountType=="C"){
		window.location.href = $("#hdnAccountUrl").val() + "?service=" + encodeURIComponent(location.href) + "&accountGuide=" + accountType;
	}
    //window.location.href = $("#hdnAccountUrl").val() + "?returnUrl=" + encodeURIComponent(location.href) + "&accountGuide=" + accountGuide;
	//window.location.href = $("#hdnAccountUrl").val() + "?service=" + encodeURIComponent(location.href) + "&accountGuide=" + accountType;
	window.location.href = $("#hdnAccountUrl").val() + "?service=http://www.smeym.org/home.html"  + "&accountGuide=" + accountType;
}

//获取图片地址
function GetImgSrc(OriginalImgSrc, defaultImgSrc) {
    var newImgSrc = "";

    if (OriginalImgSrc != undefined && OriginalImgSrc != defaultImgSrc && OriginalImgSrc != "") {
        var strs = OriginalImgSrc.split("/");
        var i = strs.length - 1;
        if (strs[i] != "") {
            if (strs[i - 1] == "Old") {
                newImgSrc = "Old/" + strs[i];
            }
            else {
                newImgSrc = strs[i - 2] + "/" + strs[i - 1] + "/" + strs[i];
            }
        }
    }
    return newImgSrc;
}

//Json时间转换
function TimeParser(time) {
    if (time == undefined || time == null || time == "") {
        return "";
    }

    var date = new Date();
    date.setTime(time.substr(6, time.length - 8));

    var month = (date.getMonth() + 1).toString();
    if (month.length == 1) {
        month = "0" + month;
    }

    var day = date.getDate().toString();
    if (day.length == 1) {
        day = "0" + day;
    }

    return date.getFullYear() + "-" + month + "-" + day;
}

//加载编辑器
function LoadEditor(textareaName, editor) {
    KindEditor.ready(function (K) {
        this[editor] = K.create(textareaName, {
            allowFileManager: true,
            langType: "zh_CN",
            urlType: "domain",
            uploadJson: '/keditorupload',
            afterUpload: function (fileName, response) {
                if (response.error != 0) {
                    alert(response.message);
                }
            },
            items: [
                'source', '|', 'preview', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
                'justifyfull', '|', 'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
                'italic', 'underline', '|', 'image', 'multiimage', 'table', 'hr', 'baidumap',
                'link', 'unlink', '|', 'fullscreen']
        });
    });
}

//浏览器检测
function BrowserRedirect() {
    var sUserAgent = navigator.userAgent.toLowerCase();

    var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
    var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
    var bIsMidp = sUserAgent.match(/midp/i) == "midp";
    var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
    var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
    var bIsAndroid = sUserAgent.match(/android/i) == "android";
    var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
    var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";

    if (bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM) {
        alert("phone");
    } else {
        alert("pc");
    }
}


//开放平台用户退出系统

//获取URL的传值参数
function GetUrlParameter(paramName) {
    var returnVal = "";
    try {
        var paramUrl = window.location.search;

        //处理长度
        if (paramUrl.length > 0) {
            paramUrl = paramUrl.substring(1, paramUrl.length);
            var paramUrlArray = paramUrl.split("&");
            for (var i = 0; i < paramUrlArray.length; i++) {
                if (paramUrlArray[i].toLowerCase().indexOf(paramName.toLowerCase()) != -1) {
                    var temp = paramUrlArray[i].split("=");
                    if (temp[0].toLowerCase() == paramName.toLowerCase()) {
                        returnVal = temp[1];
                        break;
                    }
                }
            }
        }
    }
    catch (e) { }
    return returnVal;
}
//验证邮箱
function emailyz(vname) { 
  var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
  if (!myreg.test(vname)) {
      return false;
  }
}