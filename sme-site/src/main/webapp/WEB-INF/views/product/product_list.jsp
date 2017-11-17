<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>产品列表_玉门市中小企业公共服务平台</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/easyui/themes/icon.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/home/js/CorpProduct.js"></script>
<script type="text/javascript">
	$(function () {
		$('#categoryid').combotree({
    	    url: '/categoryTree',
    	    required: true,
    	    valueField:'id',
    	    textField:'title',
    	    method:'post'
    	}); 
		
		$("#list_data").datagrid({
			height : 'auto',
			nowrap : false,
			striped : true,
			border : false,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : '/cp/product/list',
			remoteSort : false,
			fitColums : true,
			checkOnSelect : true,
			singleSelect : false,//是否单选 
			pagination : true,//分页控件 
			rownumbers : true,//行号
			idField: 'id',
			columns : [ [ {
				field : 'id',
				title : '编号',
				width : 150,
				checkbox : true
			}, {
				field : 'title',
				title : '产品名称',
				width : 250
			},{
				field : 'catetitle',
				title : '产品类别',
				width : 150
			}, {
				field : 'price',
				title : '价格',
				width : 100
			}, {
				field : 'storenum',
				title : '库存数量',
				width : 100
			}, {
				field : 'salenum',
				title : '销量',
				width : 100
			}, {
				field : 'remark',
				title : '备注说明',
				width : 150
			}  ] ],
			toolbar : [ {
				text : '新增',
				iconCls : 'icon-add',
				handler : function() {
					addFun();
				}
			}, '-', {
				text : '编辑',
				iconCls : 'icon-edit',
				handler : function() {
					editFun();
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					delFun();
				}
			} ],
			pageSize : 10,
			pageList : [10, 15, 20]
		});
		var p = $('#list_data').datagrid('getPager');
		$(p).pagination({
			pageSize : 10,//每页显示的记录条数，默认为10 
			pageList : [10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
	});
</script>
</head>
<body>

<div class="admin_right">
    <div class="indent_title">
        <img src="${pageContext.request.contextPath}/resources/home/images/t_05.jpg" width="5" height="17" class="fl"><span>发布产品</span>
    </div>
    <div class="clear" style="height: 10px; line-height: 10px;">
    </div>
    <div class="Info_top">
    	<form id="searchForm">
				<table>
				  <tr>
		              <td>产品名称：</td>
		              <td><input id="title" name="title" value="" class="easyui-validatebox textbox textbox_indent"/></td>
		              <td>产品类目：</td>
		              <td><select id="categoryid" name="categoryid" style="width: 150px;"></select></td>
		          	  <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="searchFunc();">查找</a></td>
		          </tr>                     
				</table>
		</form>
    </div>
    <div class="Info_center">
        <div class="clear"></div>
        <div id="data">
        	<table id="list_data" class="easyui-datagrid" style="width:1000px;height:500px" data-options="singleSelect:true,collapsible:true">
			</table>
        </div>
    </div>
</div>
<script type="text/javascript">
//搜索
function searchFunc() {
	var param = {
		title:$("#title").val(),
		categoryid:$("#categoryid").combobox('getValue')
	};
	$("#list_data").datagrid("load", param);
}
</script>
</body>
</html>