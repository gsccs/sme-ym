<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目列表</title>
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
	              <td>项目名称：</td>
	              <td><input id="title" name="title" value="" class="textbox textbox_indent"/></td>
	              <td>所属行业：</td>
	              <td>
	              	<select name="intype" id="intype" class="textbox textbox_indent" style="width: 195px;">
						<c:forEach items="${industrylist}" var="industry">
							<option value="${industry.id}" selected="selected">${industry.title}</option>
						</c:forEach>
					</select>
	              </td>
	              <td>资金来源：</td>
	              <td><select id="moneytype" name="moneytype" class="textbox textbox_indent"> 
	              		<c:forEach items="${moneytypelist }" var="moneytype">
	              			<option value="${moneytype.id }"> ${moneytype.title }</option>
	              		</c:forEach>
	              	</select>
	              </td>
	              <td>项目状态：</td>
	              <td>
	              	<select id="status" name="status" class="textbox textbox_indent" >
	              		<option value="">建设中</option>
	              		<option value="">已完工</option>
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
<div id="cropProject_window"></div>
	<script type="text/javascript">
		$('#list_data').datagrid({
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : '${pageContext.request.contextPath}/cropProject/datagrid',
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
				title : '项目编号',
				width : 100,
				hidden: true
			}, {
				field : 'title',
				title : '项目名称',
				width : 350
			}, {
				field : 'hycodestr',
				title : '所属行业',
				width : 200
			},{
				field : 'starttimestr',
				title : '开始时间',
				width : 100
			}, {
				field : 'endtimestr',
				title : '截止时间',
				width : 100
			}, {
				field : 'moneytypestr',
				title : '资金来源',
				width : 100
			}, {
				field : 'invest',
				title : '总投资（万元）',
				width : 100
			}, {
				field : 'status',
				title : '项目状态',
				width : 100
			}]],
			toolbar : [  {
				text : '项目添加',
				iconCls : 'icon-add',
				handler : function() {
					add();
				}
			}, '-',{
				text : '项目修改',
				iconCls : 'icon-edit',
				handler : function() {
					edit();
				}
			}, '-', {
				text : '项目删除',
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
				self.location = "${pageContext.request.contextPath}/cropProject/edit?id="
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
			 self.location = "${pageContext.request.contextPath}/cropProject/add";
		} 
	
		//删除
		function del(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			if(checkedRows.length == 1) {
				$.messager.confirm('确认', '您是否要删除当前选中的记录？', function(r) {
					if(r) {
						$.ajax({
							url : '${pageContext.request.contextPath}/cropProject/delete',
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
				industry:$("#industry").val()
			 };
			 console.log(param);
			 $("#list_data").datagrid("load",param);
	     }
	</script>
</body>
</html>
