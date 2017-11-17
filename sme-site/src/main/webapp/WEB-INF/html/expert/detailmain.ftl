

	<div class="clear"></div>

	<div class="main_w">
		<div class="w1000">
			<div class="expert_main fl">
				<div class="e_view">
					<div class="r_title">
						<span class="title_ico">基本资料</span>
					</div>
					<div class="service_info">
						<div class="Info">
							<div class="fl">
								<div class="img_p">
									<p class="img-box">
										<img src="${currExpert.logo}"
											onerror="this.onerror=null;this.src='/resources/site/images/no.png'"
											alt="${currExpert.title}">
									</p>
								</div>
							</div>
							<div class="infoview fl">
								<dl>
									<dd>
										<span class="s_name"><span>姓</span>名：</span><span
											class="n_name">${currExpert.title}</span> <span class="s_d_name">年 龄：</span>${currExpert.age!"-"}岁
									</dd>
									<dd>
										<span class="s_name">技术职称：</span>${currExpert.technical}
									</dd>
									<dd>
										<span class="s_name">专业行业：</span>${currExpert.classid}
									</dd>
									<dd>
										<span class="s_name">专业年限：</span>${currExpert.proflife!'-'}年
									</dd>
									<dd>
										<span class="s_name">最高学历：</span><span class="n_name">${currExpert.degree}</span>
										<span class="s_d_name">职 务：</span>${currExpert.duties}
									</dd>
									<dd>
										<span class="s_name">工作单位：</span>${currExpert.degree}
									</dd>
									<dd>
										<span class="s_name">所在地区：</span>甘肃省玉门市
									</dd>
								</dl>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="r_title">
						<span class="title_ico">个人简历</span>
					</div>
					<div class="service_info s_content">
					</div>
					<div class="r_title">
						<span class="title_ico2">研究成果 / 荣誉 / 奖励</span>
					</div>
					<div class="service_info s_content">
						
					</div>
					<div class="r_title">
						<span class="title_ico">联系方式</span>
					</div>
					<div class="service_info s_content">
						<span class="contactus"><span class="c_title">办公电话：</span>${currExpert.telnum}</span>

						<span class="contactus"><span class="c_title">手 机：</span>${currExpert.phone}</span>
						<span class="contactus"><span class="c_title">电子邮箱：</span>${currExpert.email}</span>
						<div class="clear"></div>
					</div>
					<div class="r_title">
						<span class="title_ico">成功案例</span>
					</div>
					<div class="service_info s_content">
					${currExpert.sucase}
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="news_r">
				<div class="box">
					<div class="title">
						<span></span>热点新闻
					</div>
					<div class="content">
						<ul class="c_main">
							<@sme_info_list channelid="101" titlelen="15" dateformat="MM-dd" num="10";info,index>
							<li><a href="/info-${info.id}.html"
								target="_blank" title="${info.title}">${info.title}…</a></li>
							</@sme_info_list>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="clear"></div>
	