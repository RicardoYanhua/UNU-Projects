<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.unu.WebApplication.beans.*" %>
<%@ page import = "java.util.*"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	
	body {
		margin : 0;
		display:flex;
		flex-wrap: wrap;
		justify-content: center;
		align-items: center;
		height: 100vh;
		background-color: rgb(245,245,255);
		
	}
	
	.content{
	border-radius : 15px;
	padding:20px;
		border : 1px solid rgb(220,220,220);
		background-color: rgb(255,255,255);
		width: 40%;
	}
	
	.form-content form{
	padding : 20px;
		display:grid;
		flex-wrap:wrap;
		align-content: center;
		justify-content: center;
		border : 1px solid rgb(220,220,220);
		
	}
	

</style>


</head>
<body>
<%
String url = "http://localhost:8080/WebProjectTrabajadores/";
List<Object[]> listaAreas= (List<Object[]>) request.getAttribute("listaArea");
List<Object[]> listaProfesion= (List<Object[]>) request.getAttribute("listaProfesion");

%>
<div class = "content">

<div class = "tittles">
	<h2>REGISTRO DE TRABAJADOR</h2>
	<h3>Datos del Trabajador</h3>
</div>
<div class = "form-content">
	<form  role = "form" action="<%=url%>TrabajadorController">

	<input type = "hidden" id = "op" name = "op" value = "registrar">

	<label for = "dni">DNI Trabajador</label>
	<input type = "number" placeholder="Ingresar DNI" id = "dni" name ="dni" required>
	
	<label for = "fecha">Fecha</label>
	<input type = "date" id = "fecha" name = "fecha" required>
	
	<label for = "nombres">Nombres</label>
	<input type = "text" id = "nombres" name = "nombres" required>
	
	<label for="idarea">Área</label>
	<select id="idarea" name="idarea" required>
  		<option value="" disabled selected>Seleccionar una opción</option>
  <% 
    		if (listaAreas != null) {
      			for (Object[] a : listaAreas) { 
  %>
    	<option value="<%=a[0]%>"><%=a[1]%></option>
  <%
      			}
   		 	} 
  %>
	</select>
	
	<label for = "nafp">Numero AFP </label>
	<input type = "text" id = "nafp" name = "nafp" required>
	
	
	<label for = "codEsalud">Codigo Esalud </label>
	<input type = "text" id = "codEsalud" name = "codEsalud" required>
	
	<label for = "sueldo">Sueldo </label>
	<input type = "number" id = "sueldo" name = "sueldo" required>
	
	<label for="idprofesion">Profesion</label>
	<select id="idprofesion" name="idprofesion" required>
  		<option value="" disabled selected>Seleccionar una opción</option>
  <% 
    		if (listaProfesion != null) {
      			for (Object[] p : listaProfesion) { 
  %>
    	<option value="<%=p[0]%>"><%=p[1]%></option>
  <%
      			}
   		 	} 
  %>
	</select>
	
	<input  onclick="return message()" type = "submit" value = "Registrar Trabajdor"> <br>
	<a type = "button" href = "<%=url%>TrabajadorController">Cancelar</a>

</form>
</div>

</div>

<script>
function message() {
	return confirm("Acction ? ");
}

</script>


</body>
</html>