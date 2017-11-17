<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>行政事项申请表单</title>
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
<style type="text/css">

</style>
<script type="text/javascript">
var ctx="${pageContext.request.contextPath}";
var attachs = new Array();
$(function() {
	$("#uploadify").uploadify({
	    'uploader': ctx+'/static/uploadify/uploadify.swf',
	    'script': ctx+'/uploadfile',
	    'cancelImg': ctx+'/static/uploadify/cancel.png',
	    'folder': 'UploadFile',
	    'queueID': 'fileQueue',
	    'auto': true,
	    'multi': false,
	    'buttonImg': ctx+'/static/uploadify/uploadify.png',
	    'width': 78,
	    'height': 23,
	    'onComplete': function (event, UserID, fileObj, response, data) {
	    	console.log("response:",response);
	        if (response != null) {
	        	var result = eval("(" + response + ")");
	        	if (result.success){
	        		var attach = result.data;
	                attachs.push(attach);
	                $("#filelist").append("<li id='attach_"+attach.id+"' style='padding:5px;list-style-type: none;'>"+attach.filename+"[<a href='javascript:void(0)' onclick=delAttachClient('"+attach.id+"')>删除</a>]</li>");
	                $("#attachmsg").html("上传成功！");
	        	}else{
	        		$("#attachmsg").html("上传失败.失败原因:"+result.msg);
	        	}
	        }
	    }
	});
});


//保存
function saveAttendResult(){
	var itemid = $("#itemid").val();
	var result = $('input[name="appeal_result"]:checked').val();
	var remark = $("#remark").val();
	var postData = {
		id:itemid,
		result: result,
		resultstr:remark,
		attachs:attachs
    };
	$.ajax({  
        type: "POST",  
        url: ctx+"/appeal/item/attend",  
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
        	window.location.href = ctx+"/appeal/item/";
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
        
}


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
<body>
<div class="easyui-layout" fit="true" border="false">
	<div data-options="region:'center',split:false">
		<div class="easyui-layout" fit="true" border="false">
			<div data-options="region:'west',title:''" style="width: 70%">
				<fieldset style="">
				<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">事项受理</legend>
				<input type="hidden" id="itemid" name="itemid" value="${appealItem.id}" />
				<table class="tableForm" style="margin-top: 10px;">
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">申请企业</th>
						<td>${appealItem.corptitle}</td>
					</tr>
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">事项名称</th>
						<td>${appealItem.topictitle}</td>
					</tr>
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">事项描述</th>
						<td style="width: 530px;">${appealItem.content}</td>
					</tr>
					
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">提交日期</th>
						<td>${appealItem.addtimestr}</td>
					</tr>
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">附件列表</th>
						<td>
						<ul>
						<c:forEach items="${appealItem.attachs}" var="attach">
							<li id="${attach.id}" style="height: 30px; list-style-type: none;"><label>${attach.filename}</label>&nbsp;&nbsp;
							[<a name="${attach.id}" href="${attach.filepath}" >下载</a>]</li>
						</c:forEach>
						</ul>											
						</td>
					</tr>
					
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">是否同意</th>
						<td><input type="radio" name="appeal_result" value="1" checked="checked">同意
							<input type="radio" name="appeal_result" value="0">驳回
						 </td>
					</tr>
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">结果描述</th>
						<td><textarea name="remark" id="remark" 
								class=" textbox_area textbox_indent"
								style="width: 99%; height: 120px; float: left;"></textarea></td>
					</tr>
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">上传附件</th>
						<td><input type="file" value="上传文件" name="uploadify" id="uploadify" width="78" height="23" /><span id="attachmsg"></span></td>
					</tr>
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;"></th>
						<td>
							<ul id="filelist" style="  padding-left: 0px;">
								
							</ul>
						</td>
					</tr>
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;"></th>
						<td><input type="button" value="提交" onclick="saveAttendResult();" style="width: 150px;height: 30px;"></td>
					</tr>
				</table>
				</fieldset>
			</div>
			<div data-options="region:'east'" style="width:30%;">
				<table id="trace_data" cellspacing="0" cellpadding="0" style="width: 100%">
					<thead style="background-color: #e4e4e7;">
					<tr>
						<th style="font-size: 16px;height: 30px;line-height: 30px; width: 60%;text-align: left;" >事项记录：</th>
						<th style="font-size: 16px;height: 30px;line-height: 30px; " >&nbsp;</th>
					</tr>
					</thead>
					<c:forEach items="${tracelist }" var="trace">
					<tr class="thclass">
						<td style="padding: 5px;font-size: 14px;">${trace.svgtitle }${trace.corptitle }</td>
						<td style="padding: 5px;font-size: 14px;">${trace.addtimestr }</td>
					</tr>
					<tr><td colspan="2" style="padding: 5px; padding-bottom:10px; font-size: 14px;border-bottom: 1px dotted skyblue ">${trace.content }</td></tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>

</body>
</html>
