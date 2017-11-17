<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>平台消息表单</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
</head>

<body>
	<form id="msg_form" action="" method="post">
		<input type="hidden" name="id" value="${msg.id }">
		<table cellspacing="0" cellpadding="0">
			<tr class="thclass" style="height: 40px">
					<th style="width: 130px;">消息标题<font style="color: red">*</font></th>
					<td><input type="text" name="title" class="easyui-validatebox"
						required="true" missingMessage="不能为空"
						value="${msg.title}" />
					</td>
			</tr>
			
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px;">接收者<font style="color: red">*</font></th>
				<td>
						
				</td>
			</tr>
			
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px;">通知方式</th>
				<td>
					<input type="radio" name="noticetype" value="isphone" checked="checked">短信通知		
					<input type="radio" name="noticetype" value="isphone">邮件通知
				</td>
			</tr>
			
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px;">消息内容</th>
				<td><textarea rows="5" cols="40" name="content"></textarea>  </td>
				</td>
			</tr>
			
		</table>
	</form>
<script type="text/javascript">
var basepath="${pageContext.request.contextPath}";
$('#edit_orgId').combotree({
    url: basepath+'/org/tree',
    required: true,
    //data : [{id: 1,text: 'Languages',children: [{id: 11,text:'Java'},{id: 12,text: 'C++'}]},{id: 222,text: 'Language2'}],
    valueField:'id',
    textField:'name',
    method:'post'
}); 
</script>
</body>
</html>
