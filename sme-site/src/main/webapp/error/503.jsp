<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"><head>
    <meta charset="utf-8">
    <title>CMS 503错误页面</title>
    <meta name="description" content="">
    <meta name="author" content="">

	<%@include file="/include/bsie_head.jsp" %>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/unicorn/css/style.css">

    <style type="text/css">
      body {
        padding-top: 0px;
        padding-bottom: 0px;
      }

    </style>
  </head>

<body>

  <%@include file="/include/top.jsp" %>
                <div class="error-page">
                    <h1 class="error-code color-red">Error 503</h1>
                    <p class="error-description muted">对不起，服务器当前不可用!</p>
                 
                    <a href="#" onclick="history.back(-1)" class="btn btn-small btn-primary"><i class="icon-white icon-arrow-left"></i> 返回上一页</a>
                    <a href="${pageContext.request.contextPath}/"  class="btn btn-small btn-success">返回首页 <i class="icon-white icon-arrow-right"></i></a>
                </div>

  <%@include file="/include/copyright.jsp" %>


  
	<%@include file="/include/bsie_foot.jsp" %>
    <script type="text/javascript">

    </script>

</body></html>