(function (a) {
    window.jUploader = a.jUploader = function (b) {
        b = a.extend({},
        a.jUploader.defaults, b);
        b.id = a.jUploader.createId();
        b.uploading = false;
        b.action = b.action + b.dir + "&dir=" + b.fileExtend + "&width=" + b.width + "&height=" + b.height;
        var k = function () {
            b.button = typeof b.button == "string" ? a("#" + b.button) : a(b.button);
            b.button.css({
                cursor: "pointer",
                position: "relative",
                overflow: "hidden",
                direction: "ltr"
            }).addClass("jUploader-button").bind("mouseover",
            function () {
                a(this).addClass("jUploader-button-hover")
            }).bind("mouseout",
            function () {
                a(this).removeClass("jUploader-button-hover")
            }).children("span").text(b.messages.upload);
            b.cancelable && b.button.bind("click", m);
            b.button.append(c());
            return b.button
        },
        h = function () {
        	alert("TEST_H");
            var c = "jUploaderIframe" + b.id,
            d = a('<iframe id="' + c + '" name="' + c + '" src="javascript:false;" style="display:none"></iframe>').bind("load", l);
            return d
        },
        j = function () {
        	alert("TEST_J");
            var c = "jUploaderForm" + b.id,
            d = a('<form id="' + c + '" name="' + c + '" action="' + b.action + '" target="jUploaderIframe' + b.id + '" method="post" enctype="multipart/form-data" style="display:none"></form>');
            return d
        },
        x = function () {
        	alert("TEST_x="+$("#hdnDomain").val());
            d = a('<script>document.domain="' + $("#hdnDomain").val() + '";</script>');
            return d
        },
        c = function () {
        	console.log("TEST_C");
            var c = a('<input type="file" onchange="this.blur();" />');
            c.attr("id", "jUploader-file" + b.id).attr("name", "jUploaderFile").css({
                position: "absolute",
                right: 0,
                top: 0,
                margin: 0,
                opacity: 0,
                padding: 0,
                fontFamily: "Arial",
                fontSize: "118px",
                verticalAlign: "baseline",
                cursor: "pointer"
            }).bind("change",
            function () {
                b.fileName = d(this);
                i(this) && n()
            });
            window.attachEvent && c.attr("tabIndex", "-1");
            return c
        },
        i = function (b) {
            var a = d(b);
            if (!f(a)) {
                e("invalidExtension", a);
                return false
            } else if (a == "") {
                e("emptyFile", a);
                return false
            }
            return true
        },
        d = function (a) {
            return a.value.replace(/.*(\/|\\)/, "")
        },
        g = function (a) {
            if (a.length > 33) a = a.slice(0, 19) + "..." + a.slice(-13);
            return a
        },
        f = function (c) {
            //var d = -1 !== c.indexOf(".") ? c.replace(/.*[.]/, "").toLowerCase() : "";
            //if (!b.allowedExtensions.length) return true;
            //for (var a = 0; a < b.allowedExtensions.length; a++) if (b.allowedExtensions[a].toLowerCase() == d) return true;
            //return false
            return true;
        },
        e = function (d, a) {
            var c = b.messages[d].replace("{file}", g(a)).replace("{extensions}", b.allowedExtensions.join(", "));
            b.showMessage(c)
        },
        o = function (a) {
            b.debug && window.console && console.log("[jUploader] " + a)
        },
        n = function () {
        	alert("TEST_N");
            b.uploading = true;
            b.onUpload(b.fileName);
            a(document.body).append(h()).append(j());//.append(x());
            a("#jUploader-file" + b.id).attr("id", "jUploader-file-uploading" + b.id).appendTo("#jUploaderForm" + b.id);
            b.button.append(c().hide());
            b.cancelable && b.button.children("span").text(b.messages.cancel);
            a("#jUploaderForm" + b.id).get(0).submit()
        },
        m = function () {
            if (b.uploading) {
                b.uploading = false;
                b.onCancel(b.fileName);
                b.button.children("span").text(b.messages.upload);
                a("#jUploaderForm" + b.id).remove();
                a("#jUploaderIframe" + b.id).attr("src", "javascript:false;").remove();
                a("#jUploader-file" + b.id).show();
            }
        },
        l = function () {
            var c = a("#jUploaderIframe" + b.id).get(0);
            if (!c.parentNode) return;
            if (c.contentDocument && c.contentDocument.body && c.contentDocument.body.innerHTML == "false" || c.contentWindow.document && c.contentWindow.document.body && c.contentWindow.document.body.innerHTML == "false") return;
            var e = c.contentDocument ? c.contentDocument : c.contentWindow.document,
            d;
            if (e.body.innerHTML == "") return;
            b.uploading = false;
            a("#jUploader-file" + b.id).show();
            b.button.children("span").text(b.messages.upload);
            o("innerHTML = " + e.body.innerHTML);
            try {
                var f = e.body.innerHTML.replace(/<pre>(.*)<\/pre>/g, "$1");
                alert(f);
                d = eval("(" + f + ")")
            } catch (g) {
                d = {}
            }
            setTimeout(function () {
                a("#jUploaderForm" + b.id).remove();
                a("#jUploaderIframe" + b.id).remove()
            },
            10);
            
            console.log("b.fileName",b.fileName);
            console.log("d",d);
            b.onComplete(b.fileName, d);
        };
        a(window).bind("beforeunload",
        function (a) {
            if (!b.uploading) return;
            var a = a || window.event;
            a.returnValue = b.messages.onLeave;
            return b.messages.onLeave
        });
        return k()
    };
    a.jUploader.version = 1;
    a.jUploader.defaults = {
        button: null,
        action: "/uploadfile?UploadDir=",
        dir: "Test",
        fileExtend: "image",
        width: 0,
        height: 0,
        allowedExtensions: ["jpg", "png", "gif", "jpeg", "bmp"],
        cancelable: true,
        onUpload: function () { },
        onComplete: function () {
        	console.log("onComplete");
        },
        onCancel: function () { },
        messages: {
            upload: "上传",
            cancel: "取消",
            emptyFile: "{file} 为空，请选择一个文件.",
            invalidExtension: "{file} 后缀名不合法. 只有 {extensions} 是允许的.",
            onLeave: "文件正在上传，如果你现在离开，上传将会被取消。"
        },
        showMessage: function (a) {
            alert("test:"+a);
        },
        debug: true
    };
    a.jUploader.setDefaults = function (b) {
        a.jUploader.defaults = a.extend({},
        a.jUploader.defaults, b);
    };
    a.jUploader.createId = function () {
        var a = 0;
        return function () {
            return ++a;
        }
    } ();
})(jQuery)