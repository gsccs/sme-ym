<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>发布需求- 玉门市中小企业服务平台</title>
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
		
		<link href="${pageContext.request.contextPath}/resources/uploadify/uploadify.css" rel="stylesheet" type="text/css">
		
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
							<li class="active">需求发布</li>
						</ul><!-- .breadcrumb -->

						<div class="nav-search" id="nav-search">
							
						</div><!-- #nav-search -->
					</div>

					<div class="page-content">
						<div class="page-header">
							<h1>需求发布</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

								<form class="form-horizontal" role="form">
									 <input type="hidden" id="id" name="id" value="${sneed.id }"> 
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="title"> 需求标题 </label>

										<div class="col-sm-9">
											<input type="text" id="title" placeholder="需求标题 " class="col-xs-10 col-sm-5" maxlength="100"/>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="Superclass">需求分类</label>
										<div class="col-sm-6">
											 <select id="scode" name="code" onchange="loadSubclass()">
							                    <option value="0">--请选择一级类--</option>
							                </select>
							                <select id="subscode" name="subcode" >
							                	<option value="0">--请选择二级类--</option>
							               	</select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="content"> 具体要求</label>

										<div class="col-sm-3">
											<textarea id="content" name="content" style="width: 570px; height: 300px; visibility: hidden; display: none;"></textarea>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="linker"> 联系人</label>

										<div class="col-sm-3">
											<input type="text" id="linker" name="linker" value="${user.name }" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="linktel"> 联系电话</label>

										<div class="col-sm-3">
											<input type="text" id="linktel" name="linktel" value="${user.phone }" />
										</div>
									</div>
									
									<div class="space-4"></div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" > 附&nbsp;&nbsp;件</label>
										<div class="col-sm-3">
											<table>
						                        <tbody>
						                        <tr>
						                            <td>
						                                <input type="file" value="上传文件" name="uploadify" id="uploadify" width="78" style="display: none;" height="23">
						                            </td>
						                        </tr>
						                        <tr>
						                        	<td id="filelist" colspan="2"></td>
						                        </tr>
						                    	</tbody>
						                    </table>
						                    <span id="fileQueue" style="float: right;" class="uploadifyQueue"></span>
										</div>
									</div>

									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<button id="btn-save" class="btn btn-info" type="button">
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
		<jsp:include page="${pageContext.request.contextPath}/widget/footer.jsp"/>
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
    	var bashpath="${pageContext.request.contextPath}";
        var attachs = new Array();
        $(function () {
            //LoadEditor('textarea[name="content"]', 'editor');
            LoadEditor("#content", "editor");
            $.post(bashpath+"/sclassList", { pclassid: 0 }, function (data) {
            	console.log("sclassList",data);
                var htmlstr = "<option value=\"\">--请选择一级类--</option>";
                for (var i = 0; i < data.length; i++) {
                    htmlstr += "<option value=\"" + data[i].id + "\">" + data[i].title + "</option>";
                }
                $("#scode").html(htmlstr);
                $("#subscode").html("<option value=\"0\">--请选择二级类--</option>");
            });
            
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
                	console.log("response:",response);
                    if (response != null) {
                    	var result = eval("(" + response + ")");
                        var attach = result.data;
                        attachs.push(attach);
                        layer.alert("附件上传成功！");
                        $("#filelist").append(""+attach.filename+"<br>");
                    }
                }
            });

            $("#btn-save").click(function () {
                var content = editor.html();
                var title = $("#title").val();
				if (title==""){
					layer.alert("需求标题不能为空！");
					$("#title").focus();
					return;
				}
				if (content==""){
					layer.alert("具体需求不能为空！");
					$("#content").focus();
					return;
				}
                var sneedData = {
                    title: title,
                    content: content,
                    linker: $("#linker").val(),
                    linktel: $("#linktel").val(),
                    price: $("#price").val(),
                    lasttime: $("#lasttime").val(),
                    scode: $("#scode").val(),
                    subscode: $("#subscode").val(),
                    attachs:attachs
                };
                
                $.ajax({  
                    type: "POST",  
                    url: "/cp/sneed/add",  
                    data: JSON.stringify(sneedData),//将对象序列化成JSON字符串  
                    dataType:"json",  
                    contentType : 'application/json;charset=utf-8', //设置请求头信息  
                    success: function(data){
                    	layer.alert("添加成功！");
                    	window.location.href = "/cp/sneed/list";
                    },  
                    error: function(res){
                    	layer.alert("添加失败，请您检查！");
                	}
                });
            });
        })


        function MobilePhone() {
            var sMobile = $("#txt_Demand_MobilePhone").val();
            var srt = "";
            if (!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(sMobile))) {
                $("#txt_Phone").html("<span  style='padding-left:5px;color:red; padding-left: 8px;'>您输入的手机号不正确请核实后输入正确的手机号：例子（13898888787）</span>");
                $("#txt_Demand_MobilePhone").focus();
                return false;
            } else {
                $("#txt_Phone").html("<span  style='padding-left:5px;color:#a0a0a0; padding-left: 8px;'>号码仅官方可见，不会泄露您的隐私</span>");
                return true;
            }

        }
        function loadSubclass() {
            var Superclassid = $("#scode").val();
            $.post("/sclassList", { pclassid: Superclassid }, function (data) {
                var htmlstr = "";
                for (var i = 0; i < data.length; i++) {
                    htmlstr += "<option value=\"" + data[i].id + "\">" + data[i].title + "</option>";
                }
                if (htmlstr==""){
                	$("#subscode").hide();
                }else{
                	$("#subscode").html(htmlstr);
                }
            });
        }
    </script>
	</body>
</html>
