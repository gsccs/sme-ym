var editor;
var editor01;

$(function () {
    LoadEditor("#Org_Introduce", "editor");
    LoadEditor("#Honor", "editor01");

    //异步方式加载上传js
    $.getScript('/resources/home/js/jquery.jUploader-1.0.js?t=2015063001', function () {
        for (var i = 0; i < 2; i++) { CreateUploadImg(i); }
    });
});


//城市加载
function loadcity() {
    $.ajax({
        type: 'POST',
        url: '/areaList',
        data: { parid: $("#Province").val() },
        dataType: "json",
        success: function (json) {
        	console.log("areaList",json);
            var objs = json;
            var htmlstr = "";
            if (objs.length == 0) {
                htmlstr = "<option value=\"0\" selected>选择城市</option>";
            }
            for (var i = 0; i < objs.length; i++) {
                htmlstr += "<option value=\"" + objs[i].code + "\">" + objs[i].name + "</option>";
            }
            $("#city").html(htmlstr);
            $.ajax({
                type: 'POST',
                url: '/areaList',
                data: { parid: objs[0].code },
                dataType: "json",
                success: function (json) {
                    var objs = json;
                    var htmlstr = "";
                    if (objs.length == 0) {
                        htmlstr = "<option value=\"0\" selected>选择区县</option>";
                    }
                    for (var i = 0; i < objs.length; i++) {
                        htmlstr += "<option value=\"" + objs[i].code + "\">" + objs[i].name + "</option>";
                    }
                    $("#arean").html(htmlstr);
                }
            });
        }
    });
}


//加载区县
function LoadArea() {
    $.ajax({
        type: 'POST',
        url: '/areaList',
        data: { parid: $("#city").val() },
        dataType: "json",
        success: function (json) {
            var objs = json;
            var htmlstr = "";
            if (objs.length == 0) {
                htmlstr = "<option value=\"0\" selected>选择区县</option>";
            }
            for (var i = 0; i < objs.length; i++) {
                htmlstr += "<option value=\"" + objs[i].code + "\">" + objs[i].name + "</option>";
            }
            $("#arean").html(htmlstr);
        }
    });
}


//创建上传按键
function CreateUploadImg(i) {
    $('#imgtip' + (i + 1)).hide();
    $.jUploader({
        button: "UploadImg" + (i + 1),
        dir: "Enterprise",
        width: "1000",
        height: "1000",
        messages: { upload: '上传新图片' },
        onUpload: function (fileName) {
            $('#imgtip' + (i + 1)).show();
        },
        onComplete: function (fileName, response) {
            if (response.error == 0) {
                $('#ImagePath' + (i + 1)).val(response.url);
                $('#imagesobj' + (i + 1)).attr("src", response.url);
                $('#imgtip' + (i + 1)).hide();
            } else {
                alert(response.message);
            }
        }
    });
}
//单位性质控制单选按钮
function Radiolist1(id) {
    for (var i = 1; i <= 5; i++) {
        $("#Radio" + i).attr("checked", false);
    }
    if (id == "Radio4") {
        $("#divzzjg").hide();
        regid(2); //验证工商
    }
    else {
        $("#divzzjg").show();
        regid(1); //验证组织机构
    }

    //（如果单位性质是企业，则该项为必填注册类型）
    if (id == "Radio1") {
        //加验证
        $("#REGISTER_TYPE").combotree({
            url: 'RegistrationType',
            required: true
        });
    }
    else {
        //去验证
        $("#REGISTER_TYPE").combotree({
            url: 'RegistrationType',
            required: false
        });
    }
    $("#" + id).attr("checked", true);
}
//验证工商号或组织机构代码
function regid(st) {
    switch (st) {
        case 1:
            //加验证
            $("#ORG_CODE").validatebox({
                required: true,
                validType: 'minLength[10]'
            });
            break;
        case 2:
            //加验证
            $("#ORG_CODE").validatebox({
                required: false
            });
            break;
        default:
            break;
    }
}
//提交
function SubmitCallback(check) {
    if (check != "0") {
        if (!$("#Qualification").form('validate')) {
            return false;
        }

//        if ($("#ImagePath1").val() == undefined || $("#ImagePath1").val() == "") {
//            $.messager.alert('系统提示', '请上传企业LOGO图片！', 'warning');
//            return false;
//        }
    }
    var params = $("#Qualification").serializeArray();
    for (var pn = 0; pn < params.length; pn++) {
        if (params[pn].name == 'Org_Introduce') {
            params[pn].value = editor.html();
        } else if (params[pn].name == 'Honor') {
            params[pn].value = editor01.html();
        }
        else {
            params[pn].value = params[pn].value;
        }
    }
    //地址
    var p = $("#Province").find("option:selected").text();
    var c = $("#city").find("option:selected").text();
    var a = $("#arean").find("option:selected").text();
    var address = p + "|" + c + "|" + a + "|" + $("#Village").val() + "||";

    params.push({ "name": "ORG_PROPERTY", "value": $('input[name="Radio"]:checked').val() }); //单位性质
    params.push({ "name": "SHARE_TYPE", "value": $('input[name="RadioKG"]:checked').val() }); //控股情况
    params.push({ "name": "ADDRESS", "value": address }); //地址
    params.push({ "name": "AREA_COUNTY", "value": $("#arean").find("option:selected").val() }); //行政区域
    params.push({ "name": "INDUSTRY_CODE", "value": $("#OPIndustryCode").find("option:selected").val() }); //行政区域
    params.push({ "name": "REGISTER_TYPE", "value": $('#REGISTER_TYPE').combotree('getValue') }); //服务机构登记注册类型
    params.push({ "name": "ServiceType", "value": $("#selSvcType").find("option:selected").val() }); //服务类别
    params.push({ "name": "PHOTO", "value": GetImgSrc($("#ImagePath1").val()) }); //服务机构LOGO图片
    params.push({ "name": "OPENED_TIME", "value": $("#yearstr").val() + "-" + $("#monystr").val() }); //开业时间

    var win = $.messager.progress({
        title: '系统提示',
        msg: '正在处理中...',
        interval: 500
    });

    $.ajax({
        url: "SubmitQualification",
        type: "POST",
        data: params,
        traditional: true,
        success: function (resstr) {
            $.messager.progress('close');
            if (resstr == "1") {
                if (check != "0") {
                    $.messager.alert('系统提示', '提交成功！', 'info', function () {
                        location.reload();
                    });
                } else {
                    $.messager.alert('系统提示', '保存成功！', 'info', function () {
                        location.reload();
                    });
                }
            }
            else {
                $.messager.alert('系统提示', '操作失败！', 'warning');
            }
        }
    });
}

function GetImgSrc(OriginalImgSrc) {
    var newImgSrc = "";

    if (OriginalImgSrc != "/UploadFiles/Enterprise/" && OriginalImgSrc != "") {
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
//行业代码选择
function Industrychoose() {
    $('#oktree').html('')
    var $win;
    $win = $('#divorkid').window({
        title: '行业代码选择器',
        width: 300,
        height: 400,
        //top: $(window).height(),
        top: 400,
        left: 550,
        shadow: true,
        modal: true,
        iconCls: 'icon-add',
        closed: true,
        minimizable: false,
        maximizable: false,
        collapsible: false
    });
    $win.window('open');
    $('#oktree').tree({
        url: 'sdtddd',
        animate: true,
        onClick: function (node) {
            if (node.id.length >= 4) {
                $("#INDUSTRY_CODE").val(node.id);
                $("#INDUSTRY_CODE").focus();
                $('#divorkid').window('close');
                $('#oktree').html('');
            }
        }
    });
}


function LoadIndustryCode() {
    $.ajax({
        type: 'POST',
        url: '/EntpAdmin/BasicInfo/GetIndustryCode',
        data: { Ic_id: $("#OPIndustryCodeList").val() },
        dataType: "json",
        success: function (json) {
            var objs = eval(json);
            var htmlstr = "";
            if (objs.length == 0) {
                htmlstr = "<option value=\"0\" selected>选择分类</option>";
            }
            for (var i = 0; i < objs.length; i++) {
                htmlstr += "<option value=\"" + objs[i].IC_Code + "\">" + objs[i].IC_CodeName + "</option>";
            }
            $("#OPIndustryCode").html(htmlstr)
        }
    });
}