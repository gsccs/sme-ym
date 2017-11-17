//flow_1
function setTabFlow_1(name, indexnum, n, css) {
    for (i = 1; i <= n; i++) {
        //var menu = $("#"+name + i);
        //var con = document.getElementById("con_" + name + "_" + i);
        //var con = $("#con_" + name + "_" + i);
        //var con_rmg = $("#con_" + name + "_rmg_" + i);
        //menu.className = i == cursel ? css : "";
        if (i==indexnum){
        	$("#con_" + name + "_" + i).show();
        	$("#con_" + name + "_rmg_" + i).show();
        	$("#"+name + i).addClass(css);
        }else{
        	$("#con_" + name + "_" + i).hide();
        	$("#con_" + name + "_rmg_" + i).hide();
        	$("#"+name + i).removeClass(css);
        }
        //con.style.display = i == cursel ? "block" : "none";
        //con_rmg.style.display = i == indexnum ? "block" : "none";
    }

    if (indexnum == 1) {
        $("#flow_1_more").attr("href", "/wsbs.html");
    } else if(indexnum == 2) {
        $("#flow_1_more").attr("href", "/sitem.html");
    } else {
    	$("#flow_1_more").attr("href", "/activity.html");
    }
}

// tasktab
function setTab(name, cursel, n, css) {
    for (i = 1; i <= n; i++) {
        var menu = document.getElementById(name + i);
        var con = document.getElementById("con_" + name + "_" + i);
        menu.className = i == cursel ? css : "";
        con.style.display = i == cursel ? "block" : "none";
    }

    if (cursel == 1) {
        $("#aNewsMore").attr("href", "/News/Index?id=4");
    } else {
        $("#aNewsMore").attr("href", "/News/Index?id=1");
    }
}

// tasktab
function setTab2(name, cursel, n, css, code) {
    for (i = 1; i <= n; i++) {
        var menu = document.getElementById(name + i);
        var con = document.getElementById("con_" + name + "_" + i);
        menu.className = i == cursel ? css : "";
        con.style.display = i == cursel ? "block" : "none";
    }

    var oldHref = $("#aSvcItemMore").attr("href");
    $("#aSvcItemMore").attr("href", oldHref.substr(0, oldHref.length - 2) + code);
}

$(document).ready(function () {
    $(".hea_tit_d li").hover(function () {
        //$(this).children('a').show();
        $(this).children('.zq_hea_nav2').show();
        $(this).children('a').attr("class", "hover");
    }, function () {
        $(this).children('.zq_hea_nav2').hide();
        $(this).children('a').attr("class", "");
    });
})