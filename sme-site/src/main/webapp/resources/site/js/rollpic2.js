
//图片滚动列表 
var Speed_2 = 10; //速度(毫秒)
var Space_2 = 10; //每次移动(px)
var PageWidth_2 = 144; //翻页宽度
var fill_2 = 0; //整体移位
var MoveLock_2 = false;
var MoveTimeObj_2;
var MoveWay_2 = "right";
var Comp_2 = 0;
var AutoPlayObj_2 = null;

$(function () {
    //GetObj("SvcOrgTJ_List2").innerHTML = GetObj("SvcOrgTJ_List1").innerHTML;
    GetObj('SvcOrgTJ').scrollLeft = fill_2 >= 0 ? fill_2 : GetObj('SvcOrgTJ_List1').scrollWidth - Math.abs(fill_2);
    GetObj("SvcOrgTJ").onmouseover = function () { clearInterval(AutoPlayObj_2) }
    GetObj("SvcOrgTJ").onmouseout = function () { AutoPlay_2() }
    //AutoPlay_2();
});

function GetObj(objName) {
    if (document.getElementById) { return eval('document.getElementById("' + objName + '")') } else { return eval('document.all.' + objName) }
}

function AutoPlay_2() {
    clearInterval(AutoPlayObj_2); AutoPlayObj_2 = setInterval('ISL_GoDown_2();ISL_StopDown_2();', 2000)
}

function GoUp_2() {
    if (MoveLock_2) return; clearInterval(AutoPlayObj_2); MoveLock_2 = true; MoveWay_2 = "left"; MoveTimeObj_2 = setInterval('ISL_ScrUp_2();', Speed_2);
}

function StopUp_2() {
    if (MoveWay_2 == "right") { return }; clearInterval(MoveTimeObj_2); if ((GetObj('SvcOrgTJ').scrollLeft - fill_2) % PageWidth_2 != 0) { Comp_2 = fill_2 - (GetObj('SvcOrgTJ').scrollLeft % PageWidth_2); CompScr_2() } else { MoveLock_2 = false }
    //AutoPlay_2()
}

function ISL_ScrUp_2() {
    if (GetObj('SvcOrgTJ').scrollLeft <= 0) { GetObj('SvcOrgTJ').scrollLeft = GetObj('SvcOrgTJ').scrollLeft + GetObj('SvcOrgTJ_List1').offsetWidth }
    GetObj('SvcOrgTJ').scrollLeft -= Space_2
}

function ISL_GoDown_2() {
    clearInterval(MoveTimeObj_2); if (MoveLock_2) return; clearInterval(AutoPlayObj_2); MoveLock_2 = true; MoveWay_2 = "right"; ISL_ScrDown_2(); MoveTimeObj_2 = setInterval('ISL_ScrDown_2()', Speed_2)
}

function ISL_StopDown_2() {
    if (MoveWay_2 == "left") { return }; clearInterval(MoveTimeObj_2); if (GetObj('SvcOrgTJ').scrollLeft % PageWidth_2 - (fill_2 >= 0 ? fill_2 : fill_2 + 1) != 0) { Comp_2 = PageWidth_2 - GetObj('SvcOrgTJ').scrollLeft % PageWidth_2 + fill_2; CompScr_2() } else { MoveLock_2 = false }
    //AutoPlay_2()
}

function ISL_ScrDown_2() {
    if (GetObj('SvcOrgTJ').scrollLeft >= GetObj('SvcOrgTJ_List1').scrollWidth) { GetObj('SvcOrgTJ').scrollLeft = GetObj('SvcOrgTJ').scrollLeft - GetObj('SvcOrgTJ_List1').scrollWidth }
    GetObj('SvcOrgTJ').scrollLeft += Space_2
}

function CompScr_2() {
    if (Comp_2 == 0) { MoveLock_2 = false; return }
    var num, TempSpeed = Speed_2, TempSpace = Space_2; if (Math.abs(Comp_2) < PageWidth_2 / 2) { TempSpace = Math.round(Math.abs(Comp_2 / Space_2)); if (TempSpace < 1) { TempSpace = 1 } }
    if (Comp_2 < 0) {
        if (Comp_2 < -TempSpace) { Comp_2 += TempSpace; num = TempSpace } else { num = -Comp_2; Comp_2 = 0 }
        GetObj('SvcOrgTJ').scrollLeft -= num; setTimeout('CompScr_2()', TempSpeed)
    } else {
        if (Comp_2 > TempSpace) { Comp_2 -= TempSpace; num = TempSpace } else { num = Comp_2; Comp_2 = 0 }
        GetObj('SvcOrgTJ').scrollLeft += num; setTimeout('CompScr_2()', TempSpeed)
    }
}