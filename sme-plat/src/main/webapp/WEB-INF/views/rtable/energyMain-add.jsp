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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	function submit() {
		//if($("#myform").form('validate'))
		document.getElementById('myform').submit();
	}
	function BackIndex() {
		self.location = "${pageContext.request.contextPath}/energyMain";
	}
</script>
</head>
<body>
	<div id="p" class="easyui-panel" title="报表填写"
		style="width: 100%; min-height: 200px; padding: 10px;">
		<form id="myform" action="add" method="post">
			<input type="hidden" name="reportid" value="${report.id}"> <input
				type="hidden" name="isattach" value="${report.isattach}">
			<table>
				<caption>工业重点用能企业能源消耗情况月报表</caption>
				<tbody>
					<tr>
						<td class="noborder">企业名称（盖章）：</td>
						<td colspan="3" class="noborder"><label style="float: left;">${corp.title}</label><input
							name="corpid" type="hidden" value="${corp.id}" /></td>
						<td class="noborder">数据统计期间：</td>
						<td class="noborder"><input class="tleft"
							type="text" />   <input style="width: 100px;" name="startdate" value="new Date()"
							 class="easyui-datebox" />~<input style="width: 100px;" name="enddate"
							 class="easyui-datebox" /> </td>
					</tr>
					<tr>
						<td>所属行业</td>
						<td><input name="qyIndustry" type="text" /></td>
						<td>工业总产值（万元）</td>
						<td><input name="industryAll" type="text" /></td>
						<td>工业增加值（万元）</td>
						<td><input name="industryAdd" type="text" /></td>
					</tr>
					<tr>
						<td>综合能耗量 （万吨标准煤）</td>
						<td><input name="a" type="text" /></td>
						<td>电耗量（万kwh）</td>
						<td><input name="b" type="text" /></td>
						<td>水耗量（立方米）</td>
						<td><input name="c" type="text" /></td>
					</tr>

					<tr>
						<td>工业总产值能耗 （吨标准煤/万元）</td>
						<td><input name="d" type="text" /></td>
						<td>工业总产值电耗 （千瓦时/万元）</td>
						<td><input name="e" type="text" /></td>
						<td>工业总产值水耗 （立方米/万元）</td>
						<td><input name="f" type="text" /></td>
					</tr>
					<tr>
						<td>工业增加值能耗（吨标准煤/万元）</td>
						<td><input name="g" type="text" /></td>
						<td>工业增加值电耗（千瓦时/万元）</td>
						<td><input name="h" type="text" /></td>
						<td>工业增加值水耗（立方米/万元）</td>
						<td><input name="i" type="text" /></td>
					</tr>
					<tr>
						<th rowspan="3">主要生产工艺名称</th>
						<td>工艺1</td>
						<td colspan="4"><input name="gyName" type="text" /></td>
					</tr>
					<tr>
						<td>工艺2</td>
						<td colspan="4"><input name="gyName" type="text" /></td>
					</tr>
					<tr>
						<td>工艺3</td>
						<td colspan="4"><input name="gyName" type="text" /></td>
					</tr>
					<tr>
						<th>主要产品</th>
						<th>单位</th>
						<th>产量</th>
						<th>单位产品综合能耗（吨标准煤）</th>
						<th>单位产品综合电耗（千瓦时）</th>
						<th>单位产品水耗（立方米）</th>
					</tr>
					<tr>
						<td><input name="p_product" type="text" /></td>
						<td><input name="p_unit" type="text" /></td>
						<td><input name="p_number" type="text" /></td>
						<td><input name="p_a" type="text" /></td>
						<td><input name="p_b" type="text" /></td>
						<td><input name="p_c" type="text" /></td>
					</tr>
					<tr>
						<td><input name="p_product" type="text" /></td>
						<td><input name="p_unit" type="text" /></td>
						<td><input name="p_number" type="text" /></td>
						<td><input name="p_a" type="text" /></td>
						<td><input name="p_b" type="text" /></td>
						<td><input name="p_c" type="text" /></td>
					</tr>
					<tr>
						<td><input name="p_product" type="text" /></td>
						<td><input name="p_unit" type="text" /></td>
						<td><input name="p_number" type="text" /></td>
						<td><input name="p_a" type="text" /></td>
						<td><input name="p_b" type="text" /></td>
						<td><input name="p_c" type="text" /></td>
					</tr>
					<tr>

					</tr>
				</tbody>
			</table>
			<div style="width: 96%; margin: 0 auto; font-size: 14px;">
				<div style="width: 10%; float: left; margin-left: 5%;">
					<label>单位负责人：</label>
				</div>
				<div style="width: 14%; float: left;">
					<input name="header" class="tleft" type="text" />
				</div>
				<div style="width: 8%; float: left;">
					<label>填表人：</label>
				</div>
				<div style="width: 16%; float: left;">
					<input name="writer" class="tleft" type="text" />
				</div>
				<div style="width: 8%; float: left;">
					<label>联系电话：</label>
				</div>
				<div style="width: 16%; float: left;">
					<input name="phone" class="tleft" type="text" />
				</div>
				<div style="width: 8%; float: left;">
					<label>报出日期：</label>
				</div>
				<div style="width: 11%; float: left;">
					<input style="width: 100px;" name="bcTime"
							value="new Date()" class="easyui-datebox" />
				</div> 
			</div>
			<div style="float: right;">
				<tr style="height: 80px;">
					<td colspan="2" style="text-align: right"><a id="btnAdd"
						style="margin-top: 30px;" class="easyui-linkbutton"
						data-options="iconCls:'icon-add'" href="javascript:"
						onclick="submit()">确认提交</a> <a id="btnBack"
						style="margin-top: 30px;" class="easyui-linkbutton"
						data-options="iconCls:'icon-back'" href="javascript:"
						onclick="BackIndex()">返回</a></td>
				</tr>
			</div>
		</form>
	</div>
</body>

</html>
