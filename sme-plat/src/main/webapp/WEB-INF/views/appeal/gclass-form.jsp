<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
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
		<input type="hidden" name="id" value="${sclassT.id }" />
		<%--  <input	type="hidden" name="indexnum" value="${sclassT.indexnum }" /> --%>
		<table class="tableForm" style="margin-top: 10px;">

<%-- 			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">父类名称<font
					style="color: red">*</font></th>
				<td><select class="easyui-combobox"
					name="parids" style="width: 200px;">
						<c:forEach items="${sclassTPar}" var="sclassTPar">
							<c:choose>
								<c:when test="${sclassTPar.title==sclassT.parids}">
									<option value="${sclassTPar.title}" selected="selected">${sclassTPar.title}</option>
								</c:when>
								<c:when test="${sclassTPar.parids==''}">
								<option value="1"  selected="selected"></option>
								</c:when>
								<c:otherwise>
									<option value="${sclassTPar.title}">${sclassTPar.title}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<option value="1" >一级分类</option>
				</select></td>
			</tr> --%>
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">父分类编号<font
					style="color: red">*</font></th>
				<td><input type="text" name="parid" class="easyui-validatebox"
					value="${sclassT.parid}" /></td>
			</tr>
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">分类名称<font
					style="color: red">*</font></th>
				<td><input type="text" name="title" class="easyui-validatebox"
					value="${sclassT.title}" /></td>
			</tr>
		</table>
	</form>

</body>

</html>
