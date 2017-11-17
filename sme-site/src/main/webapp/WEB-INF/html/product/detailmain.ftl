
	<div class="clear"></div>
	<div class="main_w" style="position: relative;">
		<div class="w1000 item_top">
			<div class="it_img">
				<div class="img_p">
					<p class="img-box">
						<img src="${currProduct.img}"
							alt="${currProduct.title}"
							onerror="this.onerror=null;this.src='/resources/site/images/no.png'">
					</p>
				</div>
			</div>
			<div class="it_info">
				<div class="iti_title">${currProduct.title}</div>
				<dl>
					<dt>
						<span>价</span>格：
					</dt>
					<dd class="price">￥${currProduct.price} 元</dd>
				</dl>
				<dl>
					<dt>
						<span>库</span>存：
					</dt>
					<dd>
						<span>${currProduct.storenum} 件</span>
					</dd>
				</dl>
				<dl>
					<dt>生产企业：</dt>
					<dd>
						<a href="${corp.url}" target="_blank">${corp.title}</a>
					</dd>
				</dl>
				
				<dl>
					<dt>产品类别：</dt>
					<dd>${currProduct.catetitle}</dd>
				</dl>
				<dl>
					<dt>
						<em>好</em><em>评</em>率：
					</dt>
					<dd class="iti_eval">
						<i class="iconfont hover" title="好评率"></i>
						<i class="iconfont hover" title="好评率"></i>
						<i class="iconfont hover" title="好评率"></i>
						<i class="iconfont hover" title="好评率"></i>
						<i class="iconfont hover" title="好评率"></i>
					</dd>
				</dl>
				<dl class="iti_btn">
					<!--
					<dt id="btnOrderCorp">在线下单</dt>
					<dd id="bntContact">立刻咨询</dd>
					-->
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
							谢*** <span>(请<a onclick="RedirectLogin()"
								style="cursor: pointer; color: Blue;">登录</a>后查看)
							</span>
						</dd>
					</dl>
					<dl>
						<dt>
							<span>电</span>话：
						</dt>
						<dd>189***7</dd>
					</dl>
					<dl>
						<dt>
							<span>传</span>真：
						</dt>
						<dd>847***0</dd>
					</dl>
					<dl>
						<dt>
							<span>邮</span>箱：
						</dt>
						<dd>${corp.email}</dd>
					</dl>
				</div>
				<div class="iml_adv">
					<img alt="服务项目" src="/resources/site/images/adv.jpg">
				</div>
				<div class="iml_main">
					<div class="imlm_title">企业信息</div>
					<dl>
						<dt>企业名称：</dt>
						<dd>
							<a href="${corp.url}" target="_blank">${corp.title}</a>
						</dd>
					</dl>
					<dl>
						<dt>企业性质：</dt>
						<dd>企业</dd>
					</dl>
					<dl>
						<dt>所属行业：</dt>
						<dd>信息系统集成服务</dd>
					</dl>
					<dl>
						<dt>所在地址：</dt>
						<dd>${corp.areastr}</dd>
					</dl>
					<dl>
						<dt>公司网址：</dt>
						<dd>${corp.domain}</dd>
					</dl>
				</div>
			</div>
			<div class="im_right">
				<ul class="imr_title" id="ulNav">
					<li class="hover"><a href="javascript:void(0)">产品详情</a></li>
					<li><a href="javascript:void(0)">订单记录</a></li>
					<li><a href="javascript:void(0)">产品评价</a></li>
				</ul>
				<dl class="imr_info">
					<dt>生产企业：</dt>
					<dd>
						<a href="${corp.url}" target="_blank">${corp.title}</a>
					</dd>
					<dt>产品名称：</dt>
					<dd>${currProduct.title}</dd>
					<dt>产品价格：</dt>
					<dd>￥${currProduct.price} &nbsp;</dd>
					<dt>产品类别：</dt>
					<dd>${currProduct.sclassstr}</dd>
					<dt>发布日期：</dt>
					<dd>${currProduct.addtimeStr}</dd>
					<dt>产品销量：</dt>
					<dd>${currProduct.salenum}件</dd>
				</dl>
				<div class="imr_content content" id="dvContent">
					<div class="imrc_title">产品介绍</div>
					${currProduct.content}
				</div>
				<div class="content" id="dvRecord">
					<ul id="ulOrderList">
						
					</ul>
					<div id="dvPageOrder">
						<div class="maunlist">
							<div class="manur">共 4 条</div>
							<div class="manuleft">
								<a href="javascript:void(0)" onclick="PaginationOrder(1)"
									class="hover">1</a>
							</div>
						</div>
					</div>
				</div>
				<div class="content" id="dvEvaluation">
					<div id="dvCommentList"></div>
					<div id="dvPageComment">
						<div class="maunlist">
							<div class="manur">共 0 条</div>
							<div class="manuleft">
								<a href="javascript:void(0)" onclick="PaginationComment(1)"
									class="hover">1</a>
							</div>
						</div>
					</div>
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
	