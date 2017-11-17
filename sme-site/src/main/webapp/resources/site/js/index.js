/* 处理输入关键字搜索查询 */
$(function(){
	$("#search-keywords").focus(function(){
		if("请输入关键字" == $(this).val()){
			$(this).val("");
		}
	}).focusout(function(){
		if("" == $(this).val()){
			$(this).val("请输入关键字");
		}
	});
});

/* 公告、平台信息切换 */
$(function(){
	var index = 0;
	$(".notice-title span").eq(index).addClass("active").siblings().removeClass("active");
	$(".notice-content ul").eq(index).show().siblings().hide();
	$(".notice-more a").attr("href",$(".notice-title span").eq(index).attr("href"));

	$(".notice-title span").mouseover(function(){
		index = $(this).index();
		$(".notice-title span").eq(index).addClass("active").siblings().removeClass("active");
		$(".notice-content ul").eq(index).show().siblings().hide();
		$(".notice-more a").attr("href",$(".notice-title span").eq(index).attr("href"));
	});
});

/* 处理栏目头部更多HREF及栏目切换 */
$(function(){
	var li_nodes = $(".column-header ul li:first-child");
	for(var i = 0; i < li_nodes.length; i++) {
		$(li_nodes[i]).addClass("active").siblings().removeClass("active");
		$(li_nodes[i]).parent().parent().find(">a").attr("href",$(li_nodes[i]).attr("href"));
	}

	$(".column-cont ul:first-child").show().siblings().hide();

	$(".column-header ul li").hover(function(){
		$(this).addClass("active").siblings().removeClass("active");
		$(this).parent().parent().find(">a").attr("href",$(this).attr("href"));

		$(this).parent().parent().parent().find(".column-cont").find("ul").eq($(this).index()).show().siblings().hide();
	},function(){});
});

/* 处理服务需求列表LI的左边距 */
$(function(){
	var li_nodes = $(".service-needs-item ul li");
	for(var i = 0; i < li_nodes.length; i++) {
		if(i % 3 == 0) {
			$(li_nodes[i]).addClass("no_left");
		}
	}
});

/* 处理推荐专家列表边距 */
$(function(){
	var li_nodes = $(".expert ul li");
	for(var i = 0; i < li_nodes.length; i++) {
		if(i % 3 != 0) {
			$(li_nodes[i]).css("margin-left","30px");
		}
	}
});

