<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>发布产品_企业管理后台_玉门市中小企业公共服务平台</title>
    <link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/home/css/webindex.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/home/css/admin.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/home/css/main.css" />
<link id="changbj" rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/home/css/base.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/site/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/site/js/Common.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/kindeditor/kindeditor-all-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/home/js/CorpProduct.js"></script>

<script src="${pageContext.request.contextPath}/resources/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/uploadify/swfobject.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/resources/uploadify/uploadify.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
        $(function () {
        	loadCity();
            LoadEditor("#content", "editor");
			
           /*  $('#categoryid').combotree({
        	    url: '/categoryTree',
        	    required: true,
        	    valueField:'id',
        	    textField:'title',
        	    method:'post'
        	});  */
            
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
                    if (response != null) {
                    	var result = eval("(" + response + ")");
                        $("#ryzzImgList").append('<li><img alt="0" src="' + result.url +
                        '" style="width: 80px; height: 80px;" /><p class="ryzzIntro" onclick="ShowRyzzDetail(this)">点击编辑...</p></li>');
                    }
                }
            });

            $(".ryzzImg").mouseover(function () {
                //$(".ryzzImg").removeClass("hover");
                //$(this).addClass("hover");
                $("#actiImgClose").show();
                $("#actiImgClose").css("top", $(this).position().top);
                $("#actiImgClose").css("left", $(this).position().left + 67);
                $("#actiImgClose").attr("rel", $(this).attr("alt"));
                $(this).parent().attr("id", $(this).attr("alt"));
            }).mouseout(function () {
                //$(this).removeClass("hover");
                //$("#actiImgClose").hide();
            });

            $("#actiImgClose").click(function () {
                if (confirm("确认要删除吗？")) {
                    id = $(this).attr("rel");
                    $.post("/cp/product/deleteAlbum", { id: id }, function (data) {
                        if (data == "1") {
                            $("#actiImgClose").removeAttr("rel");
                            $("#actiImgClose").hide();
                            $("#" + id).remove();
                        }
                    });
                }
            });
            
            
            $("#PRODUCT_SAVE_BTN").click(function () {
                var txtName = editor.html();
                //var nature = $('input[name="nature"]:checked').val();
                var postDate = {
                	id:$("#corpid").val(),
                    title: $("#title").val(),
                    price:$("#price").val(),
                    //categoryid: $("#categoryid").combobox('getValue'),
                    content: txtName,
                    pcode:$("#pcode").val(),
                    ccode:$("#ccode").val(),
                    acode:$("#acode").val(),
                    address: $("#address").val()
                };
                
                $.post("/cp/product/save", postDate, function (data) {
                    if (data.success) {
                        $.messager.alert("友情提示", "添加成功！", "error");
                    }else {
                        $.messager.alert("友情提示", "添加失败，请您检查!", "info", function () {
                        });
                    }
                });
            });
        });
        
        
      //加载市县
        function loadCity() {
            $.post('/areaList', { parid: $("#pcode").val() }, function (objs) {
            	console.log("arealist",objs);
                var htmlstr = "";
                if (objs.length == 0) {
                	htmlstr = "<option value='' selected>选择城市</option>";
	            }
	            for (var i = 0; i < objs.length; i++) {
	                htmlstr += "<option value='" + objs[i].code + "'>" + objs[i].name + "</option>";
	            }
                $("#ccode").html(htmlstr);
            });
        }
    	
        function loadArea() {
            $.post('/areaList', { parid: $("#ccode").val() }, function (objs) {
            	console.log("arealist",objs);
                var htmlstr = "";
                if (objs.length == 0) {
                	htmlstr = "<option value='' selected>选择地域</option>";
	            }
	            for (var i = 0; i < objs.length; i++) {
	                htmlstr += "<option value='" + objs[i].code + "'>" + objs[i].name + "</option>";
	            }
                $("#acode").html(htmlstr);
            });
        }
        
    </script>

<link href="${pageContext.request.contextPath}/resources/kindeditor/themes/default/default.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/home/css/Site.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!-- header -->
<jsp:include page="${pageContext.request.contextPath}/widget/header.jsp"/>
		
<div class="admin_right">
    <div class="indent_title">
        <img src="${pageContext.request.contextPath}/resources/home/images/t_05.jpg" width="5" height="17" class="fl"><span>发布产品</span>
    </div>
    <div class="clear" style="height: 10px; line-height: 10px;">
    </div>
    <div class="Info_center" id="Note">
        <div class="clear"></div>
        <input type="hidden" id="productid" value="${product.id }"> 
        <dl class="info_dl">
            <dt class="fm_dt"><span class="fr">产品名称：</span><font class="fr">*</font></dt>
            <dd>
                <div class="left info_div5" style="width: 470px;">
                <input type="text" id="title" class="info_input" placeholder="请填写产品名称" value="${product.title }" maxlength="100"></div>
            </dd>
        </dl>
        <dl class="info_dl">
            <dt class="fm_dt"><span class="fr">产品分类：</span><font class="fr">*</font></dt>
            <dd>
                <input type="text" id="categoryid" value="${product.categoryid }" />
            </dd>
        </dl>
        <dl class="info_dl">
            <dt class="fm_dt"><span class="fr">价 格：</span><font class="fr">*</font></dt>
            <dd>
                <div class="left info_div5" style="width: 150px;">
                    <input type="text" id="price" class="info_input" placeholder="请填写价格" value="${product.price }" maxlength="13" onkeyup="RepNumber(this)">元</div>
            </dd>
        </dl>
        <dl class="info_dl">
            <dt class="fm_dt"><span class="fr">单 位：</span><font class="fr">*</font></dt>
            <dd>
                <div class="left info_div5" style="width: 150px;">
                <input type="text" id="txtUnit" class="info_input" placeholder="请填写单位" value="" maxlength="20"></div>
            </dd>
        </dl>
        <dl class="info_dl">
            <dt class="fm_dt"><span class="fr">重量：</span></dt>
            <dd>
                <div class="left info_div5" style="width: 150px;">
                <input type="text" id="txtSpec" class="info_input" placeholder="请填写重量" value="" maxlength="20" onkeyup="RepNumber(this)">千克</div>
            </dd>
        </dl>
        <dl class="info_dl">
            <dt class="fm_dt"><span class="fr">所在区域：</span><font class="fr">*</font></dt>
            <dd>
	            <select id="pcode" onchange="loadCity()" style="width: 75px; height: 18px; border: 0px; border: 1px solid #000;">
					<option value="62" selected="selected">甘肃省</option>
				</select> 省 
                <select id="ccode" onchange="loadArea()" style="width: 170px;">
                    <option value="">--请选择城市--</option>
                </select>
                                         市
                <select id="acode" style="width: 170px;">
                    <option value="">--请选择区县--</option>
                </select>区/县
            </dd>
        </dl>
        <dl class="info_dl">
            <dt class="fm_dt"><span class="fr">产品详情：</span></dt>
            <dd style="height: 350px;">
                <div class="left">
                    <textarea name="content" id="content" style="width: 570px; height: 348px; visibility: hidden; display: none;"></textarea>
                </div>
            </dd>
        </dl>
        <dl class="info_dl">
            <dt class="fm_dt"><span class="fr">封面图片：</span></dt>
            <dd style="height: auto;">
                <ul id="ryzzImgList" class="img_list"></ul>
                <input type="text" id="txtActiImgDetail" style="position: absolute; top: 150px; left: 30px;
                    width: 78px; display: none;">
                <div id="actiImgClose" style="position: absolute; top: 68px; left: 108px; cursor: pointer;
                    background: #ccc; color: #fff; width: 7px; height: 15px; line-height: 15px; padding: 0 4px;
                    display: none;">
                   		 ╳
                </div>
                <div class="clear_all"> </div>
                <div id="uploadkj" class="img_btn jUploader-button" style="cursor: pointer; position: relative; overflow: hidden; direction: ltr;">
                <input type="file" value="上传文件" name="uploadify" id="uploadify" width="78" style="display: none;" height="23">
                </div>
            </dd>
        </dl>
        <div style="width: 200px; margin: 0 auto; padding-top: 40px;">
            <img src="${pageContext.request.contextPath}/resources/home/images/fabubg.png" width="150" height="25" style="cursor: pointer;" id="PRODUCT_SAVE_BTN">
        </div>
        <div class="clear" style="height: 20px; line-height: 20px;"></div>
    </div>
    <div class="Info_bottom">
    </div>
</div>

</body>
</html>