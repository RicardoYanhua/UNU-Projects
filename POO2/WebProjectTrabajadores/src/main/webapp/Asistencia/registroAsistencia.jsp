<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro Trabajadores</title>
    <%
        String url = "http://localhost:8080/WebProjectTrabajadores/";
        List<Object[]> items = (List<Object[]>)request.getAttribute("lista");
      
    %>
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
</head>

<body>

<div class="menu">
    <a href="#">REGISTRO TRABAJADOR</a>
    <a href="#">ASISTENCIA</a>
</div>

<div class="content">
    <form action="<%= url %>AsistenciaController" method="post">
        <input type="hidden" id="op" name="op" value="registrar">
        
        <label for="condicion">Condicion laboral</label>
        <select id="condicion" name="condicion" required>
            <option value="" disabled selected>Seleccionar una opción</option>
            <option value="contratado">Contratado</option>
            <option value="nombrado">Nombrado</option>
        </select>
        
        <label for="fecha">Fecha</label>
        <input type="date" id="fecha" name="fecha" required>
        
        <label for="justificacion">Justificación</label>
        <input type="text" id="justificacion" name="justificacion" required>
        
        <div class="agregarTrabajador">
            <label for="comboBox">Selecciona un elemento:</label>
            <select id="comboBox">
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

            <button type="button" onclick="agregarATabla(event)">Agregar a Tabla</button>
            
            <table id="tabla" border="1">
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

        <input type="submit" value="Guardar asistencia"> <br>
        <a href="<%= url %>">Cancelar</a>
    </form>
</div>
</body>
</html>

