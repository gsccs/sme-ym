<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/site/js/putud.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/site/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/site/js/jquery.soChange.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/site/js/js.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/site/js/Common.js"></script>

<link href="${pageContext.request.contextPath}/resources/home/css/Site.css" rel="stylesheet" type="text/css" />
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
			url : '/cp/appeal/topic/datagrid',
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
				title : '事项标题',
				width : 200
			},{
				field : 'svgtitle',
				title : '行政单位',
				width : 150
			}, {
				field : 'addtimestr',
				title : '指定完成时间',
				width : 150
			}, {
				field : 'remark',
				title : '备注',
				width : 300
			}  ] ],
			toolbar : [ {
				text : '提交申请',
				iconCls : 'icon-edit',
				handler : function() {
					addFun();
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
	
	
	
	/*编辑*/
	function addFun() {
		var checkedRows = $("#list_data").datagrid('getChecked');
		if (checkedRows.length == 1) {
			location.href= ctx+'/cp/appeal/form?topicid='+checkedRows[0].id;
		} else if(checkedRows.length > 1) {
			$.messager.show({
				title : '提示',
				msg : '只能选择一条记录编辑!',
				timeout : 3000,
				showType : 'slide'
			});
		}else {
			$.messager.show({
				title : '提示',
				msg : '请选择要编辑的记录!',
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
        <img src="${pageContext.request.contextPath}/resources/home/images/t_05.jpg" width="5" height="17" class="fl"><span>行政诉求</span>
    </div>
    <div class="clear" style="height: 10px; line-height: 10px;">
    </div>
    <div class="Info_top">
    	<form id="searchForm">
			<table>
				  <tr>
		              <td>事项标题：</td>
		              <td><input id="title" name="title" value="" maxlength="100"/></td>
		              <td>行政单位：</td>
		              <td>
		              <select id="svgid" name="svgid" style="width: 150px;">
		              	<option value="">-------请选择-----</option>
		              </select></td>
		          	  <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="searchFunc();">查找</a></td>
		          </tr>                     
			</table>
		</form>
    </div>
    <div class="Info_center" id="Note">
        <div class="clear"></div>
        <div id="data">
        	<table id="list_data" class="easyui-datagrid" style="width:1000px;height:500px" data-options="singleSelect:true,collapsible:true">
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