<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>玉门市新型墙材生产企业报表</title>
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
 <form id="searchForm">
     	<input class="easyui-searchbox" data-options="prompt:'请选择企业进行搜索',menu:'#mm',searcher:doSearch" style="width:300px"></input>
	<div id="mm">
		<c:forEach items="${corpTList}" var="corp">
		<div data-options="name:'${corp.id}'">${corp.title}</div>
		</c:forEach>
	</div>
	 </form>
    <div style="height:93%">
	<table id="list_data" cellspacing="0" cellpadding="0">
		<thead>
			<tr>
				<th field="corptitle" width="200">填报单位</th>
				<th field="tbdatestr" width="200">填报时间</th>
			</tr>
		</thead>
	</table>
	</div>
	<div id="dd"></div>
	<script type="text/javascript">
		$('#list_data').datagrid({
			title : '玉门市新型墙材生产企业报表',
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : '${pageContext.request.contextPath}/wallMain/datagrid',
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
			toolbar : [ /*  {
				text : '报表上报',
				iconCls : 'icon-add',
				handler : function() {
					add();
				}
			}, '-', */{
				text : '查看详情',
				iconCls : 'icon-edit',
				handler : function() {
					edit();
				}
			}, '-', {
				text : '删除报表',
				iconCls : 'icon-remove',
				handler : function() {
					del();
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
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录',
		/*onBeforeRefresh:function(){
		    $(this).pagination('loading');
		    alert('before refresh');
		    $(this).pagination('loaded');
		}*/
		});

		//编辑
		function edit(){
			 var checkedRows = $("#list_data").datagrid('getChecked');
			 if(checkedRows.length == 1) {
				 self.location = "${pageContext.request.contextPath}/wallMain/info?mainid="
						+ checkedRows[0].mainid;
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
			 self.location = "${pageContext.request.contextPath}/wallMain/add";
		}
		//删除
		function del(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			if(checkedRows.length == 1) {
				$.messager.confirm('确认', '您是否要删除当前选中的记录？', function(r) {
					if(r) {
						$.ajax({
							url : '${pageContext.request.contextPath}/wallMain/delete',
							data : {
								mainid : checkedRows[0].mainid
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
		 function doSearch(value,name){
				var noticeobj={
						corpid:name
				};
		        $("#list_data").datagrid("load",noticeobj);
	        }
	</script>
</body>
</html>
