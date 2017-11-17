<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>服务咨询列表</title>
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
		              <th>咨询名称：</th>
		              <td><input id="title" name="title" value=""/></td>
		              <th>咨询状态：</th>
		              <td>
		              	<select id="status" name="status">
		              		<option value="">----- 请选择-----</option>
		              		<option value="0">等待回复 </option>
		              		<option value="1">已回复</option>
		              	</select>
		              </td>
		              <th>咨询分类：</th>
		              <td>
		              	<select id="scode" name="scode">
		              		<option value="">----- 请选择-----</option>
		              	</select>
		              </td>
		          	  <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="searchFunc();">查找</a></td>
		          </tr>                     
				</table>
			</form>                                    
		</div>            
		<div data-options="region:'center',split:false">
			<div class="easyui-layout" fit="true" border="false">
				<div data-options="region:'west',title:''" style="width:70%;">
					<table id="list_data" cellspacing="0" cellpadding="0">
					</table>
				</div>
				<div data-options="region:'east'" style="width:30%;">
					<table id="reply_list_data" cellspacing="0" cellpadding="0"></table>
				</div>
			</div>
		</div>
	</div>
	<div id="consult_window"></div>
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
			url : ctx+'/consult/datagrid',
			remoteSort : false,
			fitColums : true,
			checkOnSelect : true,
			singleSelect : true,//是否单选 
			pagination : true,//分页控件 
			frozenColumns : [ [ {
				field : 'ck',
				checkbox : true
			} ] ],
			columns : [ [{
				field : 'id',
				title : '咨询标题',
				width : 0,
				hidden:true
			},{
				field : 'title',
				title : '咨询标题',
				width : 100
			}, {
				field : 'corptitle',
				title : '咨询企业',
				width : 100
			},{
				field : 'svgtitle',
				title : '服务部门',
				width : 100
			},{
				field : 'scodestr',
				title : '分类',
				width : 50
			},{
				field : 'addtimestr',
				title : '咨询时间',
				width : 100
			},{
				field : 'content',
				title : '咨询内容',
				width : 200
			},{
				field : 'status',
				title : '状态',
				width : 50,
				formatter:function(value,row){
			    	var str = "";
			    	if(value=='1'){
			    		str = "已回复";
			    	}else {
			    		str = "等待回复";
			    	}
			    	return str;
				}
			},{
				field : 'linker',
				title : '联系人',
				width : 80
			},{
				field : 'linktel',
				title : '联系电话',
				width : 80
			},{
				field : 'isshow',
				title : '是否公开',
				width : 50,
				formatter:function(value,row){
			    	var str = "";
			    	if(value=='1'){
			    		str = "公开";
			    	}else if(value=='0'){
			    		str = "不公开";
			    	}
			    	return str;
				}
			}] ],
			toolbar : [  {
				text : '回复',
				iconCls : 'icon-add',
				handler : function() {
					reply();
				}
			},'-',{
				text : '查看',
				iconCls : 'icon-more',
				handler : function() {
					view();
				}
			}],
			onClickRow:function () {
		        var datarow = $('#list_data').datagrid("getSelected");
		        var consultid = datarow.id;
		        if (consultid){
		        	loadreplys(consultid);
				}
		    }
		});
		//设置分页控件 
		var p = $('#list_data').datagrid('getPager');
		$(p).pagination({
			pageSize : 10,//每页显示的记录条数，默认为10 
			pageList : [ 10, 15, 20 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
		
		$('#reply_list_data').datagrid({
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			//url : ctx+'/consult/datagrid?parid=0',
			remoteSort : false,
			fitColums : true,
			checkOnSelect : true,
			//singleSelect : false,//是否单选 
			rownumbers : true,//行号 
			columns : [ [ {
				field : 'content',
				title : '回复内容',
				width : 150
			},{
				field : 'addtimestr',
				title : '回复时间',
				width : 80
			},{
				field : 'isshow',
				title : '是否公开',
				width : 80,
				formatter:function(value,row){
			    	var str = "";
			    	if(value=='1'){
			    		str = "公开";
			    	}else if(value=='0'){
			    		str = "不公开";
			    	}
			    	return str;
				}
			}] ],
			toolbar : [  {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					delreply();
				}
			}],
		});
		
		function loadreplys(id){
			$.ajax({
				type : "POST",
				url : ctx+'/consult/replyList',
				data : "page=1&rows=50&parid="+id,
				dataType : 'json',
				success : function(json) {
					console.log("parid",json);
					if (json.rows){
						$("#reply_list_data").datagrid({data:json.rows});
					}
				}
			});
		}

		//编辑
		function reply(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			if (checkedRows.length == 1)
				self.location = ctx+"/consult/form?id="+ checkedRows[0].id;
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
		
		
		//编辑
		function view(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			if (checkedRows.length == 1)
				self.location = ctx+"/consult/form?id="+ checkedRows[0].id;
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
		
		//删除
		function del(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			if(checkedRows.length == 1) {
				$.messager.confirm('确认', '您是否要删除当前选中的记录？', function(r) {
					if(r) {
						$.ajax({
							type : "POST",
							url : ctx+'/consult/delete',
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
		
		//删除
		function delreply(){
			var checkedRows = $("#reply_list_data").datagrid('getChecked');
			if(checkedRows.length == 1) {
				$.messager.confirm('确认', '您是否要删除当前选中的记录？', function(r) {
					if(r) {
						$.ajax({
							url : ctx+'/consult/delete',
							data : {
								id : checkedRows[0].id
							},
							type : "POST",
							dataType : 'json',
							success : function(json) {
								if (json.success) {
									//$("#reply_list_data").datagrid('load');
									var datarow = $('#list_data').datagrid("getSelected");
							        var consultid = datarow.id;
							        if (consultid){
							        	loadreplys(consultid);
									}
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
			 var param = {
				scode:$("#scode").val(),
				status:$("#status").val(),
				title:$("#title").val()
			 };
		     $("#list_data").datagrid("load",param);
	     }
	</script>
</body>
</html>
