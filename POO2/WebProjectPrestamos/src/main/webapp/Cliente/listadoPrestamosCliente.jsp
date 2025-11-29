<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "com.unu.poo2.beans.*" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Préstamos del Cliente</title>

<%
String url = "http://localhost:8080/WebProjectPrestamos/";
int id = (int)(request.getAttribute("idCliente"));
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
        width: 80%;
        margin: 20px auto;
        padding: 20px;
        background-color: white;
        border-radius: 8px;
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
    }

    .button {
        display: inline-block;
        background-color: #4CAF50;
        color: white;
        padding: 10px 15px;
        margin-bottom: 20px;
        text-decoration: none;
        border-radius: 4px;
        font-size: 16px;
        transition: background-color 0.3s;
    }

    .button:hover {
        background-color: #45a049;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 10px;
        text-align: center;
    }

    th {
        background-color: #f2f2f2;
    }

    td a {
        background-color: #007BFF;
        color: white;
        padding: 5px 10px;
        text-decoration: none;
        border-radius: 4px;
        margin: 0 5px;
    }

    td a:hover {
        background-color: #0056b3;
    }

    td a.delete {
        background-color: #FF6347;
    }

    td a.delete:hover {
        background-color: #e04e35;
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
    <h3>Lista de Préstamos del Cliente <%=id%></h3>

    <a class="button" href="<%=url%>PrestamoController?op=nuevo&id=<%=id%>">Nuevo Préstamo</a>

    <table>
        <thead>
            <tr>
                <th>N°</th>
                <th>ID PRESTAMO</th>
                <th>FECHA PRESTAMO</th>
                <th>NOMBRE CLIENTE</th>
                <th>MONTO</th>
                <th>INTERES</th>
                <th>N° CUOTAS</th>
                <th>OPERACIONES</th>
            </tr>
        </thead>

        <tbody>
            <%
            List<Object[]> listaPrestamosCliente = (List<Object[]>) request.getAttribute("listaPrestamosCliente");
            if (listaPrestamosCliente != null) {
                for (Object[] c : listaPrestamosCliente) {
            %>
            <tr>
                <td><%= c[0] %></td>
                <td><%= c[1] %></td>
                <td><%= c[2] %></td>
                <td><%= c[3] %></td>
                <td><%= c[4] %></td>
                <td><%= c[5] %></td>
                <td><%= c[6] %></td>
                <td>
                    <a href="<%= url %>PrestamoController?op=obtener&id=<%= c[1] %>">Modificar</a>
                    <a class="delete" onclick="return confirmarAccion()" href="<%= url %>PrestamoController?op=eliminar&id=<%= c[1] %>&cliente=<%= id %>">Eliminar</a>
                </td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="8">No hay préstamos registrados para este cliente.</td>
            </tr>
            <%
            }
            %>
        </tbody>
    </table>

    <a class="back-link" href="<%=url%>ClienteController">Volver a la Lista de Clientes</a>
</div>

</body>
</html>
