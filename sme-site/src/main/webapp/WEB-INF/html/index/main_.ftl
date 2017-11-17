	<style>
		.sclass_title{
			height:45px;
			line-height:45px;
			color:#FFF;
			text-align:center;
			font-size:14px;
		}
		
		.logreg_box {
		  height: 69px;
		  border-top: 1px solid #525e61;
		  padding: 0px 15px;
		}
		
		.fwdt_title{
			border: none;
			/**border-bottom: 2px solid #dd2828;**/
			padding: 0 5px;
			height: 45px;
  			line-height: 35px;
  			color: #dd2828;
			font-size: 16px;
			font-weight: bolder;
			cursor: pointer;
			background: url("/resources/site/images/fwdt.png");
		}
		
		.fwdt_box{
			height:90px;
			padding:5px 15px;
		}
		.fwdt_dl{
			width: 130px;
			height: 40px;
			line-height: 40px;
			float:left;
		}
		
		.fwdt_dl dt{
			float: left;
			height: 40px;
			line-height: 40px;
			display: block;
		}
		
		.fwdt_dl dt img{
			height: 25px;
			padding: 10px 5px;
		}
		
		
		.gclass{
			float: left;
			width: 100px;
			padding: 15px 15px 17px 15px;
			border-bottom: 1px dashed #cccccc;
			border-right: 1px solid #cccccc;
			height: 126px;
		}
		
		.deptLi a{
			background: url(/resources/wsbs/images/list_ico01.gif) no-repeat 0 5px;
  			padding: 0px 10px;
		}
	</style>
	
    <div class="clear"></div>
	<div class="container">
		<!--下拉大幅广告 start -->
		<!--<div id="top_img">
    			<div id="dvClose">╳</div>
			</div>-->
		<!--下拉大幅广告 end -->
		<div class="w_ban_bd">
			<div class="w_ban">
				
				<div class="w_h3_1_1">
					<ul>
						<@sme_sclass_list code="0"; sclass> 
							<li><a href="/sitem.html?scode=${sclass.id}" title="${sclass.title}">${sclass.title}</a></li>
						</@sme_sclass_list>
					</ul>
				</div>
				<div class="w_ban2">
					<div class="indexSlide">
						<div class="slide_show" id="slide_show">
							<div class="slide_wrap" id="index_slide">
								<ol class="clearfix" style="">
									<@sme_activity_list num="4"; activity,index>
									<li><a class="big_pic" href="${activity.url}" target="_blank"> 
										<img id="lunbo_${index}" src="/resources/site/images/w_banner_${index+1}.jpg">
										</a>
									</li>
									</@sme_activity_list>
								</ol>
							</div>
							<ul class="none" id="lunboNum">
								<#assign x=4>
								<#list 1..x as i>
								<#if i=1>
								<li class="cur"></li>
								<#else>
								<li></li>
								</#if>
								</#list>
							</ul>
							<a style="display: none;" href="javascript:void(0);" class="show_next"><s></s></a> 
							<a style="display: none;" href="javascript:void(0);" class="show_pre"><s></s></a>
						</div>
					</div>
				</div>
				<div class="w_ban3">
					
					<div class="w_ban3_t">
						<div class="w_ban3_t1">
							<a href="/channel.html?id=101" title="更多&gt;&gt;" id="aNewsMore">更多&gt;&gt;</a>
							<p>
								<span class="w_ban3_t1x" id="tt1" onmouseover="setTab('tt',1,2,'w_ban3_t1x')">通知公告</span>
								<!--
								|<span id="tt2" onmouseover="setTab('tt',2,2,'w_ban3_t1x')">平台动态</span>
								-->
							</p>
						</div>
						<ul class="w_ban3_l1" id="con_tt_1" style="display: block;">
							<@sme_info_list channelid="101" titlelen="15" dateformat="MM-dd" num="3";info,index>
							<li><span>${info.addtimestr}</span>
								<a href="${info.url}" title="${info.title}" target="_blank">${info.showtitle}…</a>
							</li>
							</@sme_info_list>
						</ul>
						<!--
						<ul class="w_ban3_l1" id="con_tt_2" style="display: none;">
							<@sme_info_list channelid="103" titlelen="15" dateformat="MM-dd" num="7";info,index>
							<li><span>${info.addtimestr}</span>
								<a href="${info.url}" title="${info.title}" target="_blank">${info.showtitle}…</a>
							</li>
							</@sme_info_list>
						</ul>
						-->
					</div>
					<div class="w_ban3_t">
						<div class="fwdt_title"></div>
						<div class="fwdt_box">
							<dl class="fwdt_dl">
								<dt><img src="${base}/resources/wsbs/images/root_qy_ztfl_zzrz.png" title="" alt=""></dt>
								<dd><a href="/wsbs.html" target="blank">服务事项</a> </dd>
							</dl>
							<dl class="fwdt_dl">
								<dt><img src="${base}/resources/wsbs/images/root_qy_ztfl_zzrz.png" title="" alt=""></dt>
								<dd><a href="/wsbs_query.html" target="blank">查看进度</a></dd>
							</dl>
							<dl class="fwdt_dl">
								<dt><img src="${base}/resources/wsbs/images/root_qy_ztfl_zzrz.png" title="" alt=""></dt>
								<dd><a href="/declare.html" target="blank">项目申报</a></dd>
							</dl>
							<dl class="fwdt_dl">
								<dt><img src="${base}/resources/wsbs/images/root_qy_ztfl_zzrz.png" title="" alt=""></dt>
								<dd><a href="/report.html" target="blank">数据报送</a></dd>
							</dl>
						</div>
						<div id="UserInfo" class="logreg_box">
							<div class="w_ban3_2">
								<@shiro.guest> 
								<a href="javascript:void(0);" onclick="RedirectLogin()" title="登录" class="w_ban3_x1">登录</a>
								<a href="javascript:void(0);" onclick="RedirectRegist()" title="注册" class="w_ban3_x2">注册</a>
								</@shiro.guest>
								<@shiro.user> 
								<a href="/home.html" title="发布服务需求" class="w_ban3_x1">发布服务需求</a>
								<a href="http://sp.smeym.org/" title="发布服务项目" class="w_ban3_x2">发布服务项目</a>
								</@shiro.user>
							</div>
						<div>
					</div>
				</div>
			</div>
		</div>
		</div></div>
		<div class="clear"></div>
		<div class="w_banner">
			<div class="DB_tab25">
		        <ul class="DB_bgSet">
		            <li style="background: url('${base}/resources/banner/images/banner_bg_1.jpg') no-repeat 100% 100%;" onclick="javascript:window.open('park.html');"></li>
		            <li style="background: url('${base}/resources/banner/images/banner_bg_2.jpg') no-repeat 100% 100%;" onclick="javascript:window.open('park.html');"></li>
		            <li style="background: url('${base}/resources/banner/images/banner_bg_3.jpg') no-repeat 100% 100%;" onclick="javascript:window.open('park.html');"></li>
		        </ul>
		        <ul class="DB_imgSet">
		            <li >
		                <img class="DB_1_1" src="${base}/resources/banner/images/banner_text_1_1.png" alt="" style="max-height:90px;"/>
		                <img class="DB_1_2" src="${base}/resources/banner/images/banner_text_1_2.png" alt="" style="max-height:70px;"/>
		                <!--<img class="DB_1_3" src="${base}/resources/banner/images/stuimg1_3.png" alt="" style="max-height:90px;"/>-->
		            </li>
		            <li onclick="javascript:window.location.href='/park.html';">
		                <img class="DB_2_1" src="${base}/resources/banner/images/banner_text_2_1.png" alt="" style="max-height:90px;"/>
		                <img class="DB_2_2" src="${base}/resources/banner/images/banner_text_2_2.png" alt="" style="max-height:70px;"/>
		                <!--<img class="DB_2_3" src="${base}/resources/banner/images/stuimg2_3.png" alt="" style="max-height:90px;"/>-->
		            </li>
		            <li onclick="javascript:window.location.href='/park.html';">
		                <img class="DB_3_1" src="${base}/resources/banner/images/banner_text_3_1.png" alt="" style="max-height:90px;"/>
		                <img class="DB_3_2" src="${base}/resources/banner/images/banner_text_3_2.png" alt="" style="max-height:70px;"/>
		                <!--<img class="DB_3_3" src="${base}/resources/banner/images/stuimg3_3.png" alt="" style="max-height:90px;"/>-->
		            </li>
		        </ul>
		        <!--
		        <div class="DB_menuWrap">
		            <ul class="DB_menuSet">
		                <li>
		                    <img src="${base}/resources/banner/images/btn_off.png" alt="" />
		                </li>
		                <li>
		                    <img src="${base}/resources/banner/images/btn_off.png" alt="" />
		                </li>
		                <li>
		                    <img src="${base}/resources/banner/images/btn_off.png" alt="" />
		                </li>
		            </ul>
		            <div class="DB_next">
		                <img src="${base}/resources/banner/images/nextArrow.png" alt="NEXT" />
		            </div>
		            <div class="DB_prev">
		                <img src="${base}/resources/banner/images/prevArrow.png" alt="PREV" />
		            </div>
		        </div>
		        -->
		    </div>
		</div>
		<div class="clear"></div>
		<div class="w_tj">
			<dl>
				<dt>服务机构注册量：</dt>
				<dd class="exp" id="plat_svg_num">9</dd>
				<dd>家</dd>
			</dl>
			<dl class="exp">
				<dt>行政事项发布量：</dt>
				<dd class="exp" id="plat_gitem_num">0</dd>
				<dd>条</dd>
			</dl>
			<dl class="exp">
				<dt>服务事项发布量：</dt>
				<dd class="exp" id="plat_sitem_num">0</dd> 
				<dd>次</dd>
			</dl>
			<dl class="exp">
				<dt>企业注册量：</dt>
				<dd class="exp" id="plat_corp_num">285</dd>
				<dd>家</dd>
			</dl>
			<div class="stat">
				<a href="/statist.html" target="_blank">点击查看数据统计</a>
			</div>
		</div>
		<div class="w_center_bd">
			<div class="w_f1">
				<div class="w_head">
					<a id="flow_1_more" href="/wsbs.html" title="更多&gt;&gt;" class="w_rig">更多&gt;&gt;</a>
					<p class="w_p_img1">
						<span id="wt1" class="w_dqys" onmouseover="setTabFlow_1('wt',1,8,'w_dqys')">行政事项</span>
					   |<span id="wt2" onmouseover="setTabFlow_1('wt',2,8,'w_dqys')">服务部门</span>
					   |<span id="wt3" onmouseover="setTabFlow_1('wt',3,8,'w_dqys')">服务活动</span>
					</p>
				</div>
				<div class="w_f1_nr">
					<ul class="w_f1_nr1" id="con_wt_1" style="display: block;">
						<@sme_gclass_list code="0"; sclass>
						<li class="gclass" style="  width: 100px;padding: 25px 15px 7px 15px;">
						<a href="/appeal.html?gcode=${sclass.id}" title="${sclass.title}" target="_blank" style="display: block;width: 60px;height: 60px;  margin: 0 auto;"> 
							<img src="${base}/resources/wsbs/images/${sclass.logo}" title="${sclass.title}"
								alt="${sclass.title}" style="width: 60px;height: 60px;"
								onerror="this.onerror=null;this.src='/resources/site/images/no.png'"></a>
							<h2 style="  text-align: center;">
								<a href="/appeal.html?gcode=${sclass.id}" title="${sclass.title}" target="_blank">${sclass.title}</a>
							</h2>
						</li>
						</@sme_gclass_list>
					</ul>
					<ul class="w_f1_nr1" id="con_wt_2" style="display: none;">
						<@sme_svorg_list svgtype="G" num="50";svorg,index>
							<li id="${svorg.id}" svgid="${svorg.id}" class="deptLi" style="  width: 110px;padding: 15px 15px 17px 15px;  height: 14px;">
								<a href="${svorg.url}" title="${svorg.title}">${svorg.title}</a>
							</li>
						</@sme_svorg_list>
					</ul>
					<ul class="w_f1_nr1" id="con_wt_3" style="display: none;">
						<@sme_activity_list dateformat="yyyy-MM-dd HH:mm" num="4" titlelen="15" remarklen="50";activity>
						<li><a href="${activity.url}" title="${activity.title}" target="_blank"> 
							<img src="${activity.img}" title="${activity.title}"
								alt="${activity.title}" onerror="this.onerror=null;this.src='/resources/site/images/no.png'"></a>
							<h2>
								<a href="${activity.url}" title="${activity.title}" target="_blank">${activity.showtitle}…</a>
							</h2>
							<p>
								<a href="${activity.url}" title="${activity.title}" target="_blank">${activity.showremark}…</a>
							</p>
							<p>
								<em>活动时间： ${activity.starttimestr} </em>
							</p>
						</li>
						</@sme_activity_list>
					</ul>
					<div class="w_f1_r f1_wsbs" id="con_wt_rmg_1">
						<a href="/wsbs.html" title="服务大厅"></a>
					</div>
					<div class="w_f1_r f1_item" id="con_wt_rmg_2" style="display:none">
						<a href="http://sp.smeym.org/" title="发布服务"></a>
					</div>
					<div class="w_f1_r f1_acti" id="con_wt_rmg_3" style="display:none">
						<a href="http://sp.smeym.org/" title="发布活动"></a>
					</div>
				</div>
			</div>
			<div class="w_f2">
				<div class="w_head">
					<a href="/corp.html" title="更多&gt;&gt;" class="w_rig" id="aSvcItemMore"> 更多&gt;&gt;</a>
					<p class="w_p_img2">
						<a href="/corp.html" title="" class="w_xx" id="xx1"
							onmouseover="setTab2('xx',1,8,'w_xx',1)">企业风采</a>&nbsp;&nbsp;|&nbsp;&nbsp;
						<a href="/sneed.html" title=""  id="xx2"
							onmouseover="setTab2('xx',2,8,'w_xx',2)">企业需求</a>&nbsp;&nbsp;|&nbsp;&nbsp;
						<a href="/product.html" title=""  id="xx3"
							onmouseover="setTab2('xx',3,8,'w_xx',3)">产品发布</a>
					</p>
					<div class="w_head_a">
						
					</div>
				</div>
				
				<div class="w_f2_nr" id="con_xx_1" style="display: block;">
					<ul>
						<@sme_corp_list num="5" titlelen="15";corp,index>
						<#if index==4>
						<li style='border-right: none;'>
						<#else>
						<li>
						</#if>
							<div class="w_f2_nr1">
								<a href="${corp.url}" title="${corp.title}" target="_blank"> 
								<img src="${corp.logo}" title="${corp.title}" alt="${corp.title}"
									onerror="this.onerror=null;this.src='/resources/site/images/no.png'"></a>
							</div> 
							<!--<b> <a href="${corp.url}" title="${corp.title}">${corp.showtitle}</a></b>-->
							<p>
								<a href="${corp.url}" title="了解详情" target="_blank">${corp.showtitle}</a>
							</p>
							
						</li>
						</@sme_corp_list>
					</ul>
				</div>
				<div class="w_f2_mid" id="con_xx_2" style="display: none;">
					<ul class="w_f2_sneed">
						<@sme_sneed_list code="0" titlelen='20' num="6";sneed,index>
						<#if index%2=0>
						<li class="no_left">
						<#else>
						<li>
						</#if>
							<h2>
								<a href="${sneed.url}" title="${sneed.title}" target="_blank">${sneed.title}</a>
							</h2>
							<p>
								<span title="${sneed.sclassstr}"><em>需求类别：</em>${sneed.sclassstr}…</span><span>发布日期：${sneed.addtimestr}</span>
							</p>
						</li>
						</@sme_sneed_list>
					</ul>
					<div class="w_f3_rig_nr">
						<ul class="w_f3_rig_nr_ul">
							<li>
							<input type="text" id="DemandName"
								placeholder="请输入您的需求标题" required="required" maxlength="100"
								style="margin-top: 8px" data-msg-name="需求标题"></li>
							<li><select id="Superclass" onchange="loadSubclass()">
									<option value="">--请选择一级类--</option>
									<@sme_sclass_list code="0";sclass>
									<option value="${sclass.id}">${sclass.title}</option>
									</@sme_sclass_list>
								</select> 
								<select id="Subclass">
									<option value="">--请选择二级类--</option>
								</select>
							</li>
							<li><input type="text" id="LinkMan" placeholder="请输入联系人"
								required="required" maxlength="100" style="width: 118px"
								data-msg-name="联系人"> 
								<input type="text" id="LinkPhone"
									placeholder="请输入联系电话" required="required" maxlength="100"
									style="width: 117px" data-msg-name="联系电话"></li>
							<li><textarea id="Demand_Detailed" required="required"
									placeholder="请输入您的需求内容" data-msg-name="需求内容"></textarea></li>
							<li>
								<div class="w_mffb">
									<a href="javascript:void(0);" style="cursor: hand"
										onclick="AddDemand()" title="免费发布需求"> 免费发布需求</a>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="w_f2_nr" id="con_xx_3" style="display: none;">
					<ul class="w_f2_product">
						<@sme_product_list num="6" titlelen="15";product>
							<li><a href="${product.url}" title="${product.title}" target="_blank"> 
								<img src="${product.img}" title="${product.title}" alt="${product.title}" 
									onerror="this.onerror=null;this.src='/resources/site/images/no.png'">
								</a>
								<h2>
									<a href="${product.url}" title="${product.title}" target="_blank">${product.showtitle}…</a>
								</h2>
								<span>${product.brief}……</span>
							</li>
						</@sme_product_list>
					</ul>
				</div>
			</div>
			
			<div class="w_f4">
				<div class="w_f4_lef">
					<div class="w_head">
						<a href="/svorg.html" title="更多&gt;&gt;" class="w_rig">更多&gt;&gt;</a>
						<p class="w_p_img4_1">
							<em><a href="/svorg.html" title="找机构,推荐机构">推荐机构</a></em>
						</p>
					</div>
					<div class="LeftBotton3" onmouseup="StopUp_2()" onmousedown="GoUp_2()" onmouseout="StopUp_2()"></div>
					<div class="w_f4_lef_nr" id="SvcOrgTJ">
						<div class="wf4lefnr_sub">
							<div id="SvcOrgTJ_List1">
								<@sme_svorg_list svgtype='S' num="20";svorg,index>
								<#if index%2=0>
								<ul id="${index}">
								</#if>
									<li class="no_left" test="${index}">
										<a href="${svorg.url}" title="${svorg.title}" target="_blank"> 
											<img src="${svorg.logo}" title="${svorg.title}" alt="${svorg.title}"
												onerror="this.onerror=null;this.src='/resources/site/images/no.png'">
											<div class="icon_zl">战略</div>
											<div class="icon_zl icon_hx">核心</div>
										</a>
										<p>
											<a href="${svorg.url}" title="${svorg.title}" target="_blank">${svorg.title}…</a>
										</p>
									</li>
								<#if index gt 0 >
								<#if index%2!=0>
								</ul>
								</#if></#if>
								</@sme_svorg_list>
							</div>
						</div>
					</div>
					<div class="RightBotton3" onmouseup="ISL_StopDown_2()"
						onmousedown="ISL_GoDown_2()" onmouseout="ISL_StopDown_2()">
					</div>
				</div>
				<div class="w_f4_rig">
					<div class="w_head">
						<a href="/expert.html" title="更多&gt;&gt;" class="w_rig">更多&gt;&gt;</a>
						<p class="w_p_img4_2">
							<em><a href="/expert.html" title="找专家,推荐专家">推荐专家</a></em>
						</p>
					</div>
					<ul class="w_f4_rig_nr">
						<@sme_expert_list ;expert,index>
						<#if index%3==0>
						<li class="no_left">
						<#else>
						<li>
						</#if>
							<a href="${expert.url}" title="${expert.title}" target="_blank"> 
							<img src="${expert.logo}" title="${expert.title}" alt="${expert.title}"
								onerror="this.onerror=null;this.src='/resources/site/images/no.png'">
							</a>
							<p>
								<a href="${expert.url}" title="${expert.title}" target="_blank">${expert.title}</a>
							</p>
						</li>
						</@sme_expert_list>
					</ul>
				</div>
			</div>
			<div class="w_f5">
				<div class="w_head">
					<a href="#" title="更多&gt;&gt;" class="w_rig">更多&gt;&gt;</a>
					<p class="w_p_img5">
						<em>玉门风采</em>
					</p>
				</div>
				<div class="w_bd_3">
					<div onmouseup="StopUp_3()" class="LeftBotton3" onmousedown="GoUp_3()" onmouseout="StopUp_3()"></div>
					<div class="Cont3" id="Cont_3">
						<div class="ScrCont">
							<div id="List1_3">
								<!-- 图片列表 begin -->
								<@sme_info_list channelid='108' num="20"; info,index>
								<div class="box3">
									<a href="${info.url}" title="${info.title}" target="_blank" rel="nofollow"> 
										<img src="${info.img}" title="${info.title}" alt="${info.title}">
									</a>
								</div>
								</@sme_info_list>
								<!-- 图片列表 end -->
							</div>
							<div id="List2_3">
								
							</div>
						</div>
					</div>
					<div onmouseup="ISL_StopDown_3()" class="RightBotton3"
						onmousedown="ISL_GoDown_3()" onmouseout="ISL_StopDown_3()">
					</div>
				</div>
			</div>
			<div class="w_f6">
				<div class="w_f6_1">
					<div class="w_head">
						<a href="/channel.html?id=103" title="更多&gt;&gt;" class="w_rig">更多&gt;&gt;</a>
						<p class="w_p_img6_1">
							<em>项目规划</em>
						</p>
					</div>
					<ul class="w_f6_1_nr">
						<@sme_info_list channelid="103" num="2" titlelen="10" dateformat="yyyy-MM-dd"; info,index>
						<li><a href="${info.url}" 
									title="${info.title}" target="_blank"> 
							<img src="${info.img}" title="${info.title}" alt="${info.title}"
								onerror="this.onerror=null;this.src='/resources/site/images/no.png'"></a>
							<h2>
								<a href="${info.url}"
									title="${info.title}" target="_blank">${info.title}</a>
							</h2>
							<p>
								<a href="${info.url}"
									title="${info.title}" target="_blank">${info.remark}…</a>
							</p>
							<p>
								<em>${info.addtimestr}</em>
							</p>
						</li>
						</@sme_info_list>
					</ul>
				</div>
				<div class="w_f6_2">
					<div class="w_head">
						<a href="/channel.html?id=1013" title="更多&gt;&gt;" class="w_rig">更多&gt;&gt;</a>
						<p class="w_p_img6_3">
							<em>文化旅游</em>
						</p>
					</div>
					<div id="myscroll">
						<ul class="w_f6_2_nr">
						<@sme_info_list channelid="1013" num="5" titlelen="10" remarklen="25" dateformat="yyyy-MM-dd"; info,index>
						<li><a href="${info.url}"  title="${info.title}" target="_blank"> 
							<img src="${info.img}" title="${info.title}" alt="${info.title}"
								onerror="this.onerror=null;this.src='/resources/site/images/no.png'"></a>
							<h2>
								<a href="${info.url}" title="${info.title}" target="_blank">${info.title}</a>
							</h2>
							<p>
								<a href="${info.url}" title="${info.title}" target="_blank">${info.showremark}…</a>
							</p>
						</li>
						</@sme_info_list>
						</ul>
					</div>
				</div>
				<div class="w_f6_3">
					<div class="w_head">
						<a href="/#" title="更多&gt;&gt;" class="w_rig">更多&gt;&gt;</a>
						<p class="w_p_img6_2">
							<em>玉门特色</em>
						</p>
					</div>
					<ul class="w_f6_2_nr">
						<@sme_info_list channelid="106" num="2" titlelen="10" remarklen="25" dateformat="yyyy-MM-dd"; info,index>
						<li><a href="${info.url}" 
									title="${info.title}" target="_blank"> 
							<img src="${info.img}" title="${info.title}" alt="${info.title}"
								onerror="this.onerror=null;this.src='/resources/site/images/no.png'"></a>
							<h2>
								<a href="${info.url}"
									title="${info.title}" target="_blank">${info.title}</a>
							</h2>
							<p>
								<a href="${info.url}" title="${info.title}" target="_blank">${info.showremark}…</a>
							</p>
						</li>
						</@sme_info_list>
					</ul>
				</div>
			</div>
		</div>
		<div class="clear"></div>
		<div class="w_bot_bd">
			<div class="w_bot_1">
				<div class="w_bot_1s">
					<@sme_link_class type='3'; lkclass,index>
						<#if index==0>
						<a href="javascript:void(0)" title="${lkclass.name}" class="w_bot_dq" id="tw${index+1}" onmouseover="setTab('tw',${index+1},4,'w_bot_dq')"> ${lkclass.name}</a>
						<#else>
						<a href="javascript:void(0)" title="${lkclass.name}" id="tw${index+1}" onmouseover="setTab('tw',${index+1},4,'w_bot_dq')">${lkclass.name}</a>
						</#if>
					</@sme_link_class>
				</div>
				<@sme_link_class type='3'; lkclass,index>
				<#if index==0>
				<div class="w_bot_1x" id="con_tw_${index+1}" style="display: block;">
				<#else>
				<div class="w_bot_1x" id="con_tw_${index+1}" style="display: none;">
				</#if>
					<@sme_link_list classId="${lkclass.id}" type='3'; link,index>
					<a href="${link.url}" rel="${link.name}" target="_blank">${link.name}</a>
					</@sme_link_list>
				</div>
				</@sme_link_class>
			</div>
			<div class="w_bot_2" id="dvFoot">
				<em>友情链接</em> 
				<select>
					<option value="0">国家部委网站</option>
					<option value="http://www.gov.cn/">中央人民政府门户网站</option>
					<option value="http://www.sdpc.gov.cn/">发展改革委</option>
					<option value="http://www.miit.gov.cn/n11293472/index.html">工业与信息化部</option>
					<option value="http://www.most.gov.cn/index.htm">科技部</option>
					<option value="http://www.mohrss.gov.cn/">人力和社会保障部</option>
					<option value="http://www.mofcom.gov.cn/">商务部</option>
					<option value="http://www.chinatax.gov.cn/">税务总局</option>
					<option value="http://www.saic.gov.cn/">工商总局</option>
					<option value="http://www.sipo.gov.cn/">知识产权局</option>
				</select> 
				<select>
					<option value="0">市政府及各局网站</option>
					<@sme_link_list classId="278d273a-a486-4128-831f-3d8a2c7ff54f" type='2'; link,index>
						<option value="${link.url}">${link.name}</option>
					</@sme_link_list>
				</select> 
				<select>
					<option value="0">行业网站</option>
					<@sme_link_list classId="3673893e-d11b-41bb-a3b2-006927972575" type='2'; link,index>
						<option value="${link.url}">${link.name}</option>
					</@sme_link_list>
				</select> 
				<select>
					<option value="0">新闻媒体网站</option>
					<option value="http://www.sme.gov.cn/index.htm">中国中小企业信息网</option>
					<option value="#">甘肃中小企业网</option>
					<option value="#">甘肃在线</option>
					<option value="http://www.rednet.cn/">红网</option>
					<option value="http://www.people.com.cn/">人民网</option>
					<option value="#">甘肃经济网</option>
					<option value="#">甘肃人才网</option>
				</select>
			</div>
		</div>

		<div class="clear"></div>
	</div>
	
	<script type="text/javascript">
        $('.DB_tab25').DB_tabMotionBanner({
            key: 'b28551',
            autoRollingTime: 6000,
            bgSpeed: 500,
            motion: {
                DB_1_1: { left: -50, opacity: 0, speed: 1000, delay: 500 },
                DB_1_2: { left: -50, opacity: 0, speed: 1000, delay: 1000 },
                /**DB_1_3: { left: 100, opacity: 0, speed: 1000, delay: 1500 },**/
                DB_2_1: { top: 50, opacity: 0, speed: 1000, delay: 500 },
                DB_2_2: { top: 50, opacity: 0, speed: 1000, delay: 1000 },
                /**DB_2_3: { top: 100, opacity: 0, speed: 1000, delay: 1500 },**/
                DB_3_1: { left: -50, opacity: 0, speed: 1000, delay: 500 },
                DB_3_2: { top: 50, opacity: 0, speed: 1000, delay: 1000 },
                /**DB_3_3: { top: 0, opacity: 0, speed: 1000, delay: 1500 },**/
                end: null
            }
        })
    </script>