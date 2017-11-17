<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>信息表单</title>
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
		$("#uploadify").uploadify({
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
	            	var result = eval("(" + response + ")");
	            	console.log("attach:",result);
	            	if (result.success){
	            		var attach = result.data;
	                    attachs.push(attach);
	                    $("#filelist").append("<li id='attach_"+attach.id+"' style='padding:5px;list-style-type: none;'>"+attach.filename+"[<a href='javascript:void(0)' onclick=delAttachClient('"+attach.id+"')>删除</a>]</li>");
	            	}
	            }
			}
		});

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

		$('#channelid').combotree({
			url : ctx + '/channel/tree',
			required : true,
			valueField : 'id',
			textField : 'title',
			method : 'post'
		});

		$("#infoSaveBtn").click(function() {
			var content = editor.html();
			var infoid = $("#infoid").val();
			var postData = {
				id : infoid,
				title : $("#infotitle").val(),
				img : $("#img").val(),
				remark : $("#remark").val(),
				content : content,
				addtime : $("#addtime").val(),
				channelid : $("#channelid").combobox('getValue'),
				status : $("#status").val(),
				attachs:attachs
			};
			console.log("postData",postData);
			var posturl = ctx + "/info/add";
			if (infoid != '') {
				posturl = ctx + "/info/edit";
			}
			
			$.ajax({  
	            type: "POST",  
	            url: posturl,  
	            data: JSON.stringify(postData),//将对象序列化成JSON字符串  
	            dataType:"json",  
	            contentType : 'application/json;charset=utf-8', //设置请求头信息  
	            success: function(res){
	            	$.messager.show({
	    				title : '友情提示',
	    				msg : res.msg,
	    				timeout : 3000,
	    				showType : 'slide'
	    			});
	            	window.location.href = ctx+"/info";
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
	
	function delAttachClient(attachid){
		if (attachs){
			for(var i=0;i<attachs.length;i++){
				var attach = attachs[i];
				var attach_id = attach.id;
				if (attach_id==attachid){
					attachs.splice(i,1);
					console.log(attachs);
					$("#attach_"+attach_id).remove();
					break;
				}
			}
		}
	}

	//附件删除
	function delAttachByServer(attachid){
		if (!attachid){
			return;
		}
		$.ajax({
			url : ctx+'/appeal/attach/delete?attachid='+attachid,
			type : 'post',
			dataType : 'json',
			success : function(json) {
				if (json.success) {
					$("#attach_"+attachid).remove(); 
				}else{
					alert(json.msg);
				}
			}
	    });  
	}
</script>
</head>
<body style="margin: 10px; padding: 0px; background-color: #fff;">
	<fieldset>
		<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">信息发布</legend>
		<form id="myform" action="add" method="post">
			<input type="hidden" id="infoid" value="${info.id }">
			<table cellpadding="3" cellspacing="0" class="edit_table" id="tbEditForm">
				<tr>
					<td class="edit_title"><tt>*</tt>信息标题：</td>
					<td><input type="text" name="title" id="infotitle"
						style="width: 395px;height: 30px" maxlength="255"
						class="easyui-validatebox textbox textbox_indent"
						value="${info.title}" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>信息来源：</td>
					<td><input type="text" name="source" id="source"
						style="width: 395px;height: 30px" maxlength="255"
						class="easyui-validatebox textbox textbox_indent"
						value="${info.source}" /></td>
				</tr>

				<tr>
					<td class="edit_title"><tt>*</tt>信息发布人：</td>
					<td><input type="text" id="author" name="author" style="width: 395px;height: 30px"
						maxlength="50" class="easyui-validatebox textbox textbox_indent"
						value="${user.title}" /></td>
				</tr>

				<tr>
					<td class="edit_title"><tt>*</tt>所属栏目：</td>
					<td><input type="text" id="channelid" name="channelid"
						required="true" missingMessage="栏目不能为空" value="${info.channelid }">
					</td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>发布时间：</td>
					<td><input id="addtime" name="addtime" style="width: 130px;"
						class="easyui-datetimebox" value="new Date()"
						data-options="required:true,formatter:myformatter,parser:myparser" />
					</td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>信息图片：</td>
					<td><input type="file" value="上传文件" id="uploadify2" width="78" style="display: none;" height="23" />
						<label id="txtTishi2" style="font-size: 12px"></label>
					</td>
					<td><input type="hidden" id="img" name="img" value="${info.img}"></td>

				</tr>
				<tr>
					<td class="edit_title"></td>
					<td><img width="60px" height="60px" id="imgshow" src="${info.img}" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>信息摘要：</td>
					<td>
					<textarea type="text" id="remark" name="remark" style="width: 99%;height: 60px; " maxlength="200">${info.remark}</textarea>
					</td>
				</tr>
				<tr>
					<td class="edit_title" style="vertical-align: top;"><tt>*</tt>信息内容：</td>
					<td><textarea name="content"
							class="textbox textbox_area textbox_indent"
							style="width: 99%; height: 400px; float: left;">${info.content}</textarea></td>
				</tr>

				<tr class="thclass" style="height: 40px">
					<th style="width: 130px; font-size: 14px;">附件列表</th>
					<td><input type="file" value="上传文件" name="uploadify"
						id="uploadify" width="78" style="display: none;" height="23" /></td>
				</tr>
				<tr class="thclass" style="height: 40px">
					<th style="width: 130px; font-size: 14px;"></th>
					<td>
					<ul id="filelist" style="  padding-left: 0px;">
						<c:forEach items="${info.attachs}" var="attach">
							<li id="attach_${attach.id}" style="padding:5px;list-style-type: none;">${attach.filename}&nbsp;&nbsp;[<a href='javascript:void(0)' onclick="delAttachByServer('${attach.id}')" >删除</a>]</li>
						</c:forEach>
					</ul>							
					</td>
				</tr>
				
				<tr class="thclass" style="height: 40px">
					<th style="width: 130px; font-size: 14px;">信息状态</th>
					<td>
						<select name="status" id="status" class=" textbox textbox_indent">
							<option value="0" <c:if test="${info.status=='0'}" >selected="selected"</c:if>>保存草稿</option>
							<option value="1" <c:if test="${info.status=='1'}" >selected="selected"</c:if>>立即发布</option>
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