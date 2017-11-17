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
						</dd>
					</dl>
				</div>
				<div class="list_tab">
					<div class="tt_title fl" id="svg_type_G">服务机构</div>
					<!--<div class="tt_title fl" id="svg_type_S" style="margin-left: 5px;">社会服务机构</div>-->
					<div class="search_view fr" title="输入关键字搜索服务机构">
						<input type="text" class="key_txt" placeholder="请输入关键字" value="">
							<button type="button" class="bnt_search">
								<i class="iconfont"></i>
							</button>
					</div>
				</div>
				<div class="downline"></div>
				<div class="list_main">
					<@sme_svorg_page page="${page!1}" num="10" pagenum="${pagenum!0}" svgtype="${svgtype!'S'}" scode="${scode}" order="istop"; svorgList,pager>
					<#list svorgList as svorg>
					<div class="Info">
						<div class="fl">
							<div class="img_p">
								<p class="img-box">
									<a href="${svorg.url}" target="_blank"> 
										<img src="${svorg.logo}" alt="${svorg.title}"
										onerror="this.onerror=null;this.src='/resources/site/images/no.png'"></a>
								</p>
							</div>
						</div>
						<div class="infoview fl">
							<dl>
								<dt>
									<a href="${svorg.url}" target="_blank">${svorg.title}</a> 
										<i class="iconfont" title="推荐机构"></i> 
										<i class="icon_zl" title="省平台战略合作机构"></i> 
										<i class="icon_hx" title="核心服务机构"></i>
								</dt>
								
								<dd>
									<span class="s_name">联系人：</span>${svorg.linker!'-'}
									<span class="s_d_name">联系电话：</span>${svorg.linktel!'-'}
								</dd>
								<dd>
									<span class="s_name">所在地址：</span><span
										title="${svorg.areastr}">${svorg.areastr}…</span>
								</dd>
								<dd>
									<a href="${svorg.url}" target="_blank" class="s_detail">进入机构</a>
								</dd>
							</dl>
						</div>
						<div class="prdt_l fl">
							<dl>
								<dt>服务项目</dt>
								<#if svorg.svgtype='G'>
								<@sme_appealtopic_list num="3" titlelen="15" svgid="${svorg.id}";appeal,index>
								<dd>
									<a href="${appeal.url}" target="_blank" title="${appeal.title}">${appeal.showtitle}</a>
								</dd>
								</@sme_appealtopic_list>
								</#if>
								<#if svorg.svgtype='S'>
								<@sme_sitem_list num="3" titlelen="15" svgid="${svorg.id}";sitem,index>
								<dd>
									<a href="${sitem.url}" target="_blank" title="${sitem.title}">${sitem.showtitle}</a>
								</dd>
								</@sme_sitem_list>
								</#if>
							</dl>
						</div>
						<div class="clear"></div>
					</div>
					<div class="downline"></div>
					</#list>
					${pager.numPageStr}
					</@sme_svorg_page>
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
	