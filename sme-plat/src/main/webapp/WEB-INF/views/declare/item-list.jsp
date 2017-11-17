<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目申报列表</title>
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
		              <td>项目名称：</td>
		              <td><input id="title" name="title" value="" class="textbox textbox_indent"/></td>
		              <td>状态：</td>
		              <td>
		              	<select id="status" name="status" style="width: 150px;">
			              	<option value="">-------请选择-----</option>
			              	<option value="1">正在申报</option>
			              	<option value="0">申报成功</option>
			              	<option value="-1">申报失败</option>
			              	<option value="-1">取消申报</option>
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
		url : ctx+'/declare/item/datagrid',
		remoteSort : false,
		fitColums : true,
		checkOnSelect : true,
		singleSelect : true,//是否单选 
		pagination : true,//分页控件 
		rownumbers : true,//行号 
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		columns : [ [ {
			field : 'topictitle',
			title : '申报项目',
			width : 150
		},{
			field : 'corptitle',
			title : '申报企业',
			width : 150
		}, {
			field : 'svgtitle',
			title : '审核部门',
			width : 150
		}, {
			field : 'title',
			title : '项目名称',
			width : 150
		}, {
			field : 'leader',
			title : '项目经理',
			width : 50
		}, {
			field : 'linktel',
			title : '联系电话',
			width : 100
		}, {
			field : 'invest',
			title : '投资金额(万元)',
			width : 50
		}, {
			field : 'owncapital',
			title : '自有资金(万元)',
			width : 80
		}, {
			field : 'bankcapital',
			title : '银行贷款(万元)',
			width : 80
		}, {
			field : 'othercapital',
			title : '其他资金(万元)',
			width : 80
		}, {
			field : 'saleincome',
			title : '销售收入(万元)',
			width : 80
		}, {
			field : 'saleincome',
			title : '销售收入(万元)',
			width : 80
		}, {
			field : 'saleprofits',
			title : '销售利润(万元)',
			width : 80
		}, {
			field : 'taxes',
			title : '税金(万元)',
			width : 80
		}, {
			field : 'employee',
			title : '从业人数(个)',
			width : 80
		}, {
			field : 'addtimestr',
			title : '资料提交时间',
			width : 150
		},{
			field : 'status',
			title : '状态',
			width : 100,
			formatter:function(value,row){
		    	var str = "";
		    	if(value=="0"){
		    		str = "<font style=''>正在预审</font>";
		    	}else if(value=="1"){
		    		str = "<font style='color:green'>预审通过</font>";
		    	}else if(value=="-1"){
		    		str = "<font style='color:red'>预审驳回</font>";
		    	}else if(value=="-2"){
		    		str = "<font style='color:red'>取消申请</font>";
		    	}
		    	return str;
			}
		}, {
			field : 'content',
			title : '备注信息',
			width : 150
		}, {
			field : 'reply',
			title : '申请结果',
			width : 150
		}   ] ],
		toolbar : [{
			text : '申报信息审核',
			iconCls : 'icon-more',
			handler : function() {
				audit();
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
	
	//审核
	function audit(){
		 var checkedRows = $("#list_data").datagrid('getChecked');
		 if(checkedRows.length == 1) {
			 var status = checkedRows[0].status;
			 if (status!='0'){
				 $.messager.show({
						title : '提示',
						msg : '暂时无法执行此操作!',
						timeout : 3000,
						showType : 'slide'
				});
				return;
			 }
			 location.href= ctx+"/declare/item/form?id="+checkedRows[0].id;
		 }else if(checkedRows.length > 1) {
			$.messager.show({
				title : '提示',
				msg : '只能选择一条事项!',
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
</script>
</body>
</html>
