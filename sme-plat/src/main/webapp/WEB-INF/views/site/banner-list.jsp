<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>站点热点列表</title>
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
.datagrid-row {
	height: 35px;
}
</style>

<script type="text/javascript">
var ctx="${pageContext.request.contextPath}";
</script>
</head>
<body>
	<input type="hidden" id="returnMsg" value="${returnMsg.msg}" />
	<input type="hidden" id="returnSuccess" value="${returnMsg.success}" />
	<div class="easyui-layout" fit="true" border="false">
		<div data-options="region:'north',title:''" style="height: 60px; background: #F4F4F4;">
			<form id="searchForm">
				<table>
				  <tr>
		              <td>标题：</td>
		              <td><input id="title" name="title" value="" class="textbox textbox_indent" style="height: 20px;"/></td>
		              <td>状态：</td>
		              <td>
		              	<select id="status" name="status" class="textbox textbox_indent">
		              		<option value="">----- 请选择-----</option>
		              		<option value="0">启用</option>
		              		<option value="1">关闭</option>
		              	</select>
		              </td>
		          	  <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="searchFunc();">查找</a></td>
		          </tr>                     
				</table>
			</form>                                    
		</div>            
		<div data-options="region:'center',split:false">
			<table id="list_data" cellspacing="0" cellpadding="0"></table>
		</div>
	</div>
	<div id="info_window"></div>
	<script type="text/javascript">
		var ctx = "${pageContext.request.contextPath}";
		$('#list_data').datagrid({
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : ctx+'/banner/datagrid',
			remoteSort : false,
			fitColums : true,
			checkOnSelect : true,
			pagination : true,//分页控件 
			rownumbers : true,//行号 
			frozenColumns : [ [ {
				field : 'ck',
				checkbox : true
			} ] ],
			columns : [ [ {
				field : 'title',
				title : '热点标题',
				width : 300
			}, {
				field : 'classtag',
				title : '分类标识',
				width : 150
			},{
				field : 'img',
				title : '热点图片',
				width : 100
			},{
				field : 'url',
				title : '链接地址',
				width : 150
			},{
				field : 'remark',
				title : '备注信息',
				width : 250
			},{
				field : 'status',
				title : '状态',
				width : 100,
				formatter:function(value,row){
			    	var str = "";
			    	if(value=="0"){
			    		str = "<font style=''>禁用</font>";
			    	}else if(value=="1"){
			    		str = "<font style=''>启用</font>";
			    	}
			    	return str;
				}
			}] ],
			toolbar : [ {
				text : '新增热点',
				iconCls : 'icon-add',
				handler : function() {
					add();
				}
			}, '-', {
				text : '热点编辑',
				iconCls : 'icon-edit',
				handler : function() {
					edit();
				}
			}, '-', {
				text : '热点删除',
				iconCls : 'icon-remove',
				handler : function() {
					del();
				}
			} ]
		});
		//设置分页控件 
		var p = $('#list_data').datagrid('getPager');
		$(p).pagination({
			pageSize : 10,//每页显示的记录条数，默认为10 
			pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
		});

		//编辑
		function edit() {
			var checkedRows = $("#list_data").datagrid('getChecked');
			if (checkedRows.length == 1)
				self.location = ctx+"/banner/form?id="+ checkedRows[0].id;
			else if (checkedRows.length > 1) {
				$.messager.show({
					title : '提示',
					msg : '只能选择一条信息编辑!',
					timeout : 3000,
					showType : 'slide'
				});
			} else if (checkedRows.length < 1) {
				$.messager.show({
					title : '提示',
					msg : '请勾选想要编辑的信息!',
					timeout : 3000,
					showType : 'slide'
				});
			} else {
				$.messager.show({
					title : '提示',
					msg : '请勾选想要编辑的信息!',
					timeout : 3000,
					showType : 'slide'
				});
			}
		}

		//新增
		function add() {
			self.location = "${pageContext.request.contextPath}/banner/form";
		}

		//删除
		function del() {
			var checkedRows = $("#list_data").datagrid('getChecked');
			if (checkedRows.length == 1) {
				$.messager
						.confirm(
								'确认',
								'您是否要删除当前选中的记录？',
								function(r) {
									if (r) {
										$
												.ajax({
													url : '${pageContext.request.contextPath}/banner/delete',
													data : {
														id : checkedRows[0].id
													},
													dataType : 'json',
													success : function(json) {
														if (json.success) {
															$("#list_data")
																	.datagrid(
																			'load');
														}
														$.messager.show({
															title : '提示',
															msg : json.msg
														});
													}
												});
									}
								});
			} else if (checkedRows.length > 1) {
				$.messager.show({
					title : '提示',
					msg : '只能选择一条记录删除!',
					timeout : 3000,
					showType : 'slide'
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

		//搜索
		function searchFunc() {
			var param = {
				title:$("#title").val(),
				status:$("#status").val()
			};
			$("#list_data").datagrid("load", param);
		}
	</script>
</body>
</html>
