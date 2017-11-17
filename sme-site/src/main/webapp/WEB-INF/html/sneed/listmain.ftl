	<div class="clear"></div>

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
						<dd class="mtf_sub" id="CategorySub" style="display: none;">
							<#if scode ??>
								<@sme_sclass_list code="${scode}"; sclass> 
								<a href="javascript:void(0)" rel="${sclass.id}">${sclass.title}</a>
								</@sme_sclass_list>
							</#if> 
						</dd>
					</dl>
					<dl class="mt_filter">
						<dt>区域</dt>
						<dd id="AreaMain">
							<a href="javascript:void(0)" class="all hover" rel="1">全省</a> 
							<@sme_area_list parid="62";area,index>
							<a href="javascript:void(0)" rel="${area.code}">${area.name}</a>
							</@sme_area_list> 
						</dd>
					</dl>
				</div>
				<div class="list_tab">
					<div class="tt_title fl">企业需求</div>
					<div class="search_view fr" title="输入关键字搜索企业需求">
						<input type="text" class="key_txt" placeholder="请输入关键字" value="">
							<button type="button" class="bnt_search">
								<i class="iconfont"></i>
							</button>
					</div>
				</div>
				<div class="needlist">
					<@sme_sneed_page page="${page!1}" num="10" pagenum="${pagenum!0}" scode="${scode}"; sneedList,pager>
					<#list sneedList as sneed>
					<div class="Info">
						<div class="fl">
							<div class="img_p">
								<p class="img-box">
									<a href="${sneed.url}" target="_blank"> 
									<img alt="${sneed.corptitle} " src="${sneed.corplogo}"
										onerror="this.onerror=null;this.src='/resources/site/images/no.png'"></a>
								</p>
							</div>
						</div>
						<div class="infoview fl">
							<dl>
								<dd>
									<span class="s_name">需求名称：</span>
									<a href="${sneed.url}" target="_blank">${sneed.title}</a>
									<div class="clear"></div>
								</dd>
								<dd>
									<span class="s_name">联&nbsp;&nbsp;系&nbsp;&nbsp;人：</span>
									<span class="s_con">${sneed.linker}</span>
									<span class="s_d_name">联系电话：</span>${sneed.linktel}
									<div class="clear"></div>
								</dd>
								<dd>
									<span class="s_name">需求分类：</span><span class="s_con">${sneed.sclassstr}&nbsp;</span><span
										class="s_d_name">发布日期：</span>${sneed.addtimestr}
									<div class="clear"></div>
								</dd>
								<dd>
									<span class="s_name">所&nbsp;&nbsp;在&nbsp;&nbsp;地：</span>玉门市
									<a href="${sneed.url}" class="detail" target="_blank" style="margin-right: 50px;">[详情]</a>
									<div class="clear"></div>
								</dd>
							</dl>
						</div>
						<div class="clear"></div>
					</div>
					<div class="downline"></div>
					</#list>
					${pager.numPageStr}
					</@sme_sneed_page>
					<div class="clear"></div>
				</div>
			</div>
			<div class="main_r fr">
				<div class="r_title">推荐机构</div>
				<@sme_svorg_list top="1" num="4";svorg,index>
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
						<span class="d_title">所属行业：</span>${svorg.sclassstr}
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

	<div class="clear"></div>
	