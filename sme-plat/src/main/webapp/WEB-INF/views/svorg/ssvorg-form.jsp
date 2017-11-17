<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
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
	src="${pageContext.request.contextPath}/static/uploadify/jquery.uploadify.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/uploadify/swfobject.js"
	charset="utf-8"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/kindeditor/kindeditor-all-min.js"></script>
<link
	href="${pageContext.request.contextPath}/static/kindeditor/themes/default/default.css"
	rel="stylesheet" />
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
	//加载服务分类（小类）
	function loadSubclass() {
	    var Superclassid = $("#scode").val();
	    $.post(ctx+"/sclass/list", { pid: Superclassid }, function (data) {
	    	var htmlstr = "";
            for (var i = 0; i < data.length; i++) {
                htmlstr += "<option value=\"" + data[i].id + "\">" + data[i].title + "</option>";
            }
            $("#subscode").html(htmlstr);
	    });
	}
	
	function submit() {
		var title = $("#title").val();
		if (title==""){
			$("#title").focus();
			return;
		}
		var postData = {
			id:$("#id").val(),
			title:$("#title").val(),
			logo:$("#logo").val(),
			svgtype:"S",
			linker:$("#linker").val(),
			linktel:$("#linktel").val(),
			address:$("#address").val(),
			domain:$("#domain").val(),
			scode:$("#scode").val(),
			regasset:$("#regasset").val(),
			orgcode:$("#orgcode").val(),
			content:editor.html()
		};
		console.log(postData);
		$.ajax({  
	        type: "POST",  
	        url: ctx+"/svorg/save",  
	        data: JSON.stringify(postData),
	        dataType:"json",  
	        contentType : 'application/json;charset=utf-8', //设置请求头信息  
	        success: function(res){
	        	$.messager.show({
					title : '友情提示',
					msg : res.msg,
					timeout : 3000,
					showType : 'slide'
				});
	        	window.location.href = ctx+"/svorg/slist/";
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
	function BackIndex() {
		self.location = ctx+"/svorg/slist";
	}
</script>
</head>
<body style="margin: 10px; padding: 0px; background-color: #fff;">
	<script type="text/javascript">
		$(function() {
			//loadSubclass();
			LoadEditor('textarea[name="content"]', 'editor');
			$("#uploadify")
					.uploadify(
							{
								'uploader' : '${pageContext.request.contextPath}/static/uploadify/uploadify.swf',
								'script' : '${pageContext.request.contextPath}/uploadfile',
								'cancelImg' : '${pageContext.request.contextPath}/static/uploadify/cancel.png',
								'folder' : 'UploadFile',
								'queueID' : 'fileQueue',
								'auto' : true,
								'multi' : false,
								'buttonImg' : '${pageContext.request.contextPath}/static/uploadify/uploadify.png',
								'width' : 78,
								'height' : 23,
								'onComplete' : function(event, UserID, fileObj,
										response, data) {
									if (response != null) {
										$("#txtTishi").html("附件上传成功");
										var json_data = eval("(" + response
												+ ")");
										$("#logo").val(json_data.data.filepath);
									}
								}
							});
		});
	</script>
	<fieldset>
		<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">服务机构注册</legend>
		<form id="myform" action="${pageContext.request.contextPath}/svorg/save" method="post">
			<input type="hidden" id="id" name="id" value="${svorgT.id}">
			<input type="hidden" name="svgtype" id="svgtype" value="S" />
			<table cellpadding="3" cellspacing="0" class="edit_table"
				id="tbEditForm">
				<tr>
					<td class="edit_title"><tt>*</tt>机构名称：</td>
					<td><input type="text" id="title" name="title" value="${svorgT.title}"
						style="width: 395px;" maxlength="200" data-options="required:true,validType:'NULL'"
						class="easyui-validatebox textbox textbox_indent" /></td>
					<td rowspan="4">
						<img alt="" src="${svorgT.logo }" width="100px" height="100px">
						<input type="file" value="上传文件" id="uploadify" width="78"
							style="display: none;" height="23" />
						<label id="txtTishi" style="font-size: 12px"></label></td>
						<input type="hidden" id="logo" name="logo" value="${svorgT.logo }">
				</tr>
				
				<tr>
					<td class="edit_title"><tt>*</tt>机构法人：</td>
					<td><input type="text" id="legaler" name="legaler" value="${svorgT.legaler}"
						style="width: 150px;" maxlength="10"
						class="easyui-validatebox textbox textbox_indent" /></td>
					<td></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>联系人：</td>
					<td><input type="text" id="linker" name="linker" value="${svorgT.linker}"
						style="width: 300px;" maxlength="10"
						class="easyui-validatebox textbox textbox_indent" /></td>
					<td></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>联系电话：</td>
					<td><input type="text" id="linktel" name="linktel" value="${svorgT.linktel}"
						style="width: 300px;" maxlength="15"
						class="easyui-validatebox textbox textbox_indent" /></td>
					<td></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>服务分类：</td>
					<td><select name="scode" id="scode" onchange="loadSubclass();"
						style="width: 190px;">
							<option value="">----请选择----</option>
							<c:forEach items="${listSclass}" var="listSclass">
								<c:choose>
									<c:when test="${listSclass.id==svorgT.scode}">
										<option value="${listSclass.id}" selected="selected">${svorgT.sclassstr}</option>
									</c:when>
									<c:otherwise>
										<option value="${listSclass.id}">${listSclass.title}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select> 
					<select name="subscode" id="subscode" style="width: 190px;">
						<option value="">---请选择分类----</option>
					</select>
					</td>
					<td></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>机构代码：</td>
					<td><input type="text" name="orgcode" id="orgcode" 
						value="${svorgT.orgcode}" style="width: 200px;"
						maxlength="50" class="easyui-validatebox textbox textbox_indent" /></td>
					<td></td>
				</tr>
				
				<tr>
					<td class="edit_title"><tt>*</tt>注册资本：</td>
					<td><input type="text" id="regasset" name="regasset"
						value="${svorgT.regasset}" style="width: 200px;" maxlength="10"
						class="easyui-validatebox textbox textbox_indent" /> </td>
					<td></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>详细地址：</td>
					<td colspan="2"><input type="text" id="address" name="address"
						value="${svorgT.address}" style="width: 300px;" maxlength="200"
						class="easyui-validatebox textbox textbox_indent" /></td>
				</tr>
				
				
				<tr>
					<td class="edit_title" style="vertical-align: top;">企业简介：</td>
					<td colspan="2">
					<textarea name="content" id="content"
							class="textbox textbox_area textbox_indent"
							style="width: 99%; height: 200px; float: left;">${svorgT.content}</textarea></td>
				</tr>

				<tr style="height: 50px;">
					<td colspan="2" style="text-align: right">
					<a id="btnAdd"
						class="easyui-linkbutton" data-options="iconCls:'icon-add'"
						href="javascript:" onclick="submit()">保存</a> <a id="btnBack"
						class="easyui-linkbutton" data-options="iconCls:'icon-back'"
						href="javascript:" onclick="BackIndex()">返回</a>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>
