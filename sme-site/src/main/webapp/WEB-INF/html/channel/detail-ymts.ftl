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

.title_03{
	line-height:33px;
	padding-left: 15px;
	font-weight: bolder;
	font-size: 16px;
  	border-bottom: 1px solid #C4C4C4;
	background: url("resources/site/images/title_03.png") no-repeat 0px 50%;
}

.content02 {
  width: 1000px;
  height: 222px;
  padding-top: 13px;
  margin: 0 auto;
  margin-bottom: 12px;
}

.part01 {
  float: left;
  width: 450px;
  height: 220px;
}

.yqgg dl dt {
  width: 420px;
}


.yqgg dl dd{
	width: 420px;
}

</style>

<div class="clear"></div>
<div class="main_w">
	<div class="w1000" style="background: #FFF;display: table;">
		<div class="park_bar_lf" style="margin-top: 20px;">
			<ul>
				<@sme_channel_list parid="106";channel,index>
				<li>
					<dl>
						<dt><span>${channel.title}</span></dt>
						<@sme_channel_list parid="${channel.id}";subchannel,index>
						<dd>${subchannel.title}</dd>
						</@sme_channel_list>
					</dl>
				</li>
				</@sme_channel_list>
			</ul>
		</div>
		<div class="park_content">
			<!--content02 start-->
			<div class="content02">
				<div class="part01">
					<div class="yqgg">
						<dl>
							<dt class="title_03"><span>玉门文化<span></dt>
							<@sme_info_list channelid="106" dateformat="yyyy-MM-dd HH:mm" titlelen="12" num="5";info,index>
							<dd><a href="${info.url}" target="_blank">${info.showtitle}</a></dd>
							</@sme_info_list>
						</dl>
					</div>
				</div>
				
				<div class="part01">
					<div class="yqgg">
						<dl>
							<dt class="title_03"><span>文化旅游<span></dt>
							<@sme_info_list channelid="1013" dateformat="yyyy-MM-dd HH:mm" titlelen="12" num="5";info,index>
							<dd><a href="${info.url}" target="_blank">${info.showtitle}</a></dd>
							</@sme_info_list>
						</dl>
					</div>
				</div>
				<div style="clear:both;"></div>
			</div>
			<!--content02 end-->
			<div class="banner"><img src="http://www.smeym.org/resources/banner/images/banner_bg_3.jpg" width="996" height="83"></div>
			
			<!--content03 table start-->
			<div class="content03">
			  <div class="title_03">玉门风采</div>
			  <!--企业滚动开始-->
			  <div class="slide">
			    <div class="mainpro">
				 <div class="blk_18">
				  <div class="pcont" id="ISL_Cont_1">
				   <div class="ScrCont">
				    <div id="List1_1">
					<@sme_info_list channelid="108" dateformat="yyyy-MM-dd HH:mm" titlelen="12";info,index>
					 
					 </@sme_info_list>
					</div>
					<div id="List2_1">
					
					</div>
				   </div>
				  </div>
				 </div>
				</div>
			  </div>
			  <!--企业滚动结束--> 	
			</div>
			<!--content03 table end-->
		</div>
</div>	
<div class="clear"></div>

