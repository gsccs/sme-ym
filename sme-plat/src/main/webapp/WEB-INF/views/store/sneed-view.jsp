<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>服务专家列表</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/default.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/Site.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/easyui-lang-zh_CN.js"></script>

</head>
<body style="margin: 10px; padding: 0px; background-color: #fff;">
	<fieldset>
		<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">需求详情</legend>
			<input type="hidden" name="id" value="${sneedT.id}" />
			<table cellpadding="3" cellspacing="0" class="edit_table" id="tbEditForm">
				<tr>
					<td class="edit_title">需求名称：</td>
					<td>${sneedT.title}</td>
				</tr>
				<tr>
					<td class="edit_title">需求分类：</td>
					<td>${sneedT.sclassstr }</td>
				</tr>
				<tr>
					<td class="edit_title" style="vertical-align: top;">具体要求：</td>
					<td><textarea name="content" id="content"
							class="textbox textbox_area textbox_indent"
							style="width: 80%; height: 200px; float: left;" readonly="readonly">${sneedT.content}</textarea>
					</td>
				</tr>
				<tr>
					<td class="edit_title" style="vertical-align: top;">联系人：</td>
					<td>${sneedT.linker}&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td class="edit_title" style="vertical-align: top;">联系电话：</td>
					<td>${sneedT.linktel}&nbsp;&nbsp;
					</td>
				</tr>
			</table>
			
			<table id="list_data" cellspacing="0" cellpadding="0" style="width: 80%;height: 200px">
				
			</table>
	</fieldset>
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
			url : ctx+'/sneed/biddatagrid',
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
				field : 'id',
				title : '编号',
				width : 100
			}, {
				field : 'svgtitle',
				title : '服务机构',
				width : 150
			}, {
				field : 'addtimestr',
				title : '提交时间',
				width : 100
			}, {
				field : 'linker',
				title : '联系人',
				width : 100
			}, {
				field : 'linktel',
				title : '联系电话',
				width : 100
			},{
				field : 'status',
				title : '需求状态',
				width : 150
			},{
				field : 'remark',
				title : '备注信息',
				width : 200
			}]],
			toolbar : [{
				text : '服务需求添加',
				iconCls : 'icon-add',
				handler : function() {
					add();
				}
			}]
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

	</script>
</body>
</html>
