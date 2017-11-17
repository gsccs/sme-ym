<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统用户表单</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
</head>
<body>
    <form id="user_pwd_form" method="post">
    	<input type="hidden" id="user_id" name="id" value="${userInfo.id }">
    	<table cellspacing="0" cellpadding="0">
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px;">新密码：<font style="color: red">*</font></th>
				<td><input type="text" id="newPassword" name="newPassword" class="easyui-validatebox"
						required="true" missingMessage="不能为空"
						value="" />
				</td>
			</tr>
		</table>
    </form>
</body>
</html>