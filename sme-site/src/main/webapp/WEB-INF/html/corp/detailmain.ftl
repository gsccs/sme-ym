
	<div class="clear"></div>

	<div class="main_w">
		<div class="w1000 s_top">
			<div class="s_top_logo">
				<div class="img_p">
					<p class="img-box">
						<img src="${currCorp.logo}"
							alt="${currCorp.title}"
							onerror="this.onerror=null;this.src='/resources/site/images/no.png'">
					</p>
				</div>
			</div>
			<div class="s_top_title">
				<div class="s_top_title_name">${currCorp.title}</div>
				<div class="s_top_title_type">${currCorp.sclassstr}</div>
				<div class="s_top_title_icon"></div>
			</div>
		</div>
		<div class="w1000 s_main">
			<div class="s_main_left">
				<div class="sml_header">
					<div class="smlh_title">企业简介</div>
					<div class="smlh_info">Introduce</div>
					<div class="smlh_slash">/</div>
				</div>
				<div class="sml_content">
					${currCorp.content}
				</div>
				<div class="sml_header">
					<div class="smlh_title">特色产品</div>
					<div class="smlh_info">Product</div>
					<div class="smlh_slash">/</div>
				</div>
				<div class="sml_content">
					<@sme_product_page corpid="${currCorp.id}" page="1" num="5" pagenum="${pagenum!0}"; productList,pager>
					<div id="dvPrdt">
						<#list productList as product>
						<div class="smlc_prdt_img">
							<div class="img_p">
								<p class="img-box">
									<a href="${product.url}">
									<img alt="${product.title}" src="${product.img}"
										onerror="this.onerror=null;this.src='/resources/site/images/no.png'"></a>
								</p>
							</div>
						</div>
						<ul class="smlc_prdt_info">
							<li class="smlcp_title"><a href="${product.url}">${product.title}</a></li>
							<li class="smlcp_cont">
								<dl>
									<dt>产品价格：</dt>
									<dd>${product.price} 元</dd>
								</dl>
							</li>
						</ul>
						</#list>
						
					</div>
					<div id="dvPage">
						${pager.ajaxPageStr}
					</div>
					</@sme_product_page>
				</div>
				<div class="sml_header">
					<div class="smlh_title">企业风采</div>
					<div class="smlh_info">Presence</div>
					<div class="smlh_slash">/</div>
				</div>
				<div class="sml_content">
					<ul class="smlc_honor">
						<li>
							<div class="img_p">
								<p class="img-box">
									<a href="./企业详情_files/201405191518495874805.jpg"
										target="_blank"> <img alt=""
										src="./企业详情_files/201405191518495874805.jpg"></a>
								</p>
							</div>
							<center></center>
						</li>
						
						
						<li>
							<div class="img_p">
								<p class="img-box">
									<a href="./企业详情_files/201507241139207474463.jpg"
										target="_blank"> <img alt=""
										src="./企业详情_files/201507241139207474463.jpg"></a>
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
						<div class="smrit_main">企业信息</div>
						<div class="smrit_right">&nbsp;</div>
					</div>
					<dl>
						<dt>企业名称：</dt>
						<dd>${currCorp.title}</dd>
					</dl>
					<dl>
						<dt>企业性质：</dt>
						<dd>企业</dd>
					</dl>
					<dl>
						<dt>所属行业：</dt>
						<dd>其他科技推广和应用服务业</dd>
					</dl>
					<dl>
						<dt>所在地址：</dt>
						<dd>${currCorp.address}</dd>
					</dl>
					<dl>
						<dt>公司网址：</dt>
						<dd>
							<a href="${currCorp.domain}" target="_blank">${currCorp.domain}</a>
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
						<dd>${currCorp.linker}</dd>
					</dl>
					<dl>
						<dt>
							<span>电</span>话：
						</dt>
						<dd>${currCorp.phone}</dd>
					</dl>
					<dl>
						<dt>
							<span>传</span>真：
						</dt>
						<dd>${currCorp.linktel}</dd>
					</dl>
					<dl>
						<dt>
							<span>邮</span>箱：
						</dt>
						<dd>${currCorp.email}</dd>
					</dl>
					<dl>
						<dt>&nbsp;</dt>
						<dd>
							<a target="_blank"
								href="http://wpa.qq.com/msgrd?v=3&uin=${currCorp.qq}&site=qq&menu=yes">
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
	