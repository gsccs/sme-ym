	<div class="clear"></div>
	<div class="main_w" style="position: relative;">
		<div class="w1000 item_top">
			<div class="it_img">
				<div class="img_p">
					<p class="img-box">
						<img src="${currSitem.logo}"
							alt="${currSitem.title}"
							onerror="this.onerror=null;this.src='/resources/site/images/no.png'">
					</p>
				</div>
			</div>
			<div class="it_info">
				<div class="iti_title">${currSitem.title}</div>
				<!--
				<dl>
					<dt>
						<span>价</span>格：
					</dt>
					<dd class="market_price">
						￥<span>${currSitem.price} ${currSitem.spaystr}</span>
					</dd>
				</dl>
				<dl>
					<dt>
						<em>公</em><em>益</em>价：
					</dt>
					<dd class="price">￥0.00 元/次</dd>
				</dl>
				-->
				<dl>
					<dt>服务机构：</dt>
					<dd>
						<a href="${svorg.url}" target="_blank">${svorg.title}</a>
					</dd>
				</dl>
				<dl>
					<dt>服务方式：</dt>
					<dd>
					<#if currSitem.spanlist ??>
					<#list currSitem.spanlist as span>
						${span}
					</#list>
					<#else>
						其他服务
					</#if>
					</dd>
				</dl>
				<dl>
					<dt>服务对象：</dt>
					<dd>
					<#if currSitem.sprolist ??>
					<#list currSitem.sprolist as spro>
						${spro}
					</#list>
					<#else>
						其他
					</#if>
					</dd>
				</dl>
				<dl>
					<dt>服务类别：</dt>
					<dd>${currSitem.sclassstr}</dd>
				</dl>
				<dl>
					<dt>
						<em>好</em><em>评</em>率：
					</dt>
					<dd class="iti_eval" style="padding-top: 15px;">
						<#if currSitem.evalnum??>
						<#assign x="${currSitem.evalnum}"?number>
						<#else>
						<#assign x=5>
						</#if>
						<#list 1..x as i>
						<em title="好评率"></em>
						</#list>					
					</dd>
				</dl>
				<dl class="iti_btn">
					<dt id="btnApplcSvc">立刻申请</dt>
				</dl>
			</div>
		</div>
		<div class="w1000 item_main">
			<div class="im_left">
				<div class="iml_main">
					<div class="imlm_title">联系我们</div>
					<dl>
						<dt>
							<em>联</em><em>系</em>人：
						</dt>
						<dd>
							${svorg.linker}<span></span>
						</dd>
					</dl>
					<dl>
						<dt>
							<span>电</span>话：
						</dt>
						<dd>${svorg.linktel}</dd>
					</dl>
					
					<dl>
						<dt>
							<span>邮</span>箱：
						</dt>
						<dd>${svorg.email}</dd>
					</dl>
				</div>
				<div class="iml_adv">
					<img alt="服务项目" src="/resources/site/images/adv.jpg">
				</div>
				<div class="iml_main">
					<div class="imlm_title">机构信息</div>
					<dl>
						<dt>机构名称：</dt>
						<dd>
							<a href="${svorg.url}" target="_blank">${svorg.title}</a>
						</dd>
					</dl>
					<dl>
						<dt>机构性质：</dt>
						<dd>企业</dd>
					</dl>
					<dl>
						<dt>所属行业：</dt>
						<dd>信息系统集成服务</dd>
					</dl>
					<dl>
						<dt>所在地址：</dt>
						<dd>${svorg.address}</dd>
					</dl>
					<dl>
						<dt>公司网址：</dt>
						<dd>${svorg.domain}</dd>
					</dl>
				</div>
			</div>
			<div class="im_right">
				<ul class="imr_title" id="ulNav">
					<li class="hover"><a href="javascript:void(0)">服务详情</a></li>
					<li><a href="javascript:void(0)">服务记录</a></li>
					<li><a href="javascript:void(0)">服务评价</a></li>
				</ul>
				<dl class="imr_info">
					<dt>机构名称：</dt>
					<dd>
						<a href="${svorg.url}" target="_blank">${svorg.title}</a>
					</dd>
					<dt>服务项目：</dt>
					<dd>${currSitem.title}</dd>
					<dt>收费标准：</dt>
					<dd>￥${currSitem.price} ${currSitem.spaystr} &nbsp; ${currSitem.otherspay}</dd>
					<dt>服务类别：</dt>
					<dd>${currSitem.sclassstr}</dd>
					<dt>服务范围：</dt>
					<dd>
					<#if currSitem.arealist ??>
					<#list currSitem.arealist as area>
						${area}
					</#list>
					<#else>
						玉门市
					</#if>
					</dd>
					<dt>发布日期：</dt>
					<dd>${currSitem.addtimeStr}</dd>
					<dt>服务次数：</dt>
					<dd>${currSitem.salenum}次</dd>
				</dl>
				<div class="imr_info content" id="dvContent" style="margin-top: 20px;">
					<div class="imrc_title">服务介绍</div>
					${currSitem.content}
				</div>
				<div class="imr_info content" id="dvRecord" style="margin-top: 20px;">
					<@sme_sorder_page sitemid="${currSitem.id}" ;sorderlist,pager>
					<ul id="ulOrderList">
						<#if sorderlist ??>
						<#list sorderlist as sorder>
						<li>${sorder.corptitle}   ${sorder.addtimestr}</li>
						</#list>
						<#else>
						<li>暂无服务记录</li>
						</#if>
					</ul>
					<div id="dvPageOrder">
						${pager.ajaxPageStr}
					</div>
					</@sme_sorder_page>
				</div>
				<div class="imr_info content" id="dvEvaluation" style="margin-top: 20px;">
					<@sme_sitemeval_page  ;sitemevallist,pager>
					<div id="dvCommentList">
						<ul>
						<#if sitemevallist ??>
							<#list sitemevallist as sitemeval>
							<li>${sitemeval.id} ${sitemeval.corptitle}</li>
							</#list>
						<#else>
							<li>暂无评价记录</li>	
						</#if>
						<#if sitemevallist?size<=0>
							<li>暂无评价记录</li>	
						</#if>
						</ul>
					</div>
					<div id="dvPageComment">
						${pager.ajaxPageStr}
					</div>
					</@sme_sitemeval_page>
				</div>
			</div>
		</div>
		<div class="iContact">
			<div class="dialog_title">
				<span class="closed"></span>
			</div>
			<div class="dialog_view">
				<div class="txt_view">
					<span class="title">标题</span><input type="text" class="txt1"
						id="QTitle">
				</div>
				<div class="txt_view">
					<span class="title fl">内容</span>
					<div class="fl">
						<textarea rows="6" id="QContent"></textarea>
					</div>
					<div class="clear"></div>
				</div>
				<div class="smb_bnt" id="Q_smb_bnt"></div>
			</div>
		</div>
	</div>

	<div class="clear"></div>
	