<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error 404 - Página no encontrada</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: rgb(245,245,255);
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            text-align: center;
            background: rgb(255,255,255);
            padding: 20px 40px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            text-decoration: none;
            color: rgb(255,255,255);
            background-color: rgb(34,34,34);
            border-radius: 5px;
            font-size: 14px;
        }
        a:hover {
            background-color: rgb(54,54,54);
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>ERROR 404</h1>
        <p>El controlador no pudo ejecutar la operacion.</p>
        <a href="<%= request.getContextPath() %>/">Volver al inicio</a>
    </div>
    
</body>
</html>
