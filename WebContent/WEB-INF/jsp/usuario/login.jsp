<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>		

<jsp:include page="../template/headerNoAutentication.jsp"></jsp:include>

	<h1 id="tituloIndex">Saldo Positivo</h1>
	
	<hr/>
	
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

<jsp:include page="../template/footerNoAutentication.jsp"></jsp:include>
