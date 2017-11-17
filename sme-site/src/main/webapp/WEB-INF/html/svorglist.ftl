<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>服务机构_玉门市中小企业公共服务平台</title>
<link rel="shortcut icon" href="${base}/resources/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/base.css" />
<!--<script src="${base}/resources/site/js/hm.js"></script>-->
<script type="text/javascript" src="${base}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/Common.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/HomeAndFavorite.js"></script>
<!--<script type="text/javascript" src="${base}/resources/site/js/index.js"></script>-->
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/s_corplist.css" />
<script type="text/javascript">
        $(document).ready(function () {
        	
        	//$("#hdnTopNav").val("2");
            $("#CategoryMain a").removeClass("hover").siblings("[rel='${scode!'0'}']").addClass("hover");
            $("#CategorySub a").removeClass("hover");
            $("#CategorySub a[rel='${subscode!''}']").addClass("hover");
            $("#AreaMain a").removeClass("hover").siblings("[rel='${ccode!62}']").addClass("hover");
            $("#AreaSub a").removeClass("hover");
            $("#AreaSub a[rel='']").addClass("hover");
			
            var scode = $("#scode").val();
			if (scode && scode!=0){
				$("#CategorySub").show();
			}else{
				$("#CategorySub").hide();
			}
            
            if(1 > 1) {
                $("#AreaSub").show();
            }
            else {
                $("#AreaSub").hide();
            }

            $("#CategoryMain a").click(function () {
                window.location.href = "/svorg.html?scode=" + $(this).attr("rel") + "&subscode=0&city=1&area=&keyword=" + $(".key_txt").val();
            });

            $("#CategorySub a").click(function () {
                window.location.href = "/svorg.html?scode=${scode}&subcode=" + $(this).attr("rel") + "&city=1&area=&keyword=" + $(".key_txt").val();
            });

            $("#AreaMain a").click(function () {
                window.location.href = "/svorg.html?scode=${scode}&subscode=${subscode}&city=" + $(this).attr("rel") + "&area=0&keyword=" + $(".key_txt").val();
            });

            $("#AreaSub a").click(function () {
                window.location.href = "/svorg.html?scode=${scode}&subscode=&city=1&area=" + $(this).attr("rel") + "&keyword=" + $(".key_txt").val();
            });
            
            $("#svg_type_G").click(function () {
                window.location.href = "/svorg.html?svgtype=G&keyword=" + $(".key_txt").val();
            });
            $("#svg_type_S").click(function () {
                window.location.href = "/svorg.html?scode=${scode}&subscode=${subscode}&city=1&svgtype=S&keyword=" + $(".key_txt").val();
            });

            $(".bnt_search").click(function () {
                window.location.href = "/svorg.html?scode=${scode}&subcode=&city=1&area=&keyword=" + $(".key_txt").val();
            });

            
        });
    </script>
</head>
<body>

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
	
	<input type="hidden" id="hdnLoginStatus" value="SVC" />
	<input type="hidden" id="hdnTopNav" value="4" />
	<input type="hidden" id="hdnWebUrl" value="#" />
	<input type="hidden" id="scode" value="${scode}" />
	
	<!-- main -->
	[#include "/svorg/listmain.ftl" /]
	
	<!-- footer -->
    [#include "/widget/footer.ftl" /]	
	
</body>
</html>