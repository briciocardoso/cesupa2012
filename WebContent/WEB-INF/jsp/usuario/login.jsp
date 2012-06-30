<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>		

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../resource/css/960gs.css" />
		<link rel="stylesheet" type="text/css" href="../resource/css/bootstrap.css" />
		
		<title>Saldo Positivo</title>
	</head>
	
<body>

<div class="container_12">

	<div class="grid_12">

	<h1>Bem Vindo ao Saldo Positivo</h1>
	
	<hr/>
	
	</div>
	
	<div class="clear"></div>
	
	<div class="grid_4 prefix_4">
	
		<div id="messages"></div>
		
		<div class="well">
		<h4>Realize o seu login</h4>
		
		<form action='<c:url value="/usuario/realizarLogin"/>' name="form" method="post">
		
			<label>Email</label>
			<input type="text" name="usuario.email" size="70" title="Email" validate="required;email;" />
			
			<br/>
			
			<label>Senha</label>
			<input type="password" name="usuario.senha" size="70" title="Senha" validate="required;"/>
			
			<br/>
			
			<input type="submit" value="Login" onclick="return isValida();" class="btn-primary"/>
			
			<br/>
			
			<a href="<c:url value="/usuario/formCriarAcesso"/>">Criar acesso ao Saldo Positivo</a><br>
			<a href="<c:url value="/usuario/formSenha" />">Esqueceu sua senha ?</a>
			
		</form>
		
		</div>
	
	</div>
	
	<div class="clear"></div>

</div>

	
	<script type="text/javascript" src="../resource/js/Ajax.js"></script>
	<script type="text/javascript" src="../resource/js/Validate.js"></script>

	
</body>

</html>