	<div class="clear"></div>

	<div class="main_w">
		<div class="w1000">
			<div class="news_l">
				<h1>
					
					<div class="new_title">
					<#if currInfo ??>
					${currInfo.title}
					<#else>
					
					</#if>
					</div>
				</h1>
				<div class="from_time">
					<#if currInfo ??>
					发布时间：${currInfo.addtimestr}&nbsp;&nbsp;&nbsp;&nbsp;
					来源：${currInfo.source}&nbsp;&nbsp;&nbsp;&nbsp;
					作者：${currInfo.author}&nbsp;&nbsp;&nbsp;&nbsp;
					阅读：${currInfo.clicknum!'0'}次
					</#if>
				</div>
				<div class="downline"></div>
				<div class="con_con">
					<#if currInfo ??>
					${currInfo.content}
					</#if>
				</div>
				<div class="con_fj">
					<div class="fj_top"></div>
					<div class="fj_center">
						<#if currInfo?? && currInfo.attachs ??>
						<div class="fj_center_con">
							<div class="fj_center_con_title">附件：</div>
							<div class="fj_center_con_con">
								<#list currInfo.attachs as attach>
									<a href="${attach.filepath}">(${attach_index+1}). ${attach.filename}</a>
								</#list>
							</div>
							<div style="clear: both"></div>
							<div class="fj_bottom"></div>
						</div>
						</#if>
					</div>
				</div>
			</div>
			<div class="news_r">
				<div class="box">
					<div class="title" style="    background: #f09119;">
						<span></span>热点新闻
					</div>
					<div class="content">
						<ul class="main">
							<@sme_info_list channelid='101' num="10" titlelen="15";info,index>
							<li><a href="/info-${info.id}.html"
								target="_blank" title="${info.title}">${info.showtitle}…</a></li>
							</@sme_info_list>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="clear"></div>
	
	