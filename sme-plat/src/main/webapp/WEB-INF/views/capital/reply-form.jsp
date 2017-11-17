<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>融资申请回复表单</title>
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
	src="${pageContext.request.contextPath}/static/js/Common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/uploadify/jquery.uploadify.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/uploadify/swfobject.js"
	charset="utf-8"></script>
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";

	$(function() {
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
		
		$("#applAddBtn").click(function () {
			var content = $("#content").val();
			var linktel = $("#linktel").val();
			var linker = $("#linker").val();
			if (content==""){
				$("#content").focus();
				$.messager.show({
    				title : '友情提示',
    				msg : "回复内容不能为空",
    				timeout : 3000,
    				showType : 'slide'
    			});
			}
			
			if (linktel==""){
				$("#linktel").focus();
				$.messager.show({
    				title : '友情提示',
    				msg : "请填写联系电话",
    				timeout : 3000,
    				showType : 'slide'
    			});
			}
			
			if (linker==""){
				$("#linker").focus();
				$.messager.show({
    				title : '友情提示',
    				msg : "请填写联系信息",
    				timeout : 3000,
    				showType : 'slide'
    			});
			}
			var id =$("#id").val();
			url=ctx+"/capital/reply";
			
	        var postData = {
	        	id:id,
	            applid:$("#applid").val(),
	            linktel:$("#linktel").val(),
	            linker:$("#linker").val(),
	            content: $("#content").val()
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
	            	window.location.href = ctx+"/capital/appls";
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
		<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">企业融资申请</legend>
		<form id="myform" method="post">
			<input type="hidden" id="id" name="id" value="${reply.id}" />
			<input type="hidden" id="applid" name="id" value="${appl.id}" />
			<table cellpadding="3" cellspacing="0" class="edit_table" style="width: 80%;">
				<tr>
					<td class="edit_title">申请企业：</td>
					<td>${corp.title }</td>
					<td class="edit_title">注册资金：</td>
					<td>${corp.title }</td>
				</tr>
				<tr>
					<td class="edit_title">企业法人：</td>
					<td>${corp.legaler }</td>
					<td class="edit_title">联系电话：</td>
					<td>${corp.linktel }</td>
				</tr>
				<tr>
					<td class="edit_title">融资金额：</td>
					<td>${appl.loan }  万元</td>
					<td class="edit_title">融资期限：</td>
					<td>${appl.month } 月
					</td>
				</tr>
				<tr>
					<td class="edit_title">资金用途：</td>
					<td colspan="3"><textarea 
							class="textbox textbox_area textbox_indent"
							style="width: 80%; height: 120px; float: left;" readonly="readonly">${appl.usefor }</textarea></td>
				</tr>
				
				<tr>
					<td class="edit_title" style="vertical-align: top;">回复内容：</td>
					<td colspan="3"><textarea name="content" id="content"
							class="textbox textbox_area textbox_indent"
							style="width: 80%; height: 120px; float: left;" ></textarea></td>
				</tr>
				
				<tr>
					<td class="edit_title">联系人：</td>
					<td><input type="text" id="linker" name="linker"
						class="easyui-validatebox textbox textbox_indent"
						style="width: 100px;"
						data-options=" validType:'maxLength[50]'" value="${user.title }" />
					</td>
					<td class="edit_title">联系电话：</td>
					<td><input type="text" id="linktel" name="linktel"
						class="easyui-validatebox textbox textbox_indent"
						style="width: 130px;" maxlength="20"
						data-options="validType:'length[1,20]'" value="${user.phone }" /></td>
				</tr>
				
				<tr style="height: 50px;">
					<td colspan="3" style="text-align: center">
					<a id="applAddBtn" class="easyui-linkbutton" data-options="iconCls:'icon-add'" href="javascript:">保存</a> 
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>
