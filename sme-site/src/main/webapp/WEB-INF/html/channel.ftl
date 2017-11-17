<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="keywords" content="服务项目,融资担保,创业服务,管理咨询,法律服务,信息服务,市场开拓,人才培训,技术创新,其他服务,玉门市中小企业公共服务平台" />
<meta name="description" content="服务项目，指向客户提供的服务内容，以满足客户需求。" />

<title>${currChannel.title}_玉门市中小企业公共服务平台</title>
<link rel="shortcut icon" href="#Service/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/base.css" />
<script type="text/javascript" src="${base}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/Common.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/HomeAndFavorite.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/s_infolist.css" />
<script type="text/javascript">
        $(function () {
            
        });
    </script>
</head>
<body>

	<script type="text/javascript">
    $(function () {
        //$("#uTopNav li").removeClass("w_h3_2_dq").eq(parseInt($("#hdnTopNav").val())).addClass("w_h3_2_dq");

        $("#dvCategoryTitle").click(function () {
            $("#uCategoryDetail").slideDown(400);
        });

        $("#uCategoryDetail").mouseleave(function () {
            $("#uCategoryDetail").slideUp(400);
        });

        Search();
    });
</script>
	<!-- header -->
    [#include "/widget/header.ftl" /]
	<!-- main -->
	[#include "/info/listmain.ftl" /]	
	<!-- footer -->
    [#include "/widget/footer.ftl" /]					
</body>
</html>