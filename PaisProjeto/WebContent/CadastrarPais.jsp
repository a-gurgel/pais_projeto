<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Cadastrar País</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<c:import url="Menu.jsp"/>
	<div id="main" class="container">
		<h3 class="page-header">Cadastrar País</h3>
		<form action="controller.do" method="post">
			<div class="row">
				<div class="form-group col-md-12">
			 		<label for="nome">Nome</label>
			 		<input type="text" class="form-control" name="nome" id="nome" required maxlength="100"  placeholder="Nome"/>
			 	</div>
			 </div>
			 <div class="row">  
				 <div class="form-group col-md-6">  
					 <label for="populacao">População</label>  
					 <input type="number" class="form-control" name="populacao" id="populcao" maxlength="20"  placeholder="População"/>  
				 </div>  
				 <div class="form-group col-md-6">  
					 <label for="area">Area</label>  
					 <input type="number" class="form-control" name="area" id="area"  placeholder="Area"/>  
				 </div>  
			 </div>   
			 <hr/>  
			 <div id="actions" class="row">
			 	<div class="md-col-12">  
				 	<button type="submit" class="btn btn-primary" name="command" value="CriarPais" >  Salvar</button>  
				 	<a href="index.jsp" class="btn btndefault">Cancelar</a>  
			 	</div>  
		 	</div>  
	 	</form>  
	</div>
	<script src="js/jquery.min.js"></script>  
	<script src="js/bootstrap.min.js"></script>
</body>
</html>