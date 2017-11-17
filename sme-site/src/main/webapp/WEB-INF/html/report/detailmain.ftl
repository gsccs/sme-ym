<style>
#filelist li{
	width:700px;
}

.txtEvaluation{
	width: 933px;
  	height: 100px;
  	border: 1px solid #d0d0d0;
  	background: #f9fbfc;
}
</style>
<div class="clear"></div>
<div class="main_w">
	<div class="w1000">
		<div class="acti_detail">
			<div class="title">${currReport.title}</div>
			<div class="top">
				<dl>
					<dt>报送单位：</dt>
					<dd>${currReport.svgtitle}</dd>
				</dl>
				<dl>
					<dt>时间要求：</dt>
					<dd>${currReport.starttimestr} ~ ${currReport.endtimestr}</dd>
				</dl>
				<dl>
					<dt>
						<span style="letter-spacing: .5em;">联</span><span style="letter-spacing: .5em;">系</span>人：
					</dt>
					<dd>${currReport.linker}</dd>
				</dl>
				<dl>
					<dt>联系电话：</dt>
					<dd>${currReport.linktel}
						<!--
						<span>(请<a onclick="RedirectLogin()" style="cursor: pointer; color: Blue;">登录</a>后查看)
						</span>
						-->
					</dd>
				</dl>
				
				<dl>
					<dt>附件模板：</dt>
					<#if currReport.attachs ??>
					<#list currReport.attachs as attach>
						<dd style='padding-left: 15px;'>${attach.filename}&nbsp;&nbsp;&nbsp;&nbsp;[<a href="${attach.filepath}" >下载</a>] </dd>
					</#list>
					<#else>
						无
					</#if>
				</dl>
			</div>
			
			<div class="content">
				<div class="title">报送要求</div>
				${currReport.content}
			</div>
			
			<!-- -->
			<@shiro.user> 
			<div class="evaluation" id="dvEvaluation" style="display: ;">
				<div class="title_x">备注信息</div>
				<input type="hidden" id="reportid" value="${currReport.id}">
				<input type="hidden" id="svgid" value="${currReport.svgid}">
				<textarea class="txtEvaluation" id="content" name="content"></textarea>
				
				<div class="attach" style="margin-top: 10px;">
					<ul id="filelist"> </ul>
					<input type="file" value="上传资料" name="uploadify" id="uploadify" width="78" style="display: none;" height="23">
				</div>
				
				<div style='width:100px; margin:20px auto;'><input id="dvSubmit" type='button' value='提 交' /></div>
			</div>
			</@shiro.user>
		</div>
		<div class="acti_right">
			<div class="box">
				<div class="title">
					<span></span>通知公告
				</div>
				<div class="content">
					<ul class="main">
						<@sme_info_list channelid="104" dateformat="yyyy-MM-dd HH:mm" titlelen="12";info,index>
						<li><a href="${info.url}"
							target="_blank" title="${info.title}">${info.showtitle}…</a></li>
						</@sme_info_list>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="clear"></div>