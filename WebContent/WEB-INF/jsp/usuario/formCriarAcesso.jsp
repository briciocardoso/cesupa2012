<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>		

<jsp:include page="../template/headerNoAutentication.jsp"></jsp:include>

	<h1>Crie seu acesso</h1>
	
	<hr/>
	
	</div>
	
	<div class="clear"></div>
	
	<div class="grid_4 prefix_3">
	
		<div id="messages"></div>
		
		<form action='<c:url value="/usuario/criarAcesso"/>' method="post" name="form">
		
		  <label>Nome <span id="messageError">*</span>:</label>
		  <input type="text" tabindex="1" name="usuario.nome" size="70" title="Nome" validate="required;" onblur="validateField(this);"/>
		  <br/>

		  <label>Email <span id="messageError">*</span>:</label>
		  <input type="text" name="usuario.email" size="70" title="Email" validate="required;email;" onblur="validateField(this);"/>

		  <br/>	
		  
		  <label>Senha <span id="messageError">*</span>:</label>
		  <input id="usuario.senha" type="password" name="usuario.senha" size="30" title="Senha" validate="required;min(6);" onblur="validateField(this);"/>

		  <br/>
		
		  <label>Confirmação de Senha <span id="messageError">*</span>:</label>
		  <input type="password" name="confirmacaoSenha" size="30" title="Confirmação de Senha" validate="required;equals(usuario.senha);" onblur="validateField(this);"/>	
		  <br/>

		  <input type="submit" value="Salvar" onclick="return isValida();" class="btn btn-success"/>
		  
		  <input type="button" value="Voltar" onclick="voltar();" class="btn btn-inverse"/>
				   
		
		</form>
		
		<script type="text/javascript" src="../resource/js/Action.js"></script>
		<script type="text/javascript" src="../resource/js/Validate.js"></script>

<jsp:include page="../template/footerNoAutentication.jsp"></jsp:include>
