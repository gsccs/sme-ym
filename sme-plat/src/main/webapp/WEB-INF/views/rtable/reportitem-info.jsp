<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>报表详情</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/Common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/kindeditor/kindeditor-all-min.js"></script>
<link
	href="${pageContext.request.contextPath}/static/kindeditor/themes/default/default.css"
	rel="stylesheet" />
<script
	src="${pageContext.request.contextPath}/static/uploadify/jquery.uploadify.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/static/uploadify/swfobject.js"
	type="text/javascript"></script>
<link
	href="${pageContext.request.contextPath}/static/uploadify/uploadify.css"
	rel="stylesheet" type="text/css" />
<style type="text/css">
th {
	width: 130px;
	font-size: 14px;
}
</style>

</head>
<body>

	<fieldset>
		<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">报送详情</legend>
		<form>
			<table class="tableForm" style="margin-top: 10px;">
				<tr class="thclass" style="height: 40px">
					<th style="width: 130px; font-size: 14px;">报出企业<font
						style="color: red">*</font></th>
					<td><label 	style="width: 300px; height: 30px" >${reportItem.corptitle}</label></td>
				</tr>

				<tr class="thclass" style="height: 40px">
					<th style="width: 130px; font-size: 14px;">报出日期<font
						style="color: red">*</font></th>
					<td><label 	style="width: 345px; height: 100px;">${reportItem.submitdatestr}</label></td>
				</tr>
								<tr class="thclass" style="height: 40px">
					<th style="width: 130px; font-size: 14px;">上报日期<font
						style="color: red">*</font></th>
					<td><label 	style="width: 345px; height: 100px;">${reportItem.addtimestr}</label></td>
				</tr>
											<tr class="thclass" style="height: 40px">
					<th style="width: 130px; font-size: 14px;">备注说明<font
						style="color: red">*</font></th>
					<td><label 	style="width: 345px; height: 100px;">${reportItem.remark}</label></td>
				</tr>
				
				<tr class="thclass" style="height: 40px">
					<th style="width: 130px; font-size: 14px;">附件列表</th>
					<td>
						<ul style="padding-left: 0px;">
							<c:forEach items="${reportItem.attachs}" var="attach">
								<li style="padding: 5px; list-style-type: none;">
								${attach.filename}
								[<a href="${attach.filepath}" target="blank">下载</a>]</li>
							</c:forEach>
						</ul>
					</td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>