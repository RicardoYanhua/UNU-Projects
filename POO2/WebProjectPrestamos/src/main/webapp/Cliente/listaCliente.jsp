<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import= "com.unu.poo2.beans.*" %>
<%@page import= "java.util.*" %>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Lista de Clientes</title>

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
        margin-bottom: 10px;
        margin-right: 10px;
        background-color: #4CAF50;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        font-size: 16px;
        text-align: center;
        transition: background-color 0.3s ease, transform 0.2s ease;
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

    .actions a {
        margin-right: 10px;
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

<script>
    function confirmarAccion() {
        return confirm("¿Estás seguro de que deseas realizar esta acción?");
    }
</script>
</head>
<body>

<%
String url = "http://localhost:8080/WebProjectPrestamos/";
List<Cliente> listaClientes = (List<Cliente>) request.getAttribute("listaClientes");
%>

<h3>Lista de Clientes</h3>

<div>
    <a type="button" href="<%=url%>ClienteController?op=nuevo">Nuevo Cliente</a>
    <a type="button" href="<%=url%>ClienteController?op=busqueda">Buscar Cliente</a>
    <a type="button" href="<%=url%>ClienteController">Todos los Clientes</a>

    <table>
        <thead>
            <tr>
                <th>ID Cliente</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>DNI</th>
                <th>Fecha Nacimiento</th>
                <th>Dirección</th>
                <th>Operaciones</th>
            </tr>
        </thead>

        <tbody>
            <%
            if(listaClientes != null) {
                for(Cliente c : listaClientes) {
            %>
                <tr>
                    <td><%= c.getIDCliente() %></td>
                    <td><%= c.getNombres() %></td>
                    <td><%= c.getApellidos() %></td>
                    <td><%= c.getDNI() %></td>
                    <td><%= c.getFechaNacimiento() %></td>
                    <td><%= c.getDireccion() %></td>
                    <td class="actions">
                        <a type="button" href="<%=url%>ClienteController?op=obtenerCliente&id=<%=c.getIDCliente()%>">Modificar Datos</a>
                        <a type="button" onclick="return confirmarAccion()" href="<%=url%>ClienteController?op=eliminar&id=<%=c.getIDCliente()%>">Eliminar Cliente</a>
                        <a type="button" href="<%=url%>PrestamoController?op=cargarPrestamosCliente&id=<%=c.getIDCliente()%>">Préstamo</a>
                    </td>
                </tr>
            <%  
                }
            } else {
            %>
                <tr>
                    <td colspan="7" style="text-align: center;">Sin datos de clientes</td>
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
