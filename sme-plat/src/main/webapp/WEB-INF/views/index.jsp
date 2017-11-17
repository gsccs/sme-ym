<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>玉门中小企业服务平台SP系统</title>
<link
	href="${pageContext.request.contextPath}/static/main/css/public.css"
	type="text/css" rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/static/main/css/houtai.css"
	type="text/css" rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/static/main/css/smartMenu.css"
	type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
.logo-title{
	font-size: 20px;
	font-weight: bolder;
	color: cornflowerblue;
}
</style>
</head>
<body>
	<div id="admin">
		<div class="ad-menu" id="ad-menu">
			<div class="ad-logo">
				<img
					src="${pageContext.request.contextPath}/static/main/image/no.png"
					height="103" width="130">
			</div>
			<div class="ad-list">
				<ul>
					<c:forEach items="${menus }" var="menu">
					<li>
						<div class="li-item">
							<em class="scm li-ico ic1"></em>${menu.name }<span class="scm arrow"></span>
						</div>
						<dl>
							<c:forEach items="${menu.subs }" var="submenu">
							<dt class="dd-item J_menuItem"
								href="${pageContext.request.contextPath}${submenu.url}" data-index="${submenu.id}">${submenu.name }</dt>
							</c:forEach>
						</dl>
					</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="ad-comment-box" id="ad-comment">
			<div class="ad-top-comment">
				<div class="ad-message">
					<div class="ad-top-left">
						<div class="ad-change-btn">
							<a id="ad-list" href="javascript:;" class="scm ad-list-btn"></a>
						</div>
						<div class="ad-search-box clear logo-title" >
						玉门市中小企业服务平台SP系统
						</div>
					</div>
					<div class="ad-top-right">
						<div class="ad-notice">
							<ul>
								<li><a href="/msg" class="scm nt1 J_menuItem" title="平台消息" text="平台消息"><span
										class="scm nt-count dot" id="noticenum">0</span></a></li>
								<li><a href="/consult" class="scm nt2 J_menuItem" title="企业咨询"><span
										class="scm nt-count dot" id="consultnum">0</span></a></li>
								<li><a href="/declare/item" class="scm nt3 J_menuItem" title="待办任务"><span
										class="scm nt-count dot" id="pushnum">0</span></a></li>
							</ul>
						</div>
						<div class="ad-welcom">
							<div class="ad-wel-img">
								<img
									src="${pageContext.request.contextPath}/static/main/image/min_logo.png"
									height="36" width="36">
							</div>
							<div class="ad-wel-text">
								<div class="font-wel">
									欢迎您！<strong>${user.title }</strong>
								</div>
								<div class="font-wel">
									<a href="javascript:;" onclick="logout();"><strong>【退出】</strong></a>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="ad-sub-nav-box content-tabs">
					<a href="javascript:;"
						class="scm jian-a sub-sel pre j_tabBg J_tabLeft"></a>
					<div class="ad-sub-wraper page-tabs J_menuTabs">
						<ul class="ad-sub-list page-tabs-content">
							<li class="active J_menuTab" data-id="${pageContext.request.contextPath}/main">首&nbsp;&nbsp;页</li>
						</ul>
					</div>
					<a href="javascript:;" class="scm jian-a next j_tabBg J_tabRight"></a>
				</div>
			</div>
			<div class="ad-main-comment J_mainContent" id="ad-iframe">
				<iframe class="J_iframe" name="iframe0" width="100%" height="100%"
					src="${pageContext.request.contextPath}/main" frameborder="0"
					data-id="${pageContext.request.contextPath}/main" seamless></iframe>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/main/js/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/main/js/contabs.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/main/js/maintabs.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/main/js/jquery-smartMenu-min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/main/js/jquery.nicescroll.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/js/Common.js"></script>
	<script type="text/javascript">
		$(function() {
			$(".ad-menu").niceScroll({
				cursorborder : "0 none",
				cursorcolor : "#1a1a19",
				cursoropacitymin : "0",
				boxzoom : false
			});
			
			CheckSession();
			
			getPlatMsg();
		});
		
		function getPlatMsg(){
			$.ajax({  
	            type: "GET",  
	            url: "/platmsg",  
	            dataType:"json",  
	            success: function(res){
	            	console.log(res);
	            	if(res){
	            		$("#noticenum").html(res.notice);
	            		$("#pushnum").html(res.push);
	            		$("#sordernum").html(res.msg);
	            	}
	            },  
	            error: function(res){
	            	
	        	}
	        });
		}
	</script>
</body>
</html>