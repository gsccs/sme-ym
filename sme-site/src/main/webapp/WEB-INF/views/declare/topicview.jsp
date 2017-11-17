<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目申报详情_企业管理后台_玉门市中小企业公共服务平台</title>
 <link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/home/css/webindex.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/home/css/admin.css" />

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/home/css/main.css" />
<link id="changbj" rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/easyui/themes/icon.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/site/js/easyui-lang-zh_CN.js"></script>
<script src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/resources/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/resources/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/uploadify/swfobject.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/resources/uploadify/uploadify.css" rel="stylesheet" type="text/css">

<div class="admin_right">
	<div class="indent_title">
		<img
			src="${pageContext.request.contextPath}/resources/home/images/t_05.jpg"
			width="5" height="17" class="fl"><span>项目申报</span>
	</div>

	<div class="Info_center" style="display: ;">
		<div class="">
			<div class="clear"></div>
			<div class="fm_xuxian"></div>
			<dl class="info_dl">
	            <dt class="fm_dt"><span class="fr">项目主题：</span></dt>
	            <dd>
	                <div class="left " style="width: 470px;">${declareTopic.title } </div>
	            </dd>
	        </dl>
	        <dl class="info_dl">
	            <dt class="fm_dt"><span class="fr">主办单位：</span></dt>
	            <dd>
	                <div class="left " style="width: 470px;">${declareTopic.svgtitle }
	                <input type="hidden" id="svgid" class="info_input" value="${declareTopic.svgid }" style="color: #999"  />
	                </div>
	            </dd>
	        </dl>
			<dl class="info_dl">
	            <dt class="fm_dt"><span class="fr">申报开始时间：</span></dt>
	            <dd>
	                <div class="left " style="width: 470px;">${declareTopic.starttimestr } </div>
	            </dd>
	        </dl>
	        <dl class="info_dl">
	            <dt class="fm_dt"><span class="fr">申报结束时间：</span></dt>
	            <dd>
	                <div class="left " style="width: 470px;">${declareTopic.endtimestr } </div>
	            </dd>
	        </dl>
	        
	        <dl class="info_dl">
	            <dt class="fm_dt"><span class="fr">附件列表：</span></dt>
	            <dd>
	                <ul class="left " style="width: 470px;">
	                	<c:forEach items="${declareTopic.attachs }" var="attach">
							<li>${attach.filename } &nbsp;&nbsp;&nbsp;&nbsp;[<a href="${attach.filepath }">下载</a>]</li>
						</c:forEach>
	                </ul>
	            </dd>
	        </dl>
	        
	        <dl class="info_dl">
	            <dt class="fm_dt"><span class="fr">附件列表：</span></dt>
	            <dd>
	                <ul class="left " style="width: 470px;">
	                	<c:forEach items="${declareTopic.attachs }" var="attach">
							<li>${attach.filename } &nbsp;&nbsp;&nbsp;&nbsp;[<a href="${attach.filepath }">下载</a>]</li>
						</c:forEach>
	                </ul>
	            </dd>
	        </dl>
	        
		</div>
		<div class="clear" style="height: 20px; line-height: 20px;"></div>
	</div>
	<div class="Info_bottom"></div>
</div>
</body>
</html>