<style type="text/css">
* {
	margin: 0;
	padding: 0;
	border: 0;
	list-style: none;
}

/*=========mF_liuzg ========*/
.mychgPic {
	width: 545px;
	height: 385px;
	border: 1px solid #999;
}

.mF_liuzg {
	position: relative;
	width: 545px;
	height: 385px;
	overflow: hidden;
	font: 12px/1.5 Verdana, Geneva;
	background: #fff;
}

.mF_liuzg .loading {
	position: absolute;
	z-index: 9999;
	width: 100%;
	height: 100%;
	color: #666;
	text-align: center;
	padding-top: 90px;
} /*载入画面*/
.mF_liuzg .pic li {
	width: 545px;
	position: relative;
	overflow: hidden;
	*margin-top: -2px;
}

.mF_liuzg .pic li p {
	width: 545px;
	position: absolute;
}

.mF_liuzg .pic li p a {
	display: block;
} /*图片和焦点图框架一样大小*/
.mF_liuzg .pic li p img {
	width: 545px;
	height: 385px;
}

.mF_liuzg .txt li {
	position: absolute;
	z-index: 2;
	bottom: 0;
	width: 545px;
	height: 36px;
	line-height: 34px;
	overflow: hidden;
	display: none;
}

.mF_liuzg .txt li a {
	display: block;
	color: #fff;
	padding: 2px 0 0 16px;
	font-size: 14px;
	font-weight: bold;
	text-decoration: none;
} /*标题样式*/
.mF_liuzg .txt-bg {
	position: absolute;
	bottom: 0;
	z-index: 1;
	width: 545px;
	height: 36px;
	overflow: hidden;
	background: #000;
	filter: alpha(opacity = 50);
	opacity: 0.5;
} /*标题背景*/
.mF_liuzg .num {
	position: absolute;
	z-index: 3;
	bottom: 8px;
	right: 8px;
	color: #333;
} /*按钮样式*/
.mF_liuzg .num li {
	float: left;
	width: 22px;
	height: 18px;
	position: relative;
	border: 1px solid #FFF;
	line-height: 18px;
	text-align: center;
	margin-right: 3px;
	cursor: pointer;
	background: #000;
	filter: alpha(opacity = 90);
	opacity: 0.9;
	color: #FFF;
}

.mF_liuzg .num li.current,.mF_liuzg .num li.hover {
	background: #A61814;
	color: #fff;
	font-weight: bold;
}

.rz_cp_box dl{
	padding-left: 20px;
}
.rz_cp_box dl dt{
	float: left;
}
.rz_cp_box dl dd{
	float: left;
}


.q1 {
  font-size: 15px;
  font-weight: bold;
  min-height: 20px;
  margin-bottom: 8px;
}

.qw {
  min-height: 25px;
  font-size: 14px;
}

.qww {
  width: 20px;
  min-height: 20px;
  background: #247fe8;
  float: left;
  text-align: center;
  color: #FFF;
}

.qwt {
  min-height: 20px;
  float: left;
  line-height: 20px;
  padding-left: 10px;
  margin-bottom: 5px;
}

.qd {
  min-height: 25px;
  font-size: 14px;
  width: 620px;
}

.qdd {
  width: 20px;
  min-height: 20px;
  background: #38de24;
  float: left;
  text-align: center;
  color: #FFF;
}

.qda {
  min-height: 20px;
  float: left;
  line-height: 20px;
  padding-left: 10px;
  width: 280px;
}


.bz_data table {
  border-collapse: collapse;
  font-size: 12px;
  text-align: center;
}
.bz_data th {
  height: 30px;
  line-height: 30px;
  border: 1px solid #ddd;
  background: #f3f3f3;
  color: #555;
}

.bz_data td {
  height: 30px;
  line-height: 30px;
  border: 1px solid #ddd;
  padding: 0 5px;
}

.xzfw{
    width:95px;
	height:106px;
	float:left;
	padding:0px 10px 10px 0px;

}



</style>
<script type="text/javascript">
var myFocus={
 //Design By Koen @ 2010.8.x
 //http://hi.baidu.com/koen_li
 $:function(id){return document.getElementById(id);},
 $$:function(tag,obj){return (typeof obj=='object'?obj:this.$(obj)).getElementsByTagName(tag);},
 style:function(obj,style){return (+[1,])?window.getComputedStyle(obj,null)[style]:obj.currentStyle[style];},//getStyle简化版
 easeOut:function(t,b,c,d){return -c*((t=t/d-1)*t*t*t - 1) + b;},
 move:function(obj,prop,val,type,spd,fn){//运动函数，spd为运动需要的时间，时间越大速度越小
  var t=0,b=parseInt(this.style(obj,prop)),c=val-b,d=spd||50,st=type,m=c>0?'ceil':'floor';
  if(obj[prop+'Timer']) clearInterval(obj[prop+'Timer']);
  obj[prop+'Timer']=setInterval(function(){
   if(t<d){obj.style[prop]=Math[m](myFocus[st](++t,b,c,d))+'px';}
   else {clearInterval(obj[prop+'Timer']);fn&&fn.call(obj);}
  },10);return this;
 },
 addList:function(obj,cla,x){//生成HMTL,cla为列表的class,其中封装有:cla='txt'(生成alt文字),cla='num'(生成按钮数字),cla='thumb'(生成小图)
  var s=[],n=x||this.$$('li',this.$$('ul',obj)[0]).length,num=cla.length;
  for(var j=0;j<num;j++){
   s.push('<ul class='+cla[j]+'>');
   for(var i=0;i<n;i++){s.push('<li>'+(cla[j]=='num'?(i+1):(cla[j]=='txt'?this.$$('li',obj)[i].innerHTML.replace(/\<img.*?\>/i,this.$$('img',obj)[i].alt):(cla[j]=='thumb'?'<img src='+(this.$$('img',obj)[i].getAttribute("thumb")||this.$$('img',obj)[i].src)+' />':'')))+'<span></span></li>')};
   s.push('</ul>');
  }; obj.innerHTML+=s.join('');
 },
 setting:function(par){
  if(window.attachEvent){window.attachEvent('onload',function(){myFocus[par.style](par)});}
　　  else{window.addEventListener('load',function(){myFocus[par.style](par)},false);}
 },
 mF_liuzg:function(par){
  var box=this.$(par.id),boxH=box.offsetHeight,t=par.time*1000;
  this.addList(box,['txt-bg','txt','num']);
  var pic=this.$$('li',this.$$('ul', box)[0]),n=pic.length;
  var c=boxH%par.chip?8:par.chip,h=boxH/c,pics=[];
  for(var i=0;i<c;i++){
   pics.push('<li><p>')
   for(var j=0;j<n;j++) pics.push(pic[j].innerHTML);
   pics.push('</p></li>')
  }
  this.$$('ul', box)[0].innerHTML=pics.join('');
  var ul=this.$$('ul',box),txt=this.$$('li',ul[2]),btn=this.$$('li',ul[3]),pic=this.$$('li',ul[0]);
  for(var i=0;i<c;i++){//初始化样式设置
   this.$$('p',pic[i])[0].style.top=-i*h+'px';
   pic[i].style.height=h+'px';
   this.$$('p',pic[i])[0].style.height=boxH*c+'px';
  }
  var index = 0;//开始显示的序号
  box.removeChild(this.$$('div',box)[0]);
  var run = function(idx) {
   var tt=par.type==4?Math.round(1+(Math.random()*(3-1))):par.type;//效果选择
   btn[index].className = '';
   txt[index].style.display='none';
            if(index==n-1) index=-1;
   var N=idx!=undefined?idx:index+1;
   var spd=tt==2?20:(tt==1?80:Math.round(20+(Math.random()*(80-20))));
   for(var i=0;i<c;i++){
    if(tt==3) spd=Math.round(20+(Math.random()*(80-20)));
    myFocus.move(myFocus.$$('p',pic[i])[0],'top',-N*c*h-i*h,'easeOut',spd);
    spd=tt==2?spd+10:(tt==1?spd-10:spd);
   }
   btn[N].className = 'current';
   txt[N].style.display='block';
            index = N;
        }
  run(index);
  var auto=setInterval(function(){run()},t);
  for (var j=0;j<n;j++){
   btn[j].j=j;
   btn[j].onclick=function(){if(!this.className) run(this.j)}
  }
  box.onmouseover=function(){clearInterval(auto);}
     box.onmouseout=function(){auto=setInterval(function(){run()},t);}
  for(var i=0,lk=this.$$('a',box),ln=lk.length;i<ln;i++) lk[i].onfocus=function(){this.blur();}//去除虚线框
 }
};
myFocus.setting({
 style:'mF_liuzg',//style为风格样式，
 id:'myFocus',//焦点图ID
 chip:8,//图片切片数量，能被焦点图的高整除才有效，默认为8片
 type:4,//切片效果，1为甩头，2为甩尾，3为凌乱，4为随机效果
 time:4//每帧图片时间间隔
});//更多样式设置留意myFocus正式版
</script>



<script type="text/javascript">
function TagMonitor(){
       this.tags = [];
   }
   
   TagMonitor.prototype.add = function(tag){
       this.tags[this.tags.length] = tag;
	   tag.monitor = this;
   }
   
   TagMonitor.prototype.flush = function(){
       for(var i=0;i<this.tags.length;i++){
	       this.tags[i].close();
	   }
   }
   
   function Tag(id, pannelId, className, hClassName){
       this.monitor = null;
	   this.id = id;
	   this.pannelId = pannelId;
	   this.className = className;
	   this.hClassName = hClassName;

       $("#" + this.id).bind('mouseover', { obj: this }, function (event) {
			event.data.obj.m();
	   })
   }
   
   Tag.prototype.m = function(){
       this.monitor.flush();
	   document.getElementById(this.pannelId).style.display = '';
	   document.getElementById(this.id).className = this.className;
   }
   
   Tag.prototype.close = function(){
       document.getElementById(this.pannelId).style.display = 'none';
	   document.getElementById(this.id).className = this.hClassName;
   }
   
   $(function(){
	   var monitor1 = new TagMonitor();

	   monitor1.add(new Tag('rdxwId','rdxwPanelId','title01_1','title01_2'));
	   monitor1.add(new Tag('tzggId','tzggPanelId','title01_1','title01_2'));
	   
	   var monitor2 = new TagMonitor();

	   monitor2.add(new Tag('gjjId','gjjPanelId','title02_2','title02_3'));	 
	   monitor2.add(new Tag('gssId','gssPanelId','title02_2','title02_3'));
	   monitor2.add(new Tag('jqsId','jqsPanelId','title02_2','title02_3'));	 
	   monitor2.add(new Tag('ymsId','ymsPanelId','title02_2','title02_3'));
	   
	   var monitor3 = new TagMonitor();

	   monitor3.add(new Tag('rzcpId','rzcpPanelId','title02_2','title02_3'));	 
	   monitor3.add(new Tag('rzzcId','rzzcPanelId','title02_2','title02_3'));
	   monitor3.add(new Tag('rzzxId','rzzxPanelId','title02_2','title02_3'));
	   
	   var monitor4 = new TagMonitor();

	   monitor4.add(new Tag('sjdwId','sjdwPanelId','link_font2','link_font3'));	 
	   monitor4.add(new Tag('hzwzId','hzwzPanelId','link_font2','link_font3'));
	   monitor4.add(new Tag('hyxhId','hyxhPanelId','link_font2','link_font3'));
	  
	   var monitor5 = new TagMonitor();

	   monitor5.add(new Tag('xxfwId','xxfwPanelId','shfw_01','shfw_02'));	 
	   monitor5.add(new Tag('rzdbId','rzdbPanelId','shfw_01','shfw_02'));
	   monitor5.add(new Tag('cyfwId','cyfwPanelId','shfw_01','shfw_02'));	 
	   monitor5.add(new Tag('rcfwId','rcfwPanelId','shfw_01','shfw_02'));
	   monitor5.add(new Tag('jscxId','jscxPanelId','shfw_01','shfw_02'));	 
	   monitor5.add(new Tag('glzxId','glzxPanelId','shfw_01','shfw_02'));
	   monitor5.add(new Tag('scktId','scktPanelId','shfw_01','shfw_02'));	 
	   monitor5.add(new Tag('flfwId','flfwPanelId','shfw_01','shfw_02'));
});

function MM_swapImgRestore(imgdom,imgurl) { //v3.0
	$(imgdom).attr("src",imgurl);
}

function MM_swapImage(imgdom,imgurl) { //v3.0
	$(imgdom).attr("src",imgurl);
}

function showSvorg(title){
	
}
</script>
	<div class="warp">
		<!--内容部分 start-->
		<div style="background-color: #FFFFFF; text-align: left; vertical-align: top;">
			<!--天气搜索 start-->
			<div style="background-color: #FFFFFF; text-align: left; vertical-align: top; line-height: 30px; padding: 10px; height: 30px; background-image: url(${base}/resources/site/images/bg_tq.jpg);">
				<!--搜索 start-->
				<div style="float: right; width: 360px;">
					<div style="float: left;">
						<img src="${base}/resources/site/images/icon_fdj.jpg" />
					</div>
					<div style="float: left; padding: 5px 10px 0px 10px;">
						<input name="" type="text"  id="txtSearchText" value="请输入关键字" onclick="if(value==defaultValue){value=&#39;&#39;;this.style.color=&#39;#000&#39;}"
							onblur="if(!value){value=defaultValue;this.style.color=&#39;#999&#39;}" style="width: 250px; height: 20px; border: 1px solid #CCCCCC;">
					</div>
					<div style="float: left;">
						<img src="${base}/resources/site/images/button_ss.jpg" border="0" id="btnSearchSubmit" />
						<a href="javacript:void(0);"></a>
					</div>
					<div class="clear"></div>
				</div>
				<!--搜索 end-->
				<!--天气 start-->
				<div style="float: left; width: 600px;">
					<div style="float: left;">
						<img src="${base}/resources/site/images/icon_tqyb.jpg" />
					</div>
					<div style="float: left; padding-top: 5px;">
						<iframe
							src="http://i.tianqi.com/index.php?c=code&id=40&icon=1&py=yumen&num=5"
							allowtransparency="true" frameborder="0" width="480" height="20"
							name="365myt" scrolling="no"></iframe>
					</div>
					<div class="clear"></div>
				</div>
				<!--天气 end-->
				<div class="clear"></div>
			</div>
			<!--天气搜索 end-->

			<!--内容 start-->
			<div style="padding: 0px 12px; text-align: left; vertical-align: top;">
				<!--图片新闻 start-->
				<div>
					<!--新闻 start-->
					<div style="float: right; width: 418px;">
						<div class="bg_title01">
							<a href="/channel.html?id=101"><div id="rdxwId" class="title01_1">新闻动态</div></a> 
							<a href="/channel.html?id=102"><div id="tzggId" class="title01_2">通知公告</div></a>
							<div class="clear"></div>
						</div>

						<div id="rdxwPanelId">
							<div style="background-color: #f9f9f9; padding: 10px; margin: 10px 0px; text-align: left; vertical-align: top;">
								<@sme_info_list channelid="101" titlelen="18" remarklen="45" dateformat="yyyy-MM-dd" num="1" ;info,index>
								<div style="font-size: 20px; color: #CC0000; font-weight: bold; line-height: 45px; height: 45px; letter-spacing: 2px;">
									<a href="${info.url}" class="a_title">${info.showtitle}</a>
								</div>
								<div style="font-size: 14px; color: #9b9b9b; line-height: 20px; height: 60px;">${info.showremark}...</div>
								</@sme_info_list>
							</div>
							<div style="text-align: left; vertical-align: top; line-height: 38px; font-size: 16px; height: 200px;">
								<ul>
									<@sme_info_list channelid="101" titlelen="20" dateformat="yyyy-MM-dd" num="5";info,index>
										<li>
											<a href="${info.url}" title="${info.title}" target="_blank">・&nbsp;${info.showtitle}…</a>
										</li>
									</@sme_info_list>
								</ul>
							</div>
						</div>

						<div id="tzggPanelId" style="display: none;">
							<div style="background-color: #f9f9f9; padding: 10px; margin: 10px 0px; text-align: left; vertical-align: top;">
								<@sme_info_list channelid="102" titlelen="18" remarklen="45" dateformat="yyyy-MM-dd" num="1" ;info,index>
								<div style="font-size: 20px; color: #CC0000; font-weight: bold; line-height: 45px; height: 45px; letter-spacing: 2px;">
									<a href="${info.url}" class="a_title">${info.showtitle}</a>
								</div>
								<div style="font-size: 14px; color: #9b9b9b; line-height: 20px; height: 60px;">${info.showremark}...</div>
								</@sme_info_list>
							</div>
							<div style="text-align: left; vertical-align: top; line-height: 38px; font-size: 16px; height: 200px;">
								<ul>
									<@sme_info_list channelid="102" titlelen="20" dateformat="yyyy-MM-dd" num="5";info,index>
										<li>
											<a href="${info.url}" title="${info.title}" target="_blank">・&nbsp;${info.showtitle}…</a>
										</li>
									</@sme_info_list>
								</ul>
							</div>
						</div>
					</div>
					<!--新闻 end-->
					
					<!--图片 start-->
					<div style="float: left; width: 545px; height: 385px;">
						<div class="mychgPic">
							<div id="myFocus" class="mF_liuzg">
								<div class="loading">
									<span>请稍候...</span>
								</div>
								<!--载入画面-->
								<ul class="pic">
									<!--内容列表-->
									<@sme_banner_list status='1';banner,index>
									<li><a href="${banner.url}" target="_blank">
										<img src="${banner.img}" alt="${banner.title}" /></a></li>
									</@sme_banner_list>
								</ul>
							</div>
						</div>
					</div>
					<!--图片 end-->
				</div>
				<!--图片新闻 end-->
				<div class="clear"></div>
				<!--banner1 start-->
				<div style="padding: 12px 0px; height: 110px;">
					<a href="#"><img src="${base}/resources/site/images/banner_jkyqsyjs.jpg" border="0" /></a>
				</div>
				<!--banner1 end-->
				<!--新闻一 start-->
				<div style="padding-bottom: 8px;">
					<!--政策法规 start-->
					<div style="width: 480px; float: right;">
						<div class="bg_title02">
							<@sme_channel_list parid="105" desc="1";channel,index>
							 <#if index==0>
							 <a href="#"><div id="${channel.id}" class="tab_zcfg title02_2">${channel.title}</div></a>
						     <#else>
						     <a href="#"><div id="${channel.id}" class="tab_zcfg title02_3">${channel.title}</div></a>
						     </#if>
						     </@sme_channel_list>
							<div class="title02_1">政策法规</div>
							<div class="clear"></div>
						</div>
						<@sme_channel_list parid="105" desc="1";channel,index>
						<div id="zcfg_${channel.id}" class="list_ul zcfg_list"
							style="text-align: left; vertical-align: top; line-height: 35px; font-size: 16px; height: 280px; background-color: #f9f9f9; margin: 5px 0px; padding: 10px;display:<#if (index>0) >none</#if>">
							<ul>
								<@sme_info_list channelid="${channel.id}" titlelen="25" dateformat="yyyy-MM-dd" num="8";info,index>
								<li>
									<a href="${info.url}" title="${info.title}" target="_blank">・&nbsp;${info.showtitle}…</a>
								</li>
								</@sme_info_list>
							</ul>
						</div>
						</@sme_channel_list>
						
					</div>
					<!--政策法规 end-->
					<!--平台活动 start-->
					<div style="width: 480px; float: left;">
						<div class="bg_title02">
							<div style="float: right;">
								<a href="http://www.smeym.org/activity.html" class="a_more">更多>></a>
							</div>
							<div class="title02_1">平台活动</div>
							<div class="clear"></div>
						</div>

						<div
							style="text-align: left; vertical-align: top; line-height: 35px; font-size: 16px; height: 300px; background-color: #f9f9f9; margin: 5px 0px; padding: 0px 15px;">
							<@sme_activity_list dateformat="yyyy-MM-dd HH:mm" num="2" titlelen="15" remarklen="45";activity>
							<div class="pthd_tb">
								<div style="float: right; width: 275px;">
									<div class="pt_font1">
										<a href="${activity.url}">${activity.showtitle}</a>
									</div>
									<div class="pt_font2">"${activity.showremark}...</div>
									<div class="pt_font3">活动时间： ${activity.starttimestr}</div>
								</div>
								<div style="float: left; width: 160px; height: 115px;">
									<a href="${activity.url}"><img src="${activity.img}" width="160" height="115" border="0" /></a>
								</div>
								<div class="clear"></div>
							</div>
							</@sme_activity_list>
						</div>
					</div>
					<!--平台活动 start-->
					<div class="clear"></div>
				</div>
				<!--新闻一end-->

				<!--服务 start-->
				<div
					style="border-bottom: 1px solid #eeeeee; border-left: 1px solid #eeeeee; border-right: 1px solid #eeeeee; margin-bottom: 12px;">
					<!--行政服务 start-->
					<div style="float: right; width: 330px;">
						<div class="fw_title">行政服务</div>
						<div style="padding: 10px 0px 0px 13px; text-align: left; vertical-align: top;">
							<@sme_sclass_list code="0" type="G"; sclass,index>
							<div class="xzfw">
								<a href="/appeal.html?gcode=${sclass.id}" >
								<img src="${base}/resources/site/images/${sclass.id}_1.jpg" border="0" width="95" height="106" onmouseout="MM_swapImgRestore(this,'${base}/resources/site/images/${sclass.id}_1.jpg')" onmouseover="MM_swapImage(this,'${base}/resources/site/images/${sclass.id}_2.jpg')"/>
								</a>
							</div>
							</@sme_sclass_list>
							<div class="clear"></div>
						</div>
					</div>
					<!--行政服务 end-->
					<!--社会服务 start-->
					<div
						style="float: left; width: 643px; border-right: 1px solid #eeeeee;">
						<div class="fw_title">社会服务</div>
						<div style="height: 340px; padding: 10px; text-align: left; vertical-align: top;">
							<!--社会服务内容 start-->
							<div style="padding-bottom: 5px;">
								<div style="float: right; width: 460px; height: 240px; border: 1px solid #eeeeee; padding: 10px;">
									<@sme_sclass_list code="0" type="S"; sclass,index>
									<#if index==0>
									<div id="sclass_${sclass.id}" class="sclass_panel" style="display:;">
									<#else>
									<div id="sclass_${sclass.id}" class="sclass_panel" style="display:none;">
									</#if>
										<!--服务机构 start-->
										<div style="float: right; width: 220px;">
											<div
												style="background-image: url(${base}/resources/site/images//shfw_fwjg.jpg); height: 35px;"></div>
											<div
												style="line-height: 34px; text-align: left; vertical-align: top; padding: 5px 0px;">
												<ul>
													<@sme_svorg_list scode="${sclass.id}" titlelen="14" num="6"; svorg,index>
														<li class="fwxm_tb"><a href="${svorg.url}">${svorg.showtitle}</a></li>
													</@sme_svorg_list>
												</ul>
											</div>
										</div>
										<!--服务机构 end-->
										<!--服务项目 start-->
										<div style="float: left; width: 220px;">
											<div style="background-image: url(${base}/resources/site/images/shfw_fwxm.jpg); height: 35px;"></div>
											<div style="line-height: 34px; text-align: left; vertical-align: top; padding: 5px 0px;">
												<ul>
													<@sme_sitem_list scode="${sclass.id}" titlelen="14" num="6"; sitem,index>
													<li class="fwxm_tb" onmouseover="showSvorg('${sitem.showtitle}')"><a href="${sitem.url}">${sitem.showtitle}</a></li>
													</@sme_sitem_list>
												</ul>
											</div>
										</div>
										<!--服务项目 end-->
										<div class="clear"></div>
									</div>
									</@sme_sclass_list>
								</div>

								<div style="float: left; width: 135px;">
									<@sme_sclass_list code="0" type="S"; sclass,index>
									<#if index==0>
									<a href="#"><div id="${sclass.id}" class="shfw_01 tab_sclass curr">${sclass.title}</div></a> 
									<#else>
									<a href="#"><div id="${sclass.id}" class="shfw_02 tab_sclass curr">${sclass.title}</div></a>
									</#if>
									</@sme_sclass_list>
									<div class="clear"></div>
								</div>

								<div class="clear"></div>
							</div>
							<!--社会服务内容 end-->

							<!--数据专题 start-->
							<div style="height: 70px;">
								<div style="width: 203px; height: 70px; float: right;">
									<a href="/corp.html"><img src="${base}/resources/site/images/zt_qyml.jpg" width="203"
										height="70" border="0" /></a>
								</div>
								<div
									style="width: 203px; height: 70px; float: left; margin-right: 7px;">
									<a href="/report.html"><img src="${base}/resources/site/images/zt_sjbs.jpg" width="203"
										height="70" border="0" /></a>
								</div>
								<!--
								<div
									style="width: 150px; height: 70px; float: left; margin-right: 7px;">
									<a href="/project.html"><img src="${base}/resources/site/images/zt_gcxm.jpg" width="150"
										height="70" border="0" /></a>
								</div>
								-->
								<div
									style="width: 203px; height: 70px; float: left; margin-right: 7px;">
									<a href="/declare.html"><img src="${base}/resources/site/images/zt_xmsb.jpg" width="203"
										height="70" border="0" /></a>
								</div>
							</div>
							<!--数据专题 end-->
						</div>
					</div>
					<!--社会服务 end-->
					<div class="clear"></div>
				</div>
				<!--服务 end-->

				<!--banner2 start-->
				<div style="height: 110px; margin-bottom: 12px;">
					<div style="float: right; width: 330px; height: 110px;">
						<a href="http://sp.smeym.org/"><img src="${base}/resources/site/images/pic_qyxxhpt.jpg" border="0" /></a>
					</div>
					<div style="float: left; width: 634px; height: 110px;">
						<a href="http://www.smeym.org/channel.html?id=1035"><img src="${base}/resources/site/images/pic_zgzz.jpg" border="0" /></a>
					</div>
					<div class="clear"></div>
				</div>
				<!--banner2 end-->

				<!--新闻二 start-->
				<div style="padding-bottom: 8px;">
					<!--服务动态 start-->
					<div style="width: 630px; float: left;">
						<div class="bg_title02">
							<div style="float: right;">
								<a href="http://www.smeym.org/home.html" class="a_more">更多>></a>
							</div>
							<div class="title02_1">服务动态</div>
							<div class="clear"></div>
						</div>

						<div class="bz_data" style="text-align: left; vertical-align: top; line-height: 35px; font-size: 16px; height: 30px; margin: 5px 0px; ">
							<table width="100%" border="0" cellpadding="0" cellspacing="0">
								<tr>
								      <th style="width:40%;">需求标题</th>
								      <th style="width:30%;">企业名称</th>
								      <th style="width:15%;">发布时间</th>
								      <th style="width:15%;">当前状态</th>
								   </tr>
							</table>
						</div>
						<div id="demohq" class="bz_data" style="text-align: left; vertical-align: top; line-height: 35px; font-size: 16px; height: 250px;overflow:hidden;  margin: 5px 0px; ">
							<div id="demohq1" >
							<table width="100%" border="0" cellpadding="0" cellspacing="0" >
								    <@sme_appealitem_list num="10";appealitem,index>
									<tr>
										<td style="width:40%;"><a href="" target="_blank">${appealitem.topictitle}</a></td>
										<td style="width:30%;">${appealitem.corptitle}</td>
										<td style="width:15%;">${appealitem.addtimestr}</td>
										<td style="width:15%;" class="red" >
											<#if appealitem.status=="0">
												已提交，等待受理
											</#if>
											<#if appealitem.status=="1">
												<font color="green">已办理</font>
											</#if>
											<#if appealitem.status=="2">
												受理中
											</#if>
										</td>
									</tr>
									</@sme_appealitem_list>
						    </table>
						    </div>
						    <div id="demohq2" ></div>
						</div>
					</div>
					<!--服务动态 start-->
					<!--融资服务 start-->
					<div style="width: 330px; float: right;">
						<div class="bg_title02">
							<a href="http://www.smeym.org/appeal.html?gcode=212"><div id="rzcpId" class="tab_rzfw title02_3">融资产品</div></a>
							<a href="http://www.smeym.org/channel.html?id=1036"><div id="rzzcId" class="tab_rzfw title02_3">融资政策</div></a>
							<a href="http://www.smeym.org/consults.html"><div id="rzzxId" class="tab_rzfw title02_2">融资咨询</div></a> 
							<div class="title02_1">融资服务</div>
							<div class="clear"></div>
						</div>
						
						<div id="rzzxPanelId"
							style="text-align: left; vertical-align: top; font-size: 14px; height: 280px; background-color: #f9f9f9; margin: 5px 0px; padding: 10px; ">
							<@sme_consult_list scode="11" num="4" remarklen="20";consult,index>
							<div style="min-height:60px; margin:0px auto; margin-top:10px; overflow:hidden;">
					        	<div class="q1"><a href="/consult-${consult.id}.html">${consult.title}</a></div>
					            <div class="qw"><div class="qww">问</div><div class="qwt">${consult.showremark}</div></div>
					        </div>
					        </@sme_consult_list>
						</div>
						
						<div id="rzzcPanelId"
							style="text-align: left; vertical-align: top; line-height: 35px; font-size: 16px; height: 280px; background-color: #f9f9f9; margin: 5px 0px; padding: 10px; display: none;">
							<ul>
								 <@sme_info_list channelid="1036" titlelen="15" dateformat="yyyy-MM-dd" num="8";info,index>
								<li>
									<a href="${info.url}" title="${info.title}" target="_blank">・&nbsp;${info.showtitle}…</a>
								</li>
								</@sme_info_list>
							</ul>
						</div>
						
						<div id="rzcpPanelId"
							style="text-align: left; vertical-align: top; line-height: 35px; font-size: 16px; height: 280px; background-color: #f9f9f9; margin: 5px 0px; padding: 10px;display: none;">
							<div class="rz_cp_box">
								<@sme_appealtopic_list gcode="212" num="2" ;topic,index>
								<div > <a href="${topic.url}">・&nbsp;${topic.title}…</a></div>
								<dl>
									<dt>融资机构:</dt>
									<dl><a href="${topic.url}">${topic.svgtitle}</a></dl>
								</dl>
								<div class="clear"></div>
								</@sme_appealtopic_list>
							</div>
						</div>

					</div>
					<!--融资服务 end-->

					<div class="clear"></div>
				</div>
				<!--新闻二 end-->

				<!--友情链接 start-->
				<div style="padding-bottom: 12px;">
					<div style="height: 40px; line-height: 40px; background-color: #f9f9f9; border-top: 4px solid #1782ed; border-bottom: 1px solid #cecece;">
						<@sme_link_class type='3'; lkclass,index>
							<#if index==1>
							<div class="tab_link link_font2" id="${lkclass.id}"> ${lkclass.name}</div>
							<#else>
							<div class="tab_link link_font3" id="${lkclass.id}">${lkclass.name}</div>
							</#if>
						</@sme_link_class>
						<div class="link_font1">友情链接</div>
						<div class="clear"></div>
					</div>
					<@sme_link_class type='3'; lkclass,index>
					<#if index==1>
					<div class="link_panel w_bot_1x" id="link_${lkclass.id}" style="background-color: #f9f9f9; padding: 10px 10px 15px 0px; line-height: 30px;">
					<#else>
					<div class="link_panel w_bot_1x" id="link_${lkclass.id}" style="background-color: #f9f9f9; padding: 10px 10px 15px 0px; line-height: 30px; display: none;">
					</#if>
						<@sme_link_list classId="${lkclass.id}" type='3'; link,index>
						<div class="link_01">
							<a href="${link.url}" target="_blank">&#8226;&nbsp;${link.name}</a>
						</div>
						</@sme_link_list>
						<div class="clear"></div>
					</div>
					</@sme_link_class>
				</div>
				<!--友情链接 end-->
			</div>
			<!--内容 end-->
		</div>
		<!--内容部分 end-->
	</div>
<script>
var speedhq=60;
function Marqueehq(){
	if(demohq.scrollTop==demohq1.offsetHeight){
		demohq.scrollTop=0;
	}else{
		demohq.scrollTop++;
	}
}
var MyMarhq=setInterval(Marqueehq,speedhq)
demohq.onmouseover=function() {clearInterval(MyMarhq)}
demohq.onmouseout=function() {MyMarhq=setInterval(Marqueehq,speedhq)}
</script>