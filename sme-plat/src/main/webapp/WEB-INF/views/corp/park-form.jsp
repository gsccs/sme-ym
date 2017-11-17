<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>园区编辑表单</title>
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
	                    //$("#filelist").append(""+attach.filename+"<br>");
	                    $("#parklogo").attr("src",attach.filepath);
	            	}
	                //$("#txtTishi").html(result.msg);
	            }
	        }
	    });
		
		$("#parkAddBtn").click(function () {
			if (!$("#myform").form('validate')) {
				console.log("valid","false");
				//return false;
			}
			var id =$("#parkid").val();
			//var status = $('#myform input[name="status"]:checked').val();
			//console.log("status",status);
			
			if (id != ""){
				url=ctx+"/park/edit";
			}else{
				url=ctx+"/park/add";
			}
			
	        var postData = {
	        	id:id,
	            title:$("#title").val(),
	            svgid:$("#svgid").val(),
	            phone:$("#phone").val(),
	            //regtime:$("#regtime").datebox('getValue'),
	            address:$("#address").val(),
	            content: editor.html(),
	            logo:$("#parklogo").attr("src")
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
	            	window.location.href = ctx+"/park";
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
		<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">园区编辑</legend>
		<form id="myform" action="${park==null?'add':'edit'}" method="post">
		<input type="hidden" id="parkid" name="id" value="${park.id}" />
			<table cellpadding="3" cellspacing="0" class="edit_table" id="tbEditForm">
				<tr>
					<td class="edit_title"><tt>*</tt><span
						style="letter-spacing: 2em">标</span>题：</td>
					<td><input type="text" name="title"  id="title"
						style="width: 395px;" maxlength="200"
						data-options="required:true,validType:'NULL'"
						class="easyui-validatebox textbox textbox_indent" value="${park.title }" /></td>
				</tr>
				
				<tr>
					<td class="edit_title"><tt>*</tt>管委会：</td>
					<td>
						<select id="svgid" class=" textbox textbox_indent" style="height: 25px;width: 120px;">
							<c:forEach items="${svorgList }" var="svg">
							<option value="${svg.id }" <c:if test="${sclass.id== park.svgid }">   selected="selected" </c:if>>${svg.title }</option>
							</c:forEach>
						</select>					
					</td>
				</tr>
				
				
				
				<tr>
					<td class="edit_title"><tt>*</tt>联系电话：</td>
					<td><input type="text" id="phone" name="phone"
						class="easyui-validatebox textbox textbox_indent"
						style="width: 130px;" maxlength="20"
						data-options="validType:'length[1,20]'" value="${park.phone }" />
					</td>
				</tr>
				
				<tr>
					<td class="edit_title"><tt>*</tt>园区地址：</td>
					<td><input type="text" name="address"  id="address"
						style="width: 395px;" maxlength="512"
						data-options="validType:'NULL'"
						class="easyui-validatebox textbox textbox_indent" value="${park.address}" /></td>
				</tr>

				<tr>
					<td class="edit_title" style="vertical-align: top;">园区简介：</td>
					<td><textarea name="content" id="content"
							class="textbox textbox_area textbox_indent"
							style="width: 99%; height: 200px; float: left;" >${park.content }</textarea></td>
				</tr>
				<tr>
					<td class="edit_title">园区图片：</td>
					<td>
					<img id="parklogo" alt="" src="${park.logo }" width="100" height="100">
					<input type="file" value="上传文件" id="uploadify" width="78" style="display: none;" height="23" />
					</td>
				</tr>
				
				
				<tr style="height: 50px;">
					<td colspan="2" style="text-align: right">
					<a id="parkAddBtn" class="easyui-linkbutton" data-options="iconCls:'icon-save'" href="javascript:">保存</a> 
					<a id="btnBack" class="easyui-linkbutton" data-options="iconCls:'icon-back'" href="javascript:" onclick="BackIndex()">返回</a>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>
