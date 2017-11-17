<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新增报表</title>
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
th {
	width: 130px;
	font-size: 14px;
}
</style>

</head>
<body>
	<script type="text/javascript">
		var ctx = "${pageContext.request.contextPath}";
		var attachs = new Array();
		
		$(function() {
			$("#uploadify")
					.uploadify(
							{
								'uploader' : ctx
										+ '/static/uploadify/uploadify.swf',
								'script' : ctx + '/uploadfile',
								'cancelImg' : ctx
										+ '/static/uploadify/cancel.png',
								'folder' : 'UploadFile',
								'queueID' : 'fileQueue',
								'auto' : true,
								'multi' : false,
								'buttonImg' : ctx
										+ '/static/uploadify/uploadify.png',
								'width' : 78,
								'height' : 23,
								'onComplete' : function(event, UserID, fileObj,
										response, data) {
									console.log("response:", response);
									if (response != null) {
										var result = eval("(" + response + ")");
										if (result.success) {
											var attach = result.data;
											attachs.push(attach);
											console.log("attachs:", attachs);
											$("#filelist")
													.append(
															"<li id='attach_"+attach.id+"' style='padding:5px;list-style-type: none;'>"
																	+ attach.filename
																	+ "[<a href='javascript:void(0)' onclick=delAttachClient('"
																	+ attach.id
																	+ "')>删除</a>]</li>");
										}
									}
								}
							});

			$("#saveTopicBtn").click(function() {
				var id = $("#reportid").val();
				if (id != "") {
					url = ctx + "/report/edit";
				} else {
					url = ctx + "/report/add";
				}
				var title = $("#title").val();
				if (title == "") {
					$.messager.show({
						title : '提示',
						msg : '报表标题不能为空！',
						timeout : 3000,
						showType : 'slide'
					});
					return;
				}
				
				var cyc = $("#cyc").val();
				if (cyc == "") {
					$.messager.show({
						title : '提示',
						msg : '报表标题不能为空！',
						timeout : 3000,
						showType : 'slide'
					});
					return;
				}

				var postData = {
					id : $("#reportid").val(),
					svgid : $("#svgid").val(),
					title : $("#title").val(),
					cyc : $("input[name='cyc']:checked").val(),
					isattach : $("input[name='isattach']:checked").val(),
					status : $("#status").val(),
					remark : $("#remark").val(),
					attachs : attachs
				};
				console.log("postData", postData);

				$.ajax({
					type : "POST",
					url : url,
					data : JSON.stringify(postData),//将对象序列化成JSON字符串  
					dataType : "json",
					contentType : 'application/json;charset=utf-8', //设置请求头信息  
					success : function(res) {
						$.messager.show({
							title : '友情提示',
							msg : res.msg,
							timeout : 3000,
							showType : 'slide'
						});
						window.location.href = ctx + "/report";
					},
					error : function(res) {
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

		function delAttachClient(attachid) {
			if (attachs) {
				for (var i = 0; i < attachs.length; i++) {
					var attach = attachs[i];
					var attach_id = attach.id;
					if (attach_id == attachid) {
						attachs.splice(i, 1);
						console.log(attachs);
						$("#attach_" + attach_id).remove();
						break;
					}
				}
			}
		}

		//附件删除
		function delAttachByServer(attachid) {
			if (!attachid) {
				return;
			}
			$.ajax({
				url : ctx + '/report/attach/delete?attachid=' + attachid,
				type : 'post',
				dataType : 'json',
				success : function(json) {
					if (json.success) {
						$("#attach_" + attachid).remove();
					} else {
						alert(json.msg);
					}
				}
			});
		}
	</script>

	<fieldset>
		<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">报表</legend>
		<form id="reportform" method="post">
			<input type="hidden" id="reportid" name="id" value="${report.id}" />
			<input type="hidden" id="svgid" name="svgid" value="${report.svgid}" />
			<table class="tableForm" style="margin-top: 10px;">
				<tr class="thclass" style="height: 40px">
					<th style="width: 130px; font-size: 14px;">报表名称<font
						style="color: red">*</font></th>
					<td><input type="text" name="title" id="title"
						style="width: 300px; height: 30px" class="textbox textbox_indent"
						value="${report.title}" /></td>
				</tr>

				<tr class="thclass" style="height: 40px">
					<th style="width: 130px; font-size: 14px;">报送周期<font
						style="color: red">*</font></th>
					<td><input type="radio" name="cyc" id="D" value="D" <c:if test="${report.cyc=='D' }"> checked="checked" </c:if> /> <label for="D" >日</label>
						<input type="radio" name="cyc" id="W" value="W" <c:if test="${report.cyc=='W' }"> checked="checked" </c:if> /> <label for="W">周</label>
						<input type="radio" name="cyc" id="M" value="M" <c:if test="${report.cyc=='M' }"> checked="checked" </c:if> /> <label for="M">月</label>
						<input type="radio"	name="cyc" id="Q" value="Q" <c:if test="${report.cyc=='Q' }"> checked="checked" </c:if> /> <label for="Q">季度</label>
						<input type="radio" name="cyc" id="Y" value="Y" <c:if test="${report.cyc=='Y' }"> checked="checked" </c:if> /> <label for="Y">年</label>
					</td>
				</tr>
				<tr class="thclass" style="height: 40px">
					<th style="width: 130px; font-size: 14px;">是否附件上报<font
						style="color: red">*</font></th>
					<td><input type="radio" name="isattach" id="no" value="0" <c:if test="${report.isattach=='0' }"> checked="checked" </c:if> /><label
						for="no">否</label>
						<input type="radio" name="isattach" id="yes" value="1" <c:if test="${report.isattach=='1' }"> checked="checked" </c:if> />
						<label for="yes">是</label>
					</td>
				</tr>
				
				<tr class="thclass" style="height: 40px">
					<th style="width: 130px; font-size: 14px;">业务状态<font
						style="color: red">*</font></th>
					<td><select id="status" name="status">
							<option value="1"
								<c:if test="${report.status=='1' }"> selected="selected" </c:if>>业务开放</option>
							<option value="0"
								<c:if test="${report.status=='0' }"> selected="selected" </c:if>>业务关闭</option>
					</select></td>
				</tr>
				
				<tr class="thclass" style="height: 40px">
					<th style="width: 130px; font-size: 14px;">备注说明<font
						style="color: red">*</font></th>
					<td><textarea name="remark" id="remark"
							class="textbox textbox_area textbox_indent" rows="5" cols="10"
							style="width: 345px; height: 100px;">${report.remark}</textarea></td>
				</tr>
				

				<tr class="thclass" style="height: 40px">
					<th style="width: 130px; font-size: 14px;">附件列表</th>
					<td><input type="file" value="上传文件" name="uploadify"
						id="uploadify" width="78" style="display: none;" height="23" /></td>
				</tr>
				<tr class="thclass" style="height: 40px">
					<th style="width: 130px; font-size: 14px;"></th>
					<td>
						<ul id="filelist" style="padding-left: 0px;">
							<c:forEach items="${report.attachs}" var="attach">
								<li id="attach_${attach.id}"
									style="padding: 5px; list-style-type: none;">${attach.filename}&nbsp;&nbsp;[<a
									href='javascript:void(0)'
									onclick="delAttachByServer('${attach.id}')">删除</a>]
								</li>
							</c:forEach>
						</ul>
					</td>
				</tr>
				<tr class="thclass" style="height: 40px">
					<th style="width: 130px; font-size: 14px;"></th>
					<td><input type="button" value="保存" id="saveTopicBtn"
						style="width: 130px; height: 40px;" /></td>
				</tr>
			</table>
		</form>
	</fieldset>

</body>
</html>