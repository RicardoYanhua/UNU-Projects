<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style type="text/css">
		body {
			background-color: rgb(245,245,255);
			margin : 0;
			display:flex;
			justify-content: center;
			align-items: center;
			height: 100vh;
			
		}
		.container{
			background-color: rgb(255,255,255);
			border: 1px solid rgb(220,220,220);
			box-shadow: 0px 0px 10px 5px rgbs(0,0,0,0.2);
			padding: 15px;
			border-radius: 8px;
		}
		.botones{
		display: grid;
		
		}
		.titulo {
		text-align: center;
		font-weight: bold;
		margin-bottom: 20px;
		}
		.botones a {
			text-decoration: none;
			background-color: rgb(34,34,34);
			color: rgb(255,255,255);
			padding: 10px 15px;
			margin: 5px;
			border-radius: 5px;
			transition: background-color 1s ;
			
		}
		.botones a:hover {
			background-color: rgb(255,54,54);
		}
		.botones a:active {
	background-color: rgb(255,0,0);
}
		
	</style>

</head>
<body>
<%
String url = "http://localhost:8080/WebProjectTrabajadores/";
%>

	<div class = "container">
		<div class = "titulo">
			<label>MENU DE OPCIONES</label>
		</div>
		
		<div class = "botones">
			<a type = "button" href = "<%=url%>TrabajadorController">REGISTRO TRABAJADOR</a>
			<a type = "button" href = "<%=url%>AsistenciaController">ASISTENCIA</a>
		</div>
	
	</div>

</body>
</html>