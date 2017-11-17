<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>服务项目编辑</title>
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
		$("#content").val(editor.html());
		document.getElementById('myform').submit();
	}
	function BackIndex() {
		self.location = "${pageContext.request.contextPath}/sitem";
	}
	$(function() {
		LoadEditor('textarea[name="content"]', 'editor');
	});

	//获取二级分类	
	function a(parids) {
		$("#scode option[value='']").remove();
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
							"<option value="+values['id']+">" + values['title']
									+ "</option>");
				});
			}
		});
	}
</script>
</head>
<body style="margin: 10px; padding: 0px; background-color: #fff;">
	<fieldset>
		<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">服务项目编辑</legend>
		<form id="myform" action="edit" method="post">
			<input type="hidden" name="id" value="${sitemT.id}" />
			<input type="hidden" name="svgid" value="${sitemT.svgid}" />
			<table cellpadding="3" cellspacing="0" class="edit_table"
				id="tbEditForm">
				<tr>
					<td class="edit_title"><tt>*</tt>项目名称：</td>
					<td><input type="text" name="title" value="${sitemT.title}"
						style="width: 395px;" maxlength="512"
						class="easyui-validatebox textbox textbox_indent" value="" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>服务分类：</td>
					<td><select name="scode" id="scode" onchange="a(this.value)"
						style="width: 190px;">
							<option value="">=======请选择=======</option>
							<c:forEach items="${list}" var="listSclass">
							<c:choose>
								<c:when test="${listSclass.title==sitemT.sclassstr}">
									<option value="${listSclass.id}" selected="selected">${listSclass.title}</option>
								</c:when>
								<c:otherwise>
									<option value="${listSclass.id}">${listSclass.title}</option>
								</c:otherwise>
								</c:choose>
							</c:forEach>
					</select> <select name="subscode" id="subscode" style="width: 190px;">
							<option value="${sitemT.subscode}">${sitemT.subsclassstr}</option>
					</select></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt><span
						style="letter-spacing: 2em">时</span>限：</td>
					<td><input style="width: 130px;" name="addtime"
						value="${sitemT.addtimeStr}" class="easyui-datebox"
						data-options="required:true,formatter:myformatter,parser:myparser" />
						～ <input id="txtEndTime" style="width: 130px;" name="endtime"
						value="${sitemT.endtimeStr}" class="easyui-datebox"
						data-options="formatter:myformatter,parser:myparser" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt><span
						style="letter-spacing: .5em">联</span><span
						style="letter-spacing: .5em">系</span>人：</td>
					<td><input type="text" name="linker" style="width: 125px;"
						maxlength="10" data-options="required:true,validType:'CHS'"
						class="easyui-validatebox textbox textbox_indent"
						value="${sitemT.linker}" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>联系电话：</td>
					<td><input type="text" name="phone" style="width: 125px;"
						maxlength="25" class="easyui-validatebox textbox textbox_indent"
						value="${sitemT.phone}" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>ＱＱ号码：</td>
					<td><input type="text" name="qq" style="width: 125px;"
						maxlength="10" data-options="required:true,validType:'QQ'"
						class="easyui-validatebox textbox textbox_indent"
						value="${sitemT.qq}" /> （用于与客户在线对话）</td>
				</tr>
				<tr>
					<td class="edit_title">电子邮箱：</td>
					<td><input type="text" name="email" style="width: 200px;"
						maxlength="64" class="easyui-validatebox textbox textbox_indent"
						data-options="validType:'email'" value="${sitemT.email}" /></td>
				</tr>
				<tr>
					<td class="edit_title">服务对象：</td>
					<td style="border-bottom: 1px solid #ccc;">
						<ul class="chk_lst">
							<c:forEach items="${otypelist}" var="otypelist">
								<c:choose>
									<c:when test="${sitemT.sproject.contains(otypelist.id)}">
										<li><input type="checkbox" name="sproject"
											id="${otypelist.id}" value="${otypelist.id}"
											checked="checked" /><label for="${otypelist.id}">${otypelist.title}</label></li>
									</c:when>
									<c:otherwise>
										<li><input type="checkbox" name="sproject"
											id="${otypelist.id}" value="${otypelist.id}" /><label
											for="${otypelist.id}">${otypelist.title}</label></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="edit_title">服务方式：</td>
					<td style="border-bottom: 1px solid #ccc;">
						<ul class="chk_lst">
							<c:forEach items="${stypelist}" var="stypelist">
								<c:choose>
									<c:when test="${sitemT.spattern.contains(stypelist.id)}">
										<li><input type="checkbox" name="spattern"
											id="${stypelist.id}" value="${stypelist.id}"
											checked="checked" /><label for="${stypelist.id}">${stypelist.title}</label></li>
									</c:when>
									<c:otherwise>
										<li><input type="checkbox" name="spattern"
											id="${stypelist.id}" value="${stypelist.id}" /><label
											for="${stypelist.id}">${stypelist.title}</label></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ul>
					</td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>收费模式：</td>
					<td><input type="text" name="price" value="${sitemT.price}"
						class="easyui-numberbox" style="width: 80px;" /> <c:forEach
							items="${ptypelist}" var="ptypelist">
							<c:choose>
								<c:when test="${sitemT.spayunit.contains(ptypelist.id)}">
									<input type="radio" name="spayunit" id="${ptypelist.id}"
										value="${ptypelist.id}" checked="checked" />
									<label for="${ptypelist.id}">${ptypelist.title}</label>
								</c:when>
								<c:otherwise>
									<input type="radio" name="spayunit" id="${ptypelist.id}"
										value="${ptypelist.id}" />
									<label for="${ptypelist.id}">${ptypelist.title}</label>
								</c:otherwise>
							</c:choose>
						</c:forEach></td>
				</tr>
				<tr>
					<td class="edit_title"
						style="vertical-align: top; text-align: right;">
						其它收费&nbsp;&nbsp; <br /> 模式描述：
					</td>
					<td><textarea name="otherpay"
							class="textbox textbox_area textbox_indent" rows="5" cols="10"
							style="width: 345px; height: 100px;">${sitemT.otherpay}</textarea></td>
				</tr>
				<tr>
					<td class="edit_title" style="vertical-align: top;">项目介绍：</td>
					<td><textarea name="content" id="content"
							class="textbox textbox_area textbox_indent"
							style="width: 99%; height: 200px; float: left;">${sitemT.content}</textarea></td>
				</tr>
				<%-- 				<tr>
					<td class="edit_title" style="vertical-align: top;">服务流程：</td>
					<td><textarea name="barcode"
							class="textbox textbox_area textbox_indent"
							style="width: 99%; height: 100px; float: left;">${sitemT.barcode}</textarea></td>
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
