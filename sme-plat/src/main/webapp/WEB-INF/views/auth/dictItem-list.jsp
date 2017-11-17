<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>服务需求列表</title>
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
    <div style="height:100%">
	<table id="list_data" cellspacing="0" cellpadding="0">
		<thead>
			<tr>
				<th field="groupTitle" width="100">数据表名称</th>
				<th field="title" width="100">数据项</th>
			</tr>
		</thead>
	</table>
	</div>
	<div id="dd"></div>
	<script type="text/javascript">
		$('#list_data').datagrid({
			title : '列表',
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : '${pageContext.request.contextPath}/dictItem/datagrid',
			remoteSort : false,
			fitColums : true,
			checkOnSelect : true,
			//singleSelect : false,//是否单选 
			//pagination : true,//分页控件 
			rownumbers : true,//行号 
			frozenColumns : [ [ {
				field : 'ck',
				checkbox : true
			} ] ],
			toolbar : [ 
	 		            {
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
			pageSize : 15,//每页显示的记录条数，默认为10 
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
					    height:300,
					    closed: false,
					    cache: false,
					    href: '${pageContext.request.contextPath}/dictItem/edit?id='+checkedRows[0].id,
					    modal: true,
					    buttons : [ {
							text : '保存',
							iconCls : 'icon-add',
							handler : function() {
								$('#seller_editForm').form('submit', {
									url : '${pageContext.request.contextPath}/dictItem/edit',
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
				    height:300,
				    closed: false,
				    cache: false,
				    href: '${pageContext.request.contextPath}/dictItem/add',
				    modal: true,
				    buttons : [ {
						text : '保存',
						iconCls : 'icon-add',
						handler : function() {
							$('#seller_editForm').form('submit', {
								url : '${pageContext.request.contextPath}/dictItem/add',
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
							url : '${pageContext.request.contextPath}/dictItem/delete',
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
	</script>
</body>
</html>
