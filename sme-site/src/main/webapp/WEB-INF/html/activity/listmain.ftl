<div class="clear"></div>
<div class="main_w">
	<div class="w1000">
		<div class="acti_left">
			<div class="filter">
				<dl class="filter_main exp">
					<dt>分类</dt>
					<dd id="CategoryMain">
						<a href="javascript:void(0)" class="all hover" rel="0">不限</a> 
						<@sme_sclass_list code="0"; sclass> 
							<a href="javascript:void(0)" rel="${sclass.id}">${sclass.title}</a>
						</@sme_sclass_list>
					</dd>
				</dl>
				<dl class="filter_main">
					<dt>区域</dt>
					<dd id="AreaMain">
						<a href="javascript:void(0)" class="all hover" rel="1">全省</a> 
						<@sme_area_list parid="62";area,index>
							<a href="javascript:void(0)" rel="${area.code}">${area.name}</a>
						</@sme_area_list> 
					</dd>
				</dl>
			</div>
			<div class="title">活动预告</div>
			<@sme_activity_page dateformat="yyyy-MM-dd HH:mm" page="${page!1}" num="${num!10}" scode="${scode}";actlist,pager>
			<div id="dvActivityNotice">
				<#list actlist as activity>
				<div class="main">
					<ul class="n_left">
						<li class="title">
						<a href="${activity.url}" target="_blank" title="${activity.title}">${activity.title}</a></li>
						<li>${activity.remark}…</li>
					</ul>
					<dl class="n_right">
						<dt>活动时间：</dt>
						<dd>${activity.starttimestr}</dd>
						<dt>活动类别：</dt>
						<dd>${activity.sclassstr}</dd>
						<dt>活动地址：</dt>
						<dd title="${activity.areastr}">${activity.areastr}</dd>
					</dl>
					<div class="signup" onclick="onSignUp('${activity.id}','${activity.svgid}')">
					</div>
				</div>
				</#list>
			</div>
			<div id="dvPageNotice" class="acti_page">
				<div id="dvLoadingNotice" class="loading"></div>
				${pager.numPageStr}
			</div>
			</@sme_activity_page>
		</div>
		<div class="acti_right">
			<a class="publish" href="http://sp.smeym.org/"></a>
			<div class="box">
				<div class="title">
					<span></span>热门活动
				</div>
				<div class="content">

					<ul class="main">
						<@sme_activity_list dateformat="yyyy-MM-dd HH:mm" titlelen="12";activity,index>
						<li><a href="/activity-${activity.id}.html"
							target="_blank" title="${activity.title}">${activity.showtitle}…</a></li>
						</@sme_activity_list>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>	
<div class="clear"></div>

