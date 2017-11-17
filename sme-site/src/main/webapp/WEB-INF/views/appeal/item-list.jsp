<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>行政诉求- 中小企业服务平台</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!-- basic styles -->
		<link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/font-awesome.min.css" />

		<!--[if IE 7]>
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/ui.jqgrid.css" />
		<!-- fonts -->

		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />

		<!-- ace styles -->

		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/ace-skins.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->

		<script src="${pageContext.request.contextPath}/resources/assets/js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="${pageContext.request.contextPath}/resources/assets/js/html5shiv.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/respond.min.js"></script>
		<![endif]-->
		
	</head>

	<body>
		<!-- header -->
		<jsp:include page="${pageContext.request.contextPath}/widget/header.jsp"/>
		

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<!-- nav siderbar -->
				<jsp:include page="${pageContext.request.contextPath}/widget/sidebar.jsp"/>
				<!-- content -->

				<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="/home">首页</a>
							</li>
							<li class="active">需求列表</li>
						</ul><!-- .breadcrumb -->

						<div class="nav-search" id="nav-search">
							
						</div><!-- #nav-search -->
					</div>

					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<h3 class="header smaller lighter blue">需求列表</h3>
								<button class="btn btn-info" type="button" onclick="fun_edit();">
									<i class="icon-edit bigger-110"></i>
									修改
								</button>
								<button class="btn btn-info" type="button" onclick="fun_remove();">
									<i class="icon-remove bigger-110"></i>
									删除
								</button>
							</div>
							<div class="col-xs-12">
								<table id="grid-table"></table>
								<div id="grid-pager"></div>
							</div><!-- /.col -->
						</div><!-- /.row -->
						
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->
			</div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div>
	<!-- /.main-container -->
	<jsp:include page="${pageContext.request.contextPath}/widget/footer.jsp"/>
	<script src="${pageContext.request.contextPath}/resources/assets/js/jqGrid/jquery.jqGrid.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/jqGrid/i18n/grid.locale-en.js"></script>

	<script type="text/javascript">
		var ctx="${pageContext.request.contextPath}";
		var $path_base = "/";
		
		jQuery(function($) {
			var grid_selector = "#grid-table";
			var pager_selector = "#grid-pager";
		
			jQuery(grid_selector).jqGrid({
				url: ctx+"/cp/appeal/item/datagrid",
				datatype: "json",
				mtype: "POST",
				height: 300,
				colNames:['需求编码','需求名称','需求分类', '受理单位', '提交时间','办结时间','状态','结果','备注信息'],
				colModel:[
					{name:'id',index:'id', width:60, sorttype:"int"},
					{name:'topictitle',index:'title', width:150},
					{name:'sclassstr',index:'sclassstr',width:90},
					{name:'svgtitle',index:'svgtitle', width:70},
					{name:'addtimestr',index:'addtimestr', width:90},
					{name:'endtimestr',index:'endtimestr', width:90},
					{name:'status',index:'status', width:90,formatter:formatstatus},
					{name:'result',index:'result', width:90,formatter:formatresult},
					{name:'content',index:'content', width:150}
				], 
				viewrecords : true,
				rowNum:10,
				rowList:[10,20,30],
				pager : pager_selector,
				altRows: true,
				//toppager: true,
				
				multiselect: true,
				//multikey: "ctrlKey",
		        multiboxonly: true,
		
				loadComplete : function() {
					var table = this;
					setTimeout(function(){
						//updateActionIcons(table);
						//updatePagerIcons(table);
						//enableTooltips(table);
					}, 0);
				},
		
				caption: "",
				autowidth: true
				//toolbar:[true,"top"]
			});
			
			//$("#t_grid-table").append($('#toolbar').html());   
			
			function formataction(cellval,options,rowobj){
				console.log(rowobj);
				
			}
			function formatstatus(cellval,options,rowobj){
				var str = "";
		    	if(cellval=="0"){
		    		str = "<font style=''>等待受理</font>";
		    	}else if(cellval=="1"){
		    		str = "<font color='green'>办理成功</font>";
		    	}else if(cellval=="2"){
		    		str = "<font color='green'>正在办理</font>";
		    	}else if(cellval=="-2"){
		    		str = "<font color=''>已取消</font>";
		    	}
		    	return str;
			}
			
			function formatresult(cellval,options,rowobj){
				var str = "";
		    	if(cellval=="1"){
		    		str = "<font style=''>同意受理</font>";
		    	}else{
		    		str = "<font color='green'>不同意</font>";
		    	}
		    	return str;
			}
		});
		
		function fun_remove(){
			var selectedIds = $("#grid-table").jqGrid("getGridParam", "selarrrow");
		}
		
		function fun_edit(){
			var selectedIds = $("#grid-table").jqGrid("getGridParam", "selarrrow");
			if (selectedIds.length==1){
            	window.location.href = "/cp/appeal/form?itemid="+selectedIds[0];
			}else{
				layer.alert("请选择单条记录！");
				return;
			}
		}
		
		/*跟踪进度*/
		function fun_trace() {
			var checkedRows = $("#list_data").datagrid('getChecked');
			if (checkedRows.length == 1) {
				$.ajax({  
	                type: "GET",  
	                url: ctx+"/appealtrace/"+checkedRows[0].id,  
	                dataType:"json",  
	                success: function(res){
	                	if (res && res.length>0){
	                		var html_ = "";
	                		for(var i=0;i<res.length;i++){
	                			html_ = html_+"<tr style='  height: 40px;'>";
	                			//html_ = html_+"<td style='text-align:center'>"+(i+1)+"</td>";
	                			if (res[i].svgtitle){
	                				html_ = html_+"<td >"+res[i].svgtitle+"</td>";
	                			}else{
	                				html_ = html_+"<td>"+res[i].corptitle+"</td>";
	                			}
	                			html_ = html_+"<td>"+res[i].addtimestr+"</td>";
	                			html_ = html_+"<td>"+res[i].content+"</td>";
	                			html_ = html_+"</tr>";
	                		}
	                		$("#tracelist").html(html_);
	                	}
	                	
	                	layer.open({
	        				title :'查看办理进度',
	        				type: 1,
	        				area: ['600px', '300px'],
	        				btn: ['确认'],
	        				yes: function(index, layero){ 
	        					layer.closeAll();
	        				},
	        				content: $('#tracebox') //这里content是一个DOM
	        			});
	                },  
	                error: function(res){
	                	layer.alert('查询操作失败!');
	            	}
	            });
				
			} else if(checkedRows.length > 1) {
				layer.alert('只能选择一条记录编辑!');
			}else {
				layer.alert('请选择要编辑的记录!');
			}
		}
		
		/*取消申请*/
		function fun_cancel() {
			var selectedIds = $("#grid-table").jqGrid("getGridParam", "selarrrow");
			if (selectedIds.length==1){
				$.ajax({  
	                type: "POST",  
	                url: ctx+"/cp/appeal/cancel?id="+selectedIds[0],  
	                dataType:"json",  
	                success: function(res){
	                	layer.msg('取消成功！', {
	                	    time: 2000, //20s后自动关闭
	                		icon: 1,
	                		btn: ['确定'] //按钮
	                	}, function(){
	                		window.location.href = ctx+"/cp/appeal/item";
	                	});
	                },  
	                error: function(res){
	                	layer.alert('取消操作失败!');
	            	}
	            });
			}else{
				layer.alert("请选择单条记录！");
				return;
			}
		}
	</script>
	</body>
</html>
