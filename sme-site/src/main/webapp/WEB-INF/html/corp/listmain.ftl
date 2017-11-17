	<div class="clear"></div>
	
	<div class="main_w">
		<div class="w1000">
			<div class="main_l fl">
				<div class="main_top">
					<!--
					<dl class="mt_filter mtf_exp">
						<dt>行业</dt>
						<dd id="CategoryMain">
							<a href="javascript:void(0)" class="all hover" rel="0">不限</a> 
							<@sme_industry_list code="0"; industry,index> 
							<a href="javascript:void(0)" rel="${industry.id}">${industry.title}</a>
							</@sme_industry_list>
						</dd>
					</dl>
					
					<dl class="mt_filter">
						<dt>园区</dt>
						<dd id="ParkMain">
							<a href="javascript:void(0)" class="all hover" rel="0">全市</a> 
							<@sme_park_list ;park,index>
							<a href="javascript:void(0)" rel="${park.id}">${park.title}</a>
							</@sme_park_list>
						</dd>
					</dl>
					-->
				</div>
				<div class="list_tab">
					<div class="tt_title fl">企业名录</div>
					<div class="search_view fr" title="输入关键字搜索服务机构">
						<input type="text" class="key_txt" placeholder="请输入关键字" value="">
							<button type="button" class="bnt_search">
								<i class="iconfont"></i>
							</button>
					</div>
				</div>
				<div class="downline"></div>
				<div class="list_main">
					<@sme_corp_page page="${page!1}" num="${num!10}" pagenum="${pagenum!0}" parkid="${parkid}" hycode="${scode}" status="1" order="istop"; corpList,pager>
					<#list corpList as corp>
					<div class="Info">
						<div class="fl">
							<div class="img_p">
								<p class="img-box">
									<a href="${corp.url}" target="_blank"> 
										<img src="${corp.logo}" alt="${corp.title}"
										onerror="this.onerror=null;this.src='/resources/site/images/no.png'"></a>
								</p>
							</div>
						</div>
						<div class="infoview fl">
							<dl>
								<dt>
									<a href="${corp.url}" target="_blank">${corp.title}</a> 
								</dt>
								
								<dd>
									<span class="s_name">联系人：</span>${corp.linker}
									<span class="s_d_name">联系电话：</span>${corp.linktel}
								</dd>
								<dd>
									<span class="s_name">所在地址：</span><span
										title="${corp.areastr}">${corp.areastr}…</span>
								</dd>
								<dd>
									<a href="${corp.url}" target="_blank" class="s_detail">进入企业</a>
								</dd>
							</dl>
						</div>
						<div class="prdt_l fl">
							<dl>
								<dt>特色产品</dt>
								<@sme_product_list num="3" titlelen="10" corpid="${corp.id}";product,index>
								<dd>
									<a href="${product.url}" target="_blank" title="${product.title}">${product.showtitle}</a>
								</dd>
								</@sme_product_list>
							</dl>
						</div>
						<div class="clear"></div>
					</div>
					<div class="downline"></div>
					</#list>
					${pager.numPageStr}
					</@sme_corp_page>
				</div>
			</div>
			<div class="main_r fr">
				<div class="r_title">推荐项目</div>
				
				<@sme_sitem_list num="5" scode="0";sitem,index>
				<div class="rt_img">
					<div class="img_p">
						<p class="img-box">
							<a href="${sitem.url}" target="_blank"> 
							<img src="${sitem.logo}"  alt="${sitem.title}"  onerror="this.onerror=null;this.src='/resources/site/images/no.png'"></a>
						</p>
					</div>
				</div>
				<dl>
					<dd class="rt_title">
						<a href="${sitem.url}" target="_blank" title="${sitem.title}">${sitem.title}</a>
					</dd>
					<dd>
						<span class="d_title">服务次数：</span>${sitem.salenum} 次
					</dd>
					<dd>
						<span class="d_title">服务区域：
						<#if sitem.arealist ??>
						<#list sitem.arealist as area>
							${area} 
						</#list>
						<#else>
						玉门市
						</#if>
						</span>
					</dd>
				</dl>
				</@sme_sitem_list>
			</div>
		</div>
	</div>

	<div class="clear"></div>
	