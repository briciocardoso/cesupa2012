<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../resource/css/960gs.css" />
		<title>Saldo Positivo</title>
	</head>

	<body>
	
	<div class="container_12">

	<div class="grid_12">
	
	<h1>Bem Vindo ao Saldo Positivo</h1>
	
	<hr/>
	Usuário: ${usuarioSession.usuario.email}
	</div>
	
	<div class="grid_12">
		<a href='<c:url value="/conta/formConta"/>'> Crie sua conta </a>
	</div>
	
	<h2>Suas contas</h2>
	
	<c:forEach items="${listaContas}" var="conta">
	
	<h4>${conta.nome}</h4>
	<div>Saldo: ${conta.saldo}</div>
	<a href="<c:url value="/conta/formEditaConta/${conta.id}"/>">Editar Conta</a>
	<br/>
	
	 
	</c:forEach>
	
	
	</div>
	
	</body>

</html>