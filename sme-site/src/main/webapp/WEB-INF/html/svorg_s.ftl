<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>机构详情_玉门市中小企业公共服务平台</title>
<link rel="shortcut icon" href="${base}/resources/site/images/favicon.ico"
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
            $(".right_title li.title_comm").click(function () {
                var strs = $(this).attr("id").split("_");
                $("#titleHover").css("left", strs[1] + "px").html($(this).html());

                var i = parseInt($(this).index() / 2);
                $(".svc_cont").children("div").hide().eq(i).show();
            });

            $("#hdnTopNav").val("2");
        });

        function Pagination(page) {
            $.post(
                "/Service/GetItemByPage",
                { iSvcUid: 369, page: page },
                function (data) {
                    var strHtml = "";
                    $.each(data.lstPrdt, function (i, item) {
                        strHtml += '<div class="smlc_prdt_img"><div class="img_p"><p class="img-box"><a href="/Service/ItemDetail/' + item.id +
                            '"><img alt="' + item.SERVICE_NAME + '" src="http://img.smehn.cn:8080/upload/Product/' + item.SERVICE_LOG +
                            '" onerror="this.onerror=null;this.src=\'/resources/site/images/no.png\'" /></a></p></div></div>' +
                            '<ul class="smlc_prdt_info"><li class="smlcp_title"><a href="/Service/ItemDetail/' + item.id +
                            '">' + item.SERVICE_NAME + '</a></li><li class="smlcp_cont"><dl><dt>服务区域：</dt><dd>' + item.SERVICE_AREA +
                            '</dd></dl></li><li class="smlcp_cont"><dl><dt>收费标准：</dt><dd>' + item.CHARGE_METHOD + '</dd></dl></li></ul>';
                    });

                    $("#dvPrdt").html(strHtml);
                    $("#dvPage").html(data.strPage);
                }
            );
        }
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
	
	<!-- header -->
	[#include "/svorg/detailmain_s.ftl" /]
	
	<!-- footer -->
    [#include "/widget/footer.ftl" /]	
</body>
</html>