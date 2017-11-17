<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品类目列表</title>
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
	<div id="user_window"></div>
</body>
<script type="text/javascript">
var basepath = "${pageContext.request.contextPath}";
	$('#list_data').treegrid({
			title : '商品类目列表',
			fit : true,//自动大小  
			striped : true,
			loadMsg : '数据加载中请稍后……',
			url : '${pageContext.request.contextPath}/category/treeGrid',
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
				width : 150
			},{
				field : 'typename',
				title : '商品类型',
				width : 150
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
			onBeforeExpand : function(row) {
				//动态设置展开查询的url  
				var url = "${pageContext.request.contextPath}/category/treeGrid?parid="
						+ row.treeid;
				$("#list_data").treegrid("options").url = url;
				return true;
			},
			onBeforeLoad : function(row, param) {
				// 此处就是异步加载地所在
				if (row) {
					$(this).treegrid('options').url = '${pageContext.request.contextPath}/category/treeGrid"/>?parid='
							+ row.matId;
				} else {
					$(this).treegrid('options').url = '${pageContext.request.contextPath}/category/treeGrid';
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

		function editFun(id) {
			if (id != undefined) {
				treeGrid.treegrid('select', id);
			}
			var node = treeGrid.treegrid('getSelected');
			if (node) {
				parent.$
						.modalDialog({
							title : '编辑类目',
							width : 500,
							height : 300,
							href : '${pageContext.request.contextPath}/category/editPage?id='
									+ node.id,
							buttons : [ {
								text : '编辑',
								handler : function() {
									parent.$.modalDialog.openner_treeGrid = treeGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
									var f = parent.$.modalDialog.handler
											.find('#form');
									f.submit();
								}
							} ]
						});
			}
		}

		function addFun() {
			var node = $('#list_data').treegrid('getSelected');
			if(node){
				var cate_add_dialog = $('#user_window').dialog({
					title : '新增类目',
					width : 600,
					height : 400,
					closed : false,
					cache : false,
					href : basepath+'/category/create?pid='+node.id,
					modal : true,
					buttons : [ {
						text : '保   存',
						handler : function() {
							$('#cate_form').form('submit',{
								url : basepath+'/category/create?pid='+node.id,
								success : function(data) {
									var result = $.parseJSON(data);
									if (result.success) {
										/* $('#list_data').datagrid('load');
										cate_add_dialog.dialog('close'); */
									}
									cate_add_dialog.dialog('close');
									$("#list_data").treegrid('reload',node.id);
									$("#list_data").treegrid('unselectAll');
									
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
			}else{
				$.messager.show({
					title : '提示',
					msg : '请勾选想要新增的上级类目!',
					timeout : 3000,
					showType : 'slide'
				});
			}
		}
	</script>
</html>
