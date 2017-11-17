<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>卖家帐号表单</title>
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
<style type="text/css">
th {
	width: 130px;
	font-size: 14px;
}

input {
	width: 200px;
	height: 30px;
}
</style>
</head>
<body>
	<form id=seller_editForm method="post">
		<input type="hidden" name="id" value="${decTopic.id }" />
		<table class="tableForm" style="margin-top: 10px;">
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">主题名称<font
					style="color: red">*</font></th>
				<td><input type="text" name="title"
					style="width: 360px; height: 20px" class="textbox textbox_indent"
					value="${decTopic.title}" /></td>
			</tr>
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">时&nbsp;&nbsp;限<font
					style="color: red">*</font></th>
				<td><input style="width: 160px;" name="starttime"
					id="starttime"
					value='<c:if test="${empty(decTopic)}">
						new date()
					</c:if>
					${decTopic.starttimeStr}'
					data-options="formatter:myformatter,parser:myparser"
					class="easyui-datebox" /> ～ <input style="width: 160px;"
					name="endtime" value="${decTopic.endtimeStr}"
					data-options="formatter:myformatter,parser:myparser"
					class="easyui-datebox" /></td>
			</tr>
		</table>
		<input type="hidden" id="filepath" name="filepath" value="" />
	</form>


	<c:if test="${!empty(decTopic)}">
		<table>
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">附件列表:</th>
				<td>
				<ul style="  padding-left: 0px;">
				<c:forEach items="${delAttachList}" var="attList">
				<li id="${attList.id}" style="height:30px;list-style-type: none;"><label >${attList.filename}</label>&nbsp;&nbsp;<a name="${attList.id}" onclick="delAttach(this)" class="easyui-linkbutton">删除</a>
				</li>
				</c:forEach>
				</ul>
				</td>
			</tr>
		</table>
	</c:if>
		<form id="aa" action="${pageContext.request.contextPath}/uploadfile"
			enctype="multipart/form-data" method="POST">
			<table>
				<tr class="thclass" style="height: 40px">
					<th style="width: 130px; font-size: 14px;">附件上传<font
						style="color: red">*</font></th>
					<td><input name="upload" id="upload" class="easyui-filebox"
						style="width: 200px;"
						data-options="prompt:'请选取附件...',buttonText: '选择'" value="" /> <a
						onclick="upload()" class="easyui-linkbutton">上传</a></td>
				</tr>
			</table>
		</form>
	<script>
	
	//附件上传
		function upload() {
			alert($("#upload").filebox('getValue'));
			$.ajax({
				url : '${pageContext.request.contextPath}/uploadfile',
				//	contentType: 'multipart/form-data',
				type : 'post',
				data : {
					file : $("#upload").filebox('getValue')
				},
				fileElementId : 'aa',
				dataType : 'json',
				success : function(json) {
					$("#SSfilepath").val(json.data);
					if (json.success) {
						$("#list_data").datagrid('load');
					}
					$.messager.show({
						title : '提示',
						msg : json.msg
					});
				}
			});
		}
		
		//附件删除
		function delAttach(id){
			  $.ajax({
					url : '${pageContext.request.contextPath}/decTopic/delete/attach',
					type : 'post',
					data : {
						id : $(id).parent().attr("id")
					},
					dataType : 'json',
					success : function(json) {
						$("#SSfilepath").val(json.data);
						if (json.success) {
							$("#list_data").datagrid('load');
						}
						$.messager.show({
							title : '提示',
							msg : json.msg
						});
					}
			  });
			  $(id).parent().remove(); 
		}
	</script>

</body>
</html>
