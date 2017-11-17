<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>项目申报_企业管理后台_玉门市中小企业公共服务平台</title>
    <link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/home/css/webindex.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/home/css/admin.css" />

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/home/css/main.css" />
<link id="changbj" rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/home/css/base.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/site/js/putud.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/site/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/site/js/jquery.soChange.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/site/js/js.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/site/js/Common.js"></script>
<script src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/resources/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/resources/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/uploadify/swfobject.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/resources/uploadify/uploadify.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/kindeditor/kindeditor-all-min.js"></script>
    
    <script type="text/javascript">
    	var bashpath="${pageContext.request.contextPath}";
        var FlieName = "";
        var Demand_Pay = true;
        var editor;
        $(function () {
            LoadEditor('textarea[name="Demand_Detail"]', 'editor');
            $.post(bashpath+"/sclassList", { pclassid: 0 }, function (data) {
            	console.log("sclassList",data);
                var htmlstr = "";
                for (var i = 0; i < data.length; i++) {
                    htmlstr += "<option value=\"" + data[i].id + "\">" + data[i].title + "</option>";
                }
                $("#Superclass").html(htmlstr);
                $("#Subclass").html("<option value=\"0\">--请选择二级类--</option>")
            });
            
            $("#uploadify").uploadify({
                'uploader': '/resources/uploadify/uploadify.swf',
                'script': '/uploadfile',
                'cancelImg': '/resources/uploadify/cancel.png',
                'folder': 'UploadFile',
                'queueID': 'fileQueue',
                'auto': true,
                'multi': false,
                'buttonImg': '/resources/uploadify/uploadify.png',
                'width': 78,
                'height': 23,
                'onComplete': function (event, UserID, fileObj, response, data) {
                	console.log("data:",data);
                	console.log("response:",response);
                    pice = response;
                    if (response != null) {
                        FlieName = response;
                        $("#txtTishi").html("<img src='/images/biao_05.png' /> 附件上传成功");
                    }
                }
            });
            var date = new Date();
            $("#txt_Demand_CompletionTime").val(date.getFullYear() + "-" + parseInt(date.getMonth() + 1) + "-" + date.getDate())

            $("#txt_Demand_Pay").click(function () {
                Demand_Pay = $("#txt_Demand_Pay").is(":checked") ? true : false;
            })

            $("#Demand_Add").click(function () {
                var txtName = editor.html();
                var postDate = {
                    title: $("#txt_Demand_Name").val(),
                    content: txtName,
                    //Demand_Attachment: FlieName,
                    //linktel: $("#txt_Demand_MobilePhone").val(),
                    price: $("#txt_Demand_Money").val(),
                    //Demand_Pay: Demand_Pay,
                    lasttime: $("#txt_Demand_CompletionTime").val(),
                    code: $("#Superclass").val(),
                    subcode: $("#Subclass").val()
                };
                
                $.post("/sneed/add", postDate, function (data) {
                    if (data == "OK") {
                        $("#Moy").text("￥" + $("#txt_Demand_Money").val());
                        $("#ReleaseYe").css("display", "none");
                        $("#Note").css("display", "none");
                        $("#Successful").css("display", "block");
                        //reload();
                    }
                    else if (data == "NO") {
                        $.messager.alert("友情提示", "添加失败，请您检查", "error");
                    }
                    else {
                        $.messager.alert("友情提示", "添加成功！", "info", function () {
                            window.location.href = "/sneed/list.html";
                        });
                    }
                });
            });
            //下一步
            $("#NextStep").click(function () {
                if ($("#txt_Demand_Name").val() == "请一句话描述您的需求") {
                    return;
                }
                
                if ($("#txt_Demand_CompletionTime").val() == "" || $("#txt_Demand_CompletionTime").val() == null) {
                    return;
                }
                if ($("#txt_Demand_Money").val() == "" || $("#txt_Demand_Money").val() == null) {
                    $("#txt_Demand_Money").val("0");
                }
                var txtName = editor.html();
                if (txtName == "" || txtName == null) {
                    return;
                }
                var Superclassid = $("#Superclass").val();
                var Subclassid = $("#Subclass").val();
                if (Subclassid == "0") {
                    $("#txt_class").html('请选择需求类别');
                    $("#Subclass").css("border", "red 1px solid");
                    return;
                }
                var obj = document.getElementById('Superclass');
                var index = obj.selectedIndex;
                var obj1 = document.getElementById('Subclass');
                var index1 = obj1.selectedIndex;
                var val = obj.options[index].text;
                var val1 = obj1.options[index1].text;
                $("#Serviceclassname").html(val + '   ' + val1);
                $("#ServiceclassId").attr("text", Subclassid);
                $("#piaoti").html($("#txt_Demand_Name").val());
                $("#yaoq").html(txtName);
                $("#dinhua").html($("#txt_Demand_MobilePhone").val());
                //            $("#zfu").text();
                $("#Date").html($("#txt_Demand_CompletionTime").val());
                $("#Moye").html($("#txt_Demand_Money").val());

                $("#Note").css("display", "none");
                $("#ReleaseYe").css("display", "block");
            });
            $("#Demand_Shangyibu").click(function () {
                $("#ReleaseYe").css("display", "none");
                $("#Note").css("display", "block");
            });

        })


        function MobilePhone() {
            var sMobile = $("#txt_Demand_MobilePhone").val();
            var srt = "";
            if (!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(sMobile))) {
                $("#txt_Phone").html("<span  style='padding-left:5px;color:red; padding-left: 8px;'>您输入的手机号不正确请核实后输入正确的手机号：例子（13898888787）</span>");
                $("#txt_Demand_MobilePhone").focus();
                return false;
            } else {
                $("#txt_Phone").html("<span  style='padding-left:5px;color:#a0a0a0; padding-left: 8px;'>号码仅官方可见，不会泄露您的隐私</span>");

                return true;
            }

        }
        function loadSubclass() {
            var Superclassid = $("#Superclass").val();
            $.post("/sclassList", { pclassid: Superclassid }, function (data) {
                var htmlstr = "";
                for (var i = 0; i < data.length; i++) {
                    htmlstr += "<option value=\"" + data[i].id + "\">" + data[i].title + "</option>";
                }
                $("#Subclass").html(htmlstr)
            });
        }
    </script>

<style type="text/css" media="screen">
#uploadifyUploader {visibility:hidden}
</style>
<link href="${pageContext.request.contextPath}/resources/kindeditor/themes/default/default.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/home/css/Site.css" rel="stylesheet" type="text/css" />

<div class="admin_right">
    <div class="indent_title">
        <img src="${pageContext.request.contextPath}/resources/home/images/t_05.jpg" width="5" height="17" class="fl"><span>发布需求</span>
    </div>
    <div class="clear" style="height: 10px; line-height: 10px;">
    </div>
    <div class="Info_top">
    </div>
    
    <div class="Info_center" id="Note" style="display: block;">
        <ul class="fm_requ_title">
            <li style="padding-left: 12px;">描述您的需求</li>
            <li>确认需求</li>
            <li>完成需求发布</li>
        </ul>
        <div class="clear">
        </div>
        <div class="fm_req_gudie">
        </div>
        <div class="info_sm top" style="margin: 0 auto; padding-top: 20px;">
            <font style="color: #be1e06; padding-right: 2px;">*</font>表示该项必填！公司介绍是展示您公司的舞台，把您公司介绍给大家吧！</div>
        <div class="fm_xuxian">
        </div>
        <dl class="info_dl">
            <dt class="fm_dt"><span class="fr">标题：</span><font class="fr">*</font></dt>
            <dd>
                <div class="left info_div5" style="width: 470px;">
                    <input type="text" id="txt_Demand_Name" name="title" class="info_input" value="请一句话描述您的需求" style="color: #999" onclick="if(value==defaultValue){value='';this.style.color='#000'}" onblur="if(!value){value=defaultValue;this.style.color='#999'}"></div>
            </dd>
        </dl>
        <dl class="info_dl">
            <dt class="fm_dt"><span class="fr">需求分类：</span><font class="fr">*</font></dt>
            <dd>
                一级类
                <select id="Superclass" name="code" onchange="loadSubclass()" style="width: 120px; height: 18px;
                    border: 0px; border: 1px solid #000;">
                    <option value="0">--请选择一级类--</option>
                </select>
                二级类
                <select id="Subclass" name="subcode" style="width: 120px; height: 18px; border: 0px; border: 1px solid #000;">
                	<option value="0">--请选择二级类--</option>
               	</select>
            </dd>
            <dd id="txt_class" style="color: #a0a0a0; padding-left: 8px;">
                需求类别</dd>
        </dl>
        <dl class="info_dl">
            <dt class="fm_dt"><span class="fr">具体要求：</span><font class="fr">*</font></dt>
            <dd style="height: 350px;">
                <div class="left">
                    <textarea name="Demand_Detail" style="width: 570px; height: 300px; visibility: hidden; display: none;">测试需求</textarea>
                </div>
                <div style="clear: both;">
                </div>
                <div style="margin-top: 10px;">
                    <table>
                        <tbody><tr>
                            <td>
                                <input type="file" value="上传文件" name="uploadify" id="uploadify" width="78" style="display: none;" height="23">
                            </td>
                            <td>
                                <span id="txtTishi" style="color: #a0a0a0; padding-left: 8px;">最多可添加一个附件，每个大小不超过10M</span>
                            </td>
                        </tr>
                    </tbody></table>
                    
                    <span id="fileQueue" style="float: right;" class="uploadifyQueue"></span>
                </div>
            </dd>
        </dl>
        <dl class="info_dl">
            <dt class="fm_dt">联系电话：</dt>
            <dd>
                <div class="left info_div5" style="width: 122px;">
                    <input type="text" class="info_input" id="txt_Demand_MobilePhone" onkeyup="MobilePhone()" value="15193176118"></div>
            </dd>
            <dd id="txt_Phone" style="color: #a0a0a0; padding-left: 8px;"> 号码仅官方可见，不会泄露您的隐私</dd>
        </dl>
        <dl class="info_dl">
            <dt class="fm_dt">出价：</dt>
            <dd>
                <div class="left info_div5" style="width: 90px;">
                    <input type="text" class="info_input" id="txt_Demand_Money" onkeyup="this.value=this.value.replace(/[^\d\.]/g,'')" value="1">
                </div>
            </dd>
            <dd style="color: #a0a0a0; padding-left: 8px;">
                合理的定价可以吸引更多专业服务机构</dd>
        </dl>
        <dl class="info_dl">
            <dt class="fm_dt">如何支付赏金：</dt>
            <dd>
                <input type="radio" name="sex" id="txt_Demand_Pay" value="1" class="fl" checked="checked" style="margin-top: 5px; margin-left: 5px" ></dd>
            <dd>
                <font size="2" color="#3a62b0" style="padding-left: 5px">验收后一次性付清</font>
            </dd>
            
        </dl>
        
        <dl class="info_dl">
            <dt class="fm_dt"><span class="fr">指定完成时间：</span><font class="fr">*</font></dt>
            <dd>
                <div class="left info_div5" style="width: 130px;">
                    <input type="text" id="txt_Demand_CompletionTime" class="Wdate" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'txt_Demand_CompletionTime\')}',dateFmt:'yyyy-MM-dd',disabledDates:['%y-%M-%d {%H-1}\:..\:..','%y-%M-%d {%H+1}\:..\:..']})" style="color: #999" onclick="if(value==defaultValue){value='';this.style.color='#000'}" onblur="if(!value){value=defaultValue;this.style.color='#999'}"></div>
            </dd>
        </dl>
        <div style="width: 200px; margin: 0 auto; padding-top: 40px;">
            <img src="/resources/home/images/bubg.jpg" width="150" height="25" id="NextStep" style="cursor: pointer;"></div>
        <div class="clear" style="height: 20px; line-height: 20px;">
        </div>
    </div>
    
    <div class="Info_center" id="ReleaseYe" style="display: none;">
        <div class="">
            <div class="fm_req_gudie">
                <img src="${pageContext.request.contextPath}/resources/home/images/bz2.png" width="677" height="63">
            </div>
            <div class="clear">
            </div>
            <div class="info_sm top" style="margin: 0 auto; padding-top: 60px;">
            </div>
            <div class="fm_xuxian">
            </div>
            <dl class="info_dl">
                <dt style="width: 162px; font-size: 18px; font-weight: bold;">标题：</dt>
                <dd>
                    <div id="piaoti" style="font-size: 18px; font-weight: bold;">
                    </div>
                </dd>
            </dl>
            <dl class="info_dl">
                <dt style="width: 162px; font-size: 18px; font-weight: bold;">所属类别：</dt>
                <dd>
                    <div id="Serviceclassname">
                    </div>
                    <input id="ServiceclassId" type="hidden">
                </dd>
            </dl>
            <dl class="info_dl">
                <dt style="width: 162px;">具体要求：</dt>
                <dd style="width: 100%; height: auto;">
                    <div id="yaoq" style="margin-left: 130px; height: auto; width: 70%;">
                    </div>
                </dd>
            </dl>
            <dl class="info_dl">
                <dt style="width: 162px;"><span>电话：</span></dt>
                <dd>
                    <div id="dinhua">
                    </div>
                </dd>
            </dl>
            <dl class="info_dl">
                <dt style="width: 162px;"><span id="zfu">支付方式：</span></dt>
                <dd>
                    <div class="fangshi">
                        <img src="${pageContext.request.contextPath}/resources/home/images/dian_05.jpg" width="8" height="8">
                        完成付清</div>
                </dd>
            </dl>
            <dl class="info_dl">
                <dt style="width: 162px;"><span class="fr">完成时间：</span></dt>
                <dd>
                    <div id="Date">
                    </div>
                </dd>
            </dl>
            <dl class="info_dl">
                <dt style="width: 162px; font-size: 18px; font-weight: bold;">总计：</dt>
                <dd>
                    <img src="${pageContext.request.contextPath}/resources/home/images/req1_12.png">
                </dd>
                <dd>
                    <div id="Moye" class="chujia" style="margin-left: 5px; font-size: 18px; font-weight: bold;">
                    </div>
                </dd>
            </dl>
        </div>
        <div style="width: 300px; margin: 0 auto; padding-top: 40px;">
            <span>
                <img src="${pageContext.request.contextPath}/resources/home/images/fabubg.png" width="150" height="25" id="Demand_Add" style="cursor: pointer;"></span><span>
                <img src="${pageContext.request.contextPath}/resources/home/images/shuangyibu.png" width="54" height="23" id="Demand_Shangyibu" style="cursor: pointer; margin-left: 10px;"></span></div>
        <div class="clear" style="height: 20px; line-height: 20px;">
        </div>
    </div>
    
    <div class="Info_center" id="Successful" style="display: none;">
        <div class="">
            <div style="background: url(${pageContext.request.contextPath}/resources/home/images/bz3.png) no-repeat; width: 677px; height: 63px;
                margin: 0 auto;">
            </div>
            <div class="clear">
            </div>
            <div class="info_sm top" style="margin: 0 auto; padding-top: 60px;">
            </div>
            <div class="fm_xuxian">
            </div>
            <div class="yanse3">
                <img src="${pageContext.request.contextPath}/resources/home/images/OK.png" width="37" height="35"><span>恭喜！您的需求已提交，请尽快支付托管金额</span></div>
            <div class="clear" style="height: 20px">
            </div>
            <div class="biaoti1">
                <span>您的需求：</span><span class="yanse">企业共性技术信息安全云管理服务企</span></div>
            <div class="clear" style="height: 20px">
            </div>
            <div class="biaoti1">
                <img src="${pageContext.request.contextPath}/resources/home/images/qbz.jpg" class="jiange" width="23" height="23"><span>托管金：</span><span class="yanse1" id="Moy"></span></div>
            <div class="clear" style="height: 20px">
            </div>
            <div class="clear" style="height: 20px">
            </div>
            <a href="#">
                <input type="button" name="xyb1" class="rwfb" value="立即支付"></a>
            <div class="clear" style="height: 20px">
            </div>
            <div class="clear" style="height: 20px">
            </div>
            <div class="kuang">请在24小时内完成支付，否则需求会被自动撤销</div>
            <div class="clear" style="height: 20px">
            </div>
        </div>
        <div class="clear" style="height: 20px; line-height: 20px;">
        </div>
    </div>
    <div class="Info_bottom">
    </div>
</div>

</body>
</html>