<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
	
	<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous">
	</script>
	
	<link rel="stylesheet" href="assets/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous">
		
	<script src="assets/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous">
	</script>
	
</head>
<body>


	<%
	String url = "http://localhost:8080/WebProjectTrabajadoresGui/";
	%>

	<div class="container-fluid" style="padding: 0px;">
	
	<nav class="navbar navbar-expand-lg bg-dark" data-bs-theme="dark">
		<div class="container" >
			<a class="navbar-brand" href="#">EnvYendYanHua</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">
					<li class="nav-item">
						<a class="nav-link active" aria-current="page" href="<%=url%>TrabajadorController?op=listar">Registro Trabajador</a>
					</li>
					<li class="nav-item">
						<a class="nav-link active" href="<%=url%>AsistenciaController?op=listar">Asistencia</a>
					</li>
					
					<!--  
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Reportes</a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Por Autor</a></li>
							<li><a class="dropdown-item" href="#">Por Libro</a></li>
							<li><a class="dropdown-item" href="#">Por Editorial</a></li>
						</ul>
					</li>
					-->
					
				</ul>
			</div>
		</div>
	</nav>
	
</div>



</body>
</html>