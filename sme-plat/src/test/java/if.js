var MEAP = require("meap");
var fs = require("fs");

function run(Param, Robot, Request, Response, IF) {
	var filename = Param.params.filename ? Param.params.filename : 'Csharp.doc';
	var fileBuffer = fs.readFileSync('D:\\Csharp.doc'); //需要加文件路径 读取后是个buffer文件
	var name = Param.params.name ? Param.params.name : '测试1';
	var option = {
		method : "POST",
		url : kgOAURL + "/general/email/new/submit.php",

		Headers : {
			'Accept' : 'text/html, application/xhtml+xml, */*',
			'Referer' : 'http://10.209.19.151/general/email/new/',
			'Accept-Language' : 'zh-CN',
			'User-Agent' : 'Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)',
			'Content-Type' : 'multipart/form-data; boundary=---------------------------7df2841f15005e;charset=utf-8',
			'Accept-Encoding' : 'gzip, deflate',
			/** 'Content-Length' : '3871', **/
			'Connection' : 'Keep-Alive',
			'Cache-Control' : 'no-cache'
		},
		Body : {
			ASC_DESC : '',
			BODY_ID : '',
			BOX_ID : '',
			BTN_CLOSE : '',
			COPY_TIME : '',
			COPY_TO_ID : '',
			COPY_TO_NAME : '',
			COPY_TO_WEBMAIL : '',
			DISK_ID : '',
			EMAIL_ID : '',
			FIELD : '',
			FROM : '',
			FROM_FLAG : '',
			FW : '',
			IMPORTANT : '',
			ISUPDATE : '',
			IS_F : '',
			IS_R : '',
			OP : '',
			RECENT_LINKMAN : '',
			REPLAY : '',
			SECRET_LEVEL : '',
			SECRET_TO_ID : '',
			SECRET_TO_NAME : '',
			SECRET_TO_WEBMAIL : '',
			SEND_FLAG : 1,
			SUBJECT : encodeURI('测试邮件'),
			TD_HTML_EDITOR_CONTENT : encodeURI('邮件测试内容'),
			TO_ID : encodeURI(name),
			TO_NAME : encodeURI(name),
			TO_WEBMAIL : '',
			ATTACHMENT_1000 : '',
			ATTACHMENT_ID_OLD : '',
			ATTACHMENT_NAME_OLD : '',
			ATTACH_NAME : '',
			ATTACH_DIR : '',
			ATTACHMENT_0 : ''
		},
		Enctype : "multipart/form-data",
		Cookie : "true"
	};

	MEAP.AJAX.Runner(option, function(err, res, data) {
		if (!err) {
			Response.setHeader('Content-Type', 'text/html; charset=utf8');
			if (data.indexOf('成功') > -1) {
				Response.end(JSON.stringify({
					"rtState" : "0",
					"rtMsrg" : "邮件发送成功"
				}));
			} else {
				Response.end(JSON.stringify({
					"rtState" : "-1",
					"rtMsrg" : "邮件发送失败"
				}));
			}
		} else {
			//Add your exception handling code 
		}
	}, Robot, function(des) {
		if (des.indexOf('请重新登录') > -1) {
			Response.end(JSON.stringify({
				"rtState" : "-1",
				"rtMsrg" : "请重新登录"
			}));
			return;
		}
		LOG(option)
		return des;
	});
}

exports.Runner = run;
