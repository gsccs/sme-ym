<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>企业能耗-中小企业服务平台</title>
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
							<li class="active">企业帐号</li>
						</ul><!-- .breadcrumb -->

						<div class="nav-search" id="nav-search">
							
						</div><!-- #nav-search -->
					</div>

					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<h3 class="header smaller lighter blue">企业能耗统计</h3>
								<button class="btn btn-info" type="button" onclick="fun_add();">
									<i class="icon-add bigger-110"></i>
									新增
								</button>
								<button class="btn btn-info" type="button" onclick="fun_edit();">
									<i class="icon-edit bigger-110"></i>
									修改
								</button>
								<button class="btn btn-info" type="button" onclick="fun_del();">
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
				url: ctx+"/cp/energy/datagrid",
				datatype: "json",
				mtype: "POST",
				height: 400,
				colNames:['编码','工业总产值','工业增加值', '联系电话','电耗量','水耗量','工业总产值能耗','工业总产值','工业总产值','水耗量','水耗量','水耗量','水耗量'],
				colModel:[
					{name:'id',index:'id', width:60, sorttype:"int"},
					{name:'year',index:'year', width:150},
					{name:'month',index:'month',width:100},
					{name:'grossnum',index:'grossnum', width:90},
					{name:'addednum',index:'addednum', width:90},
					{name:'electrnum',index:'electrnum', width:100},
					{name:'waternum',index:'waternum', width:100},
					{name:'grosspower',index:'grosspower', width:100},
					{name:'grosselectr',index:'grosselectr', width:100},
					{name:'grosswater',index:'grosswater', width:100},
					{name:'addedpower',index:'addedpower', width:100},
					{name:'addedelectr',index:'addedelectr', width:100},
					{name:'addedwater',index:'addedwater', width:100}
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
				caption: "",
				autowidth: true
			});
		});
		
		
		function fun_add(){
			window.location.href = "/cp/energy/form";
		}
		
		function fun_edit(){
			var selectedIds = $("#grid-table").jqGrid("getGridParam", "selarrrow");
			if (selectedIds.length==1){
            	window.location.href = "/cp/energy/form?id="+selectedIds[0];
			}else{
				layer.alert("请选择单条记录！");
				return;
			}
		}
		
		function fun_del(){
			var selectedIds = $("#grid-table").jqGrid("getGridParam", "selarrrow");
			if (selectedIds.length==1){
				$.ajax({  
                    type: "POST",  
                    url: "/cp/energy/delete?id="+selectedIds[0],  
                    dataType:"json",  
                    success: function(res){
                    	layer.msg('删除成功！', {
                    	    time: 5000, //20s后自动关闭
                    		icon: 1,
                    		btn: ['确定'] //按钮
                    	}, function(){
                    		window.location.href = ctx+"/cp/energy";
                    	});
                    },  
                    error: function(res){
                    	layer.alert(res.msg);
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
