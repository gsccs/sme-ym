<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>行政诉求申详情</title>
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
<div class="easyui-layout" fit="true" border="false">
	<div data-options="region:'center',split:false">
		<div class="easyui-layout" fit="true" border="false">
			<div data-options="region:'west',title:''" style="width: 70%">
				<fieldset style="height: 95%">
				<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">事项详情</legend>
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
						<td style="width: 530px;"><textarea 
								class="textbox textbox_area textbox_indent" readonly="readonly"
								style="width: 99%; height: 120px; float: left;">${appealItem.content}</textarea></td>
					</tr>
					
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">提交日期</th>
						<td>${appealItem.addtimestr}</td>
					</tr>
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">附件列表：</th>
						<td>
							<c:forEach items="${appealItem.attachs}" var="attach">
							<li id="${attach.id}" style="height: 30px; list-style-type: none;">
								<label>${attach.filename}</label>&nbsp;&nbsp;
							</li>
							</c:forEach>
						</td>
					</tr>
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">办理结果</th>
						<td>
						<c:if test="${appealItem.result==0}">办理成功</c:if>
						<c:if test="${appealItem.result==1}">驳回</c:if>
						</td>
					</tr>
					
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">回复内容</th>
						<td>${appealItem.content}</td>
					</tr>
					
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">回复时间</th>
						<td>${appealItem.endtimestr}</td>
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
