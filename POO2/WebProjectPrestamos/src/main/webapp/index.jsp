<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Menú Principal</title>

<!-- Google Fonts para una tipografía moderna -->
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">

<style type="text/css">
    body {
        font-family: 'Roboto', sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        background-color: #f5f5ff; /* Color de fondo suave */
    }
    
    div {
        width: 90%;
        max-width: 400px;  /* Limitar el tamaño máximo del contenedor */
        border: 1px solid #dcdcdc;
        box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
        background-color: #fff;
        border-radius: 10px;
        padding: 30px;
        text-align: center;
    }

    h3 {
        font-size: 24px;
        color: #333;
        margin-bottom: 20px;
    }

    a {
        display: block;
        padding: 12px 20px;
        margin: 10px 0;
        background-color: #4CAF50;  /* Color verde */
        color: white;
        text-decoration: none;
        border-radius: 5px;
        font-weight: 500;
        transition: background-color 0.3s ease, transform 0.2s ease;
    }

    a:hover {
        background-color: #45a049; /* Color más oscuro para hover */
        transform: translateY(-3px); /* Efecto de elevación */
    }

    a:active {
        transform: translateY(1px); /* Efecto de presión al hacer clic */
    }
</style>

<%
String url = "http://localhost:8080/WebProjectPrestamos/";
%>
</head>
<body>

    <div>
        <h3>Menú Principal</h3>
        
        <!-- Los enlaces ahora se ven como botones con un buen estilo -->
        <a href="ClienteController">Clientes</a>
        <a href="PrestamoController">Préstamos</a>
    </div>

</body>
</html>
