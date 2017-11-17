
	<div class="clear"></div>
	<div class="main_w">
		<div class="w1000">
			<div class="main_l fl" style="padding-top: 0px;">

				<div class="s_top" style="margin-top: 1px;"></div>
				<div class="s_main">
					<div class="r_title">
						<span class="title_ico">服务事项</span>
					</div>
					<div class="need">
						<div class="Info">
							<div class="fl">
								<div class="img_p">
									<p class="img-box">
										<a href="${currAppealTopic.url}"> 
										<img alt="${currAppealTopic.svgtitle}" src="${currAppealTopic.svglogo}"
											onerror="this.onerror=null;this.src='/resources/site/images/no.png'"></a>
									</p>
								</div>
								<p class="pname">
									<a href="${currAppealTopic.url}">${currAppealTopic.svgtitle}</a>
								</p>
							</div>
							<div class="infoview fl">
								<dl>
									<dd>
										<span class="s_name">服务事项：</span>
										<a href="${currAppealTopic.url}">${currAppealTopic.title}</a>
										<div class="clear"></div>
									</dd>
									<dd>
										<span class="s_name">联&nbsp;&nbsp;系&nbsp;&nbsp;人：</span>
										<span class="s_con">${currAppealTopic.linker!'-'}</span>
										<div class="clear"></div>
									</dd>
									<dd>
									    <span class="s_name">联系电话：</span>
									    <span class="s_con">${currAppealTopic.linktel!'-'}</span>
									    <div class="clear"></div>
									</dd>
									<dd>
										<span class="s_name">所&nbsp;&nbsp;在&nbsp;&nbsp;地：</span>
										<span class="s_con">甘肃省|玉门市</span>
										<div class="clear"></div>
									</dd>
								</dl>
							</div>
							<div class="sr-btn-box fr" >
								<@shiro.user> 
								<a href="javacript:void(0)" onclick="javascript:document.getElementById('appealitem').scrollIntoView()" >在线办理</a>
								</@shiro.user> 
								<@shiro.guest> 
								<a href="/home.html" >在线办理</a>
								</@shiro.guest> 
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="need_content">
						<dl>
							<dt class="sub-r-wrap"><h3>办理对象<h3></dt>
							<dd>${currAppealTopic.starobj}<dd>
						</dl>
						<dl>
							<dt class="sub-r-wrap"><h3>办理条件<h3></dt>
							<dd>${currAppealTopic.scondit}<dd>
						</dl>
						<dl>
							<dt class="sub-r-wrap"><h3>办事窗口<h3></dt>
							<dd>${currAppealTopic.swindow}<dd>
						</dl>
						<dl>
							<dt class="sub-r-wrap"><h3>办理流程<h3></dt>
							<dd>${currAppealTopic.workflow}<dd>
						</dl>
						<dl>
							<dt class="sub-r-wrap"><h3>附件列表<h3></dt>
							<#if currAppealTopic.attachs ??>
							<#list currAppealTopic.attachs as attach>
								<dd style='padding-left: 15px;'>${attach.filename}&nbsp;&nbsp;&nbsp;&nbsp;[<a href="${attach.filepath}" >下载</a>] </dd>
							</#list>
							<#else>
								无
							</#if>
						</dl>
					</div>
					<!---->
					<@shiro.user> 
					<div class="r_title mar_top">
						<span class="title_ico">提交资料</span>
					</div>
					<div class="need_content">
						<div id="server_msg" style="display:none"></div>
						<form id="appealitem" method="post">
							<input type="hidden" id="topicid" value="${currAppealTopic.id}">
							<input type="hidden" id="svgid" value="${currAppealTopic.svgid}">
							<div class="title_x">办理内容</div>
							<textarea id="content" style="width:785px;height:80px;" onpropertychange="if(value.length>100) value=value.substr(0,100)"></textarea>
							<div class="title_x" style="margin-top: 10px;">
								<input type="file" value="上传资料" name="uploadify" id="uploadify" width="78" style="display: none;" height="23">
							</div>
							<ul id="filelist">
								
							</ul>
						</form>
					</div>
					<div class="send_bnt" id="appeal_bnt">提交资料</div>
					</@shiro.user>
				</div>
				<div class="s_bottom">
					
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
