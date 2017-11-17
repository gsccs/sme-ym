<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目申报主题列表</title>
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
		              <td>主题名称：</td>
		              <td><input id="title" name="title" class="easyui-validatebox textbox textbox_indent" value=""/></td>
		              <td>项目类型：</td>
		              <td>
		              	<select id="dectype" name="dectype" class=" textbox textbox_indent">
							<option selected="selected"></option>
							<c:forEach items="${dectypelist }" var="dectype">
								<option value="${dectype.id }" <c:if test="${decTopic.dectype == dectype.id }"> selected="selected" </c:if>>${dectype.title }</option>
							</c:forEach>
						</select>
		              </td>
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
			<table id="list_data" cellspacing="0" cellpadding="0">
				<thead>
					<tr>
						<th field="title" width="300">申报项目名称</th>
						<th field="dectypestr" width="300">项目类型</th>
						<th field="starttimestr" width="150">申报开始时间</th>
						<th field="endtimestr" width="150">申报截止时间</th>
						<th field="svgtitle" width="300">申报发布机构</th>
					</tr>
				</thead>
			</table>
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
			url : ctx+'/declare/topic/datagrid',
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
			toolbar : [ {
				text : '发布申报主题',
				iconCls : 'icon-add',
				handler : function() {
					add();
				}
			}, '-', {
				text : '修改申报主题',
				iconCls : 'icon-edit',
				handler : function() {
					edit();
				}
			}, '-', {
				text : '删除申报主题',
				iconCls : 'icon-remove',
				handler : function() {
					del();
				}
			},  '-', {
				text : '查看申报情况',
				iconCls : 'icon-more',
				handler : function() {
					list();
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
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});

		//编辑
		function edit(){
			 var checkedRows = $("#list_data").datagrid('getChecked');
			 if(checkedRows.length == 1) {
				 location.href=ctx+'/declare/topic/form?id='+checkedRows[0].id;
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
			location.href=ctx+'/declare/topic/form';
		} 
	
		//删除
		function del(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			if(checkedRows.length == 1) {
				$.messager.confirm('确认', '您是否要删除当前选中的记录？', function(r) {
					if(r) {
						$.ajax({
							url : '${pageContext.request.contextPath}/declare/topic/delete',
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
				 var topic_dialog = $('#topic_window').dialog({
						title: '申报详情',
					    width: 1002,
					    height:450,
					    closed: false,
					    cache: false,
					    href: '${pageContext.request.contextPath}/decTopic/list?id='+checkedRows[0].id,
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
