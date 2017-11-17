<div class="clear"></div>
<div class="main_w">
	<div class="w1000">
		<div class="acti_left">
			<div class="filter">
				<dl class="filter_main exp">
					<dt>部门</dt>
					<dd id="CategoryMain">
						<a href="javascript:void(0)" class="all hover" rel="0">不限</a> 
						<@sme_svorg_list svgtype="G" num="50"; sclass> 
							<a href="javascript:void(0)" rel="${sclass.id}">${sclass.title}</a>
						</@sme_svorg_list>
					</dd>
				</dl>
			</div>
			<div class="top">企业数据上报</div>
			<@sme_report_page svgid="${svgid}" dateformat="yyyy-MM-dd HH:mm" page="${page!1}" num="${num!10}";datalist,pager>
			<div id="dvActivityNotice">
				<#list datalist as report>
				<div class="main">
					<div class="n_left">
					<ul >
						<li class="title">
						<a href="/report-${report.id}.html" target="_blank" title="${report.title}">${report.title}</a>
						</li>
					</ul>
					<dl>
						<dt>开始时间：</dt>
						<dd>${report.starttimestr}</dd>
						<dt>结束时间：</dt>
						<dd>${report.endtimestr}</dd>
						<dt>负责单位：</dt>
						<dd title="${report.svgtitle}">${report.svgtitle}</dd>
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
			</@sme_report_page>
		</div>
		<div class="acti_right">
			<div class="box">
				<div class="title">
					<span></span>通知公告
				</div>
				<div class="content">

					<ul class="main">
						<@sme_info_list channelid="101" dateformat="yyyy-MM-dd HH:mm" titlelen="12";info,index>
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

