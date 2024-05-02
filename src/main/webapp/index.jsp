<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="views/styles/estilos.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ServletLogin" method="post">
		<div>
			<label for="name">Nombre:</label> <input type="text" id="name"
				name="user_name" required/>
		</div>
		<div>
			<label for="password">Contraseña:</label> <input type="password"
				id="password" name="user_password" required/>
		</div>
		<a href="ServletLogin?register=si"> Registrar nueva cuenta </a>
		<div class="button">
			<button type="submit">Login</button>
		</div>
	</form>
<%
    if(null!=request.getAttribute("errorMessage"))
    {
        out.println(request.getAttribute("errorMessage"));
    }
%>
</body>
</html>