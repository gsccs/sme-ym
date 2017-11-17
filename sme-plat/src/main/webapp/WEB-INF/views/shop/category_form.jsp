<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/css.css">
</head>
<body>

  <form id="cate_form" method="post">
		<table id="cate_table" class="tableForm" style="margin-top: 10px;">
			<input id="parId" type="text" name="parId"  value="${pid}"/>
			<tr>
				<th style="width: 100px;">类目名称</th>
				<td><input type="text" name="title" class="easyui-validatebox"
					data-options="required:true" /></td>
			</tr>
		</table>
	</form>
</body>
</html>