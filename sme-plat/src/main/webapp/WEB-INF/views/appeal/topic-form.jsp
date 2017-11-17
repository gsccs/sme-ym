<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>行政诉求主题表单</title>
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
<script src="${pageContext.request.contextPath}/static/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/uploadify/swfobject.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/static/uploadify/uploadify.css" rel="stylesheet" type="text/css" />
<style type="text/css">
th {
	width: 130px;
	font-size: 14px;
}
</style>

</head>
<body>
<script type="text/javascript">
var ctx="${pageContext.request.contextPath}";
var attachs = new Array();
$(function() {
	var scode = $("#scode_").val();
	LoadEditor('textarea[name="workflow"]', 'editor');
	$.post(ctx+"/gclass/list", { pid: 0 }, function (data) {
    	console.log("sclassList",data);
        var htmlstr = "<option value=\"\">--请选择一级类--</option>";
        for (var i = 0; i < data.length; i++) {
        	if (scode ==data[i].id){
        		htmlstr += "<option value='" + data[i].id + "' selected>" + data[i].title + "</option>";
        	}else{
            	htmlstr += "<option value='" + data[i].id + "'>" + data[i].title + "</option>";
        	}
        }
        $("#scode").html(htmlstr);
    });
	
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
            	}
            }
        }
    });
	
	$("#saveTopicBtn").click(function () {
		var id =$("#topicid").val();
		if (id != ""){
			url=ctx+"/appeal/topic/edit";
		}else{
			url=ctx+"/appeal/topic/add";
		}
		var title= $("#title").val();
		if (title==""){
			$.messager.show({
				title : '提示',
				msg : '诉求标题内容不能为空！',
				timeout : 3000,
				showType : 'slide'
			});
			return;
		}
        var txtName = editor.html();
        if (txtName==""){
			$.messager.show({
				title : '提示',
				msg : '诉求内容不能为空！',
				timeout : 3000,
				showType : 'slide'
			});
			return false;
		}
        var postData = {
        	id:id,
            title: $("#title").val(),
            scode:$("#scode").val(),
            //subscode:$("#subscode").val(),
            remark:$("#remark").val(),
            daynum:$("#daynum").val(),
            status:$("#status").val(),
            starobj: $("#starobj").val(),
            scondit: $("#scondit").val(),
            sbasis:$("#sbasis").val(),
            swindow: $("#swindow").val(),
            workflow: txtName,
            attachs:attachs
        };
        
        console.log("postData",postData);
        
        $.ajax({  
            type: "POST",  
            url: url,  
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
            	window.location.href = ctx+"/appeal/topic";
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

<fieldset>
	<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">行政事项发布</legend>
	<form id="topicform" method="post">
		<input type="hidden" id="topicid" name="id" value="${appealTopic.id}" />
		<input type="hidden" id="svgid" name="id" value="${appealTopic.svgid}" />
		<input type="hidden" id="scode_" name="scode_" value="${appealTopic.scode}" />
		<input type="hidden" id="subscode_" name="subscode_" value="${appealTopic.subscode}" />
		<table class="tableForm" style="margin-top: 10px;">
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">事项名称<font style="color: red">*</font></th>
				<td><input type="text" name="title" id="title"
					style="width: 300px; height: 30px" class="textbox textbox_indent"
					value="${appealTopic.title}" /></td>
			</tr>
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">服务分类<font style="color: red">*</font></th>
				<td>
					<select id="scode" name="scode">
						<c:forEach items="${sclassList }" var="sclass">
							<option value="${sclass.id }" <c:if test="${sclass.id==appealTopic.scode }"> selected="selected"</c:if> >${sclass.title }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">事项描述<font
					style="color: red">*</font></th>
				<td><textarea name="remark" id="remark"
							class="textbox textbox_area textbox_indent"
							style="width: 99%; height: 120px; float: left;">${appealTopic.remark}</textarea></td>
			</tr>
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">服务对象<font
					style="color: red">*</font></th>
				<td><textarea name="starobj" id="starobj"
							class="textbox textbox_area textbox_indent"
							style="width: 99%; height: 120px; float: left;">${appealTopic.starobj}</textarea></td>
			</tr>
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">办理条件<font
					style="color: red">*</font></th>
				<td><textarea name="scondit" id="scondit"
							class=" textbox_area textbox_indent"
							style="width: 99%; height: 120px; float: left;" placeholder="办理条件">${appealTopic.scondit}</textarea></td>
			</tr>
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">办事窗口<font
					style="color: red">*</font></th>
				<td><textarea name="swindow" id="swindow"
							class=" textbox_area textbox_indent"
							style="width: 99%; height: 70px; float: left;">${appealTopic.swindow}</textarea></td>
			</tr>
			
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">法定依据<font
					style="color: red">*</font></th>
				<td><textarea name="sbasis" id="sbasis"
							class=" textbox_area textbox_indent"
							style="width: 99%; height: 120px; float: left;">${appealTopic.sbasis}</textarea></td>
			</tr>
			
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">办事流程<font
					style="color: red">*</font></th>
				<td><textarea name="workflow" id="workflow"
							class="textbox textbox_area textbox_indent"
							style="width: 99%; height: 200px; float: left;">${appealTopic.workflow}</textarea></td>
			</tr>
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">办理时限<font
					style="color: red">*</font></th>
				<td><input type="text" name="daynum" id="daynum"
					style="width: 60px; height: 30px" class="textbox textbox_indent"
					value="${appealTopic.daynum==null?3:appealTopic.daynum}" />（工作日）</td>
			</tr>
			
			
			
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">业务状态</th>
				<td>
					<select id="status" name="status">
						<option value="1" <c:if test="${appealTopic.status=='1' }"> selected="selected" </c:if>>业务开放</option>
						<option value="0" <c:if test="${appealTopic.status=='0' }"> selected="selected" </c:if>>业务关闭</option>
					</select>
				</td>
			</tr>
			
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;">附件列表</th>
				<td><input type="file" value="上传文件" name="uploadify" id="uploadify" width="78" style="display: none;" height="23" /></td>
			</tr>
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;"></th>
				<td>
					<ul id="filelist" style="  padding-left: 0px;">
						<c:forEach items="${appealTopic.attachs}" var="attach">
							<li id="attach_${attach.id}" style="padding:5px;list-style-type: none;">${attach.filename}&nbsp;&nbsp;[<a href='javascript:void(0)' onclick="delAttachByServer('${attach.id}')" >删除</a>]</li>
						</c:forEach>
					</ul>
				</td>
			</tr>
			<tr class="thclass" style="height: 40px">
				<th style="width: 130px; font-size: 14px;"></th>
				<td><input type="button" value="保存" id="saveTopicBtn" style="width: 130px;height: 40px;"/></td>
			</tr>
		</table>
	</form>
</fieldset>
	
</body>
</html>
