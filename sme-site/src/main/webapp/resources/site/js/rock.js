/* 处理图片滚动 */
$(function(){
	for(var i = 0; i < $(".rock .rock-big li").size(); i++) {
		$(".rock-num").append("<li><span></span></li>");
	}
	$(".rock-num").css("margin-left","-"+($(".rock-num").width()/2-8)+"px");

	var index = 0;
	var times = 2500;
	showImg(index);

	var rockInterval = setInterval(function(){
		index ++;
		if(index == $(".rock .rock-big li").size()) {
			index = 0;
		}
		showImg(index);
	},times);

	$(".rock-num li").hover(function(){
		index = $(this).index();
		showImg(index);
	}, function () {});

	$(".rock-big li").hover(function () {
		$(".rock-position").show();
		clearInterval(rockInterval);
	},function(){
		$(".rock-position").hide();
		rockInterval = setInterval(function(){
			index ++;
			if(index == $(".rock .rock-big li").size()) {
				index = 0;
			}
			showImg(index);
		},times);
	});

	$(".rock-position").hover(function(){
		$(this).show();
		clearInterval(rockInterval);
	},function(){});

	$(".rock-position-left").click(function(){
		index--;
		if(index == -1) {
			index = $(".rock .rock-big li").size()-1;
		}
		showImg(index);
	});

	$(".rock-position-right").click(function(){
		index++;
		if(index == $(".rock .rock-big li").size()) {
			index = 0;
		}
		showImg(index);
	});
});

function showImg(index) {
	$(".rock-num li").eq(index).addClass("active").siblings().removeClass("active");
	$(".rock-big li").eq(index).stop().fadeIn(1000).siblings().hide();
}