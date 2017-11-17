<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新增指标</title>
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
<script type="text/javascript">
$(document).ready(function(){
	$("#showtype").change(function(){
		$("#prop_unit_tr").hide();
		$("#prop_unit_tr").hide();
		 var showtype=$(this).val();
		 if (showtype=='numberbox'){
			 $("#prop_unit_tr").show();
		 }
		 if (showtype=='combobox'){
			 $("#prop_dict_tr").show();
		 }
	});
});

</script>
</head>

<body>
	<fieldset>
	<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">统计指标</legend>
	<form id="prop_form" class="tableForm" style="margin-top: 10px;" method="post" >
		<input type="hidden" name="id" value="${prop.id }" />
		<table class="tableForm" style="margin-top: 10px;">
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; text-align: right;">指标名称<font
					style="color: red">*</font></th>
				<td><input type="text" name="title" style="width: 300px; height: 30px"
					class="textbox textbox_indent easyui-validatebox " required="true"
					missingMessage="属性名称不能为空" value="${prop.title }" /></td>
			</tr>
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; text-align: right;">指标编码<font
					style="color: red">*</font></th>
				<td><input type="text" name="code" style="width: 300px; height: 30px"
					class="textbox textbox_indent easyui-validatebox " required="true"
					missingMessage="指标编码不能为空" value="${prop.code }" /></td>
			</tr>
			
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; text-align: right;">表单类型<font
					style="color: red">*</font></th>
				<td><select id="showtype" name="showtype" class="textbox textbox_indent" style="width: 300px; height: 30px">
						<option value="text">文本</option>
						<option value="numberbox">数值</option>
						<option value="datebox">日期</option>
						<option value="combobox">选择</option>
				</select></td>
			</tr>
			
			<tr class="thclass" style="height: 40px;display: none;" id="prop_unit_tr" >
				<th style="width: 130px; text-align: right;">指标单位<font
					style="color: red">*</font></th>
				<td><input type="text" name="title" style="width: 300px; height: 30px"
					class="textbox textbox_indent easyui-validatebox " required="true"
					missingMessage="属性名称不能为空" value="${prop.title }" /></td>
			</tr>
			<tr class="thclass" style="height: 40px;display: none;" id="prop_dict_tr">
				<th style="width: 130px; text-align: right;">数据字典<font
					style="color: red">*</font></th>
				<td>
				<select id="dictcode" name="dictcode" style="width: 300px; height: 30px">
						<c:forEach items="${dictgrouplist }" var="dictgroup">
						<option value="${dictgroup.code }">${dictgroup.title }</option>
						</c:forEach>
				</select>
				</td>
			</tr>

			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; text-align: right;">默认值</th>
				<td><input type="text" name="title" 
					class="textbox textbox_indent " 
					value="${prop.defval }" /></td>
			</tr>

			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; text-align: right;">状态</th>
				<td colspan="3">
				<select id="status" name="status">
					<option value="1"
						<c:if test="${prop.status=='1' }"> selected="selected"</c:if>>正常</option>
					<option value="0"
						<c:if test="${prop.status=='0' }"> selected="selected"</c:if>>禁用</option>
				</select></td>
			</tr>

			<tr class="thclass" style="height: 130px">
				<th style="width: 130px; text-align: right;">属性描述</th>
				<td colspan="3"><textarea style="width: 350px;" rows="3"
						cols="25" name="remark">${prop.remark }</textarea></td>
			</tr>

		</table>
	</form>
	</fieldset>
</body>

</html>
