<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>站点热点表单</title>
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
					$("#img").val(json_data.data.filepath);
					$("#imgshow").attr("src", json_data.data.filepath);
				}
			}
		});
	});
	
	
	function submitForm() {
		var bannerid = $("#bannerid").val();
		var title = $("#title").val();
		var classtag = $("#classtag").val();
		var url = $("#url").val();
		var img = $("#img").val();
		if (null==title){
			layer.alert("热点标题不能为空");
			return false;
		}
		if (null==classtag){
			layer.alert("分类标识不能为空");
			return false;
		}
		
		if (null==url){
			layer.alert("连接地址不能为空");
			return false;
		}
		
		if (null==img){
			layer.alert("热点图片不能为空");
			return false;
		}
		
		var postData = {
			id : bannerid,
			title : $("#title").val(),
			img : $("#img").val(),
			url : $("#url").val(),
			classtag : $("#classtag").val(),
			remark : $("#remark").val(),
			status : $("#status").val()
		};
		var posturl = ctx + "/banner/add";
		if (bannerid != '') {
			posturl = ctx + "/banner/edit";
		}
		
		console.log("postData",postData);
		$.ajax({  
            type: "POST",  
            url: posturl,  
            data: JSON.stringify(postData),//将对象序列化成JSON字符串  
            dataType:"json",  
            contentType : 'application/json;charset=utf-8', //设置请求头信息  
            success: function(res){
            	window.location.href = "/banner";
            },  
            error: function(res){
				layer.alert("保存失败");
				$('#dvSubmit').removeAttr("disabled");
        	}
        });
	}
</script>
</head>
<body style="margin: 10px; padding: 0px; background-color: #fff;">
	<fieldset>
		<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">站点热点</legend>
		<form id="myform" action="add" method="post">
			<input type="hidden" id="bannerid" value="${banner.id }">
			<table cellpadding="3" cellspacing="0" class="edit_table" id="tbEditForm">
				<tr>
					<td class="edit_title"><tt>*</tt>热点标题：</td>
					<td><input type="text" name="title" id="title"
						style="width: 395px;height: 30px" maxlength="255"
						class="easyui-validatebox textbox textbox_indent"
						value="${banner.title}" /></td>
				</tr>
				<tr>
					<td class="edit_title">分类标识：</td>
					<td><input type="text" name="classtag" id="classtag"
						style="width: 395px;height: 30px" maxlength="255"
						class="easyui-validatebox textbox textbox_indent"
						value="${banner.classtag}" /></td>
				</tr>
				
				<tr>
					<td class="edit_title"><tt>*</tt>连接地址：</td>
					<td><input type="text" name="url" id="url"
						style="width: 395px;height: 30px" maxlength="255"
						class="easyui-validatebox textbox textbox_indent"
						value="${banner.url}" /></td>
				</tr>
				
				<tr>
					<td class="edit_title"><tt>*</tt>热点图片：</td>
					<td><input type="file" value="上传文件" id="uploadify2" width="78" style="display: none;" height="23" />
						<label id="txtTishi2" style="font-size: 12px"></label>
					</td>
					<td><input type="hidden" id="img" name="img" value="${banner.img}"></td>

				</tr>
				<tr>
					<td class="edit_title"></td>
					<td><img width="60px" height="40px" id="imgshow" src="${banner.img}"/></td>
				</tr>
				<tr>
					<td class="edit_title">热点描述：</td>
					<td>
					<textarea type="text" id="remark" name="remark" style="width: 99%;height: 60px; " maxlength="200">${banner.remark}</textarea>
					</td>
				</tr>
				
				<tr>
					<td class="edit_title"><tt>*</tt>是否发布：</td>
					<td>
						<select name="status" id="status" style="width: 200px;height: 30px;" class="easyui-validatebox textbox textbox_indent">
							<option value="1" <c:if test="${banner.status=='1' }"> selected="selected" </c:if> >是</option>
							<option value="0" <c:if test="${banner.status=='0' }"> selected="selected" </c:if> >否</option>
						</select>
					</td>
				</tr>
				
				<tr style="height: 50px;">
					<td colspan="2" style="text-align: right">
					<a id="bannerSaveBtn" class="easyui-linkbutton" data-options="iconCls:'icon-save'"
						href="javascript:" onclick="submitForm();">保存</a> 
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>