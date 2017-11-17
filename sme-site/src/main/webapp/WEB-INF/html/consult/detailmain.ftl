<style>
.q1 {
  font-size: 15px;
  font-weight: bold;
  min-height: 20px;
  margin-bottom: 8px;
}

.qw {
  min-height: 25px;
  font-size: 14px;
  width: 620px;
}

.qww {
  width: 20px;
  min-height: 20px;
  background: #247fe8;
  float: left;
  text-align: center;
  color: #FFF;
}

.qwt {
  min-height: 20px;
  float: left;
  line-height: 20px;
  padding-left: 10px;
  width: 586px;
  margin-bottom: 5px;
}

.qd {
  min-height: 25px;
  font-size: 14px;
  width: 620px;
}

.qdd {
  width: 20px;
  min-height: 20px;
  background: #38de24;
  float: left;
  text-align: center;
  color: #FFF;
}

.qda {
  min-height: 20px;
  float: left;
  line-height: 20px;
  padding-left: 10px;
  width: 586px;
}
</style>
<div class="main_w">
	<div class="w1000">
		<div class="main_l fl">
			
			<div class="list_tab">
				<div class="tt_title fl">信息咨询</div>
				<div class="search_view fr" title="输入关键字搜索服务项目">
				</div>
			</div>
			<div class="downline"></div>
			<div class="list_main">
				<div class="Info">
					<div style="min-height:60px; width:614px; margin:0px auto; margin-top:10px; overflow:hidden;">
			        	<div class="q1">${currConsult.title}</div>
			            <div class="qw"><div class="qww">问</div><div class="qwt">${currConsult.content}</div></div>
			            <@sme_consult_list parid="${currConsult.id}"; consult,index>
			            <div class="qd"><div class="qdd">答</div><div class="qda">${consult.content}</div></div>
			            </@sme_consult_list>
			        </div>
					<div class="clear"></div>
				</div>
				<div class="downline"></div>
			</div>
		</div>
		<div class="main_r fr">
			<div style="margin:0px 0px 20px">
				<a href="/consultf.html" target="_blank">
				<img src="http://www.gszwfw.gov.cn/gszw/resources/bscx/ask/new/images/wyzx.png" style="width:205px;height:50px" >
				</a>
			</div>
			<div class="r_title">推荐机构</div>
			<@sme_svorg_list top="1" num="3";svorg,index>
			<div class="rt_img">
				<div class="img_p">
					<p class="img-box">
						<a href="${svorg.url}" target="_blank"> 
						<img alt="${svorg.title}" src="${svorg.logo}"></a>
					</p>
				</div>
			</div>
			<dl>
				<dt class="rt_title">
					<a href="${svorg.url}" target="_blank" title="${svorg.title}">${svorg.title}…</a>
				</dt>
				<dd>
					<span class="d_title">所属行业：</span>${svorg.industrystr}
				</dd>
				<dd>
					<span class="d_title">服务项目数：</span>
					<a href="${svorg.url}" target="_blank">0</a>
				</dd>
			</dl>
			</@sme_svorg_list>
			
		</div>
	</div>
</div>
