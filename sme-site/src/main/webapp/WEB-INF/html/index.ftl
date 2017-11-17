<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>玉门市中小企业公共服务平台</title>
<link rel="shortcut icon" href="#favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/base.css" />
<script type="text/javascript" src="${base}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/Common.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/HomeAndFavorite.js"></script>

<meta name="keywords"
	content="中小企业,中小企业服务,中小企业公共服务,中小企业服务平台,中小企业公共服务平台,甘肃中小企业,甘肃中小企业公共服务平台,玉门市中小企业公共服务平台" />
<meta name="description"
	content="以市公共服务平台为资源共享、服务协同的枢纽服务平台，以市州综合及产业窗口服务平台为快速响应、服务对接的重要载体，以县（市区）综合窗口平台为集聚资源、了解需求的第一抓手，通过互联互通、资源共享，集聚省内所有优质服务机构，为中小企业提供“找得着、用得起、有保障”的服务，助力我省中小企业健康发展。" />
<!--
<link type="text/css" rel="stylesheet" href="${base}/resources/site/css/css.css" />
<link type="text/css" rel="stylesheet" href="${base}/resources/banner/css/style.css" />
<script type="text/javascript" src="${base}/resources/banner/js/jquery.banner.min.js"></script>
-->
<script type="text/javascript">
        $(function () {
            if (document.getElementById("myscroll")) {
                var scrollup = new ScrollText("myscroll");
                scrollup.LineHeight = 39;        	//单排文字滚动的高度
                scrollup.Amount = 1;            	//注意:子模块(LineHeight)一定要能整除Amount.
                scrollup.Delay = 50;           		//延时
                scrollup.Timeout = 0;
                scrollup.Start();             		//文字自动滚动
                scrollup.Direction = "up"; 			//文字向下滚动
            }
        });
</script>
</head>
<body>
<script type="text/javascript">
    $(function () {
    	Search();
        $(".tab_zcfg").mouseover(function(){
           	$(".tab_zcfg").removeClass("title02_2");
           	$(".tab_zcfg").addClass("title02_3");
            $(this).removeClass("title02_3");
            $(this).addClass("title02_2");
            var id=$(this).attr("id");
            $(".zcfg_list").hide();
            $("#zcfg_"+id).show();
        });
        
        $(".tab_sclass").mouseover(function(){
           	$(".tab_sclass").removeClass("shfw_01");
           	$(".tab_sclass").addClass("shfw_02");
           	$(this).removeClass("shfw_02");
            $(this).addClass("shfw_01");
            var sid=$(this).attr("id");
            $(".sclass_panel").hide();
            $("#sclass_"+sid).show();
        });
        
        $(".tab_link").mouseover(function(){
           	$(".tab_link").removeClass("link_font2");
           	$(".tab_link").addClass("link_font3");
           	$(this).removeClass("link_font3");
            $(this).addClass("link_font2");
            var sid=$(this).attr("id");
            $(".link_panel").hide();
            $("#link_"+sid).show();
        });
    });
</script>
	
	<!-- header -->
	[#include "/widget/header.ftl" /]
    	
	<!-- main -->
	[#include "/index/main.ftl" /]
    
	<!-- footer -->
    [#include "/widget/footer.ftl" /]
    
</body>
</html>