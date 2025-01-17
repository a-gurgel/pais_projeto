<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Vizualizar País</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
</head>
<body>

	<!-- Modal -->
	<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog"
		aria-labelledby="modalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Fechar">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalLabel">Excluir País</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir este país?
				</div>
				<div class="modal-footer">
					<form action="controller.do" method="post">
						<input type="hidden" name="id" value="${pais.id }" />
						<button type="submit" class="btn btn-primary" name="command"
							value="ExcluirPais">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<c:import url="Menu.jsp"/>
	<div id="main" class="container">
		<h3 class="page-header">Visualizar País #${pais.id}</h3>
		<div class="row">
			<div class="col-md-12">
				<c:if test="${not empty pais.nome }">
					<p><strong>Nome</strong></p>
					<p>${pais.nome}</p>
				</c:if>
				<c:if test="${empty pais.nome}">
					<p>
						<strong>Nome não informado</strong>
					</p>
				</c:if>	
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<c:if test="${not empty pais.populacao }">
					<p><strong>População</strong></p>
					<p>${pais.populacao}</p>
				</c:if>
				<c:if test="${empty pais.populacao}">
					<p>
						<strong>População não informada</strong>
					</p>
				</c:if>				
			</div>
			<div class="col-md-6">
				<c:if test="${not empty pais.area }">
					<p><strong>Area</strong></p>
					<p>${pais.area}</p>
				</c:if>
				<c:if test="${empty pais.area }">
					<p>
						<strong>Area não informada</strong>
					</p>
				</c:if>
			</div>
		</div>
		<hr />
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="controller.do?command=EditarPais&id=${pais.id }" class="btn btn-primary">Editar</a> 
				<a href="#" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal">Excluir</a> 
				<a href="ListarPaises.jsp" class="btn btn-default">Voltar</a>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>