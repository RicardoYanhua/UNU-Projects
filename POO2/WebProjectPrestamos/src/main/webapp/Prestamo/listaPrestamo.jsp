<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import= "com.unu.poo2.beans.*" %>
<%@page import= "java.util.*" %>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Lista de Préstamos</title>

<!-- Google Fonts para una tipografía más moderna -->
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">

<style type="text/css">
    body {
        font-family: 'Roboto', sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
        color: #333;
    }

    h3 {
        text-align: center;
        color: #4CAF50;
        margin-top: 20px;
        font-size: 24px;
    }

    div {
        margin: 20px auto;
        width: 90%;
        max-width: 1200px;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
    }

    a[type="button"] {
        display: inline-block;
        padding: 12px 20px;
        background-color: #4CAF50;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        font-size: 16px;
        text-align: center;
        transition: background-color 0.3s ease, transform 0.2s ease;
        margin-top: 20px;
    }

    a[type="button"]:hover {
        background-color: #45a049;
        transform: translateY(-3px);
    }

    a[type="button"]:active {
        transform: translateY(1px); /* Efecto de presión */
    }

    table {
        width: 100%;
        margin-top: 20px;
        border-collapse: collapse;
        font-size: 14px;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 12px;
        text-align: left;
    }

    th {
        background-color: #4CAF50;
        color: white;
    }

    td {
        background-color: #fafafa;
    }

    tr:nth-child(even) td {
        background-color: #f1f1f1;
    }

    tr:hover td {
        background-color: #e1e1e1;
    }

    /* Estilos responsivos */
    @media (max-width: 768px) {
        table {
            font-size: 12px;
        }
        
        a[type="button"] {
            font-size: 14px;
        }
    }
</style>

</head>
<body>

<%
String url = "http://localhost:8080/WebProjectPrestamos/";
List<Prestamo> listaPrestamo = (List<Prestamo>) request.getAttribute("listaPrestamo");
%>

<h3>Lista de Préstamos</h3>

<div>
    <table>
        <thead>
            <tr>
                <th>ID Préstamo</th>
                <th>Fecha Préstamo</th>
                <th>Monto</th>
                <th>Referencia del Cliente</th>
                <th>Interés</th>
                <th>N° Cuotas</th>
            </tr>
        </thead>

        <tbody>
            <%
            if(listaPrestamo != null) {
                for(Prestamo p : listaPrestamo) {
            %>
                <tr>
                    <td><%= p.getIDPrestamo() %></td>
                    <td><%= p.getFecha() %></td>
                    <td><%= p.getMonto() %></td>
                    <td><%= p.getReferenciaCliente() %></td>
                    <td><%= p.getInteres() %></td>
                    <td><%= p.getCuotas() %></td>
                </tr>
            <%  
                }
            } else {
            %>
                <tr>
                    <td colspan="6" style="text-align: center;">Sin datos de préstamos</td>
                </tr>
            <%  
            }
            %>
        </tbody>
    </table>
    
    <a type="button" href="<%=url%>">Volver</a>
</div>

</body>
</html>
