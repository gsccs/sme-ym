//点击在线办理和查看指南后添加历史记录
function addHistory(code) {
	var history = LEx.cookie.get("project_history");
	if (history != null && history != "") {
		if (history.indexOf(code) == -1) {
			history += "," + code;
		}
	} else {
		history = code;
	}
	LEx.cookie.set("project_history", history, 1);
}

function chargeHelp(pid) {
	LEx.dialog({
		title : "收费标准",
		url : LEx.webPath + "project/chargehelp?pid=" + pid,
		width : 700,
		height : 250,
	//	lock : true,  兼容IE7不要","
		lock : true
	});
}

// 二维码地址
function download(filepath) {
	var url = "";
	filepath = filepath.replace(/(^\s+)|(\s+$)/g, "");
	filepath = filepath.replace(/^\//, "");
	var reg = /^(http:\/\/|https:\/\/)/i;
	if (reg.test(filepath)) {
		url = filepath; // url格式路径直接返回
	} else {
		url = location.href; // 本地服务器相对路径
		var xy = url.match(reg);
		url = url.replace(xy[0], "");
		url = xy[0] + url.substr(0, url.indexOf("/")) + LEx.webPath + filepath;
	}
	return url;
}

function downloadFile(filepath) {
	filepath = filepath.replace(/(^\s+)|(\s+$)/g, "");
	filepath = filepath.replace(/^\//, "");
	var reg = /^(http:\/\/|https:\/\/)/i;
	if (reg.test(filepath)) {
		window.open(filepath);
	} else {
		var url = location.href;
		var xy = url.match(reg);
		url = url.replace(xy[0], "");
		url = xy[0] + url.substr(0, url.indexOf("/")) + LEx.webPath + filepath;
		var p = filepath.lastIndexOf(".");
		if (p > 0) {
			var hz = filepath.substring(p + 1, filepath.length);
			if (hz == "jpg" || hz == "gif" || hz == "png" || hz == "jpeg" || hz == "bmp") {
				window.open(url);
			} else {
				location.href = url;
			}
		} else {
			LEx.dialog.tips("未知文件类型！");
		}
	}
}

// 格式化字段，val为代码值，dictcode对应字典表code，codemap对应字典码表数组
function formatField(val, dictcode, codemap) {
	for ( var i in codemap) {
		if (codemap[i].DICT_CODE == field) {
			if (codemap[i].ITEM_CODE == val) {
				return codemap[i].ITEM_VALUE;
			}
		}
	}
	return "无";
}

// 时间格式，如果不为空，按照空间格式显示时间，如果为空，显示“—”
function formatDate(val) {
	if (LEx.isNotNull(val)) {
		return LEx.util.Format.formatDate(val);
	} else {
		return "无";
	}
}

function openOnlineServiceUrl(url) {
	var CA_auth = "{{ConfigInfo.CA_auth}}";
	url = completeUrl(url);
	if (LEx.isNotNull(CA_auth) && CA_auth == 1) {
		url = LEx.webPath + "app/uc/login?action=random&goto=" + encodeURIComponent(url);
	}
	window.open(url);
}

// 对A类事项，如果地址不以http开头，在头部加上http
function completeUrl(url) {
	url = url.replace(/(^\s+)|(\s+$)/g, "");
	var reg = /^(http:\/\/|https:\/\/)/i;
	if (!reg.test(url)) {
		url = "http://" + url;
	}
	return url;
}
