	<style>
	.tab_item{
		background-color: #F4F4F4;
		float: left;
		font-size: 17px;
		height: 40px;
		line-height: 40px;
		color: #FFFFFF;
		text-align: center;
  		width: 170px;
	}
	
	.curr_item{
		background-color: #2AA3DB;
	}
	
	.pg_ul{
		height:50px;
		line-height:50px;
	}
	
	.pg_ul li{
		float:left;
		padding: 0px 10px;
		width: 200px;
		font-size: 14px;
		text-align: center;
	}
	</style>
	
	<div class="clear"></div>
	<div class="main_w">
		<div class="w1000">
			<div class="busy-main h330" style="  background: #FFF;min-height: 500px;">
				<div class="busy-header-tab">
					<div class="tab_item curr_item" target="tab_1">我要查询</div>
					<div class="tab_item" target="tab_2">办理进度</div>
				</div>
				<div id="tab_1" class="busy-title-tab" style="display:block">
					<h1 id="tip">请输入申请人和申办流水号，查询办件信息：</h1>
					<form id="busyQueryForm" method="post" >
						<div class="busy-content-tab">
							<ul id="list">
								<li>
									<h2>
										<a style="color: red;">*</a>申请人或单位：
									</h2> <input id="SQR" name="SQR" type="text" size="35" autocomplete="off">
								</li>
								<li>
									<h2>
										<span style="padding-left: 13px;"><a style="color: red;">*</a></span>申办流水号：
									</h2> <input id="SBLSH" name="SBLSH" type="text" size="35" autocomplete="off">
								</li>
								<li class="validateCode" style="display:none">
						                  		<h2><a style="color: red;">*</a>验证码：</h2>
						                  		<input type="text" id="validateCode" name="validateCode" size="35">
						                  </li>
						                  <li class="validateCode" style="margin-top:0px;display:none">
						                  		<h2></h2>
						                  		<img title="点击图片更换验证码" id="verifyCode" src="./进度查询- 深圳市网上办事大厅_files/verifyCode" style="width:80px; height:22px;vertical-align:text-top;cursor: pointer;margin-left:6px;" onclick="changeVerify();">
									<span style="color: #999; font-style: oblique;margin-top:7px;">[<a style="color: #9999;" href="javascript:changeVerify()">看不清，换一张 </a>]</span>
						                  </li>
							</ul>
						</div>
					</form>
					<div class="busy-content-tab" >
						<a id="submit" class="submit fl">提&nbsp;&nbsp;交</a> <a id="reset" class="reset">重&nbsp;&nbsp;置</a>
					</div>
				</div>
				<div id="tab_2" class="busy-title-tab" style="display:none;">
					<ul class="pg_ul">
						<li>注册企业</li>
						<li>提交时间</li>
						<li>主办单位</li>
						<li>申请状态</li>
					</ul>
					<@sme_appealitem_list;appealitem>
					<ul class="pg_ul">
						<li>${appealitem.corptitle}</li>
						<li>${appealitem.addtimestr}</li>
						<li>${appealitem.svgtitle}</li>
						<li>
							<#if appealitem.status=="0">
								已提交，等待受理
							</#if>
							<#if appealitem.status=="1">
								已办理
							</#if>
							<#if appealitem.status=="2">
								已受理
							</#if>
						</li>
					</ul>
					</@sme_appealitem_list>
				</div>
			</div>
		</div>
	</div>	
	<div class="clear"></div>