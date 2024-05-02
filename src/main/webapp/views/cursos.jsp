<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% List<String> cursos = ((List<String>)request.getAttribute("cursos")); %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="views/styles/estilos.css">
<meta charset="UTF-8">
<title>Cursos</title>
</head>
<body>
	<h1><%=session.getAttribute("login").toString()%></h1>
		<% for( String value : cursos ){ %>  
  	<h4><%= value %></h4>
		<%}%>
	<form action="ServletCursos" method="get">
		<div>
			<label for="curso">Introduce curso</label> <input type="text"
				id="curso" name="curso" required />
		</div>
		<div class="button">
			<button type="submit">Añadir</button>
		</div>
	</form>
</body>
</html>