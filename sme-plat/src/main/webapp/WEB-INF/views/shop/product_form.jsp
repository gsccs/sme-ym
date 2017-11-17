<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
</head>

<body>

  <form id="cate_form" method="post">
		<table id="cate_table" class="tableForm" style="margin-top: 10px;">
			<input id="productid" type="text" name="id"  value="${product.id}"/>
			<tr>
				<th style="width: 100px;">名称</th>
				<td><input type="text" name="title" class="easyui-validatebox"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<th style="width: 100px;">类目名称</th>
				<td><input type="text" name="title" class="easyui-validatebox"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<th style="width: 100px;">类目名称</th>
				<td><input type="text" name="title" class="easyui-validatebox"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<th style="width: 100px;">类目名称</th>
				<td><input type="text" name="title" class="easyui-validatebox"
					data-options="required:true" /></td>
			</tr>
		</table>
	</form>
</body>
</html>