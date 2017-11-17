<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统资源表单</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
</head>

<body>
	<form id="resource_form" action="" method="post">
		<input type="hidden" name="id" value="${resource.id }">
		
		<table cellspacing="0" cellpadding="0">
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px;">资源名称<font style="color: red">*</font></th>
				<td><input type="text" name="name" class="easyui-validatebox"
						required="true" missingMessage="不能为空"
						value="${resource.name}" />
				</td>
			</tr>
			
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px;">上级资源</th>
				<td><input type="text" id="parentId" name="parentId" 
						value="${resource.parentId}" />
				</td>
			</tr>
			
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px;">资源路径</th>
				<td><input type="text" name="url" 
						value="${resource.url}" />
				</td>
			</tr>
			
			<tr class="thclass" style="height: 40px">
					<th style="width: 130px;">权限字符串</th>
					<td><input type="text" name="permission" 
						value="${resource.permission}" />
					</td>
			</tr>
			
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px;">资源类型</th>
				<td>
				<select name="type">
					<option value="menu" <c:if test="${resource.type=='menu' }">selected="selected"</c:if>>菜单</option>
					<option value="button" <c:if test="${resource.type=='button' }">selected="selected"</c:if>>按钮</option>
				</select>		
				</td>
			</tr>
			
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px;">状态</th>
				<td>
				<select name="state">
					<option value="1">启用</option>
					<option value="0">禁用</option>
				</select>		
				</td>
			</tr>
			
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px;">备注说明</th>
				<td><textarea rows="5" cols="30" name="remark">${resource.remark }</textarea>  </td>
				</td>
			</tr>
		</table>
</form>
<script type="text/javascript">

$(function () {
	$('#parentId').combotree({
	    url: basepath+'/resource/tree',
	    valueField:'id',
	    textField:'name',
	    method:'post'
	}); 
});
</script>
</body>
</html>
