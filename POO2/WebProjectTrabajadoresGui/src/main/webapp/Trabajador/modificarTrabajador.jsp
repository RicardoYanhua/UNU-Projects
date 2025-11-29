<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.unu.WebApplication.beans.*" %>
<%@ page import = "java.util.*"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<style>
		.content{
			margin : 0;
			display: flex;
			justify-content: center;
			align-items: center;
			width: 100%;
		}
		.content-form{
			width: 50%;
		}
		.tittle{
			margin-top: 30px;
			margin-bottom: 10px;
			padding: 10px 0px 3px 0px;
			
		}
		.tittle h4{
			color: rgb(34,34,34);
			font-weight: bold;
		}
		
		
	</style>

</head>
<body>

<%
Trabajador trabajador;
if((Trabajador) request.getAttribute("trabajador") == null){
	trabajador = new Trabajador();
}else{
	trabajador = (Trabajador) request.getAttribute("trabajador");
}
 
List<Object[]> listaAreas= (List<Object[]>) request.getAttribute("listaArea");
List<Object[]> listaProfesion= (List<Object[]>) request.getAttribute("listaProfesion");
%>

<%@ include file="/menu.jsp" %>

<div class = "content">
<div class = "content-form">

	<div class = "tittle">
		<h4>ModificarTrabajdor</h3>
	</div>
	
	<form  role = "form" action="<%=url%>TrabajadorController">

		<input type = "hidden" id = "op" name = "op" value = "modificar">
		<input type = "hidden" id = "idtrabajador" name = "idtrabajador" value = "<%=trabajador.getIdTrabajador()%>">


		<div class="form-group">
			<label for = "dni">DNI Trabajador</label>
			<input class="form-control" type = "number" placeholder="Ingresar DNI" id = "dni" name ="dni" value = "<%=trabajador.getDni()%>" required>
		</div>

		<div class = "form-group">
			<label for = "fecha">Fecha</label>
			<input class="form-control" type = "date" id = "fecha" name = "fecha" value = "<%=trabajador.getFecha()%>" required>
		</div>
		
		<div class = "form-group">
		<label for = "nombres">Nombres</label>
			<input class="form-control" type = "text" id = "nombres" name = "nombres" value = "<%=trabajador.getNombres()%>" required>
		</div>
		
		<div class = "form-group">
			<label for="idarea">Área</label>
			
			
			
			<select id="idarea" name="idarea" class="form-select" required>
  			<option value="" disabled>Seleccionar una opción</option>
 	 <% 
 	   		if (listaAreas != null) {
 	     			for (Object[] a : listaAreas) { 
	      				if((int)a[0] == trabajador.getIdArea()){
  	 %>
 	     			    	<option value="<%=a[0]%>" selected><%=a[1]%></option>
 	  <%
   		   				}else{
  	 %>
        				<option value="<%=a[0]%>"><%=a[1]%></option>
 	  <%	
    	  				}
  
    	  			}
   			 	} 
 	 %>
			</select>
		</div>
	
		<div class = "form-group">
			<label for = "nafp">Numero AFP </label>
			<input  class="form-control" type = "text" id = "nafp" name = "nafp" value = "<%=trabajador.getnAfp()%>" required>
		</div>
	
		<div class = "form-group">
			<label for = "codEsalud">Codigo Esalud </label>
			<input  class="form-control" type = "text" id = "codEsalud" name = "codEsalud" value = "<%=trabajador.getCodEsalud()%>" required>
		</div>
	
		<div class = "form-group">
			<label for = "sueldo">Sueldo </label>
			<input class = "form-control" type = "number" id = "sueldo" name = "sueldo" value = "<%=trabajador.getSueldo()%>" required>
		</div>
	
		<div class = "form-group">
			<label for="idprofesion">Profesion</label>
			<select class = "form-select" id="idprofesion" name="idprofesion"  required>
  			<option value="" disabled selected>Seleccionar una opción</option>
 	 <% 
    			if (listaProfesion != null) {
      				for (Object[] p : listaProfesion) { 
      					if((int)p[0] == trabajador.getIdProfesion()){
 	 %>
     	 			    	<option value="<%=p[0]%>" selected><%=p[1]%></option>
 	 <%
      					}else{ 				
 	 %>
      				    	<option value="<%=p[0]%>"><%=p[1]%></option>
 	 <%
      					}
 	
      				}
   		 		} 
  	%>
			</select>
		</div>
	
	<div style = "display:flex;justify-content: flex-end;padding: 20px 0px">
		<a class="btn" type = "button" href = "<%=url%>TrabajadorController"> Cancelar</a>
		<input  class="btn btn-primary" onclick="return message()" type = "submit" value = "Guardar Trabajador">
	</div>
		
	</form>
</div>
</div>


<script>
function message() {
	return confirm('Esta seguro de realizar esta accion ?');
}
</script>


</body>
</html>