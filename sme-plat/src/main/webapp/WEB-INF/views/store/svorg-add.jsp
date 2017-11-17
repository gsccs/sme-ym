<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
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
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/kindeditor/kindeditor-all-min.js"></script>
<link
	href="${pageContext.request.contextPath}/static/kindeditor/themes/default/default.css"
	rel="stylesheet" />
<script type="text/javascript">
	function submit() {
		if($("#myform").form('validate')){
			$("#content").val(editor.html());
		document.getElementById('myform').submit();
		}
	}
	function BackIndex() {
		self.location = "${pageContext.request.contextPath}/svorg";
	}
	//获取二级分类	
	function a(parids) {
		$("#sclassstr option[value='']").remove();
		$.ajax({
			url : "${pageContext.request.contextPath}/sitem/getTags",
			type : "POST",
			data : {
				parids : parids
			},
			dataType : "JSON",
			success : function(data) {
				$("#subscode").empty();
				$.each(data, function(index, values) { // 解析出data对应的Object数组  
					$("#subscode").append(
							"<option value="+values['id']+">"
									+ values['title'] + "</option>");
				});
			}
		});
	}
</script>
</head>
<body style="margin: 10px; padding: 0px; background-color: #fff;">
	<script type="text/javascript">
		$(function() {
			LoadEditor('textarea[name="content"]', 'editor');
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
		<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">服务机构注册</legend>
		<form id="myform" action="add" method="post">
			<table cellpadding="3" cellspacing="0" class="edit_table"
				id="tbEditForm">
				<tr>
					<td class="edit_title"><tt>*</tt>机构名称：</td>
					<td><input type="text" name="title" value="${svorgT.title}"
						style="width: 395px;" maxlength="512" data-options="required:true,validType:'NULL'"
						class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>机构logo：</td>
					<td><input type="file" value="上传文件" id="uploadify" width="78"
						style="display: none;" height="23" /><label id="txtTishi"
						style="font-size: 12px"></label></td>
					<td><input type="hidden" id="logo" name="logo" value=""></td>
				</tr>

				<tr>
					<td class="edit_title"><tt>*</tt>机构性质：</td>
					<td><c:forEach items="${listSOBJ}" var="listSOBJ">
							<input type="radio" name="nature" id="${listSOBJ.id}"
								value="${listSOBJ.id}" />
							<label for="${listSOBJ.id}">${listSOBJ.title}</label>
						</c:forEach></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>机构法人：</td>
					<td><input type="text" name="legaler" value="${svorgT.legaler}"
						style="width: 150px;" maxlength="512"
						class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>联系人：</td>
					<td><input type="text" name="linker" value="${svorgT.linker}"
						style="width: 300px;" maxlength="512"
						class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>联系电话：</td>
					<td><input type="text" name="linktel" value="${svorgT.linktel}"
						style="width: 300px;" maxlength="512"
						class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>服务分类：</td>
					<td><select name="scode" id="scode" onchange="a(this.value)"
						style="width: 190px;">
							<option value="">=======请选择=======</option>
							<c:forEach items="${listSclass}" var="listSclass">
								<c:choose>
									<c:when test="${listSclass.title==svorgT.sclassstr}">
										<%-- <option value="${svorgT.sclassstr}" selected="selected">${svorgT.sclassstr}</option> --%>
									</c:when>
									<c:otherwise>
										<option value="${listSclass.id}">${listSclass.title}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select> <select name="subscode" id="subscode" style="width: 190px;">
							<option value="">=====请选择一级分类=====</option>
					</select></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>机构代码：</td>
					<td><input type="text" name="orgcode"
						value="${svorgT.orgcode}" style="width: 200px;"
						maxlength="512" class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>工商注册：</td>
					<td><input type="text" name="regcode"
						value="${svorgT.regcode}" style="width: 200px;" maxlength="512"
						class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>注册类型：</td>
					<td><input type="text" name="regtype"
						value="${svorgT.regtype}" style="width: 200px;" maxlength="512"
						class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>行业代码：</td>
					<td><input type="text" name="hycode"
						value="${svorgT.hycode}" style="width: 200px;" maxlength="512"
						class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>控股情况：</td>
					<td><input type="text" name="stake"
						value="${svorgT.stake}" style="width: 200px;" maxlength="512"
						class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>注册资本：</td>
					<td><input type="text" name="regasset"
						value="${svorgT.regasset}" style="width: 200px;" maxlength="512"
						class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>详细地址：</td>
					<td><input type="text" name="address"
						value="${svorgT.address}" style="width: 300px;" maxlength="512"
						class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
								<tr>
					<td class="edit_title" style="vertical-align: top;">部门职责：</td>
					<td><textarea name="content" id="content"
							class="textbox textbox_area textbox_indent"
							style="width: 99%; height: 200px; float: left;">${svorgT.content}</textarea></td>
				</tr>
<%-- 				<tr>
					<td class="edit_title"><tt>*</tt>状态：</td>
					<td><input type="text" name="paytype"
						value="${svorgT.paytype}" style="width: 150px;" maxlength="512"
						class="easyui-validatebox textbox textbox_indent" /></td>
				</tr> --%>

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
