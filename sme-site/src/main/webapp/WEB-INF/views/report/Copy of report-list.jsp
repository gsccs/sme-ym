<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>数据上报_企业管理后台_玉门市中小企业公共服务平台</title>
    <link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/home/css/webindex.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/home/css/admin.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/home/css/main.css" />
<link id="changbj" rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/easyui/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/easyui/themes/icon.css" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/site/js/easyui-lang-zh_CN.js"></script>
<link href="${pageContext.request.contextPath}/resources/home/css/Site.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	var ctx="${pageContext.request.contextPath}";
	$(function () {
		$("#list_data").datagrid({
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : '/cp/report/list',
			remoteSort : false,
			fitColums : true,
			checkOnSelect : true,
			singleSelect : false,//是否单选 
			pagination : true,//分页控件 
			rownumbers : true,//行号
			idField: 'id',
			columns : [ [ {
				field : 'id',
				title : '编号',
				width : 150,
				checkbox : true
			}, {
				field : 'title',
				title : '报表名称',
				width : 200
			},{
				field : 'cyc',
				title : '上报周期',
				width : 150
			}, {
				field : 'svgtitle',
				title : '上报部门',
				width : 150
			}, {
				field : 'status',
				title : '状态',
				width : 150
			}, {
				field : 'remark',
				title : '备注说明',
				width : 150
			}  ] ],
			toolbar : [ {
				text : '上报数据',
				iconCls : 'icon-add',
				handler : function() {
					report();
				}
			}],
			pageSize : 15,
			pageList : [10, 15, 20]
		});
		var p = $('#list_data').datagrid('getPager');
		$(p).pagination({
			pageSize : 10,//每页显示的记录条数，默认为10 
			pageList : [10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
	});
	
	//记录删除
	function report(){
		var checkedRows = $("#list_data").datagrid('getChecked');
		if(checkedRows.length >=1){
			location.href= ctx+'/cp/report/form?reportid='+checkedRows[0].id;
		}
	}
	
	//记录删除
	function report_(){
		var checkedRows = $("#list_data").datagrid('getChecked');
		if(checkedRows.length >=1){
			var ids =  new Array();
			for (var i=0;i<checkedRows.length;i++){
				ids.push(checkedRows[i].id);
			}
			$.messager.confirm('确   认', '您是否要删除当前选中的记录？', function(r) {
				if(r) {
					$.ajax({
						url : basepath+'/monitorval/delete',
						data : {"ids":ids.toString()},
						type:'POST',
						dataType : 'json',
						success : function(json) {
							if (json.success) {
								$("#list_data").datagrid('load');
							}
							$.messager.show({
								title : '提示',
								msg : json.msg
							});
						}
					});
				}
			});
		} else {
			$.messager.show({
				title : '提示',
				msg : '请勾选想要删除的记录!',
				timeout : 3000,
				showType : 'slide'
			});
		}
	}
</script>
<style type="text/css">
.datagrid-row {
	height: 50px;
}
</style>
</head>
<body>

<div class="admin_right">
    <div class="indent_title">
        <img src="${pageContext.request.contextPath}/resources/home/images/t_05.jpg" width="5" height="17" class="fl"><span>数据上报</span>
    </div>
    <div class="clear" style="height: 10px; line-height: 10px;">
    </div>
    <div class="Info_top">
    	<form id="searchForm">
				<table>
				  <tr>
		              <td>报表名称：</td>
		              <td><input id="title" name="title" value="" class="easyui-validatebox textbox textbox_indent"/></td>
		              <td>报表状态：</td>
		              <td><select id="status" name="status" style="width: 150px;"></select></td>
		          	  <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="searchFunc();">查找</a></td>
		          </tr>                     
				</table>
		</form>
    </div>
    <div class="Info_center" id="Note">
        <div class="clear"></div>
        <div id="data">
        	<table id="list_data" class="easyui-datagrid" style="width:1000px;height:400px" data-options="singleSelect:true,collapsible:true">
			</table>
        </div>
    </div>
    <!-- <div class="Info_bottom"></div> -->
</div>
<script type="text/javascript">
var ifm= window.top.document.getElementById("iframe0");   
var subWeb = document;  
if(ifm != null && document != null) {
   ifm.height = document.body.height;
   ifm.width = document.body.scrollWidth;
}


function searchFunc(){
	var param = {
		title:$("#title").val(),
		svgid:$("#svgid").val()
	};
	$("#list_data").datagrid("load", param);
}
</script>
</body></html>