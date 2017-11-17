$(function(){

	  $("#b").load("Ðü¸¡´°¿Ú.html");
  
		   
		   
	$(window).scroll(function(){
		var scrollTop = document.body.scrollTop || document.documentElement.scrollTop || 0;
		$(".christmas_ad").stop();
		var scrollTop2 = (scrollTop+160) - $(".christmas_ad").position().top;
		$(".christmas_ad:not(:animated)").animate({top:"+="+scrollTop2+"px"},1000);
	
	})
}) 

 function closead(){
    $(".christmas_ad").hide();	 
 }

