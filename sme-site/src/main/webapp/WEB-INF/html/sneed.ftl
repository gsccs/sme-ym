<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>需求详情_玉门市中小企业公共服务平台</title>
<link rel="shortcut icon" href="/resources/site/images/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/base.css" />
<script type="text/javascript" src="${base}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/Common.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/HomeAndFavorite.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/need.css" />
<script type="text/javascript">
        $(function () {
            $(".send_bnt").click(function () {
                $.post("/Need/Send", { DemandID: $("#DemandID").val() }, function (result) {
                    if (result.Result == true) {
                        alert(result.Msg);
                        window.location.href = "http://sp.smehn.cn/";
                    } else {
                        if (result.Data == "3") {
                            RedirectLogin("Svc");
                        } else {
                            alert(result.Msg);
                        }
                        return false;
                    }
                });
            });

            $("#hdnTopNav").val("3");
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
	
	<!-- main -->
	[#include "/sneed/detailmain.ftl" /]
	
	<!-- footer -->
    [#include "/widget/footer.ftl" /]	

</body>
</html>