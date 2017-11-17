var spUserId;
var ownerId;
var recommendStatus;
var orderId;
var orderNum;
var is96871;
var isTfb;
var isHlw;

function LoadProductList(pid, d, name, status, roleid, kinds, typeid, order) {
    var curRoleId = $("#hdnRoleId").val();
    var spUserIdUrl = $("#hdnSpUserId").val();
    $('#ProductList').datagrid({
        url: '/Product/ProductListJson?page=' + pid + "&rows=" + d + "&name=" + encodeURIComponent(name) + "&status=" + status +
            "&roleid=" + roleid + "&kinds=" + kinds + "&curRoleId=" + curRoleId + "&spUserId=" + spUserIdUrl + "&typeid=" + typeid + "&order=" + order,
        pagination: true,
        pageNumber: parseInt(pid),
        pageSize: 10,
        singleSelect: true,
        fitColumns: true,
        striped: true,
        //title: str,
        onDblClickRow: function (rowIndex, rowData) {
            if (rowData.id != undefined) {
                var win = $.messager.progress({
                    title: '系统提示'
                });
                var page = $('#ProductList').datagrid('getPager').data("pagination").options.pageNumber;
                window.location.href = "/Product/Detail?id=" + rowData.id + "&page=" + page + "&iRoleId=" + curRoleId + "&spUserId=" + spUserIdUrl
                    + "&name=" + name + "&status=" + status + "&roleid=" + roleid + "&kinds=" + kinds + "&typeid=" + typeid + "&order=" + order;
            }
        },
        onLoadSuccess: function (rowData) {
            $("#aSort").linkbutton("disable");
            $("#aCategory").linkbutton("disable");
        },
        onSelect: function (rowIndex, rowData) {
            if (spUserIdUrl == undefined || spUserIdUrl == null || spUserIdUrl == "") {
                orderId = rowData.id;
                if (curRoleId == 1) {
                    orderNum = rowData.OrderMain;
                } else {
                    orderNum = rowData.OrderSub;
                }

                is96871 = rowData.PropertyId;
                isTfb = rowData.IsTfb;
                isHlw = rowData.IsHlw;

                $("#aSort").linkbutton("enable");
                $("#aCategory").linkbutton("enable");
            }
        }
    }).pagination({
        pageSize: 10, //每页显示的记录条数，默认为10 
        pageList: [5, 10, 15], //可以设置每页记录条数的列表 
        beforePageText: '第', //页数文本框前显示的汉字 
        afterPageText: '页 共 {pages} 页',
        displayMsg: '当前显示 {from} - {to} 条记录 共 {total} 条记录',
        onBeforeRefresh: function () {
            $(this).pagination('loading');
            $("#aSort").linkbutton("disable");
        }
    });

    $("#aSort").linkbutton("disable");
}

//列表查询功能
function SearchProduct(pageIn) {
    var page;
    if (pageIn != undefined && pageIn != null && pageIn != "") {
        page = pageIn;
    } else {
        page = GetUrlParameter("page");
        if (page == undefined || page == null || page == "" || page == "0") {
            page = "1"
        }
    }

    LoadProductList(page, 10, $("#txtSearch").val(), $("#selStatus").val(), $("#selRole").val(), $("#selKinds").val(), $("#selType").val(), $("#selOrder").val()); //加载列表
}

//编辑排序
function ShowOrder() {
    $win = $('#dvOrder').window({
        top: 139,
        left: 567
    });
    $win.window('open');

    $("#txtOrder").numberbox('setValue', orderNum);
}

//关闭编辑排序
function CloseOrder() {
    $("#txtOrder").numberbox('setValue', '');
    $('#dvOrder').dialog('close');
}

//提交排序
function EditOrder() {
    $.post("/Product/EditOrder", { id: orderId, iOrder: $('#txtOrder').numberbox('getValue') }, function (data) {
        if (data.Result == true) {
            //$.messager.alert('系统提示', '提交成功！', 'info', function () {
                CloseOrder();
                SearchProduct();
            //});
        } else {
            $.messager.alert('系统提示', '未知原因，提交失败，请尝试重新提交！', 'warning');
        }
    });
}

//编辑分类
function ShowCategory() {
    $win = $('#dvCategory').window({
        top: 139,
        left: 461
    });
    $win.window('open');

    is96871 == 1 ? $("#chkCate1").attr("checked", "checked") : $("#chkCate1").removeAttr("checked");
    isTfb == true ? $("#chkCate2").attr("checked", "checked") : $("#chkCate2").removeAttr("checked");
    isHlw == true ? $("#chkCate3").attr("checked", "checked") : $("#chkCate3").removeAttr("checked");

    if ($("#hdnRoleId").val() == "1") {
        $("#chkCate1").removeAttr("disabled");
        $("#chkCate2").removeAttr("disabled");
        $("#chkCate3").removeAttr("disabled");
    } else {
        $("#chkCate1").attr("disabled", "disabled");
        $("#chkCate2").attr("disabled", "disabled");
        $("#chkCate3").attr("disabled", "disabled");
    }
}

//关闭编辑分类
function CloseCategory() {
    $('#dvCategory').dialog('close');
}

//提交分类
function EditCategory() {

    $("#chkCate1").attr("checked") ? is96871 = 1 : is96871 = 0;
    $("#chkCate2").attr("checked") ? isTfb = true : isTfb = false;
    $("#chkCate3").attr("checked") ? isHlw = true : isHlw = false;

    $.post("/Product/EditCategory", { id: orderId, PropertyId: is96871, IsTfb: isTfb, IsHlw: isHlw }, function (data) {
        if (data.Result == true) {
            //$.messager.alert('系统提示', '提交成功！', 'info', function () {
            CloseCategory();
            SearchProduct();
            //});
        } else {
            $.messager.alert('系统提示', '未知原因，提交失败，请尝试重新提交！', 'warning');
        }
    });
}

//加载编辑器和图片上传控件
function LoadEditAndUpload() {
    //异步方式加载上传js
    $.getScript('/Scripts/jquery.jUploader-1.0.js?t=2015063001', function () {
        $.jUploader({
            button: "uploadkj",
            dir: "Product",
            width: "1000",
            height: "1000",
            messages: { upload: '上传新图片' },
            onUpload: function (fileName) {
                $('#imgtip').show();
            },
            onComplete: function (fileName, response) {
                if (response.error == 0) {
                    $('#uploadImagePath').val(response.url);
                    $('#imagesobj').attr("src", response.url);
                    $('#imgtip').hide();
                } else {
                    alert(response.message);
                }
            }
        });
    });
}

//加载Checkbox数据
function LoadChk(preName, data) {
    if (data != undefined && data != "") {
        var lstData = data.split(',');
        $(lstData).each(function (i, item) {
            $("input[name='" + preName + "'][value='" + item + "']").attr("checked", "checked");
        });
    }
}

//类型处理
function TypeProc() {
    var typeId = $("#hdnTypeIdModel").val();
    if (typeId == "W") {
        $("#trOrg").hide();
        $("#trRole").hide();
        $("#rdlWindow").attr("checked", "checked");
    } else {
//        $("#trOrg").show();
//        $("#trRole").show();
        $("#rdlService").attr("checked", "checked");
    }

    $('input[name="TypeId"]').change(function () {
        if ($(this).val() == "W") {
            $("#trOrg").hide();
            $("#trRole").hide();
        } else {
            $("#trOrg").show();
            $("#trRole").show();
        }
    });
}

//选择服务机构
function SelectSvcOrg() {
    $win = $('#dvSvcOrg').window({
        top: 200,
        left: 84
    });
    $win.window('open');

    GetSvcOrgLst('0');
}

//加载服务机构
function GetSvcOrgLst(isSearch) {
    var cname = $("#txtSvcOrgSearch").val();
    var roleId = $("#hdnCurRoleId").val();

    $('#SvcOrgList').datagrid({
        url: '/Product/ServicesListJson?page=1&rows=10&roleId=' + roleId + '&keyword=' + cname + '&isSearch=' + isSearch,
        pagination: true,
        pageNumber: 1,
        pageSize: 10,
        singleSelect: true,
        fitColumns: true,
        reload: true,
        striped: true,
        //title: str,
        onDblClickRow: function (rowIndex, rowData) {
            if (rowData.id != undefined) {
                spUserId = rowData.id;
                ownerId = rowData.ORG_ID;
                $("#txtOrgNameForSel").val(rowData.oname);
                $("#txtRoleName").val(rowData.rname);
                $('#dvSvcOrg').window('close');
            }
        }
    }).pagination({
        pageSize: 10, //每页显示的记录条数，默认为10 
        pageNumber: 1,
        pageList: [5, 10, 15], //可以设置每页记录条数的列表 
        beforePageText: '第', //页数文本框前显示的汉字 
        afterPageText: '页 共 {pages} 页',
        displayMsg: '当前显示 {from} - {to} 条记录 共 {total} 条记录',
        onBeforeRefresh: function () {
            $(this).pagination('loading');
        }
    });
}

//编辑服务项目
function EditProduct(type) {
    //获取提交数据
    var postData = GetPostData();
    if (postData == false) {
        return;
    }

    $.ajax({
        url: "/Product/EditProduct",
        type: "POST",
        data: postData,
        traditional: true,
        success: function (data) {
            CallBackMsg(data, type);
        }
    });

}

//获取提交数据
function GetPostData() {
    if (!$("#tbEditForm").form('validate')) {
        return false;
    }

    //服务主类
    var kindsMain = $("#selKindsMaster").combotree('getValue');
    if (kindsMain == undefined || kindsMain == "") {
        $.messager.alert('系统提示', '请选择服务主类！', 'warning');
        return false;
    }

    //服务子类
    var kindsSub = $("#selKindsChild").combotree('getValue');
    if (kindsSub == undefined || kindsSub == "") {
        $.messager.alert('系统提示', '请选择服务子类！', 'warning');
        return false;
    }

    //服务范围
    var lstChkArea = $('input[name="Area"]:checked');
    if (lstChkArea.length <= 0) {
        $.messager.alert('系统提示', '请选择服务范围！', 'warning');
        return false;
    }
    var lstArea = new Array();
    $(lstChkArea).each(function (i, chk) {
        lstArea[i] = $(chk).val();
    });

    //服务对象
    var lstChkSvcObj = $('input[name="SvcObj"]:checked');
    var lstSvcObj = new Array();
    if (lstChkSvcObj.length > 0) {
        $(lstChkSvcObj).each(function (i, chk) {
            lstSvcObj[i] = $(chk).val();
        });
    }

    //服务方式
    var lstChkSvcMethod = $('input[name="SvcMethod"]:checked');
    var lstSvcMethod = new Array();
    if (lstChkSvcMethod.length > 0) {
        $(lstChkSvcMethod).each(function (i, chk) {
            lstSvcMethod[i] = $(chk).val();
        });
    }

    //收费模式
    var Price = $("#txtChargeModeMoney").numberbox('getValue');
    var Unit = $("input[name='chargeMode']:checked").val();
    var chargeMode = $("#txtChargeModeOther").val();

    var typeId = $("input[name='TypeId']:checked").val();

    //所属机构
    if ((spUserId == undefined || spUserId == "") && typeId == "S") {
        $.messager.alert('系统提示', '请选择所属机构！', 'warning');
        return false;
    }

    var postData = {
        id: $("#hdnSvcItemId").val(),
        Useruid: spUserId,
        OWNER_ID: ownerId,
        SERVICE_NAME: $("#txtServiceName").val(),
        KindsIdMain: kindsMain,
        KindsIdSub: kindsSub,
        SERVICE_AREA: lstArea.join(','),
        Starttime: $("#txtStartTime").datebox("getValue"),
        Endtime: $("#txtEndTime").datebox("getValue"),
        LINKMAN: $("#txtLinkMan").val(),
        TEL: $("#txtPhone").val(),
        QQ: $("#txtQQ").val(),
        EMAIL: $("#txtEmail").val(),
        SERVICE_url: $("#txtUrl").val(),
        SERVICE_OBJECT: lstSvcObj.join(','),
        SERVICE_METHOD: lstSvcMethod.join(','),
        CHARGE_METHOD: chargeMode,
        Price: Price,
        Unit: Unit,
        SERVICE_Presentation: $("#Presentation").val(),
        SERVICE_PROCEDURE: $("#PROCEDURE").val(),
        SERVICE_LOG: GetImgSrc($("#uploadImagePath").val()),
        TypeId: typeId
    };

    return postData;
}

//推荐状态变更
function SetRecomment() {
    var id = $("#hdnSvcItemId").val();

    $.ajax({
        url: "/Product/SetRecommend",
        type: "POST",
        data: { id: id, HomeShow: recommendStatus },
        success: function (data) {
            if (data.Result == true) {
                if (recommendStatus == false) {
                    $.messager.alert('系统提示', '取消成功！', 'info', function () {
                        recommendStatus = true;
                        $("#btnRecommend").html('<span class="l-btn-left l-btn-icon-left"><span class="l-btn-text">推荐项目</span><span class=\"l-btn-icon icon-save\">&nbsp;</span></span>');
                    });
                } else {
                    $.messager.alert('系统提示', '推荐成功！', 'info', function () {
                        recommendStatus = false;
                        $("#btnRecommend").html("<span class=\"l-btn-left l-btn-icon-left\"><span class=\"l-btn-text\">取消推荐</span><span class=\"l-btn-icon icon-no\">&nbsp;</span></span>");
                    });
                }
            } else {
                $.messager.alert('系统提示', '操作失败，请尝试重新操作！', 'warning');
            }
        }
    });
}

//服务项目退回
function PopReturnWin() {
    var $win = $('#dvWindow').window({
        top: $(window).height() - 50,
        left: 100,
        shadow: true,
        minimizable: false,
        maximizable: false,
        collapsible: false
    });
    $win.window('open');
}

//退回操作
function SetReturn() {
    var content = $("#txtReturnReason").val();
    if (content == "") {
        $.messager.alert('系统提示', '请填写退回理由！', 'warning', function () {
            $("#txtReturnReason").focus();
        });
        return false;
    }

    var result = ChangeProductStatus(4, content);
    if (result == true) {
        $.messager.alert('系统提示', '退回成功！', 'info', function () {
            $("#txtReturnReason").val("");
            SetBtnStatus("4");
            CancelReturn();
        });
    } else {
        $.messager.alert('系统提示', '退回失败！', 'warning');
    }
}

//取消退回
function CancelReturn() {
    $('#dvWindow').window('close');
}

//服务项目上架
function SetOnShelf() {
    var result = ChangeProductStatus(1);
    if (result == true) {
        $.messager.alert('系统提示', '服务项目上架成功！', 'info', function () {
            SetBtnStatus("1");
        });
    } else {
        $.messager.alert('系统提示', '服务项目上架失败！', 'warning');
    }
}

//服务项目下架
function SetOffShelf() {
    var result = ChangeProductStatus(2);
    if (result == true) {
        $.messager.alert('系统提示', '服务项目下架成功！', 'info', function () {
            SetBtnStatus("2");
        });
    } else {
        $.messager.alert('系统提示', '服务项目下架失败！', 'warning');
    }
}

//删除服务服务项目
function DelProduct() {
    $.messager.confirm("操作提示", "您确定要删除该服务项目吗？", function (state) {
        if (state) {
            var result = ChangeProductStatus(3);
            if (result == true) {
                $.messager.alert('系统提示', '删除成功！', 'info', function () {
                    BackIndex();
                });
            } else {
                $.messager.alert('系统提示', '删除失败！', 'warning');
            }
        }
    });
}

//服务项目状态变更通用方法
function ChangeProductStatus(status, content) {
    var id = $("#hdnSvcItemId").val();

    var result = false;
    $.ajax({
        url: "/Product/ChangeProductStatus",
        type: "POST",
        async: false,
        data: { id: id, status: status, content: content },
        success: function (data) {
            if (data.Result == true) {
                result = true;
            } else {
                result = false;
            }
        }
    });

    return result;
}

//处理提交返回
function CallBackMsg(data, type) {
    if (data.Result == true) {
        if (type == 0) {
            $.messager.alert('系统提示', '添加成功！', 'info', function () {
                BackIndex();
            });
        }
        else {
            $.messager.alert('系统提示', '修改成功！', 'info', function () {
                BackIndex();
            });
        }
    }
    else if (data == "Redirect") {
        window.location.href = "/Home/Index";
    }
    else {
        if (type == 0) {
            $.messager.alert('系统提示', '添加失败！', 'error');
        }
        else {
            $.messager.alert('系统提示', '修改失败！', 'error');
        }
    }
}

//返回到列表页
function BackIndex() {
    window.location.href = "/Product/Index?page=" + $("#hdnPage").val() + "&iRoleId=" + $("#hdnCurRoleId").val() +
        "&spUserId=" + $("#hdnSpUserId").val() + "&name=" + $("#hdnName").val() + "&status=" + $("#hdnStatus").val() +
        "&roleid=" + $("#hdnRoleId").val() + "&kinds=" + $("#hdnKindsId").val() + "&typeid=" + $("#hdnTypeId").val() + "&order=" + $("#hdnOrder").val();
}

//设置控件状态
function SetBtnStatus(status) {
    $("#trType").show();
    $("#trStatus").show();
    $("#btnRecommend").show();
    $("#btnReturn").show();
    $("#btnOnShelf").show();
    $("#btnOffShelf").show();
    $("#btnDel").show();
    $("#btnEdit").show();
    $("#trOrg").show();
    $("#trRole").show();

    switch (status) {
        case "0":
            $("#btnRecommend").hide();
            $("#btnOffShelf").hide();
            $("#btnAdd").hide();
            break;
        case "1":
            $("#btnOnShelf").hide();
            $("#btnAdd").hide();
            break;
        case "2":
            $("#btnRecommend").hide();
            $("#btnOffShelf").hide();
            $("#btnAdd").hide();
            break;
        case "3":
            $("#btnRecommend").hide();
            $("#btnReturn").hide();
            $("#btnOffShelf").hide();
            $("#btnDel").hide();
            $("#btnAdd").hide();
            $("#btnEdit").hide();
            break;
        case "4":
            $("#btnRecommend").hide();
            $("#btnReturn").hide();
            $("#btnOffShelf").hide();
            $("#btnAdd").hide();
            break;
        default:
            $("#trStatus").hide();
            $("#btnRecommend").hide();
            $("#btnReturn").hide();
            $("#btnOnShelf").hide();
            $("#btnOffShelf").hide();
            $("#btnDel").hide();
            $("#btnEdit").hide();
            break;
    }

    var spUserIdUrl = $("#hdnSpUserId").val();
    if (spUserIdUrl != undefined && spUserIdUrl != "") {
        $("#trOrg").hide();
        $("#trRole").hide();
        $("#btnRecommend").hide();
        $("#btnReturn").hide();
        $("#btnOnShelf").hide();
        $("#btnOffShelf").hide();
        $("#trType").hide();
    }

    var typeIdModel = $("#hdnTypeIdModel").val();
    if (typeIdModel == "W") {
        $("#btnRecommend").hide();
        $("#btnReturn").hide();
        $("#btnOnShelf").hide();
        $("#btnOffShelf").hide();
    }
}

function GetImgSrc(OriginalImgSrc) {
    var newImgSrc = "";

    if (OriginalImgSrc != "/UploadFiles/Product/" && OriginalImgSrc != "") {
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

//状态转换
function StatusParser(status) {
    switch (status) {
        case "0":
            return "未审核";
            break;
        case "1":
            return "服务中";
            break;
        case "2":
            return "已下架";
            break;
        case "3":
            return "已删除";
            break;
        case "4":
            return "已退回";
            break;
        default:
            return "未审核";
            break;
    }
}