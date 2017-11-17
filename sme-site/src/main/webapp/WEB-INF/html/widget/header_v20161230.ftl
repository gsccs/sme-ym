<div class="warp">
	<!--页头 start-->
	<div style="height: 318px;">
	<div style="width:1000px;">
	   <!--页头注释 start-->
	   <div style="height:36px; line-height:36px;">
	     <div style=" float:right;">
	     	<@shiro.guest> 
	     	[<a href="http://account.smeym.org/logout">登录</a>]&nbsp;&nbsp;
	     	[<a href="/reg.html">注册</a>]&nbsp;&nbsp;
	     	</@shiro.guest>
			<@shiro.user>
			[<a href="/home.html">会员中心</a>]&nbsp;&nbsp;
			</@shiro.user> 
	     	|&nbsp;&nbsp;<a href="javascript:void(0)" onclick="AddFavorite('玉门市中小企业公共服务平台', 'http://www.smeym.org/')" title="收藏本站"> 收藏本站</a></div>
		 <div style=" float:left;">
		 	<script>
					var d=new Date();
					function a(num){
					 switch(num){
					  case 0:return "1";break;
					  case 1:return "2";break;
					  case 2:return "3";break;
					  case 3:return "4";break;
					  case 4:return "5";break;
					  case 5:return "6";break;
					  case 6:return "7";break;
					  case 7:return "8";break;
					  case 8:return "9";break;
					  case 9:return "10";break;
					  case 10:return "11";break;
					  case 11:return "12";break;
					 }
					}
					function b(num){
					 switch(num){
					  case 0:return "日";break;
					  case 1:return "一";break;
					  case 2:return "二";break;
					  case 3:return "三";break;
					  case 4:return "四";break;
					  case 5:return "五";break;
					  case 6:return "六";break;
					 }
					}
					document.write(d.getFullYear()+"年"+a(d.getMonth())+"月"+d.getDate()+"日 星期"+b(d.getDay()));
				</script>
		 <span class="STYLE1">欢迎来到玉门市中小企业公共服务平台！</span>
		 </div>
		 <div class="clear"></div>
	   </div>
	   <!--页头注释 end-->
	   <!--flash start-->
	   <div style="width:1000px; height:232px;">
	     <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="1000" height="232">
	       <param name="movie" value="${base}/resources/site/images/top.swf" />
	       <param name="quality" value="high" />
	       <embed src="${base}/resources/site/images/top.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="1000" height="232"></embed>
	     </object> 
	   </div>
	   <!--flash end-->
	   <!--菜单 start-->
	     <div style="width:1000px; height:50px; line-height:50px; text-align:center; font-family:'Microsoft YaHei'; font-size:18px; color:#FFFFFF;">
		   <div class="menu_tb"><a href="${base}/index.html" class="a_menu">首&nbsp;&nbsp;页</a></div><div class="menu_fg"></div>
		   <div class="menu_tb"><a href="${base}/channel.html?id=105" class="a_menu">政策法规</a></div><div class="menu_fg"></div>
		   <div class="menu_tb"><a href="${base}/svorg.html" class="a_menu">社会服务</a></div><div class="menu_fg"></div>
		   <div class="menu_tb"><a href="${base}/appeal.html" class="a_menu">行政服务</a></div><div class="menu_fg"></div>
		   <div class="menu_tb"><a href="${base}/corp.html" class="a_menu">企业风采</a></div><div class="menu_fg"></div>
		   <div class="menu_tb"><a href="${base}/consults.html" class="a_menu">信息咨询</a></div><div class="menu_fg"></div>
		   <div class="menu_tb"><a href="${base}/channel-1015.html" class="a_menu">玉门招商</a></div><div class="menu_fg"></div>
		   <div class="menu_tb"><a href="${base}/lxwm.html" class="a_menu">联系我们</a></div>
		 </div>
	     <!--菜单名称 end-->
	</div>
	</div>
	<!--页头 end-->
</div>