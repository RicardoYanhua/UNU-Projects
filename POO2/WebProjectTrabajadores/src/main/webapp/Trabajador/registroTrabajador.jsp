<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.unu.WebApplication.beans.*" %>
<%@ page import = "java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String url = "http://localhost:8080/WebProjectTrabajadores/";
List<Object[]> listaTrabajador= (List<Object[]>) request.getAttribute("listaTrabajador");
%>

<div class = "content">

	<div class = "menu">
		<a type = "button" href = "#">RREGISTRO TRABAJADOR</a>
		<a type = "button" href = "#">ASISTENCIA</a>
	</div>
	
	<div>
		<div class = "operaciones">
			<a type = "button" href = "<%=url%>TrabajadorController?op=nuevo">Nuevo trabajador</a>
		</div>
		
		<div class = "contentRegister">
			<table>
				<thead>
					<tr>
						<th>CODIGO</th>
						<th>TRABAJADOR</th>
						<th>AREA</th>
						<th>SUELDO</th>
						<th>MODIFICAR</th>
						<th>ELIMNAR</th>
					</tr>
				</thead>
				<tbody>
					<%
						if(listaTrabajador != null){
							for (Object[] t : listaTrabajador){
					%>
						<tr >
							<td name = "idtrabajador"><%=t[0]%></td>
							<td name = "nombres"><%=t[1]%></td>
							<td name = "area"><%=t[2]%></td>
							<td name = "sueldo"><%=t[3]%></td>
							<td>
								<a type = "button" href = "<%=url%>TrabajadorController?op=obtener&id=<%=t[0]%>">MODIFICAR</a>
							</td>
							<td>
								<a onclick="return message()" type = "button" href = "<%=url%>TrabajadorController?op=eliminar&id=<%=t[0]%>">ELIMINAR</a>
							</td>
							
						</tr>
					
					<%		
						}}else{
					%>
						<tr>
							<td solspan = "6">Sin datos de trabajadores</td>
						</tr>	
					<%
						}
					%>
					
				</tbody>
			</table>
		</div>
		
	</div>
	<a type = "button" href = "<%=url%>"> Volver a menu</a>

</div>

<script>
	function message() {
		return confirm('Esta seguro de realizar esta accion ?');
	}

</script>
</body>
</html>