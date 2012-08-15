<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../template/headerNoAutentication.jsp"></jsp:include>


	<h1>Recuperação de senha</h1>
	<hr/>
	
	<div id="messages"></div>
	
	<div id="infoRecuperaSenha">
		<p>Informe seu email cadastrado para que possamamos enviar uma nova senha para você.</p>
	</div>
	
	<form name="form" action='<c:url value="/usuario/sendEmailSenha" />' method="post">
		<label>Email:</label>
		<p/>
		<input type="text" name="email" size="70" validate="required;email;" title="Email" /><br/>
		<input type="submit" value="Recuperar senha" class="btn btn-success" onclick="return isValida();">
		<input type="button" value="Voltar" onclick="voltar();" class="btn btn-inverse"/>
	</form>

<jsp:include page="../template/footerNoAutentication.jsp"></jsp:include>