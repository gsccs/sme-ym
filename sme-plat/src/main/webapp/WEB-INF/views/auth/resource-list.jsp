<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<title></title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/syUtil.js"
	charset="utf-8"></script>
<style type="text/css">
th {
	font-size: 12px;
	padding: 5px 10px;
}

.datagrid-header td {
	text-align: center;
}
</style>
</head>
<body>
	<div class="easyui-layout" fit="true" border="false">
		<div data-options="region:'north'" style="height: 40px; background: #F4F4F4;">
			<form id="searchForm">
				<table>
					<tr>
						<th>资源名称：</th>
						<td><input id="resourcename" name="resourcename" value="" /></td>
						<td><a class="easyui-linkbutton" href="javascript:void(0);"
							onclick="searchFunc();">查找</a></td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'center',split:false">
			<table id="list_data" cellspacing="0" cellpadding="0">
			</table>
		</div>
	</div>
	<div id="resource_window"></div>

<script type="text/javascript">
var basepath = "${pageContext.request.contextPath}";
$('#list_data').treegrid({
	height : 'auto',
	nowrap : false,
	striped : true,
	border : true,
	collapsible : false,//是否可折叠的 
	fit : true,//自动大小 
	loadMsg : '数据加载中请稍后……',
	url : basepath+'/resource/treegrid',
	remoteSort : false,
	fitColums : true,
	checkOnSelect : true,
	//singleSelect : false,//是否单选 
	pagination : true,//分页控件 
	rownumbers : true,//行号 
	idField:'id',
	treeField:'text',
	parentField : 'parentId',
	columns : [ [ {
		field : 'id',
		title : '编号',
		width : 150,
		checkbox : true
	},{
		field : 'text',
		title : '资源名称',
		width : 150
	},{
		field : 'type',
		title : '资源类型',
		width : 150
	},{
		field : 'url',
		title : '资源路径',
		width : 150,
		hidden:true
	},{
		field : 'permission',
		title : '权限字符串',
		width : 150,
		hidden:true
	} ] ],
	toolbar : [ {
		text : '增加根节点',
		iconCls : 'icon-add',
		handler : function() {
			addRootFun();
		}
	},{
		text : '增加子节点',
		iconCls : 'icon-add',
		handler : function() {
			addSubFun();
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
	} ],
	onLoadSuccess: function () {
		$('#list_data').treegrid('collapseAll')
	}
});
//设置分页控件 
var p = $('#list_data').datagrid('getPager');
$(p).pagination({
	pageSize : 10,//每页显示的记录条数，默认为10 
	pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
	beforePageText : '第',//页数文本框前显示的汉字 
	afterPageText : '页    共 {pages} 页',
	displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
});		

function addRootFun() {
	var resource_add_dialog = $('#resource_window').dialog({
		title : '新增系统资源',
		width : 600,
		height : 400,
		closed : false,
		cache : false,
		href : basepath+'/resource/dataform',
		modal : true,
		buttons : [ {
			text : '保   存',
			handler : function() {
				$('#resource_form').form('submit',{
					url : basepath+'/resource/create',
					success : function(data) {
						var result = $.parseJSON(data);
						if (result.success) {
							$('#list_data').datagrid('load');
							resource_window_dialog.dialog('close');
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

/*编辑*/
function addSubFun() {
	var checkedRows = $("#list_data").datagrid('getChecked');
	if (checkedRows.length == 1) {
		var resource_window_dialog = $('#resource_window').dialog({
			title : '增加系统资源',
			width : 600,
			height : 400,
			closed : false,
			cache : false,
			href : basepath+'/resource/dataform?parentId='+checkedRows[0].id,
			modal : true,
			buttons : [ {
				text : '保   存',
				handler : function() {
					$('#resource_form').form('submit',{
						url : basepath+'/resource/create',
						success : function(data) {
							var result = $.parseJSON(data);
							if (result.success) {
								$('#list_data').datagrid('load');
								resource_window_dialog.dialog('close');
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
	} else if(checkedRows.length > 1) {
		$.messager.show({
			title : '提示',
			msg : '只能选择一个目录!',
			timeout : 3000,
			showType : 'slide'
		});
	}else {
		$.messager.show({
			title : '提示',
			msg : '请选择要增加资源的父目录!',
			timeout : 3000,
			showType : 'slide'
		});
	}
}		


/*编辑*/
function editFun() {
	var checkedRows = $("#list_data").datagrid('getChecked');
	if (checkedRows.length == 1) {
		var resource_window_dialog = $('#resource_window').dialog({
			title : '资源修改',
			width : 600,
			height : 400,
			closed : false,
			cache : false,
			href : basepath+'/resource/dataform?id='+checkedRows[0].id,
			modal : true,
			buttons : [ {
				text : '保   存',
				handler : function() {
					$('#resource_form').form('submit',{
						url : basepath+'/resource/update',
						success : function(data) {
							var result = $.parseJSON(data);
							if (result.success) {
								$('#list_data').datagrid('load');
								resource_window_dialog.dialog('close');
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

//记录删除
function delFun(){
	var checkedRows = $("#list_data").datagrid('getChecked');
	if(checkedRows.length == 1) {
		$.messager.confirm('确认', '您是否要删除当前选中的记录？', function(r) {
			if(r) {
				$.ajax({
					url : basepath+'/resource/delete',
					data : {
						id : checkedRows[0].id
					},
					type:'GET',
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


function searchFunc(){
	var paramobj={
		name:$("#resourcename").val(),
	};
    $("#list_data").datagrid("load",paramobj);
}


//点击清空按钮出发事件
function clearSearch() {
    $("#list_data").datagrid("load", {});
    $("#searchForm").find("input").val("");
}				
	</script>
</body>
</html>