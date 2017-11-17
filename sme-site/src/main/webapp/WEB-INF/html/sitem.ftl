<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>服务详情_玉门市中小企业公共服务平台</title>
<link rel="shortcut icon" href="${base}/resources/site/images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/base.css" />
<script type="text/javascript" src="${base}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/Common.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/HomeAndFavorite.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/s_itemlist.css" />
<script type="text/javascript">
        $(function () {
            $("#btnApplcSvc").click(function () {
                torderC();
            });

            $("#bntContact").click(function () {
                $.post("/checkSession", function (result) {
                	console.log("checkSession",result);
                    if (result.success) {
                        $(".iContact").show();
                    } else { // == false || result.Msg != "entp"
                     	//RedirectLogin("Entp");
                        return false;
                    }
                });
            });

            $(".closed").click(function () {
                $(".iContact").hide();
            });

            $("#Q_smb_bnt").click(function () {
                Consult();
            });

            $("#ulNav li").click(function() {
                var index = $(this).index();
                $("#ulNav li").removeClass("hover").eq(index).addClass("hover");
                $(".content").hide().eq(index).show();
            });

            $("#hdnTopNav").val("1");
        });

        function torderC() {
            $.ajax({
                url: "/cp/sorder/addsorder",
                type: "POST",
                data: {sitemid: "${currSitem.id}"},
                success: function (json) {
                	console.log("addorder",json);
                	if (json.success){
                		alert("订购成功，请至我的服务订单中查看！");
	                    window.location.href = "/cp/home.html";
                	}else{
                		if (json.code == "nolog") {
	                        RedirectLogin("Entp");
	                    }else if(json.code == "noitem"){
	                    	alert("服务项目不存在！");
	                    }else if (json.code == "EntpNotExist") {
	                        alert("请先完善企业资料！");
	                        window.location.href = "/cp/corp/orginfo";
	                    }else if(json.code == "ok"){
	                    
	                    }else {
	                        alert(json.mssage);
	                    }
                	}
                }
            })
        }

        function Consult() {
            var title = $("#QTitle").val();
            var content = $("#QContent").val();

            if (title == "") {
                alert("标题不能为空!");
                return false;
            }

            if (content == "") {
                alert("内容不能为空!");
                return false;
            }

            $.ajax({
                url: "/cp/sorder/Addconsult",
                type: "POST",
                data: { title: title, question: content, sitemid: "${currSitem.id}" },
                success: function (resstr) {
                    if (resstr == "nolog") {
                        RedirectLogin("Entp");
                    }
                    else if (resstr == "EntpNotExist") {
                        alert("请先完善企业资料！");
                        window.location.href = "/EntpAdmin/BasicInfo/orginfo";
                    }
                    else {
                        if (resstr == "1") {
                            alert("提交成功，请等待回复！");
                            $("#QTitle").val("");
                            $("#QContent").val("");
                            $(".iContact").hide();
                        }
                        else {
                            alert("提交失败，请重新提交！");
                        }
                    }
                }
            });
        }

        function PaginationOrder(page) {
            //$("#dvLoading").show();
            var pagesize=10;
            $.post("/sorderlist",
                { page: page,pagesize:pagesize, sitemid: "${currSitem.id}" },
                function (json) {
                	console.log("orderlist",json);
                	var strHtml = "";
                	if (json.success && json.data){
	                	$.each(json.data, function (i, order) {
	                        strHtml += '<li><span class="list_title">服务对象：' + order.corptitle +
	                            '</span><span class="list_time">服务时间：' + order.adddatestr + '</span></li>';
	                    });
                	}
                    $("#ulOrderList").html(strHtml);
                    $("#dvPageOrder").html(data.strPage);
                    //$("#dvLoading").hide();
                }
            );
        }

        function PaginationComment(page) {
            //$("#dvLoading").show();
            $.post(
                "/sitemevals",
                { page: page, sitemid: "${currSitem.id}" },
                function (json) {
                    var strHtml = "";
                    if (json.success){
	                    $.each(json.data, function (i, comment) {
	                        strHtml += '<ul><li class="se_detail"><p>' + ((comment.content == undefined || comment.content == "") ? "好评！" : comment.content) +
	                            '</p><span>' + comment.adddatestr + '</span> </li><li class="se_orgname">'  + comment.corptitle + '</li></ul>';
	                    });
                    }
                    $("#dvCommentList").html(strHtml);
                    $("#dvPageComment").html(data.strPage);
                    //$("#dvLoading").hide();
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
	
	<!-- main -->
	[#include "/sitem/detailmain.ftl" /]
	
	<!-- footer -->
    [#include "/widget/footer.ftl" /]	
</body>
</html>