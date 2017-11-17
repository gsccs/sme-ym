	<style>
	.sml_header .smlh_slash {
	     position: initial;
		 color: #a0a0a0;
		 font-size: 22px;
		 font-weight: lighter;
		 /* top: 5px; */
		 /* left: 112px; */
		 width: 25px;
		 float: left;
		 text-align: center;
	}
	
	
	
	.smlh_curr{
		color:red;
		font-weight: bolder;
	}
	</style>
	
	
	<div class="clear"></div>

	<div class="main_w">
		<div class="w1000 s_top">
			<div class="s_top_logo">
				<div class="img_p">
					<p class="img-box">
						<img src="${currSvorg.logo}"
							alt="${currSvorg.title}"
							onerror="this.onerror=null;this.src='/resources/site/images/no.png'">
					</p>
				</div>
			</div>
			<div class="s_top_title">
				<div class="s_top_title_name">${currSvorg.title}</div>
				<div class="s_top_title_icon"></div>
			</div>
		</div>
		<div class="w1000 s_main">
			<div class="s_main_left">
				<div class="sml_header">
					<div class="smlh_title smlh_curr" target="introduce">职责简介</div>
					<div class="smlh_slash">/</div>
					<div class="smlh_title" target="appeal">行政事项</div>
					<div class="smlh_slash">/</div>
					<div class="smlh_title" target="declare">项目申报</div>
					<div class="smlh_info" id="smlh_info" >Introduce</div>
				</div>
				
				<div id="introduce" class="sml_content" style="display:">
					${currSvorg.content}
				</div>
				
				<div id="appeal" class="sml_content" style="display:none">
					<div id="appeallist">
						<@sme_appealtopic_page svgid="${currSvorg.id}" page="1" num="5" pagenum="${pagenum!0}"; appealList,pager>
						<#list appealList as appeal>
						<ul class="smlc_prdt_info">
							<li class="smlcp_cont">
								<dl>
									<dt>行政事项：</dt>
									<dd><a href="${appeal.url}">${appeal.title}</a></dd>
								</dl>
								<dl>
									<dt>事项描述：</dt>
									<dd>${appeal.remark}</dd>
								</dl>
							</li>
							<!--<li class="smlcp_btn"> <a href="javascript:void(0);" onclick="RedirectHome();">提交申请</a></li>-->
							<li class="downline"></li>
						</ul>
						</#list>
						${pager.numPageStr}
						</@sme_appealtopic_page>
					</div>
				</div>
				
				<div id="declare" class="sml_content" style="display:none">
					<div id="declarelist">
					<@sme_declaretopic_page svgid="${currSvorg.id}" page="1" num="5" pagenum="${pagenum!0}"; declarelist,pager>
					<#list declarelist as declare>
					<ul class="smlc_prdt_info">
						<li class="smlcp_cont">
							<dl>
								<dt>申报专题：</dt>
								<dd><a href="${declare.url}" >${declare.title}</a> </dd>
							</dl>
							<dl>
								<dt style="float: left;">申报开始时间：</dt>
								<dd style="float: left;width: 25%;">${declare.starttimestr} </dd>
								<dt style="float: left;">申报结束时间：</dt>
								<dd style="float: left;width: 25%;">${declare.endtimestr} </dd>
							</dl>
						</li>
						<li class="smlcp_btn"> <a href="javascript:void(0);" onclick="RedirectHome();">提交申请</a></li>
						<li class="downline"></li>
					</ul>
					
					</#list>
					${pager.numPageStr}
					</@sme_declaretopic_page>
					</div>
				</div>
			</div>
			<div class="s_main_right">
				<div class="smr_info">
					<div class="smri_title">
						<div class="smrit_left">Information</div>
						<div class="smrit_main">机构信息</div>
						<div class="smrit_right">&nbsp;</div>
					</div>
					<dl>
						<dt>机构名称：</dt>
						<dd>${currSvorg.title}</dd>
					</dl>
					<dl>
						<dt>机构性质：</dt>
						<dd>事业单位</dd>
					</dl>
					<dl>
						<dt>所在地址：</dt>
						<dd>${currSvorg.address}</dd>
					</dl>
					<dl>
						<dt>官方网址：</dt>
						<dd>
							<a href="${currSvorg.domain}" target="_blank">${currSvorg.domain}</a>
						</dd>
					</dl>
				</div>
				<div class="smr_info">
					<div class="smri_title">
						<div class="smrit_left">Contact</div>
						<div class="smrit_main">联系方式</div>
						<div class="smrit_right">&nbsp;</div>
					</div>
					<dl>
						<dt>联系人：</dt>
						<dd>${currSvorg.linker}</dd>
					</dl>
					<dl>
						<dt>
							<span>电</span>话：
						</dt>
						<dd>${currSvorg.linktel}</dd>
					</dl>
					<dl>
						<dt>
							<span>传</span>真：
						</dt>
						<dd>${currSvorg.linktel}</dd>
					</dl>
					<dl>
						<dt>
							<span>邮</span>箱：
						</dt>
						<dd>${currSvorg.email}</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<a target="_blank"
								href="http://wpa.qq.com/msgrd?v=3&uin=${currSvorg.qq}&site=qq&menu=yes">
								<img border="0" src="${base}/resources/site/images/zx_qq.gif" alt="点击这里给我发消息"
								title="点击这里给我发消息" />
							</a>
						</dd>
					</dl>
				</div>
				<div class="smr_info">
					<div class="smri_title">
						<div class="smrit_left">Information</div>
						<div class="smrit_main">政策通知</div>
						<div class="smrit_right">&nbsp;</div>
					</div>
					<ul class="smri_title">
						<@sme_info_list svgid="${currSvorg.id}" titlelen="15" dateformat="MM-dd" num="5";info,index>
							<li class="hot_li"> 
								<a href="${info.url}" title="${info.title}" target="_blank" class="listitem">${info.showtitle}…</a>
							</li>
						</@sme_info_list>
					</ul>
				<div>
			</div>
		</div>
	</div>

	<div class="clear"></div>
	