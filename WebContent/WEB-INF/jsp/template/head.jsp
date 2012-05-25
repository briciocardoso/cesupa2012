<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="/saldopositivo/resource/css/estilo.css" />
	<link rel="stylesheet" type="text/css" href="/saldopositivo/resource/css/bootstrap.css" />
	
	<title>Saldo Positivo</title>
</head>
<body>

<div class="navbar navbar-fixed-top">

<div class="navbar-inner">

<div class="container">

<a class="brand">Saldo Positivo</a>

<ul class="nav">
	<li><a href="../usuario/index">Home</a></li>
	<li><a>Contas</a></li>
	<li><a>Categorias</a></li>
	<li><a>Usuário</a></li>
	<li><a href="../usuario/sair">Sair</a></li>
</ul>

</div>
</div>


</div>

<div class="container">
	<div class="hero-unit">
	<div id="messageSuccess">${success}</div>
	<div id="messageError">${error}</div>
