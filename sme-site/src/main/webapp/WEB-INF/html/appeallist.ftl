<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>行政事项_玉门市中小企业公共服务平台</title>
<link rel="shortcut icon" href="/resources/site/images/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/base.css" />
<script type="text/javascript" src="${base}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/Common.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/HomeAndFavorite.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/appeal.css" />
<script type="text/javascript">
        $(function () {
            $("#CategoryMain a").removeClass("hover").siblings("[rel='${gcode!'0'}']").addClass("hover");
            $("#AreaMain a").removeClass("hover").siblings("[rel='${svgid!'0'}']").addClass("hover");

            $("#CategoryMain a").click(function () {
                window.location.href = "/appeal.html?gcode=" + $(this).attr("rel") + "";
            });

            $("#AreaMain a").click(function () {
                window.location.href = "/appeal.html?gcode=0&&svgid=" + $(this).attr("rel");
            });
        });
</script>
</head>
<body>
	<!-- header -->
	[#include "/widget/header.ftl" /]
	
	<!-- main -->
	[#include "/appeal/listmain.ftl" /]
	
	<!-- footer -->
    [#include "/widget/footer.ftl" /]	


</body>
</html>