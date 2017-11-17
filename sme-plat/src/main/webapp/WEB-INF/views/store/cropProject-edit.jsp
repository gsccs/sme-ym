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
	src="${pageContext.request.contextPath}/static/kindeditor/kindeditor-all-min.js"></script>
<link
	href="${pageContext.request.contextPath}/static/kindeditor/themes/default/default.css"
	rel="stylesheet" />
<script type="text/javascript">
	function submit() {
		if ($("#myform").form('validate')) {
			$("#content").val(editor1.html());
			$("#backdrop").val(editor2.html());
			document.getElementById('myform').submit();
		}
	}
	function BackIndex() {
		self.location = "${pageContext.request.contextPath}/cropProject";
	}
	LoadEditor('textarea[name="content"]', 'editor1');
	LoadEditor('textarea[name="backdrop"]', 'editor2');
</script>
</head>
<body style="margin: 10px; padding: 0px; background-color: #fff;">
	<fieldset>
		<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">企业项目编辑</legend>
		<form id="myform" action="edit" method="post">
		<input type="hidden" name="id" value="${cropProject.id}">
			<table cellpadding="3" cellspacing="0" class="edit_table"
				id="tbEditForm">
				<tr>
					<td class="edit_title"><tt>*</tt>项目名称：</td>
					<td><input type="text" name="title"
						value="${cropProject.title}" style="width: 395px;" maxlength="512"
						class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>

				<tr>
					<td class="edit_title"><tt>*</tt>行业类别：</td>
					<td><select name="intype" id="intype" style="width: 195px;">
							<c:forEach items="${listIndustryT}" var="IndustryT">
								<c:choose>
									<c:when test="${IndustryT.id==cropProject.intype}">
										<option value="${IndustryT.id}" selected="selected">${IndustryT.title}</option>
									</c:when>
									<c:otherwise>
										<option value="${IndustryT.id}">${IndustryT.title}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
				</tr>

				<tr>
					<td class="edit_title"><tt>*</tt>建设地址：</td>
					<td><input type="text" name="address"
						value="${cropProject.address}" style="width: 395px;"
						maxlength="512" class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				<tr>
					<td class="edit_title" style="vertical-align: top;">项目背景：</td>
					<td><textarea name="backdrop" id="backdrop"
							class="textbox textbox_area textbox_indent"
							style="width: 99%; height: 200px; float: left;">${cropProject.backdrop}</textarea></td>
				</tr>
				<tr>
					<td class="edit_title" style="vertical-align: top;">建设内容：</td>
					<td><textarea name="content" id="content"
							class="textbox textbox_area textbox_indent"
							style="width: 99%; height: 200px; float: left;">${cropProject.content}</textarea></td>
				</tr>

				<tr>
					<td class="edit_title"><tt>*</tt>建设时间：</td>
					<td><input style="width: 130px;" name="starttime"
						value="${cropProject.starttimestr}" class="easyui-datebox"
						data-options="required:true,formatter:myformatter,parser:myparser" />
						～ <input style="width: 130px;" name="endtime"
						value="${cropProject.endtimestr}" class="easyui-datebox"
						data-options="formatter:myformatter,parser:myparser" /></td>
				</tr>

				<tr>
					<td class="edit_title"><tt>*</tt><span
						style="letter-spacing: .5em">总</span><span
						style="letter-spacing: .5em">投</span>资：</td>
					<td><input type="text" name="invest"
						value="${cropProject.invest}" style="width: 150px;"
						maxlength="512" class="easyui-validatebox textbox textbox_indent" />
					</td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>资金来源：</td>
					<td><select name="moneytype" id="moneytype"
						style="width: 195px;">
							<c:forEach items="${listMTYPE}" var="listMTYPE">
								<c:choose>
									<c:when test="${listMTYPE.id==cropProject.moneytype}">
										<option value="${listMTYPE.id}" selected="selected">${listMTYPE.title}</option>
									</c:when>
									<c:otherwise>
										<option value="${listMTYPE.id}">${listMTYPE.title}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt><span
						style="letter-spacing: .5em">联</span><span
						style="letter-spacing: .5em">系</span>人：</td>
					<td><input type="text" name="linker"
						value="${cropProject.linker}" style="width: 300px;"
						maxlength="512" class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>联系电话：</td>
					<td><input type="text" name="linktel"
						value="${cropProject.linktel}" style="width: 300px;"
						maxlength="512" class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				<tr style="height: 50px;">
					<td colspan="2" style="text-align: right"><a id="btnAdd"
						class="easyui-linkbutton" data-options="iconCls:'icon-add'"
						href="javascript:" onclick="submit()">保存</a> <a id="btnBack"
						class="easyui-linkbutton" data-options="iconCls:'icon-back'"
						href="javascript:" onclick="BackIndex()">返回</a>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>
