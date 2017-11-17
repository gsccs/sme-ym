<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>统计指标管理</title>
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
		<div data-options="region:'north',title:''" style="height: 60px; background: #F4F4F4;">
			<form id="searchForm">
				<table>
				  <tr>
		              <td>指标名称：</td>
		              <td><input id="title" name="title" class="easyui-validatebox textbox textbox_indent" value=""/></td>
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
			<div class="easyui-layout" fit="true" border="false">
				<div data-options="region:'west',title:''" style="">
					<table id="list_data" cellspacing="0" cellpadding="0">
					</table>
				</div>
				<div data-options="region:'east'" style="width:400px;">
					<table id="gvg_data" cellspacing="0" cellpadding="0"></table>
				</div>
			</div>
		</div>
	</div>
	<div id="prop_window"></div>
	<script type="text/javascript">
		var ctx = "${pageContext.request.contextPath}";
		$('#list_data').datagrid({
			//title : document.getElementById("reportTitle").value+'列表',
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : ctx+'/prop/datagrid',
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
				field : 'title',
				title : '指标名称',
				width : 200
			}, {
				field : 'code',
				title : '指标编码',
				width : 100
			},{
				field : 'unit',
				title : '数值单位',
				width : 100
			},{
				field : 'showtype',
				title : '类型',
				width : 100,
				formatter:function(value,row){
			    	var str = "";
			    	if(value=="0"){
			    		str = "<font style=''>文本链接</font>";
			    	}else if(value=="1"){
			    		str = "<font style=''>图片链接</font>";
			    	}else if(value=="2"){
			    		str = "<font style=''>下拉链接</font>";
			    	}
			    	return str;
				}
			},{
				field : 'status',
				title : '状态',
				width : 100,
				formatter:function(value,row){
			    	var str = "";
			    	if(value=="0"){
			    		str = "<font style=''>禁用</font>";
			    	}else if(value=="1"){
			    		str = "<font style=''>启用</font>";
			    	}
			    	return str;
				}
			},{
				field : 'svgids',
				title : '可见单位',
				width : 100,
				hidden:true
			}] ],
			toolbar : [ {
				text : '新增',
				iconCls : 'icon-add',
				handler : function() {
					add();
				}
			},'-',{
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					view();
				}
			},'-',{
				text : '授权',
				iconCls : 'icon-more',
				handler : function() {
					authFun();
				}
			}],
			onClickRow:function () {
				$('#gvg_data').datagrid('unselectAll');
		        var proprow = $('#list_data').datagrid("getSelected");
		        var svgids = proprow.svgids;
		        if (svgids){
		        	var svgarray = svgids.split(",");
		        	var rows = $("#gvg_data").datagrid("getRows"); 
					for(var i=0;i<rows.length;i++){
						var svgid = rows[i].id;
						for(var r=0;r<svgarray.length;r++){
							if(svgid == svgarray[r]){
								$('#gvg_data').datagrid('selectRow',r);	
							}
						}
					}
				}
		    }
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
		
		$('#gvg_data').datagrid({
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : ctx+"/svorg/datagrid",
			queryParams:{
				svgtype : 'G'
			},
			remoteSort : false,
			fitColums : true,
			checkOnSelect : true,
			//singleSelect : false,//是否单选 
			rownumbers : true,//行号 
			frozenColumns : [ [ {
				field : 'ck',
				checkbox : true
			} ] ],
			columns : [ [ {
				field : 'title',
				title : '机构名称',
				width : 200
			}]],
			pagination : true,
            pageList : [ 50, 100 ],//可以设置每页记录条数的列表
            pageSize : 50 //每页显示的记录条数，默认为5  
		});
		//查看详情
		function add(){
			 self.location = ctx+"/prop/form";
		}
		//查看详情
		function edit(){
			 var checkedRows = $("#list_data").datagrid('getChecked');
			 if(checkedRows.length == 1) {
				 self.location = ctx+"/prop/form?id="
						+ checkedRows[0].id;
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
		
		//删除
		function del(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			if(checkedRows.length == 1) {
				$.messager.confirm('确认', '您是否要删除当前选中的记录？', function(r) {
					if(r) {
						$.ajax({
							url : '${pageContext.request.contextPath}/reportitem/delete',
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
		
		function authFun(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			if (checkedRows.length == 1) {
				var rows = $("#gvg_data").treegrid("getChecked");
				if (!rows || rows.length<=0){
					$.messager.show({
						title : '提示',
						msg : '请勾选想要授权的单位!',
						timeout : 3000,
						showType : 'slide'
					});
				}else{
					var svgids="";
					for(var i=0;i<rows.length;i++){
						svgids = svgids+rows[i].id+",";
					}
					console.log(svgids);
					$.ajax({
						url : ctx+'/prop/auth',
						data : "propid="+checkedRows[0].id+"&svgids="+svgids,
						type:'POST',
						dataType : 'json',
						success : function(json) {
							$.messager.show({
								title : '提示',
								msg : json.msg
							});
						}
					});
				}
			} else if(checkedRows.length > 1) {
				$.messager.show({
					title : '提示',
					msg : '只能选择一个记录操作!',
					timeout : 3000,
					showType : 'slide'
				});
			}else {
				$.messager.show({
					title : '提示',
					msg : '请勾选想要授权的记录!',
					timeout : 3000,
					showType : 'slide'
				});
			}
		}
		//搜索
		function doSearch(){
			var param={
				title:$("#title").val()
			};
		    $("#list_data").datagrid("load",param);
	    }
	</script>
</body>
</html>
