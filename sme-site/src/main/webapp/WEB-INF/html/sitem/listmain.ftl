<div class="main_w">
	<div class="w1000">
		<div class="main_l fl">
			<div class="main_top">
				<dl class="mt_filter mtf_exp">
					<dt>分类</dt>
					<dd id="CategoryMain">
						<a href="javascript:void(0)" class="all" rel="0" class="hover">不限</a>
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
			</div>
			<div class="list_tab">
				<div class="tt_title fl">服务项目</div>
				<div class="search_view fr" title="输入关键字搜索服务项目">
					<input type="text" class="key_txt" placeholder="请输入关键字" value="" />
						<button type="button" class="bnt_search">
							<i class="iconfont"></i>
						</button>
				</div>
			</div>
			<div class="downline"></div>
			<div class="list_main">
				<@sme_sitem_page page="${page!1}" num="${num!10}" pagenum="${pagenum!0}" scode="${scode}" subscode="${subscode}" keyword="${keyword}"; sitemList,pager>
				<#list sitemList as sitem>
				<div class="Info">
					<div class="fl">
						<div class="img_p">
							<p class="img-box">
								<a href="${sitem.url}" target="_blank"> 
								<img src="${sitem.img}" alt="${sitem.title}"
									onerror="this.onerror=null;this.src='/resources/site/images/no.png'"></a>
							</p>
						</div>
					</div>
					<div class="infoview fl">
						<dl>
							<dd>
								<span class="s_name">服务名称：</span>
								<a href="${sitem.url}" target="_blank">${sitem.title}</a>
							</dd>
							<dd>
								<span class="s_name">服务次数：</span>${sitem.salenum} 次
							</dd>
							<dd>
								<span class="s_name">好&nbsp;评&nbsp;率&nbsp;：</span><span
									class="con_d fr"><em></em><em></em><em></em><em></em><em></em></span>
							</dd>
							<dd>
								<span class="s_name">服务介绍：</span>${sitem.remark}…
								<a href="${sitem.url}" class="detail" target="_blank">[ 详情  ]</a>
							</dd>
						</dl>
					</div>
					<!--
					<div class="areaview fl">
						<span>服务区域</span>
						<#if sitem.arealist ??>
						<#list sitem.arealist as area>
							${area} 
						</#list>
						<#else>
						玉门市
						</#if>
					</div>
					
					<div class="areaview fl">
						<span>收费标准</span>
						${sitem.price} ${sitem.spaystr} 
						${sitem.otherpay}
					</div>
					-->
					<div class="clear"></div>
				</div>
				<div class="downline"></div>
				</#list>
				${pager.numPageStr}
				</@sme_sitem_page>
			</div>
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
