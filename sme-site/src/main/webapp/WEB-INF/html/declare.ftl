<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>项目申报详情_玉门市中小企业公共服务平台</title>
<link rel="shortcut icon" href="/resources/site/images/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/base.css" />
<script type="text/javascript" src="${base}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/Common.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/HomeAndFavorite.js"></script>

<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/declare.css" />
<script type="text/javascript" src="${base}/resources/site/js/jquery-1.8.0.min.js"></script>
<script src="${base}/resources/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
<script src="${base}/resources/uploadify/swfobject.js" type="text/javascript"></script>
<link href="${base}/resources/uploadify/uploadify.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${base}/resources/layer/layer.js"></script>
<script type="text/javascript">
var attachs = new Array();
$(function () {
	$("#uploadify").uploadify({
        'uploader': '/resources/uploadify/uploadify.swf',
		'script': '/uploadfile',
		'cancelImg': '/resources/uploadify/cancel.png',
		'folder': 'UploadFile',
		'queueID': 'fileQueue',
		'auto': true,
		'multi': false,
		'buttonImg': '/resources/uploadify/uploadify.png',
		'width': 78,
		'height': 23,
		'onComplete': function (event, UserID, fileObj, response, data) {
			console.log("response:",response);
			if (response != null) {
				var result = eval("(" + response + ")");
				if (result.success){
		        	var attach = result.data;
					attachs.push(attach);
					$("#filelist").append("<li id='attach_"+attach.id+"'>"+attach.filename+"&nbsp;&nbsp;&nbsp;[<a href='javascript:void(0)' onclick=delAttachClient('"+attach.id+"')>删除</a>]</li>");
				}else{
					$("#txtTishi").html(result.msg);
		        }
			}
		}
	}); 
	
	$("#dvSubmit").click(function () {
		var topicid =$("#topicid").val();
		var content= $("#content").val();
		if (content==""){
			layer.alert("申报内容不能为空！");
			return;
		}
		
		if (content.length>255){
			layer.alert("申报内容超出最大字数限制！");
			return;
		}
		
		if(attachs.length<=0){
			var r=confirm("请确认不需要上传附件？");
			if (!r){
				return;
			}
		}
		
        var postData = {
        	topicid:topicid,
            content: content,
            attachs:attachs
        };
        
        console.log("postData",postData);
        $('#dvSubmit').attr('disabled',"true");
        $.ajax({  
            type: "POST",  
            url: "/cp/declare/add",  
            data: JSON.stringify(postData),//将对象序列化成JSON字符串  
            dataType:"json",  
            contentType : 'application/json;charset=utf-8', //设置请求头信息  
            success: function(res){
				layer.alert("申请提交成功");
				$("#content").val();
				//$("#filelist").remove();
				$('#dvSubmit').attr('disabled',"true");
            },  
            error: function(res){
				layer.alert("申请提交失败");
				$('#dvSubmit').removeAttr("disabled");
        	}
        });
    });           
});

 //验证码
function ChangeCode() {
	$("#imgCode").attr("src", "/Home/GetValidCode?time=" + (new Date()).getTime());
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
</script>
</head>
<body>

	<script type="text/javascript">
    $(function () {

        $("#dvCategoryTitle").click(function () {
            $("#uCategoryDetail").slideDown(400);
        });

        $("#uCategoryDetail").mouseleave(function () {
            $("#uCategoryDetail").slideUp(400);
        });

        Search();
    });
</script>
	<!-- header -->
	[#include "/widget/header.ftl" /]
	
	<!-- main -->
	[#include "/declare/detailmain.ftl" /]
	
	<!-- footer -->
    [#include "/widget/footer.ftl" /]	
</body>
</html>