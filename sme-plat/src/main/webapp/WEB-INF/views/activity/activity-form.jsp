<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>活动表单</title>
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
		self.location = "${pageContext.request.contextPath}/activity";
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
	                    $("#filelist").append(""+attach.filename+"<br>");
	            	}
	                $("#txtTishi").html(result.msg);
	            }
	        }
	    });
		
		$("#activityAddBtn").click(function () {
			if (!$("#myform").form('validate')) {
				console.log("valid","false");
				//return false;
			}
			var id =$("#activityid").val();
			var status = $('#myform input[name="status"]:checked').val();
			console.log("status",status);
			
			if (id != ""){
				url=ctx+"/activity/edit";
			}else{
				url=ctx+"/activity/add";
			}
			
	        var postData = {
	        	id:id,
	            title:$("#title").val(),
	            scode:$("#scode").val(),
	            svgid:$("#svgid").val(),
	            usernum:$("#usernum").val(),
	            orgnum:$("#orgnum").val(),
	            linktel:$("#linktel").val(),
	            linker:$("#linker").val(),
	            starttime:$("#starttime").datebox('getValue'),
	            endtime:$("#endtime").datebox('getValue'),
	            address:$("#address").val(),
	            content: editor.html(),
	            img:$("#act_img").val(),
	            status:status,
	            attachs:attachs
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
	            	window.location.href = ctx+"/activity";
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
	<input type="hidden" id="returnMsg" value="${returnMsg.msg}" />
	<input type="hidden" id="returnSuccess" value="${returnMsg.success}" />
	<script type="text/javascript">
		if (document.getElementById("returnSuccess").value)
			$.messager.show({
				title : '提示',
				msg : document.getElementById("returnMsg").value,
				timeout : 3000,
				showType : 'slide'
			});
	</script>

	<fieldset>
		<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">活动编辑</legend>
		<form id="myform" action="${activity==null?'add':'edit'}" method="post">
		<input type="hidden" id="activityid" name="id" value="${activity.id}" />
			<table cellpadding="3" cellspacing="0" class="edit_table" id="tbEditForm">
				<tr>
					<td class="edit_title"><tt>*</tt><span
						style="letter-spacing: 2em">标</span>题：</td>
					<td><input type="text" name="title"  id="title"
						style="width: 395px;" maxlength="512"
						data-options="required:true,validType:'NULL'"
						class="easyui-validatebox textbox textbox_indent" value="${activity.title }" /></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>活动分类：</td>
					<td><select name="scode" id="scode"  style="width: 190px;">
							<c:forEach items="${sclasslist}" var="sclass">
							<option value="${sclass.id }" <c:if test="${sclass.id== activity.scode }">   selected="selected" </c:if>>${sclass.title }</option>
						</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>主办单位：</td>
					<td>
					<input type="text" style="width: 190px;" readonly="readonly" value="${svorg.title }">
					<input type="hidden" name="svgid" id="svgid"  style="width: 190px;" readonly="readonly" value="${activity.svgid }" >
					</td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>活动人数：</td>
					<td><input type="text" id="usernum" name="usernum" class="easyui-numberbox" style="width: 80px;" value="${activity.usernum }"/>（所有参加活动的人员总数）
						</td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>参会机构：</td>
					<td><input type="text" id="orgnum" name="orgnum" class="easyui-numberbox" style="width: 80px;" value="${activity.orgnum }"/>（参加活动的服务机构数量）
					</td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>活动时间：</td>
					<td><input style="width: 130px;" name="starttime" id="starttime"
						value="${activity.starttimestr}" class="easyui-datebox"
						data-options="required:true,formatter:myformatter,parser:myparser" />
						～ <input id="endtime" style="width: 130px;" name="endtime"
						 class="easyui-datebox" value="${activity.endtimestr}"
						data-options="formatter:myformatter,parser:myparser" /></td>
				</tr>
				<tr style="height: 32px;">
					<td class="edit_title">活动状态：</td>
					<td>
						<input type="radio" value="0" name="status" id="State" <c:if test="${activity.status=='0'}">checked="checked"</c:if> />
						<label for="State">未开始</label> 
						<input type="radio" value="1" name="status" id="State1" <c:if test="${activity.status=='1'}">checked="checked"</c:if> />
						<label for="State1">进行中</label>
						<input type="radio" value="2" name="status" id="State2" <c:if test="${activity.status=='2'}">checked="checked"</c:if> />
						<label for="State2">已结束</label></td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt><span
						style="letter-spacing: .5em">联</span><span
						style="letter-spacing: .5em">系</span>人：</td>
					<td><input type="text" id="linker" name="linker"
						class="easyui-validatebox textbox textbox_indent"
						style="width: 100px;"
						data-options=" validType:'maxLength[50]'" value="${activity.linker }" />
					</td>
				</tr>
				<tr>
					<td class="edit_title"><tt>*</tt>联系电话：</td>
					<td><input type="text" id="linktel" name="linktel"
						class="easyui-validatebox textbox textbox_indent"
						style="width: 130px;" maxlength="20"
						data-options="validType:'length[1,20]'" value="${activity.linktel }" />
					</td>
				</tr>
				
				<tr>
					<td class="edit_title"><tt>*</tt>活动地址：</td>
					<td><input type="text" name="address"  id="address"
						style="width: 395px;" maxlength="512"
						data-options="validType:'NULL'"
						class="easyui-validatebox textbox textbox_indent" value="${activity.address}" /></td>
				</tr>

				<tr>
					<td class="edit_title" style="vertical-align: top;">活动内容：</td>
					<td><textarea name="content" id="content"
							class="textbox textbox_area textbox_indent"
							style="width: 99%; height: 200px; float: left;" >${activity.content }</textarea></td>
				</tr>
				<tr>
					<td class="edit_title">活动图片：</td>
					<td>
					<input type="hidden" id="act_img" name="img" value="" />
					<img alt="" src="${activity.img }" width="70" height="70">
					<input type="file" value="上传文件" id="uploadify" width="78" style="display: none;" height="23" />
						<label id="txtTishi" style="font-size: 12px"></label>
					</td>
				</tr>
				
				
				<tr style="height: 50px;">
					<td colspan="2" style="text-align: right">
					<a id="activityAddBtn" class="easyui-linkbutton" data-options="iconCls:'icon-add'" href="javascript:">保存</a> 
					<a id="btnBack" class="easyui-linkbutton" data-options="iconCls:'icon-back'" href="javascript:" onclick="BackIndex()">返回</a>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>
