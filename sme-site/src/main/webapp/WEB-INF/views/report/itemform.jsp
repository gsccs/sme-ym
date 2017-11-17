<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>数据上报_企业管理后台_玉门市中小企业公共服务平台</title>
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
<script src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/resources/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/resources/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/uploadify/swfobject.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/resources/uploadify/uploadify.css" rel="stylesheet" type="text/css">
    
    <script type="text/javascript">
    	var ctx="${pageContext.request.contextPath}";
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
                            $("#filelist").append("<li id='attach_"+attach.id+"' style='padding:5px;list-style-type: none;'>"+attach.filename+"[<a href='javascript:void(0)' onclick=delAttachClient('"+attach.id+"')>删除</a>]</li>");
                    	}
                        $("#txtTishi").html(result.msg);
                    }
                }
            });

            $("#Report_SAVE_BTN").click(function () {
            	if (attachs.length<=0){
            		alert("请上传附件。");
            		return;
            	}
            	var id =$("#id").val();
        		if (id != ""){
        			url=ctx+"/cp/report/edit";
        		}else{
        			url=ctx+"/cp/report/add";
        		}
                var postData = {
                	id:$("#id").val(),
                	reportid:$("#reportid").val(),
                	remark: $("#remark").val(),
                    attachs:attachs
                };
                
                console.log("postdata",postData);
                $.ajax({  
                    type: "POST",  
                    url: url,  
                    data: JSON.stringify(postData),//将对象序列化成JSON字符串  
                    dataType:"json",  
                    contentType : 'application/json;charset=utf-8', //设置请求头信息  
                    success: function(res){
                    	console.log(res);
                    	$.messager.show({
            				title : '友情提示',
            				msg : res.msg,
            				timeout : 3000,
            				showType : 'slide'
            			});
                    	window.location.href = ctx+"/cp/report/itemlist";
                    },  
                    error: function(res){
                    	console.log("error",res);
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

<style type="text/css" media="screen">
#uploadifyUploader {visibility:hidden}
</style>

<div class="admin_right">
    <div class="indent_title">
        <img src="${pageContext.request.contextPath}/resources/home/images/t_05.jpg" width="5" height="17" class="fl"><span>数据上报</span>
    </div>
    <div class="Info_center" id="Note" style="display: block;">
        <div class="clear">
        </div>
        <div class="fm_xuxian">
        </div>
        <input type="hidden" id="id" value="${reportItem.id }"  />
        <input type="hidden" id="reportid" value="${report.id }"  />
        <dl class="info_dl">
            <dt class="fm_dt"><span class="fr">报表名称：</span></dt>
            <dd>
                <div class="left " style="width: 470px;">${report.title } </div>
            </dd>
        </dl>
        <dl class="info_dl">
            <dt class="fm_dt"><span class="fr">上报单位：</span></dt>
            <dd>
                <div class="left " style="width: 470px;">${report.svgtitle }
                <input type="hidden" id="svgid" class="info_input" value="${report.svgid }" style="color: #999"  />
                </div>
            </dd>
        </dl>
        
        <dl class="info_dl">
            <dt class="fm_dt"><span class="fr">上报要求：</span></dt>
            <dd>
                <div class="left " style="width: 470px;">
                ${report.remark }
                </div>
            </dd>
        </dl>
        
        <dl class="info_dl">
            <dt class="fm_dt"><span class="fr">报表模板：</span></dt>
            <dd>
                <ul class="left " style="width: 470px;">
                	<c:forEach items="${report.attachs }" var="attach">
                		<li>${attach.filename }&nbsp;&nbsp;&nbsp;&nbsp;[<a href="${attach.filepath }">下载</a>]</li>
                	</c:forEach>
                </ul>
            </dd>
        </dl>
        <dl class="info_dl">
            <dt class="fm_dt"><span class="fr">备注信息：</span></dt>
            <dd style="height: 200px;">
                <div class="left">
                    <textarea id="remark" style="width: 570px; height: 100px; ">${reportItem.remark }</textarea>
                </div>
                <div style="clear: both;">
                </div>
                <div style="margin-top: 10px;">
                	<ul id="filelist">
                		<c:forEach items="${reportItem.attachs }" var="attach">
	                		<li>${attach.filename }&nbsp;&nbsp;&nbsp;&nbsp;[<a href="${attach.filepath }">下载</a>]</li>
	                	</c:forEach>
                	</ul>
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
        	<input type="button" id="Report_SAVE_BTN" value="保  存" style="width: 100px;height: 30px;">    
        </div>
        <div class="clear" style="height: 20px; line-height: 20px;">
        </div>
    </div>
    <div class="Info_bottom"></div>
</div>

</body>
</html>