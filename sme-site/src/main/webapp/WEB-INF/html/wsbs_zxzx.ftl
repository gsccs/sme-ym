<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>在线咨询_玉门市中小企业公共服务平台</title>
<link rel="shortcut icon" href="${base}/resources/site/images/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/base.css" />
<script type="text/javascript" src="${base}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/Common.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/HomeAndFavorite.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/resources/wsbs/css/project.css" />
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
	
	.zxzx_input{
		width: 305px;
	  height: 30px;
	  line-height: 30px;
	  border: 1px solid #b0b0b0;
	  font-size: 14px;
	  color: #333;
	}
	
	
	.zxzx_textarea{
		width: 700px;
	  height: 200px;
	  line-height: 30px;
	  border: 1px solid #b0b0b0;
	  font-size: 14px;
	  color: #333;
	  margin: 5px 0;
	}
	
	.zxzx_td_title{
		width: 110px;
	  line-height: 47px;
	  font-size: 14px;
	  color: #333;
	  text-align: right;
	}
	</style>
</head>
<body>

<script type="text/javascript">
    $(function () {
		
    });
</script>

	<!-- header -->
	[#include "/widget/header.ftl" /]
	
	<!-- main -->
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
										<option value=""><option>
										</select>
									</td>
								</tr>
								<tr>
									<td class="zxzx_td_title">
										<span style="padding-left: 13px;"><a style="color: red;">*</a></span>咨询事项：
									</td>
									<td> 
										<select id="svgid" name="svgid" class="zxzx_input">
											<option value=""><option>
										</select>
									</td>
								</tr>
								<tr>
									<td class="zxzx_td_title">
										<span style="padding-left: 13px;"><a style="color: red;">*</a></span>主题：
									</td>
									<td>  
										<input id="SBLSH" name="SBLSH" type="text" size="35" autocomplete="off" class="zxzx_input">
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
						<a id="submit" class="submit fl">提&nbsp;&nbsp;交</a> <a id="reset" class="reset">重&nbsp;&nbsp;置</a>
					</div>
				</div>
				
			</div>
		</div>
	</div>	
	<div class="clear"></div>
	
	<!-- footer -->
    [#include "/widget/footer.ftl" /]			
</body>
</html>