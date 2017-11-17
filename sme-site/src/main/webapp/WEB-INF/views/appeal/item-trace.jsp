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
	
    <script type="text/javascript">
    	var ctx="${pageContext.request.contextPath}";
        var editor;
        <script type="text/javascript">
    	var ctx = "${pageContext.request.contextPath}";
    	$(function () {
    		$("#list_data").datagrid({
    			height : 'auto',
    			nowrap : false,
    			striped : true,
    			border : true,
    			collapsible : false,//是否可折叠的 
    			fit : true,//自动大小 
    			loadMsg : '数据加载中请稍后……',
    			url : '/appeal/trace',
    			remoteSort : false,
    			fitColums : true,
    			checkOnSelect : true,
    			singleSelect : true,//是否单选 
    			pagination : true,//分页控件 
    			rownumbers : true,//行号
    			idField: 'id',
    			columns : [ [ {
    				field : 'id',
    				title : '编号',
    				width : 150,
    				checkbox : true
    			}, {
    				field : 'topictitle',
    				title : '事项标题',
    				width : 200
    			},{
    				field : 'svgtitle',
    				title : '主办单位',
    				width : 100
    			}, {
    				field : 'addtimestr',
    				title : '提交时间',
    				width : 150
    			}, {
    				field : 'endtimestr',
    				title : '办理时间',
    				width : 150
    			}, {
    				field : 'status',
    				title : '状态',
    				width : 100,
    				formatter:function(value,row){
    			    	var str = "";
    			    	if(value=="0"){
    			    		str = "<font style=''>等待受理</font>";
    			    	}else if(value=="1"){
    			    		str = "<font color='green'>办理成功</font>";
    			    	}else if(value=="2"){
    			    		str = "<font color='green'>正在办理</font>";
    			    	}else if(value=="-2"){
    			    		str = "<font color=''>已取消</font>";
    			    	}
    			    	return str;
    				}
    			}, {
    				field : 'result',
    				title : '办理结果',
    				width : 100,
    				formatter:function(value,row){
    			    	var str = "";
    			    	if(value=="0"){
    			    		str = "<font color='red'>驳回</font>";
    			    	}else if(value=="1"){
    			    		str = "<font color='green'>通过</font>";
    			    	}
    			    	return str;
    				}
    			}, {
    				field : 'resultstr',
    				title : '结果描述',
    				width : 200
    			}  ] ],
    			toolbar : [ {
    				text : '修改申请',
    				iconCls : 'icon-edit',
    				handler : function() {
    					editFun();
    				}
    			},'-',{
    				text : '取消申请',
    				iconCls : 'icon-edit',
    				handler : function() {
    					cancelFun();
    				}
    			},'-',{
    				text : '跟踪进度',
    				iconCls : 'icon-edit',
    				handler : function() {
    					traceFun();
    				}
    			}],
    			pageSize : 10,
    			pageList : [10, 15, 20]
    		});
    		var p = $('#list_data').datagrid('getPager');
    		$(p).pagination({
    			pageSize : 10,//每页显示的记录条数，默认为10 
    			pageList : [10, 15, 20 ],//可以设置每页记录条数的列表 
    			beforePageText : '第',//页数文本框前显示的汉字 
    			afterPageText : '页    共 {pages} 页',
    			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
    		});
    	});
</script>

<style type="text/css" media="screen">
#uploadifyUploader {visibility:hidden}
</style>
<div class="admin_right">
    <div class="indent_title">
        <img src="${pageContext.request.contextPath}/resources/home/images/t_05.jpg" width="5" height="17" class="fl"><span>提交申请</span>
    </div>
    <div class="Info_center" id="Note" style="display: block;">
        <div class="clear">
        </div>
        <div class="fm_xuxian">
        </div>
        <input type="hidden" id="id" class="info_input" value="${appealItem.id }"  />
       
        <div class="clear" style="height: 20px; line-height: 20px;">
        </div>
        <table id="list_data" class="easyui-datagrid" style="width:1000px;height:500px" data-options="singleSelect:true,collapsible:true">
    	
    	</table>
    </div>
    
    <div class="Info_bottom"></div>
</div>

</body>
</html>