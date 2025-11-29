<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.unu.poo2.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar</title>

</head>

<body>

<%@ include file='/NavBar.jsp' %>

<div class = "main" >
	<div class="main-conteiner" style = "width:50%;">
		
		<form role="form" action="<%=url%>Controller" method="POST" onsubmit="return validarFormulario()">
			
			<input type = "hidden" id = "op" name = "op" value = "insertar">
			<div class="form-tittle tittle">Titulo</div>
			
			
				
				<div class = "input-group">
					<span>Titulo</span>
					<input id = "variable1" type = "text" placeholder="Ingresar texto">
				</div>
				<div class = "input-group">
					<span>Numero</span>
					<input type = "number" placeholder="Ingresar texto">
				</div>
				<div class = "input-group">
					<span>Fecha</span>
					<input type = "date" placeholder="Ingresar texto">
				</div>
				
				<!-- COMBOBOX CUSTOM-->
			 	<div class="input-group">
			 	
					<span>Combobox</span>
					
			 		<select>
			 			<option value="" disabled selected>Seleccionar opcion</option>
  <% 
  					List<Object[]> ListaComboBox1= (List<Object[]>)request.getAttribute("ListaOpcionesCombo1");
    				if (ListaComboBox1 != null) {
      					for (Object[] ComboItem : ListaComboBox1) { 
  %>
    				<option value="<%=ComboItem[0]%>"><%=ComboItem[1]%></option>
  <%
      				}} 
  %>
					</select>
				</div>
				
				<!-- COMBOBOX PREDETERMINADO-->
			 	<div class="input-group">
					<span>Combobox</span>
			 		<select>
			 			<option value="" disabled selected>Seleccionar opcion</option>
  
    				<option value="1">Opcion1</option>
    				<option value="2">Opcion2</option>
    				<option value="3">Opcion3</option>
    				<option value="4">Opcion4</option>
  
					</select>
				</div>
				
				
				
				
		<div class="input-group">
					<span >Combo Selector</span>
			 		<select id = "Combo" >
			 			<option value="" disabled selected>Elija una opción</option>
  <% 
  						List<Object[]> ListaComboBox2= (List<Object[]>)request.getAttribute("ListaOpcionesCombo2");
  						if(ListaComboBox2 == null){
  							ListaComboBox2 = new ArrayList<>();
  							ListaComboBox2.add(new Object[]{1,"Nombre1","Sueldo1"});
  							ListaComboBox2.add(new Object[]{2,"Nombre2","Sueldo2"});
  							ListaComboBox2.add(new Object[]{3,"Nombre3","Sueldo3"});
  							ListaComboBox2.add(new Object[]{4,"Nombre4","Sueldo4"});
  						}
  						
    					if (ListaComboBox2 != null) {
      						for (Object[] Item : ListaComboBox2) { 
  %>
    					<option value="<%=Item[0]%>"><%=Item[1]%>-<%=Item[2]%></option>
  <%
      					}} 
  %>
					</select>
					<button class="btn btn-primary" type="button" onclick="agregarATabla(event)">Agregar</button>
					
				</div>		
		
				
				
				
		<div class="form-tittle sub-tittle">TituloTabla</div>
		
	 	<div class="table-container">
        	<table class="table">
            	<thead>
               		<tr>
                    <th>PrimaryKey</th>
                    <th>Variable1</th>
                    <th>Variable2</th>
                    <th>Operaciones</th>
                	</tr>
            	</thead>
        	</table>
        
        	<div class="tbody-container" style = "height:200px; max-height: 200px;">
	            <table class="table">
	                <tbody id = "TablaBody" >
	               
	                </tbody>
	            </table>
        	</div>
		</div>
				
			
			
			
			<div class="form-operaciones">
				<a type="button" href="<%=url%>">Cancelar</a>
				<input type = "submit" value = "Registrar">
				
				
			</div>
	
		</form>
	</div>
</div>

<script>
    function agregarATabla(event) {
        event.preventDefault();
        const select = document.getElementById("Combo");
        const tabla = document.getElementById("TablaBody");
        const selectedOption = select.options[select.selectedIndex];

        if (selectedOption && select.selectedIndex != 0) {
            
            // RECOLECTAR DATOS
            const primaryKey = selectedOption.value;
            const datos = selectedOption.innerHTML.split("-");
            const variable1 = datos[0];
            const variable2 = datos[1];

            // Crear la primera celda para el ID
            const fila = tabla.insertRow();
        
            //CELDA PRIMARY KEY
            const Celda_PrimaryKey = fila.insertCell(0);
            // Crear el campo oculto para el servlet
            const inputHidden = document.createElement("input");
            inputHidden.type = "hidden";
            inputHidden.name = "PrimaryKeyArray";  // Este es el nombre que se enviará al servlet
            inputHidden.value = primaryKey;
            // Agregar el campo oculto a la primera celda
            Celda_PrimaryKey.appendChild(inputHidden);
            Celda_PrimaryKey.innerText = primaryKey;
       
            // CELDAS VARIABLES
            fila.insertCell(1).innerText = variable1;
            fila.insertCell(2).innerText = variable2;

            // Crear la celda de eliminación
            const Celda_Elminar = fila.insertCell(3);
            
            const BotonEliminar = document.createElement("a");
            BotonEliminar.innerText = "Eliminar";
            BotonEliminar.classList = "button-eliminar";
            BotonEliminar.onclick = function () {
                    tabla.deleteRow(fila.rowIndex);  
                    selectedOption.style.display = "block"; 
                
            };
            
            Celda_Elminar.appendChild(BotonEliminar);

            selectedOption.style.display = "none";
            select.selectedIndex = 0;
        }
    }

    </script>

	<script>
	function validarFormulario() {
		const Variable1 = document.getElementById('variable1').value.trim();
		
		if (Variable1 === '') {
			//alert("asdasdasdasd");
			showMessage('Operación realizada con éxito', 4);
            document.getElementById('variable1').focus();
            return false;
        }

        return true; 
	}
	</script>

</body>
</html>