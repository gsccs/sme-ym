<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目申报表单</title>
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
	var status = $('input[name="declare_result"]:checked').val();
	var reply = $("#reply").val();
	var postData = {
		id:itemid,
		status: status,
		reply:reply,
		attachs:attachs
    };
	$.ajax({  
        type: "POST",  
        url: ctx+"/declare/item/audit",  
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
        	window.location.href = ctx+"/declare/item/";
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
		url : ctx+'/declare/attach/delete?attachid='+attachid,
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
		<div id="tt" class="easyui-tabs" fit="true" style="" >
			<div title="项目申报审批" style="margin: 10px; padding: 0px; background-color: #fff;">
				<fieldset style="">
				<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">项目申报</legend>
				<input type="hidden" id="itemid" name="itemid" value="${declareItem.id}" />
				<table class="tableForm" style="margin-top: 10px;width: 80%;">
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">申报企业:</th>
						<td colspan="3">${declareItem.corptitle}</td>
					</tr>
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">申报项目:</th>
						<td colspan="3">${declareItem.topictitle}</td>
					</tr>
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">项目名称:</th>
						<td colspan="3">${declareItem.title}</td>
					</tr>
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">项目经理:</th>
						<td>${declareItem.leader}</td>
						<th style="width: 130px; font-size: 14px;">联系电话:</th>
						<td>${declareItem.linktel}</td>
					</tr>
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">申请备注:</th>
						<td colspan="3" >
						<textarea 
								class=" textbox_area textbox_indent" readonly="readonly"
								style="width: 99%; height: 120px; float: left;">${declareItem.content}</textarea></td>
					</tr>
					
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">申请日期:</th>
						<td colspan="3">${declareItem.addtimestr}</td>
					</tr>
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">附件列表:</th>
						<td colspan="3">
						<ul>
						<c:forEach items="${declareItem.attachs}" var="attach">
							<li id="${attach.id}" style="height: 30px; list-style-type: none;"><label>${attach.filename}</label>&nbsp;&nbsp;
							[<a name="${attach.id}" href="${attach.filepath}" >下载</a>]</li>
						</c:forEach>
						</ul>											
						</td>
					</tr>
					
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">审批结果:</th>
						<td colspan="3"><input type="radio" name="declare_result" value="1" checked="checked">同意
							<input type="radio" name="declare_result" value="-1">驳回
						 </td>
					</tr>
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">审批意见:</th>
						<td colspan="3"><textarea name="reply" id="reply" 
								class=" textbox_area textbox_indent"
								style="width: 99%; height: 120px; float: left;"></textarea></td>
					</tr>
					
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;"></th>
						<td colspan="3"><input type="button" value="提交" onclick="saveAttendResult();" style="width: 150px;height: 30px;"></td>
					</tr>
				</table>
				</fieldset>
			</div>
			<div title="项目情况" style="">  
			    <table  cellspacing="0" cellpadding="0" >
			    	<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">投资总额</th>
						<td>${declareItem.invest} 万元</td>
						<th style="width: 130px; font-size: 14px;">自有资金</th>
						<td>${declareItem.owncapital} 万元</td>
					</tr>
					
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">银行贷款</th>
						<td>${declareItem.bankcapital} 万元</td>
						<th style="width: 130px; font-size: 14px;">其他资金</th>
						<td>${declareItem.othercapital} 万元</td>
					</tr>
			    </table>
			    
			    
			    <table  cellspacing="0" cellpadding="0">
			    	<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">销售收入</th>
						<td>${declareItem.saleincome} 万元</td>
						<th style="width: 130px; font-size: 14px;">销售利润</th>
						<td>${declareItem.saleprofits} 万元</td>
					</tr>
					
					<tr class="thclass" style="height: 40px">
						<th style="width: 130px; font-size: 14px;">税金</th>
						<td>${declareItem.taxes} 万元</td>
						<th style="width: 130px; font-size: 14px;">从业人数</th>
						<td>${declareItem.employee} 个</td>
					</tr>
			    </table>
			</div> 
		</div>
	</div>
</div>

</body>
</html>
