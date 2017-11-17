<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品列表</title>
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
		<div data-options="region:'north',title:''" style="height: 40px; background: #F4F4F4;">
			<form id="searchForm">
				<table>
				  <tr>
		              <th>产品名称：</th>
		              <td><input id="title" name="title" value="" class="textbox textbox_indent" style="height: 25px;"/></td>
		              <th>产品分类：</th>
		              <td><input id="categoryid" name="categoryid" value="" class="textbox textbox_indent" style="height: 25px;"/></td>
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
	<script type="text/javascript">
		$('#list_data').datagrid({
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : '${pageContext.request.contextPath}/product/datagrid',
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
				field : 'barcode',
				title : '商品编号',
				width : 150
			},{
				field : 'title',
				title : '商品名称',
				width : 250
			},{
				field : 'catetitle',
				title : '产品分类',
				width : 150
			},{
				field : 'price',
				title : '价格',
				width : 50
			},{
				field : 'storenum',
				title : '库存',
				width : 50
			},{
				field : 'weight',
				title : '重量',
				width : 50
			},{
				field : 'corptitle',
				title : '生产企业',
				width : 250
			}] ],
			toolbar : [ {
				text : '查看',
				iconCls : 'icon-add',
				handler : function() {
					viewFun();
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					
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
	</script>

</body>
</html>
