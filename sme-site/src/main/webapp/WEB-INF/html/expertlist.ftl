<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>专家咨询_玉门市中小企业公共服务平台</title>
<link rel="shortcut icon" href="${base}/resources/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/base.css" />
<script type="text/javascript" src="${base}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/Common.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/HomeAndFavorite.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/expert.css" />

<script type="text/javascript">
        $(function () {
            $("#CategoryMain a").removeClass("hover").siblings("[rel='${scode!0}']").addClass("hover");
            $("#AreaMain a").removeClass("hover").siblings("[rel='${ccode!0}']").addClass("hover");

            $("#CategoryMain a").click(function () {
                window.location.href = "/expert.html?scode=" + $(this).attr("rel") + "&ccode=${ccode}&keyword=" + $(".key_txt").val();
            });

            $("#AreaMain a").click(function () {
                window.location.href = "/expert.html?scode=${scode}&ccode=" + $(this).attr("rel") + "&keyword=" + $(".key_txt").val();
            });

            $(".bnt_search").click(function () {
                window.location.href = "/expert.html?code=${scode}&ccode=${ccode}&keyword=" + $(".key_txt").val();
            });

            $("#hdnTopNav").val("4");
        });
    </script>
</head>
<body>
	
	<input type="hidden" id="hdnLoginStatus" value="SVC" />
	<input type="hidden" id="hdnTopNav" value="4" />
	<input type="hidden" id="hdnWebUrl" value="#" />
	
	
	<script type="text/javascript">
    $(function () {
        $("#uTopNav li").removeClass("w_h3_2_dq").eq(parseInt($("#hdnTopNav").val())).addClass("w_h3_2_dq");

        $("#dvCategoryTitle").click(function () {
            $("#uCategoryDetail").slideDown(400);
        });

        $("#uCategoryDetail").mouseleave(function () {
            $("#uCategoryDetail").slideUp(400);
        });

        Search();

        CheckSession(1);
    });
</script>

	<!-- header -->
	[#include "/widget/header.ftl" /]

	<!-- main -->
    [#include "/expert/listmain.ftl" /]	
	
	<!-- footer -->
    [#include "/widget/footer.ftl" /]	
</body>
</html>