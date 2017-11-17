//转换加密函数
function Encryption(YciwufkO1, $zqnKwNP2) {
    var FFDYb3 = hex_md5($zqnKwNP2 + YciwufkO1) + "\x26" + YciwufkO1 + "\x26" + hex_md5(YciwufkO1 + $zqnKwNP2);
    return FFDYb3;
}

//生成随机数
function Random() {
    var myrandom = Math.round(Math.random() * 100000)
    return myrandom;
}

//去空格
String.prototype.trim = function () { return this.replace(/(^\s*)|(\s*$)/g, ""); }

//获取URL的传值参数
function GetUrlParameter(paramName) {
    var returnVal = "";
    try {
        var paramUrl = window.location.search;

        //处理长度
        if (paramUrl.length > 0) {
            paramUrl = paramUrl.substring(1, paramUrl.length);
            var paramUrlArray = paramUrl.split("&");
            for (var i = 0; i < paramUrlArray.length; i++) {
                if (paramUrlArray[i].toLowerCase().indexOf(paramName.toLowerCase()) != -1) {
                    var temp = paramUrlArray[i].split("=");
                    if (temp[0].toLowerCase() == paramName.toLowerCase()) {
                        returnVal = temp[1];
                        break;
                    }
                }
            }
        }
    }
    catch (e) { }
    return returnVal;
}

//权限控制
function quxnfunsend(strs) {
    var st = strs.split('&');
    for (var i = 0; i <= st.length - 2; i++) {
        var hu = st[i].split('|');
        if (hu[1].trim() == "0") {
            $("#" + hu[0]).linkbutton('enable');
        } else if (hu[1].trim() == "1") {
            $("#" + hu[0]).show();
        }
    }
}

//获取图片地址
function GetImgSrc(OriginalImgSrc, defaultImgSrc) {
    var newImgSrc = "";

    if (OriginalImgSrc != undefined && OriginalImgSrc != defaultImgSrc && OriginalImgSrc != "") {
        var strs = OriginalImgSrc.split("/");
        var i = strs.length - 1;
        if (strs[i] != "") {
            if (strs[i - 1] == "Old") {
                newImgSrc = "Old/" + strs[i];
            }
            else {
                newImgSrc = strs[i - 2] + "/" + strs[i - 1] + "/" + strs[i];
            }
        }
    }
    return newImgSrc;
}

//登录超时弹窗
function AlertTimeOutMsg() {
    $.messager.alert('系统提示', '超时了，请重新登录！', 'warning', function () {
        window.location.href = "/";
    });
}

//获取当前日期（格式：yyyy-MM-dd）
function myformatter(date) {
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    var d = date.getDate();
    return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
}

//讲字符串日期格式转换为日期格式
function myparser(s) {
    if (!s) {
        return new Date();
    }
    var ss = s.split('-');
    var y = parseInt(ss[0], 10);
    var m = parseInt(ss[1], 10);
    var d = parseInt(ss[2], 10);
    if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
        return new Date(y, m - 1, d);
    } else {
        return new Date();
    }
}

//将日期格式转换成字符串日期格式（格式：yyyy-MM-dd）
function TimeParser(time) {
    if (time == undefined || time == null || time == "") {
        return "";
    }

    var date = new Date();
    date.setTime(time.substr(6, time.length - 8));

    var month = (date.getMonth() + 1).toString();
    if (month.length == 1) {
        month = "0" + month;
    }

    var day = date.getDate().toString();
    if (day.length == 1) {
        day = "0" + day;
    }

    return date.getFullYear() + "-" + month + "-" + day;
}

//将日期格式转换成字符串日期格式（格式：yyyy-MM-dd hh:mm:ss）
function TimeParserDetail(time) {
    if (time == undefined || time == null || time == "") {
        return "";
    }

    var date = new Date();
    date.setTime(time.substr(6, time.length - 8));

    var month = (date.getMonth() + 1).toString();
    if (month.length == 1) {
        month = "0" + month;
    }

    var day = date.getDate().toString();
    if (day.length == 1) {
        day = "0" + day;
    }

    var hour = date.getHours().toString();
    if (hour.length == 1) {
        hour = "0" + hour;
    }

    var minute = date.getMinutes().toString();
    if (minute.length == 1) {
        minute = "0" + minute;
    }

    var second = date.getSeconds().toString();
    if (second.length == 1) {
        second = "0" + second;
    }

    return date.getFullYear() + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
}

//加载编辑器
function LoadEditor(textareaName, editor) {
    KindEditor.ready(function (K) {
        this[editor] = K.create(textareaName, {
            allowFileManager: true,
            langType: "zh_CN",
            urlType: "domain",
            //uploadJson: '/keditorupload?UploadDir=EditorFiles',
            uploadJson: '/keditorupload',
            afterUpload: function (fileName, response) {
            	console.log("fileName",fileName);
            	console.log("response",response);
                if (response.error != 0) {
                    alert("test:"+response.message);
                }
            },
            items: [
                'source', '|', 'preview', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
                'justifyfull', '|', 'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
                'italic', 'underline', '|', 'image', 'multiimage', 'media', 'table', 'hr', 'baidumap',
                'link', 'unlink', '|', 'fullscreen']
        });
    });
}


//加载服务分类（大类）
function LoadClass() {
    $.post("/sclassList", { pclassid: 0 }, function (data) {
        var htmlstr = "";
        for (var i = 0; i < data.length; i++) {
            htmlstr += "<option value=\"" + data[i].id + "\">" + data[i].title + "</option>";
        }
        $("#Superclass").html(htmlstr);
        $("#Subclass").html("<option value=\"0\" >--请选择二级类--</option>")
    });
}


//检查用户是否登录
function CheckSession(type) {
    $.post("/checkSession", function (result) {
    	console.log("session",result);
        if (result.success == false) {
        	 window.location.href = "http://account.smeym.org/logout?service=http://sp.smeym.org/cas";
            //$("#hdnLoginStatus").val("OFF");
        } 
    });
}

//退出
function logout(){
	window.location.href = "http://account.smeym.org/logout?service=http://sp.smeym.org/cas";
}
