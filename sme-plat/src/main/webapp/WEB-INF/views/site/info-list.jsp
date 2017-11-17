<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>站点信息列表</title>
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
$(function() {
	$('#channelid').combotree({
	    url: ctx+'/channel/tree',
	    valueField:'id',
	    textField:'title',
	    method:'post'
	}); 
});
</script>
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
		
		//将日期格式转换成字符串日期格式（格式：yyyy-MM-dd）
		function TimeParser(time) {
			if (time == undefined || time == null || time == "") {
				return "";
			}
			var date = new Date();
			//  date.setTime(time.substr(6, time.length - 8));
			var month = (date.getMonth() + 1).toString();
			if (month.length == 1) {
				month = "0" + month;
			}
			var day = date.getDate().toString();
			if (day.length == 1) {
				day = "0" + day;
			}
			return date.getFullYear() + "-" + month + "-" + day;
		}
	</script>
	
	<div class="easyui-layout" fit="true" border="false">
		<div data-options="region:'north',title:''" style="height: 60px; background: #F4F4F4;">
			<form id="searchForm">
				<table>
				  <tr>
		              <td>标题：</td>
		              <td><input id="title" name="title" value="" class="textbox textbox_indent" style="height: 20px;"/></td>
		              <td>栏目：</td>
		              <td><input id="channelid" name="channelid" style="widtd: 150px;" /></td>
		              <td>状态：</td>
		              <td>
		              	<select id="status" name="status" class="textbox textbox_indent">
		              		<option value="">----- 请选择-----</option>
		              		<option value="0">草稿</option>
		              		<option value="1">待审核</option>
		              		<option value="2">已发布</option>
		              		<option value="-1">驳回</option>
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
			url : ctx+'/info/datagrid',
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
				title : '信息标题',
				width : 300
			}, {
				field : 'channelstr',
				title : '所属栏目',
				width : 150
			}, {
				field : 'addtimestr',
				title : '发布时间',
				width : 150
			},{
				field : 'svgtitle',
				title : '发布单位',
				width : 150
			},{
				field : 'username',
				title : '发布人',
				width : 100
			},{
				field : 'source',
				title : '信息来源',
				width : 150
			},{
				field : 'author',
				title : '作者',
				width : 100
			},{
				field : 'status',
				title : '状态',
				width : 100,
				formatter:function(value,row){
			    	var str = "";
			    	if(value=="0"){
			    		str = "<font style=''>草稿</font>";
			    	}else if(value=="1"){
			    		str = "<font style=''>提交,待审核</font>";
			    	}else if(value=="2"){
			    		str = "<font style=''>已发布</font>";
			    	}else if(value=="-1"){
			    		str = "<font style=''>审核未通过</font>";
			    	}else if(value=="-2"){
			    		str = "<font style=''>已删除</font>";
			    	}
			    	return str;
				}
			}] ],
			toolbar : [ {
				text : '信息发布',
				iconCls : 'icon-add',
				handler : function() {
					add();
				}
			}, '-', {
				text : '信息编辑',
				iconCls : 'icon-edit',
				handler : function() {
					edit();
				}
			}, '-', {
				text : '信息删除',
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
				self.location = ctx+"/info/form?id="+ checkedRows[0].id;
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
			self.location = "${pageContext.request.contextPath}/info/form";
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
													url : '${pageContext.request.contextPath}/info/delete',
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
				channelid:$("#channelid").combobox('getValue'),
				status:$("#status").val()
			};
			$("#list_data").datagrid("load", param);
		}
	</script>
</body>
</html>
