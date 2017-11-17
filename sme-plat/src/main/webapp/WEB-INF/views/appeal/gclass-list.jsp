<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>服务分类列表</title>
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
<div id="dd"></div>
	<script type="text/javascript">
		$('#list_data').treegrid({
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : '${pageContext.request.contextPath}/sclass/datagrid',
			idField:'id',
			treeField:'text',
			parentField : 'parentId',
			rownumbers : true,//行号 
			frozenColumns : [ [ {
				field : 'ck',
				checkbox : true
			} ] ],
			columns : [ [{
				field : 'text',
				title : '分类名称',
				width : 250
			}] ],
			toolbar : [ {
				text : '添加',
				iconCls : 'icon-add',
				handler : function() {
					add();
				}
			}, '-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					edit();
				}
			}, '-', {
				text : '删除',
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
		/*onBeforeRefresh:function(){
		    $(this).pagination('loading');
		    alert('before refresh');
		    $(this).pagination('loaded');
		}*/
		});

		//编辑
		function edit(){
			 var checkedRows = $("#list_data").datagrid('getChecked');
			 if(checkedRows.length == 1) {
				 var seller_edit_dialog = $('#dd').dialog({
						title: '编辑',
					    width: 600,
					    height:400,
					    closed: false,
					    cache: false,
					    href: '${pageContext.request.contextPath}/sclass/edit?id='+checkedRows[0].id,
					    modal: true,
					    buttons : [ {
							text : '保存',
							iconCls : 'icon-add',
							handler : function() {
								$('#seller_editForm').form('submit', {
									url : '${pageContext.request.contextPath}/sclass/edit',
									type: 'POST',
									success : function(data) {
										var json = $.parseJSON(data);
											if (json.success) {
												$('#list_data').datagrid('load');
												seller_edit_dialog.dialog('close');
											}
											$.messager.show({
												title : '提示',
												msg : json.msg,
												timeout : 3000,
												showType : 'slide'
											});
									}
								});
							}
						} ]
					});
			 }else if(checkedRows.length > 1) {
				$.messager.show({
					title : '提示',
					msg : '只能选择一条信息编辑!',
					timeout : 3000,
					showType : 'slide'
				});
			}else if(checkedRows.length < 1){
				$.messager.show({
					title : '提示',
					msg : '请勾选想要编辑的信息!',
					timeout : 3000,
					showType : 'slide'
				});
			}else {
				$.messager.show({
					title : '提示',
					msg : '请勾选想要编辑的信息!',
					timeout : 3000,
					showType : 'slide'
				});
			}
		}
		
		//新增
		 function add(){
			 var seller_edit_dialog = $('#dd').dialog({
					title: '新增',
				    width: 600,
				    height:400,
				    closed: false,
				    cache: false,
				    href: '${pageContext.request.contextPath}/sclass/add',
				    modal: true,
				    buttons : [ {
						text : '保存',
						iconCls : 'icon-add',
						handler : function() {
							$('#seller_editForm').form('submit', {
								url : '${pageContext.request.contextPath}/sclass/add',
								type: 'POST',
								success : function(data) {
									var json = $.parseJSON(data);
										if (json.success) {
											$('#list_data').datagrid('load');
											seller_edit_dialog.dialog('close');
										}
										$.messager.show({
											title : '提示',
											msg : json.msg,
											timeout : 3000,
											showType : 'slide'
										});
								}
							});
						}
					} ]
				});
			
		} 
	
		//删除
		function del(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			if(checkedRows.length == 1) {
				$.messager.confirm('确认', '您是否要删除当前选中的记录？', function(r) {
					if(r) {
						$.ajax({
							url : '${pageContext.request.contextPath}/sclass/delete',
							data : {
								id : checkedRows[0].id
							},
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
					msg : '只能选择一条记录删除!',
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
		
		//搜索
		 function doSearch(){
			 var param = $("#searchForm").serialize();
				var noticeobj={
						parids:$("#parids").val()
				};
		        $("#list_data").datagrid("load",noticeobj);
	        }
	</script>
</body>
</html>
