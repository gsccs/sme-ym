function loadConfig() {
	var ABTFileUrl = document.getElementById("nobar").getAttribute("src");
	URLPrefix = "";
	if (ABTFileUrl.indexOf("/") != -1) {
		URLPrefix = ABTFileUrl.substring(0, ABTFileUrl.lastIndexOf("/") + 1);
	} else {
		URLPrefix = "";
	}
	document.writeln("<script type=\"text/javascript\" src=\"" + URLPrefix + "config.js\"></script>");
	document.writeln("<script type=\"text/javascript\" src=\"" + URLPrefix + "pinyin.js\"></script>");
}
loadConfig();
eval(function(p, a, c, k, e, d) {
	e = function(c) {
		return (c < a ? '': e(parseInt(c / a))) + ((c = c % a) > 35 ? String.fromCharCode(c + 29) : c.toString(36))
	};
	if (!''.replace(/^/, String)) {
		while (c--) d[e(c)] = k[c] || e(c);
		k = [function(e) {
			return d[e]
		}];
		e = function() {
			return '\\w+'
		};
		c = 1
	};
	while (c--) if (k[c]) p = p.replace(new RegExp('\\b' + e(c) + '\\b', 'g'), k[c]);
	return p
} ('6(b.1){	b.1("7",0,4);}3{	b.2("8",0);}b.9 = b.a = 5(){}', 62, 12, 'Initialization|addEventListener|attachEvent|else|false|function|if|load|onload|onresize|onscroll|window'.split('|'), 0, {}));
var pageLoaded = false;
function Initialization() {
	eval(function(p, a, c, k, e, d) {
		e = function(c) {
			return (c < a ? '': e(parseInt(c / a))) + ((c = c % a) > 35 ? String.fromCharCode(c + 29) : c.toString(36))
		};
		if (!''.replace(/^/, String)) {
			while (c--) d[e(c)] = k[c] || e(c);
			k = [function(e) {
				return d[e]
			}];
			e = function() {
				return '\\w+'
			};
			c = 1
		};
		while (c--) if (k[c]) p = p.replace(new RegExp('\\b' + e(c) + '\\b', 'g'), k[c]);
		return p
	} ('a = e;	4();	7(0.9){		1();		6(0.2);		8();		d.c = 0.5;		d.3.b();	}', 62, 15, 'ABTConfig|browserType|container|cookie|declareConfig|defaultSkin|getElements|if|iframeKeyListenerWrite|mainSwitch|pageLoaded|readCookie|skin|toolbar|true'.split('|'), 0, {}))
}
eval(function(p, a, c, k, e, d) {
	e = function(c) {
		return (c < a ? '': e(parseInt(c / a))) + ((c = c % a) > 35 ? String.fromCharCode(c + 29) : c.toString(36))
	};
	if (!''.replace(/^/, String)) {
		while (c--) d[e(c)] = k[c] || e(c);
		k = [function(e) {
			return d[e]
		}];
		e = function() {
			return '\\w+'
		};
		c = 1
	};
	while (c--) if (k[c]) p = p.replace(new RegExp('\\b' + e(c) + '\\b', 'g'), k[c]);
	return p
} ('5.d = 8 b(6){	9(!e){f;}	i 4=0,6=6||7;	4=6.a||6.j||6.2;	h.c(6.3,6.1,6.g,4);}', 62, 20, '|altKey|charCode|ctrlKey|currkey|document|e|event|function|if|keyCode|keyListener|keyboardListener|onkeydown|pageLoaded|return|shiftKey|toolbar|var|which'.split('|'), 0, {}))

function browserType() {
	browserType = {};
	var ua = navigator.userAgent.toLowerCase();
	var s; (s = ua.match(/msie ([\d.]+)/)) ? browserType.ie = s[1] : (s = ua.match(/firefox\/([\d.]+)/)) ? browserType.firefox = s[1] : (s = ua.match(/chrome\/([\d.]+)/)) ? browserType.chrome = s[1] : (s = ua.match(/opera.([\d.]+)/)) ? browserType.opera = s[1] : (s = ua.match(/version\/([\d.]+).*safari/)) ? browserType.safari = s[1] : 0;
}
eval(function(p, a, c, k, e, d) {
	e = function(c) {
		return (c < a ? '': e(parseInt(c / a))) + ((c = c % a) > 35 ? String.fromCharCode(c + 29) : c.toString(36))
	};
	if (!''.replace(/^/, String)) {
		while (c--) d[e(c)] = k[c] || e(c);
		k = [function(e) {
			return d[e]
		}];
		e = function() {
			return '\\w+'
		};
		c = 1
	};
	while (c--) if (k[c]) p = p.replace(new RegExp('\\b' + e(c) + '\\b', 'g'), k[c]);
	return p
} ('c f(8){	d = m 1();	i(7.e(8)){		d.6 = 7.e(8);		d.2 = d.6.g("*");		d.4 = d.6.g("k");		d.3 = d.6.g("j");		d.5 = 7.g("h")[0].g("l");		d.a = b;	}	9{		d.a = n;	}}', 62, 24, '|Object|allElements|allFrame|allImg|allStyle|container|document|elementId|else|error|false|function|getE|getElementById|getElements|getElementsByTagName|head|if|iframe|img|link|new|true'.split('|'), 0, {}));
eval(function(p, a, c, k, e, d) {
	e = function(c) {
		return (c < a ? '': e(parseInt(c / a))) + ((c = c % a) > 35 ? String.fromCharCode(c + 29) : c.toString(36))
	};
	if (!''.replace(/^/, String)) {
		while (c--) d[e(c)] = k[c] || e(c);
		k = [function(e) {
			return d[e]
		}];
		e = function() {
			return '\\w+'
		};
		c = 1
	};
	while (c--) if (k[c]) p = p.replace(new RegExp('\\b' + e(c) + '\\b', 'g'), k[c]);
	return p
} ('6 8(9){	f d = "";	d += 5(9.e().7("3")>-1?1:0);	d += 5(9.e().7("2")>-1?1:0);	d += 5(9.e().7("4")>-1?1:0);	d += 9.e().c(9.e().a("+")+1);	b d;}', 62, 16, '||ALT|CTRL|SHIFT|String|function|indexOf|keyCodeStringHandle|keyString|lastIndexOf|return|substring|thisKeyString|toUpperCase|var'.split('|'), 0, {}));
function skipElementBuild(element, elementText) {
	if (!element) {
		return;
	}
	var shipElement = document.createElement("div");
	shipElement.setAttribute("class", ABTConfig.skipClassName);
	shipElement.style.cssText = "width:0px;height:0px;font-size:0px;line-height:0px;";
	shipElement.innerHTML = '<a href="javascript:"' + ' title="' + elementText + '">' + elementText + "</a>";
	element.parentNode.insertBefore(shipElement, element);
	shipElement.firstChild.focus();
}
function skipElementRemove(skipElement) {
	skipElement.parentNode.parentNode.removeChild(skipElement.parentNode);
}
eval(function(p, a, c, k, e, d) {
	e = function(c) {
		return (c < a ? '': e(parseInt(c / a))) + ((c = c % a) > 35 ? String.fromCharCode(c + 29) : c.toString(36))
	};
	if (!''.replace(/^/, String)) {
		while (c--) d[e(c)] = k[c] || e(c);
		k = [function(e) {
			return d[e]
		}];
		e = function() {
			return '\\w+'
		};
		c = 1
	};
	while (c--) if (k[c]) p = p.replace(new RegExp('\\b' + e(c) + '\\b', 'g'), k[c]);
	return p
} ('6 8(3){	i 4;	9(3.b=="#e"){4=g.c;}	5 9(3.b=="0"){		9(3.7("1")){4=3.7("1");}		5 9(3.7("h")){4=3.7("h");}		5{4=2.h;}	}	5{4=3.a||3.f;}	d 4;}', 62, 19, 'IMG|alt|document|element|elementText|else|function|getAttribute|getText|if|innerText|nodeName|nodeValue|return|text|textContent|thisElement|title|var'.split('|'), 0, {}));
eval(function(p, a, c, k, e, d) {
	e = function(c) {
		return (c < a ? '': e(parseInt(c / a))) + ((c = c % a) > 35 ? String.fromCharCode(c + 29) : c.toString(36))
	};
	if (!''.replace(/^/, String)) {
		while (c--) d[e(c)] = k[c] || e(c);
		k = [function(e) {
			return d[e]
		}];
		e = function() {
			return '\\w+'
		};
		c = 1
	};
	while (c--) if (k[c]) p = p.replace(new RegExp('\\b' + e(c) + '\\b', 'g'), k[c]);
	return p
} ('b i(){	g(c.8){p;}	a(w f=0;f<c.1.l;f++){		w h = c.1[f].4;		u{			w r = h.6.5("q");			r.s("v","t/j");			r.t = "6.m = b(7){w 7=7||9;6.o.n.k(7);}";			h.6.d("e")[0].2(r);		}3(7){}	}}', 62, 33, '|allFrame|appendChild|catch|contentWindow|createElement|document|e|error|event|for|function|getE|getElementsByTagName|head|i|if|iframeDOM|iframeKeyListenerWrite|javascript|keyListener|length|onkeydown|parent|parentWindow|return|script|scriptElement|setAttribute|text|try|type|var'.split('|'), 0, {}));
var toolbar = new Object();
eval(function(p, a, c, k, e, d) {
	e = function(c) {
		return (c < a ? '': e(parseInt(c / a))) + ((c = c % a) > 35 ? String.fromCharCode(c + 29) : c.toString(36))
	};
	if (!''.replace(/^/, String)) {
		while (c--) d[e(c)] = k[c] || e(c);
		k = [function(e) {
			return d[e]
		}];
		e = function() {
			return '\\w+'
		};
		c = 1
	};
	while (c--) if (k[c]) p = p.replace(new RegExp('\\b' + e(c) + '\\b', 'g'), k[c]);
	return p
} ('n.i = c(7,5,l,j){	e(d.8){k;}	p g = "";	g += 3(7?1:0);	g += 3(5?1:0);	g += 3(l?1:0);	a(p 4 f n.2){		o{n.2[4].h(g+3.b(j).m());}6(9){					}	}}', 62, 26, '||Function|String|a|altKey|catch|ctrlKey|error|f|for|fromCharCode|function|getE|if|in|keyNum|keyTrigger|keyboardListener|otherKey|return|shiftKey|toUpperCase|toolbar|try|var'.split('|'), 0, {}));
toolbar.cookie = new Object();
toolbar.cookie.setCookie = function(cookieName, cookieValue) {
	if (cookieName == undefined || cookieValue == undefined) {
		return;
	}
	var Days = ABTConfig.cookieTime;
	var exp = new Date();
	exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
	var cookie_path = LEx.webPath;

	document.cookie = cookieName + "=" + escape(cookieValue) + ("; path=" + cookie_path) + ";expires=" + exp.toGMTString();
}
toolbar.cookie.getCookie = function(name) {
	if (name == undefined) {
		return;
	}
	var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
	if (arr != null) return unescape(arr[2]);
	return null;
}
toolbar.cookie.readCookie = function() {
	if (!ABTConfig.cookieSwitch || getE.error) {
		return;
	}
	for (var a in toolbar.Function) {
		try {
			toolbar.Function[a].cookieMethod();
		} catch(e) {};
	}
}
toolbar.Function = new Object();
toolbar.Function.areaSkip = {
	keyTrigger: function(keyString) {
		var customizeAreaSkip = ABTConfig.areaSkip.delimit;
		for (var a = 0; a < customizeAreaSkip.length; a++) {
			if (keyString == keyCodeStringHandle(customizeAreaSkip[a].split(":")[2])) {
				toolbar.Function.areaSkip.mainMethod(customizeAreaSkip[a].split(":")[0], customizeAreaSkip[a].split(":")[1]);
			}
		}
	},
	mainMethod: function(areaId, elementText) {
		if (!ABTConfig.areaSkip.functionSwitch) {
			return;
		};
		skipElementBuild(document.getElementById(areaId), elementText);
	}
}
eval(function(p, a, c, k, e, d) {
	e = function(c) {
		return (c < a ? '': e(parseInt(c / a))) + ((c = c % a) > 35 ? String.fromCharCode(c + 29) : c.toString(36))
	};
	if (!''.replace(/^/, String)) {
		while (c--) d[e(c)] = k[c] || e(c);
		k = [function(e) {
			return d[e]
		}];
		e = function() {
			return '\\w+'
		};
		c = 1
	};
	while (c--) if (k[c]) p = p.replace(new RegExp('\\b' + e(c) + '\\b', 'g'), k[c]);
	return p
} ('N.5.c = {	v:l(u){		Q z = 3.c.z;		Q D = 3.c.D;		k(Q 6=0;6<z.w;6++){s(u==t(z[6])){N.5.c.x(0);};};		k(Q 6=0;6<D.w;6++){s(u==t(D[6])){N.5.c.x(1);};};	},	o:l(){		Q I = 3.c.d;		Q 8 = y 4();		Q 7 = 0;		k(Q 6=0;6<p.9.w;6++){			k(Q a=0;a<I.w;a++){				Q L = I[a].H(":");				s((L[0]=="K"&&p.9[6].A==L[1])||(L[0]=="J"&&p.9[6].n("r")==L[1])){					8[7]={						e:p.9[6],						f:L[2],						g:L[0]					};					7++;				}			}		}		E 8;	},	j:O,	b:y 4(),	C:-1,	x:l(F){		s(!3.c.m){E;};		s(M.j){			M.b = M.o();			M.j = i;		}		s(F==0){			M.C++;			s(M.C>M.b.w-1){M.C=M.b.w-1;}		}		h s(F==1){			M.C--;			s(M.C<0){M.C=0;}		}		s(M.b.w==0){E;}		Q B = "";		s(M.b[M.C].g!="J"){			B = q(M.b[M.C].e);			s(B==P){B="";}		}		B += M.b[M.C].f;		G(M.b[M.C].e,B);	}};', 62, 53, '|||ABTConfig|Array|Function|a|allColumnNum|allCustomElement|allElements|b|customElementGroup|customSkip|delimit|element|elementTips|elementType|else|false|firstRun|for|function|functionSwitch|getAttribute|getCustomSkip|getE|getText|id|if|keyCodeStringHandle|keyString|keyTrigger|length|mainMethod|new|nextKeyCode|nodeName|nodeText|nowElementNum|previousKeyCode|return|skipDirection|skipElementBuild|split|switchValue|tagId|tagName|tempVar|this|toolbar|true|undefined|var'.split('|'), 0, {}));
toolbar.Function.textMode = {
	showHTML: function() {
		if (ABTConfig.textMode.functionSwitch) {
			var buttonText = this.textModeState ? "切换回默认模式": "纯文本模式浏览";
			return "<input id=\"textmodebutton\" type=\"button\" value=\"" + buttonText + "\" title=\"" + buttonText + "\" onclick=\"toolbar.Function.textMode.mainMethod()\" />";
		} else {
			return ""
		}
	},
	keyTrigger: function(keyString) {
		var shortcuts = ABTConfig.textMode.KeyCode;
		for (var a = 0; a < shortcuts.length; a++) {
			if (keyString == keyCodeStringHandle(shortcuts[a])) {
				toolbar.Function.textMode.mainMethod();
			};
		};
	},
	cookieName: "textModeState",
	cookieMethod: function() {
		if (ABTConfig.textMode.cookieSwitch && toolbar.cookie.getCookie(this.cookieName) == 1) {
			toolbar.Function.textMode.mainMethod();
		}
	},
	resetCookie: function() {
		toolbar.cookie.setCookie(this.cookieName, 0);
	},
	textModeState: false,
	mainMethod: function() {
		if (!ABTConfig.textMode.functionSwitch || getE.error) {
			return;
		};
		if (!this.textModeState) {
			getE.container.style.display = "none";
			for (var c = 0; c < getE.allFrame.length; c++) {
				var iframeDOM = getE.allFrame[c].contentWindow;
				var newFrameContainer = document.createElement("div");
				try {
					newFrameContainer.innerHTML = iframeDOM.document.body.innerHTML;
				} catch(z) {}
				getE.allFrame[c].parentNode.insertBefore(newFrameContainer, getE.allFrame[c]);
			}
			while (getE.allFrame.length) {
				getE.allFrame[0].parentNode.removeChild(getE.allFrame[0]);
			}
			for (var d = 0; d < getE.allImg.length; d++) {
				var newImgContainer = document.createElement("span");
				newImgContainer.innerHTML = getText(getE.allImg[d]);
				getE.allImg[d].parentNode.insertBefore(newImgContainer, getE.allImg[d]);
			}
			while (getE.allImg.length) {
				getE.allImg[0].parentNode.removeChild(getE.allImg[0]);
			}
			var textModeStyleUrl = URLPrefix + "textMode.css";
			for (var a = 0; a < getE.allStyle.length; a++) {
				if (getE.allStyle[a].getAttribute("id") != "ABTStyle") {
					getE.allStyle[a].setAttribute("href", "#");
				}
			}
			var textModeStyle = document.createElement("link");
			textModeStyle.setAttribute("rel", "stylesheet");
			textModeStyle.setAttribute("type", "text/css");
			textModeStyle.setAttribute("href", textModeStyleUrl);
			document.getElementsByTagName("head")[0].appendChild(textModeStyle);
			for (var b = 0; b < getE.allElements.length; b++) {
				getE.allElements[b].style.height = null;
			};
			if (document.getElementById("textmodebutton")) {
				document.getElementById("textmodebutton").setAttribute("value", "切换回默认模式")
			};
			getE.container.style.display = "block";
			this.textModeState = true;
			toolbar.cookie.setCookie(this.cookieName, this.textModeState ? 1 : 0);
		} else {
			this.textModeState = false;
			toolbar.cookie.setCookie(this.cookieName, this.textModeState ? 1 : 0);
		 	window.location.href = LEx.getLocation();//xss
			window.location.reload();
		}
	}
};
toolbar.Function.pageZoom = {
	showHTML: function() {
		if (ABTConfig.pageZoom.functionSwitch) {
			return "<input id=\"pagezoomin\" type=\"button\" value=\"页面放大\" title=\"页面放大\" onclick=\"toolbar.Function.pageZoom.mainMethod(1)\" /><input id=\"pagezoomout\" type=\"button\" value=\"页面缩小\" title=\"页面缩小\" onclick=\"toolbar.Function.pageZoom.mainMethod(0)\" />";
		} else {
			return "";
		}
	},
	cookieName: "pageZoomState",
	cookieMethod: function() {
		if (!ABTConfig.pageZoom.cookieSwitch) {
			return;
		}
		var cookieValue = toolbar.cookie.getCookie(this.cookieName);
		if (cookieValue > 1) {
			cookieValue -= ABTConfig.pageZoom.onceZoom;
			this.pageZoomState = cookieValue;
			toolbar.Function.pageZoom.mainMethod(1);
		}
	},
	resetCookie: function() {
		toolbar.cookie.setCookie(this.cookieName, 1);
	},
	pageZoomState: 1,
	firstRun: true,
	mainMethod: function(zoomMode) {
		if (!ABTConfig.pageZoom.functionSwitch || getE.error) {
			return;
		};
		if (zoomMode == 1) {
			this.pageZoomState = (this.pageZoomState * 10 + ABTConfig.pageZoom.onceZoom * 10) / 10;
			if (this.pageZoomState > ABTConfig.pageZoom.Max) {
				this.pageZoomState = ABTConfig.pageZoom.Max;
			}
		} else if (zoomMode == 0) {
			this.pageZoomState = (this.pageZoomState * 10 - ABTConfig.pageZoom.onceZoom * 10) / 10;
			if (this.pageZoomState < ABTConfig.pageZoom.Min) {
				this.pageZoomState = ABTConfig.pageZoom.Min;
			}
		}
		var containerWidth = getE.container.offsetWidth;
		var containerHeight = getE.container.offsetHeight;
		getE.container.style.display = "none";
		if (browserType.ie) {
			if (document.body.offsetWidth > containerWidth * this.pageZoomState) {
				getE.container.style.cssText = "position:absolute;left:50%;margin:0px;";
				getE.container.style.marginLeft = 0 - Math.round(containerWidth * this.pageZoomState / 2) + "px";
			} else {
				getE.container.style.cssText = "position:absolute;left:0px;margin:0px;";
			}
			getE.container.style.zoom = this.pageZoomState;
		} else {
			var containerX = Math.round(((containerWidth * this.pageZoomState - containerWidth) / this.pageZoomState) / 2);
			var containerY = Math.round(((containerHeight * this.pageZoomState - containerHeight) / this.pageZoomState) / 2);
			var boxTranslate;
			if (containerWidth * this.pageZoomState > document.body.offsetWidth) {
				var fuck = (containerWidth * this.pageZoomState - document.body.offsetWidth) / 2;
				boxTranslate = Math.round(fuck / this.pageZoomState);
			} else {
				boxTranslate = 0;
			}
			var hackCSS = "";
			if (browserType.firefox) {
				hackCSS = "-moz-";
			};
			if (browserType.chrome || browserType.safari) {
				hackCSS = "-webkit-";
				document.body.style.height = Math.round(containerHeight * this.pageZoomState) + "px";
				var bodyWidth;
				var oldBodyWidth = document.body.offsetWidth;
				if (oldBodyWidth < containerWidth * this.pageZoomState && zoomMode == 1) {
					bodyWidth = Math.round((containerWidth * this.pageZoomState - oldBodyWidth) / this.pageZoomState);
					document.body.style.width = Math.round(containerWidth * this.pageZoomState) + "px";
					boxTranslate -= bodyWidth / 2;
				}
				if (zoomMode == 0) {
					if (screen.width > containerWidth * this.pageZoomState) {
						document.body.style.width = null;
					} else {
						document.body.style.width = Math.round(containerWidth * this.pageZoomState) + "px";
					}
				}
			}
			if (browserType.opera) {
				hackCSS = "-o-";
			};
			getE.container.style.cssText = hackCSS + "transform:scale(" + this.pageZoomState + ") translate(" + boxTranslate + "px," + containerY + "px);";
		}
		if (this.pageZoomState == 1) {
			getE.container.style.cssText = null;
			document.body.style.width = null;
		}
		getE.container.style.display = "block";
		toolbar.cookie.setCookie(this.cookieName, this.pageZoomState);
	}
};
toolbar.Function.fontZoom = {
	showHTML: function() {
		if (ABTConfig.fontZoom.functionSwitch) {
			return "<input id=\"fontzoomin\" type=\"button\" value=\"文字放大\" title=\"文字放大\" onclick=\"toolbar.Function.fontZoom.mainMethod(1)\" /><input id=\"fontzoomout\" type=\"button\" value=\"文字缩小\" title=\"文字缩小\" onclick=\"toolbar.Function.fontZoom.mainMethod(0)\" onfocus=\"toolbar.Function.hightContrast.openMenu(1)\" />";
		} else {
			return "";
		}
	},
	cookieName: "fontZoomState",
	cookieMethod: function() {
		if (!ABTConfig.fontZoom.cookieSwitch) {
			return;
		}
		var cookieValue = toolbar.cookie.getCookie(this.cookieName);
		if (cookieValue != 0) {
			this.fontZoomState = cookieValue - ABTConfig.fontZoom.onceZoom;
			toolbar.Function.fontZoom.mainMethod(1);
		}
	},
	resetCookie: function() {
		toolbar.cookie.setCookie(this.cookieName, 0);
	},
	fontZoomState: 0,
	mainMethod: function(zoomMode) {
		if (!ABTConfig.fontZoom.functionSwitch || getE.error) {
			return;
		};
		if (this.fontZoomState == 0) {
			this.fontZoomState = ABTConfig.fontZoom.Min;
		}
		if (zoomMode == 1) {
			this.fontZoomState += ABTConfig.fontZoom.onceZoom;
			if (this.fontZoomState > ABTConfig.fontZoom.Max) {
				this.fontZoomState = ABTConfig.fontZoom.Max;
			}
		} else if (zoomMode == 0) {
			this.fontZoomState -= ABTConfig.fontZoom.onceZoom;
			if (this.fontZoomState < ABTConfig.fontZoom.Min) {
				this.fontZoomState = 0;
			}
		}
		for (var a = 0; a < getE.allElements.length; a++) {
			if (this.fontZoomState > ABTConfig.fontZoom.Min) {
				getE.allElements[a].style.fontSize = this.fontZoomState + "px";
				getE.allElements[a].style.lineHeight = (this.fontZoomState + 2) + "px";
			} else {
				getE.allElements[a].style.fontSize = null;
				getE.allElements[a].style.lineHeight = null;
			}
		}
		toolbar.cookie.setCookie(this.cookieName, this.fontZoomState);
	}
}
toolbar.Function.hightContrast = {
	showHTML: function() {
		if (ABTConfig.hightContrast.functionSwitch) {
			var hightContrastHTML = "<div id=\"hightcontrast\"><input id=\"hightcontrastbutton\" type=\"button\" value=\"高对比度\" title=\"高对比度\" onmouseover=\"toolbar.Function.hightContrast.openMenu(0)\" onmouseout=\"toolbar.Function.hightContrast.openMenu(1)\" onfocus=\"toolbar.Function.hightContrast.openMenu(0)\" /><ul id=\"hightcontrastlist\" onmouseover=\"toolbar.Function.hightContrast.openMenu(0)\" onmouseout=\"toolbar.Function.hightContrast.openMenu(1)\" style=\"display:none;\">";
			hightContrastHTML += "<li><a href=\"javascript:toolbar.Function.hightContrast.mainMethod(-1)\">还原对比度</a></li>";
			var contrastlist = ABTConfig.hightContrast.delimit;
			for (var a = 0; a < contrastlist.length; a++) {
				hightContrastHTML = hightContrastHTML + "<li style=\"background-color:" + contrastlist[a].split("|")[1] + ";\"><a href=\"javascript:toolbar.Function.hightContrast.mainMethod(" + a + ")\" style=\"color:" + contrastlist[a].split("|")[0] + ";\">" + contrastlist[a].split("|")[2] + "</a></li>"
			}
			hightContrastHTML += "</ul></div>";
			return hightContrastHTML
		} else {
			return ""
		}
	},
	cookieName: "hightContrastState",
	cookieMethod: function() {
		if (!ABTConfig.hightContrast.cookieSwtich) {
			return
		}
		var cookieValue = toolbar.cookie.getCookie(this.cookieName);
		if (cookieValue != -1) {
			toolbar.Function.hightContrast.mainMethod(cookieValue)
		}
	},
	resetCookie: function() {
		toolbar.cookie.setCookie(this.cookieName, -1)
	},
	openMenu: function(mode) {
		if (mode == 0) {
			document.getElementById("hightcontrastlist").style.display = "block"
		} else if (mode == 1) {
			document.getElementById("hightcontrastlist").style.display = "none"
		}
	},
	contrastControl: function(element, mode, q, b) {
		if (mode == 0) {
			element.style.backgroundColor = "";
			element.style.backgroundImage = "";
			element.style.color = ""
		} else if (mode == 1) {
			element.style.backgroundColor = b;
			element.style.backgroundImage = "none";
			element.style.color = q
		}
	},
	mainMethod: function(colorNum) {
		if (!ABTConfig.hightContrast.functionSwitch || getE.error) {
			return
		};
		var contrastlist = ABTConfig.hightContrast.delimit;
		if (colorNum != -1) {
			var qcolor = contrastlist[colorNum].split("|")[0];
			var bcolor = contrastlist[colorNum].split("|")[1];
			for (var b = 0; b < getE.allElements.length; b++) {
				this.contrastControl(getE.allElements[b], 1, qcolor, bcolor)
			}
			for (var c = 0; c < getE.allFrame.length; c++) {
				var iframeDOM = getE.allFrame[c].contentWindow;
				try {
					var iframeBody = iframeDOM.document.getElementsByTagName("body")[0];
					this.contrastControl(iframeBody, 1, qcolor, bcolor);
					for (var d = 0; d < iframeBody.getElementsByTagName("*").length; d++) {
						this.contrastControl(iframeBody.getElementsByTagName("*")[d], 1, qcolor, bcolor)
					}
				} catch(e) {}
			}
		} else {
			for (var b = 0; b < getE.allElements.length; b++) {
				this.contrastControl(getE.allElements[b], 0)
			}
			for (var c = 0; c < getE.allFrame.length; c++) {
				var iframeDOM = getE.allFrame[c].contentWindow;
				try {
					var iframeBody = iframeDOM.document.getElementsByTagName("body")[0];
					this.contrastControl(iframeBody, 0);
					for (var d = 0; d < iframeBody.getElementsByTagName("*").length; d++) {
						this.contrastControl(iframeBody.getElementsByTagName("*")[d], 0)
					}
				} catch(e) {}
			}
		}
		toolbar.cookie.setCookie(this.cookieName, colorNum)
	}
}
toolbar.Function.guides = {
	showHTML: function() {
		if (ABTConfig.guides.functionSwitch) {
			var guidesValue = this.guidesState ? "关闭辅助线": "开启辅助线";
			return "<input id=\"guidesbutton\" type=\"button\" value=\"" + guidesValue + "\" title=\"" + guidesValue + "\" onclick=\"toolbar.Function.guides.mainMethod();\" onfocus=\"toolbar.Function.hightContrast.openMenu(1);\" />";
		} else {
			return "";
		}
	},
	cookieName: "guidesState",
	cookieMethod: function() {
		if (ABTConfig.guides.cookieSwitch && toolbar.cookie.getCookie(this.cookieName) == 1) {
			toolbar.Function.guides.mainMethod();
		}
	},
	resetCookie: function() {
		toolbar.cookie.setCookie(this.cookieName, 0);
	},
	guidesState: false,
	mainMethod: function() {
		if (!ABTConfig.guides.functionSwitch) {
			return;
		};
		if (!this.guidesState) {
			var newGuidesBox = document.createElement("div");
			newGuidesBox.setAttribute("id", "guidesbox");
			newGuidesBox.innerHTML = "<div id=\"guidesXLine\"></div><div id=\"guidesYLine\"></div>";
			document.body.insertBefore(newGuidesBox, getE.container);
			document.getElementById("guidesYLine").style.height = document.body.offsetHeight + "px";
			document.getElementById("guidesXLine").style.backgroundColor = "#F00";
			document.getElementById("guidesYLine").style.backgroundColor = "#F00";
			if (document.getElementById("guidesbutton")) {
				document.getElementById("guidesbutton").setAttribute("value", "关闭辅助线");
			}
			if (document.getElementById("guidesbutton")) {
				document.getElementById("guidesbutton").setAttribute("title", "关闭辅助线");
			}
			document.onmousemove = this.moveGuides;
			window.onscroll = this.moveGuides;
			this.guidesState = true;
		} else {
			document.getElementById("guidesbox").parentNode.removeChild(document.getElementById("guidesbox"));
			if (document.getElementById("guidesbutton")) {
				document.getElementById("guidesbutton").setAttribute("value", "开启辅助线");
			}
			if (document.getElementById("guidesbutton")) {
				document.getElementById("guidesbutton").setAttribute("title", "开启辅助线");
			}
			this.guidesState = false;
		}
		toolbar.cookie.setCookie(this.cookieName, this.guidesState ? 1 : 0);
	},
	moveGuides: function(e) {
		if (!document.getElementById("guidesbox")) {
			return;
		}
		e = window.event ? window.event: e;
		var guidesX, guidesY;
		document.getElementById("guidesXLine").style.position = "absolute";
		if (browserType.ie) {
			guidesX = e.clientX + ABTConfig.guides.skew;
			guidesY = e.clientY + (document.documentElement.scrollTop || document.body.scrollTop) + ABTConfig.guides.skew;
		} else {
			document.getElementById("guidesXLine").style.position = "fixed";
			guidesX = e.pageX + ABTConfig.guides.skew;
			guidesY = e.pageY - (document.documentElement.scrollTop || document.body.scrollTop) + ABTConfig.guides.skew;
		}
		document.getElementById("guidesYLine").style.left = guidesX + "px";
		document.getElementById("guidesXLine").style.top = guidesY + "px";
	}
}
toolbar.Function.textTips = {
	showHTML: function() {
		if (ABTConfig.textTips.functionSwitch) {
			return "<input id=\"texttipsbutton\" type=\"button\" value=\"文字提示\" title=\"文字提示\" onclick=\"toolbar.Function.textTips.mainMethod()\" /><!--<input id=\"pinyinbutton\" type=\"button\" value=\"开启拼音功能\" title=\"开启拼音功能\" onclick=\"toolbar.Function.textTips.pinyinControl()\" />-->"
		} else {
			return ""
		}
	},
	cookieName: "textTips",
	cookieMethod: function() {
		if (ABTConfig.textTips.cookieSwitch && toolbar.cookie.getCookie(this.cookieName) == 1) {
			toolbar.Function.textTips.mainMethod()
		}
	},
	resetCookie: function() {
		toolbar.cookie.setCookie(this.cookieName, 0)
	},
	testTipsState: false,
	pinyinState: false,
	allTextNode: new Array(),
	getTextNode: function(element) {
		var childNodes = element.childNodes;
		for (var i = 0; i < childNodes.length; i++) {
			var thisChild = childNodes[i];
			switch (thisChild.nodeType) {
			case 1:
				this.getTextNode(thisChild);
				break;
			case 3:
				if (this.trim(thisChild.nodeValue).length == 0) {
					break
				}
				this.allTextNode.push(thisChild);
				break
			}
			if (thisChild.nodeName == "IMG" || thisChild.nodeName == "INPUT" || thisChild.nodeName == "OBJECT" || thisChild.nodeName == "SELECT") {
				this.allTextNode.push(thisChild)
			}
		}
	},
	AddTag: function() {
		if (this.firstRun) {
			return
		}
		for (var a = 0; a < this.allTextNode.length; a++) {
			var tagNode = document.createElement("span");
			if (this.allTextNode[a].nodeName == "IMG" || this.allTextNode[a].nodeName == "INPUT" || this.allTextNode[a].nodeName == "SELECT") {
				tagNode.setAttribute("class", "getmessage");
				var newNode = this.allTextNode[a].cloneNode(true);
				tagNode.appendChild(newNode)
			} else if (this.allTextNode[a].nodeName == "OBJECT" && this.allTextNode[a].parentNode.nodeName != "OBJECT") {
				tagNode.setAttribute("class", "getmessage");
				var newNode = this.allTextNode[a].cloneNode(true);
				tagNode.appendChild(newNode)
			} else {
				var newString = this.allTextNode[a].nodeValue;
				var reg = /[，。！？；、：]/;
				if (reg.exec(newString) == null) {
					tagNode.setAttribute("class", "getmessage");
					tagNode.innerHTML = newString
				} else {
					tagNode.setAttribute("class", "getmainmessage");
					tagNode.innerHTML = this.mySplit(newString, /[，。！？；、：]/)
				}
			}
			if (this.allTextNode[a].parentNode) {
				this.allTextNode[a].parentNode.insertBefore(tagNode, this.allTextNode[a])
			}
		}
		for (var b = 0; b < this.allTextNode.length; b++) {
			this.allTextNode[b].parentNode.removeChild(this.allTextNode[b])
		}
		var allOption = getE.container.getElementsByTagName("option");
		for (var c = 0; c < allOption.length; c++) {
			var thisMessage = allOption[c].firstChild.cloneNode(true);
			allOption[c].innerHTML = "";
			allOption[c].appendChild(thisMessage)
		}
		this.firstRun = true
	},
	trim: function(str) {
		return str.replace(/(^\s*)|(\s*$)/g, "")
	},
	mySplit: function(str, reg) {
		var result, x = str,
		y, zzz = true;
		var stringArray = new Array();
		do {
			result = reg.exec(x);
			if (result != null) {
				var stringIndex = result.index;
				stringArray.push(x.substring(0, stringIndex + 1));
				x = x.substring(stringIndex + 1)
			} else {
				stringArray.push(x);
				zzz = false
			}
		} while ( zzz ) var yy = "<span class=\"getmessage\">";
		for (var a = 0; a < stringArray.length; a++) {
			yy += (a < stringArray.length - 1) ? (stringArray[a] + "</span><span class=\"getmessage\">") : (stringArray[a])
		}
		yy += "</span>";
		return yy
	},
	getText: function() {
		if (!document.getElementById("gettextmessagecontent")) {
			return
		}
		var messagebox = document.getElementById("gettextmessagecontent");
		var textMessage = "";
		if (this.firstChild.nodeName == "IMG") {
			if (this.parentNode.parentNode.nodeName == "A" || this.parentNode.nodeName == "A") {
				textMessage = "图片链接：" + getText(this.firstChild)
			} else {
				textMessage = "图片：" + getText(this.firstChild)
			}
		} else if (this.firstChild.nodeName == "OBJECT") {
			textMessage = "媒体：" + this.firstChild.getAttribute("title")
		} else if (this.firstChild.nodeName == "SELECT") {
			textMessage = "下拉菜单"
		} else if (this.firstChild.nodeName == "INPUT") {
			var inputType = this.firstChild.getAttribute("type");
			switch (inputType) {
			case "button":
				textMessage = "表单按钮：" + this.firstChild.getAttribute("value");
				break;
			case "image":
				textMessage = "图形按钮：" + this.firstChild.getAttribute("alt");
				break;
			case "submit":
				textMessage = "提交按钮：" + this.firstChild.getAttribute("value");
				break;
			case "reset":
				textMessage = "重置按钮：" + this.firstChild.getAttribute("value");
				break;
			case "file":
				textMessage = "文件域：" + this.firstChild.getAttribute("title");
				break;
			case "password":
				textMessage = "密码域：" + this.firstChild.getAttribute("title");
				break;
			case "radio":
				textMessage = "单选框：" + this.firstChild.getAttribute("title");
				break;
			case "checkbox":
				textMessage = "复选框：" + this.firstChild.getAttribute("title");
				break;
			case "text":
				textMessage = "文本域：" + this.firstChild.getAttribute("title");
				break
			}
		} else if (this.parentNode.parentNode.nodeName == "A" || this.parentNode.nodeName == "A") {
			var thisContent;
			if (this.parentNode.parentNode.nodeName == "A") {
				if (this.parentNode.parentNode.getAttribute("title")) {
					thisContent = this.parentNode.parentNode.getAttribute("title")
				} else {
					thisContent = this.innerText || this.textContent
				}
			} else if (this.parentNode.nodeName == "A") {
				if (this.parentNode.getAttribute("title")) {
					thisContent = this.parentNode.getAttribute("title")
				} else {
					thisContent = this.innerText || this.textContent
				}
			}
			textMessage = "链接：" + thisContent
		} else if (this.parentNode.nodeName == "H1" || this.parentNode.nodeName == "H2" || this.parentNode.nodeName == "H3" || this.parentNode.nodeName == "H4" || this.parentNode.nodeName == "H5" || this.parentNode.nodeName == "H6") {
			var thisContent = this.innerText || this.textContent;
			textMessage = "标题：" + thisContent
		} else {
			var thisContent = this.innerText || this.textContent;
			textMessage = "文本：" + thisContent
		}
		var messageboxWidth = messagebox.offsetWidth;
		var fontRatio = messageboxWidth / textMessage.length;
		if (fontRatio < 30) {
			if (fontRatio > 18) {
				messagebox.style.fontSize = parseInt(fontRatio) + "px";
				messagebox.style.lineHeight = parseInt(fontRatio) + "px"
			}
			if (fontRatio < 10) {
				messagebox.style.fontSize = parseInt(fontRatio * 2) + "px";
				messagebox.style.lineHeight = parseInt(fontRatio * 2) + "px"
			}
		} else {
			messagebox.style.fontSize = ""
		}
		if (toolbar.Function.textTips.pinyinState) {
			textMessage = toolbar.Function.textTips.pinyinText(textMessage)
		}
		messagebox.innerHTML = textMessage;
		textMessage = "";
		if (toolbar.Function.textTips.textbgState) {
			this.style.backgroundColor = "#F00";
			this.style.color = "#FFF"
		}
	},
	pinyinText: function(text) {
		var messayArray = text.split("");
		var newString = "";
		for (var a = 0; a < messayArray.length; a++) {
			var testVar = "";
			if (pinyin[messayArray[a]]) {
				testVar = pinyin[messayArray[a]]
			} else {
				testVar = "&nbsp;"
			}
			if (messayArray[a] == " ") {
				messayArray[a] = "&nbsp;"
			}
			newString += "<span>" + messayArray[a] + "<sup>" + testVar + "</sup></span>"
		}
		return newString
	},
	getEvent: function() {
		var allSpan = getE.container.getElementsByTagName("span");
		for (var c = 0; c < allSpan.length; c++) {
			if (allSpan[c].getAttribute("class") == "getmessage") {
				allSpan[c].onmouseover = this.getText;
				allSpan[c].onmouseout = this.clearTextbg
			}
		}
	},
	pinyinControl: function() {
		this.pinyinState = this.pinyinState ? false: true;
		if (this.pinyinState) {
			document.getElementById("pinyinbuttonbox").firstChild.innerHTML = "关闭拼音功能"
		} else {
			document.getElementById("pinyinbuttonbox").firstChild.innerHTML = "开启拼音功能"
		}
	},
	firstRun: false,
	textbgState: false,
	textbg: function() {
		this.textbgState = this.textbgState ? false: true;
		document.getElementById("textbgbuttonbox").getElementsByTagName("a")[0].innerHTML = this.textbgState ? "关闭标记功能": "开启标记功能"
	},
	clearTextbg: function() {
		this.style.backgroundColor = "";
		this.style.color = ""
	},
	mainMethod: function() {
		if (!ABTConfig.textTips.functionSwitch || getE.error) {
			return
		};
		if (!this.textGetState) {
			var newMessageBox = document.createElement("div");
			newMessageBox.setAttribute("id", "gettextmessagebox");
			newMessageBox.innerHTML = "<div id=\"closetextmessagebox\"><a href=\"javascript:\" onclick=\"toolbar.Function.textTips.mainMethod()\"></a></div><div id=\"textbgbuttonbox\"><a href=\"javascript:\" onclick=\"toolbar.Function.textTips.textbg()\">开启标记功能</a></div><div id=\"pinyinbuttonbox\"><a href=\"javascript:\" onclick=\"toolbar.Function.textTips.pinyinControl()\">开启拼音功能</a></div><div id=\"gettextmessagecontent\"></div>";
			document.body.insertBefore(newMessageBox, getE.container);
			document.body.style.paddingBottom = 140 + "px";
			document.getElementById("pinyinbuttonbox").firstChild.focus();
			this.getTextNode(getE.container);
			this.AddTag();
			this.getEvent();
			this.textGetState = true
		} else {
			document.body.removeChild(document.getElementById("gettextmessagebox"));
			document.body.style.paddingBottom = 0 + "px";
			this.textGetState = false
		}
		toolbar.cookie.setCookie(this.cookieName, this.textGetState ? 1 : 0)
	}
}
toolbar.Function.help = {
	showHTML: function() {
		if (ABTConfig.help.functionSwitch) {
			return "<input id=\"ABTHelpbutton\" type=\"button\" value=\"帮助\" title=\"帮助\" onclick=\"toolbar.Function.help.mainMethod()\" />"
		} else {
			return ""
		}
	},
	helpBoxState: false,
	mainMethod: function() {
		if (!ABTConfig.help.functionSwitch) {
			return
		};
		if (!this.helpBoxState) {
			var newHelpBox = document.createElement("div");
			newHelpBox.setAttribute("id", "abthelpbox");
			newHelpBox.innerHTML = "<div id=\"helptitle\">无障碍辅助浏览工具条</div><div id=\"helpcontent\"></div><div id=\"closehelpbox\"><a href=\"javascript:\" onclick=\"toolbar.Function.help.mainMethod()\" title=\"关闭帮助\"></a></div>";
			document.body.insertBefore(newHelpBox, document.body.firstChild);
			document.getElementById("helpcontent").innerHTML = "<iframe id=\"helpcontentbox\" src=\"" + URLPrefix + "helpContent.html\" frameborder=\"0\" scrolling=\"auto\" marginheight=\"0\" marginwidth=\"0\" title=\"帮助内容\"></iframe>";
			this.helpBoxState = true
		} else {
			document.body.removeChild(document.getElementById("abthelpbox"));
			this.helpBoxState = false
		}
	}
}
toolbar.Function.resetToolbar = {
	showHTML: function() {
		if (ABTConfig.resetToolbar.functionSwitch) {
			return "<input id=\"resetbutton\" type=\"button\" value=\"重置\" title=\"重置\" onclick=\"toolbar.Function.resetToolbar.mainMethod()\" />"
		} else {
			return ""
		}
	},
	mainMethod: function() {
		if (!ABTConfig.resetToolbar.functionSwitch) {
			return
		};
		for (var a in toolbar.Function) {
			try {
				toolbar.Function[a].resetCookie()
			} catch(e) {}
		};
		window.location.reload()
	}
}
toolbar.Function.show = {
	showHTML: function() {
		if (ABTConfig.show.functionSwitch) {
			return "<input id=\"closetoolbar\" type=\"button\" value=\"关闭\" title=\"关闭\" onclick=\"toolbar.Function.show.mainMethod()\" />"
		} else {
			return ""
		}
	},
	keyTrigger: function(keyString) {
		var shortcuts = ABTConfig.show.keyCode;
		for (var a = 0; a < shortcuts.length; a++) {
			if (keyString == keyCodeStringHandle(shortcuts[a])) {
				toolbar.Function.show.mainMethod()
			}
		}
	},
	cookieName: "toolbarState",
	cookieMethod: function() {
		if (ABTConfig.show.cookieSwtich && toolbar.cookie.getCookie(this.cookieName) == 1) {
			toolbar.Function.show.mainMethod()
		}
	},
	resetCookie: function() {
		toolbar.cookie.setCookie(this.cookieName, 1)
	},
	toolbarState: false,
	mainMethod: function() {
		if (!ABTConfig.show.functionSwitch) {
			return;
		};
		if (!this.toolbarState) {
			if (!document.getElementById("nobarStyle")) {
				var toolbarStyleElement = document.createElement("link");
				toolbarStyleElement.setAttribute("rel", "stylesheet");
				toolbarStyleElement.setAttribute("type", "text/css");
				toolbarStyleElement.setAttribute("id", "nobarStyle");
				toolbarStyleElement.setAttribute("href", URLPrefix + "skins/" + ABTConfig.skin[toolbar.skin].folder + "/skin.css");
				document.getElementsByTagName("head")[0].appendChild(toolbarStyleElement)
			}
			var toolbarHTML = "";
			for (var a in toolbar.Function) {
				try {
					toolbarHTML = toolbarHTML + toolbar.Function[a].showHTML()
				} catch(e) {}
			};
			var newToolbar = document.createElement("div");
			newToolbar.setAttribute("id", "ABTToolbar");
			newToolbar.innerHTML = toolbarHTML;
			document.body.insertBefore(newToolbar, document.body.firstChild);
			var toobarHeight = document.getElementById("ABTToolbar").offsetHeight;
			toobarHeight = toobarHeight > (ABTConfig.skin[toolbar.skin].bodyPadding * 2.1) ? toobarHeight: ABTConfig.skin[toolbar.skin].bodyPadding;
			document.body.style.paddingTop = toobarHeight + "px";
			document.body.style.backgroundPosition = "center " + toobarHeight + "px";
			skipElementBuild(document.getElementById("ABTToolbar").firstChild, "无障碍辅助工具条已开启");
			this.toolbarState = true
		} else {
			document.body.removeChild(document.getElementById("ABTToolbar"));
			document.body.style.paddingTop = "0px";
			document.body.style.backgroundPosition = "center top";
			skipElementBuild(document.body.firstChild, "无障碍辅助工具条已关闭");
			this.toolbarState = false
		}
		toolbar.cookie.setCookie(this.cookieName, this.toolbarState ? 1 : 0)
	}
}