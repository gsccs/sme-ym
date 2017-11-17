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
	<div class="easyui-layout" fit="true" border="false">
		<div data-options="region:'north',title:''" style="height: 60px; background: #F4F4F4;">
			<form id="searchForm">
				<table>
				  <tr>
		              <th>姓名：</th>
		              <td><input id="title" name="title" value=""/></td>
	<!-- 	              <th>栏目</th>
		              <td><select id="scode" name="scode">
		              		<option value="">----- 请选择-----</option>
		              		<option value="1">启用</option>
		              		<option value="0">禁用</option>
		              	</select></td> -->
		              <th>状态：</th>
		              <td>
		              	<select id="state" name="state">
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
			<table id="list_data" cellspacing="0" cellpadding="0">
				<thead>
					
				</thead>
			</table>
		</div>
	</div>
	<div id="expert_window"></div>
	<script type="text/javascript">
		$('#list_data').datagrid({
			height : 'auto',
			nowrap : false,
			striped : true,
			border : true,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : '${pageContext.request.contextPath}/expert/datagrid',
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
				field : 'title',
				title : '姓名',
				width : 50
			}, {
				field : 'logo',
				title : '照片',
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
			}, {
				field : 'degree',
				title : '最高学历',
				width : 50
			},{
				field : 'technical',
				title : '技术职称',
				width : 150
			},{
				field : 'proflife',
				title : '专业年限',
				width : 50
			},{
				field : 'phone',
				title : '联系电话',
				width : 100
			},{
				field : 'email',
				title : '邮箱地址',
				width : 100
			},{
				field : 'age',
				title : '年龄',
				width : 100
			},{
				field : 'sex',
				title : '性别',
				width : 100
			},{
				field : 'duties',
				title : '工作职务',
				width : 100
			}] ],
			toolbar : [  {
				text : '服务专家添加',
				iconCls : 'icon-add',
				handler : function() {
					add();
				}
			}, '-',  {
				text : '服务专家修改',
				iconCls : 'icon-edit',
				handler : function() {
					edit();
				}
			}, '-', {
				text : '服务专家删除',
				iconCls : 'icon-remove',
				handler : function() {
					del();
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

		//编辑
		function edit(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			if (checkedRows.length == 1)
				self.location = "${pageContext.request.contextPath}/expert/edit?id="
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
		
		//新增
		 function add(){
			 self.location = "${pageContext.request.contextPath}/expert/add";
		} 
	
		//删除
		function del(){
			var checkedRows = $("#list_data").datagrid('getChecked');
			if(checkedRows.length == 1) {
				$.messager.confirm('确认', '您是否要删除当前选中的记录？', function(r) {
					if(r) {
						$.ajax({
							url : '${pageContext.request.contextPath}/expert/delete',
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
		
		//搜索
		 function searchFunc(){
			 var param = $("#searchForm").serialize();
				var noticeobj={
						title:$("#title").val()
				};
		        $("#list_data").datagrid("load",noticeobj);
	        }
	</script>
</body>
</html>
