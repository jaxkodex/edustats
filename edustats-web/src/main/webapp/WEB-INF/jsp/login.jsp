<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="Toma el control en tu IE">
<meta name="keywords" content="instituciones educativas, peru, educacion, estadisitica">

<title>Edustats | Toma el control en tu IE</title>

<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/simple-sidebar.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/metisMenu.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" />

</head>
<body>

<div class="container">
	<div class="col-sm-6 col-sm-offset-3">
		<div class="login-box">
			<div class="text-center">
				<h1>Edustats</h1>
			</div>
			<c:if test="${param.error != null}">
			<div class="alert alert-danger">
				<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
				Usuario y/o contraseña incorrecta.
			</div>
			</c:if>
			<form action="${pageContext.request.contextPath}/login" method="POST">
				<div class="form-group">
					<label for="username">Usuario</label>
					<input id="username" name="username" class="form-control input-sm" type="text" />
				</div>
				<div class="form-group">
					<label for="password">Contraseña</label>
					<input id="password" name="password" class="form-control input-sm" type="password" />
				</div>
				<button type="submit" class="btn btn-primary">Ingresar</button>
			</form>
		</div>
	</div>
</div>

</body>
</html>