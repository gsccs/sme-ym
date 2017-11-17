<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>行政诉求_企业管理后台_玉门市中小企业公共服务平台</title>
    <link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/home/css/webindex.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/home/css/admin.css" />

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/home/css/main.css" />
<link id="changbj" rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/easyui/themes/icon.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/site/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/site/js/jquery.soChange.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/site/js/js.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/site/js/Common.js"></script>
<script src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/resources/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/resources/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/uploadify/swfobject.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/resources/uploadify/uploadify.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/kindeditor/kindeditor-all-min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/layer/layer.js"></script>
	
    <script type="text/javascript">
    	var ctx="${pageContext.request.contextPath}";
        var editor;
        var attachs = new Array();
        $(function () {
            LoadEditor('textarea[name="Demand_Detail"]', 'editor');
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
                            $("#filelist").append("<li id='attach_"+attach.id+"'>"+attach.filename+"</li>");
                    	}
                        $("#txtTishi").html(result.msg);
                    }
                }
            });

            $("#Declare_SAVE_BTN").click(function () {
            	var id =$("#id").val();
        		if (id != ""){
        			url=ctx+"/cp/declare/update";
        		}else{
        			url=ctx+"/cp/declare/add";
        		}
                var txtName = editor.html();
                var postData = {
                	id:$("#id").val(),
                	topicid:$("#topicid").val(),
                    content: txtName,
                    status:'0',
                    attachs:attachs
                };
                $.ajax({  
                    type: "POST",  
                    url: url,  
                    data: JSON.stringify(postData),//将对象序列化成JSON字符串  
                    dataType:"json",  
                    contentType : 'application/json;charset=utf-8', //设置请求头信息  
                    success: function(res){
                    	layer.msg('资料提交成功！', {
                    	    time: 5000, //20s后自动关闭
                    		icon: 1,
                    		btn: ['确定'] //按钮
                    	}, function(){
                    		window.location.href = ctx+"/cp/declare/items";
                    	});
                    	
                    },  
                    error: function(res){
                    	layer.alert(res.msg);
                	}
                });
            });
        });
</script>

<style type="text/css" media="screen">
#uploadifyUploader {visibility:hidden}
</style>
<link href="${pageContext.request.contextPath}/resources/kindeditor/themes/default/default.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/home/css/Site.css" rel="stylesheet" type="text/css" />

<div class="admin_right">
    <div class="indent_title">
        <img src="${pageContext.request.contextPath}/resources/home/images/t_05.jpg" width="5" height="17" class="fl"><span>提交申请</span>
    </div>
    <div class="Info_center" id="Note" style="display: block;">
        <div class="clear">
        </div>
        <div class="fm_xuxian">
        </div>
        <input type="hidden" id="id" class="info_input" value="${declareItem.id }"  />
        <input type="hidden" id="topicid" class="info_input" value="${declareTopic.id }"  />
        <dl class="info_dl">
            <dt class="fm_dt"><span class="fr">申报项目：</span></dt>
            <dd>
                <div class="left " style="width: 470px;">${declareTopic.title } [<a href="/declare-${declareTopic.id }.html" target="blank">申报指南</a>]</div>
            </dd>
        </dl>
        <dl class="info_dl">
            <dt class="fm_dt"><span class="fr">主办单位：</span></dt>
            <dd>
                <div class="left " style="width: 470px;">${declareTopic.svgtitle }
                <input type="hidden" id="svgid" class="info_input" value="${declareTopic.svgid }" style="color: #999" onclick="if(value==defaultValue){value='';this.style.color='#000'}" onblur="if(!value){value=defaultValue;this.style.color='#999'}" />
                </div>
            </dd>
        </dl>
        
        <dl class="info_dl">
            <dt class="fm_dt"><span class="fr">具体要求：</span><font class="fr">*</font></dt>
            <dd style="height: 350px;">
                <div class="left">
                    <textarea name="Demand_Detail" style="width: 570px; height: 300px; visibility: hidden; display: none;">${declareItem.content }</textarea>
                </div>
            </dd>
        </dl>
        <dl class="info_dl">
            <dt class="fm_dt"><span class="fr">附件列表：</span></dt>
            <dd style="height: 100px;">
                <ul id="filelist" class="left " style="width: 470px;">
                	<c:forEach items="${declareItem.attachs }" var="attach">
                		<li id="attach_${attach.id }">${attach.filename }&nbsp;&nbsp;&nbsp;&nbsp;[<a href="${attach.filepath }">下载</a>]</li>
                	</c:forEach>
                </ul>
                <div style="clear: both;">
                </div>
                <div style="margin-top: 10px;">
                    <table>
                        <tbody><tr>
                            <td>
                                <input type="file" value="上传文件" name="uploadify" id="uploadify" width="78" style="display: none;" height="23">
                            </td>
                            <td>
                                <span id="txtTishi" style="color: #a0a0a0; padding-left: 8px;"></span>
                            </td>
                        </tr>
                    	</tbody>
                    </table>
                    <span id="fileQueue" style="float: right;" class="uploadifyQueue"></span>
                </div>
            </dd>
        </dl>
        
        <div style="width: 200px; margin: 0 auto; padding-top: 40px;">
        	<input type="button" id="Declare_SAVE_BTN" value="保存" style="width: 100px;height: 30px;">    
        </div>
        <div class="clear" style="height: 20px; line-height: 20px;">
        </div>
    </div>
    <div class="Info_bottom"></div>
</div>

</body>
</html>