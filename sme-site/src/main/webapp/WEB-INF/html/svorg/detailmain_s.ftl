
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
				<div class="s_top_title_type">${currSvorg.sclassstr}</div>
				<div class="s_top_title_icon"></div>
			</div>
		</div>
		<div class="w1000 s_main">
			<div class="s_main_left">
				<div class="sml_header">
					<div class="smlh_title">机构简介</div>
					<div class="smlh_info">Introduce</div>
					<div class="smlh_slash">/</div>
				</div>
				<div class="sml_content">
					${currSvorg.content}
				</div>
				<div class="sml_header">
					<div class="smlh_title">服务项目</div>
					<div class="smlh_info">Project</div>
					<div class="smlh_slash">/</div>
				</div>
				<div class="sml_content">
					<@sme_sitem_page svgid="${currSvorg.id}" page="1" num="5" pagenum="${pagenum!0}"; sitemList,pager>
					<#list sitemList as sitem>
					<div>
						<div class="smlc_prdt_img">
							<div class="img_p">
								<p class="img-box">
									<a href="${sitem.url}">
									<img alt="${sitem.title}" src="${sitem.img}"
										onerror="this.onerror=null;this.src='/resources/site/images/no.png'"></a>
								</p>
							</div>
						</div>
						<ul class="smlc_prdt_info">
							<li class="smlcp_title">
							<a href="${sitem.url}">${sitem.title}</a></li>
							<li class="smlcp_cont"><dl>
									<dt>服务区域：</dt>
									<dd>
										<#if sitem.arealist ??>
										<#list sitem.arealist as area>
											${area} 
										</#list>
										<#else>	
											玉门市
										</#if>
									</dd>
								</dl></li>
							<li class="smlcp_cont"><dl>
									<dt>收费标准：</dt>
									<dd>${sitem.price} ${sitem.spaystr} ${sitem.otherpay}</dd>
								</dl></li>
						</ul>
					</div>
					</#list>
					<div id="dvPage">
						${pager.ajaxPageStr}
					</div>
					</@sme_sitem_page>
				</div>
				<div class="sml_header">
					<div class="smlh_title">荣誉资质</div>
					<div class="smlh_info">Honor</div>
					<div class="smlh_slash">/</div>
				</div>
				<div class="sml_content">
					<ul class="smlc_honor">
						<li>
							<div class="img_p">
								<p class="img-box">
									<a href="./机构详情_files/201405191518495874805.jpg"
										target="_blank"> <img alt=""
										src="./机构详情_files/201405191518495874805.jpg"></a>
								</p>
							</div>
							<center></center>
						</li>
						
						
						<li>
							<div class="img_p">
								<p class="img-box">
									<a href="./机构详情_files/201507241139207474463.jpg"
										target="_blank"> <img alt=""
										src="./机构详情_files/201507241139207474463.jpg"></a>
								</p>
							</div>
							<center></center>
						</li>
					</ul>
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
						<dd>企业</dd>
					</dl>
					<dl>
						<dt>所属行业：</dt>
						<dd>其他科技推广和应用服务业</dd>
					</dl>
					<dl>
						<dt>所在地址：</dt>
						<dd>${currSvorg.address}</dd>
					</dl>
					<dl>
						<dt>公司网址：</dt>
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
			</div>
		</div>
	</div>

	<div class="clear"></div>
	