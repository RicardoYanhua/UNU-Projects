<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.unu.WebApplication.beans.*" %>
<%@ page import = "java.util.*"%>
<!DOCTYPE html>
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
List<Object[]> listaTrabajador= (List<Object[]>) request.getAttribute("listaTrabajador");
%>

<%@ include file="/menu.jsp" %>



	
<div class = "content">
<div class = "content-form">
	
	<div class = "tittle">
		<h4>ListaTrabajadores</h3>
	</div>
	
		<div style = "display : flex; justify-content: flex-end;">
			<a class = "btn btn-primary"type = "button" href = "<%=url%>TrabajadorController?op=nuevo">Nuevo trabajador</a>
		</div>
		
		
			<table class="table">
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

<script>
	function message() {
		return confirm('Esta seguro de realizar esta accion ?');
	}

</script>
</body>
</html>