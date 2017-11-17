	<style>
	.list_main ul li{
		  height: 45px;
  		  line-height: 45px;	
  		  border-bottom: 1px dashed #dbdbdb;
	}
	</style>
	<input type="hidden" id="param_s" value="${s}">
	<input type="hidden" id="param_c" value="${c}">
	<input type="hidden" id="param_k" value="${k}">
	
	<div class="main_w">
		<div class="w1000">
			<div class="main_l fl">
				<div class="main_top">
					<dl class="mt_filter mtf_exp">
						<dt>分类</dt>
						<dd id="search_facet">
							
						</dd>
					</dl>
				</div>
				<div class="list_tab">
					<div class="tt_title fl">搜索结果</div>
					<div class="search_view fr" title="输入关键字搜索服务项目">
						
					</div>
				</div>
				<div class="downline"></div>
				<div class="list_main" style="border: none;">
					<ul id="search_record">
					
					</ul>
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