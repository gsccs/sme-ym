<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>行政诉求主题列表</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
var ctx="${pageContext.request.contextPath}";
</script>
<style type="text/css">
.datagrid-row {
	height: 50px;
}
</style>
</head>
<body>
	<div class="easyui-layout" fit="true" border="false">
		<div data-options="region:'north',title:''" style="height: 40px; background: #F4F4F4;">
			<form id="searchForm">
				<table>
				  <tr>
		              <th>事项标题：</th>
		              <td><input id="title" name="title" value="" class="textbox textbox_indent" style="height: 25px;"/></td>
		              
		              <th>责任部门：</th>
		              <td>
		              	<select id="svgid" name="svgid" class="textbox textbox_indent" style="height: 25px;">
		              		<option value="">----- 请选择-----</option>
		              		<c:forEach items="${svglist }" var="svg">
		              		<option value="${svg.id }">${svg.title }</option>
		              		</c:forEach>
		              	</select>
		              </td>
		              <th>事项状态：</th>
		              <td>
		              	<select id="status" name="status" class="textbox textbox_indent" style="height: 25px;">
		              		<option value="">----- 请选择-----</option>
		              		<option value="1">业务开放</option>
		              		<option value="0">业务关闭</option>
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
	<div id="topic_window"></div>
	<script type="text/javascript">
		$('#list_data').datagrid({
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : ctx+'/appeal/topic/datagrid',
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
				field : 'title',
				title : '事项名称',
				width : 150
			}, {
				field : 'sclassstr',
				title : '事项分类',
				width : 100
			},{
				field : 'remark',
				title : '事项内容',
				width : 450
			}, {
				field : 'svgtitle',
				title : '责任部门',
				width : 150
			},{
				field : 'status',
				title : '状态',
				width : 100,
				formatter:function(value,row){
			    	var str = "";
			    	if(value=='1'){
			    		str = "业务开放";
			    	}else{
			    		str = "业务关闭";
			    	}
			    	return str;
				}
			}]],
			toolbar : [ {
				text : '新增',
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
				text : '关闭',
				iconCls : 'icon-remove',
				handler : function() {
					del();
				}
			}]
		});
		//设置分页控件 
		var p = $('#list_data').datagrid('getPager');
		$(p).pagination({
			pageSize : 15,//每页显示的记录条数，默认为10 
			pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
		});

		//编辑
		function edit(){
			 var checkedRows = $("#list_data").datagrid('getChecked');
			 if(checkedRows.length == 1) {
				 location.href= ctx+"/appeal/topic/form?id="+checkedRows[0].id;
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
			 location.href= ctx+"/appeal/topic/form";
		} 
	
		//删除
		function del(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			if(checkedRows.length == 1) {
				$.messager.confirm('确认', '您是否要删除当前选中的记录？', function(r) {
					if(r) {
						$.ajax({
							url : ctx+'/appeal/topic/delete',
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
		
		//已申报企业
		function list(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			 if(checkedRows.length == 1) {
				 var win_dialog = $('#topic_window').dialog({
						title: '申报详情',
					    width: 1002,
					    height:450,
					    closed: false,
					    cache: false,
					    href: ctx+'/decTopic/list?id='+checkedRows[0].id,
					    modal: true,
					});
			 }else if(checkedRows.length > 1) {
				$.messager.show({
					title : '提示',
					msg : '只能选择一条信息查看!',
					timeout : 3000,
					showType : 'slide'
				});
			}else if(checkedRows.length < 1){
				$.messager.show({
					title : '提示',
					msg : '请勾选想要查看的信息!',
					timeout : 3000,
					showType : 'slide'
				});
			}else {
				$.messager.show({
					title : '提示',
					msg : '请勾选想要查看的信息!',
					timeout : 3000,
					showType : 'slide'
				});
			}
		}
		
		//搜索
		function searchFunc(){
			var param = $("#searchForm").serialize();
		    $("#list_data").datagrid("load",param);
	    }
		
	</script>
</body>
</html>
