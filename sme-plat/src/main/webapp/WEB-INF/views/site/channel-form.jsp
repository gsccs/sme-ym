<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>栏目表单</title>
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
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
	var attachs = new Array();
	function BackIndex() {
		self.location = "${pageContext.request.contextPath}/info";
	}
	$(function() {
		LoadEditor('textarea[name="content"]', 'editor');
		$("#uploadify2").uploadify({
			'uploader' : ctx + '/static/uploadify/uploadify.swf',
			'script' : ctx + '/uploadfile',
			'cancelImg' : ctx + '/static/uploadify/cancel.png',
			'folder' : 'UploadFile',
			'queueID' : 'fileQueue',
			'auto' : true,
			'multi' : false,
			'buttonImg' : ctx + '/static/uploadify/uploadify.png',
			'width' : 78,
			'height' : 23,
			'onComplete' : function(event, UserID, fileObj, response, data) {
				if (response != null) {
					$("#txtTishi2").html("图片上传成功");
					var json_data = eval("(" + response + ")");
					console.log(json_data.data.filepath);
					console.log("<img src="+json_data.data.filepath+">");
					$("#img").val(json_data.data.filepath);
					$("#imgshow").attr("src", json_data.data.filepath);
				}
			}
		});

		$('#parid').combotree({
			url : ctx + '/channel/tree',
			required : true,
			valueField : 'id',
			textField : 'title',
			method : 'post'
		});

		$("#infoSaveBtn").click(function() {
			var content = editor.html();
			var channelid = $("#channelid").val();
			var postData = {
				id : channelid,
				title : $("#title").val(),
				template : $("#template").val(),
				pagemark : $("#pagemark").val(),
				content : content,
				parid : $("#parid").combobox('getValue'),
				status : $("#status").val(),
			};
			console.log("postData",postData);
			var posturl = ctx + "/channel/add";
			if (channelid != '') {
				posturl = ctx + "/channel/edit";
			}
			
			$.ajax({  
	            type: "POST",  
	            url: posturl,  
	            data: JSON.stringify(postData),//将对象序列化成JSON字符串  
	            dataType:"json",  
	            contentType : 'application/json;charset=utf-8', //设置请求头栏目  
	            success: function(res){
	            	$.messager.show({
	    				title : '友情提示',
	    				msg : res.msg,
	    				timeout : 3000,
	    				showType : 'slide'
	    			});
	            	window.location.href = ctx+"/channel";
	            },  
	            error: function(res){
	            	$.messager.show({
	    				title : '友情提示',
	    				msg : res.msg,
	    				timeout : 3000,
	    				showType : 'slide'
	    			});
	        	}
	        });
		});
	});
	
	
</script>
</head>
<body style="margin: 10px; padding: 0px; background-color: #fff;">
	<fieldset>
		<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">栏目发布</legend>
		<form id="myform" action="add" method="post">
			<input type="hidden" id="channelid" value="${channel.id }">
			<table cellpadding="3" cellspacing="0" class="edit_table" id="tbEditForm">
				<tr>
					<td class="edit_title"><tt>*</tt>栏目标题：</td>
					<td><input type="text" name="title" id="title"
						style="width: 395px;height: 30px" maxlength="255"
						class="easyui-validatebox textbox textbox_indent"
						value="${channel.title}" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>栏目模板：</td>
					<td><input type="text" id="templet" name="templet" 
						style="width: 395px;height: 30px" maxlength="50"
						class="easyui-validatebox textbox textbox_indent"
						value="${channel.templet }">
					</td>
				</tr>

				<tr>
					<td class="edit_title"><tt>*</tt>上级栏目：</td>
					<td><input type="text" id="parid" name="parid" value="${channel.parid }">
					</td>
				</tr>
				
				<tr>
					<td class="edit_title"><tt>*</tt>栏目标识：</td>
					<td>
					<input type="text" name="pagemark" id="pagemark"
						style="width: 395px;height: 30px" maxlength="50"
						class="easyui-validatebox textbox textbox_indent"
						value="${channel.pagemark}" />
					</td>
				</tr>
				<tr>
					<td class="edit_title" style="vertical-align: top;"><tt>*</tt>栏目内容：</td>
					<td><textarea name="content"
							class="textbox textbox_area textbox_indent"
							style="width: 99%; height: 400px; float: left;">${channel.content}</textarea></td>
				</tr>

				<tr class="thclass" style="height: 40px">
					<th style="width: 130px; font-size: 14px;">栏目状态</th>
					<td>
						<select name="status" id="status" class=" textbox textbox_indent" style="width: 120px;">
							<option value="0" <c:if test="${channel.status=='0'}" >selected="selected"</c:if>>启用</option>
							<option value="1" <c:if test="${channel.status=='1'}" >selected="selected"</c:if>>禁用</option>
						</select>
					</td>
				</tr>
				<tr style="height: 50px;">
					<td colspan="2" style="text-align: right"><a id="infoSaveBtn"
						class="easyui-linkbutton" data-options="iconCls:'icon-save'"
						href="javascript:">保存</a> <a id="btnBack"
						class="easyui-linkbutton" data-options="iconCls:'icon-back'"
						href="javascript:" onclick="BackIndex()">返回</a>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>