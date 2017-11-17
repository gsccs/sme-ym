<div class="main_w">
	<div class="w1000">
		<div class="main_l fl">
			<div class="list_tab">
				<div class="tt_title fl">工业项目投资</div>
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
								<span class="s_name">项目投资：</span>${sitem.backdrop}
							</dd>
							
							<dd>
								<span class="s_name">建设内容：</span>
								<span class="con_d fr">${sitem.content}</span>
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
