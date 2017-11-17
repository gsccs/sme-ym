<div class="main_w">
		<div class="w1000">
			<div class="news_l" style="float:right">
				<div class="list_tab">
					<div class="tt_title fl">
					<#if currChannel ??>
					${currChannel.title}
					<#else>
					信息列表
					</#if>
					</div>
				</div>
				<@sme_info_page num="${num!10}" page="${page!1}" titlelen="25" dateformat="yyyy-MM-dd" channelid="${id}";infolist,pager>
				<ul class="l_list">
					<#list infolist as info>
						<li>[<a href="/svorg-${info.svgid}.html" title="" target="_blank">${info.svgtitle}</a>]&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="${info.url}" title="${info.title}" target="_blank">
							<span>${info.title}</span>
							<span class="time">${info.addtimestr}</span>
						</a></li>
					</#list>
				</ul>
				${pager.numPageStr}
				</@sme_info_page>
				<ul class="l_list"></ul>
			</div>
			<div class="news_r" style="float:left">
				<div class="box">
					<div class="title">
						<span></span>政策法规
					</div>
					<div class="content">
						<ul class="main">
							<@sme_channel_list parid="105";subchannel,index>
							<li><a href="/channel-${subchannel.id}.html" target="_blank" title="${subchannel.title}">${subchannel.title}</a></li>
							</@sme_channel_list>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="clear"></div>