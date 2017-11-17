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
		<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	function submit() {
		//if($("#myform").form('validate'))
		document.getElementById('myform').submit();
	}
	function BackIndex() {
		self.location = "${pageContext.request.contextPath}/waterMain";
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
		<input type="hidden" name="reportid" value="${report.id}">
		<input type="hidden" name="isattach" value="${report.isattach}">
			<table>
				<caption>酒泉市工业固体废物综合利用情况表</caption>
				<tbody>
					<tr>
						<td class="noborder">企业名称:</td>
						<td colspan="6" class="noborder"><label style="float: left;">${corp.title}</label><input
							name="corpid" type="hidden" value="${corp.id}" /></td>
						<td class="noborder">填表时间</td>
						<td colspan="2" class="noborder">
							<input style="width: 100px;" name="tbtime"
							 class="easyui-datebox" />
							</td>
					</tr>
					<tr>
						<th rowspan="2">种类</th>
						<td colspan="3">实际产生量(万吨)</td>
						<td colspan="3">综合利用量(万吨)</td>
						<td colspan="3">综合利用率(%)</td>
					</tr>
					<tr>
						<td><input name="c_date" type="text" value="2014年" /></td>
						<td><input name="c_date" type="text" value="2015年1-6月预计" /></td>
						<td><input name="c_date" type="text" value="2015年全年预计" /></td>
						<td><input name="c_date" type="text" value="2014年" /></td>
						<td><input name="c_date" type="text" value="2015年1-6月预计" /></td>
						<td><input name="c_date" type="text" value="2015年全年预计" /></td>
						<td><input name="c_date" type="text" value="2014年" /></td>
						<td><input name="c_date" type="text" value="2015年1-6月预计" /></td>
						<td><input name="c_date" type="text" value="2015年全年预计" /></td>
					</tr>
					<tr>
						<td>一、尾矿</td>
						<td><input name="c_a" type="text" /></td>
						<td><input name="c_a" type="text" /></td>
						<td><input name="c_a" type="text" /></td>
						<td><input name="c_a" type="text" /></td>
						<td><input name="c_a" type="text" /></td>
						<td><input name="c_a" type="text" /></td>
						<td><input name="c_a" type="text" /></td>
						<td><input name="c_a" type="text" /></td>
						<td><input name="c_a" type="text" /></td>
					</tr>
					<tr>
						<td>其中：煤矸石</td>
						<td><input name="c_b" type="text" /></td>
						<td><input name="c_b" type="text" /></td>
						<td><input name="c_b" type="text" /></td>
						<td><input name="c_b" type="text" /></td>
						<td><input name="c_b" type="text" /></td>
						<td><input name="c_b" type="text" /></td>
						<td><input name="c_b" type="text" /></td>
						<td><input name="c_b" type="text" /></td>
						<td><input name="c_b" type="text" /></td>
					</tr>
					<tr>
						<td>二、冶炼渣</td>
						<td><input name="c_c" type="text" /></td>
						<td><input name="c_c" type="text" /></td>
						<td><input name="c_c" type="text" /></td>
						<td><input name="c_c" type="text" /></td>
						<td><input name="c_c" type="text" /></td>
						<td><input name="c_c" type="text" /></td>
						<td><input name="c_c" type="text" /></td>
						<td><input name="c_c" type="text" /></td>
						<td><input name="c_c" type="text" /></td>
					</tr>
					<tr>
						<td>其中：工业炉渣</td>
						<td><input name="c_d" type="text" /></td>
						<td><input name="c_d" type="text" /></td>
						<td><input name="c_d" type="text" /></td>
						<td><input name="c_d" type="text" /></td>
						<td><input name="c_d" type="text" /></td>
						<td><input name="c_d" type="text" /></td>
						<td><input name="c_d" type="text" /></td>
						<td><input name="c_d" type="text" /></td>
						<td><input name="c_d" type="text" /></td>
					</tr>
					<tr>
						<td>三、化工废渣</td>
						<td><input name="c_e" type="text" /></td>
						<td><input name="c_e" type="text" /></td>
						<td><input name="c_e" type="text" /></td>
						<td><input name="c_e" type="text" /></td>
						<td><input name="c_e" type="text" /></td>
						<td><input name="c_e" type="text" /></td>
						<td><input name="c_e" type="text" /></td>
						<td><input name="c_e" type="text" /></td>
						<td><input name="c_e" type="text" /></td>
					</tr>
					<tr>
						<td>其中：工业副产石膏</td>
						<td><input name="c_f" type="text" /></td>
						<td><input name="c_f" type="text" /></td>
						<td><input name="c_f" type="text" /></td>
						<td><input name="c_f" type="text" /></td>
						<td><input name="c_f" type="text" /></td>
						<td><input name="c_f" type="text" /></td>
						<td><input name="c_f" type="text" /></td>
						<td><input name="c_f" type="text" /></td>
						<td><input name="c_f" type="text" /></td>
					</tr>
					<tr>
						<td>电石渣</td>
						<td><input name="c_g" type="text" /></td>
						<td><input name="c_g" type="text" /></td>
						<td><input name="c_g" type="text" /></td>
						<td><input name="c_g" type="text" /></td>
						<td><input name="c_g" type="text" /></td>
						<td><input name="c_g" type="text" /></td>
						<td><input name="c_g" type="text" /></td>
						<td><input name="c_g" type="text" /></td>
						<td><input name="c_g" type="text" /></td>
					</tr>
					<tr>
						<td>四、其它废渣</td>
						<td><input name="c_h" type="text" /></td>
						<td><input name="c_h" type="text" /></td>
						<td><input name="c_h" type="text" /></td>
						<td><input name="c_h" type="text" /></td>
						<td><input name="c_h" type="text" /></td>
						<td><input name="c_h" type="text" /></td>
						<td><input name="c_h" type="text" /></td>
						<td><input name="c_h" type="text" /></td>
						<td><input name="c_h" type="text" /></td>
					</tr>
					<tr>
						<td>其中：粉煤灰</td>
						<td><input name="c_i" type="text" /></td>
						<td><input name="c_i" type="text" /></td>
						<td><input name="c_i" type="text" /></td>
						<td><input name="c_i" type="text" /></td>
						<td><input name="c_i" type="text" /></td>
						<td><input name="c_i" type="text" /></td>
						<td><input name="c_i" type="text" /></td>
						<td><input name="c_i" type="text" /></td>
						<td><input name="c_i" type="text" /></td>
					</tr>
					<tr>
						<td>合计</td>
						<td><input name="c_j" type="text" /></td>
						<td><input name="c_j" type="text" /></td>
						<td><input name="c_j" type="text" /></td>
						<td><input name="c_j" type="text" /></td>
						<td><input name="c_j" type="text" /></td>
						<td><input name="c_j" type="text" /></td>
						<td><input name="c_j" type="text" /></td>
						<td><input name="c_j" type="text" /></td>
						<td><input name="c_j" type="text" /></td>
					</tr>
					<tr>
						<td class="noborder">审核领导：</td>
						<td colspan="7" class="noborder"><input name="shleader"
							type="text" style="text-align: left;" />
						<td class="noborder">填表人：</td>
						<td class="noborder"><input name="tbname" type="text" /></td>
					</tr>
				</tbody>
			</table>
			<div
				style="width: 96%; margin: 0 auto; font-size: 14px; margin-left: 5%; margin-top: 20px;">
				<div style="line-height: 30px; font-size: 12px;">备注：工业固体废物产生量指企业在生产过程中产生的固体状、半固体状和高浓度液体状废弃物的总量，包括危险废物、冶炼废渣、粉煤灰、炉渣、煤矸石、尾矿、放射性废物和其他废物等。</div>
				<div style="line-height: 30px; font-size: 12px;">资源综合利用是指在矿产资源开采过程中对共生、伴生矿进行综合开发与合理利用；对生产过程中产生的废渣、废水(液)、废气、余热、余压等进行回收和合理利用。对此表进行调查统计时，不应只局限于通过认定的资源综合利用企业，而应对其他工业企业和其他行业工业固废综合利用情况也进行调查统计。请于2015年6月底和12月底前报上报市工信委环资科。</div>
				<div style="line-height: 30px; font-size: 12px;">其它废渣是指除三种废渣以外的所有废渣，废渣种类可另附说明。</div>
			</div>
			<div style="float: right;">
				<tr style="height: 80px;">
					<td colspan="2" style="text-align: right"><a id="btnAdd"
						style="margin-top: 30px;" class="easyui-linkbutton"
						data-options="iconCls:'icon-add'" href="javascript:"
						onclick="submit()">确认提交</a> <a id="btnBack"
						style="margin-top: 30px;" class="easyui-linkbutton"
						data-options="iconCls:'icon-back'" href="javascript:"
						onclick="BackIndex()">返回</a>
				</tr>
			</div>
		</form>
	</div>
</body>

</html>
