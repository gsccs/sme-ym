<style>
.acti_left .main .n_left dl{
  width: 500px;
  line-height: 2em;
  float: left;
  overflow: hidden;
}

.acti_left .main .n_left dt {
  float: left;
  color: #0c77ca;
}

.acti_left .main .n_left dd {
  width: 400px;
  float: left;
}

.acti_left .main .n_right{
	padding: 5px 10px 0;
}


.main_r {
  width: 209px;
  margin-top: 15px;
  overflow: hidden;
  background: #fff;
  padding: 15px 18px;
}

.main_r .r_title {
  font-size: 16px;
  font-weight: bold;
  background: #f09119;
  text-align: center;
  height: 30px;
  line-height: 30px;
  color: #FFF;
}

.main_r .content .main li {
  height: 2.5em;
  line-height: 2.5em;
  border-bottom: 1px dashed #d0d0d0;
  padding-left: 10px;
  list-style: disc inside;
  width: 90px;
  float: left;
  overflow: hidden;
}
</style>

<div class="clear"></div>
<div class="main_w">
	<div class="w1000">
		<div class="acti_left">
			<div class="filter">
				<dl class="filter_main exp">
					<dt>分类</dt>
					<dd id="CategoryMain">
						<a href="javascript:void(0)" class="all hover" rel="0">不限</a> 
						<@sme_sclass_list code="0" type="G"; gclass> 
							<a href="javascript:void(0)" rel="${gclass.id}">${gclass.title}</a>
						</@sme_sclass_list>
					</dd>
				</dl>
				<!--
				<dl class="filter_main">
					<dt>部门</dt>
					<dd id="AreaMain">
						<a href="javascript:void(0)" class="all hover" rel="0">全市</a> 
						<@sme_svorg_list svgtype="${svgtype!'G'}" num="50";svorg,index>
							<a href="javascript:void(0)" rel="${svorg.id}">${svorg.title}</a>
						</@sme_svorg_list> 
					</dd>
				</dl>
				-->
			</div>
			<div class="title">行政事项</div>
			<@sme_appealtopic_page dateformat="yyyy-MM-dd HH:mm" page="${page!1}" num="${num!10}" svgid="${svgid}" scode="${gcode}";appeallist,pager>
			<div>
				<#list appeallist as appealtopic>
				<div class="main">
					<ul class="n_left">
						<li>
						<a href="${appealtopic.url}" target="_blank" title="${appealtopic.title}">${appealtopic.title}</a></li>
						<li>
							<dl class="">
								<dt>服务部门：</dt>
								<dd>${appealtopic.svgtitle!'-'}</dd>
								<dt>办事窗口：</dt>
								<dd>${appealtopic.swindow!'-'}</dd>
							</dl>
						</li>
					</ul>
					<div class="sr-btn-box fr n_right" >
					<a href="${appealtopic.url}" target="_blank" title="${appealtopic.title}">办事指南</a>
					</div>
				</div>
				</#list>
			</div>
			<div id="dvPageNotice" class="acti_page">
				<div id="dvLoadingNotice" class="loading"></div>
				${pager.numPageStr}
			</div>
			</@sme_appealtopic_page>
		</div>
		
		<div class="main_r fr">
			<div class="r_title">行政单位</div>
			<div class="content">
					<ul class="main">
						<@sme_svorg_list svgtype="G" num="50";svorg,index>
						<li><a href="${svorg.url}" target="_blank" title="${svorg.title}">${svorg.title}</a></li>
						</@sme_svorg_list>
					</ul>
			</div>	
		</div>
	</div>
</div>	
<div class="clear"></div>

