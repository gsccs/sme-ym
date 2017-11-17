<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>企业信息-中小企业服务平台</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />

		<!-- basic styles -->
		<link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/font-awesome.min.css" />

		<!--[if IE 7]>
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->

		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/jquery-ui-1.10.3.custom.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/chosen.css" />

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
							<li class="active">企业信息</li>
						</ul><!-- .breadcrumb -->

						<div class="nav-search" id="nav-search">
							
						</div><!-- #nav-search -->
					</div>

					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

								<form class="form-horizontal" role="form">
									 <input type="hidden" id="corpid" value="${corp.id }" />
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="title"> 企业名称 </label>
										<div class="col-sm-9">
											<input type="text" id="title" placeholder="企业名称" class="col-xs-10 col-sm-5" maxlength="100" value="${corp.title }"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="legaler">法&nbsp;&nbsp;人</label>
										<div class="col-sm-3">
											<input type="text" id="legaler" name="legaler" value="${corp.legaler }" maxlength="10" />										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="linker">联系人</label>
										<div class="col-sm-3">
											<input type="text" id="linker" name="linker" value="${corp.linker }" maxlength="10" />
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="phone"> 联系电话</label>
										<div class="col-sm-3">
											<input type="text" id="phone" value="${corp.phone }" maxlength="15" />
										</div>
									</div>
									<div class="space-4"></div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="hycode"> 行业分类</label>
										<div class="col-sm-2">
											<select class="form-control" id="hycode" onchange="loadHycode()">
												<c:forEach items="${rootindlist }" var="industry">
													<option value="${industry.id }" <c:if test="${industry.id==corp.hycode }">selected="selected"</c:if>>${industry.title }</option>
												</c:forEach>
											</select>
										</div>
										<!-- 
										<div class="col-sm-2">
											<select class="form-control" id="subhycode">
												<c:forEach items="${subindlist }" var="industry">
												<option value="${industry.id }" <c:if test="${industry.id==corp.hycode }">selected="selected"</c:if>>${industry.title }</option>
												</c:forEach>
											</select>
										</div>
										 -->
									</div>
									<!-- 
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="stake"> 控股情况</label>
										<div class="col-sm-2">
											<select class="form-control" id="stake" >
												<c:forEach items="${stakelist }" var="stake">
													<option value="${stake.id }" <c:if test="${stake.id==corp.stake }">selected="selected"</c:if>>${stake.title }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									 -->
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="park"> 所属园区</label>
										<div class="col-sm-2">
											<select class="form-control" id="park" >
												<c:forEach items="${parklist }" var="park">
													<option value="${park.id }" <c:if test="${park.id==corp.parkid }">selected="selected"</c:if>>${park.title }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									
									<div class="space-4"></div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="phone"> 详细地址</label>
										<div class="col-sm-9">
											<input type="text" id="address" value="${corp.address }" class="col-xs-10 col-sm-5"/>
										</div>
									</div>
									<!-- 
									<div class="space-4"></div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="regtype"> 企业类型</label>
										<div class="col-sm-9">
											<input type="text" id="regtype" placeholder="" class="col-xs-10 col-sm-5" value="${corp.regtype }"/>
										</div>
									</div>
									 -->
									<div class="space-4"></div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="orgcode"> 机构代码</label>
										<div class="col-sm-9">
											<input type="text" id="orgcode" placeholder="" class="col-xs-10 col-sm-5" value="${corp.orgcode }"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="email"> 电子邮箱</label>
										<div class="col-sm-9">
											<input type="text" id="email" placeholder="" class="col-xs-10 col-sm-5" value="${corp.email }"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="qqcode"> QQ号码</label>
										<div class="col-sm-9">
											<input type="text" id="qqcode" placeholder="" class="col-xs-10 col-sm-5" value="${corp.qqcode }"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="content"> 企业简介</label>
										<div class="col-sm-9">
											<textarea id="content" name="content" style="width: 570px; height: 300px; visibility: hidden; display: none;">${corp.content }</textarea>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="logo"> 企业LOGO</label>
										<div class="col-sm-9">
											<c:if test="${empty corp.logo }">
											<img id="logoimage" src="${pageContext.request.contextPath}/resources/site/images/no.png" alt="" style="width: 150px; height: 150px;">
											</c:if>
											<c:if test="${not empty corp.logo }">
											<img id="logoimage" src="${corp.logo }" alt="" style="width: 150px; height: 150px;">
											</c:if>
											<div style="position: absolute; bottom: 5px; left: 170px;">
												[大小：150*150]<br> (若无LOGO请上传企业相关图片)
											</div>
											<input id="logo" type="hidden" value="${corp.logo }">
											<div id="uploadify" style="margin: 10px; width: 117px; height: 27px; line-height: 27px; border: 0px; cursor: pointer; color: rgb(21, 74, 145); position: relative; overflow: hidden; direction: ltr;" class="jUploader-button">
												<span style="text-indent: 40px; display: block;">上传新图片</span> 
											</div>
										</div>
									</div>
									
									<div class="space-4"></div>

									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<button id="CORP_SAVE_BTN" class="btn btn-info" type="button">
												<i class="icon-ok bigger-110"></i>
												保存
											</button>

											&nbsp; &nbsp; &nbsp;
											<button class="btn" type="reset">
												<i class="icon-undo bigger-110"></i>
												取消
											</button>
										</div>
									</div>

								</form>
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->

				
			</div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="${pageContext.request.contextPath}/resources/assets/js/jquery-2.0.3.min.js"></script>
		<!-- <![endif]-->

		<!--[if IE]>
		<script src="${pageContext.request.contextPath}/resources/assets/js/jquery-1.10.2.min.js"></script>
		<![endif]-->
		

		<script type="text/javascript">
		</script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<!--[if lte IE 8]>
		  <script src="${pageContext.request.contextPath}/resources/assets/js/excanvas.min.js"></script>
		<![endif]-->

		<script src="${pageContext.request.contextPath}/resources/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/chosen.jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.inputlimiter.1.3.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.maskedinput.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap-tag.min.js"></script>

		<!-- ace scripts -->

		<script src="${pageContext.request.contextPath}/resources/assets/js/ace-elements.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/layer/layer.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/uploadify/jquery.uploadify.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/uploadify/swfobject.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/kindeditor/kindeditor-all-min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/site/js/Common.js"></script>
		<script type="text/javascript">
        $(function () {
            LoadEditor("#content", "editor");
            
            $("#uploadify").uploadify({
                'uploader': '/resources/uploadify/uploadify.swf',
                'script': '/uploadfile',
                'cancelImg': '/resources/uploadify/cancel.png',
                'folder': 'UploadFile',
                'queueID': 'fileQueue',
                'auto': true,
                'multi': false,
                'buttonImg': '/resources/uploadify/uploadify.png',
                'width': 78,
                'height': 23,
                'onComplete': function (event, UserID, fileObj, response, data) {
                	//console.log("data:",data);
                	//console.log("response:",response);
                	
                    if (response != null && response!="") {
                    	var datajson = eval("(" + response + ")");
                        $("#logoimage").attr("src",datajson.data.filepath);
                    }
                }
            });
            
            $("#CORP_SAVE_BTN").click(function () {
                var txtName = editor.html();
                //var nature = $('input[name="nature"]:checked').val();
                var postData = {
                	id:$("#corpid").val(),
                    title: $("#title").val(),
                    legaler:$("#legaler").val(),
                    linker:$("#linker").val(),
                    phone: $("#phone").val(),
                    email: $("#email").val(),
                    //stake: $("#stake").val(),
                    orgcode: $("#orgcode").val(),
                    hycode: $("#hycode").val(),
                    //subhycode: $("#subhycode").val(),
                    content: txtName,
                    //pcode:$("#pcode").val(),
                    //ccode:$("#ccode").val(),
                    logo:$("#logoimage").attr("src"),
                    address: $("#address").val()
                };
                
                console.log("postData:",postData);
                
                $.post("/cp/corp/save", postData, function (data) {
                    if (data.success) {
                    	layer.alert("保存成功！");
                    }else {
                    	layer.alert("添加失败，请您检查！"+data.msg);
                    }
                });
            });
        });
    </script>
	</body>
</html>
