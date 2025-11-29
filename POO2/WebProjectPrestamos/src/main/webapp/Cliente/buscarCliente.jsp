
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Buscar Cliente</title>
    <style>
        /* Estilos generales */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        /* Contenedor principal */
        div {
            width: 100%;
            max-width: 500px;
            padding: 30px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        /* Estilo para los títulos */
        h3 {
            color: #4CAF50;
            margin-bottom: 20px;
        }

        /* Etiquetas */
        label {
            font-size: 16px;
            margin-bottom: 10px;
            display: block;
            text-align: left;
            color: #333;
        }

        /* Estilo para los campos de entrada */
        input[type="text"] {
            width: 100%;
            padding: 12px;
            font-size: 16px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        /* Estilo para el botón de búsqueda */
        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #4CAF50;
            color: white;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        /* Estilo para el enlace de "Volver" */
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 12px 20px;
            background-color: #f44336;
            color: white;
            font-size: 16px;
            border-radius: 5px;
            text-decoration: none;
            text-align: center;
            transition: background-color 0.3s;
        }

        a:hover {
            background-color: #e53935;
        }
    </style>
</head>
<body>
<%
String url = "http://localhost:8080/WebProjectPrestamos/";
%>
<div>
    <h3>Buscar Cliente</h3>
    <form action="<%= url %>ClienteController" method="get">
        <input type="hidden" name="op" value="buscar">
        
        <label for="buscar">Buscar Cliente por Nombres o Apellidos</label>
        <input type="text" id="buscar" name="buscar" required placeholder="Escribe el nombre o apellido">

        <input type="submit" value="Buscar Cliente">
        <a href="<%= url %>ClienteController">Volver al Lista Clientes</a>
    </form>
</div>

</body>
</html>
