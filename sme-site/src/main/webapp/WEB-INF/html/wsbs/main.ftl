
	
	<div class="float_right_box">
		<a class="ctrl-btn-1" href="#" target="_blank"><span class=""
			style="right: -1px;">在线咨询</span></a> <a class="ctrl-btn-2"
			href="#BusyQuery" target="_blank"><span class=""
			style="right: -1px;">查看进度</span></a> <a class="ctrl-btn-3" href="#star"
			target="_blank"><span class="" style="right: -1px;">在线评议</span></a> <a
			class="ctrl-btn-4" href="#" target="_blank"><span class=""
			style="right: -1px;">在线投诉</span></a> <a class="ctrl-btn-5"
			href="javascript:;" style="display: none; visibility: visible;"
			onclick="window.scrollTo(0,0)"><span>返回顶部</span></a>
	</div>


	<div class="pageMain">
		<div class="main clearfix">

			<div id="project">
				<div class="fl wbhomefl">
						<!--
						<div style="margin-bottom: 15px; display: block;">
							<a href="#branch/index"
								class="adshow"> <img alt="区级分厅" width="248"
								src="${base}/resources/wsbs/images/DistrictBranchOffice.jpg"></a>
						</div>
						-->
						<div id="investment" style="margin-bottom: 15px; display: block;">
							<a href="http://baosong.sme.gov.cn/" class="adshow" target="blank"> 
							<img alt="" width="248"
								src="${base}/resources/wsbs/images/InvestmentExamineAndApproveSupervisePlatform.jpg"></a>
						</div>
						
						<div id="commercial" style="margin-bottom: 15px; display: block;">
							<a href="#invest?service=c&commercial=true"
								class="adshow"> <img alt="商事登记" width="248"
								src="${base}/resources/wsbs/images/CommercialPlatform.jpg"></a>
						</div>

						<div style="margin-bottom: 15px; display: block;">
							<a href="/home.html" target="_blank" class="adshow"> 
							<img alt="办结信息" width="248" src="${base}/resources/wsbs/images/BusyInfo.jpg"></a>
						</div>
						<!--
						<div style="margin-bottom: 15px; display: block;">
							<a href="#icity/specialtopic/index"
								target="_blank" class="adshow"> <img alt="场景式服务" width="248"
								src="${base}/resources/wsbs/images/SceneService.jpg"></a>
						</div>
						-->
						<div id="personalwebpage"
							style="margin-bottom: 15px; display: none;">
							<a href="javascript:;" class="adshow" target="_blank"
								id="PersonalWebpageid"> <img alt="专属网页" width="248"
								src="${base}/resources/wsbs/images/CitizenPersonalWebpage.jpg"></a>
						</div>

						<div id="entiprisewebpage"
							style="margin-bottom: 15px; display: block;">
							<a href="/corp.html" class="adshow goTwoWeb" target="_blank"> 
								<img alt="专属网页" width="248"
									src="${base}/resources/wsbs/images/CorporateExclusiveWebpage.jpg"></a>
						</div>

						<div class="brbox lbshow">
							<div class="shadow_bg positionr">
								<div class="boxhead positiona">
									<span class="hotservice_img">热门服务</span>
									<span class="tit_service">大家都在使用哪些服务</span><em class="hot_ico"></em>
								</div>
								<div>
									<div class="photserv">
										<ul class="list_li busyhot">
											<@sme_info_list channelid="101" titlelen="15" dateformat="MM-dd" num="5";info,index>
											<li class="hot_li"><span class="hot_three">1</span> 
												<a href="${info.url}" title="${info.title}" target="_blank" class="listitem">${info.showtitle}…</a>
											</li>
											</@sme_info_list>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				<div class="fr wbhomefr">
					<div id="itemtype" class="rbshow" style="height: auto; min-height: 298px;">
						<div class="bot_bg">
							<div class="phead">
								<span class="title" style="float: left;">办事服务导航</span> <span
									style="float: right; font-size: 13px; color: #333; margin-right: 12px;">
									<!----> 当前导航： <span id="dffl">企业服务</span>&nbsp;&gt;&nbsp; <span
									id="dfpos">玉门市</span>

								</span>
								<ul class="ptabs">
									<a href="javascript:void(0);" id="ptab_a2" class="ptab_a2"
										style="">
										<li class="ptab gr ptabon" tag="sclass">
											<!--企业办事-->
									</li>
									</a>
									<a href="javascript:void(0);" class="ptab_a3">
										<li class="ptab bm " tag="svorg">
											<!--部门办事-->
									</li>
									</a>

								</ul>
							</div>
							<div id="ptype" class="ptype" style="float: left;">
								<div id="tab_sclass"
									style="float: left; padding-top: 20px; display:;">
									<ul class="catalog">
										<@sme_gclass_list code="0"; sclass>
										<li class="sclassLi" scode="${sclass.id}" title="${sclass.title}" style="display: list-item;">
											<div style="text-align: center;">
												<a href="javascript:void(0);"> 
												<img src="${base}/resources/wsbs/images/${sclass.logo}"
													border="none" alt="${sclass.title}"><br> <font
													style="font-size: 12px; color: #333;">${sclass.title}</font></a>
											</div>
										</li> 
										</@sme_gclass_list>
									</ul>
								</div>
								<div id="tab_svorg" style="float: left; display: none;">
									<div class="division">
										<div id="divisionPopDiv">
											<div id="chooseDivision" title="玉门市“四帮一扶”涉企单位">玉门市“四帮一扶”涉企单位</div>
										</div>
										<div id="divisionNum">
											共<span id="dept_tatal" class="num">25</span>个服务部门
										</div>
									</div>
									<div id="deptlist">
										<ul id="dept" style="min-height: 84px;" class="svorg">
											<@sme_svorg_list svgtype="${svgtype!'G'}" num="50";svorg,index>
											<li id="${svorg.id}" svgid="${svorg.id}" class="deptLi" style="display:;"><a
												href="${svorg.url}" title="${svorg.title}">${svorg.title}</a></li>
											</@sme_svorg_list>
										</ul>
										<!--<div class="btnmore" style="display: block;">查看更多</div>-->
									</div>
								</div>
							</div>
						</div>
					</div>
					<div id="itemlist" class="rbshow">
						<div class="bot_bg">
							<div class="phead h40">
								<span class="title">行政服务事项</span>
								<div class="itemtip">
									共&nbsp;<span id="item_total" style="color: red;">49</span>&nbsp;个事项，&nbsp;
								</div>
								<br style="clear: both;">
							</div>
							<div class="phead_B">
								
							</div>
							<div id="ptype" class="ptype">
								<@sme_appealtopic_page page="${page!1}" num="10" pagenum="${pagenum!0}" ;topiclist,pager>
								<!-- 列表 -->
								<div id="s_list" class="body" style="display: block;" tag="list">
									<#list topiclist as topic>
									<div class="permission">
										<div class="permission_dept">
											<img border="0" width="64" height="64" src="${topic.svglogo}"><br>
											<a class="deptname" href="javascript:void(0);"
												title="${topic.svgtitle}" hidefocus="true">${topic.svgtitle}</a>
										</div>
										<div class="permission_info">
											<div class="top">
												<a href="${topic.url}" target="_blank" hidefocus="true"
													class="guidehref">${topic.title}</a>
											</div>
											<div class="center">
												<div class="icons">
													<span class="notsuport">办理时限:${topic.daynum}工作日</span> 
												</div>
											</div>
										</div>
										<div class="permission_online">
											<span> <a href="" target="_blank" class="ibutton">
													在线办理 </a></span> <span> <a class="ibutton nbutton_guide"
												href="${topic.url}" target="_blank">办事指南</a>
											</span>
										</div>
									</div>
									</#list>
								</div>
								<!-- 图标 -->
								<div id="s_icon" class="body" style="display: none;" tag="icon">

								</div>
								<!-- 目录 -->
								<div id="s_type" class="body" tag="type" style="display: none;">

								</div>
								<!-- 分页 -->
								<div id="epager" style="clear: both;">
									<div class="pages">${pager.ajaxPageStr}</div>
								</div>
								</@sme_appealtopic_page>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="clear"></div>
	