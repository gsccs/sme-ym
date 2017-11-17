<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>报表列表</title>
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
<style type="text/css">
.datagrid-row {
	height: 50px;
}
</style>
</head>
<body>
	<div class="easyui-layout" fit="true" border="false">
		<div data-options="region:'north',title:''" style="height: 60px; background: #F4F4F4;">
			<form id="searchForm">
				<table>
				  <tr>
		              <td>报表名称：</td>
		              <td><input id="title" name="title" class="easyui-validatebox textbox textbox_indent" value=""/></td>
		              <td>状态：</td>
		              <td>
		              	<select id="state" name="state" class="textbox textbox_indent">
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
			<div class="easyui-layout" fit="true" border="false">
				<div data-options="region:'west',title:''" style="">
					<table id="list_data" cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th field="title" width="250">报表名称</th>
								<th field="cycstr" width="100">报送周期</th>
								<th field="svgtitle" width="300">发布机构</th>
							</tr>
						</thead>
					</table>
				</div>
				<div data-options="region:'east'" style="width:400px;">
					<table id="prop_data" cellspacing="0" cellpadding="0"></table>
				</div>
			</div>
		</div>
	</div>
	<div id="topic_window"></div>
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
			url : ctx+'/report/datagrid',
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
				title : '指标名称',
				width : 200
			},{
				field : 'cycstr',
				title : '报送周期',
				width : 50
			},{
				field : 'svgtitle',
				title : '直报单位',
				width : 100
			},{
				field : 'isattach',
				title : '上报方式',
				width : 100,
				formatter:function(value,row){
			    	var str = "";
			    	if(value=="0"){
			    		str = "<font style=''>表单</font>";
			    	}else if(value=="1"){
			    		str = "<font style=''>附件</font>";
			    	}
			    	return str;
				}
			}]],
			toolbar : [ {
				text : '新增报表',
				iconCls : 'icon-add',
				handler : function() {
					add();
				}
			}, '-', {
				text : '修改报表',
				iconCls : 'icon-edit',
				handler : function() {
					edit();
				}
			}, '-', {
				text : '删除报表',
				iconCls : 'icon-remove',
				handler : function() {
					del();
				}
			},  '-', {
				text : '查看报送情况',
				iconCls : 'icon-more',
				handler : function() {
					list();
				}
			} ],
			onClickRow:function () {
				$('#prop_data').datagrid('unselectAll');
		        var proprow = $('#list_data').datagrid("getSelected");
		        var svgids = proprow.svgids;
		        if (svgids){
		        	var svgarray = svgids.split(",");
		        	var rows = $("#prop_data").datagrid("getRows"); 
					for(var i=0;i<rows.length;i++){
						var svgid = rows[i].id;
						for(var r=0;r<svgarray.length;r++){
							if(svgid == svgarray[r]){
								$('#prop_data').datagrid('selectRow',r);	
							}
						}
					}
				}
		    }
		});
		//设置分页控件 
		var p = $('#list_data').datagrid('getPager');
		$(p).pagination({
			pageSize : 15,//每页显示的记录条数，默认为10 
			pageList : [ 5, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
		
		$('#prop_data').datagrid({
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : ctx+"/prop/datagrid",
			queryParams:{
				svgtype : 'G'
			},
			remoteSort : false,
			fitColums : true,
			checkOnSelect : true,
			//singleSelect : false,//是否单选 
			rownumbers : true,//行号 
			frozenColumns : [ [ {
				field : 'ck',
				checkbox : true
			} ] ],
			columns : [ [ {
				field : 'title',
				title : '指标名称',
				width : 100
			},{
				field : 'showtype',
				title : '数据类型',
				width : 100
			},{
				field : 'unit',
				title : '数据单位',
				width : 70
			}]],
			pagination : true,
            pageList : [ 50, 100 ],//可以设置每页记录条数的列表
            pageSize : 50 //每页显示的记录条数，默认为5  
		});
		
		//编辑
		function edit(){
			 var checkedRows = $("#list_data").datagrid('getChecked');
			 if(checkedRows.length == 1) {
				 location.href=ctx+'/report/form?id='+checkedRows[0].id;
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
			location.href=ctx+'/report/form';
		} 
		
			//开始上报
		 function report(){
			 var checkedRows = $("#list_data").datagrid('getChecked');
			 if(null!=checkedRows[0].code)
			location.href=ctx+checkedRows[0].code+"/add?id="+checkedRows[0].id;
			 else
				 location.href=ctx+"/report/byattach/?id="+checkedRows[0].id;
		} 
	
		//删除
		function del(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			if(checkedRows.length == 1) {
				$.messager.confirm('确认', '您是否要删除当前选中的记录？', function(r) {
					if(r) {
						$.ajax({
							url : '${pageContext.request.contextPath}/report/delete',
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
		
		//已报送企业
		function list(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			 if(checkedRows.length == 1) 
				 if(null!=checkedRows[0].code)
				 location.href='${pageContext.request.contextPath}'+checkedRows[0].code
				 else 
				 location.href='${pageContext.request.contextPath}/reportitem/list?reportid='+checkedRows[0].id
			 else if(checkedRows.length > 1) {
				$.messager.show({
					title : '提示',
					msg : '只能选择一条查看!',
					timeout : 3000,
					showType : 'slide'
				});
			}else if(checkedRows.length < 1){
				$.messager.show({
					title : '提示',
					msg : '请勾选想要查看的报表!',
					timeout : 3000,
					showType : 'slide'
				});
			}else {
				$.messager.show({
					title : '提示',
					msg : '请勾选想要查看的报表!',
					timeout : 3000,
					showType : 'slide'
				});
			}
		}
		
		//搜索
		 function doSearch(){
			 var param = $("#searchForm").serialize();
				var noticeobj={
						title:$("#title").val()
				};
		        $("#list_data").datagrid("load",noticeobj);
	        }
		
	</script>
</body>
</html>
