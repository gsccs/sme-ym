<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/css.css">
</head>
<body>

   <form id="org_form" action="" method="post">
		<input type="hidden" name="id" value="${org.id }">
		<table cellspacing="0" cellpadding="0">
			<tr class="thclass" style="height: 40px">
					<th style="width: 130px;">机构名称<font style="color: red">*</font></th>
					<td><input type="text" name="name" class="easyui-validatebox"
						required="true" missingMessage="不能为空"
						value="${org.name}" />
					</td>
			</tr>
			
			<tr class="thclass" style="height: 40px">
					<th style="width: 130px;">机构编号</th>
					<td><input type="text" name="code" 
						value="${org.code}" />
					</td>
			</tr>
			
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px;">上级部门<font style="color: red">*</font></th>
				<td>
					<input type="text" id="parentId" name="parentId"  value="${org.parentId }">		
				</td>
			</tr>
			
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px;">部门状态</th>
				<td>
				<select name="state">
					<option value="1" <c:if test="${org.available }"> selected="selected"</c:if>>启用</option>
					<option value="0" <c:if test="${org.available }"> selected="selected"</c:if>>禁用</option>
				</select>		
				</td>
			</tr>
			
		</table>
</form>
<script type="text/javascript">
$('#parentId').combotree({
    url: basepath+'/org/tree',
    /**required: true, **/
    valueField:'id',
    textField:'name',
    method:'post'
}); 
</script>
</body>
</html>