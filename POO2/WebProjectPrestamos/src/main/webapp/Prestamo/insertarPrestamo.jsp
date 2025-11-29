<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import = "com.unu.poo2.beans.*"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Préstamo</title>

    <!-- Estilos básicos -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }

        h3 {
            text-align: center;
            color: #4CAF50;
            margin-top: 20px;
            font-size: 24px;
        }

        div {
            width: 90%;
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        label {
            font-size: 16px;
            margin-bottom: 5px;
            display: block;
        }

        input[type="date"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            padding: 12px 20px;
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

        a[type="button"] {
            display: inline-block;
            padding: 12px 20px;
            margin-top: 20px;
            text-decoration: none;
            background-color: #f44336;
            color: white;
            font-size: 16px;
            border-radius: 5px;
            text-align: center;
            transition: background-color 0.3s;
        }

        a[type="button"]:hover {
            background-color: #e53935;
        }

        /* Estilo para la confirmación */
        .confirmation-box {
            display: inline-block;
            background-color: #4CAF50;
            padding: 10px 20px;
            color: white;
            border-radius: 5px;
            cursor: pointer;
        }

        .confirmation-box:hover {
            background-color: #45a049;
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
    int idcliente = (int) request.getAttribute("idcliente");
%>

<div>
    <h3>Registrar Préstamo del Cliente <%= idcliente %></h3>
    <form role="form" action="<%= url %>PrestamoController" method="post">
        <input type="hidden" name="op" value="insertar">
        <input type="hidden" name="referenciaCliente" value="<%= idcliente %>">

        <label for="fecha">Fecha del Préstamo</label>
        <input type="date" id="fecha" name="fecha" required>

        <label for="monto">Monto del Préstamo</label>
        <input type="number" id="monto" name="monto" min="0" required>

        <label for="interes">Interés</label>
        <input type="number" id="interes" name="interes" step="0.01" min="0" required>

        <label for="cuotas">Número de Cuotas</label>
        <input type="number" id="cuotas" name="cuotas" min="1" required>

        <input type="submit" onclick="return confirmarAccion()" value="Registrar Préstamo">
    </form>

    <a type="button" href="<%= url %>PrestamoController">Volver a la Lista de Préstamos</a>
</div>

</body>
</html>
