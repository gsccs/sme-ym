<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>需求响应单位列表</title>
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

</head>
<body style="margin: 10px; padding: 0px; background-color: #fff;">
	<fieldset>
		<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">需求详情</legend>
			<input type="hidden" id="sneedid" name="sneedid" value="${sneedT.id}" />
			<input type="hidden" id="corpid" name="corpid" value="${sneedT.corpid}" />
			
			<table cellpadding="3" cellspacing="0" class="edit_table" id="tbEditForm">
				<tr>
					<td class="edit_title">企业名称：</td>
					<td>${sneedT.corptitle}</td>
				</tr>
				<tr>
					<td class="edit_title">需求标题：</td>
					<td>${sneedT.title}</td>
				</tr>
				<tr>
					<td class="edit_title">需求分类：</td>
					<td>${sneedT.sclassstr }</td>
				</tr>
				<tr>
					<td class="edit_title" style="vertical-align: top;">具体要求：</td>
					<td>${sneedT.content}</textarea>
					</td>
				</tr>
				<tr>
					<td class="edit_title" style="vertical-align: top;">联系人：</td>
					<td>${sneedT.linker}&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td class="edit_title" style="vertical-align: top;">联系电话：</td>
					<td>${sneedT.linktel}&nbsp;&nbsp;
					</td>
				</tr>
				
				<tr>
					<td class="edit_title" style="vertical-align: top;">联系人：</td>
					<td>${sneedT.linktel}&nbsp;&nbsp;
					</td>
				</tr>
				
				<tr>
					<td class="edit_title" style="vertical-align: top;">备注信息：</td>
					<td><textarea id="remark" name="remark" rows="" cols="" style="height: 120px;width: 500px" maxlength="200"></textarea>
					</td>
				</tr>
				
				<tr>
					<td class="edit_title" style="vertical-align: top;">联系人：</td>
					<td><input type="text" id="linker" name="linker" maxlength="100"> &nbsp;&nbsp;
					</td>
				</tr>
				
				<tr>
					<td class="edit_title" style="vertical-align: top;">联系电话：</td>
					<td><input type="text" id="linktel" name="linktel" maxlength="15"> &nbsp;&nbsp;
					</td>
				</tr>
				
				<tr>
					<td class="edit_title" style="vertical-align: top;"></td>
					<td><input id="BidSaveBtn" type="button" value="参与解决"> 
					</td>
				</tr>
			</table>
			
	</fieldset>
<script type="text/javascript">
var ctx = "${pageContext.request.contextPath}";
$("#BidSaveBtn").click(function() {
	var postData = {
		sneedid : $("#sneedid").val(),
		//corpid : $("#corpid").val(),
		linker : $("#linker").val(),
		linktel : $("#linktel").val(),
		remark : $("#remark").val()
	};
	console.log("postData",postData);
	var posturl = ctx + "/sneed/bid/add";
	
	$.ajax({  
        type: "POST",  
        url: posturl,  
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
        	window.location.href = ctx+"/sneed/bidlist";
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
</script>
</body>
</html>
