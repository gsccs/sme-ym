<div class="main_w">
	<div class="w1000">
		<div class="main_l fl">
			<@sme_sclass_list code="0"; sclass> 
			<div class="list_tab">
				<div class="tt_title fl">${sclass.title}</div>
				<div class="search_view fr" title="输入关键字搜索服务项目">
				</div>
			</div>
			<div class="downline"></div>
			<div class="list_main">
				<div class="Info">
					<div class="fl">
						<@sme_sclass_list code="${sclass.id}"; subsclass> 
						<a href="/sitem.html?scode=${sclass.id}&subscode=${subsclass.id}" rel="${subsclass.id}">${subsclass.title}</a>
						</@sme_sclass_list>
					</div>
					<div class="infoview fl">
						
					</div>
					<div class="clear"></div>
				</div>
				<div class="downline"></div>
			</div>
			</@sme_sclass_list>
		</div>
		<div class="main_r fr">
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
