<style>

</style>

<div class="clear"></div>
<div class="main_w">
	<div class="w1000">
		<div class="main_l fl" style="min-height: 500px;">
			<div style="clear:both;"></div> 
			<div class="park_title"><h3 style="padding-left: 15px;">联系我们</h3></div>
			<div class="list_main">
				<div class="city-img" style="float:left">
						<img src="${base}/resources/site/images/ymqj.jpg" style="opacity: 1;height: 200px;width: 100%;">
				</div>
			</div>
			<div class="" style="">
				<@sme_channel id="1030";channel>
					${channel.content}
				</@sme_channel>
			</div>
		</div>
		<div class="main_r fr">
			<div class="r_title">最新动态</div>
			<div class="news">
				<ul>
					<@sme_info_list channelid='101' num="5" titlelen="12";info,index>
						<li><a href="${info.url}" target="_blank">${info.showtitle}</a></li>
					</@sme_info_list>
				</ul>	
			</div>	
		</div>
		
		<div class="main_r fr">
			<div class="r_title">政策法规</div>
			<div class="news">
				<ul>
					<@sme_info_list channelid='105' num="5" titlelen="12";info,index>
						<li><a href="${info.url}" target="_blank">${info.showtitle}</a></li>
					</@sme_info_list>
				</ul>	
			</div>	
		</div>
	</div>
</div>	
<div class="clear"></div>

