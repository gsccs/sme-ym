<style>
.park_bar_lf{
	float: left;
  	width: 170px;
}

.park_bar_lf dt,dd{
	height: 35px;
  	line-height: 35px;
}

.park_content{
	float:left;
	background: #FFF;
	margin-bottom: 30px;
}
</style>

<div class="clear"></div>
<div class="main_w">
	<div class="w1000" style="background: #FFF;display: table;">
		<div class="park_bar_lf" style="margin-top: 20px;">
			<ul>
				<li>
					<dl>
						<dt>区域发展</dt>
					</dl>
				</li>
				<li>
					<dl>
						<dt>经济基础</dt>
					</dl>
				</li>
				<li>
					<dl>
						<dt>投资环境</dt>
					</dl>
				</li>
				<li>
					<dl>
						<dt>优惠政策</dt>
					</dl>
				</li>
				<li>
					<dl>
						<dt>配套服务</dt>
					</dl>
				</li>
			</ul>
		</div>
		<div class="park_content">
		<div class="park_title"><h3 style="padding-left: 15px;">玉门招商</h3></div>
		<!--content01开始-->
		<div class="content01">
			<div class="city-img" style="float:left">
				<img src="${base}/resources/site/images/ymqj.jpg" style="opacity: 1;height: 200px;width: 650px;">
			</div>
			
			<div class="news">
				<div><img src="${base}/resources/park/images/zxdt.jpg" border="0" usemap="#Map">
				</div>
				<ul>
					<@sme_info_list channelid='104' num="5" titlelen="20";info,index>
					<li><a href="${info.url}" target="_blank">${info.showtitle}</a></li>
					</@sme_info_list>
				</ul>
			</div>
			<div style="clear:both;"></div>
		</div>
		<!--content01结束-->
		<div style="clear:both;"></div> 
		<div class="park_title"><h3 style="padding-left: 15px;">工业园区</h3></div>
		<!--content04 start-->
		<div class="content04">
			
			<@sme_park_list;park,index>
			<div style="float:left;width:300px;  padding: 5px;">
				<dl style="float:left;width:100px">
					<dt style="float:left"><img src="${park.logo}" width="100px" height="100px" style="border: 2px solid #ECECEC;"></dt>
					<dd style="text-align: center;">${park.svgtitle}</dd>
				</dl>
				<div style="float:left;  width: 180px; padding-left: 10px;">${park.remark}</div>
			</div>
			</@sme_park_list>
			<div style=" clear:both;"></div>
		</div>
		<!--content04 end-->
	</div>
</div>	
<div class="clear"></div>

