<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
</title>

	<!-- 
	<link rel="stylesheet" href="<%= request.getContextPath() %>/assetsCustom/css/popupStyle.css">
	<script src="<%= request.getContextPath() %>/assetsCustom/js/popupScript.js"></script>
	 --> 
	<link rel="stylesheet" href="/assetsCustom/css/popupStyle.css">
	<script src="/assetsCustom/js/popupScript.js"></script>

	<style>
        ::-webkit-scrollbar {
            width: 7px;
            height: 7px;
        }
        ::-webkit-scrollbar-track {
            background: rgba(0,0,0,0);
            border-radius: 3px;
        }
        ::-webkit-scrollbar-thumb {
        	background: linear-gradient(135deg, rgb(227, 227, 227), rgb(227, 227, 227));
            border-radius: 5px;
            box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
        }
        ::-webkit-scrollbar-thumb:hover {
            background: linear-gradient(135deg,rgb(199, 199, 199) ,rgb(199, 199, 199));
        }
	
       body{
       display:flex;
       justify-content:center;
       align-items:center;
       margin:0;
       padding:60px 0px 0px 0px;
       font-family: Arial, sans-serif;
       background-color: rgb(245,245,255);
       }
       
       input[type="number"]::-webkit-inner-spin-button,
       input[type="number"]::-webkit-outer-spin-button {
            -webkit-appearance: none;
            margin: 0;
       }

       input[type="number"] {
            -moz-appearance: textfield;
       }
       
       
       
       
       
       .navbar{
       		display: flex;
            justify-content: center;
            align-items: center;
            position: absolute;
            top: 0;
            left: 0;
            background-color: rgb(34,34,34);
            width: 100%;
            color:rgb(255,255,255);
            padding: 15px 0px;
            z-index: 999;
       }   
       .navbar .navbar-conteiner{
       		width:80%;
            display: flex;
            align-items: center;
            gap: 20px; /* Espaciado entre logo y enlaces */
        }
        .navbar ul {
        	width:100%;
            list-style: none;
            margin: 0;
            padding: 0;
            display: flex;
            gap: 30px;
        }
        .navbar-tittle{
        	
    		text-align:left;
        	width:600px;
        	font-size: 1.5rem;
            font-weight: bold;
            white-space: nowrap;
        }
        .navbar ul li a {
            color: rgb(255,255,255);
            font-size: 1rem;
            transition: color 0.3s ease;
        }
        
        .main{
        	display:flex;
        	position:absolute;
        	top:0;
        	left:0;
        	width: 100%;
        	
        	justify-content: center;
        	
        	z-index: 998;
        }
        .main-conteiner{
        	margin-top:80px;
        	margin-bottom:20px;
        	background: rgb(255,255,255);
            padding: 40px 40px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .main-conteiner .form-tittle {
        	text-align:left;
        	width:100%;
            font-weight: bold;
            margin: 5px 0px;
        }
        .tittle{
        	font-size: 1.5rem;
        }
        .sub-tittle{
        	ont-size: 1rem;
        }
        
        .main-conteiner .form-busqueda{
        	display:flex;
        	justify-content:flex-end;
        	gap:20px;
        	padding: 3px 0px;
        	
        }
        button{
			border: 2px solid rgb(220,220,220);
            color: rgb(255,255,255);
            background-color: rgb(62, 166, 255);
            border-radius: 5px;
            padding: 10px 20px;
            font-size: 14px;
            font-weight: bold;
            align-content: center;
        
        }
        input:not([type="submit"]){
        	width: 100%;
            padding: 10px 10px 10px 10px;
            border: 2px solid rgb(220,220,220);
            border-radius: 8px;
            font-size: 14px;
            outline: none;
            transition: all 0.3s ease;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        select {
            width: 100%;
            padding: 10px;
            border: 2px solid rgb(220, 220, 220);
            border-radius: 8px;
            font-size: 14px;
            outline: none;
            transition: all 0.3s ease;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            background-color: white;
        }

        select:focus {
            border-color: rgb(0, 123, 255); /* Color al hacer foco */
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5); /* Sombra de enfoque */
        }

        option {
            padding: 10px;
        }
        
        input:focus:not([type="submit"]) {
            border-color: rgb(8, 102, 255);
            box-shadow: 0 4px 10px rgba(8, 102, 255, 0.2);
        }
        
        .main-conteiner .form-operaciones{
        	display: flex;
        	width: 100%;
        	justify-content: flex-end;
        	gap: 10px;
        	margin: 10px 0px;
        }
        .main-conteiner .form-operaciones a{
        	min-width: 120px;
        	padding: 10px 10px;
        	text-align: center;
        }
        .main-conteiner .form-operaciones input[type="submit"]{
        
        	min-width: 120px;
        	border-radius: 5px;
            border:none;
            padding: 15px 20px;
            font-size: 14px;
            font-weight: bold;
        	text-align: center;
        	
        	background-color: rgb(2, 165, 75);
        	color: rgb(255,255,255);
        }
       
        
        a{
        	text-decoration:none;
            color: rgb(255,255,255);
            background-color: rgb(34,34,34);
            border-radius: 5px;
            padding: 10px 20px;
            font-size: 14px;
            font-weight: bold;
            align-content: center;
        }
        a:hover {
            background-color: rgb(54,54,54);
        }
        
		.table-container {
            max-width: 100%;
            border: 1px solid #ddd;
            border-radius: 5px;
            overflow: hidden;
            
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .table {
            border-collapse: collapse;
            width: 100%;
            table-layout: fixed;
            border-radius: 8px;
        }

        .table thead {
            background-color: #333;
            color: white;
            text-align: left;
        }

        .table thead th {
            padding: 12px 15px;
            position: sticky;
            top: 0;
            z-index: 1;
        }

        /* Contenedor con scroll solo para tbody */
        .tbody-container {
            display: block;
            overflow-y: auto;
            
            
        }

        .tbody-container table {
            table-layout: fixed; /* Asegura que las columnas mantengan el mismo ancho */
        }

        .table tbody tr {
            border-bottom: 1px solid #ddd;
        }

        .table tbody td {
            padding: 12px 15px;
        }

        .table tbody tr:hover {
            background-color: #f0f0f0;
        }

        .button-modificar,
        .button-eliminar {
            color: white;
            padding: 10px 10px;
            text-decoration: none;
            border-radius: 3px;
        }

        .button-modificar {
            background-color: rgb(0, 123, 255);
        }

        .button-modificar:hover {
            background-color: rgb(0, 86, 179);
        }

        .button-eliminar {
            background-color: rgb(220, 53, 69);
        }

        .button-eliminar:hover {
            background-color: rgb(200, 35, 51);
        }
        
        .input-group{
			display: flex;
			justify-content: space-between;
			gap: 5px;
			margin: 5px 0px;
		}
		
		.input-group span{
			display:inline-block;
			white-space: nowrap;
			min-width: 120px; /* Tamaño mínimo fijo */
   			
			font-size: 13px;
			font-weight:bold;
			background-color: rgb(54,54,54);
			color:rgb(255,255,255);
			text-align: left;
			align-content: center;
			padding: 0px 15px;
			border-radius: 8px;
			
		}
        
    </style>
    
</head>
<body>

	<%
	String url = "http://localhost:8080/";
	%>
	
	<div class="navbar">
        <div class="navbar-conteiner">
            <div class="navbar-tittle">WebProject</div>
            
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Services</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
            
        </div>
    </div>
	
</body>


</html>