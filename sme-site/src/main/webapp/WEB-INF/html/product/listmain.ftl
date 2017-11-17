	<div class="clear"></div>

	<div class="main_w">
		<div class="w1000">
			<div class="main_l fl">
				<div class="main_top">
					<dl class="mt_filter mtf_exp">
						<dt>分类</dt>
						<dd id="CategoryMain">
							<a href="javascript:void(0)" class="all hover" rel="0">不限</a>
							<@sme_category_list ; category> 
							<a href="javascript:void(0)" rel="${category.id}">${category.title}</a>
							</@sme_category_list>
						</dd>
						<dd class="mtf_sub" id="CategorySub" style="display: none;">
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
					<div class="tt_title fl">产品列表</div>
					<div class="search_view fr" title="输入关键字搜索产品">
						<input type="text" class="key_txt" placeholder="请输入关键字" value="">
							<button type="button" class="bnt_search">
								<i class="iconfont"></i>
							</button>
					</div>
				</div>
				<div class="needlist">
					<@sme_product_page page="${page!1}" num="${pagesize!10}" pagenum="${pagenum!0}" titlelen="20"; productList,pager>
					<#list productList as product>
					<div class="Info">
						<div class="fl">
							<div class="img_p">
								<p class="img-box">
									<a href="${product.url}" target="_blank"> 
									<img alt="${product.title} " src="${product.img}"
										onerror="this.onerror=null;this.src='/resources/site/images/no.png'"></a>
								</p>
							</div>
						</div>
						<div class="infoview fl">
							<dl>
								<dd>
									<span class="s_name">产品名称：</span>
									<a href="${product.url}" target="_blank">${product.title}</a>
									<div class="clear"></div>
								</dd>
								<dd>
									<span class="s_name">生产企业：</span>
									<span class="s_con">${product.corptitle}</span>
									<span class="s_d_name">联系电话：</span>${product.linktel}
									<div class="clear"></div>
								</dd>
								<dd>
									<span class="s_name">产品价格：</span><span class="s_con">${product.price}元&nbsp;</span><span
										class="s_d_name">市场销量：</span>${product.salenum}件
									<div class="clear"></div>
								</dd>
								<dd>
									<span class="s_name">所&nbsp;&nbsp;在&nbsp;&nbsp;地：</span>玉门市
									<a href="${product.url}" class="detail" target="_blank" style="margin-right: 50px;">[详情]</a>
									<div class="clear"></div>
								</dd>
							</dl>
						</div>
						<div class="clear"></div>
					</div>
					<div class="downline"></div>
					</#list>
					${pager.numPageStr}
					</@sme_product_page>
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
	