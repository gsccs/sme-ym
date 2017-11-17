<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
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
	src="${pageContext.request.contextPath}/static/js/Common.js"></script>
<script type="text/javascript">
	function BackIndex() {
		self.location = "${pageContext.request.contextPath}/corp";
	}
</script>
<style type="text/css">
.edit_title{
min-width: 70px;
}
</style>
</head>
<body >
<div class="easyui-layout" fit="true" border="false">
	<div data-options="region:'center',split:false">
		<div id="tt" class="easyui-tabs" fit="true" style="" >
			<div title="基本信息" style="margin: 10px; padding: 0px; background-color: #fff;">
				<fieldset>
				<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">企业详情</legend>
				<form id="myform" action="add" method="post">
					<table cellpadding="3" cellspacing="0" class="edit_table"
						id="tbEditForm">
						<tr>
							<td class="edit_title" style="width: 84px;">企业名称：</td>
							<td colspan="3"><label>${corp.title}</label></td>
						</tr>
						<tr>
							<td class="edit_title">组织机构代码：</td>
							<td><label>${corp.orgcode}</label></td>
							<td class="edit_title">工商注册编码：</td>
							<td><label>${corp.regcode}</label></td>
						</tr>
						<tr>
							<td class="edit_title">注册类型：</td>
							<td><label>${corp.regtype}</label></td>
							<td class="edit_title">注册资金：</td>
							<td><label>${corp.regfund}</label></td>
						</tr>
						<tr>
							<td class="edit_title">联系电话：</td>
							<td><label>${corp.phone}</label></td>
							<td class="edit_title">邮箱地址：</td>
							<td><label>${corp.email}</label></td>
						</tr>
		
						<tr>
							<td class="edit_title">单位性质：</td>
							<td><label>${corp.nature}</label></td>
							<td class="edit_title">法人：</td>
							<td><label>${corp.legaler}</label></td>
						</tr>
						<tr>
							<td class="edit_title">联系人：</td>
							<td><label>${corp.linker}</label></td>
							<td class="edit_title">联系电话：</td>
							<td><label>${corp.linktel}</label></td>
						</tr>
		
						<tr>
							<td class="edit_title">公司地址：</td>
							<td colspan="3"><label>${corp.address}</label></td>
						</tr>
						<tr>
							<td class="edit_title">控股情况：</td>
							<td><label>${corp.stake}</label></td>
							<td class="edit_title">QQ：</td>
							<td><label>${corp.qqcode}</label></td>
						</tr>
						<tr>
							<td class="edit_title">所属行业：</td>
							<td><label>${corp.hycode}</label></td>
							<td class="edit_title">子行业类别：</td>
							<td><label>${corp.subhycode}</label></td>
						</tr>
						
						<tr>
							<td class="edit_title">created：</td>
							<td><label>${corp.created}</label></td>
							<td class="edit_title">企业logo：</td>
							<td><img src="${corp.logo}"></td>
						</tr>
						<tr>
							<td class="edit_title">简要介绍：</td>
							<td colspan="3"><label>${corp.content}</label></td>
						</tr>
					</table>
			</fieldset>
			</div>  
			
			<div title="经营状况" style="">  
			    <table id="run_list_data" cellspacing="0" cellpadding="0"></table>
			</div> 
			<div title="生产工艺" style="">  
			    <table id="tech_list_data" cellspacing="0" cellpadding="0"></table> 
			</div> 
			<div title="能耗情况" style="">  
			    <table id="energy_list_data" cellspacing="0" cellpadding="0"></table> 
			</div>  
			<div title="用水情况" style="">  
			    <table id="water_list_data" cellspacing="0" cellpadding="0"></table> 
			</div>
			<div title="固体废旧物" style="">  
			    <table id="msw_list_data" cellspacing="0" cellpadding="0"></table> 
			</div>
		</div> 
	</div>
</div>
<script type="text/javascript">
var ctx = "${pageContext.request.contextPath}";
var selectedTab;
$('#tt').tabs({   
    onSelect:function(title){
    	selectedTab = title;
    }   
}); 
$('#run_list_data').datagrid({
	height : 'auto',
	nowrap : false,
	striped : true,
	border : true,
	collapsible : false,//是否可折叠的 
	fit : true,//自动大小 
	loadMsg : '数据加载中请稍后……',
	url : ctx+'/cdata/run/datagrid',
	remoteSort : false,
	fitColums : true,
	checkOnSelect : true,
	//singleSelect : false,//是否单选 
	pagination : true,//分页控件 
	rownumbers : true,//行号 
	columns : [ [ {
		field : 'id',
		title : '编号',
		width : 100,
		hidden: true
	}, {
		field : 'year',
		title : '经营年度',
		width : 80
	},{
		field : 'employee',
		title : '从业人数(个)',
		width : 100
	},{
		field : 'sale',
		title : '销售收入(万元)',
		width : 100
	},{
		field : 'assets',
		title : '资产合计(万元)',
		width : 100
	},{
		field : 'profits',
		title : '利润总额(万元)',
		width : 100
	},{
		field : 'tax',
		title : '上缴税金(万元)',
		width : 100
	},{
		field : 'debt',
		title : '负债总额(万元)',
		width : 100
	} ]]
});
//设置分页控件 
var p = $('#run_list_data').datagrid('getPager');
$(p).pagination({
	pageSize : 10,//每页显示的记录条数，默认为10 
	pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
	beforePageText : '第',//页数文本框前显示的汉字 
	afterPageText : '页    共 {pages} 页',
	displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
});	


$('#tech_list_data').datagrid({
	height : 'auto',
	nowrap : false,
	striped : true,
	border : true,
	collapsible : false,//是否可折叠的 
	fit : true,//自动大小 
	loadMsg : '数据加载中请稍后……',
	url : ctx+'/cdata/tech/datagrid',
	remoteSort : false,
	fitColums : true,
	checkOnSelect : true,
	//singleSelect : false,//是否单选 
	pagination : true,//分页控件 
	rownumbers : true,//行号 
	columns : [ [ {
		field : 'id',
		title : '编号',
		width : 100,
		hidden: true
	}, {
		field : 'title',
		title : '工艺名称',
		width : 200
	},{
		field : 'employee',
		title : '从业人数(个)',
		width : 100
	},{
		field : 'sale',
		title : '销售收入(万元)',
		width : 100
	},{
		field : 'assets',
		title : '资产合计(万元)',
		width : 100
	}]]
});
//设置分页控件 
var p = $('#tech_list_data').datagrid('getPager');
$(p).pagination({
	pageSize : 10,//每页显示的记录条数，默认为10 
	pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
	beforePageText : '第',//页数文本框前显示的汉字 
	afterPageText : '页    共 {pages} 页',
	displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
});	

$('#energy_list_data').datagrid({
	height : 'auto',
	nowrap : false,
	striped : true,
	border : true,
	collapsible : false,//是否可折叠的 
	fit : true,//自动大小 
	loadMsg : '数据加载中请稍后……',
	url : ctx+'/cdata/energy/datagrid',
	remoteSort : false,
	fitColums : true,
	checkOnSelect : true,
	//singleSelect : false,//是否单选 
	pagination : true,//分页控件 
	rownumbers : true,//行号 
	columns : [ [ {
		field : 'id',
		title : '编号',
		width : 100,
		hidden: true
	}, {
		field : 'year',
		title : '年度',
		width : 80
	}, {
		field : 'month',
		title : '月份',
		width : 80
	},{
		field : 'grossnum',
		title : '工业总产值（万元）',
		width : 100
	},{
		field : 'addednum',
		title : '工业增加值（万元）',
		width : 100
	},{
		field : 'assets',
		title : '综合能耗量(万吨标准煤)',
		width : 100
	},{
		field : 'assets',
		title : '电耗量（万kwh）',
		width : 100
	},{
		field : 'assets',
		title : '水耗量（立方米）',
		width : 100
	},{
		field : 'assets',
		title : '工业总产值能耗(吨标准煤/万元)',
		width : 100
	},{
		field : 'assets',
		title : '工业总产值电耗(千瓦时/万元)',
		width : 100
	},{
		field : 'assets',
		title : '工业总产值水耗(立方米/万元)',
		width : 100
	},{
		field : 'assets',
		title : '工业增加值能耗(万吨标准煤)',
		width : 100
	},{
		field : 'assets',
		title : '工业增加值电耗(万吨标准煤)',
		width : 100
	},{
		field : 'assets',
		title : '工业增加值水耗(万吨标准煤)',
		width : 100
	}]]
});
//设置分页控件 
var p = $('#energy_list_data').datagrid('getPager');
$(p).pagination({
	pageSize : 10,//每页显示的记录条数，默认为10 
	pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
	beforePageText : '第',//页数文本框前显示的汉字 
	afterPageText : '页    共 {pages} 页',
	displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
});

//水资源
$('#water_list_data').datagrid({
	height : 'auto',
	nowrap : false,
	striped : true,
	border : true,
	collapsible : false,//是否可折叠的 
	fit : true,//自动大小 
	loadMsg : '数据加载中请稍后……',
	url : ctx+'/cdata/water/datagrid',
	remoteSort : false,
	fitColums : true,
	checkOnSelect : true,
	//singleSelect : false,//是否单选 
	pagination : true,//分页控件 
	rownumbers : true,//行号 
	columns : [ [ {
		field : 'id',
		title : '编号',
		width : 100,
		hidden: true
	}, {
		field : 'year',
		title : '年度',
		rowspan:2,
		width : 80
	}, {
		field : 'month',
		title : '月份',
		rowspan:2,
		width : 80
	},{
		title : '取水类别(万立方米)',
		colspan:5
	},{
		title : '用水类别',
		colspan:3
	},{
		field : 'year',
		title : '生产用重复用水量',
		rowspan:2,
		width : 80
	},{
		field : 'year',
		title : '生产用水重复利用率%',
		rowspan:2,
		width : 80
	},{
		field : 'year',
		title : '一级水表计量水量(万立方米)',
		rowspan:2,
		width : 80
	},{
		field : 'year',
		title : '一级水表计量率%',
		rowspan:2,
		width : 80
	},{
		field : 'year',
		title : '万元产值取水量(立方米/万元)',
		rowspan:2,
		width : 80
	},{
		field : 'year',
		title : '万元工业增加值取水量(立方米/万元)',
		rowspan:2,
		width : 80
	},{
		field : 'year',
		title : '废水排放量',
		rowspan:2,
		width : 80
	},{
		field : 'year',
		title : '节约用水量',
		rowspan:2,
		width : 80
	}],[{
		field : 'addednum',
		title : '地表水',
		width : 100
	},{
		field : 'addednum',
		title : '地下水',
		width : 100
	},{
		field : 'addednum',
		title : '自来水',
		width : 100
	},{
		field : 'assets',
		title : '其它水',
		width : 100
	},{
		field : 'assets',
		title : '取水总量',
		width : 100
	},{
		field : 'assets',
		title : '工业用新水',
		width : 100
	},{
		field : 'assets',
		title : '非工业用新水',
		width : 100
	},{
		field : 'assets',
		title : '外供新水',
		width : 100
	}]]
});
//设置分页控件 
var p = $('#water_list_data').datagrid('getPager');
$(p).pagination({
	pageSize : 10,//每页显示的记录条数，默认为10 
	pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
	beforePageText : '第',//页数文本框前显示的汉字 
	afterPageText : '页    共 {pages} 页',
	displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
});	
</script>
</body>
</html>
