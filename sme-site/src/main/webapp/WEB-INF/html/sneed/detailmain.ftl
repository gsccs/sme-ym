<style>
.mar_top {
  margin-top: 30px;
}
</style>
	<div class="clear"></div>
	<div class="main_w">
		<div class="w1000">
			<div class="main_l fl" style="padding-top: 0px;">

				<div class="s_top" style="margin-top: 1px;"></div>
				<div class="s_main">
					<div class="r_title">
						<span class="title_ico">基本详情</span>
					</div>
					<div class="need">
						<div class="Info">
							<div class="fl">
								<div class="img_p">
									<p class="img-box">
										<a href="${corp.url}"> 
										<img alt="${corp.title}" src="${corp.logo}"
											onerror="this.onerror=null;this.src='/resources/site/images/no.png'"></a>
									</p>
								</div>
								<p class="pname">
									<a href="${corp.url}">${corp.title}</a>
								</p>
							</div>
							<div class="infoview fl">
								<dl>
									<dd>
										<span class="s_name">需求名称：</span>
										<a href="${currSneed.url}">${currSneed.title}</a>
										<div class="clear"></div>
									</dd>
									<dd>
										<span class="s_name">联&nbsp;&nbsp;系&nbsp;&nbsp;人：</span>
										<span class="s_con">${currSneed.linker}</span>
									    <span class="s_d_name">联系电话：</span>${currSneed.linktel}
										<div class="clear"></div>
									</dd>
									<dd>
										<span class="s_name">需求分类：</span><span class="s_con"> </span>
										<span class="s_d_name">发布日期：</span>${currSneed.addtimestr}
										<div class="clear"></div>
									</dd>
									<dd>
										<span class="s_name">所&nbsp;&nbsp;在&nbsp;&nbsp;地：</span><span
											class="s_con">甘肃省|玉门市</span><span class="s_d_name">倒&nbsp;&nbsp;计&nbsp;&nbsp;时：</span>5天8小时20分
										<div class="clear"></div>
									</dd>
								</dl>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="mar_top"></div>
					<div class="r_title">
						<span class="title_ico">具体要求</span>
					</div>
					<div class="need_content">
						${currSneed.content}
						<p>
							<br>
						</p>
					</div>
					<div class="r_title mar_top">
						<span class="title_ico2">成功对接日志</span>
					</div>
					<div class="need_content">暂无资料</div>
					<div class="send_bnt">我要竞标</div>
				</div>
				<div class="s_bottom">
					<input type="hidden" id="DemandID" value="${currSneed.id}">
				</div>
			</div>
			<div class="main_r fr">

				<div class="r_title">推荐机构</div>
				<@sme_svorg_list top="1" num="4";svorg,index>
				<div class="rt_img">
					<div class="img_p">
						<p class="img-box">
							<a href="${svorg.url}" target="_blank"> 
							<img alt="${svorg.title}" src="${svorg.logo}"></a>
						</p>
					</div>
				</div>
				<dl>
					<dt class="rt_title">
						<a href="${svorg.url}" target="_blank" title="${svorg.title}">${svorg.title}…</a>
					</dt>
					<dd>
						<span class="d_title">所属行业：</span>${svorg.sclassstr}
					</dd>
					<dd>
						<span class="d_title">服务项目数：</span>
						<a href="${svorg.url}" target="_blank">${svorg.salenum}</a>
					</dd>
				</dl>
				</@sme_svorg_list>
				
			</div>
		</div>
	</div>

	<div class="clear"></div>
	