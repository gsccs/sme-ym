//运动
function startMove(obj,json,times,fx,fn){	
	var iCur = {};	
	var startTime = now();	
	for(var attr in json){
		iCur[attr] = 0;
		if(attr == 'opacity'){			
			iCur[attr] = Math.round(getStyle(obj,attr)*100);			
		}
		else{			
			iCur[attr] = parseInt(getStyle(obj,attr));			
		}
	}	
	clearInterval(obj.timer);
	obj.timer = setInterval(function(){		
		var changeTime = now();		
		var scale = 1 -  Math.max(0,startTime  -  changeTime + times)/times ; //1000 - 0  ->  1 - 0  -> 0 - 1		
		for(var attr in json){			
			var value = Tween[fx]( scale*times ,iCur[attr] , json[attr] - iCur[attr] , times );			
			if(attr == 'opacity'){				
				obj.style.filter = 'alpha(opacity='+value+')';
				obj.style.opacity = value/100;				
			}
			else{
				
				obj.style[attr] = value + 'px';				
			}			
		}		
		if(scale == 1){
			clearInterval(obj.timer);
			if(fn){
				fn.call(obj);
			}
		}		
	},13);	
	function now(){		
		return (new Date()).getTime();		
	}	
	
}	
//样式获取
function getStyle(obj,attr){
	return obj.currentStyle?obj.currentStyle[attr]:getComputedStyle(obj,false)[attr];;
}
//获取类名
function getByClass(Parten,sClass){
	var aEl=Parten.getElementsByTagName('*');
	var aClassName=[];
	var re=new RegExp('\\b'+sClass+'\\b','i')
	for(var i=0; i<aEl.length; i++){
		if(re.test(aEl[i].className)){
			aClassName.push(aEl[i]);
		}
	}
	return aClassName
}
//时间运动JSON
var Tween = {
	//t : 当前时间   b : 初始值  c : 变化值   d : 总时间
	//return : 当前的位置 	
	linear: function (t, b, c, d){  //匀速
		return c*t/d + b;
	},
	backBoth: function(t, b, c, d, s){
		if (typeof s == 'undefined') {
			s = 1.70158; 
		}
		if ((t /= d/2 ) < 1) {
			return c/2*(t*t*(((s*=(1.525))+1)*t - s)) + b;
		}
		return c/2*((t-=2)*t*(((s*=(1.525))+1)*t + s) + 2) + b;
	}
}

//政民互动大厅
function govHall(obj){
	var oObj=getByClass(document,obj)[0];
	if(oObj == null) return;
	var aA=oObj.getElementsByTagName('div')[0].getElementsByTagName('a');
	var oInfoTxt=getByClass(oObj,'text_showinfo')[0];
	var oInfoTxtH4=oInfoTxt.getElementsByTagName('h4')[0];
	var oInfoTxtP=oInfoTxt.getElementsByTagName('p')[0];
	var aMoveUd=getByClass(oObj,'move_ud');

	oInfoTxtH4.innerHTML=aA[0].title;
	oInfoTxtP.innerHTML=aA[0].name;
	for(var i=0; i<aA.length; i++){
		aA[i].onmouseover=function(){
			oInfoTxt.style.display='block';
			startMove(oInfoTxt,{height:90},100,'linear')
			oInfoTxtH4.innerHTML=this.title;
			oInfoTxtP.innerHTML=this.name;
		}
		aA[i].onmouseout=function(){
			
			startMove(oInfoTxt,{height:0},100,'linear',function(){
				oInfoTxt.style.display='none';
				oInfoTxtH4.innerHTML='';
				oInfoTxtP.innerHTML='';				
			})
		}
	}
	for(var i=0; i<aMoveUd.length; i++){
		aMoveUd[i].onmouseover=function(){
			startMove(this,{top:-this.offsetHeight/2},150,'linear')
		}
		aMoveUd[i].onmouseout=function(){
			startMove(this,{top:0},200,'linear')
		}
	}
}

//政民互动微博列表
function weiBoMove(obj){
	var oObj=getByClass(document,obj)[0];
	if(oObj == null) return;
	var oBtn=getByClass(oObj,'tD_btn')[0];
	var oUpBtn=oBtn.getElementsByTagName('a')[0];
	var oDownBtn=oBtn.getElementsByTagName('a')[1];
	var oUl=getByClass(oObj,'userlist')[0];
	var iNum=0;
	var moveHeight=oUl.getElementsByTagName('li')[0].offsetHeight;
	
	oObj.onmouseover=function(){
		oBtn.style.display='block';
		oUpBtn.onclick=function(){
			if(iNum >= -moveHeight){
				iNum=0;
				startMove(oUl,{top:0},300,'linear');
			}else{
				iNum+=moveHeight;
				startMove(oUl,{top:iNum},300,'linear');
			}			
		}
		oDownBtn.onclick=function(){
			if(iNum >= -(oUl.offsetHeight- oObj.offsetHeight)){
				iNum-=moveHeight;
				startMove(oUl,{top:iNum},300,'linear');
            }			
		}
	}
	oObj.onmouseout=function(){
		oBtn.style.display='none';
	}

	

}
//政民互动微博列表弹窗
function popBox(){
	var oDiv = document.createElement('div');
	var oBg=document.createElement('div');
	var oContent=getByClass(document,'userlist')[0].cloneNode(true);
	var oClose=document.createElement('a');
	getByClass(document,'js_weibo_box')[0].style.zIndex=-1;
	oDiv.className ='pop_box iweibo_box';
	oBg.style.width=oDiv.style.width=document.body.scrollWidth+'px';
	oBg.style.height=oDiv.style.height=document.body.scrollHeight+'px';
	oBg.className='bg';
	oClose.className='close';
	oClose.href='javascript:;';
	oClose.innerHTML='关闭';
	document.body.appendChild(oDiv);
	oDiv.appendChild(oBg);
	oDiv.appendChild(oContent);
	oContent.appendChild(oClose);
	oContent.style.left=(document.documentElement.clientWidth-oContent.offsetWidth)/2+'px';
	if(document.body.scrollTop){
		oContent.style.top=document.body.scrollTop+(document.documentElement.clientHeight+-oContent.offsetHeight)/2+'px';			
	}else{
		oContent.style.top=document.documentElement.scrollTop+(document.documentElement.clientHeight+-oContent.offsetHeight)/2+'px';
	}
	oClose.onclick=function(){			
		startMove(oDiv,{opacity:0},150,'linear',function(){
			document.body.removeChild(oDiv);
			getByClass(document,'js_weibo_box')[0].style.zIndex=1;
		})
		
	}
}

// 底部滑出效果
function bottomMove(obj){
	var oObj=getByClass(document,obj)[0];
	if(oObj == null) return;
	var aLi=getByClass(oObj,'move_li')
	
	for(var i=0; i<aLi.length; i++){
		aLi[i].onmouseover=function(){
			var oDiv=this.getElementsByTagName('div')[0].getElementsByTagName('div')[0];
			var iHeight=oDiv.offsetHeight;
			this.getElementsByTagName('a')[0].className='active';
			this.getElementsByTagName('div')[0].style.display='block';
			startMove(oDiv,{bottom:0},200,'linear');
		}
		aLi[i].onmouseout=function(){
			var _This=this;
			var oDiv=this.getElementsByTagName('div')[0].getElementsByTagName('div')[0];
			var iHeight=oDiv.offsetHeight;		

			startMove(oDiv,{bottom:-iHeight},200,'linear',function(){
				_This.getElementsByTagName('div')[0].style.display='none';
				_This.getElementsByTagName('a')[0].className='';
			});
		}
	}
}


//微博显示
function showWb(obj){
	var oObj=getByClass(document,obj)[0];
	if(oObj == null) return;
	var oUl=oObj.getElementsByTagName('ul')[0];
	var aLi=oUl.getElementsByTagName('li');
	if(aLi.length < 4) return;
	var iHeight=0;
	timer=null;
	timer=setInterval(function(){toMove()},3000)
	oObj.onmouseover=function(){clearInterval(timer);}
	oObj.onmouseout=function(){timer=setInterval(function(){toMove()},3000)}

	function toMove(){
		iHeight=aLi[aLi.length-1].offsetHeight;

		var oNewLi=aLi[aLi.length-1].cloneNode(true);		
		oUl.insertBefore(oNewLi,aLi[0]);
		oUl.removeChild(aLi[aLi.length-1]);
		aLi[0].style.opacity = 0;
		aLi[0].style.filter = 'alpha(opacity=0)';

		aLi[0].style.height=0;		
		startMove(aLi[0],{height:iHeight},400,'linear',function(){
			startMove(aLi[0],{opacity:100},300,'linear')
		})


	}
}
//左侧浮动窗口
function floatRight(obj){
	var oObj=getByClass(document,obj)[0];
	if(oObj==null) return;
	
	if(document.body.offsetWidth<998+110){
		oObj.style.display='none';
	}else{
		var aSpan=oObj.getElementsByTagName('span');
		var aSpanWidth=aSpan[0].offsetWidth-80;
		var oGotop=getByClass(oObj,'ctrl-btn-5')[0];
		oGotop.style.visibility='hidden';
		for(var i=0; i<aSpan.length; i++){
			aSpan[i].onmouseover=function(){
				for(var j=0; i<aSpan.length; j++){
					aSpan[j].className='';
				}
				this.className='active';
				startMove(this,{right:80},200,'linear')
			}
			aSpan[i].onmouseout=function(){
				var _This=this;
				startMove(this,{right:-aSpanWidth},200,'linear',function(){
					this.className=''
					startMove(this,{right:-(aSpanWidth-45)},200,'linear')
				})
			}
		}
		window.onscroll=function(){
			var iTop=document.body.scrollTop || document.documentElement.scrollTop;
			if(iTop>200){
				oGotop.style.visibility='visible'
			}else if(iTop<=0){
				oGotop.style.visibility='hidden'
			}
		}
	}
}


