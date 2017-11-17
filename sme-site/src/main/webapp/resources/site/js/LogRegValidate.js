//
function ChangeUrl(url) {
    window.location.href = url;
}

function OpenMsg() {
    $("#Msg").fadeIn();
    setTimeout("CloseMsg()", 2000);
}

function CloseMsg() {
    $("#Msg").fadeOut();
}

$(function () {
    $("#btnSubmit").click(function () {
        return CheckInput($(this).attr("data-type"));
    });

    $("input[name='SvcGuide']").change(function () {
        switch ($(this).attr("id")) {
        	case "rblCorp":
        		$("#REG_TYPE").val("C");
            	$(".rgm_intro").hide();
            	$(".rgm_intro_C").show();
            	$(".rgm_li").hide();
            	$(".rgm_li_C").show();
        		break;
            case "rblGovmt":
            	$("#REG_TYPE").val("G");
            	$(".rgm_intro").hide();
            	$(".rgm_intro_G").show();
            	$(".rgm_li").hide();
            	$(".rgm_li_G").show();
                //window.location.href = '/RegSvc/GovmtSvcRegist';
                break;
            case "rblSocial":
            	$("#REG_TYPE").val("S");
            	$(".rgm_intro").hide();
            	$(".rgm_intro_S").show();
            	$(".rgm_li").hide();
            	$(".rgm_li_S").show();
                //window.location.href = '/RegSvc/SocialSvcRegist';
                break;
            case "rblExpert":
            	$("#REG_TYPE").val("E");
            	$(".rgm_intro").hide();
            	$(".rgm_intro_E").show();
            	$(".rgm_li").hide();
            	$(".rgm_li_E").show();
                //window.location.href = '/RegExpert/ExpertRegist';
                break;
            default:
                break;
        }
    });

    $("select[name='Province']").change(function () {
        $.ajax({
            url: "GetAddr",
            type: "POST",
            data: { areaParent: $(this).val() },
            success: function (data) {
                var htmlstr = "";
                for (var i = 0; i < data.length; i++) {
                    htmlstr += "<option value=\"" + data[i].Area_Code + "\">" + data[i].Area_Name + "</option>";
                }
                $("select[name='City']").html(htmlstr)
            }
        });
    });

    //异步方式加载上传js
    $.getScript("/resources/site/js/jquery.jUploader-1.0.js", function () {
        $.jUploader({
            button: "btnUploadPic",
            dir: "Experts",
            width: "1000",
            height: "1000",
            messages: { upload: '上传新图片' },
            onComplete: function (fileName, response) {
                if (response.error == 0) {
                    $('#hdnImg').val(GetImgSrc(response.url, ""));
                    $('#expertImg').attr("src", response.url);
                } else {
                    alert(response.message);
                }
            }
        });
    });

    $("#cbProtocol").change(function () {
        if ($(this).attr("checked")) {
            $("#btnSubmit").removeAttr("disabled");
        }
        else {
            $("#btnSubmit").attr("disabled", "disabled");
        }
    });
});

//输入验证
function CheckInput(submitType) {
    var result = true;
    var msg;
    $("input:visible,select:visible,textarea:visible").each(function () {
        result = true;

        var inputType = this.type;
        var id = $(this).attr("id");
        var isRequired = $(this).attr("required");
        var regexValue = $(this).attr("pattern");
        var minLength = $(this).attr("minlength");
        var maxLength = $(this).attr("maxlength");
        var msgName = $(this).attr("data-msg-name");

        var thisValue = "";
        if (inputType == "radio" || inputType == "checkbox") {
            thisValue = $("input[name='" + this.name + "']:checked").val();
        }
        else {
            thisValue = $(this).val();
        }

        //1. 是否必填 且不能为空或缺省值
        if (isRequired == "required") {
            if (thisValue == undefined || thisValue == "") {
                if (inputType == "radio" || inputType == "checkbox") {
                    msg = "请选择" + msgName + "！";
                }
                else {
                    msg = msgName + "不能为空！";
                }
                result = false;
            }
            else if (inputType == "select-one" && thisValue == "0") {
                msg = "请选择" + msgName + "！";
                result = false;
            }
        }

        //2. 是否符合格式 属性为 regex 正则
        if (result == true && thisValue != "") {
            if (regexValue != undefined) {
                var reg = new RegExp(regexValue, "ig");
                result = reg.test(thisValue);
                if (result == false) {
                    msg = msgName + "不合法！";
                }
            }
        }

        //3. 是否符合最小长度
        if (result == true && minLength != undefined && minLength != "-1") {
            if (thisValue.length < parseInt(minLength)) {
                result = false;
                msg = msgName + "不能小于" + minLength + "位！";
            }
        }

        //4. 是否符合最大长度
        if (result == true && maxLength != undefined && maxLength != "-1") {
            if (thisValue.length > parseInt(maxLength)) {
                result = false;
                msg = msgName + "超过既定长度[" + maxLength + "]！";
            }
        }

        //5. 两次输入密码是否相同验证
        if (result == true && id == "txtConfirmPwd") {
            if ($("#txtPwd").val() != $("#txtConfirmPwd").val()) {
                result = false;
                msg = "两次输入的密码不一致！";
            }
        }

        if (result == false) {
            $(this).focus();

            if (submitType == "expert") {
                $("#Msg[rel='reg']").css("top", $(this).parent()[0].offsetTop + $(this).parent()[0].clientHeight - 30 + "px");
                $("#Msg[rel='reg']").css("left", $(this).parent()[0].offsetLeft + $(this).parent()[0].clientWidth + "px");
            }
            else if (submitType == "spExp") {
                $("#Msg[rel='reg']").css("top", $(this).parent()[0].offsetTop + $(this).parent()[0].clientHeight - 1 + "px");
                $("#Msg[rel='reg']").css("left", $(this).parent()[0].offsetLeft + $(this).parent()[0].clientWidth + 148 + "px");
            }
            else {
                $("#Msg[rel='reg']").css("top", $(this).parent()[0].offsetTop + 3 + "px");
                $("#Msg[rel='reg']").css("left", $(this).parent()[0].offsetLeft + 168 + "px");
            }
        }
        return result;
    });

    if (result == false) {
        $("#Msg").html(msg);
        OpenMsg();
    }

    return result;
}

//企业登录返回
function CallBackLoginReg(data) {
    if (data.Data == "code") {
        ChangeCode();
    }

    if (data.Result == false) {
        $("#Msg[rel='reg']").css("top", "0px");
        $("#Msg[rel='reg']").css("left", "58px");
        $("#Msg").html(data.Msg);
        OpenMsg();
    }
    else {
        if (data.Msg != "0") {
            alert(data.Msg);
        }
        window.location.href = data.Data;
    }
}

//专家信息修改返回
function CallBackExpFix(data) {
    if (data.Result == false) {
        $("#Msg[rel='reg']").css("bottom", "40px");
        $("#Msg[rel='reg']").css("left", "550px");
        $("#Msg").html(data.Msg);
        OpenMsg();
    }
    else {
        $("#Msg[rel='reg']").css("bottom", "40px");
        $("#Msg[rel='reg']").css("left", "550px");
        $("#Msg").html(data.Msg);
        OpenMsg();
        //window.location.href = data.Data;
    }
}

//验证码
function ChangeCode() {
    $("#imgCode").attr("src", "/Home/GetValidateCode?time=" + (new Date()).getTime());
}