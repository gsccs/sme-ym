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
<%-- <script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/syUtil.js"
	charset="utf-8"></script> --%>
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
	              <th>用户名称：</th>
	              <td><input id="title" name="title" value=""/></td>
	              <th>登录帐号：</th>
	              <td><input id="account" name="account" value=""/></td>
	              <th>帐号类型：</th>
	              <td>
	              	<td>
	              	<select id="usertype" name="usertype">
	              		<option value="">----- 请选择-----</option>
	              		<option value="G">行政服务机构</option>
	              		<option value="S">社会服务单位</option>
	              		<option value="C">注册企业</option>
	              	</select>
	              </td>
	              <th>状态：</th>
	              <td>
	              	<select id="state" name="state">
	              		<option value="">----- 请选择-----</option>
	              		<option value="1">启用</option>
	              		<option value="0">禁用</option>
	              	</select>
	              </td>
	          	  <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="searchFunc();">查找</a></td>
	              <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="clearSearch();">清空</a></td>
	          </tr>                     
			</table>
		</form>                                    
	</div>            
	
	<div data-options="region:'center',split:false">
		<div class="easyui-layout" fit="true" border="false">
			<div data-options="region:'west',title:''" style="">
				<table id="list_data" cellspacing="0" cellpadding="0">
				</table>
			</div>
			<div data-options="region:'east'" style="width:350px;">
				<table id="auth_list_data" cellspacing="0" cellpadding="0"></table>
			</div>
		</div>
	</div>
	</div>
</div>
<div id="user_window"></div>
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
	url : basepath+'/user/datagrid',
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
		field : 'account',
		title : '登录帐号',
		width : 150
	},{
		field : 'title',
		title : '用户名',
		width : 150
	},{
		field : 'orgname',
		title : '组织机构',
		width : 200
	},{
		field : 'usertype',
		title : '注册类型',
		width : 100,
		formatter:function(value,row){
	    	var str = "";
	    	if(value=="G"){
	    		str = "<font style=''>行政部门</font>";
	    	}else if(value=="S"){
	    		str = "<font style=''>社会机构</font>";
	    	}else if(value=="C"){
	    		str = "<font style=''>注册企业</font>";
	    	}
	    	 return str;
		}
	},{
		field : 'locked',
		title : '帐号状态',
		width : 100,
		formatter:function(value,row){
	    	var str = "";
	    	if(value=="false"){
	    		str = "<font style=''>锁定</font>";
	    	}else{
	    		str = "<font style=''>正常</font>";
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
		text : '更改密码',
		iconCls : 'icon-edit',
		handler : function() {
			changePwdFun();
		}
	}, '-', {
		text : '删除',
		iconCls : 'icon-remove',
		handler : function() {
			delFun();
		}
	}, '-', {
		text : '授权',
		iconCls : 'icon-remove',
		handler : function() {
			authFun();
		}
	} ],
	onClickRow:function () {
		$('#auth_list_data').datagrid('unselectAll');
        var userrow = $('#list_data').datagrid("getSelected");
        var userid = userrow.id;
        if (userid){
        	$.ajax({
				url : basepath+'/user/userroles?userid='+userid,
				type:'POST',
				dataType : 'json',
				success : function(roleids) {
					console.log("roleids:"+roleids);
					if(roleids){
						var rows = $("#auth_list_data").datagrid("getRows"); 
						for(var i=0;i<rows.length;i++){
							var rolekey = rows[i].rolecode;
							for(var r=0;r<roleids.length;r++){
								if(rolekey == roleids[r]){
									$('#auth_list_data').datagrid('selectRow',i);	
								}
							}
						}
					}
				}
			});
		}
    }
});
//设置分页控件 
var p = $('#list_data').datagrid('getPager');
$(p).pagination({
	pageSize : 20,//每页显示的记录条数，默认为10 
	pageList : [ 20, 40, 50 ],//可以设置每页记录条数的列表 
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


/*修改密码*/
function changePwdFun() {
	var checkedRows = $("#list_data").datagrid('getChecked');
	if (checkedRows.length == 1) {
		var user_window_dialog = $('#user_window').dialog({
			title : '系统用户密码修改',
			width : 400,
			height : 200,
			closed : false,
			cache : false,
			href : basepath+'/user/changepwd?id='+checkedRows[0].id,
			modal : true,
			buttons : [ {
				text : '保   存',
				handler : function() {
					$('#user_pwd_form').form('submit',{
						url : basepath+'/user/changepwd',
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

/*授权*/
function authFun() {
	var checkedRows = $("#list_data").datagrid('getChecked');
	if (checkedRows.length == 1) {
		var roleRows = $("#auth_list_data").datagrid('getSelections');
		if (!roleRows || roleRows.length<=0){
			$.messager.show({
				title : '提示',
				msg : '请勾选想要分配的角色!',
				timeout : 3000,
				showType : 'slide'
			});
			return;
		}else{
			var roleidstr="";
			for(var i=0;i<roleRows.length;i++){
				roleidstr = roleidstr+roleRows[i].id+",";
			}
			$.ajax({
				url : basepath+'/user/userauth',
				data : "userid="+checkedRows[0].id+"&roleids="+roleidstr,
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
	} else if(checkedRows.length > 1) {
		$.messager.show({
			title : '提示',
			msg : '只能选择一个用户进行操作!',
			timeout : 3000,
			showType : 'slide'
		});
	}else {
		$.messager.show({
			title : '提示',
			msg : '请选择想要操作的用户!',
			timeout : 3000,
			showType : 'slide'
		});
	}
}		



$('#auth_list_data').datagrid({
	height : 'auto',
	nowrap : false,
	striped : true,
	border : true,
	collapsible : false,//是否可折叠的 
	fit : true,//自动大小 
	loadMsg : '数据加载中请稍后……',
	url : basepath+'/role/datagrid',
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
		field : 'rolecode',
		title : '角色标识',
		width : 150
	},{
		field : 'description',
		title : '角色描述',
		width : 150
	}] ]
});
//设置分页控件 
var p = $('#auth_list_data').datagrid('getPager');
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
		account:$("#account").val(),
		orgid:$("#orgid").val(),
		usertype:$("#usertype").val()
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