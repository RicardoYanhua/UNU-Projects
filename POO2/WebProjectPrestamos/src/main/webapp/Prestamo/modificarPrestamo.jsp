<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.unu.poo2.beans.*" %>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Editar Préstamo</title>

<!-- Google Fonts para una tipografía más moderna -->
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">

<style type="text/css">
    body {
        font-family: 'Roboto', sans-serif;
        background-color: #f9f9f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        color: #333;
    }

    div {
        background-color: #fff;
        border: 1px solid #ddd;
        box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
        padding: 30px;
        width: 90%;
        max-width: 500px;
        text-align: center;
    }

    h3 {
        color: #4CAF50;
        font-size: 24px;
        margin-bottom: 20px;
    }

    label {
        display: block;
        text-align: left;
        margin: 10px 0 5px;
        font-weight: 500;
    }

    input[type="date"],
    input[type="number"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
        font-size: 16px;
    }

    input[type="submit"],
    a {
        padding: 12px 20px;
        margin-top: 20px;
        font-size: 16px;
        background-color: #4CAF50;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s ease, transform 0.2s ease;
    }

    input[type="submit"]:hover,
    a:hover {
        background-color: #45a049;
        transform: translateY(-3px);
    }

    input[type="submit"]:active,
    a:active {
        transform: translateY(1px); /* Efecto de presión */
    }

    a {
        display: inline-block;
        background-color: #f44336;
        margin-top: 10px;
    }

    a:hover {
        background-color: #e53935;
    }
</style>

<script>
    function confirmarAccion() {
        return confirm("¿Estás seguro de que deseas realizar esta acción?");
    }
</script>
</head>
<body>

<%
String url = "http://localhost:8080/WebProjectPrestamos/";
Prestamo prestamo;
if(request.getAttribute("prestamoEditar") != null){
    prestamo = (Prestamo) request.getAttribute("prestamoEditar");
} else {
    prestamo = new Prestamo();
}
%>

<div>
    <h3>Editar Préstamo del Cliente</h3>
    
    <form role="form" action="<%=url%>PrestamoController">
        <input type="hidden" name="op" value="modificar">
        <input type="hidden" name="id" value="<%=prestamo.getIDPrestamo()%>">
        <input type="hidden" name="referenciaCliente" value="<%=prestamo.getReferenciaCliente()%>">
        
        <label for="fecha">Fecha</label>
        <input type="date" id="fecha" name="fecha" value="<%=prestamo.getFecha()%>">
        
        <label for="monto">Monto</label>
        <input type="number" id="monto" name="monto" min="0" value="<%=prestamo.getMonto()%>">
        
        <label for="interes">Interés</label>
        <input type="number" id="interes" name="interes" step="0.01" min="0" value="<%=prestamo.getInteres()%>">
        
        <label for="cuotas">Número de Cuotas</label>
        <input type="number" id="cuotas" name="cuotas" min="0" value="<%=prestamo.getCuotas()%>">
        
        <input type="submit" onclick="return confirmarAccion()" value="Guardar Préstamo">
    </form>
    
    <a href="<%=url%>ClienteController">Volver a la Lista de Clientes</a>
</div>

</body>
</html>
