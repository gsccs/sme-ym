var editor;

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
                htmlstr = "<option value=\"\" selected>--请选择区县--</option>";
            }
            for (var i = 0; i < objs.length; i++) {
                htmlstr += "<option value=\"" + objs[i].code + "\">" + objs[i].name + "</option>";
            }
            $("#arean").html(htmlstr);
        }
    });
}

//显示荣誉资质描述文本框
function ShowRyzzDetail(target) {
    $("#txtActiImgDetail").show();
    $("#txtActiImgDetail").focus();
    if ($(target).html().trim() != "点击编辑...") {
        $("#txtActiImgDetail").val($(target).html());
    }
    else {
        $("#txtActiImgDetail").val("");
    }
    $("#txtActiImgDetail").css("top", $(target).position().top + 1);
    $("#txtActiImgDetail").css("left", $(target).position().left);
    $(target).attr("rel", "ryzzFocus");
}

//荣誉资质描述文本框焦点离开
function BlurRyzzDetail(target) {
    $(target).hide();
    if ($(target).val() != '') {
        $("p[rel=ryzzFocus]").html($(target).val());
        $("#txtActiImgDetail").val("");
    }
    else {
        $("p[rel=ryzzFocus]").html("点击编辑...");
        $("#txtActiImgDetail").val("");
    }
    $(".ryzzIntro").removeAttr("rel");
}

//编辑企业产品
function EditOrgProduct() {
    //获取提交数据
    var postData = GetPostData();
    if (postData == false) {
        return;
    }

    $.ajax({
        url: "/cp/product/edit",
        type: "POST",
        data: postData,
        traditional: true,
        success: function (result) {
            if (result.success == true) {
                $.messager.alert('系统提示', result.Msg, 'info', function () {
                    window.location.href = "/EntpAdmin/Product/Index";
                });
            } else {
                switch (result.Data) {
                    case 1:
                        $.messager.alert('系统提示', result.Msg, 'warning', function () {
                            RedirectLogin("Entp");
                        });
                        break;
                    case 2:
                    case 3:
                    case 4:
                        $.messager.alert('系统提示', result.Msg, 'warning');
                        break;
                    default:
                        break;
                }
            }
        }
    });
}


function DelProduct(id) {
    if (confirm("确定删除改产品吗？")) {
        $.post("/cp/product/delete", { id: id }, function (result) {
            if (result.Result == false) {
                $.messager.alert('系统提示', result.Msg, 'warning');
            } else {
                window.location.href = "/cp/product/list";
            }
        });
    }
}

function RepNumber(obj) {
    obj.value = obj.value.replace(/[^\d.]/g, "");  //清除“数字”和“.”以外的字符
    obj.value = obj.value.replace(/^\./g, "");  //验证第一个字符是数字而不是.
    obj.value = obj.value.replace(/\.{2,}/g, "."); //只保留第一个. 清除多余的.
    obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
}

//获取提交数据
function GetPostData() {

    var PrdtName = $("#txtPrdtName").val();
    if (PrdtName == undefined || PrdtName == "") {
        $("#dvMsg").html("请填写产品名称");
        $("#txtPrdtName").focus();
        PopMsg($("#txtPrdtName"));
        return false;
    }

    var TypeId = $("#selType").val();
    if (TypeId == undefined || TypeId == "") {
        $("#dvMsg").html("请选择产品分类");
        $("#selType").focus();
        PopMsg($("#selType"));
        return false;
    }

    var Price = $("#txtPrice").val();
    if (Price == undefined || Price == "") {
        $("#dvMsg").html("请填写产品价格");
        $("#txtPrice").focus();
        PopMsg($("#txtPrice"));
        return false;
    }

    var Unit = $("#txtUnit").val();
    if (Unit == undefined || Unit == "") {
        $("#dvMsg").html("请填写产品单位");
        $("#txtUnit").focus();
        PopMsg($("#txtUnit"));
        return false;
    }

    var AreaCode = $("#arean").val();
    if (AreaCode == undefined || AreaCode == "" || AreaCode == "0") {
        $("#dvMsg").html("请选择所在区域");
        $("#arean").focus();
        PopMsg($("#arean"));
        return false;
    }

    var id = $("#hdnOrgPrdtId").val();
    var PrdtDetail = editor.html();
    var PrdtSpec = $("#txtSpec").val();

    var idlist = new Array();
    var imglist = new Array();
    var titlelist = new Array();
    $("#ryzzImgList li").each(function () {
        idlist.push($(this).find("img").attr("alt"));
        imglist.push(GetImgSrc($(this).find("img").attr("src"), "/UploadFiles/OrgProduct/"));
        var pDetail = $(this).find("p").html().trim();
        if (pDetail == "点击编辑...") {
            titlelist.push("");
        }
        else {
            titlelist.push(pDetail);
        }
    });

    var postData = {
        id: id,
        title: PrdtName,
        cateid: TypeId,
        price: Price,
        unit: Unit,
        //PrdtSpec: PrdtSpec,
        areacode: AreaCode,
        //idlist: idlist,
        //imglist: imglist,
        //titlelist: titlelist,
        desc: PrdtDetail
    };
    return postData;
}

function PopMsg(obj) {
    $("#dvMsg").css("top", $(obj)[0].offsetTop + 2 + "px");
    $("#dvMsg").css("left", $(obj)[0].offsetLeft + $(obj)[0].clientWidth + 20 + "px");

    $("#dvMsg").fadeIn();
    setTimeout('$("#dvMsg").fadeOut();', 2000);
}