<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>机构详情_玉门市中小企业公共服务平台</title>
<link rel="shortcut icon"
	href="${base}/resources/site/images/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/base.css" />
<!--<script type="text/javascript" src="${base}/resources/site/js/hm.js"></script>-->
<script type="text/javascript" src="${base}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/Common.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/HomeAndFavorite.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/index.js"></script>

<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/s_corplist.css" />
<script type="text/javascript">
        $(function () {
        	$(".smlh_title").click(function () {
        		$(".smlh_title").removeClass("smlh_curr");
				$(this).addClass("smlh_curr");
				var id = $(this).attr("target");
				$(".sml_content").hide();
				$("#"+id).show();
				var upid = id.toUpperCase();
				$("#smlh_info").html(upid);
			});
        });
    </script>
</head>
<body>

	<!-- header -->
	[#include "/widget/header.ftl" /]
	
	<!-- header -->
	[#include "/svorg/detailmain_g.ftl" /]
	
	<!-- footer -->
    [#include "/widget/footer.ftl" /]	
</body>
</html>