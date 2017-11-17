<div class="clear"></div>
	<div class="main_w">
		<div class="w1000">
			<div class="busy-main h330" style="  background: #FFF;min-height: 500px;  margin-top: 20px;">
				<div class="busy-header-tab">
					<div class="tab_item curr_item" target="tab_1">在线咨询</div>
				</div>
				<div id="tab_1" class="busy-title-tab" style="display:block">
					<form id="zxzxForm" method="post" >
							<table  width="100%" border="0" cellspacing3="0" cellpadding="0">
								<tr>
									<td class="zxzx_td_title">
										<span style="padding-left: 13px;"><a style="color: red;">*</a></span>咨询部门：
									</td> 
									<td>
										<select id="svgid" name="svgid" class="zxzx_input">
										<@sme_svorg_list svgtype="G" num="50";svorg,index>
										<option value="${svorg.id}">${svorg.title}</option>
										</@sme_svorg_list>
										</select>
									</td>
								</tr>
								<tr>
									<td class="zxzx_td_title">
										<span style="padding-left: 13px;"><a style="color: red;">*</a></span>咨询事项：
									</td>
									<td> 
										<select id="scode" name="scode" class="zxzx_input">
											<@sme_sclass_list type="G";sclass,index>
											<option value="${sclass.id}">${sclass.title}</option>
											</@sme_sclass_list>
										</select>
									</td>
								</tr>
								<tr>
									<td class="zxzx_td_title">
										<span style="padding-left: 13px;"><a style="color: red;">*</a></span>主题：
									</td>
									<td>  
										<input id="title" name="title" type="text" size="35" autocomplete="off" class="zxzx_input">
									</td>
								</tr>
								<tr>
									<td class="zxzx_td_title">
										<span style="padding-left: 13px;"><a style="color: red;">*</a></span>内容：
									</td> 
									<td>  
									<textarea name="content" id="content" cols="50" rows="6" wrap="virtual" class="zxzx_textarea"></textarea>
									</td>
								</tr>
								<tr>
									<td class="zxzx_td_title">
										<span style="padding-left: 13px;"><a style="color: red;">*</a></span>联系人：
									</td>
									<td>  
										<input id="linker" name="linker" type="text" size="35" autocomplete="off" class="zxzx_input">
									</td>
								</tr>
								<tr>
									<td class="zxzx_td_title">
										<span style="padding-left: 13px;"><a style="color: red;">*</a></span>联系电话：
									</td>
									<td>  
										<input id="linktel" name="linktel" type="text" size="35" autocomplete="off" class="zxzx_input">
									</td>
								</tr>
								<tr class="validateCode" style="display:none">
										<td>
						                  		<h2><a style="color: red;">*</a>验证码：</h2>
						                  		<input type="text" id="validateCode" name="validateCode" size="35">
						                </td>
						                <td class="validateCode" style="margin-top:0px;display:none">
						                  		<h2></h2>
						                  		<img title="点击图片更换验证码" id="verifyCode" src="/verifyCode" style="width:80px; height:22px;vertical-align:text-top;cursor: pointer;margin-left:6px;" onclick="changeVerify();">
												<span style="color: #999; font-style: oblique;margin-top:7px;">[<a style="color: #9999;" href="javascript:changeVerify()">看不清，换一张 </a>]</span>
						                </td>
								</tr>
							</table>
					</form>
					<div class="busy-content-tab" >
						<a id="Consult_Add" class="submit fl">提&nbsp;&nbsp;交</a> <a id="reset" class="reset">重&nbsp;&nbsp;置</a>
					</div>
				</div>
				
			</div>
		</div>
	</div>	
	<div class="clear"></div>