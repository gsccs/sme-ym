<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>产品订单_企业管理后台_玉门市中小企业公共服务平台</title>
    <link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/home/css/webindex.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/home/css/admin.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/home/css/main.css" />
<link id="changbj" rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/home/css/base.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/site/js/putud.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/site/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/site/js/jquery.soChange.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/site/js/js.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/site/js/Common.js"></script>

<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/resources/home/js/jquery.jUploader-1.0.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/home/js/CorpProduct.js"></script>
<link href="${pageContext.request.contextPath}/resources/home/css/Site.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	$(function () {
		loadcity();
		$("#list_data").datagrid({
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : '/cp/porder/list',
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
				field : 'ptitle',
				title : '产品名称',
				width : 200
			},{
				field : 'depttitle',
				title : '购买者',
				width : 150
			}, {
				field : 'totalnum',
				title : '产品数量',
				width : 150
			}, {
				field : 'price',
				title : '单价',
				width : 150
			}, {
				field : 'totalfee',
				title : '总价',
				width : 150
			}, {
				field : 'addtimestr',
				title : '下单时间',
				width : 150
			}, {
				field : 'remark',
				title : '备注说明',
				width : 150
			}  ] ],
			toolbar : [ {
				text : '查看详情',
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
			pageSize : 15,
			pageList : [10, 15, 20]
		});
		var p = $('#list_data').datagrid('getPager');
		$(p).pagination({
			//pageSize : 2,//每页显示的记录条数，默认为10 
			//pageList : [ 2, 10, 15 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
	});
	
	
	/*编辑*/
	function editFun() {
		var checkedRows = $("#list_data").datagrid('getChecked');
		if (checkedRows.length == 1) {
			//basepath+'/monitorval/dataform?id='+checkedRows[0].id;
		} else if(checkedRows.length > 1) {
			$.messager.show({
				title : '提示',
				msg : '只能选择一条记录编辑!',
				timeout : 3000,
				showType : 'slide'
			});
		}else {
			$.messager.show({
				title : '提示',
				msg : '请选择要编辑的记录!',
				timeout : 3000,
				showType : 'slide'
			});
		}
	}
	
	
	//记录删除
	function delFun(){
		var checkedRows = $("#list_data").datagrid('getChecked');
		if(checkedRows.length >=1){
			var ids =  new Array();
			for (var i=0;i<checkedRows.length;i++){
				ids.push(checkedRows[i].id);
			}
			$.messager.confirm('确   认', '您是否要删除当前选中的记录？', function(r) {
				if(r) {
					$.ajax({
						url : basepath+'/monitorval/delete',
						data : {"ids":ids.toString()},
						type:'POST',
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
		} else {
			$.messager.show({
				title : '提示',
				msg : '请勾选想要删除的记录!',
				timeout : 3000,
				showType : 'slide'
			});
		}
	}
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
    	
    </div>
    <div class="Info_center" id="Note">
        <div class="clear"></div>
        <div id="data">
        	<table id="list_data" class="easyui-datagrid" style="width:1000px;height:400px" data-options="singleSelect:true,collapsible:true">
			</table>
        </div>
    </div>
    <!-- <div class="Info_bottom"></div> -->
</div>

</body></html>