<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>服务活动_玉门市中小企业公共服务平台</title>
<link rel="shortcut icon" href="/resources/site/images/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/base.css" />
<script type="text/javascript" src="${base}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/Common.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/HomeAndFavorite.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/activity.css" />
<script type="text/javascript">
        $(function () {
            $("#CategoryMain a").removeClass("hover").siblings("[rel='0']").addClass("hover");
            $("#AreaMain a").removeClass("hover").siblings("[rel='1']").addClass("hover");

            $("#CategoryMain a").click(function () {
                window.location.href = "/activity.html?scode=" + $(this).attr("rel") + "&ccode=1";
            });

            $("#AreaMain a").click(function () {
                window.location.href = "/activity.html?scode=0&subscode=&ccode=" + $(this).attr("rel");
            });

            $("#hdnTopNav").val("6");
        });

        //活动报名
            function onSignUp(activityid,svgid){
            	 var postdata = {
            	 	actid:activityid,
            	 	svgid:svgid,
            	 	usernum:1
            	 } 
                 $.post("/cp/activity/enroll", postdata, function (result) {
                    if (result.success) {
                        alert(result.msg);
                        //window.location.href = "/EntpAdmin/MyActivity/Index";
                    } else {
                        if (result.Data == "2") {
                            RedirectLogin("Entp");
                        } else {
                            alert(result.Msg);
                        }
                        return false;
                    }
                });
            }
        

        function PaginationNotice(page) {
            $("#dvLoadingNotice").show();
            $.post(
                "/Activity/GetActivityByPage",
                { city: "1", code: "0", page: page, type: 0 },
                function (data) {
                    var strHtml = "";
                    $.each(data.lstActi, function (i, item) {
                        strHtml += '<div class="main"><ul class="n_left"><li class="title"><a href="/Activity/Detail/' + item.ActivityId +
                            '" target="_blank" title="' + item.Title + '">' + CutStr(item.Title, 28) + '</a></li><li>' + CutStr(item.Content, 125) +
                            '</li></ul><dl class="n_right"><dt>活动时间：</dt><dd>' + item.StartTime + ' </dd><dt>活动类别：</dt><dd>' + (item.KindName == null ? " " : item.KindName) +
                            '</dd><dt>活动地址：</dt><dd></dd></dl><div class="signup" onclick="onSignUp(\'' + item.ActivityCode + '\')"></div></div>';
                    });

                    $("#dvActivityNotice").html(strHtml);
                    $("#dvPageNotice").html('<div id="dvLoadingNotice" class="loading"></div>' + data.strPage);
                    $("#dvLoadingNotice").hide();
                }
            );
        }

        function Pagination(page) {
            $("#dvLoading").show();
            $.post(
                "/Activity/GetActivityByPage",
                { city: "1", code: "0", page: page, type: 1 },
                function (data) {
                    var strHtml = "";
                    $.each(data.lstActi, function (i, acti) {
                        strHtml += '<div class="main"><dl class="content"><dt>活动名称：</dt><dd><a href="/Activity/Detail/' + acti.ActivityId +
                            '" target="_blank" title="' + acti.Title + '">' + CutStr(acti.Title, 40) + '</a></dd><dt>活动时间：</dt><dd>' + acti.StartTime +
                            '</dd><dt>活动类别：</dt><dd>' + (acti.KindName == null ? " " : acti.KindName) + '</dd><dt>活动内容：</dt><dd>' + CutStr(acti.Content, 100) +
                            '</dd></dl><div class="evaluation"><a href="/Activity/Detail/' + acti.ActivityId + '" target="_blank"></a></div></div>';
                    });

                    $("#dvActivity").html(strHtml);
                    $("#dvPage").html('<div id="dvLoading" class="loading"></div>' + data.strPage);
                    $("#dvLoading").hide();
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
	<input type="hidden" id="hdnTopNav" value="6" />

	<!-- header -->
	[#include "/widget/header.ftl" /]
	
	<!-- main -->
	[#include "/activity/listmain.ftl" /]
	
	<!-- footer -->
    [#include "/widget/footer.ftl" /]	


</body>
</html>