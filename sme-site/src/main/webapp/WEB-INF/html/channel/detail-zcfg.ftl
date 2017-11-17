<style>
.park_bar_lf {
  float: left;
  width: 170px;
}

.news_zcfg ul li {
  width: 700px;
  height: 35px;
  border-bottom: 1px dashed #C4C4C4;
  font-size: 14px;
  background: url(resources/park/images/icon3.gif) no-repeat 5px 13px;
}

.news_zcfg li a {
  height: 35px;
  line-height: 35px;
  padding-left: 17px;
  display: block;
}

.content04 {
  width: 1000px;
  /* height: 190px; */
  margin: 0 auto;
  margin-bottom: 20px;
    height: initial;
}
</style>

<div class="clear"></div>
<div class="main_w">
	<div class="w1000" style="background: #FFF;display: table;">
		<div class="park_bar_lf" style="margin-top: 20px;">
			<ul>
			<@sme_channel_list parid="${currChannel.id}";channel,index>
				<li>
					<dl>
						<dt><a href="">${channel.title}</a></dt>
					</dl>
				</li>
			</@sme_channel_list>
			</ul>
		</div>
		<div class="park_content">
		<div class="park_title"><h3 style="padding-left: 15px;">玉门招商</h3></div>
		<!--content04 start-->
		<div class="content04 news_zcfg">
			<ul>
				<@sme_info_list channelid='104' num="20" titlelen="20";info,index>
					<li><a href="${info.url}" target="_blank">${info.showtitle}</a></li>
				</@sme_info_list>
			</ul>
			<div style=" clear:both;"></div>
		</div>
		<!--content04 end-->
	</div>
</div>	
<div class="clear"></div>

