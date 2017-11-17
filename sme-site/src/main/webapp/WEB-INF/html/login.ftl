<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>企业/服务机构登录_玉门市中小企业公共服务平台</title>
<link rel="shortcut icon" href="http://account.smehn.cn/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet" type="text/css"
	href="${base}/resources/site/css/base.css" />
<script type="text/javascript"
	src="${base}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="${base}/resources/site/js/jquery.unobtrusive-ajax.min.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/Common.js"></script>

<link rel="stylesheet" type="text/css"
	href="${base}/resources/site/css/loginreg.css" />
<script src="${base}/resources/site/js/LogRegValidate.js"
	type="text/javascript"></script>
<script type="text/javascript">
$(function() {
	$("input[name='AccountGuide'][value='Entp']").attr(
			"checked", "checked");
});					
</script>
</head>
<body>
	<div class="container">
		<div class="w_h2">
			<div class="w_h2_1">
				<a href="#" title="玉门市中小企业公共服务平台"> <img
					src="./服务机构登录_files/w_logo.png" title="玉门市中小企业公共服务平台"
					alt="玉门市中小企业公共服务平台"></a>
			</div>
		</div>
		<div class="clear"></div>

		<div class="lg_main">
			<div class="w1000">
				<div class="lg_login">
					<div class="lg_title">
						<span>用户登录</span> <a
							href="http://account.smehn.cn/Reg/EntpSvcSelect"><i
							class="iconfont" title="立即注册"></i>立即注册</a>
					</div>
					<form action="http://account.smehn.cn/Login/EntpSvcLoginSubmit"
						data-ajax="true" data-ajax-success="CallBackLoginReg" id="form0"
						method="post">
						<div class="lg_cont">
							<dl class="lgc_type">
								<dt>帐号类型：</dt>
								<dd>
									<input type="radio" name="AccountGuide" id="rblEntp"
										required="required" data-msg-name="帐号类型" value="Entp"
										checked="checked"><label for="rblEntp">企 业</label>
								</dd>
								<dd>
									<input type="radio" name="AccountGuide" id="rblSvc"
										required="required" data-msg-name="帐号类型" value="Svc"><label
										for="rblSvc">服务机构</label>
								</dd>
								<dd>
									<input type="radio" name="AccountGuide" id="rblSme"
										required="required" data-msg-name="帐号类型" value="Sme"><label
										for="rblSme">窗口平台</label>
								</dd>
							</dl>
							<div class="lgc_input">
								<div class="lgci_icon">
									<i class="iconfont" title="用户名"></i>
								</div>
								<input type="text" name="UserName" maxlength="100"
									required="required" autocomplete="on" autofocus="autofocus"
									data-msg-name="用户名" placeholder="用户名/邮箱">
							</div>
							<div class="lgc_input">
								<div class="lgci_icon">
									<i class="iconfont" title="密码"></i>
								</div>
								<input type="password" name="Pwd" maxlength="50"
									required="required" data-msg-name="登录密码" placeholder="密码">
							</div>
							<div class="lgc_input lgc_code">
								<div class="lgci_icon">
									<i class="iconfont" title="验证码"></i>
								</div>
								<input type="text" name="Code" maxlength="4" required="required"
									data-msg-name="验证码" placeholder="验证码"> <img
									id="imgCode" alt="看不清？点击换一张"
									src="./服务机构登录_files/GetValidateCode" onclick="ChangeCode()">
										<a href="javascript:void(0)" onclick="ChangeCode()"
										class="desc">看不清？点击换一张</a>
							</div>
							<div class="lgc_info">
								<input type="checkbox" id="cbRembUser" name="RembUser"><label
									for="cbRembUser">记住密码</label> <a
									href="http://account.smehn.cn/?returnUrl=http%3a%2f%2fwww.smehn.cn%3a80%2fEntpAdmin%2fDemand%2fDetail&accountGuide=Entp#"
									class="lgci_forg">忘记密码？</a>
							</div>
							<div class="lgc_submit">
								<input type="submit" id="btnSubmit" value="登 录">
							</div>
							<div id="Msg" class="lgc_msg">请输入用户名！</div>
						</div>
						<input type="hidden" id="hdnReturnUrl" name="ReturnUrl"
							value="http://www.smehn.cn:80/EntpAdmin/Demand/Detail">
					</form>
				</div>
			</div>
		</div>

		<div class="clear"></div>
	</div>
	<div class="foot">
		<ul>
			<li style="height: 22px;"></li>
			<li><a href="#Home/Contact">联系我们</a>&nbsp;
				|&nbsp; <a href="#Home/About"> 平台简介</a>&nbsp;
				|&nbsp; <a href="#Home/EntpHelp">操作手册</a></li>
			<li>主管单位：<a href="http://www.hnjxw.gov.cn/" target="_blank"
				rel="nofollow">玉门市经济和信息化委员会</a>&nbsp; 建设单位：<a
				href="#" target="_blank" rel="nofollow">玉门市中小企业服务中心</a></li>
			<li>版权所有：<a href="#" target="_blank">玉门市中小企业公共服务平台有限公司</a>&nbsp;
			</li>
			<li>Copyright (C) 2010-2016&nbsp; <a href="#">www.smehn.cn</a>&nbsp;
				证书编码：甘ICP备13005515号-1&nbsp; <script type="text/javascript">
					var cnzz_protocol = (("https:" == document.location.protocol) ? " https://"
							: " http://");
					document
							.write(unescape("%3Cspan id='cnzz_stat_icon_1000280965'%3E%3C/span%3E%3Cscript src='"
									+ cnzz_protocol
									+ "s23.cnzz.com/z_stat.php%3Fid%3D1000280965%26show%3Dpic1' type='text/javascript'%3E%3C/script%3E"));
				</script><span id="cnzz_stat_icon_1000280965"><a
					href="http://www.cnzz.com/stat/website.php?web_id=1000280965"
					target="_blank" title="站长统计"><img border="0" hspace="0"
						vspace="0" src="./服务机构登录_files/pic1.gif"></a></span> <script
					src="./服务机构登录_files/z_stat.php" type="text/javascript"></script> <script
					src="./服务机构登录_files/core.php" charset="utf-8"
					type="text/javascript"></script>
			</li>
		</ul>
	</div>
	<div class="actGotop" style="display: none;">
		<a href="javascript:;" title="返回顶部"></a>
	</div>



</body>
</html>