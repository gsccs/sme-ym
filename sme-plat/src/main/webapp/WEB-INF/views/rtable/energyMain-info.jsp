<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>工业重点用能企业能源消耗情况月报列表</title>
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
		self.location = "${pageContext.request.contextPath}/energyMain";
	}
	</script>
</head>
<body>
	<div id="p" class="easyui-panel" title="报表详情"
		style="width: 100%; min-height: 200px; padding: 10px;">
		<form id="myform">
			<table>
				<caption>工业重点用能企业能源消耗情况月报表</caption>
				<tbody>
					<tr>
						<td class="noborder">企业名称（盖章）：</td>
						<td colspan="3" class="noborder" style="text-align: left;"><label  class="tleft"
							 >${energyMain.corptitle}</label></td>
						<td class="noborder">数据统计期间：</td>
						<td class="noborder"><label class="tleft" >${energyMain.startend}</label></td>
					</tr>
					<tr>
						<td>所属行业</td>
						<td><label >${energyMain.qyIndustry}</label></td>
						<td>工业总产值（万元）</td>
						<td><label >${energyMain.industryAll}</label></td>
						<td>工业增加值（万元）</td>
						<td><label >${energyMain.industryAdd}</label></td>
					</tr>
					<tr>
						<td>综合能耗量 （万吨标准煤）</td>
						<td><label >${energyMain.a}</label></td>
						<td>电耗量（万kwh）</td>
						<td><label >${energyMain.b}</label></td>
						<td>水耗量（立方米）</td>
						<td><label >${energyMain.c}</label></td>
					</tr>

					<tr>
						<td>工业总产值能耗 （吨标准煤/万元）</td>
						<td><label >${energyMain.d}</label></td>
						<td>工业总产值电耗 （千瓦时/万元）</td>
						<td><label >${energyMain.e}</label></td>
						<td>工业总产值水耗 （立方米/万元）</td>
						<td><label >${energyMain.f}</label></td>
					</tr>
					<tr>
						<td>工业增加值能耗（吨标准煤/万元）</td>
						<td><label >${energyMain.g}</label></td>
						<td>工业增加值电耗（千瓦时/万元）</td>
						<td><label >${energyMain.h}</label></td>
						<td>工业增加值水耗（立方米/万元）</td>
						<td><label >${energyMain.i}</label></td>
					</tr>
					<tr>
						<th rowspan="3">主要生产工艺名称</th>
						<td>工艺1</td>
						<td colspan="4"><label >${technicsList[0].name}</label></td>
					</tr>
					<tr>
						<td>工艺2</td>
						<td colspan="4"><label >${technicsList[1].name}</label></td>
					</tr>
					<tr>
						<td>工艺3</td>
						<td colspan="4"><label >${technicsList[2].name}</label></td>
					</tr>
					<tr>
						<th>主要产品</th>
						<th>单位</th>
						<th>产量</th>
						<th>单位产品综合能耗（吨标准煤）</th>
						<th>单位产品综合电耗（千瓦时）</th>
						<th>单位产品水耗（立方米）</th>
					</tr>
					<c:forEach var="product" items="${productList}">
					<tr>
						<td><label >${product.product}</label></td>
						<td><label >${product.unit}</label></td>
						<td><label >${product.number}</label></td>
						<td><label >${product.a}</label></td>
						<td><label >${product.b}</label></td>
						<td><label >${product.c}</label></td>
					</tr>
					</c:forEach>
					<tr>
					</tr>
				</tbody>
			</table>
			<div style="width: 96%; margin: 0 auto; font-size: 14px;">
				<div style="width: 10%; float: left; margin-left: 5%;">
					<label>单位负责人：</label>
				</div>
				<div style="width: 14%; float: left;">
					<label  class="tleft"  >${energyMain.header}</label>
				</div>
				<div style="width: 8%; float: left;">
					<label>填表人：</label>
				</div>
				<div style="width: 16%; float: left;">
					<label  class="tleft"  >${energyMain.writer}</label>
				</div>
				<div style="width: 8%; float: left;">
					<label>联系电话：</label>
				</div>
				<div style="width: 16%; float: left;">
					<label  class="tleft"  >${energyMain.phone}</label>
				</div>
				<div style="width: 8%; float: left;">
					<label>报出日期：</label>
				</div>
				<div style="width: 11%; float: left;">
					<label  class="tleft"  >${energyMain.bcTimestr}</label>
				</div>
			</div>
			
			<tr style="height: 80px;">
					<td colspan="2" style="text-align: right"><a id="btnBack" style="margin-top:30px;"
						class="easyui-linkbutton" data-options="iconCls:'icon-back'"
						href="javascript:" onclick="BackIndex()">返回</a>
						</td>
				</tr>
		</form>
	</div>
</body>

</html>
