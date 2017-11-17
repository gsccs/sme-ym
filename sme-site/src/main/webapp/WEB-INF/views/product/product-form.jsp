<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>产品发布- 中小企业服务平台</title>
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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/dropzone.css" />
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
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/home/js/CorpProduct.js"></script>
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
							<li class="active">产品发布</li>
						</ul><!-- .breadcrumb -->

						<div class="nav-search" id="nav-search">
							
						</div><!-- #nav-search -->
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>产品发布</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

								<form class="form-horizontal" role="form">
									 <input type="hidden" id="id" name="id" value="${product.id }"> 
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="title"> 产品名称 </label>

										<div class="col-sm-9">
											<input type="text" id="title" placeholder="产品名称" class="col-xs-10 col-sm-5" maxlength="100"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="categoryid"> 产品分类</label>
										<div class="col-sm-3">
											<select id="categoryid" name="categoryid">
												<c:forEach items="${categoryList }" var="cate">
													<option value="${cate.id }">${cate.title }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="price"> 价 格</label>
										<div class="col-sm-3">
											<input type="text" id="price" value="${product.price }" />&nbsp;元
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="storenum"> 库存</label>
										<div class="col-sm-3">
											<input type="text" id="storenum" name="storenum" value="${product.storenum }" maxlength="20" onkeyup="RepNumber(this)"/>&nbsp;件 
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="storenum"> 销量</label>
										<div class="col-sm-3">
											<input type="text" id="salenum" name="salenum" value="${product.salenum }" maxlength="20" onkeyup="RepNumber(this)"/>&nbsp;件 
										</div>
									</div>
									
									<div class="space-4"></div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 产品详情</label>
										<div class="col-sm-9">
											<textarea name="content" id="content" style="width: 570px; height: 348px; visibility: hidden; display: none;"></textarea>
										</div>
									</div>
									<div class="space-4"></div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 产品图片</label>
										<div class="col-sm-9">
											<ul id="imagelist">
												<li><input type="file" value="选择文件" name="uploadify" id="m_imagebtn" width="78" style="display: none;" height="23"></li>
											</ul>
										</div>
									</div>
									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<button id="btn_save"  class="btn btn-info" type="button">
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
		var attachs = new Array();
        $(function () {
            LoadEditor("#content", "editor");
            $("#m_imagebtn").uploadify({
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
                    if (response != null) {
                    	var result = eval("(" + response + ")");
                    	var attach = result.data;
                        attachs.push(attach);
                        $("#imagelist").append('<li><img alt="0" src="' + result.url +
                        '" style="width: 80px; height: 80px;" /><p class="ryzzIntro" onclick="ShowRyzzDetail(this)">点击编辑...</p></li>');
                    }
                }
            });
            
            
            $("#btn_save").click(function () {
                var txtName = editor.html();
                //var nature = $('input[name="nature"]:checked').val();
                var param = {
                	id:$("#id").val(),
                    title: $("#title").val(),
                    price:$("#price").val(),
                    price:$("#price").val(),
                    //categoryid: $("#categoryid").combobox('getValue'),
                    content: txtName,
                    pcode:$("#pcode").val(),
                    ccode:$("#ccode").val(),
                    acode:$("#acode").val()
                    //address: $("#address").val()
                };
                
                
                $.ajax({  
                    type: "POST",  
                    url: "/cp/product/save",  
                    data: JSON.stringify(param),//将对象序列化成JSON字符串  
                    dataType:"json",  
                    contentType : 'application/json;charset=utf-8', //设置请求头信息  
                    success: function(data){
                    	layer.alert("提交成功！");
                    	window.location.href = "/cp/product/list";
                    },  
                    error: function(res){
                    	layer.alert("添加失败，请您检查！");
                	}
                });
            });
        });
    </script>
	</body>
</html>
