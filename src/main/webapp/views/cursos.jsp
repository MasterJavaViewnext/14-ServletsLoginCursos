<%@page import="com.cursojava.Login"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% List<String> cursos = ((Login)session.getAttribute("login")).getCursos(); %>
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
  			<form action="ServletDeleteCurso" method="get">
  			<div>
  				<h4><%= value %></h4>		
        		<input type="hidden" name="delete" value="<%=value%>" />
				<button name="submit">Eliminar</button>	
  			</div>
  			</form>
		<%}%>
	<form action="ServletCursos" method="get">
		<div>
			<label for="curso">Introduce curso</label> <input type="text"
				id="curso" name="curso" required />
		</div>
		<div class="button">
			<button type="submit">Matricularse</button>
		</div>
	</form>
</body>
</html>