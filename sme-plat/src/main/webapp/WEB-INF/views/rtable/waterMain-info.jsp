<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>重点用水工业企业用水状况基本信息月报表</title>
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
		self.location = "${pageContext.request.contextPath}/waterMain";
	}
</script>
</head>
<body>
	<div id="p" class="easyui-panel" title="报表填写"
		style="width: 100%; min-height: 200px; padding: 10px;">
		<form id="myform" action="add" method="post">
			<table>
				<caption>重点用水工业企业用水状况基本信息月报表</caption>
				<tbody>
					<tr>
						<td>企业名称（盖章）</td>
						<td colspan="5"><label>${waterMain.corptitle}</label></td>
					</tr>
					<tr>
						<td>通讯地址</td>
						<td colspan="3"><label>${waterMain.txaddress}</label></td>
						<td>邮政编码</td>
						<td><label>${waterMain.yznum}</label></td>
					</tr>

					<tr>
						<td>联系人</td>
						<td><label>${waterMain.linker}</label></td>
						<td>联系电话</td>
						<td><label>${waterMain.linktel}</label></td>
						<td>传真</td>
						<td><label>${waterMain.cznum}</label></td>
					</tr>
					<tr>
						<th colspan="2">取水类别</th>
						<th>计量单位</th>
						<th><label>${takeList[0].date}</label></th>
						<th><label>${takeList[1].date}</label></th>
						<th><label>${takeList[2].date}</label></th>
					</tr>
					<tr>
						<td colspan="2">地表水</td>
						<td>万立方米</td>
						<td><label>${takeList[0].waterdb}</label></td>
						<td><label>${takeList[1].waterdb}</label></td>
						<td><label>${takeList[2].waterdb}</label></td>
					</tr>
					<tr>
						<td colspan="2">地下水</td>
						<td>万立方米</td>
						<td><label>${takeList[0].waterdx}</label></td>
						<td><label>${takeList[1].waterdx}</label></td>
						<td><label>${takeList[2].waterdx}</label></td>
					</tr>
					<tr>
						<td colspan="2">自来水</td>
						<td>万立方米</td>
						<td><label>${takeList[0].waterzl}</label></td>
						<td><label>${takeList[1].waterzl}</label></td>
						<td><label>${takeList[2].waterzl}</label></td>
					</tr>
					<tr>
						<td colspan="2">其它水</td>
						<td>万立方米</td>
						<td><label>${takeList[0].waterqt}</label></td>
						<td><label>${takeList[1].waterqt}</label></td>
						<td><label>${takeList[2].waterqt}</label></td>
					</tr>
					<tr>
						<td colspan="2">取水总量</td>
						<td>万立方米</td>
						<td><label>${takeList[0].waterall}</label></td>
						<td><label>${takeList[1].waterall}</label></td>
						<td><label>${takeList[2].waterall}</label></td>
					</tr>
					<tr>
						<th colspan="2">用水类别</th>
						<th>计量单位</th>
						<th><label>${useList[0].date}</label></th>
						<th><label>${useList[1].date}</label></th>
						<th><label>${useList[2].date}</label></th>
					</tr>
					<tr>
						<td colspan="2">工业用新水</td>
						<td>万立方米</td>
						<td><label>${useList[0].a}</label></td>
						<td><label>${useList[1].a}</label></td>
						<td><label>${useList[2].a}</label></td>
					</tr>
					<tr>
						<td colspan="2">非工业用新水</td>
						<td>万立方米</td>
						<td><label>${useList[0].b}</label></td>
						<td><label>${useList[1].b}</label></td>
						<td><label>${useList[2].b}</label></td>
					</tr>
					<tr>
						<td colspan="2">外供新水</td>
						<td>万立方米</td>
						<td><label>${useList[0].c}</label></td>
						<td><label>${useList[1].c}</label></td>
						<td><label>${useList[2].c}</label></td>
					</tr>
					<tr>
						<td colspan="2">生产用重复用水量</td>
						<td>万立方米</td>
						<td><label>${useList[0].d}</label></td>
						<td><label>${useList[1].d}</label></td>
						<td><label>${useList[2].d}</label></td>
					</tr>
					<tr>
						<td colspan="2">生产用水重复利用率</td>
						<td>%</td>
						<td><label>${useList[0].e}</label></td>
						<td><label>${useList[1].e}</label></td>
						<td><label>${useList[2].e}</label></td>
					</tr>
					<tr>
						<td colspan="2">一级水表计量水量</td>
						<td>万立方米</td>
						<td><label>${useList[0].f}</label></td>
						<td><label>${useList[1].f}</label></td>
						<td><label>${useList[2].f}</label></td>
					</tr>
					<tr>
						<td colspan="2">一级水表计量率</td>
						<td>%</td>
						<td><label>${useList[0].g}</label></td>
						<td><label>${useList[1].g}</label></td>
						<td><label>${useList[2].g}</label></td>
					</tr>
					<tr>
						<td colspan="2">万元产值取水量</td>
						<td>立方米/万元</td>
						<td><label>${useList[0].h}</label></td>
						<td><label>${useList[1].h}</label></td>
						<td><label>${useList[2].h}</label></td>
					</tr>
					<tr>
						<td colspan="2">万元工业增加值取水量</td>
						<td>立方米/万元</td>
						<td><label>${useList[0].i}</label></td>
						<td><label>${useList[1].i}</label></td>
						<td><label>${useList[2].i}</label></td>
					</tr>
					<tr>
						<td colspan="2">废水排放量</td>
						<td>万立方米</td>
						<td><label>${useList[0].j}</label></td>
						<td><label>${useList[1].j}</label></td>
						<td><label>${useList[2].j}</label></td>
					</tr>
					<tr>
						<th colspan="2">单位产品取水量 指标名称</th>
						<th>计量单位</th>
						<th>2014年 指标值</th>
						<th>取水定额</th>
						<th>变化率 （±%）</th>
					</tr>
					<c:forEach var="quota" items="${quotaList}">
						<tr>
							<td colspan="2"><label>${quota.name}</label></td>
							<td><label>${quota.dw}</label></td>
							<td><label>${quota.a}</label></td>
							<td><label>${quota.b}</label></td>
							<td><label>${quota.c}</label></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="2">节约用水量</td>
						<td>万立方米</td>
						<td colspan="3"><label>${waterMain.jynum}</label></td>
					</tr>
				</tbody>
			</table>
			<div
				style="width: 96%; margin: 0 auto; font-size: 14px; margin-left: 5%; margin-top: 20px;">
				<div>填表说明：</div>
				<div style="line-height: 30px; font-size: 12px;">（1）取水总量=地表水+地下水+自来水+其它水；</div>
				<div style="line-height: 30px; font-size: 12px;">（2）工业用新水总量=取水总量-非工业用新水-外供新水；</div>
				<div style="line-height: 30px; font-size: 12px;">（3）节约用水量=(统计期单耗数-基期单耗数)x统计期产品产量。</div>
			</div>

			<div style="float: right;">
				<tr style="height: 80px;">
					<td colspan="2" style="text-align: right"><a id="btnBack"
						style="margin-top: 30px;" class="easyui-linkbutton"
						data-options="iconCls:'icon-back'" href="javascript:"
						onclick="BackIndex()">返回</a>
				</tr>
			</div>
		</form>
	</div>
</body>

</html>
