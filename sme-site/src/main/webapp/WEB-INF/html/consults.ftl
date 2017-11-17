<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>服务咨询_玉门市中小企业公共服务平台</title>
<link rel="shortcut icon" href="${base}/resources/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/base.css" />
<script type="text/javascript" src="${base}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/Common.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/HomeAndFavorite.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/s_itemlist.css" />
<script type="text/javascript">
        $(function () {
        	
            $("#CategoryMain a").removeClass("hover").siblings("[rel='${scode!'0'}']").addClass("hover");
            $("#CategorySub a").removeClass("hover");
            $("#CategorySub a[rel='${subscode!''}']").addClass("hover");
			
			var scode = $("#scode").val();
			if (scode && scode!=0){
				$("#CategorySub").show();
			}else{
				$("#CategorySub").hide();
			}

            $("#CategoryMain a").click(function () {
                window.location.href = "/consults.html?scode=" + $(this).attr("rel") + "&keyword=" + $(".key_txt").val();
            });

            $("#CategorySub a").click(function () {
                window.location.href = "/sitem.html?scode=${scode}&subscode=" + $(this).attr("rel") + "&keyword=" + $(".key_txt").val();
            });

            $(".bnt_search").click(function () {
                window.location.href = "/consults.html?scode=${scode}&subscode=${subscode}&keyword=" + $(".key_txt").val();
            });
        });
    </script>
</head>
<body>
	<input type="hidden" id="scode" value="${scode}" />
	
	<script type="text/javascript">
    $(function () {
    });
</script>
	<!-- header -->
    [#include "/widget/header.ftl" /]
	
	<!-- main -->
	[#include "/consult/listmain.ftl" /]	
						
	<!-- footer -->
    [#include "/widget/footer.ftl" /]					
</body>
</html>