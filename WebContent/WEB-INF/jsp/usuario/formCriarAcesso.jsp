<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Saldo Positivo - Criar Acesso</title>
		</head>
	
<body>

		<h1> Crie seu acesso:</h1>
		
		<hr/>
		
		<form action='<c:url value="/usuario/criarAcesso"/>' method="post" name="form">
		
		  <label>Nome:</label>
		  <input type="text" name="usuario.nome" size="70" title="Nome" validate="required;"/>
		  <br/>

		  <label>Email:</label>
		  <input type="text" name="usuario.email" size="70" title="Email" validate="required;email;"/>

		  <br/>	
		  
		  <label>Senha:</label>
		  <input type="text" name="usuario.senha" size="30" title="Senha" validate="required;min(6);"/>

		  <br/>

		  <label>Confirmação de Senha:</label>
		  <input type="text" name="confirmacaoSenha" size="30" title="Confirmação de Senha" validate="equals(usuario.senha);"/>	
		  <br/>

		  <input type="submit" value="Salvar" onclick="return isValida();"/>		   
		
		</form>
		
		<script type="text/javascript" src="../resource/js/Validate.js"></script>

</body>
</html>