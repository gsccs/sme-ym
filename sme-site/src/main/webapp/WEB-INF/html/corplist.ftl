<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>企业名录_玉门市中小企业公共服务平台</title>
<link rel="shortcut icon" href="${base}/resources/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/base.css" />
<script type="text/javascript" src="${base}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/Common.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/HomeAndFavorite.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/s_corplist.css" />
<script type="text/javascript">
        $(document).ready(function () {
        	
            $("#CategoryMain a").removeClass("hover").siblings("[rel='${scode!'0'}']").addClass("hover");
            $("#ParkMain a").removeClass("hover").siblings("[rel='${parkid!0}']").addClass("hover");
			
            $("#CategoryMain a").click(function () {
                window.location.href = "/corp.html?scode=" + $(this).attr("rel") + "&keyword=" + $(".key_txt").val();
            });

            $("#ParkMain a").click(function () {
                window.location.href = "/corp.html?scode=${scode}&parkid=" + $(this).attr("rel") + "&keyword=" + $(".key_txt").val();
            });

            $(".bnt_search").click(function () {
                window.location.href = "/corp.html?scode=${scode}&keyword=" + $(".key_txt").val();
            });
            
        });
    </script>
</head>
<body>

<script type="text/javascript">
    $(function () {
    });
</script>
	<input type="hidden" id="scode" value="${scode}" />
	<!-- header -->
	[#include "/widget/header.ftl" /]
	
	<!-- main -->
	[#include "/corp/listmain.ftl" /]
	
	<!-- footer -->
    [#include "/widget/footer.ftl" /]	
	
</body>
</html>