<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<title>用户列表</title>
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
	              <th>配置名称：</th>
	              <td><input id="c_name" name="c_name" value=""/></td>
	              <th>配置编码：</th>
	              <td><input id="c_code" name="c_code" value=""/></td>
	          	  <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="searchFunc();">查找</a></td>
	          </tr>                     
			</table>
		</form>                                    
	</div>            
	
	<div data-options="region:'center',split:false">
		<table id="list_data" cellspacing="0" cellpadding="0">
				</table>
	</div>
</div>
<div id="config_window"></div>
<script type="text/javascript">
var basepath = "${pageContext.request.contextPath}";
$('#list_data').datagrid({
	height : 'auto',
	nowrap : false,
	striped : true,
	border : true,
	collapsible : false,//是否可折叠的 
	fit : true,//自动大小 
	loadMsg : '数据加载中请稍后……',
	url : basepath+'/config/datagrid',
	remoteSort : false,
	fitColums : true,
	checkOnSelect : true,
	singleSelect : true,//是否单选 
	pagination : true,//分页控件 
	rownumbers : true,//行号 
	frozenColumns : [ [ {
		field : 'ck',
		checkbox : true
	} ] ],
	columns : [ [ {
		field : 'code',
		title : '配置编码',
		width : 150
	},{
		field : 'name',
		title : '配置名称',
		width : 150
	},{
		field : 'configvalue',
		title : '配置值',
		width : 200
	}] ],
	
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
	} ],
	onClickRow:function () {
		
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

function addFun() {
	var user_window_dialog = $('#user_window').dialog({
		title : '新增系统用户',
		width : 600,
		height : 400,
		closed : false,
		cache : false,
		href : basepath+'/user/dataform',
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
							user_window_dialog.dialog('close');
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
function editFun() {
	var checkedRows = $("#list_data").datagrid('getChecked');
	if (checkedRows.length == 1) {
		var user_window_dialog = $('#user_window').dialog({
			title : '系统用户信息编辑',
			width : 600,
			height : 400,
			closed : false,
			cache : false,
			href : basepath+'/user/dataform?id='+checkedRows[0].id,
			modal : true,
			buttons : [ {
				text : '保   存',
				handler : function() {
					$('#user_form').form('submit',{
						url : basepath+'/user/update',
						success : function(data) {
							var result = $.parseJSON(data);
							if (result.success) {
								$('#list_data').datagrid('load');
								user_window_dialog.dialog('close');
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
		$.messager.confirm('确认', '您是否要删除当前选中的用户？', function(r) {
			if(r) {
				var account = checkedRows[0].account;
				if (account=="admin"){
					$.messager.show({
						title : '提示',
						msg : '系统管理员帐户[admin]不允许删除!',
						timeout : 3000,
						showType : 'slide'
					});
					return;
				}
				
				$.ajax({
					url : basepath+'/user/delete',
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
		name:$("#c_name").val(),
		code:$("#c_code").val()
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