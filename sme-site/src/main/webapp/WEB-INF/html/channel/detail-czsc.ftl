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

.channel-detail{
	padding: 5px 25px;
}
</style>

<div class="clear"></div>
<div class="main_w">
	<div class="w1000" style="background: #FFF;display: table;">
		<div class="park_bar_lf" style="margin-top: 20px;">
			<ul>
				<@sme_channel_list parid="1017";channel,index>
				<li>
					<dl>
						<dt><a href="">${channel.title}</a></dt>
						<@sme_channel_list parid="${channel.id}";subchannel,index>
						<dd>${subchannel.title}</dd>
						</@sme_channel_list>
					</dl>
				</li>
				</@sme_channel_list>
			</ul>
		</div>
		<div class="park_content">
		<div class="park_title"><h3 style="padding-left: 15px;">${currChannel.title}</h3></div>
		<!--content01开始-->
		<div class="content01">
			<div class="channel-detail">
				${currChannel.content}
			</div>
			<div style="clear:both;"></div>
		</div>
		<!--content01结束--> 
	</div>
</div>	
<div class="clear"></div>

