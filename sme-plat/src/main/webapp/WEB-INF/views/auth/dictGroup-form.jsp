<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>卖家帐号表单</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
<style type="text/css">
th {
	width: 130px;
	font-size: 14px;
}

input {
	width: 80% !important;
	height: 30px;
}

table {
	width: 100% !important;
}
</style>
</head>

<body>
	<form id=seller_editForm method="post">
		<input type="hidden" name="id" value="${dictGroup.id }" />
		<table class="tableForm" style="margin-top: 10px; width: 100%;">
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">数据项名称<font
					style="color: red">*</font></th>
				<td><input type="text" name="title" class="easyui-validatebox"
					style="width: 80%" value="${dictGroup.title}" /></td>
			</tr>
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">数据项代码<font
					style="color: red">*</font></th>
				<td><input type="text" name="code" class="easyui-validatebox"
					style="width: 80%" value="${dictGroup.code}" /></td>
			</tr>
		</table>
	</form>

</body>

</html>
