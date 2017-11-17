<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>站点信息栏目列表</title>
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
</head>

<body>
	<table id="list_data" cellspacing="0" cellpadding="0">
		
	</table>
	<div id="channel_window"></div>
</body>
<script type="text/javascript">
var basepath = "${pageContext.request.contextPath}";
	$('#list_data').treegrid({
			fit : true,//自动大小  
			striped : true,
			loadMsg : '数据加载中请稍后……',
			url : basepath+'/channel/treegrid',
			checkOnSelect:true,
			selectOnCheck:true,
			idField:'id',
			treeField:'text',
			parentField : 'parentId',
			rownumbers : true,//行号  
			columns : [ [{
				field : 'id',
				title : '编号',
				width : 150,
				checkbox : true
			},{
				field : 'text',
				title : '类目名称',
				width : 250
			},{
				field : 'templet',
				title : '栏目模板',
				width : 150
			},{
				field : 'url',
				title : '栏目地址',
				width : 150,
				formatter:function(value,row){
			    	var str = "/channel-"+row.id+".html";
			    	return str;
				}
			}] ],
			toolbar : [ {
				text : '添加根目录',
				iconCls : 'icon-add',
				handler : function() {
					addRootFun();
				}
			}, '-',{
				text : '添加子目录',
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
			onBeforeExpand : function(row) {
				//动态设置展开查询的url  
				//var url = "${pageContext.request.contextPath}/category/treeGrid?parid="+ row.treeid;
				//$("#list_data").treegrid("options").url = url;
				return true;
			},
			onBeforeLoad : function(row, param) {
				// 此处就是异步加载地所在
				if (row) {
					//$(this).treegrid('options').url = '${pageContext.request.contextPath}/category/treeGrid"/>?parid='+ row.matId;
				} else {
					//$(this).treegrid('options').url = '${pageContext.request.contextPath}/category/treeGrid';
				}
			}
		});
		

		function deleteFun(id) {
			if (id != undefined) {
				treeGrid.treegrid('select', id);
			}
			var node = treeGrid.treegrid('getSelected');
			if (node) {
				parent.$.messager
						.confirm(
								'询问',
								'您是否要删除当前类目？',
								function(b) {
									if (b) {
										parent.$.messager.progress({
											title : '提示',
											text : '数据处理中，请稍后....'
										});
										$
												.post(
														'${pageContext.request.contextPath}/category/delete',
														{
															id : node.id
														},
														function(result) {
															if (result.success) {
																parent.$.messager
																		.alert(
																				'提示',
																				result.msg,
																				'info');
																treeGrid
																		.treegrid('reload');
																parent.layout_west_tree
																		.tree('reload');
															}
															parent.$.messager
																	.progress('close');
														}, 'JSON');
									}
								});
			}
		}

		function editFun() {
			var node = $('#list_data').treegrid('getSelected');
			if(node){
				location.href=basepath+'/channel/form?id='+node.id;
			}
		}
		
		function addRootFun() {
			location.href=basepath+'/channel/form';
		}
		
		function addSubFun() {
			var node = $('#list_data').treegrid('getSelected');
			if(node){
				location.href=basepath+'/channel/form?pid='+node.id;
			}
		}
	</script>
</html>
