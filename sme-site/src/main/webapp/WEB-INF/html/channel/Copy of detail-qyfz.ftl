<style>
.style4 {
  font-size: 12px;
  color: #333333;
  line-height: 20px;
}

table {
  display: table;
  border-collapse: separate;
  border-spacing: 1px;
  border-color: gray;
}
</style>

<div class="clear"></div>
<div class="main_w">
	<div class="w1000">
		<div class="main_l fl">
			<div class="list_main">
				<div class="city-img" style="float:left">
						<img src="${base}/resources/site/images/ymqj.jpg" style="opacity: 1;height: 200px;width: 100%;">
				</div>
			</div>
				
			<div style="clear:both;"></div> 
			<div class="park_title"><h3 style="padding-left: 15px;">区域优势</h3></div>
				<table width="700" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#E1E1E1">
					<tr style="height: 40px;text-align: center;">
						<th bgcolor="#DEE8EB" class="style4" width="200px">区域名称</th>
						<th bgcolor="#DEE8EB" class="style4" width="100px">企业数量(家)</th>
						<th bgcolor="#DEE8EB" class="style4" >区域简介</th>
					</tr>
					<@sme_park_list;park,index>
					<tr>
						<td bgcolor="#FFFFFF" class="style4">${park.title}</td>
						<td bgcolor="#FFFFFF" align="center" class="style4">${park.corpnum}</td>
						<td bgcolor="#FFFFFF" class="style4">${park.remark}</td>
					</tr>
					</@sme_park_list>
				</table>
				
			<div style="clear:both;"></div> 
			<div class="park_title"><h3 style="padding-left: 15px;">工程项目</h3></div>
				<table width="700" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#E1E1E1">
					<tr style="height: 40px;text-align: center;">
						<th bgcolor="#DEE8EB" class="style4" width="200px">项目名称</th>
						<th bgcolor="#DEE8EB" class="style4" width="100px">项目投资(万元)</th>
						<th bgcolor="#DEE8EB" class="style4" width="200px">项目简介</th>
					</tr>
					
					<@sme_project_page;projectlist,pager>
					<#list projectlist as project>
					<tr>
						<td bgcolor="#FFFFFF" class="style4" >${project.title}</td>
						<td bgcolor="#FFFFFF" align="center" class="style4" >${project.invest}</td>
						<td bgcolor="#FFFFFF" class="style4" >${project.content}</td>
					</tr>
					</#list>
					</@sme_project_page>
				</table>
				<div style="clear:both;"></div> 
				<div class="park_title"><h3 style="padding-left: 15px;">投资环境</h3></div>
				<div></div>
				<div style="clear:both;"></div> 
				<div class="park_title"><h3 style="padding-left: 15px;">配套服务</h3></div>
				<div></div>
		</div>
		<div class="main_r fr">
			<div class="r_title">最新动态</div>
			<div class="news">
				<ul>
					<@sme_info_list channelid='101' num="5" titlelen="12";info,index>
						<li><a href="${info.url}" target="_blank">${info.showtitle}</a></li>
					</@sme_info_list>
				</ul>	
			</div>	
		</div>
		
		<div class="main_r fr">
			<div class="r_title">政策法规</div>
			<div class="news">
				<ul>
					<@sme_info_list channelid='105' num="5" titlelen="12";info,index>
						<li><a href="${info.url}" target="_blank">${info.showtitle}</a></li>
					</@sme_info_list>
				</ul>	
			</div>	
		</div>
	</div>
</div>	
<div class="clear"></div>

