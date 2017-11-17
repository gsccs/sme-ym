<div >
		<ul class="rgm_guide">
			<li class="rgmg_title">请选择要注册的帐号类型</li>
			<li class="rgmg_cont">
				<input type="radio" name="SvcGuide" id="rblCorp" checked="checked" value="C" />
				<label for="rblGovmt">企业帐号注册</label>
			</li>
			<li class="rgmg_cont">
				<input type="radio" name="SvcGuide" id="rblGovmt" value="G" />
				<label for="rblGovmt">政府服务注册</label>
			</li>
			<li class="rgmg_cont">
				<input type="radio" name="SvcGuide" id="rblSocial" value="S" />
				<label for="rblSocial">社会服务注册</label>
			</li>
			<!--
			<li class="rgmg_cont">
				<input type="radio" name="SvcGuide" id="rblExpert" value="E" />
				<label for="rblExpert">专家注册</label>
			</li>
			-->
		</ul>
		<div class="rgm_main">
			<div class="rgm_cont">
				<form  id="regform" method="post">
					<input type='hidden' id="REG_TYPE" name="usertype" value="C" />
					<ul class="rgm_form">
						<li class="rgmc_msg" id="Msg" rel="reg"></li>
						<li class="rgmc_user"></li>
						<li class="rgmc_word">登录帐号：</li>
						<li><input type="text" name="account" id="account"
							placeholder="请输入您的登录帐号" required="required" maxlength="100"
							pattern="^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]{2,4}$"
							autofocus="autofocus" data-msg-name="登录帐号"></li>
						<li class="rgmc_pwd"></li>
						<li class="rgmc_word">帐户密码：</li>
						<li><input type="password" id="txtPwd"
							placeholder="请输入您的帐户密码" minlength="6" maxlength="50"
							required="required" data-msg-name="帐户密码" />
						</li>
						<li class="rgmc_cpwd"></li>
						<li class="rgmc_word">确认密码：</li>
						<li><input type="password" id="txtConfirmPwd" name="Pwd"
							placeholder="请再次输入您的帐户密码" minlength="6" maxlength="50"
							required="required" data-msg-name="帐户密码" />
						</li>
						<li class="rgmc_word">邮箱地址：</li>
						<li><input type="text" name="email" id="email"
							placeholder="请输入您的电子邮箱" required="required" maxlength="100"
							pattern="^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,4}$"
							autofocus="autofocus" data-msg-name="电子邮箱"></li>
						<li class="rgmc_pwd"></li>
						
						<li class="rgmc_word rgm_li rgm_li_C">企业名称：</li>
						<li class="rgm_li rgm_li_C">
							<input type="text" id="orgname_C" name="orgname" placeholder="请输入您的企业名称"
							required="required" maxlength="100" autofocus="autofocus"
							data-msg-name="企业名称"></li>
						<li class="rgmc_word rgm_li rgm_li_S"  style="display:none">机构名称：</li>
						<li class="rgm_li rgm_li_S" style="display:none">
							<input type="text" id="orgname_S" name="orgname" placeholder="请输入您的单位名称"
							required="required" maxlength="100" autofocus="autofocus"
							data-msg-name="机构名称"></li>
						<li class="rgmc_word rgm_li rgm_li_G"  style="display:none">机构名称：</li>
						<li class="rgm_li rgm_li_G" style="display:none">
							<select id="orgid" name="orgid" >
								<option value="" > ---请选择---</option>
								<@sme_svorg_list svgtype='G' num="100"; svorg,index>
								<option value="${svorg.id}" > ${svorg.title}</option>
								</@sme_svorg_list>
							</select>
						</li>
							
						<li class="rgmc_word">联系人：</li>
						<li><input type="text" name="linker" id="linker" placeholder="请输入您的联系人"
							required="required" maxlength="100" autofocus="autofocus"
							data-msg-name="联系人"></li>
						<li class="rgmc_word">电话：</li>
						<li><input type="text" name="linktel" id="linktel" placeholder="请输入您的电话"
							required="required" maxlength="100" autofocus="autofocus"
							data-msg-name="电话"></li>
						<li class="rgmc_word">所在地区：</li>
						<li><select id="selProvince" style="width: 80px;">
							<option value="62">甘肃省</option>
							</select> 省 
							<select id="selCity" onchange="LoadArea()" style="width: 100px;">
								<option value="6209">玉门市</option>
							</select> 市 
							<select id="selArea" name="selArea" onchange="LoadAddr()" style="width: 100px;">
										
							</select>
						</li>
					</ul>
					<div class="rgm_submit">
						<input type="button" id="regBtn" value="立即注册" /> 
						<span>已注册 现在就去 <a href="http://account.smeym.org/">登录</a> </span> 
					</div>
				</form>
				<div id="regresult" style='display:none'>
					<span>注册成功！现在就去 <a href="http://account.smeym.org/">登录</a> </span> 
				</div>
				<div class="rgmm_foot"></div>
			</div>
			
			<div class="essc_left">
		        <div class="essc_top">
		        </div>
		        <dl>
		            <dt><span></span>帐号注册</dt>
		            
		            <dd class="rgm_intro rgm_intro_C" >
						本平台所指“注册企业”，是指由社会机构（企事业单位）提供的为中小企业解决各种个性需求的服务资源。例如法律咨询、融资担保、创业辅导、管理咨询、IT服务等服务资源。
					</dd>
					<dd class="rgm_intro rgm_intro_G" style="display: none;">
						本平台所指“政府服务机构”，是指由社会机构（企事业单位）提供的为中小企业解决各种个性需求的服务资源。例如法律咨询、融资担保、创业辅导、管理咨询、IT服务等服务资源。
					</dd>
					<dd class="rgm_intro rgm_intro_S" style="display: none;">
						本平台所指“社会服务机构”，是指由社会机构（企事业单位）提供的为中小企业解决各种个性需求的服务资源。例如法律咨询、融资担保、创业辅导、管理咨询、IT服务等服务资源。
					</dd>
					<dd class="rgm_intro rgm_intro_E" style="display: none;">
						本平台所指“服务专家”，是指由社会机构（企事业单位）提供的为中小企业解决各种个性需求的服务资源。例如法律咨询、融资担保、创业辅导、管理咨询、IT服务等服务资源。
					</dd>
		        </dl>
		        <div class="essc_foot">
		        </div>
		    </div>
			
		</div>

		<div class="clear"></div>
	</div>