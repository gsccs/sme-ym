<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>进度查询_玉门市中小企业公共服务平台</title>
<link rel="shortcut icon" href="${base}/resources/site/images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/base.css" />
<script type="text/javascript" src="${base}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/Common.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/HomeAndFavorite.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/resources/wsbs/css/project.css" />

</head>
<body>

<script type="text/javascript">
    $(function () {
		$(".tab_item").mouseover(function(){
		  $(".tab_item").removeClass("curr_item");
          $(this).addClass("curr_item");
          
          $(".busy-title-tab").hide();   
          var activeTab = $(this).attr("target");   
          $("#"+activeTab).show();  
		});
    });
</script>

	<!-- header -->
	[#include "/widget/header.ftl" /]
	
	<!-- main -->
	[#include "/wsbs/query.ftl" /]
	
	<!-- footer -->
    [#include "/widget/footer.ftl" /]	
</body>
</html>