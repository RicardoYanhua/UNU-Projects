<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar Cliente</title>

<%
String url = "http://localhost:8080/WebProjectPrestamos/";
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
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    div {
        background-color: white;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        width: 400px;
    }

    h3 {
        text-align: center;
        color: #333;
    }

    label {
        display: block;
        margin: 10px 0 5px;
        color: #555;
    }

    input[type="text"],
    input[type="date"],
    input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border-radius: 4px;
        border: 1px solid #ccc;
    }

    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
        font-size: 16px;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

    a {
        display: inline-block;
        text-align: center;
        color: #007BFF;
        text-decoration: none;
        padding: 10px;
        margin-top: 10px;
        font-size: 16px;
    }

    a:hover {
        text-decoration: underline;
    }
</style>

</head>
<body>

<div>
    <h3>Registrar Datos del Cliente Nuevo</h3>
    <form role="form" action="<%=url%>ClienteController">
        <input type="hidden" name="op" value="insertar">
        
        <label for="nombres">Nombres</label>
        <input type="text" id="nombres" name="nombres" required>

        <label for="apellidos">Apellidos</label>
        <input type="text" id="apellidos" name="apellidos" required>

        <label for="dni">DNI</label>
        <input type="text" id="dni" name="dni" required>

        <label for="fechaNacimiento">Fecha de nacimiento</label>
        <input type="date" id="fechaNacimiento" name="fechaNacimiento" required>

        <label for="direccion">Dirección</label>
        <input type="text" id="direccion" name="direccion" required>

        <input type="submit" onclick="return confirmarAccion()" value="Registrar Cliente">
        <a href="<%=url%>ClienteController">Volver a la Lista de Clientes</a>
    </form>
</div>

</body>
</html>
