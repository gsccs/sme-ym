<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>行政事项申请表单</tbitle>
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
<style type="text/css">
th {
	width: 130px;
	font-size: 14px;
}
</style>

<script type="text/javascript">
var ctx="${pageContext.request.contextPath}";
//保存
function saveAttendResult(){
	var itemid = $("#itemid").val();
	var result = $('#input[name="result"]:checked').val();
	var remark = $("#remark").val();
	var postData = {
		itemid:itemid,
		result: result,
		remark:remark
    };
	$.ajax({  
        type: "POST",  
        url: ctx+"/appeal/item/attend",  
        data: postData,
        dataType:"json",  
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
</script>
</head>
<body>
<input type="hidden" id="itemid" name="itemid" value="${appealItem.id}">
<div class="easyui-layout" fit="true" border="false">
	<div data-options="region:'center',split:false">
		<div class="easyui-layout" fit="true" border="false">
			<div data-options="region:'west',title:''" style="width: 70%">
				<fieldset style="height: 95%">
				<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">事项详情</legend>
				<table class="tableForm" style="margin-top: 10px;width: 100%">
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">申请企业</th>
						<td>${appealItem.corptitle}</td>
					</tr>
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">事项名称</th>
						<td>${appealItem.topictitle}</td>
					</tr>
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">提交日期</th>
						<td>${appealItem.addtimestr}</td>
					</tr>
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">事项描述</th>
						<td style="width: 80%"><textarea 
								class="textbox textbox_area textbox_indent"
								style="width: 99%; height: 120px; float: left;">${appealItem.content}</textarea></td>
					</tr>
					
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">附件列表</th>
						<td >
							<ul style="padding-left: 0px;">
							<c:forEach items="${appealItem.attachs}" var="attach">
								<li id="${attach.id}" style="height: 30px; list-style-type: none;">
									<label>${attach.filename}</label>&nbsp;&nbsp;
									<a name="${attach.id}" onclick="delAttach(this)" class="easyui-linkbutton">[下载]</a>
								</li>
							</c:forEach>					
							</ul>
						</td>
					</tr>
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">是否同意</th>
						<td><input type="radio" name="result" value="1" checked="checked">同意
							<input type="radio" name="result" value="0">驳回
						 </td>
					</tr>
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">结果描述</th>
						<td><textarea name="remark" id="remark"
								class="textbox textbox_area textbox_indent"
								style="width: 99%; height: 120px; float: left;"></textarea></td>
					</tr>
					
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;"></th>
						<td><input type="button" value="提交" onclick="saveAttendResult();"></td>
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
