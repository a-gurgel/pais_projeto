<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema de Paises</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<header>
		<c:import url="menu.jsp" />
	</header>
	<main class="container">
		<div>
			<h4 class="font-weight-normal" id="info">País cadastrado com
				sucesso!</h4>
			<p class="font-weight-normal" id="info">segue abaixo as
				informações do país cadastrado</p>
		</div>

		<div class="jumbotron bg-light border border-primary">
			<p id="attr-p"> Id: ${pais.id}</p>
			<p id="attr-p"> Nome: ${pais.nome}</p>
			<p id="attr-p"> Area: ${pais.area}</p>
			<p id="attr-p">	População: ${pais.populacao}</p>
		</div>
		<div id="btn-voltar">
			<a type="button" href="ListarPaises.jsp" class="btn btn-primary btn-lg">Voltar</a>
		</div>
	</main>

	<footer class="bg-light text-center">
		<p class=" text-muted">@Sistema de Paises</p>
	</footer>

</body>
</html>
