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
	width: 200px;
	height: 30px;
}
</style>
</head>

<body>
	<form id=seller_editForm method="post">
		<input type="hidden" name="id" value="${link.id }" /> <input
			type="hidden" name="isok" value="${link.isok }" />
		<table class="tableForm" style="margin-top: 10px;">
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">分类名称<font
					style="color: red">*</font></th>
				<td><select name="parid">
						<!-- <option value="">=====新建分类=====</option> -->
							<c:forEach items="${listLink}" var="linkT">
							<c:choose>
								<c:when test="${link.parid==linkT.id}">
									<option value="${linkT.id}" selected="selected">${linkT.name}</option>
								</c:when>
								<c:otherwise>
									<option value="${linkT.id}">${linkT.name}</option>
								</c:otherwise>
								</c:choose>
							</c:forEach>
				</select></td>
			</tr>
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">链接名称<font
					style="color: red">*</font></th>
				<td><input type="text" name="name" class="easyui-validatebox"
					value="${link.name}" /></td>
			</tr>
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">链接地址<font
					style="color: red">*</font></th>
				<td><input type="text" name="url" class="easyui-validatebox"
					value="${link.url}" /></td>
			</tr>
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">分类类型<font
					style="color: red">*</font></th>
				<td><select name="type">
						<option value="1"
							<c:if test="${link.type==1}">selected="selected"</c:if>>图片</option>
						<option value="2"
							<c:if test="${link.type==2}">selected="selected"</c:if>>下拉</option>
						<option value="3"
							<c:if test="${link.type==3}">selected="selected"</c:if>>文字</option>
				</select></td>
			</tr>
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">链接排序<font
					style="color: red">*</font></th>
				<td><input type="text" name="ordernum"
					class="easyui-validatebox" value="${link.ordernum}" /></td>
			</tr>

		</table>
	</form>

</body>

</html>
