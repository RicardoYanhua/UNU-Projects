<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.unu.poo2.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Datos del Cliente</title>

<%
String url = "http://localhost:8080/WebProjectPrestamos/";
Cliente cliente;
if(request.getAttribute("clienteEditar") != null){
    cliente = (Cliente) request.getAttribute("clienteEditar");
} else {
    cliente = new Cliente();
}
%>

<script>
    function confirmarAccion() {
        return confirm("¿Estás seguro de que deseas realizar esta acción?");
    }
</script>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
    }

    h3 {
        text-align: center;
        margin-top: 20px;
        color: #333;
    }

    .container {
        width: 60%;
        margin: 20px auto;
        padding: 30px;
        background-color: white;
        border-radius: 8px;
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
    }

    label {
        display: block;
        margin: 10px 0 5px;
        font-size: 14px;
        font-weight: bold;
        color: #555;
    }

    input[type="text"], input[type="date"], input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        font-size: 14px;
        border: 1px solid #ddd;
        border-radius: 4px;
    }

    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

    .button {
        display: inline-block;
        background-color: #007BFF;
        color: white;
        padding: 10px 15px;
        text-decoration: none;
        border-radius: 4px;
        margin-top: 10px;
        font-size: 16px;
        transition: background-color 0.3s;
    }

    .button:hover {
        background-color: #0056b3;
    }

    .back-link {
        display: inline-block;
        margin-top: 20px;
        text-decoration: none;
        color: #007BFF;
        font-size: 16px;
    }

    .back-link:hover {
        text-decoration: underline;
    }
</style>

</head>
<body>

<div class="container">
    <h3>Editar Datos del Cliente</h3>

    <form role="form" action="<%= url %>ClienteController">
        <input type="hidden" name="op" value="modificar">
        <input type="hidden" name="id" value="<%= cliente.getIDCliente() %>">
        
        <label for="nombres">Nombres</label>
        <input type="text" id="nombres" name="nombres" value="<%= cliente.getNombres() %>" required>
        
        <label for="apellidos">Apellidos</label>
        <input type="text" id="apellidos" name="apellidos" value="<%= cliente.getApellidos() %>" required>
        
        <label for="dni">DNI</label>
        <input type="text" id="dni" name="dni" value="<%= cliente.getDNI() %>" required>
        
        <label for="fechaNacimiento">Fecha de nacimiento</label>
        <input type="date" id="fechaNacimiento" name="fechaNacimiento" value="<%= cliente.getFechaNacimiento() %>" required>
        
        <label for="direccion">Dirección</label>
        <input type="text" id="direccion" name="direccion" value="<%= cliente.getDireccion() %>" required>
        
        <input type="submit" value="Guardar Cliente">
        
        <a class="back-link" href="<%= url %>ClienteController">Volver a la Lista de Clientes</a>
    </form>
</div>

</body>
</html>
