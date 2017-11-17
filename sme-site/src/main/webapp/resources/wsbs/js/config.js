//----------------------------------------------------------------------
//名称：无障碍辅助浏览工具条第三版功能配置文件
//开发：scorpio
//日期：2010/12/20
//说明：用于配置工具条
//----------------------------------------------------------------------

//------------------------------------------------------------
//***********************工具条配置部分***********************
//------------------------------------------------------------
function declareConfig(){
	ABTConfig = new Object();
	
	//工具条主开关--------------------------------------
	ABTConfig.mainSwitch = true;
	
	//主容器名称----------------------------------------
	ABTConfig.container = "container_main";
	
	//跳转节点类名称------------------------------------
	ABTConfig.skipClassName = "skipelement";
	
	//cookie功能开关------------------------------------
	ABTConfig.cookieSwitch = true;
	//cookie保存时间------------------------------------
	ABTConfig.cookieTime = 1;
	
	//--------------------------------------------------
	//功能部分设置***O(∩_∩)O~~************************
	//--------------------------------------------------
	//区域跳转------------------------------------------
	ABTConfig.areaSkip={};
	ABTConfig.areaSkip.functionSwitch = true;
	ABTConfig.areaSkip.delimit = new Array(
		"header:已跳转到头部内容区域:Alt+K",
		"content:已跳转到主要内容区域:Alt+C",
		"content:已跳转到主要内容区域:Alt+Ctrl+C",
		"main:已跳转到中间内容区域:Alt+M",
		"main:已跳转到中间内容区域:Ctrl+Alt+Shift+M",
		"leftsidebar:已跳转到左侧内容区域:Alt+L",
		"leftcolumn:已跳转到左侧内容区域:Alt+L",
		"leftsidebar:已跳转到左侧内容区域:Ctrl+Alt+Shift+L",
		"leftcolumn:已跳转到左侧内容区域:Ctrl+Alt+Shift+L",
		"rightsidebar:已跳转到右侧内容区域:Alt+R",
		"rightcolumn:已跳转到右侧内容区域:Alt+R",
		"rightsidebar:已跳转到右侧内容区域:Ctrl+Alt+Shift+R",
		"rightcolumn:已跳转到右侧内容区域:Ctrl+Alt+Shift+R",
		"footer:已跳转到底部内容区域:Alt+B",
		"footer:已跳转到底部内容区域:Ctrl+Alt+Shift+B"
	);
	//自定义跳转----------------------------------------
	ABTConfig.customSkip={};
	ABTConfig.customSkip.functionSwitch = true;
	ABTConfig.customSkip.nextKeyCode = new Array(
		"Ctrl+z",
		"Alt+z"
	);
	ABTConfig.customSkip.previousKeyCode = new Array(
		"ctrl+shift+z",
		"alt+shift+z"
	);
	ABTConfig.customSkip.delimit = new Array(
		"tagName:H1:网站标志",
		"tagName:H2:一级栏目分组",
		"tagName:H3:二级栏目分组",
		"tagName:H4:三级栏目分组",
		"tagName:H5:四级栏目分组",
		//"tagName:DT:栏目分组",
		"tagId:header:头部栏目分组"
	);
	//纯文本模式----------------------------------------
	ABTConfig.textMode={};
	ABTConfig.textMode.cookieSwitch = false;
	ABTConfig.textMode.functionSwitch = false;
	ABTConfig.textMode.KeyCode = new Array("alt+shift+j");
	ABTConfig.textMode.styleFileURL = "/无障碍辅助浏览工具条（第三版）/styles/textMode.css";
	//页面缩放------------------------------------------
	ABTConfig.pageZoom={};
	ABTConfig.pageZoom.cookieSwitch = true;
	ABTConfig.pageZoom.functionSwitch = true;
	ABTConfig.pageZoom.onceZoom = 0.2;
	ABTConfig.pageZoom.Max = 2;
	ABTConfig.pageZoom.Min = 1;
	//字体缩放------------------------------------------
	ABTConfig.fontZoom={};
	ABTConfig.fontZoom.cookieSwitch = true;
	ABTConfig.fontZoom.functionSwitch = true;
	ABTConfig.fontZoom.onceZoom = 4;
	ABTConfig.fontZoom.Max = 28;
	ABTConfig.fontZoom.Min = 14;
	//高对比度------------------------------------------
	ABTConfig.hightContrast={};
	ABTConfig.hightContrast.cookieSwtich = true;
	ABTConfig.hightContrast.functionSwitch = true;
	ABTConfig.hightContrast.delimit = new Array(
		"#FFF|#000|黑白对比度",
		"#FFF|#93F|白紫对比度",
		"#000|#09F|黑蓝对比度",
		"#F00|#FFF|红白对比度"
	);
	//辅助线--------------------------------------------
	ABTConfig.guides={};
	ABTConfig.guides.cookieSwitch = true;
	ABTConfig.guides.functionSwitch = true;
	ABTConfig.guides.skew = 5;
	//文字提示------------------------------------------
	ABTConfig.textTips={};
	ABTConfig.textTips.cookieSwitch = true;
	ABTConfig.textTips.functionSwitch = true;
	ABTConfig.textTips.pinyinSwitch = true;
	ABTConfig.textTips.pinyinFileURL = "script/ku.js";
	//帮助----------------------------------------------
	ABTConfig.help={};
	ABTConfig.help.functionSwitch = true;
	var ABTFileUrl = document.getElementById("nobar").getAttribute("src");
	var basePath = "";
	if (ABTFileUrl.indexOf("/") != -1) {
		basePath = ABTFileUrl.substring(0, ABTFileUrl.lastIndexOf("/") + 1);
	} else {
		basePath = "";
	}
	ABTConfig.help.dataFileURL = basePath+"helpContent.html";
	//重置----------------------------------------------
	ABTConfig.resetToolbar={};
	ABTConfig.resetToolbar.functionSwitch = true;
	//开关----------------------------------------------
	ABTConfig.show={};
	ABTConfig.show.cookieSwtich = true;
	ABTConfig.show.functionSwitch = true;
	ABTConfig.show.keyCode = new Array(
		"alt+j"
	);
	
	//--------------------------------------------------
	//工具条样式设置***O(∩_∩)O~~**********************
	//--------------------------------------------------
	ABTConfig.defaultSkin = 2;
	ABTConfig.skin = new Array();
	ABTConfig.skin[0] = {
		name:"默认样式",
		bodyPadding:33,
		folder:"default"
	}
	ABTConfig.skin[1] = {
		name:"白色样式",
		bodyPadding:71,
		folder:"white"
	}
	ABTConfig.skin[2] = {
		name:"深圳政府在线定制蓝",
		bodyPadding:40,
		folder:"blue"
	}
}