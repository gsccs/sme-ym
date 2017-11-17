<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>友情链接列表</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<div class="easyui-layout" fit="true" border="false">
		<div data-options="region:'north',title:''" style="height: 60px; background: #F4F4F4;">
			<form id="searchForm">
				<table>
				  <tr>
		              <td>链接标题：</td>
		              <td><input id="name" name="name" value="" class="textbox textbox_indent" style="height: 20px;"/></td>
		              <td>链接分类：</td>
		              <td>
		              	<select id="parid" name="parid">
		              		<option value="">----请选择----</option>
		              		<c:forEach items="${classlist }" var="lclass">
		              		<option value="${lclass.id }">${lclass.name }</option>
		              		</c:forEach>
		              	</select>
		              </td>
		               <td>链接类型：</td>
		              <td>
		              	<select id="type" name="type">
		              		<option value="">----请选择----</option>
		              		<option value="0">文本链接</option>
		              		<option value="1">图片链接</option>
		              		<option value="2">下拉链接</option>
		              	</select>
		              </td>
		              <td>链接状态：</td>
		              <td>
		              	<select id="status" name="status" class="textbox textbox_indent">
		              		<option value="">----- 请选择-----</option>
		              		<option value="0">启用</option>
		              		<option value="-1">禁用</option>
		              	</select>
		              </td>
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
			url : ctx+'/link/datagrid',
			remoteSort : false,
			fitColums : true,
			checkOnSelect : true,
			//singleSelect : false,//是否单选 
			pagination : true,//分页控件 
			rownumbers : true,//行号 
			frozenColumns : [ [ {
				field : 'ck',
				checkbox : true
			} ] ],
			columns : [ [ {
				field : 'name',
				title : '链接名称',
				width : 200
			}, {
				field : 'url',
				title : '链接地址',
				width : 250
			},{
				field : 'type',
				title : '链接分类',
				width : 100
			},{
				field : 'type',
				title : '类型',
				width : 100,
				formatter:function(value,row){
			    	var str = "";
			    	if(value=="0"){
			    		str = "<font style=''>文本链接</font>";
			    	}else if(value=="1"){
			    		str = "<font style=''>图片链接</font>";
			    	}else if(value=="2"){
			    		str = "<font style=''>下拉链接</font>";
			    	}
			    	return str;
				}
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
			pageList : [ 15, 20, 25 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
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
					    href: ctx+'/link/edit?id='+checkedRows[0].id,
					    modal: true,
					    buttons : [ {
							text : '保存',
							iconCls : 'icon-add',
							handler : function() {
								$('#link_editForm').form('submit', {
									url : ctx+'/link/edit',
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
				    href: '${pageContext.request.contextPath}/link/add',
				    modal: true,
				    buttons : [ {
						text : '保存',
						iconCls : 'icon-add',
						handler : function() {
							$('#seller_editForm').form('submit', {
								url : '${pageContext.request.contextPath}/link/add',
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
							url : '${pageContext.request.contextPath}/link/delete',
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
		 function searchFunc(){
				var param={
					name:$("#name").val(),
					parid:$("#parid").val(),
					type:$("#type").val()
				};
				console.log(param);
		        $("#list_data").datagrid("load",param);
	        }
	</script>
</body>
</html>
