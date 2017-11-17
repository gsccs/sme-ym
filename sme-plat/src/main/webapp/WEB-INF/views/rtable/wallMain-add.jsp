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
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	function submit() {
		document.getElementById('myform').submit();
	}
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
		<input type="hidden" name="reportid" value="${report.id}">
		<input type="hidden" name="isattach" value="${report.isattach}">
			<table>
				<caption>玉门市新型墙材生产企业报表</caption>
				<caption>
					<input name="name" type="text" value="（      ）月 "
						style="font-size: 22px; font-weight: bold;" />
				</caption>
				<tbody>
					<tr>
						<td class="noborder" colspan="3">填报单位（公章）：</td>
						<td colspan="12" class="noborder"><label style="float: left;">${corp.title}</label><input
							name="corpid" type="hidden" value="${corp.id}" /></td>
							<td class="noborder" colspan="3">填报时间：</td>
						<td colspan="4" class="noborder">
							<input style="width: 100px;" name="tbdate"
							 class="easyui-datebox" />
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
					<tr>
						<td><input type="text" value="1" /></td>
						<td><input name="c_name" type="text" /></td>
						<td><input name="c_a" type="text" /></td>
						<td><input name="c_b" type="text" /></td>
						<td><input name="c_c" type="text" /></td>
						<td><input name="c_d" type="text" /></td>
						<td><input name="c_e" type="text" /></td>
						<td><input name="c_f" type="text" /></td>
						<td><input name="c_g" type="text" /></td>
						<td><input name="c_h" type="text" /></td>
						<td><input name="c_i" type="text" /></td>
						<td><input name="c_j" type="text" /></td>
						<td><input name="c_k" type="text" /></td>
						<td><input name="c_l" type="text" /></td>
						<td><input name="c_m" type="text" /></td>
						<td><input name="c_n" type="text" /></td>
						<td><input name="c_o" type="text" /></td>
						<td><input name="c_p" type="text" /></td>
						<td><input name="c_q" type="text" /></td>
					</tr>
					<tr>
						<td><input type="text" value="2" /></td>
						<td><input name="c_name" type="text" /></td>
						<td><input name="c_a" type="text" /></td>
						<td><input name="c_b" type="text" /></td>
						<td><input name="c_c" type="text" /></td>
						<td><input name="c_d" type="text" /></td>
						<td><input name="c_e" type="text" /></td>
						<td><input name="c_f" type="text" /></td>
						<td><input name="c_g" type="text" /></td>
						<td><input name="c_h" type="text" /></td>
						<td><input name="c_i" type="text" /></td>
						<td><input name="c_j" type="text" /></td>
						<td><input name="c_k" type="text" /></td>
						<td><input name="c_l" type="text" /></td>
						<td><input name="c_m" type="text" /></td>
						<td><input name="c_n" type="text" /></td>
						<td><input name="c_o" type="text" /></td>
						<td><input name="c_p" type="text" /></td>
						<td><input name="c_q" type="text" /></td>
					</tr>
					<tr>
						<td><input type="text" value="3" /></td>
						<td><input name="c_name" type="text" /></td>
						<td><input name="c_a" type="text" /></td>
						<td><input name="c_b" type="text" /></td>
						<td><input name="c_c" type="text" /></td>
						<td><input name="c_d" type="text" /></td>
						<td><input name="c_e" type="text" /></td>
						<td><input name="c_f" type="text" /></td>
						<td><input name="c_g" type="text" /></td>
						<td><input name="c_h" type="text" /></td>
						<td><input name="c_i" type="text" /></td>
						<td><input name="c_j" type="text" /></td>
						<td><input name="c_k" type="text" /></td>
						<td><input name="c_l" type="text" /></td>
						<td><input name="c_m" type="text" /></td>
						<td><input name="c_n" type="text" /></td>
						<td><input name="c_o" type="text" /></td>
						<td><input name="c_p" type="text" /></td>
						<td><input name="c_q" type="text" /></td>
					</tr>
					<tr>
						<td><input type="text" value="4" /></td>
						<td><input name="c_name" type="text" /></td>
						<td><input name="c_a" type="text" /></td>
						<td><input name="c_b" type="text" /></td>
						<td><input name="c_c" type="text" /></td>
						<td><input name="c_d" type="text" /></td>
						<td><input name="c_e" type="text" /></td>
						<td><input name="c_f" type="text" /></td>
						<td><input name="c_g" type="text" /></td>
						<td><input name="c_h" type="text" /></td>
						<td><input name="c_i" type="text" /></td>
						<td><input name="c_j" type="text" /></td>
						<td><input name="c_k" type="text" /></td>
						<td><input name="c_l" type="text" /></td>
						<td><input name="c_m" type="text" /></td>
						<td><input name="c_n" type="text" /></td>
						<td><input name="c_o" type="text" /></td>
						<td><input name="c_p" type="text" /></td>
						<td><input name="c_q" type="text" /></td>
					</tr>
			</table>
			<div></div>
			<div style="float: right;">
				<tr style="height: 80px;">
					<td colspan="2" style="text-align: right"><a id="btnAdd"
						style="margin-top: 30px;" class="easyui-linkbutton"
						data-options="iconCls:'icon-add'" href="javascript:"
						onclick="submit()">确认提交</a> <a id="btnBack"
						style="margin-top: 30px;" class="easyui-linkbutton"
						data-options="iconCls:'icon-back'" href="javascript:"
						onclick="BackIndex()">返回</a>
						</td>
				</tr>
			</div>
		</form>
	</div>
</body>

</html>
