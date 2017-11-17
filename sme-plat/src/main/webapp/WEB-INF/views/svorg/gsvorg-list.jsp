<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>服务机构列表</title>
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
<input type="hidden" id="returnMsg" value="${returnMsg.msg}" />
<input type="hidden" id="returnSuccess" value="${returnMsg.success}" />
	<script type="text/javascript">
		if (document.getElementById("returnSuccess").value)
			$.messager.show({
				title : '提示',
				msg : document.getElementById("returnMsg").value,
				timeout : 3000,
				showType : 'slide'
			});
	</script>
<div class="easyui-layout" fit="true" border="false">
	<div data-options="region:'north',title:''" style="height: 40px; background: #F4F4F4;">
		<form id="searchForm">
			<table>
			  <tr>
	              <td>机构名称：</td>
	              <td><input id="title" name="title" value="" class="textbox textbox_indent"/></td>
	              <th>机构类型：</th>
	              <td>
	              	<select id="svgtype" name="svgtype" class="textbox textbox_indent">
	              		<option value="">----- 机构类型-----</option>
	              		<option value="G">政府服务机构</option>
	              		<option value="S">社会服务机构</option>
	              	</select>
	              </td>
	              <th>机构状态：</th>
	              <td>
	              	<select id="status" name="status" class="textbox textbox_indent">
	              		<option value="">----- 请选择-----</option>
	              		<option value="1">启用</option>
	              		<option value="0">禁用</option>
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
<div id="svorg_window"></div>
	<script type="text/javascript">
		var ctx="${pageContext.request.contextPath}";
		$('#list_data').datagrid({
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : ctx+'/svorg/datagrid?svgtype=G',
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
			columns : [ [ 
			              {
				field : 'id',
				title : '编号',
				width : 100,
				hidden: true
			}, {
				field : 'title',
				title : '机构名称',
				width : 100
			}, {
				field : 'logo',
				title : '机构logo',
				width : 70,
				formatter:function(value,row){
			    	var str = "";
			    	if(value){
			    		str = "<img src='"+value+"' width='60' height='60'/>";
			    	}else{
			    		str = "<img src='${pageContext.request.contextPath}/static/images/no.png' width='60' height='60'/>";
			    	}
			    	return str;
				}
			}, {
				field : 'linker',
				title : '联系人',
				width : 100
			}, {
				field : 'linktel',
				title : '联系电话',
				width : 100
			},{
				field : 'address',
				title : '详细地址',
				width : 200
			},{
				field : 'domain',
				title : '官方网址',
				width : 200
			},{
				field : 'status',
				title : '状态',
				width : 100,
				formatter:function(value,row){
			    	var str = "正常";
			    	return str;
				}
			}]],
			toolbar : [  {
				text : '添加',
				iconCls : 'icon-add',
				handler : function() {
					add();
				}
			}, '-',{
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
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});

		//编辑
		function edit(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			if (checkedRows.length == 1)
				self.location = ctx+"/svorg/g/form?id="
						+ checkedRows[0].id;
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
		 function add(){
			 self.location = ctx+"/svorg/g/form";
		} 
	
		//删除
		function del(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			if(checkedRows.length == 1) {
				$.messager.confirm('确认', '您是否要删除当前选中的记录？', function(r) {
					if(r) {
						$.ajax({
							url : '${pageContext.request.contextPath}/svorg/delete',
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
				title:$("#title").val(),
				status:$("#status").val()
			 };
			 console.log(param);
			 $("#list_data").datagrid("load",param);
	     }
	</script>
</body>
</html>
