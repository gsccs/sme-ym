<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>服务需求列表</title>
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
	              <td>需求标题：</td>
	              <td><input id="title" name="title" value="" class="textbox textbox_indent" style="height: 20px;"/></td>
	              <td>需求分类：</td>
	              <td>
	              	<select id="scode" name="scode" class="textbox textbox_indent" style="height: 20px;">
	              		<option value="">----- 请选择-----</option>
	              		<c:forEach items="${sclassList }" var="sclass">
	              		<option value="${sclass.id }">${sclass.title }</option>
	              		</c:forEach>
	              	</select>
	              </td>
				  <td>需求状态：</td>
	              <td>
	              	<select id="status" name="status" class="textbox textbox_indent" style="height: 20px;">
	              		<option value="">----- 请选择-----</option>
	              		<option value="2">已解决</option>
	              		<option value="1">正在办理</option>
	              		<option value="0">未受理</option>
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
<div id="sneed_window"></div>
	<script type="text/javascript">
		$('#list_data').datagrid({
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : '${pageContext.request.contextPath}/sneed/datagrid',
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
				width : 100,
				hidden: true
			},{
				field : 'title',
				title : '需求标题',
				width : 200
			}, {
				field : 'corptitle',
				title : '企业名称',
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
				field : 'salenum',
				title : '受理单位数量',
				width : 150
			},{
				field : 'status',
				title : '需求状态',
				width : 150,
				formatter:function(value,row){
			    	var str = "";
			    	if(value=='2'){
			    		str = "已解决";
			    	}else if(value=='1'){
			    		str = "正在办理";
			    	}else if(value=='0'){
			    		str = "等待办理";
			    	}else{
			    		str = "等待办理";
			    	}
			    	return str;
				}
			},{
				field : 'remark',
				title : '备注信息',
				width : 200
			}]],
			toolbar : [{
				text : '受理',
				iconCls : 'icon-more',
				handler : function() {
					view();
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

		//编辑
		function view() {
			var checkedRows = $("#list_data").datagrid('getChecked');
			if (checkedRows.length == 1)
				self.location = "${pageContext.request.contextPath}/sneed/view?id="
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

		//搜索
		function doSearch() {
			var param = {
				title : $("#title").val()
			};
			$("#list_data").datagrid("load", param);
		}
	</script>
</body>
</html>
