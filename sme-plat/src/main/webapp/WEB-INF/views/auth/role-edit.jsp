<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统角色表单</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
</head>

<body>
	<form id="role_form" action="" method="post">

		<input type="hidden" name="id" value="${role.id }">
		<table cellspacing="0" cellpadding="0">
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px;">角色标识<font style="color: red">*</font></th>
				<td><input type="text" name="role" class="easyui-validatebox"
					required="true" missingMessage="不能为空" value="${role.rolecode}" /></td>
			</tr>
			
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px;">角色描述<font style="color: red">*</font></th>
				<td><input type="text" name="description" class="easyui-validatebox"
					required="true" missingMessage="不能为空" value="${role.description}" /></td>
			</tr>

			<tr class="thclass" style="height: 40px">
				<th style="width: 130px;">状态</th>
				<td><select name="state">
						<option value="1">启用</option>
						<option value="0">禁用</option>
				</select></td>
			</tr>

			<tr class="thclass" style="height: 40px">
				<th style="width: 130px;">备注说明</th>
				<td><textarea rows="5" cols="30" name="remark"></textarea></td>
				</td>
			</tr>

		</table>
	</form>
</body>
</html>
