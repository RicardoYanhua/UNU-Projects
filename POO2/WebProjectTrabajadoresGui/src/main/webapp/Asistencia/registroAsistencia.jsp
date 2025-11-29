<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro Trabajadores</title>
    <%
        List<Object[]> items = (List<Object[]>)request.getAttribute("lista");
    %>
    
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

<%@ include file="/menu.jsp" %>

<div class = "content">
<div class = "content-form">

	<div class = "tittle">
		<h4>RegistroAsistencia</h3>
	</div>
	
    <form action="<%= url %>AsistenciaController" method="post">
        <input type="hidden" id="op" name="op" value="registrar">
        
        <div class = "form-group">
        <label for="condicion">Condicion laboral</label>
        <select  class = "form-select" id="condicion" name="condicion" required>
            <option value="" disabled selected>Seleccionar una opción</option>
            <option value="contratado">Contratado</option>
            <option value="nombrado">Nombrado</option>
        </select>
        </div>
       
        
        <div class = "form-group">
        <label for="fecha">Fecha</label>
        <input class = "form-control" type="date" id="fecha" name="fecha" required>
        </div>
        
        
        <div class = "form-group">
        <label for="justificacion">Justificación</label>
        <input class = "form-control" type="text" id="justificacion" name="justificacion" required>
        </div>
        
        
        <div class="agregarTrabajador">
        
        	<div class = "form-group">
        	<label for="comboBox">Selecciona un elemento:</label>
            <select class = "form-select" id="comboBox">
            <option value="disabled" disabled selected>Seleccionar una opción</option>
  <% 
  					
    				if (items != null) {
      					for (Object[] ComboItem : items) { 
  %>
    				<option value="<%=ComboItem[0]%>">"<%=ComboItem[1]%> - <%=ComboItem[3]%>"</option>
  <%
      				}} 
  %>
            
            
            </select>
        	</div>
        	
            

            <button  class = "btn btn-primary" type="button" onclick="agregarATabla(event)">Agregar a Tabla</button>
            
            <table class = "table" id = "tabla">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Sueldo</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                
                <tbody>
                    <!-- Filas se agregarán aquí dinámicamente -->
                </tbody>
            </table>
        </div>
        
        <div style = "display: flex; justify-content: flex-end;">
        <a class = "btn" href="<%= url %>">Cancelar</a>
        <input class = "btn btn-primary" type="submit" value="Guardar asistencia"> 
        </div>
		
        
    </form>
</div>
</div>

<script>
        
    function agregarATabla(event) {
        // event.preventDefault();  // Descomenta si usas el preventDefault()
        const select = document.getElementById("comboBox");
        const tabla = document.getElementById("tabla");
        const selectedOption = select.options[select.selectedIndex];

        if (selectedOption && select.selectedIndex != 0) {
            const fila = tabla.insertRow();
            const id = selectedOption.value;
            const datos = selectedOption.innerHTML.split(" - ");
            const nombre = datos[0];
            const sueldo = datos[1];

            // Crear la primera celda para el ID
            const id_cell = fila.insertCell(0);

            // Crear el campo oculto dentro de la primera celda para almacenar el ID
            const inputHidden = document.createElement("input");
            inputHidden.type = "hidden";
            inputHidden.name = "idtrabajador";  // Este es el nombre que se enviará al servlet
            inputHidden.value = id;  // El valor será el ID del trabajador

            // Agregar el campo oculto a la primera celda
            id_cell.appendChild(inputHidden);

            // Ahora agregamos el ID como texto visible (opcional, si deseas que el ID se vea)
            const idText = document.createElement("span");
            idText.innerText = id;
            id_cell.appendChild(idText);

            // Crear las otras celdas para el nombre y el sueldo
            fila.insertCell(1).innerText = nombre;
            fila.insertCell(2).innerText = sueldo;

            // Crear la celda de eliminación y el botón
            const eliminarCelda = fila.insertCell(3);
            const eliminarBoton = document.createElement("button");
            eliminarBoton.innerText = "Eliminar";
            eliminarBoton.classList.add('btn');
            eliminarBoton.classList += " btn-danger";
            eliminarBoton.onclick = function () {
                tabla.deleteRow(fila.rowIndex);
                select.appendChild(selectedOption); // Reagregar la opción al select
            };
            eliminarCelda.appendChild(eliminarBoton);

            // Remover la opción seleccionada del select
            select.removeChild(selectedOption);
            select.selectedIndex = 0;
        }
    }

    </script>

</body>
</html>

