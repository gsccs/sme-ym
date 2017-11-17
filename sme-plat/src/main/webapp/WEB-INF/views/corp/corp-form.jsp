<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业表单</title>
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
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/uploadify/jquery.uploadify.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/uploadify/swfobject.js"
	charset="utf-8"></script>
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
	function BackIndex() {
		self.location = "${pageContext.request.contextPath}/park";
	}

	$(function() {
		LoadEditor('#content', 'editor');
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
	                    //$("#filelist").append(""+attach.filename+"<br>");
	                    $("#corplogo").attr("src",attach.filepath);
	                    $("#logo").val(attach.filepath);
	            	}
	                //$("#txtTishi").html(result.msg);
	            }
	        }
	    });
		
		$("#btn_save").click(function () {
			if (!$("#corpform").form('validate')) {
				console.log("valid","false");
				return false;
			}
			
	        var postData = {
	        	id:id,
	            title:$("#title").val(),
	            parkid:$("#svgid").val(),
	            phone:$("#phone").val(),
	            //regtime:$("#regtime").datebox('getValue'),
	            address:$("#address").val(),
	            content: editor.html(),
	            logo:$("#parklogo").attr("src")
	        };
	        
	        $("#hide_content").val(editor.html());
	        $.ajax({  
	            type: "POST",  
	            url: ctx+"/corp/save",
	            data:$("#corpform").serialize(),
	            //data: JSON.stringify(postData),//将对象序列化成JSON字符串  
	            dataType:"json",  
	            //contentType : 'application/json;charset=utf-8', //设置请求头信息  
	            success: function(res){
	            	$.messager.show({
	    				title : '友情提示',
	    				msg : res.msg,
	    				timeout : 3000,
	    				showType : 'slide'
	    			});
	            	window.location.href = ctx+"/corp";
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
		<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">企业信息</legend>
		<form id="corpform"  method="post">
			<input type="hidden" id="id" name="id" value="${corp.id}" />
			<input type="hidden" id="hide_content" name="content" value="" />
			<table cellpadding="3" cellspacing="0" class="edit_table" id="tbEditForm">
				<tr>
					<td class="edit_title"><tt>*</tt>企业名称：</td>
					<td><input type="text" name="title"  id="title"
						style="width: 395px;" maxlength="200"
						data-options="required:true,validType:'NULL'"
						class="easyui-validatebox textbox textbox_indent" value="${corp.title }" /></td>
						
					<td rowspan="4">
					<input type="hidden" id="logo" name="logo" value="${corp.logo }">
					<img id="corplogo" alt="" src="${corp.logo }" width="100" height="100">
					<input type="file" value="上传文件" id="uploadify" width="78" style="display: none;" height="23" />
					</td>
				</tr>
				
				<tr>
					<td class="edit_title"><tt>*</tt>所在园区：</td>
					<td colspan="2">
						<select id="parkid" name="parkid" class=" textbox textbox_indent" style="height: 25px;width: 120px;">
							<c:forEach items="${parklist }" var="park">
							<option value="${park.id }" <c:if test="${park.id== corp.parkid }">   selected="selected" </c:if>>${park.title }</option>
							</c:forEach>
						</select>					
					</td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>联系人：</td>
					<td><input type="text" id="linker" name="linker"
						class="easyui-validatebox textbox textbox_indent"
						style="width: 130px;" maxlength="20"
						value="${corp.linker }" />
					</td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>联系电话：</td>
					<td colspan="2"><input type="text" id="phone" name="phone"
						class="easyui-validatebox textbox textbox_indent"
						style="width: 130px;" maxlength="20"
						data-options="validType:'length[1,20]'" value="${corp.phone }" />
					</td>
				</tr>
				
				<tr>
					<td class="edit_title"><tt>*</tt>地址：</td>
					<td colspan="2"><input type="text" name="address"  id="address"
						style="width: 395px;" maxlength="512"
						data-options="validType:'NULL'"
						class="easyui-validatebox textbox textbox_indent" value="${corp.address}" /></td>
				</tr>
				
				<tr>
					<td class="edit_title" style="vertical-align: top;">企业网站：</td>
					<td colspan="2"><input type="text" name="domain"  id="domain"
						style="width: 395px;" maxlength="512"
						class="easyui-validatebox textbox textbox_indent" value="${corp.domain}" /></td>
				</tr>
				

				<tr>
					<td class="edit_title" style="vertical-align: top;">企业简介：</td>
					<td colspan="2">
					<textarea id="content"
							class="textbox textbox_area textbox_indent"
							style="width: 99%; height: 200px; float: left;" >${corp.content }</textarea></td>
				</tr>
				
				<tr>
					<td class="edit_title"><tt>*</tt>企业状态：</td>
					<td colspan="2">
						<select id="status" name="status" class=" textbox textbox_indent" style="height: 25px;width: 120px;">
							<option value="1" <c:if test="${'1'== corp.status }">   selected="selected" </c:if>>正常</option>
							<option value="0" <c:if test="${'0'== corp.status }">   selected="selected" </c:if>>禁用</option>
						</select>					
					</td>
				</tr>
				
				<tr style="height: 50px;">
					<td colspan="2" style="text-align: right">
					<a id="btn_save" class="easyui-linkbutton" data-options="iconCls:'icon-save'" href="javascript:">保存</a> 
					<a id="btn_back" class="easyui-linkbutton" data-options="iconCls:'icon-back'" href="javascript:" onclick="BackIndex()">返回</a>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>
