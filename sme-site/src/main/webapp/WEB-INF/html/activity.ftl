<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>服务活动详情_玉门市中小企业公共服务平台</title>
<link rel="shortcut icon" href="/resources/site/images/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/base.css" />
<script type="text/javascript" src="${base}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/Common.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/HomeAndFavorite.js"></script>

<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/need.css" />

<script type="text/javascript">
        $(function () {
            if("0" == "0") {
                $("#dvEvaluation").hide();
                //$("#dvTidbits").hide();
                $("#dvTidbitsTitle").html("活动图片");
                $("#dvSignup").show();
            } else {
                $("#dvEvaluation").show();
                $("#dvTidbits").show();
                $("#dvSignup").hide();
            }

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

            $("#dvSubmit").click(function () {
                if($("#txtEvaluation").val() == "") {
                    $("#txtEvaluation").focus();
                    return false;
                } else if ($("#txtCode").val() == "") {
                    $("#txtCode").focus();
                    return false;
                }

                $.post(
                    "/Activity/AddComment",
                    { ActivityId: 4546, Detail: $("#txtEvaluation").val(), code: $("#txtCode").val() },
                    function (result) {
                        if (result.Result == true) {
                            alert("提交成功！");
                            $("#txtEvaluation").val("");
                            $("#txtCode").val("");
                        } else {
                            if (result.Data == "3") {
                                RedirectLogin("Entp");
                                return false;
                            }

                            alert(result.Msg);
                            ChangeCode();
                            $("#txtCode").val("");

                            if (result.Data == "0") {
                                $("#txtCode").focus();
                            } else if (result.Data == "1") {
                                $("#txtEvaluation").focus();
                            } else if (result.Data == "2") {
                                $("#txtEvaluation").val("");
                            }
                        }
                    }
                );
            });

            $("#hdnTopNav").val("6");
        });

        //验证码
        function ChangeCode() {
            $("#imgCode").attr("src", "/Home/GetValidateCode?time=" + (new Date()).getTime());
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
	[#include "/activity/detailmain.ftl" /]
	
	<!-- footer -->
    [#include "/widget/footer.ftl" /]	
</body>
</html>