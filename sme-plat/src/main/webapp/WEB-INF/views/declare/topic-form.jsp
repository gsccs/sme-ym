<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目申报主题表单</title>
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
<link href="${pageContext.request.contextPath}/static/kindeditor/themes/default/default.css"
	rel="stylesheet" />
<script src="${pageContext.request.contextPath}/static/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/uploadify/swfobject.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/static/uploadify/uploadify.css" rel="stylesheet" type="text/css">
<style type="text/css">
.td_title {
	width: 130px;
	font-size: 14px;
}

.td_input {
	width: 130px;
	font-size: 14px;
}

#uploadifyUploader {
	visibility:hidden
}
</style>

</head>
<body>
<script type="text/javascript">
var ctx = "${pageContext.request.contextPath}";
$(function() {
	
	LoadEditor('textarea[name="content"]', 'editor');
	var attachs = new Array();
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
                    $("#filelist").append(""+attach.filename+"<br>");
            	}
                $("#txtTishi").html(result.msg);
            }
        }
    });
	
	$("#saveTopicBtn").click(function () {
		var id =$("#topicid").val();
		if (id != ""){
			url=ctx+"/declare/topic/edit";
		}else{
			url=ctx+"/declare/topic/add";
		}
		var title= $("#title").val();
		var starttime = $("#starttime").datebox('getValue');
		var endtime = $("#endtime").datebox('getValue');
		var condit = $("#condit").val();
		var decflow = $("#decflow").val();
		if (title==""){
			$.messager.show({
				title : '提示',
				msg : '项目申报标题内容不能为空！',
				timeout : 3000,
				showType : 'slide'
			});
			return;
		}
		
		if (starttime=="" || endtime==""){
			$.messager.show({
				title : '提示',
				msg : '项目申报起止时间不能为空！',
				timeout : 3000,
				showType : 'slide'
			});
			return false;
		}
		
		if (decflow==""){
			$.messager.show({
				title : '提示',
				msg : '项目申报流程不能为空！',
				timeout : 3000,
				showType : 'slide'
			});
			return false;
		}
        var txtName = editor.html();
        if (txtName==""){
			$.messager.show({
				title : '提示',
				msg : '项目申报内容不能为空！',
				timeout : 3000,
				showType : 'slide'
			});
			return false;
		}
        var postData = {
        	id:id,
            title: title,
            starttime:starttime,
            endtime:endtime,
            condit:$("#condit").val(),
        	decflow:$("#decflow").val(),
        	dectype:$("#dectype").val(),
            content: txtName,
            attachs:attachs
        };
        
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
            	window.location.href = ctx+"/declare/topic";
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

//附件删除
function delAttach(id){
	  $.ajax({
			url : ctx+'/decTopic/delete/attach',
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
	<fieldset>
		<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">申报项目发布</legend>
		<form id="topicform" action="add" method="post">
		<input type="hidden" id="topicid" name="id" value="${decTopic.id }" />
		<table class="tableForm" style="margin-top: 10px;">
			<tr class="thclass" style="height: 40px">
				<th class="td_title">主题名称<font style="color: red">*</font></th>
				<td><input type="text" id="title" name="title" style="width: 360px; height: 20px" class="textbox textbox_indent" value="${decTopic.title}" /></td>
			</tr>
			<tr class="thclass" style="height: 40px">
				<th class="td_title">时&nbsp;&nbsp;限<font style="color: red">*</font></th>
				<td><input style="width: 160px;" name="starttime"
					id="starttime"
					value='<c:if test="${empty(decTopic)}">
						new date()
					</c:if>
					${decTopic.starttimestr}'
					data-options="formatter:myformatter,parser:myparser"
					class="easyui-datebox" /> 
					～ 
					<input style="width: 160px;" id="endtime" name="endtime" value="${decTopic.endtimestr}"
					data-options="formatter:myformatter,parser:myparser"
					class="easyui-datebox" /></td>
			</tr>
			<tr>
				<th class="td_title">申报类型：<font style="color: red">*</font></th>
				<td>
					<select id="dectype" name="dectype" class="easyui-validatebox textbox textbox_indent">
						<c:forEach items="${dectypelist }" var="dectype">
							<option value="${dectype.id }" <c:if test="${decTopic.dectype == dectype.id }"> selected="selected" </c:if>>${dectype.title }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th class="td_title">申报条件：<font style="color: red">*</font></th>
				<td><textarea  name="condit" id="condit"
							class="textbox textbox_area textbox_indent"
							style="width: 99%; height: 100px; float: left;">${decTopic.condit}</textarea></td>
			</tr>
			<tr>
				<th class="td_title">申报流程：<font style="color: red">*</font></th>
				<td><textarea  name="decflow" id="decflow"
							class="textbox textbox_area textbox_indent"
							style="width: 99%; height: 100px; float: left;">${decTopic.decflow}</textarea></td>
			</tr>
			<tr>
				<th class="td_title">申报内容：<font style="color: red">*</font></th>
				<td><textarea  name="content" id="content"
							class="textbox textbox_area textbox_indent"
							style="width: 99%; height: 200px; float: left;">${decTopic.content}</textarea></td>
			</tr>
			<tr class="thclass" style="height: 40px">
				<th class="td_title">附件列表</th>
				<td><input type="file" value="上传文件"  id="uploadify" width="78" style="display: none;" height="23" /><label id="txtTishi" style="font-size:12px"></label>
					<ul id="filelist">
						<c:forEach items="${decTopic.attachs}" var="attach">
							<li id="${attach.id}" style="height:30px;list-style-type: none;"><label >${attach.filename}</label>&nbsp;&nbsp;<a name="${attach.id}" onclick="delAttach(this)" class="easyui-linkbutton">删除</a></li>
						</c:forEach>
					</ul>
				</td>
				<td><span id="fileQueue" style="float: right;" class="uploadifyQueue"></span></td>
			</tr>
			<tr style="height: 50px;">
					<td colspan="2" style="text-align: right">
					<a id="saveTopicBtn"
						class="easyui-linkbutton" data-options="iconCls:'icon-add'"
						href="javascript:" >确认发布</a> 
					<a id="btnBack" class="easyui-linkbutton" data-options="iconCls:'icon-back'"
						href="javascript:" onclick="BackIndex()">返回</a>
			</tr>
		</table>
	</form>
</fieldset>
</body>
</html>
