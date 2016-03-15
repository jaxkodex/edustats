<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Edustats | Administración</title>

    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/jquery-ui.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/simple-sidebar.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/metisMenu.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet" />
    
    <link href="${pageContext.request.contextPath}/resources/css/admin.css" rel="stylesheet" />
    
    <link href="${pageContext.request.contextPath}/resources/css/spinkit.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/loading.css" rel="stylesheet">
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
    var baseUrl = '${pageContext.request.contextPath}';
    var userData = ${userData};
    var ies = ${ies};
    </script>
</head>

<body>
  <div class="loading-holder">
      <div class="loading-message">
          Cargando
          <div class="sk-wave">
          <div class="sk-rect sk-rect1"></div>
          <div class="sk-rect sk-rect2"></div>
          <div class="sk-rect sk-rect3"></div>
          <div class="sk-rect sk-rect4"></div>
          <div class="sk-rect sk-rect5"></div>
        </div>
      </div>
  </div>

    <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
          <div id="menu"></div>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
              <div id="top" class="row"></div>
                <div class="row">
                    <div id="main" class="col-lg-12">
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->


	<c:if test="${not isJavascriptMinified}">
    <script data-main="${pageContext.request.contextPath}/resources/js/app/config" src="${pageContext.request.contextPath}/resources/js/libs/require.js"></script>
    </c:if>
    <c:if test="${isJavascriptMinified}">
    <script data-main="${pageContext.request.contextPath}/resources/js/app.min.js" src="${pageContext.request.contextPath}/resources/js/libs/require.js"></script>
    </c:if>
</body>
</html>
