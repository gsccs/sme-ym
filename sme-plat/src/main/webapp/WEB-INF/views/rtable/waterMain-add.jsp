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
	function submit() {
		//if($("#myform").form('validate'))
		document.getElementById('myform').submit();
	}
	function BackIndex() {
		self.location = "${pageContext.request.contextPath}/waterMain";
	}
</script>
</head>
<body>
	<div id="p" class="easyui-panel" title="报表填写"
		style="width: 100%; min-height: 200px; padding: 10px;">
		<form id="myform" action="add" method="post">
		<input type="hidden" name="reportid" value="${report.id}">
		<input type="hidden" name="isattach" value="${report.isattach}">
			<table>
				<caption>重点用水工业企业用水状况基本信息月报表</caption>
				<tbody>
					<tr>
						<td>企业名称（盖章）</td>
						<td colspan="5"><label style="float: left;">${corp.title}</label><input
							name="corpid" type="hidden" value="${corp.id}" /></td>
					</tr>
					<tr>
						<td>通讯地址</td>
						<td colspan="3"><input name="txaddress" type="text" /></td>
						<td>邮政编码</td>
						<td><input name="yznum" type="text" /></td>
					</tr>

					<tr>
						<td>联系人</td>
						<td><input name="linker" type="text" /></td>
						<td>联系电话</td>
						<td><input name="linktel" type="text" /></td>
						<td>传真</td>
						<td><input name="cznum" type="text" /></td>
					</tr>
					<tr>
						<th colspan="2">取水类别</th>
						<th>计量单位</th>
						<th><input name="t_date" type="text"  value="2014年 数值" /></th>
						<th><input name="t_date" type="text"  value="2015年1- 月数值" /></th>
						<th><input name="t_date" type="text"  value="变化率 （±%）" /></th>
					</tr>
					<tr>
						<td colspan="2">地表水</td>
						<td>万立方米</td>
						<td><input name="t_waterDb" type="text" /></td>
						<td><input name="t_waterDb" type="text" /></td>
						<td><input name="t_waterDb" type="text" /></td>
					</tr>
					<tr>
						<td colspan="2">地下水</td>
						<td>万立方米</td>
						<td><input name="t_waterDx" type="text" /></td>
						<td><input name="t_waterDx" type="text" /></td>
						<td><input name="t_waterDx" type="text" /></td>
					</tr>
					<tr>
						<td colspan="2">自来水</td>
						<td>万立方米</td>
						<td><input name="t_waterZl" type="text" /></td>
						<td><input name="t_waterZl" type="text" /></td>
						<td><input name="t_waterZl" type="text" /></td>
					</tr>
					<tr>
						<td colspan="2">其它水</td>
						<td>万立方米</td>
						<td><input name="t_waterQt" type="text" /></td>
						<td><input name="t_waterQt" type="text" /></td>
						<td><input name="t_waterQt" type="text" /></td>
					</tr>
					<tr>
						<td colspan="2">取水总量</td>
						<td>万立方米</td>
						<td><input name="t_waterAll" type="text" /></td>
						<td><input name="t_waterAll" type="text" /></td>
						<td><input name="t_waterAll" type="text" /></td>
					</tr>
					<tr>
						<th colspan="2">用水类别</th>
						<th>计量单位</th>
						<th><input name="u_date" type="text"  value="2014年 数值" /></th>
						<th><input name="u_date" type="text"  value="2015年1- 月数值" /></th>
						<th><input name="u_date" type="text"  value="变化率 （±%）" /></th>
					</tr>
					<tr>
						<td colspan="2">工业用新水</td>
						<td>万立方米</td>
						<td><input name="u_a" type="text" /></td>
						<td><input name="u_a" type="text" /></td>
						<td><input name="u_a" type="text" /></td>
					</tr>
					<tr>
						<td colspan="2">非工业用新水</td>
						<td>万立方米</td>
						<td><input name="u_b" type="text" /></td>
						<td><input name="u_b" type="text" /></td>
						<td><input name="u_b" type="text" /></td>
					</tr>
					<tr>
						<td colspan="2">外供新水</td>
						<td>万立方米</td>
						<td><input name="u_c" type="text" /></td>
						<td><input name="u_c" type="text" /></td>
						<td><input name="u_c" type="text" /></td>
					</tr>
					<tr>
						<td colspan="2">生产用重复用水量</td>
						<td>万立方米</td>
						<td><input name="u_d" type="text" /></td>
						<td><input name="u_d" type="text" /></td>
						<td><input name="u_d" type="text" /></td>
					</tr>
					<tr>
						<td colspan="2">生产用水重复利用率</td>
						<td>%</td>
						<td><input name="u_e" type="text" /></td>
						<td><input name="u_e" type="text" /></td>
						<td><input name="u_e" type="text" /></td>
					</tr>
					<tr>
						<td colspan="2">一级水表计量水量</td>
						<td>万立方米</td>
						<td><input name="u_f" type="text" /></td>
						<td><input name="u_f" type="text" /></td>
						<td><input name="u_f" type="text" /></td>
					</tr>
					<tr>
						<td colspan="2">一级水表计量率</td>
						<td>%</td>
						<td><input name="u_g" type="text" /></td>
						<td><input name="u_g" type="text" /></td>
						<td><input name="u_g" type="text" /></td>
					</tr>
					<tr>
						<td colspan="2">万元产值取水量</td>
						<td>立方米/万元</td>
						<td><input name="u_h" type="text" /></td>
						<td><input name="u_h" type="text" /></td>
						<td><input name="u_h" type="text" /></td>
					</tr>
					<tr>
						<td colspan="2">万元工业增加值取水量</td>
						<td>立方米/万元</td>
						<td><input name="u_i" type="text" /></td>
						<td><input name="u_i" type="text" /></td>
						<td><input name="u_i" type="text" /></td>
					</tr>
					<tr>
						<td colspan="2">废水排放量</td>
						<td>万立方米</td>
						<td><input name="u_j" type="text" /></td>
						<td><input name="u_j" type="text" /></td>
						<td><input name="u_j" type="text" /></td>
					</tr>
					<tr>
						<th colspan="2">单位产品取水量 指标名称</th>
						<th>计量单位</th>
						<th>2014年 指标值</th>
						<th>取水定额</th>
						<th>变化率 （±%）</th>
					</tr>
					<tr>
						<td colspan="2"><input name="q_name" type="text" /></td>
						<td><input name="q_dw" type="text" /></td>
						<td><input name="q_a" type="text" /></td>
						<td><input name="q_b" type="text" /></td>
						<td><input name="q_c" type="text" /></td>
					</tr>
					<tr>
					<td colspan="2"><input name="q_name" type="text" /></td>
						<td><input name="q_dw" type="text" /></td>
						<td><input name="q_a" type="text" /></td>
						<td><input name="q_b" type="text" /></td>
						<td><input name="q_c" type="text" /></td>
					</tr>
					<tr>
						<td colspan="2">节约用水量</td>
						<td>万立方米</td>
						<td colspan="3"><input name="jynum" type="text" /></td>
					</tr>
				</tbody>
			</table>
			<div
				style="width: 96%; margin: 0 auto; font-size: 14px; margin-left: 5%; margin-top: 20px;">
				<div style="font-size: 12px;">填表说明：</div>
				<div style="line-height: 30px; font-size: 12px;">（1）取水总量=地表水+地下水+自来水+其它水；</div>
				<div style="line-height: 30px; font-size: 12px;">（2）工业用新水总量=取水总量-非工业用新水-外供新水；</div>
				<div style="line-height: 30px; font-size: 12px;">（3）节约用水量=(统计期单耗数-基期单耗数)x统计期产品产量。</div>
			</div>
			
			<div style="float:right;">
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
