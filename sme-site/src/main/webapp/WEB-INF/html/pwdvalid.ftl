<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>密码找回_玉门市中小企业公共服务平台</title>
<link rel="shortcut icon" href="${base}/resources/site/images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/base.css" />
<script type="text/javascript" src="${base}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/Common.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/HomeAndFavorite.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/resources/wsbs/css/project.css" />
<script type="text/javascript" src="${base}/resources/layer/layer.js"></script>
<style>
	.tab_item{
		background-color: #F4F4F4;
		float: left;
		font-size: 17px;
		height: 40px;
		line-height: 40px;
		color: #FFFFFF;
		text-align: center;
  		width: 170px;
	}
	
	.curr_item{
		background-color: #2AA3DB;
	}
	
	.zxzx_input{
		width: 305px;
	  height: 30px;
	  line-height: 30px;
	  border: 1px solid #b0b0b0;
	  font-size: 14px;
	  color: #333;
	}
	
	.zxzx_td_title{
		width: 110px;
	  line-height: 47px;
	  font-size: 14px;
	  color: #333;
	  text-align: right;
	}
	</style>
</head>
<body>

<script type="text/javascript">
    $(function () {
    	$("#reset").click(function() {   
		   $("form").each(function() {   
		   		this.reset(); 
		   });  
		}); 
		  
		$("#btn_pwd").click(function () {
				var pwd = $("#pwd").val();
				var newpwd= $("#newpwd").val();
				if (account==""){
					layer.alert("登录密码不能为空！");
					$("#pwd").focus();
					return;
				}
				if (pwd != newpwd){
					layer.alert("密码输入不一致！");
					$("#newpwd").focus();
					return;
				}
                var param = {
                    account: $("#account").val(),
                    pwd: $("#pwd").val()
                };
                
                $.ajax({  
                    type: "POST",  
                    url: "/pwdupdate",  
                    data: param,//将对象序列化成JSON字符串  
                    dataType:"json",  
                    success: function(data){
                    	$("#tab_form").hide();
                    	$("#tab_info").show();
                    	layer.alert("密码修改成功！");
                    },  
                    error: function(res){
                    	layer.alert("修改失败，请您检查！");
                	}
                });
            });
    });
</script>

	<!-- header -->
	[#include "/widget/header.ftl" /]
	
	<!-- main -->
	[#include "/home/pwd_valid.ftl" /]
	
	<!-- footer -->
    [#include "/widget/footer.ftl" /]			
</body>
</html>