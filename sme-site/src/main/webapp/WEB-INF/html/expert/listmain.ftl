
	<div class="main_w">
		<div class="w1000">
			<div class="main_l fl">
				<div class="main_top">
					<dl class="mt_filter mtf_exp">
						<dt>分类</dt>
						<dd id="CategoryMain">
							<a href="javascript:void(0)" class="all hover" rel="0">不限</a> 
							<@sme_sclass_list code="0"; sclass> 
							<a href="javascript:void(0)" rel="${sclass.id}">${sclass.title}</a>
							</@sme_sclass_list>
						</dd>
					</dl>
					<!--<dl class="mt_filter">
						<dt>区域</dt>
						<dd id="AreaMain">
							<a href="javascript:void(0)" class="all hover" rel="0">全省</a> 
							<@sme_area_list parid="62";area,index>
							<a href="javascript:void(0)" rel="${area.code}">${area.name}</a>
							</@sme_area_list> 
						</dd>
					</dl>-->
				</div>
				<div class="list_tab">
					<div class="tt_title fl">专 家</div>
					<div class="search_view fr" title="输入关键字搜索专家">
						<input type="text" class="key_txt" placeholder="请输入关键字" value="${keyword!''}" />
						<button type="button" class="bnt_search">
								<i class="iconfont"></i>
						</button>
					</div>
				</div>
				<div class="downline"></div>
				<div class="list_main">
					<@sme_expert_page page="${page!1}" num="${num!10}" pagenum="${pagenum!0}"; expertList,pager>
					<#list expertList as expert>
					<div class="Info">
						<div class="fl">
							<div class="img_p2">
								<p class="img-box2">
									<a href="${expert.url}" target="_blank"> 
										<img class="wh2" src="${expert.logo}" alt="${expert.title}"
										onerror="this.onerror=null;this.src='/resources/site/images/no.png'">
									</a>
								</p>
							</div>
						</div>
						<div class="infoview2 fl">
							<dl>
								<dd>
									<span class="s_name">姓 名：</span>
									<a href="${expert.url}" target="_blank">${expert.title}</a>
								</dd>
								<dd>
									<span class="s_name">技术职称：</span>${expert.technical}
								</dd>
								<dd>
									<span class="s_name">学 历：</span>${expert.degree}
								</dd>
								<dd>
									<span class="s_name">简 介：</span>${expert.resume}
									<a href="${expert.url}" class="detail" target="_blank">[ 详情 ]</a>
								</dd>
							</dl>
						</div>
						<div class="clear"></div>
					</div>
					<div class="downline"></div>
					</#list>
					
					${pager.numPageStr}
					</@sme_expert_page>
					
				</div>
			</div>
			<div class="news_r">
				<div class="box">
					<div class="title">
						<span></span>热点新闻
					</div>
					<div class="content">
						<ul class="c_main">
							<@sme_info_list titlelen="15" num="10";info,index>
							<li><a href="/info-${info.id}.html"
								target="_blank" title="${info.title}">${info.showtitle}…</a></li>
							</@sme_info_list>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="clear"></div>
	