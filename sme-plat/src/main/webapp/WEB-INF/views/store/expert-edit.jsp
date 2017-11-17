<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>服务专家列表</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/default.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/Site.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/Verification.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/Common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/MD5xx.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/syUtil.js"
	charset="utf-8"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/uploadify/jquery.uploadify.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/uploadify/swfobject.js"
	charset="utf-8"></script>
<script type="text/javascript">
	function submit() {
		document.getElementById('myform').submit();
	}
	function BackIndex() {
		self.location = "${pageContext.request.contextPath}/expert";
	}
</script>
</head>
<body style="margin: 10px; padding: 0px; background-color: #fff;">
<script type="text/javascript">
		$(function() {
			$("#uploadify")
					.uploadify(
							{
								'uploader' : '${pageContext.request.contextPath}/static/uploadify/uploadify.swf',
								'script' : '${pageContext.request.contextPath}/uploadfile',
								'cancelImg' : '${pageContext.request.contextPath}/static/uploadify/cancel.png',
								'folder' : 'UploadFile',
								'queueID' : 'fileQueue',
								'auto' : true,
								'multi' : false,
								'buttonImg' : '${pageContext.request.contextPath}/static/uploadify/uploadify.png',
								'width' : 78,
								'height' : 23,
								'onComplete' : function(event, UserID, fileObj,
										response, data) {
									console.log("response:", response);
									pice = response;
									if (response != null) {
										FlieName = response;
										$("#txtTishi").html("附件上传成功");
										var json_data = eval("(" + response
												+ ")");
										$("#logo").val(json_data.data.filepath);
									}
								}
							});
		});
	</script>
	<fieldset>
		<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">服务专家编辑</legend>
		<form id="myform" action="edit" method="post">
			<input type="hidden" name="id" value="${expertT.id}" />
			<table cellpadding="3" cellspacing="0" class="edit_table"
				id="tbEditForm">
					<tr>
					<td class="edit_title"><tt>*</tt>姓名：</td>
					<td><input type="text" name="title" value="${expertT.title}"
						style="width: 150px;" maxlength="512"
						class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>照片：</td>
					<td><input type="file" value="上传文件" id="uploadify" width="78"
						style="display: none;" height="23" /><label id="txtTishi"
						style="font-size: 12px"></label></td>
					<td><input type="hidden" id="logo" name="logo" value="${expertT.logo}"></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>最高学历：</td>
					<td><input type="text" name="degree" value="${expertT.degree}"
						style="width: 150px;" maxlength="512"
						class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>技术职称：</td>
					<td><input type="text" name="technical"
						value="${expertT.technical}" style="width: 200px;" maxlength="512"
						class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>专业年限：</td>
					<td><input type="text" name="proflife"
						value="${expertT.proflife}" style="width: 200px;" maxlength="512"
						class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>联系电话：</td>
					<td><input type="text" name="phone" value="${expertT.phone}"
						style="width: 200px;" maxlength="512"
						class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>邮箱地址：</td>
					<td><input type="text" name="email" value="${expertT.email}"
						style="width: 200px;" maxlength="512"
						class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>年龄：</td>
					<td><input type="text" name="age" value="${expertT.age}"
						style="width: 200px;" maxlength="512"
						class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>性别：</td>
					<td>
					<input type="radio" <c:if test="${expertT.sex=='男'}">checked="checked"</c:if>  name="sex" id="男" value="男" /> 
					<label for="男">男</label>
					<input type="radio" <c:if test="${expertT.sex=='女'}">checked="checked"</c:if>   name="sex" id="女" value="女" /> 
					<label for="女">女</label>
					</td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>工作职务：</td>
					<td><input type="text" name="duties" value="${expertT.duties}"
						style="width: 300px;" maxlength="512"
						class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				<tr style="height: 50px;">
					<td colspan="2" style="text-align: right"><a id="btnAdd"
						class="easyui-linkbutton" data-options="iconCls:'icon-add'"
						href="javascript:" onclick="submit()">确认发布</a> <a id="btnBack"
						class="easyui-linkbutton" data-options="iconCls:'icon-back'"
						href="javascript:" onclick="BackIndex()">返回</a>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>
