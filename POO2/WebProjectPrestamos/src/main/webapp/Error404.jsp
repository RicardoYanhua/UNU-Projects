<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Error 404</title>

<!-- Google Fonts para una tipografía moderna -->
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">

<style type="text/css">
    body {
        font-family: 'Roboto', sans-serif;
        background-color: #f9f9f9; /* Fondo suave */
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        text-align: center;
    }

    div {
        background-color: #fff;
        border: 1px solid #ddd;
        box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
        padding: 40px 60px;
        max-width: 400px;
        width: 100%;
    }

    h2 {
        color: #f44336; /* Rojo para el error */
        font-size: 36px;
        margin-bottom: 10px;
    }

    h3 {
        color: #333;
        font-size: 18px;
        margin-bottom: 20px;
    }

    a {
        display: inline-block;
        padding: 12px 25px;
        font-size: 16px;
        background-color: #4CAF50;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s ease, transform 0.2s ease;
    }

    a:hover {
        background-color: #45a049;
        transform: translateY(-3px);
    }

    a:active {
        transform: translateY(1px); /* Efecto de presión */
    }
</style>

<%
String Message = String.valueOf(request.getAttribute("message"));
String url = "http://localhost:8080/WebProjectPrestamos/";
%>
</head>

<body>
    <div>
        <h2>Error 404 - Página no encontrada</h2>
        <h3><%=Message%></h3>
        <a href="<%=url%>">Volver al Menú de Opciones</a>
    </div>
</body>
</html>
