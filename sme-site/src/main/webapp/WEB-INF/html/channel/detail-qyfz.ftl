<style>
.style4 {
  font-size: 12px;
  color: #333333;
  line-height: 20px;
}

table {
  display: table;
  border-collapse: separate;
  border-spacing: 1px;
  border-color: gray;
}
</style>

<div class="clear"></div>
<div class="main_w">
	<div class="w1000">
		<div class="main_l fl">
			<div class="list_main">
				<div class="city-img" style="float:left">
						<img src="${base}/resources/site/images/ymqj.jpg" style="opacity: 1;height: 300px;width: 100%;">
				</div>
			</div>
			<div style="clear:both;"></div> 
			<div class="park_title"><h3 style="padding-left: 15px;">玉门市情</h3></div>
			<div style="width:100%;height:auto;">
				<@sme_info_list channelid='1025' num="5" titlelen="12";info,index>
					<dl>
							<dt style="text-align: center;padding: 10px;"><span>${info.showtitle}</span></dt>
							<dd>${info.remark}[<a href="${info.url}" target="_blank" style="color:#f09119;">详情</a>]</dd>
					<dl>
				</@sme_info_list>
			</div>	
			<div style="clear:both;"></div> 
			<div class="park_title"><h3 style="padding-left: 15px;">一区三园</h3></div>
			<div class="park_remark" style="width:100%;height:auto;">
				<@sme_info_list channelid='1027' num="5" titlelen="12";info,index>
				<dl>
					<dt style="text-align: center;padding: 10px;"><a href="${info.url}" target="_blank">${info.showtitle}</a></dt>
					<dd>${info.remark}[<a href="${info.url}" target="_blank" style="color:#f09119;">详情</a>]</dd>
				<dl>
				</@sme_info_list>
			</div>	
				
			<div style="clear:both;"></div> 
			<div class="park_title"><h3 style="padding-left: 15px;">供电价格</h3></div>
			<div class="news" style="width:100%;height:auto;">
				
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
			<div class="r_title">招商政策</div>
			<div class="news">
				<ul>
					<@sme_info_list channelid='1028' num="5" titlelen="12";info,index>
						<li><a href="${info.url}" target="_blank">${info.showtitle}</a></li>
					</@sme_info_list>
				</ul>	
			</div>	
		</div>
		
		<div class="main_r fr">
			<div class="r_title">联系方式</div>
			<div class="news">
				<ul>
					<@sme_info_list channelid='1029' num="5" titlelen="12";info,index>
						<li><a href="${info.url}" target="_blank">${info.showtitle}</a></li>
					</@sme_info_list>
				</ul>	
			</div>	
		</div>
	</div>
</div>	
<div class="clear"></div>

