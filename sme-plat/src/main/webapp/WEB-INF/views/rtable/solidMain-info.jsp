<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>酒泉市工业固体废物综合利用情况表</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/table/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/table/table.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	function BackIndex() {
		self.location = "${pageContext.request.contextPath}/solidMain";
	}
</script>
<style type="text/css">
th, td, input {
	font-size: 12px;
}
</style>
</head>
<body>
	<div id="p" class="easyui-panel" title="报表填写"
		style="width: 100%; min-height: 200px; padding: 10px;">
		<form id="myform" action="add" method="post">
			<table>
				<caption>酒泉市工业固体废物综合利用情况表</caption>
				<tbody>
					<tr>
						<td class="noborder">企业名称:</td>
						<td colspan="6" class="noborder" style="text-align: left;"><label >${solidMain.corptitle}</label></td>
						<td class="noborder">填表时间</td>
						<td colspan="2" class="noborder"><label>${solidMain.tbtimestr}</label></td>
					</tr>
					<tr>
						<th rowspan="2">种类</th>
						<td colspan="3">实际产生量(万吨)</td>
						<td colspan="3">综合利用量(万吨)</td>
						<td colspan="3">综合利用率(%)</td>
					</tr>
					<tr>
						<td><label>${contentList[0].date}</label></td>
						<td><label>${contentList[1].date}</label></td>
						<td><label>${contentList[2].date}</label></td>
						<td><label>${contentList[3].date}</label></td>
						<td><label>${contentList[4].date}</label></td>
						<td><label>${contentList[5].date}</label></td>
						<td><label>${contentList[6].date}</label></td>
						<td><label>${contentList[7].date}</label></td>
						<td><label>${contentList[8].date}</label></td>
					</tr>
					<tr>
						<td>一、尾矿</td>
						<td><label>${contentList[0].a}</label></td>
						<td><label>${contentList[1].a}</label></td>
						<td><label>${contentList[2].a}</label></td>
						<td><label>${contentList[3].a}</label></td>
						<td><label>${contentList[4].a}</label></td>
						<td><label>${contentList[5].a}</label></td>
						<td><label>${contentList[6].a}</label></td>
						<td><label>${contentList[7].a}</label></td>
						<td><label>${contentList[8].a}</label></td>
					</tr>
					<tr>
						<td>其中：煤矸石</td>
						<td><label>${contentList[0].b}</label></td>
						<td><label>${contentList[1].b}</label></td>
						<td><label>${contentList[2].b}</label></td>
						<td><label>${contentList[3].b}</label></td>
						<td><label>${contentList[4].b}</label></td>
						<td><label>${contentList[5].b}</label></td>
						<td><label>${contentList[6].b}</label></td>
						<td><label>${contentList[7].b}</label></td>
						<td><label>${contentList[8].b}</label></td>
					</tr>
					<tr>
						<td>二、冶炼渣</td>
						<td><label>${contentList[0].c}</label></td>
						<td><label>${contentList[1].c}</label></td>
						<td><label>${contentList[2].c}</label></td>
						<td><label>${contentList[3].c}</label></td>
						<td><label>${contentList[4].c}</label></td>
						<td><label>${contentList[5].c}</label></td>
						<td><label>${contentList[6].c}</label></td>
						<td><label>${contentList[7].c}</label></td>
						<td><label>${contentList[8].c}</label></td>
					</tr>
					<tr>
						<td>其中：工业炉渣</td>
						<td><label>${contentList[0].d}</label></td>
						<td><label>${contentList[1].d}</label></td>
						<td><label>${contentList[2].d}</label></td>
						<td><label>${contentList[3].d}</label></td>
						<td><label>${contentList[4].d}</label></td>
						<td><label>${contentList[5].d}</label></td>
						<td><label>${contentList[6].d}</label></td>
						<td><label>${contentList[7].d}</label></td>
						<td><label>${contentList[8].d}</label></td>
					</tr>
					<tr>
						<td>三、化工废渣</td>
						<td><label>${contentList[0].e}</label></td>
						<td><label>${contentList[1].e}</label></td>
						<td><label>${contentList[2].e}</label></td>
						<td><label>${contentList[3].e}</label></td>
						<td><label>${contentList[4].e}</label></td>
						<td><label>${contentList[5].e}</label></td>
						<td><label>${contentList[6].e}</label></td>
						<td><label>${contentList[7].e}</label></td>
						<td><label>${contentList[8].e}</label></td>
					</tr>
					<tr>
						<td>其中：工业副产石膏</td>
						<td><label>${contentList[0].f}</label></td>
						<td><label>${contentList[1].f}</label></td>
						<td><label>${contentList[2].f}</label></td>
						<td><label>${contentList[3].f}</label></td>
						<td><label>${contentList[4].f}</label></td>
						<td><label>${contentList[5].f}</label></td>
						<td><label>${contentList[6].f}</label></td>
						<td><label>${contentList[7].f}</label></td>
						<td><label>${contentList[8].f}</label></td>
					</tr>
					<tr>
						<td>电石渣</td>
						<td><label>${contentList[0].g}</label></td>
						<td><label>${contentList[1].g}</label></td>
						<td><label>${contentList[2].g}</label></td>
						<td><label>${contentList[3].g}</label></td>
						<td><label>${contentList[4].g}</label></td>
						<td><label>${contentList[5].g}</label></td>
						<td><label>${contentList[6].g}</label></td>
						<td><label>${contentList[7].g}</label></td>
						<td><label>${contentList[8].g}</label></td>
					</tr>
					<tr>
						<td>四、其它废渣</td>
						<td><label>${contentList[0].h}</label></td>
						<td><label>${contentList[1].h}</label></td>
						<td><label>${contentList[2].h}</label></td>
						<td><label>${contentList[3].h}</label></td>
						<td><label>${contentList[4].h}</label></td>
						<td><label>${contentList[5].h}</label></td>
						<td><label>${contentList[6].h}</label></td>
						<td><label>${contentList[7].h}</label></td>
						<td><label>${contentList[8].h}</label></td>
					</tr>
					<tr>
						<td>其中：粉煤灰</td>
						<td><label>${contentList[0].i}</label></td>
						<td><label>${contentList[1].i}</label></td>
						<td><label>${contentList[2].i}</label></td>
						<td><label>${contentList[3].i}</label></td>
						<td><label>${contentList[4].i}</label></td>
						<td><label>${contentList[5].i}</label></td>
						<td><label>${contentList[6].i}</label></td>
						<td><label>${contentList[7].i}</label></td>
						<td><label>${contentList[8].i}</label></td>
					</tr>
					<tr>
						<td>合计</td>
						<td><label>${contentList[0].j}</label></td>
						<td><label>${contentList[1].j}</label></td>
						<td><label>${contentList[2].j}</label></td>
						<td><label>${contentList[3].j}</label></td>
						<td><label>${contentList[4].j}</label></td>
						<td><label>${contentList[5].j}</label></td>
						<td><label>${contentList[6].j}</label></td>
						<td><label>${contentList[7].j}</label></td>
						<td><label>${contentList[8].j}</label></td>
					</tr>
					<tr>
						<td class="noborder">审核领导：</td>
						<td colspan="7" class="noborder" style="text-align: left;"><label >${solidMain.shleader}</label>
						<td class="noborder">填表人：</td>
						<td class="noborder" style="text-align: left;"><label >${solidMain.tbname}</label></td>
					</tr>
				</tbody>
			</table>
			<div
				style="width: 96%; margin: 0 auto; font-size: 14px; margin-left: 5%; margin-top: 20px;">
				<div style="line-height: 30px; font-size: 12px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注：工业固体废物产生量指企业在生产过程中产生的固体状、半固体状和高浓度液体状废弃物的总量，包括危险废物、冶炼废渣、粉煤灰、炉渣、煤矸石、尾矿、放射性废物和其他废物等。</div>
				<div style="line-height: 30px; font-size: 12px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;资源综合利用是指在矿产资源开采过程中对共生、伴生矿进行综合开发与合理利用；对生产过程中产生的废渣、废水(液)、废气、余热、余压等进行回收和合理利用。对此表进行调查统计时，不应只局限于通过认定的资源综合利用企业，而应对其他工业企业和其他行业工业固废综合利用情况也进行调查统计。请于2015年6月底和12月底前报上报市工信委环资科。</div>
				<div style="line-height: 30px; font-size: 12px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;其它废渣是指除三种废渣以外的所有废渣，废渣种类可另附说明。</div>
			</div>
			<div style="float: right;">
				<tr style="height: 80px;">
					<td colspan="2" style="text-align: right"> <a id="btnBack"
						style="margin-top: 30px;" class="easyui-linkbutton"
						data-options="iconCls:'icon-back'" href="javascript:"
						onclick="BackIndex()">返回</a>
				</tr>
			</div>
		</form>
	</div>
</body>

</html>
