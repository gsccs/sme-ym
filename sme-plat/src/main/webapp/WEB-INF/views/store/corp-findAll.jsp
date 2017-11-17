<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/default.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/Site.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/Verification.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/Common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/MD5xx.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/easyui/syUtil.js"
	charset="utf-8"></script>
<script type="text/javascript">
	function BackIndex() {
		self.location = "${pageContext.request.contextPath}/corp";
	}
</script>
<style type="text/css">
.edit_title{
min-width: 70px;
}
</style>
</head>
<body style="margin: 10px; padding: 0px; background-color: #fff;">
	<fieldset>
		<legend style="font-weight: bold; font-size: 16pt; color: #E3393C;">企业详情</legend>
		<form id="myform" action="add" method="post">
			<table cellpadding="3" cellspacing="0" class="edit_table"
				id="tbEditForm">
				<tr>
					<td class="edit_title" style="width: 84px;">企业名称：</td>
					<td><label>${corp.title}</label></td>
				</tr>
				<tr>
					<td class="edit_title">组织机构代码：</td>
					<td><label>${corp.orgcode}</label></td>
				</tr>
				<tr>
					<td class="edit_title">工商注册编码：</td>
					<td><label>${corp.regcode}</label></td>
				</tr>
				<tr>
					<td class="edit_title">企业注册类型：</td>
					<td><label>${corp.regtype}</label></td>
				</tr>
				<tr>
					<td class="edit_title">联系电话：</td>
					<td><label>${corp.phone}</label></td>
				</tr>
				<tr>
					<td class="edit_title">邮箱地址：</td>
					<td><label>${corp.email}</label></td>
				</tr>
<%-- 				<tr>
					<td class="edit_title">domain：</td>
					<td><label>${corp.domain}</label></td>
				</tr> --%>
				<tr>
					<td class="edit_title">单位性质：</td>
					<td><label>${corp.nature}</label></td>
				</tr>
				<tr>
					<td class="edit_title">法人：</td>
					<td><label>${corp.legaler}</label></td>
				</tr>
				<tr>
					<td class="edit_title">联系人：</td>
					<td><label>${corp.linker}</label></td>
				</tr>
<%-- 				<tr>
					<td class="edit_title">pcode：</td>
					<td><label>${corp.pcode}</label></td>
				</tr>
				<tr>
					<td class="edit_title">ccode：</td>
					<td><label>${corp.ccode}</label></td>
				</tr>
				<tr>
					<td class="edit_title">acode：</td>
					<td><label>${corp.acode}</label></td>
				</tr> --%>
				<tr>
					<td class="edit_title">公司地址：</td>
					<td><label>${corp.address}</label></td>
				</tr>
<%-- 				<tr>
					<td class="edit_title">zipcode：</td>
					<td><label>${corp.zipcode}</label></td>
				</tr> --%>
				<tr>
					<td class="edit_title">QQ：</td>
					<td><label>${corp.qqcode}</label></td>
				</tr>
				<tr>
					<td class="edit_title">所属行业：</td>
					<td><label>${corp.hycode}</label></td>
				</tr>
				<tr>
					<td class="edit_title">子行业类别：</td>
					<td><label>${corp.subhycode}</label></td>
				</tr>
				<tr>
					<td class="edit_title">控股情况：</td>
					<td><label>${corp.stake}</label></td>
				</tr>
<%-- 				<tr>
					<td class="edit_title">created：</td>
					<td><label>${corp.created}</label></td>
				</tr> --%>
				<tr>
					<td class="edit_title">企业logo：</td>
					<td><img src="${corp.logo}"></td>
				</tr>
				<tr>
					<td class="edit_title">简要介绍：</td>
					<td><label>${corp.content}</label></td>
				</tr>
<%-- 				<tr>
					<td class="edit_title">status：</td>
					<td><label>${corp.status}</label></td>
				</tr> --%>

				<tr style="height: 50px;">
					<td colspan="2" style="text-align: right"><a id="btnBack"
						class="easyui-linkbutton" data-options="iconCls:'icon-back'"
						href="javascript:" onclick="BackIndex()">返回</a>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>
