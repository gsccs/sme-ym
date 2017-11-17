<div class="main_w">
	<div class="w1000">
		<div class="main_l fl">
			<!--
			<div class="main_top">
				<dl class="mt_filter mtf_exp">
					<dt>分类</dt>
					<dd id="CategoryMain">
						<a href="javascript:void(0)" class="all" rel="0" class="hover">不限</a>
					</dd>
				</dl>
			</div>
			-->
			<div class="list_tab">
				<div class="tt_title fl">工程项目</div>
				<div class="search_view fr" title="输入关键字搜索服务项目">
					
				</div>
			</div>
			<div class="downline"></div>
			<div class="list_main">
				<@sme_project_page page="${page!1}" num="${num!10}" pagenum="${pagenum!0}" ; projectList,pager>
				<#list projectList as sitem>
				<div class="Info">
					<div class="infoview fl">
						<dl>
							<dd>
								<span class="s_name">项目名称：</span>
								${sitem.title}
							</dd>
							<dd>
								<span class="s_name">投资总额：</span>${sitem.invest}万元
							</dd>
							<dd>
								<span class="s_name">资金来源：</span>
								<span class="con_d fr">${sitem.moneytypestr}</span>
							</dd>
							<dd>
								<span class="s_name">性质：</span>
								<span class="con_d fr">新建</span>
							</dd>
							<dd>
								<span class="s_name">建设周期：</span>
								<span class="con_d fr">${sitem.starttimestr}～${sitem.endtimestr}</span>
							</dd>
							<dd>
								<span class="s_name">项目类型：</span>
								<span class="con_d fr">${hycodestr}</span>
							</dd>
						</dl>
					</div>
					<div class="clear"></div>
				</div>
				<div class="downline"></div>
				</#list>
				${pager.numPageStr}
				</@sme_project_page>
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
