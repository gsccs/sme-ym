<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业列表</title>
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
		
		$(function () {
			$('#hycode').combotree({
			    url: ctx+'/industry/tree',
			    valueField:'id',
			    textField:'name',
			    method:'post'
			}); 
		});
	</script>
<div class="easyui-layout" fit="true" border="false">
	<div data-options="region:'north',title:''" style="height: 40px; background: #F4F4F4;">
		<form id="searchForm">
			<table>
			  <tr>
	              <td>企业名称：</td>
	              <td><input id="title" name="title" value="" class="textbox textbox_indent" style="height: 20px;"/></td>
	              <td>所属行业：</td>
	              <td>
	              	<input type="text" id="hycode" name="hycode">
	              </td>
				  <td>所属区域：</td>
	              <td>
	              	<select id="parkid" name="parkid" class="textbox textbox_indent" style="height: 20px;">
	              		<option value="">----- 请选择-----</option>
	              		<c:forEach items="${parklist }" var="park">
	              			<option value="${park.id }">${park.title }</option>
	              		</c:forEach>
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
<div id="corp_window"></div>
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
			url : ctx+'/corp/datagrid',
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
				title : '编号',
				width : 100,
				hidden: true
			}, {
				field : 'title',
				title : '企业名称',
				width : 200
			}, {
				field : 'logo',
				title : '企业logo',
				width : 70,
				formatter:function(value,row){
			    	var str = "";
			    	if(value){
			    		str = "<img src='"+value+"' width='60' height='60'/>";
			    	}else{
			    		str = "<img src='${pageContext.request.contextPath}/static/images/no.png' width='60' height='60'/>";
			    	}
			    	return str;
				}
			},{
				field : 'orgcode',
				title : '组织机构代码',
				width : 100
			}, {
				field : 'legaler',
				title : '法 人',
				width : 50
			}, {
				field : 'linker',
				title : '联系电话',
				width : 100
			},{
				field : 'regtype',
				title : '注册类型',
				width : 150
			},{
				field : 'regfund',
				title : '注册资金(万元)',
				width : 100
			},{
				field : 'naturestr',
				title : '企业性质',
				width : 50
			},{
				field : 'hytypestr',
				title : '行业类别',
				width : 100
			},{
				field : 'stakestr',
				title : '控股情况',
				width : 50
			} ,{
				field : 'address',
				title : '详细地址',
				width : 280
			}]],
			toolbar : [ 
			{
				text : '查看详情',
				iconCls : 'icon-more',
				handler : function() {
					findAll();
				}
			}
			]
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

		//查看
		function findAll(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			if (checkedRows.length == 1)
				self.location = "${pageContext.request.contextPath}/corp/findAll?id="
						+ checkedRows[0].id;
			else if (checkedRows.length > 1) {
				$.messager.show({
					title : '提示',
					msg : '只能选择一条信息查看!',
					timeout : 3000,
					showType : 'slide'
				});
			} else if (checkedRows.length < 1) {
				$.messager.show({
					title : '提示',
					msg : '请勾选想要查看的信息!',
					timeout : 3000,
					showType : 'slide'
				});
			} else {
				$.messager.show({
					title : '提示',
					msg : '请勾选想要查看的信息!',
					timeout : 3000,
					showType : 'slide'
				});
			}
		}
		
		//搜索
		 function searchFunc(){
				var param={
					title:$("#title").val(),
					hycode:$("#hycode").combotree("getValue"),
					parkid:$("#parkid").val()
				};
		        $("#list_data").datagrid("load",param);
	        }
	</script>
</body>
</html>
