<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<title>消息列表</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
<style type="text/css">
th{
	font-size: 12px;
  	padding: 5px 10px;
}

.datagrid-header td{
	text-align: center;
}
</style>
</head>
<body>
<div class="easyui-layout" fit="true" border="false">
	<div data-options="region:'north',title:''" style="height: 50px; background: #F4F4F4;">
		<form id="searchForm">
			<table>
			  <tr>
	              <th>消息标题：</th>
	              <td><input id="title" name="title" value=""/></td>
	              <th>消息状态：</th>
	              <td>
	              	<td>
	              	<select id="status" name="status">
	              		<option value="">----- 请选择-----</option>
	              		<option value="0">未读</option>
	              		<option value="1">已读</option>
	              	</select>
	              </td>
	          	  <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="searchFunc();">查找</a></td>
	              <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="clearSearch();">清空</a></td>
	          </tr>                     
			</table>
		</form>                                    
	</div>            
	
	<div data-options="region:'center',split:false">
		<div id="tt" class="easyui-tabs" fit="true" style="" >  
		     <div title="接受消息" style="">  
		          <table id="rece_list_data" cellspacing="0" cellpadding="0"></table> 
		      </div>  
		      <div title="发送消息" style="">  
		          <table id="send_list_data" cellspacing="0" cellpadding="0"></table>
		     </div>  
		 </div> 
	</div>
</div>
<div id="msg_window"></div>
<script type="text/javascript">
var basepath = "${pageContext.request.contextPath}";
var selectedTab;
$('#tt').tabs({   
    onSelect:function(title){
    	selectedTab = title;
    }   
}); 
$('#send_list_data').datagrid({
	height : 'auto',
	nowrap : false,
	striped : true,
	border : true,
	collapsible : false,//是否可折叠的 
	fit : true,//自动大小 
	loadMsg : '数据加载中请稍后……',
	url : basepath+'/msg/senddg',
	remoteSort : false,
	fitColums : true,
	checkOnSelect : true,
	singleSelect : true,//是否单选 
	pagination : true,//分页控件 
	rownumbers : true,//行号 
	columns : [ [ {
		field : 'id',
		title : '编号',
		width : 150,
		checkbox : true
	},{
		field : 'title',
		title : '标题',
		width : 150
	},{
		field : 'receiver',
		title : '接收者',
		width : 150
	},{
		field : 'content',
		title : '内容',
		width : 250
	},{
		field : 'addtimestr',
		title : '时间',
		width : 100
	},{
		field : 'status',
		title : '状态',
		width : 100,
		formatter:function(value,row){
	    	var str = "";
	    	if(value=="1"){
	    		str = "<font style=''>已读</font>";
	    	}else{
	    		str = "<font style=''>未读</font>";
	    	}
	    	 return str;
		}
	} ] ],
	toolbar : [ {
		text : '添加',
		iconCls : 'icon-add',
		handler : function() {
			addFun();
		}
	}, '-', {
		text : '修改',
		iconCls : 'icon-edit',
		handler : function() {
			editFun();
		}
	}, '-', {
		text : '删除',
		iconCls : 'icon-remove',
		handler : function() {
			delFun();
		}
	}]
});
//设置分页控件 
var p = $('#send_list_data').datagrid('getPager');
$(p).pagination({
	pageSize : 20,//每页显示的记录条数，默认为10 
	pageList : [ 20, 40, 50 ],//可以设置每页记录条数的列表 
	beforePageText : '第',//页数文本框前显示的汉字 
	afterPageText : '页    共 {pages} 页',
	displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
});		

function addFun() {
	var msg_window_dialog = $('#msg_window').dialog({
		title : '新增消息',
		width : 600,
		height : 400,
		closed : false,
		cache : false,
		href : basepath+'/msg/form',
		modal : true,
		buttons : [ {
			text : '保   存',
			handler : function() {
				$('#user_form').form('submit',{
					url : basepath+'/user/create',
					success : function(data) {
						var result = $.parseJSON(data);
						if (result.success) {
							$('#list_data').datagrid('load');
							msg_window_dialog.dialog('close');
						}
						$.messager.show({
							title : '提示',
							msg : result.msg,
							timeout : 3000,
							showType : 'slide'
						});
					}
				});
			}
		} ]
	});
}


//记录删除
function delFun(){
	var checkedRows = $("#list_data").datagrid('getChecked');
	if(checkedRows.length == 1) {
		$.messager.confirm('确认', '您是否要删除当前选中的记录？', function(r) {
			if(r) {
				$.ajax({
					url : basepath+'/msg/delete',
					data : {
						id : checkedRows[0].id
					},
					type:'GET',
					dataType : 'json',
					success : function(json) {
						if (json.success) {
							$("#send_list_data").datagrid('load');
						}
						$.messager.show({
							title : '提示',
							msg : json.msg
						});
					}
				});
			}
		});
	} else if(checkedRows.length > 1) {
		$.messager.show({
			title : '提示',
			msg : '只能选择一个记录删除!',
			timeout : 3000,
			showType : 'slide'
		});
	}else {
		$.messager.show({
			title : '提示',
			msg : '请勾选想要删除的记录!',
			timeout : 3000,
			showType : 'slide'
		});
	}
}


$('#rece_list_data').datagrid({
	height : 'auto',
	nowrap : false,
	striped : true,
	border : true,
	collapsible : false,//是否可折叠的 
	fit : true,//自动大小 
	loadMsg : '数据加载中请稍后……',
	url : basepath+'/msg/recedg',
	remoteSort : false,
	fitColums : true,
	checkOnSelect : true,
	//singleSelect : false,//是否单选 
	pagination : true,//分页控件 
	rownumbers : true,//行号 
	columns : [ [ {
		field : 'id',
		title : '编号',
		width : 50,
		checkbox : true
	},{
		field : 'title',
		title : '标题',
		width : 150
	},{
		field : 'sender',
		title : '发送者',
		width : 150
	},{
		field : 'content',
		title : '内容',
		width : 250
	},{
		field : 'addtimestr',
		title : '时间',
		width : 100
	}] ],

	toolbar : [ {
		text : '查看',
		iconCls : 'icon-add',
		handler : function() {
			viewFun();
		}
	}]
});
//设置分页控件 
var p = $('#rece_list_data').datagrid('getPager');
$(p).pagination({
	pageSize : 10,//每页显示的记录条数，默认为10 
	pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
	beforePageText : '第',//页数文本框前显示的汉字 
	afterPageText : '页    共 {pages} 页',
	displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
});

function searchFunc(){
	var paramobj={
		title:$("#title").val(),
		status:$("#status").val()
	};
	if (selectedTab=="接受消息"){
		$("#rece_list_data").datagrid("load",paramobj);
	}else{
		$("#send_list_data").datagrid("load",paramobj);
	}
}

//点击清空按钮出发事件
function clearSearch() {
    $("#list_data").datagrid("load", {});
    $("#searchForm").find("input").val("");
}				
	</script>
</body>
</html>