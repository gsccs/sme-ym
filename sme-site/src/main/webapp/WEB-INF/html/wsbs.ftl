<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>网上办事大厅 - 玉门市中小企业服务平台</title>
<meta http-equiv="X-UA-Compatible" content="IE=8" />

<link rel="stylesheet" type="text/css" href="${base}/resources/wsbs/css/base.css" />
<link rel="stylesheet" type="text/css" href="${base}/resources/wsbs/css/plus.css" />
<link rel="stylesheet" type="text/css" href="${base}/resources/wsbs/css/portal.css" />
<link rel="stylesheet" type="text/css" href="${base}/resources/wsbs/css/project.css" />
<link rel="stylesheet" type="text/css" href="${base}/resources/wsbs/css/wsbs.css" />

<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/base.css" />
<script type="text/javascript" src="${base}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/Common.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/HomeAndFavorite.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/s_corplist.css" />

</head>
<body>
<script type="text/javascript">
var scode;
var svgid;
$(function () {
	//平台统计数据
	$.ajax({  
		type: "GET",  
	    url: "/getWsbsNum",  
	    dataType:"json",  
		success: function(res){
	           console.log("allnum",res);
	          $("#dept_tatal").html(res.govnum);
	          $("#item_total").html(res.topicnum);
	     },  
	     error: function(res){
	            	
	     }
	});		        	                
	        
	        		
	// 点击tab
	$(".ptab").click(function() {
		var selectType = $(this).attr("tag");
		$(".ptab").removeClass("ptabon");
		$(this).addClass("ptabon");
		$("#tab_sclass,#tab_svorg").hide();
		$("#tab_"+selectType).show();
	});

	var showType = $('#showType').attr("tag");
	// 切换展示方式
	$("#showList,#showIcon,#showType").click(function() {
		showType = $(this).attr("tag");
		$("#s_list,#s_icon,#s_type").hide();
		$("#ptype>div[tag=" + showType + "]").show();
		$("#showList,#showIcon,#showType").removeClass("on");
		$(this).addClass("on");
		//onQuery();
	});
	
	//
	$(".sclassLi").click(function() {
		scode = $(this).attr("scode");
		querytopic();
	});
	
	$(".deptLi").click(function() {
		svgid = $(this).attr("svgid");
		querytopic();
	});
});


function querytopic(){
	$.ajax({  
            type: "GET",  
            url: "/appeal/topics?scode="+scode+"&svgid="+svgid,  
            //data: JSON.stringify(postData),//将对象序列化成JSON字符串  
            dataType:"json",  
            //contentType : 'application/json;charset=utf-8', //设置请求头信息  
            success: function(json){
            	var topichtml_=""
            	var topiclist = json.rows;
            	for(var i=0;i<topiclist.length;i++){
            		topichtml_+="<div class='permission'>";
            		topichtml_+="<div class='permission_dept'>";
            		topichtml_+="<img border='0' width='64'height='64' src='"+topiclist[i].svglogo+"'><br>";
				    topichtml_+="<a class='deptname' href='javascript:void(0);' hidefocus='true'>"+topiclist[i].svgtitle+"</a>";
				    topichtml_+="</div>"
					topichtml_+="<div class='permission_info'>"
					topichtml_+="</div>";
					topichtml_+="<div class='permission_online'>";
					topichtml_+="<span> <a href='' target='_blank' class='ibutton'> 在线办理 </a></span>"; 
					topichtml_+="<span> <a class='ibutton nbutton_guide' href='"+topiclist[i].url+"' target='_blank'>办事指南</a></span>";
					topichtml_+="</div>";
					topichtml_+="</div>";
            	}
            	$("#s_list").html(topichtml_);
            },  
            error: function(res){
            	$("#server_msg").show();
				$("#server_msg").html(res.msg);
        	}
    });
}
</script>

<script type="text/javascript">
var permissionList = null; // 列表表格控件
var permissionIcon = null; // 图标表格控件
var permissionType = null; // 目录表格控件
var selectType = ""; // 事项类型
var pageType = "";//不影响selectType用途，增加 页面类型，标识个人或企业 
var showType = ""; // 事项展示方式
var itemParam = ""; // 事项查询参数
var sortType = ""; // 事项排序方式
</script>
	<!-- header -->
	[#include "/widget/header.ftl" /]
	
	<!-- header -->
	[#include "/wsbs/main.ftl" /]
	
	<!-- footer -->
    [#include "/widget/footer.ftl" /]	
		
</body>
</html>