<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>		

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Bem Vindo</title>
	</head>
	
<body>

	<h1>Bem Vindo ao Saldo</h1>
	
	<hr/>
	
	<h3>Realize seu Login</h3>
	
	<form action='<c:url value="/usuario/realizarLogin"/>' method="post">
	
	
		<label>Email</label>
		<input type="text" name="usuario.email" size="70" />
		
		<br/>
		
		<label>Senha</label>
		<input type="text" name="usuario.senha" size="70" />
		
		<br/>
		
		<input type="submit" value="Login"/>
		
	</form>
</body>

</html>