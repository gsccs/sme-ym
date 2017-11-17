<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<style>
.footer {
    padding-top: 75px;
    height: 0;
    width: 0;
}
.footer .footer-inner {
    text-align: center;
    position: absolute;
    z-index: auto;
    left: 0;
    right: 0;
    bottom: 0;
}

.footer .footer-inner .footer-content {
    position: absolute;
    left: 12px;
    right: 12px;
    bottom: 4px;
    padding: 8px;
    line-height: 36px;
    border-top: 3px double #E5E5E5;
}

.bigger-120 {
    font-size: 120% !important;
}
</style>
	<div class="footer">
        <div class="footer-inner">
            <div class="footer-content">
                <span class="bigger-120">
                    <span class="blue bolder">中小企业服务平台</span>
                    © 2016
                    <small>
					<cite title="Source Title">玉门市工业和信息化局</cite>
                    </small>

                </span>
                &nbsp; &nbsp;
                <span class="action-buttons">
                    <a href="#">
                        <i class="ace-icon fa fa-weibo text-danger bigger-150"></i>
                    </a>

                    <a href="#">
                        <i class="ace-icon fa fa-weixin text-success bigger-150"></i>
                    </a>
                </span>
            </div>
        </div>
    </div>
	<!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="${pageContext.request.contextPath}/resources/assets/js/jquery-2.0.3.min.js"></script>
		<!-- <![endif]-->

		<!--[if IE]>
		<script src="${pageContext.request.contextPath}/resources/assets/js/jquery-1.10.2.min.js"></script>
		<![endif]-->
		
		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='${pageContext.request.contextPath}/resources/assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
		</script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<!--[if lte IE 8]>
		  <script src="${pageContext.request.contextPath}/resources/assets/js/excanvas.min.js"></script>
		<![endif]-->

		<script src="${pageContext.request.contextPath}/resources/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.slimscroll.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.easy-pie-chart.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.sparkline.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/flot/jquery.flot.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/flot/jquery.flot.pie.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/flot/jquery.flot.resize.min.js"></script>

		<!-- ace scripts -->

		<script src="${pageContext.request.contextPath}/resources/assets/js/ace-elements.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/layer/layer.js" type="text/javascript" ></script>