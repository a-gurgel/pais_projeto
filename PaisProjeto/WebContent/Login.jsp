<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<c:import url="Menu.jsp"/>	<div id="login">
        <h3 class="text-center text-white pt-5">Login</h3>
        <div class="container" id="main" >
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="controller.do?command=FazerLogin" method="post">
                            <div class="form-group">
                                <label for="username" class="text-info">Username:</label><br>
                                <input type="text" name="username" id="username" class="form-control" maxlength="60" placeholder="Username" required>
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <input type="password" name="passwd" id="passwd" class="form-control" placeholder="Senha" required>
                            </div>
                            <div style="display: flex; justify-content: space-between">
	                            <div class="row col-md-8" >
									<button type="submit" class="btn btn-primary">
										<span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Enviar
									</button>
								</div>
								<div>
									<p  style="margin-bottom: 0px; margin-top: 10px;">Não tem conta? <a style="color: #007bff; cursor: pointer;" href="Registrar.jsp">Registre-se</a></p>
								</div>
							</div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<script src="js/jquery.min.js"></script>  
	<script src="js/bootstrap.min.js"></script>
</body>
</html>