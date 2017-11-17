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
		self.location = "${pageContext.request.contextPath}/sneed";
	}
	$(function() {
		LoadEditor('textarea[name="content"]', 'editor');
	});
	//获取二级分类	
	function a(parids){
		$("#barcode option[value='']").remove();
		$.ajax({
			url : "${pageContext.request.contextPath}/sneed/getTags",
			type : "POST",
			data : {parids:parids},
			dataType : "JSON",
			success : function(data) {
				$("#img").empty();
	            $.each(data, function(index,values){   // 解析出data对应的Object数组  
	            			$("#img").append("<option value="+values['title']+">"+values['title']+"</option>");
	            });
			}
		});
	}
</script>
</head>
<body style="margin: 10px; padding: 0px; background-color: #fff;">
	<fieldset>
		<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">服务需求发布</legend>
		<form id="myform" action="add" method="post">
			<table cellpadding="3" cellspacing="0" class="edit_table"
				id="tbEditForm">
				<tr>
					<td class="edit_title"><tt>*</tt>需求名称：</td>
					<td><input type="text" name="title" value="${sneedT.title}"
						style="width: 395px;" maxlength="512" 
						class="easyui-validatebox textbox textbox_indent" value="" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>需求分类：</td>
					<td><select  name="barcode" id="barcode"  onchange="a(this.value)"
						style="width: 190px;">
						<option value="">=======请选择=======</option>
							<c:forEach items="${list}" var="list">
								<c:choose>
									<c:when test="${list.title==sneedT.barcode}">
										<option value="${sneedT.barcode}" selected="selected">${sneedT.barcode}</option>
									</c:when>
									<c:otherwise>
										<option value="${list.title}">${list.title}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select> <select  name="img" id="img" style="width: 190px;">
							<option value="">=====请选择一级分类=====</option>
					</select>
					</td>
				</tr>
					<tr>
					<td class="edit_title" style="vertical-align: top;">具体要求：</td>
					<td><textarea  name="content" id="content"
							class="textbox textbox_area textbox_indent"
							style="width: 80%; height: 300px; float: left;">${sneedT.content}</textarea>
							</td>
				</tr>
								<tr>
					<td class="edit_title" style="vertical-align: top;">联系电话：</td>
					<td><input type="text" name="status" value="${sneedT.status}"
						style="width: 150px;" maxlength="512" 
						class="easyui-validatebox textbox textbox_indent" value="" />&nbsp;&nbsp;号码仅官方可见，不会泄露您的隐私
							</td>
				</tr>
												<tr>
					<td class="edit_title" style="vertical-align: top;"><span
						style="letter-spacing: 2em">出</span>价：</td>
					<td><input type="text" name="price" value="${sneedT.price}"
						style="width: 150px;" maxlength="512" 
						class="easyui-validatebox textbox textbox_indent" value="" />&nbsp;&nbsp;合理的定价可以吸引更多专业服务机构
							</td>
				</tr>
				<tr>
					<td class="edit_title">完成时限：</td>
					<td><input style="width: 130px;" name="addtime"
						value="new Date()" class="easyui-datebox"
						data-options="required:true,formatter:myformatter,parser:myparser" />
				</td>
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
