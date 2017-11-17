<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>全站搜索_玉门市中小企业公共服务平台</title>
<link rel="shortcut icon" href="${base}/resources/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/base.css" />
<script type="text/javascript" src="${base}/resources/site/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/Common.js"></script>
<script type="text/javascript" src="${base}/resources/site/js/HomeAndFavorite.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/resources/site/css/s_itemlist.css" />

</head>
<body>
	<script type="text/javascript">
    $(function () {
    		//var records="[{"_version_":1534836678381797382,"cateid":"104","catestr":"104-最新动态","id":"1290","name_autocomplete":"玉门2户企业进入国家知识产权优势企业名单","siteid":"1","title":"玉门2户企业进入国家知识产权优势企业名单"},{"_version_":1534836678383894529,"cateid":"104","catestr":"104-最新动态","id":"1283","name_autocomplete":"玉门市宇丰新能源公司风机叶片二期项目开工建设","siteid":"1","title":"玉门市宇丰新能源公司风机叶片二期项目开工建设"},{"_version_":1534836678383894533,"cateid":"107","catestr":"107-玉门文化","id":"1279","name_autocomplete":"新能源博物馆","siteid":"1","title":"新能源博物馆"},{"_version_":1534836678389137408,"cateid":"106","catestr":"106-玉门特色","id":"1256","name_autocomplete":"下西号鹿产品","siteid":"1","title":"下西号鹿产品"},{"_version_":1534836678391234564,"cateid":"105","catestr":"105-政策信息","id":"1239","name_autocomplete":"酒泉市人民政府办公室 关于印发酒泉市战略性新兴产业发展实施方案通知","siteid":"1","title":"酒泉市人民政府办公室 关于印发酒泉市战略性新兴产业发展实施方案通知"},{"_version_":1534836678392283141,"cateid":"105","catestr":"105-政策信息","id":"1232","name_autocomplete":"甘肃省人民政府办公厅关于印发2015年 战略性新兴产业发展总体攻坚战工作方案的通知","siteid":"1","title":"甘肃省人民政府办公厅关于印发2015年 战略性新兴产业发展总体攻坚战工作方案的通知"},{"_version_":1534836678394380289,"cateid":"102","catestr":"102-通知公告","id":"1224","name_autocomplete":"国务院关于进一步加强淘汰落后产能工作的通知（摘编）","siteid":"1","title":"国务院关于进一步加强淘汰落后产能工作的通知（摘编）"}]";
    		//var json = eval('(' + str + ')'); 
			$.ajax({  
                	type: "GET",  
                    url: "/querylist",  
                    data: "keyword=${k}&siteid=${s}",
                    dataType:"json",  
                    success: function(res){
                    	console.log(res.facets);
                    	console.log(res.records);
                    	var facets = res.facets;
                    	var records = res.records;
                    	var facets_html="";
                    	var recode_html="";
                    	for(var i=0;i<facets.cate_facts.length;i++){
                    		var catefact = facets.cate_facts[i];
                    		facets_html = facets_html+"<a href='javascript:void(0)' class=''>"+catefact.title+"</a>"
                    	}
                    	
                    	for(var j=0;j<records.length;j++){
                    		var record = records[j];
                    		recode_html = recode_html+"<li><a href='"+record.url+"' class=''>"+record.title+"</a></li>"
                    	}
                    	$("#search_facet").html(facets_html);
                    	$("#search_record").html(recode_html);
                    },  
                    error: function(res){
                    
                	}
            });		
    });
</script>
	<!-- header -->
    [#include "/widget/header.ftl" /]
	
	[#include "/search/main.ftl" /]
						
	<!-- footer -->
    [#include "/widget/footer.ftl" /]					
</body>
</html>