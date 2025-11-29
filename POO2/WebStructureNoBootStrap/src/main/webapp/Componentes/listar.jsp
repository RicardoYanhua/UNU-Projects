<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.unu.poo2.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar</title>

</head>
<body>

<%@ include file='/NavBar.jsp' %>

<div class = "main" >

	<div class="main-conteiner" style = "width:80%;">
		
		<div class="form-tittle tittle">Titulo</div>
		<div class="form-tittle sub-tittle">Busqueda</div>
		
		
		<div class="form-busqueda">
			<input type="text" id="busqueda" name="busqueda" placeholder="Ingresar busqueda">
			<a type="button" href="<%=url%>">Buscar</a>
		</div>
		
		<div class="form-operaciones">
			<a type="button" href="<%=url%>">Operacion1</a>
			<a type="button" href="<%=url%>">Operacion2</a>
			<a type="button" href="<%=url%>">Operacion3</a>
			<a type="button" href="<%=url%>">Operacion4</a>
			
		</div>
		
		<div class="form-tittle sub-tittle">TituloTabla</div>
		
	 	<div class="table-container">
        	<table class="table">
            	<thead>
               		<tr>
                    <th>PrimaryKey</th>
                    <th>Variable1</th>
                    <th>Variable2</th>
                    <th>Variable3</th>
                    <th>Variable4</th>
                    <th>Operaciones</th>
                	</tr>
            	</thead>
        	</table>
        
        	<div class="tbody-container" style = "height:400px; max-height: 400px;">
	            <table class="table">
	                <tbody>
	               <%
					List<Entidad> Lista = (List<Entidad>) request.getAttribute("Lista");
					
					if(Lista == null){
						Lista = new ArrayList<>();
						for (int i=0 ; i<20 ; i++){
							Lista.add(new Entidad());
						}
					}
					for (Entidad obj : Lista) {
					%>
					<tr>
						<td><%=obj.getVariablePrimaryKey()%></td>
						<td><%=obj.getVariableTipoInt()%></td>
						<td><%=obj.getVariableTipoString()%></td>
						<td><%=obj.getVariableTipoDouble()%></td>
						<td><%=obj.getVariableTipoDate()%></td>
						<td>
							<a class = "button-modificar" href="<%=url%>AutorController?op=obtener&id=<%=obj.getVariableTipoInt()%>" >Modificar</a>
							<a class = "button-eliminar" href="javascript:EliminarRegistro('<%=obj.getVariableTipoInt()%>')" >Eliminar</a>
						</td>
					</tr>
					<%}%>
	                </tbody>
	            </table>
        	</div>
        
			
		
		</div>

		
		
	</div>
</div>
	


<script>
	function EliminarRegistro(id) {
	    const resultado =showConfirm('Eliminar Registro','¿ Estás seguro de eliminar este registro ?');
	    if (resultado) {
	    	location.href= "#";
	    	//location.href = "NameController?op=eliminar&id=" + id;
	    } 
	}
</script>


</body>
</html>