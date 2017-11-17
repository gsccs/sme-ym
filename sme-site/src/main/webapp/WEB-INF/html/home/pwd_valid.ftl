<div class="clear"></div>
	<div class="main_w">
		<div class="w1000">
			<div class="busy-main h330" style="  background: #FFF;min-height: 500px;  margin-top: 20px;">
				<div class="busy-header-tab">
					<div class="tab_item curr_item" target="tab_1">密码找回</div>
				</div>
				<div id="tab_form" class="busy-title-tab" style="display:block">
					<form id="pwd_form" method="post" style="width: 500px;margin: 0 auto;margin-top: 50px;">
							<table  width="100%" border="0" cellspacing3="0" cellpadding="0">
								<tr>
									<td class="zxzx_td_title" >
										<span style="padding-left: 13px;"></span>登录帐号：
									</td>
									<td>${account}
									<input id="account" name="account" type="hidden" size="35"  value="${account}">
									</td>
								</tr>
								
								<tr>
									<td class="zxzx_td_title" >
										<span style="padding-left: 13px;"><a style="color: red;">*</a></span>新密码：
									</td>
									<td>  
										<input id="pwd" name="pwd" type="password" size="35" autocomplete="off" class="zxzx_input" >
									</td>
								</tr>
								
								<tr>
									<td class="zxzx_td_title">
										<span style="padding-left: 13px;"><a style="color: red;">*</a></span>确认密码：
									</td>
									<td>  
										<input id="newpwd" name="newpwd" type="password" size="35" autocomplete="off" class="zxzx_input">
									</td>
								</tr>
							</table>
					</form>
					<div class="busy-content-tab" style="margin-top: 50px;">
						<a id="btn_pwd" class="submit fl">提&nbsp;&nbsp;交</a> <a id="reset" class="reset">重&nbsp;&nbsp;置</a>
					</div>
				</div>
				
				<div id="tab_info" class="busy-title-tab" style="display:none">
					<div style="width: 400px;height:300px;margin: 0 auto;margin-top: 50px;line-height:100px;">
						你的密码已修改成功，请【<a href="http://account.smeym.org/logout">&nbsp;重新登录&nbsp;</a>】
					</div>
				</div>
				
			</div>
		</div>
	</div>	
	<div class="clear"></div>