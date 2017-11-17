<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>平台帐号注册_玉门市中小企业公共服务平台</title>
<link rel="shortcut icon" href="${base}/resources/site/images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/base.css" />
<script type="text/javascript" src="${base}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/jquery.unobtrusive-ajax.min.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/Common.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/loginreg.css" />
<script type="text/javascript" src="${base}/resources/site/js/LogRegValidate.js" ></script>
<script type="text/javascript">
        //加载区县
        function LoadArea() {
            $.post('/areaList', { parid: $("#selCity").val() }, function (objs) {
            	console.log("arealist",objs);
                var htmlstr = "";
                if (objs.length == 0) {
                	htmlstr = "<option value='' selected>选择城市</option>";
	            }
	            for (var i = 0; i < objs.length; i++) {
	                htmlstr += "<option value='" + objs[i].code + "'>" + objs[i].name + "</option>";
	            }
                $("#selArea").html(htmlstr);
            });
        }
		
        $(function () {
        	LoadArea();
        	$("#regBtn").click(function () {
                var postData = {
                    account: $("#account").val(),
                    password: $("#txtPwd").val(),
                    name: $("#linker").val(),
                    phone: $("#linktel").val(),
                    email:$("#email").val(),
                    usertype:$("#REG_TYPE").val()
                };
                if ($("#REG_TYPE").val()=="G"){
                	postData.orgid=$("#orgid").val();
                }
                if ($("#REG_TYPE").val()=="C"){
                	postData.orgname=$("#orgname_C").val();
                }
                if ($("#REG_TYPE").val()=="S"){
                	postData.orgname=$("#orgname_S").val();
                }
                console.log("postData",postData);
                $.ajax({  
                    type: "POST",  
                    url: "/regist",  
                    data: JSON.stringify(postData),//将对象序列化成JSON字符串  
                    dataType:"json",  
                    contentType : 'application/json;charset=utf-8', //设置请求头信息  
                    success: function(data){
                    	console.log(data);
                    	if(data.success){
                    		$("#regform").hidden();
                    		$("#regresult").show();
                    		//window.location.href = "/index.html";
                    	}
                    },  
                    error: function(res){
                    	alert("友情提示", "添加失败，请您检查", "error");
                	}
                });
              });
        });
    </script>

</head>
<body>
	
	<!-- header -->
    [#include "/widget/header.ftl" /]
    <!--class="container" -->
	[#include "/regist/main.ftl" /]
	<!-- footer -->
    [#include "/widget/footer.ftl" /]

</body>
</html>