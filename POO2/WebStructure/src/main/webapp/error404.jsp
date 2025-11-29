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
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
      
    </style>
</head>
<body>
    <div>
        <h1>ERROR 404</h1>
        <p>El controlador no pudo ejecutar la operacion.</p>
        <a href="<%= request.getContextPath() %>/">Volver al inicio</a>
    </div>
    
</body>
</html>

