<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>无标题文档</title>
<link
	href="${pageContext.request.contextPath}/static/main/css/bootstrap.min.css?v=3.3.5"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/static/main/css/font-awesome.min.css?v=4.4.0"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/static/main/css/animate.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/static/main/css/style.min.css?v=4.0.0"
	rel="stylesheet" />
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
<script type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
</script>
<style type="text/css">
.svg_dl{
	height: 30px;
}
.svg_dt{
	float: left;
	width: 30%;
}
.svg_dd{
	float: left;
	width: 70%;
}
</style>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-6">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>机构信息</h5>
						<div class="ibox-tools">
							<a class="close-link"> <i class="fa fa-times"></i>
							</a>
						</div>
					</div>
					<div class="ibox-content" style="min-height: 175px;">
						<dl class="svg_dl">
							<dt class="svg_dt">机构名称：</dt>
							<dd class="svg_dd">${svorg.title }</dd>
						</dl>
						<dl class="svg_dl">
							<dt class="svg_dt">机构类型：</dt>
							<dd class="svg_dd">
								<c:if test="${svorg.svgtype=='G' }">
									政府服务机构
								</c:if>
								<c:if test="${svorg.svgtype=='S' }">
									社会服务机构
								</c:if>
							</dd>
						</dl>
						<dl class="svg_dl">
							<dt class="svg_dt">单位地址：</dt>
							<dd class="svg_dd">${svorg.address }</dd>
						</dl>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>通知公告</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a> 
							<a class="dropdown-toggle" data-toggle="dropdown"
								href="typography.html#"> <i class="fa fa-wrench"></i>
							</a>
							<ul class="dropdown-menu dropdown-user">
								<li><a href="typography.html#">选项1</a></li>
								<li><a href="typography.html#">选项2</a></li>
							</ul>
							<a class="close-link"> <i class="fa fa-times"></i>
							</a>
						</div>
					</div>
					<div id="notice_list_data" class="ibox-content" style="min-height: 175px;">
						
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-6">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>待办工作</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a> <a class="dropdown-toggle" data-toggle="dropdown"
								href="typography.html#"> <i class="fa fa-wrench"></i>
							</a>
							<ul class="dropdown-menu dropdown-user">
								<li><a href="typography.html#">选项1</a></li>
								<li><a href="typography.html#">选项2</a></li>
							</ul>
							<a class="close-link"> <i class="fa fa-times"></i>
							</a>
						</div>
					</div>
					<div id="sorder_list_data" class="ibox-content"
						style="min-height: 175px;"></div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>咨询信息</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a> <a class="dropdown-toggle" data-toggle="dropdown"
								href="typography.html#"> <i class="fa fa-wrench"></i>
							</a>
							<ul class="dropdown-menu dropdown-user">
								<li><a href="typography.html#">选项1</a></li>
								<li><a href="typography.html#">选项2</a></li>
							</ul>
							<a class="close-link"> <i class="fa fa-times"></i>
							</a>
						</div>
					</div>
					<div id="consilt_list_data" class="ibox-content"
						style="min-height: 175px;"></div>
				</div>
			</div>

		</div>

	</div>
	<script type="text/javascript">
		$('#notice_list_data').datagrid({
			height : 'auto',
			nowrap : false,
			striped : true,
			border : false,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : ctx + '/info/noticeList?channelid=102',
			remoteSort : false,
			fitColums : true,
			checkOnSelect : true,
			columns : [ [ {
				field : 'title',
				title : '标题',
				width : 300,
				formatter:function(value,row){
			   		return str = "<a href='http://www.smeym.org/info-"+row.id+".html' target='blank'>"+value+"</a>";
				}
			}, {
				field : 'addtimestr',
				title : '发布日期',
				width : 100
			}, {
				field : 'svgtitle',
				title : '发布单位',
				width : 150
			}] ]
			
		});
		
		//代办任务
		$('#sorder_list_data').datagrid({
			height : 'auto',
			nowrap : false,
			striped : true,
			border : false,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : ctx + '/appeal/item/datagrid',
			remoteSort : false,
			fitColums : true,
			checkOnSelect : true,
			singleSelect : true,//是否单选 
			rownumbers : true,//行号 
			columns : [ [ {
				field : 'topictitle',
				title : '事项名称',
				width : 150,
				formatter : function(value, row) {
					var str = "";
					if (row.pushnum > 0) {
						str = "<font color='red'>"+value+"</font>";
					}else{
						str = value;
					}
					return str;
				}
			}, {
				field : 'corptitle',
				title : '申请企业',
				width : 150
			}, {
				field : 'addtimestr',
				title : '提交日期',
				width : 100
			}, {
				field : 'status',
				title : '状态',
				width : 100,
				formatter:function(value,row){
			    	var str = "";
			    	if(value=='0'){
			    		str = "等待受理";
			    	}else if(value=='1') {
			    		str = "<font color='green'>已办理</font>";
			    	}else if(value=='2') {
			    		str = "正在办理";
			    	}else if(value=='-2') {
			    		str = "已取消";
			    	}
			    	return str;
				}
			} ] ]
		});

		$('#consilt_list_data').datagrid({
			height : 'auto',
			nowrap : false,
			striped : true,
			border : false,
			collapsible : false,//是否可折叠的 
			fit : true,//自动大小 
			loadMsg : '数据加载中请稍后……',
			url : ctx + '/consilt/datagrid?status=0',
			remoteSort : false,
			fitColums : true,
			checkOnSelect : true,
			columns : [ [ {
				field : 'corptitle',
				title : '咨询企业',
				width : 150
			},{
				field : 'content',
				title : '咨询内容',
				width : 150
			},{
				field : 'addtimestr',
				title : '时间',
				width : 150
			}, {
				field : 'status',
				title : '状态',
				width : 100,
				formatter : function(value, row) {
					var str = "";
					if (value == '1') {
						str = "<font color='green'>已回复</font>";
					}else{
						str = "<a href='#'>等待回复</a>";
					}
					return str;
				}
			} ] ]
		});
	</script>
	<script
		src="${pageContext.request.contextPath}/static/main/js/jquery.min.js?v=2.1.4"></script>
	<script
		src="${pageContext.request.contextPath}/static/main/js/bootstrap.min.js?v=3.3.5"></script>
</body>
</html>
