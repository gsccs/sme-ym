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
	<table id="list_data" cellspacing="0" cellpadding="0">
		<thead>
			<tr>
				<th field="id" width="100">ID</th>
				<th field="cate" width="100">分类</th>
				<th field="brand" width="100">品牌</th>
				<th field="barcode" width="100">商品编码</th>
				<th field="title" width="100">商品名称</th>
				<th field="price" width="100">价格</th>
				<th field="mktprice" width="100">市场价</th>
				<th field="alias" width="100">是否热点</th>
				<th field="storenum" width="100">库存</th>
				<th field="site" width="100">店铺名称</th>
				<th field="weight" width="100">重量</th>
				<th field="gainScore" width="100">积分</th>
			</tr>
		</thead>
	</table>
	<div id="dd"></div>
	<script type="text/javascript">
		$('#list_data').datagrid({
			title : '商品列表',
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
			toolbar : [ {
				text : '查看',
				iconCls : 'icon-add',
				handler : function() {
					//openDialog("add_dialog", "add");
					addFun();
				}
			}, '-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					openDialog("add_dialog", "edit");
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					delAppInfo();
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
		/*onBeforeRefresh:function(){
		    $(this).pagination('loading');
		    alert('before refresh');
		    $(this).pagination('loaded');
		}*/
		});

		function addFun() {
			$('#dd').dialog({
				title : '添加类型',
				width : 600,
				height : 400,
				closed : false,
				cache : false,
				href : '${pageContext.request.contextPath}/type/create',
				modal : true,
				buttons : [ {
					text : '添加',
					handler : function() {
						/* var f = parent.$.modalDialog.handler
								.find('#form'); */
						alert("Form");
						f.submit();
					}
				} ]
			});
		}
	</script>

</body>

</html>
