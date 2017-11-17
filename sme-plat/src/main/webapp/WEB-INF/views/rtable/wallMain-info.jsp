<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>玉门市新型墙材生产企业报表</title>
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
		self.location = "${pageContext.request.contextPath}/wallMain";
	}
</script>
<style type="text/css">
th, td, input {
	font-size: 12px;
}

.noborder {
	font-size: 12px;
}
</style>
</head>
<body>
	<div id="p" class="easyui-panel" title="报表填写"
		style="width: 100%; min-height: 200px; padding: 10px;">
		<form id="myform" action="add" method="post">
			<table>
				<caption>玉门市新型墙材生产企业报表</caption>
				<caption>
					<label style="font-size: 22px; font-weight: bold;">${wallMain.name}</label>
				</caption>
				<tbody>
					<tr>
						<td class="noborder" colspan="3">填报单位（公章）：</td>
						<td colspan="12" class="noborder" style="text-align: left;"><label
							>${wallMain.corptitle}</label></td>
						<td colspan="4" class="noborder">填报日期：<label>${wallMain.tbdatestr}</label>
						</td>
					</tr>
					<tr>
						<td rowspan="2">序号</td>
						<td rowspan="2">产品名称</td>
						<td colspan="2">产品产量（ m³）</td>
						<td colspan="2">煤耗 （吨）</td>
						<td colspan="2">电耗 （ 度）</td>
						<td colspan="2">水耗 （ m³）</td>
						<td colspan="2">销售 （ m³）</td>
						<td colspan="6">掺 废</td>
						<td rowspan="2">备注</td>
					</tr>
					<tr>
						<td>本月</td>
						<td>累计</td>
						<td>本月</td>
						<td>累计</td>
						<td>本月</td>
						<td>累计</td>
						<td>本月</td>
						<td>累计</td>
						<td>本月</td>
						<td>累计</td>
						<td>名称</td>
						<td>用量（吨）</td>
						<td>名称</td>
						<td>用量（吨）</td>
						<td>名称</td>
						<td>用量（吨）</td>
					</tr>
					<c:forEach items="${contentList}" var="content" varStatus="num">
						<tr>
							<td><label>${num.index+1}</label></td>
							<td><label>${content.name}</label></td>
							<td><label>${content.a}</label></td>
							<td><label>${content.b}</label></td>
							<td><label>${content.c}</label></td>
							<td><label>${content.d}</label></td>
							<td><label>${content.e}</label></td>
							<td><label>${content.f}</label></td>
							<td><label>${content.g}</label></td>
							<td><label>${content.h}</label></td>
							<td><label>${content.i}</label></td>
							<td><label>${content.j}</label></td>
							<td><label>${content.k}</label></td>
							<td><label>${content.l}</label></td>
							<td><label>${content.m}</label></td>
							<td><label>${content.n}</label></td>
							<td><label>${content.o}</label></td>
							<td><label>${content.p}</label></td>
							<td><label>${content.q}</label></td>
						</tr>
					</c:forEach>
			</table>
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
