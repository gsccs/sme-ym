<style>
#filelist li{
	width:700px;
}

.txtEvaluation{
	width: 733px;
  	height: 100px;
  	border: 1px solid #d0d0d0;
  	background: #f9fbfc;
}
</style>
<div class="clear"></div>
<div class="main_w">
	<div class="w1000">
		<div class="acti_detail">
			<div class="title">${currDeclareTopic.title}</div>
			<div class="top">
				<dl>
					<dt>申报单位：</dt>
					<dd>${currDeclareTopic.svgtitle}</dd>
				</dl>
				<dl>
					<dt>申报时间：</dt>
					<dd>${currDeclareTopic.starttimestr} ~ ${currDeclareTopic.endtimestr}</dd>
				</dl>
				<dl>
					<dt>
						<span style="letter-spacing: .5em;">联</span><span style="letter-spacing: .5em;">系</span>人：
					</dt>
					<dd>${currDeclareTopic.linker}</dd>
				</dl>
				<dl>
					<dt>联系电话：</dt>
					<dd>${currDeclareTopic.linktel}
						<!--
						<span>(请<a onclick="RedirectLogin()"
							style="cursor: pointer; color: Blue;">登录</a>后查看)
						</span>
						-->
					</dd>
				</dl>
				
				<!--<div class="qrcodetxt">手机扫码报名↑</div>
				<div class="signup" id="dvSignup" style="top:50px"></div>
				-->
			</div>
			
			<div class="content">
				<div class="title">申报内容</div>
				${currDeclareTopic.content}
			</div>
			
			<div class="evaluation" id="dvEvaluation" style="display: ;">
				<div class="title_x">申报内容</div>
				<input type="hidden" id="topicid" value="${currDeclareTopic.id}">
				<input type="hidden" id="svgid" value="${currDeclareTopic.svgid}">
				<textarea class="txtEvaluation" id="content" name="content"></textarea>
				
				<div class="attach" style="margin-top: 10px;">
					<ul id="filelist"> </ul>
					<input type="file" value="上传资料" name="uploadify" id="uploadify" width="78" style="display: none;" height="23">
				</div>
				
				<div style='width:100px; margin:20px auto;'><input id="dvSubmit" type='button' value='提 交' /></div>
			</div>
		</div>
		<div class="acti_right">
			<div class="box">
				<div class="title">
					<span></span>热门活动
				</div>
				<div class="content">
					<ul class="main">
						<@sme_activity_list num="10" titlelen="15";act,index>
						<li><a href="${act.url}" target="_blank" title="${act.title}">${act.showtitle}…</a></li>
						</@sme_activity_list>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
	
<div class="clear"></div>