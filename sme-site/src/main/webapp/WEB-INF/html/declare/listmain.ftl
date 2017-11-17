<div class="clear"></div>
<div class="main_w">
	<div class="w1000">
		<div class="acti_left">
			<div class="filter">
				<dl class="filter_main exp">
					<dt>部门</dt>
					<dd id="CategoryMain">
						<a href="javascript:void(0)" class="all hover" rel="0">不限</a> 
						<@sme_svorg_list svgtype="G" num="50"; svorg,index> 
							<a href="javascript:void(0)" rel="${svorg.id}">${svorg.title}</a>
						</@sme_svorg_list>
					</dd>
				</dl>
			</div>
			<div class="top">企业申报列表</div>
			<@sme_declaretopic_page svgid="${svgid!0}" dateformat="yyyy-MM-dd HH:mm" page="${page!1}" num="${num!10}";actlist,pager>
			<div>
				<#list actlist as declaretopic>
				<div class="main">
					<div class="n_left">
					<ul >
						<li class="title">
						<a href="/declare-${declaretopic.id}.html" target="_blank" title="${declaretopic.title}">${declaretopic.title}</a></li>
					</ul>
					<dl >
						<dt>开始时间：</dt>
						<dd>${declaretopic.starttimestr}</dd>
						<dt>结束时间：</dt>
						<dd>${declaretopic.endtimestr}</dd>
						<dt>负责单位：</dt>
						<dd title="${declaretopic.svgtitle}">${declaretopic.svgtitle}</dd>
					</dl>
					</div>
					<div class="n_right"></div>
				</div>
				</#list>
			</div>
			<div id="dvPageNotice" class="acti_page">
				<div id="dvLoadingNotice" class="loading"></div>
				${pager.numPageStr}
			</div>
			</@sme_declaretopic_page>
		</div>
		<div class="acti_right">
			<div class="box">
				<div class="title">
					<span></span>通知公告
				</div>
				<div class="content">
					<ul class="main">
						<@sme_info_list channelid="101" titlelen="15" dateformat="MM-dd" num="10";info,index>
						<li><a href="${info.url}"
							target="_blank" title="${info.title}">${info.showtitle}…</a></li>
						</@sme_info_list>
					</ul>
				</div>
			</div>
			
			<div class="box" style="  margin-top: 20px;">
				<div class="title">
					<span></span>最新动态
				</div>
				<div class="content">
					<ul class="main">
						<@sme_info_list channelid="104" titlelen="15" dateformat="MM-dd" num="10";info,index>
						<li><a href="${info.url}"
							target="_blank" title="${info.title}">${info.showtitle}…</a></li>
						</@sme_info_list>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>	
<div class="clear"></div>

