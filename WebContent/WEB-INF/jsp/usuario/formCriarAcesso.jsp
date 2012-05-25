<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../template/head.jsp"></jsp:include>

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
		  <input type="button" value="Voltar" onclick="voltar();"/>
				   
		
		</form>
		
		<script type="text/javascript" src="../resource/js/Action.js"></script>
		<script type="text/javascript" src="../resource/js/Validate.js"></script>

<jsp:include page="../template/footer.jsp"></jsp:include>