<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../template/head.jsp"></jsp:include>

<h2>Edite seus dados</h2>

<hr/>

	<form action="../usuario/editar" method="post" name="form">
	
		<div class="grid_4 prefix_3">
	
		<div id="messages"></div>
		
		<label>Nome: <spam id="messageError">*</spam> </label>
		<input type="text" name="usuario.nome" value="${usuario.nome}" size="10" title="Nome" validate="required;" />		<p/>
		
		<label>Email: <spam id="messageError">*</spam></label>
		<input type="text" name="usuario.email" value="${usuario.email}" size="10" title="Email" validate="required;email;" onblur="validateField(this);" />   <p/>
		
		<label>Senha atual: <spam id="messageError">*</spam></label>
		<input type="password" name="senhaAtualDigitada" size="7" title="Senha atual" validate="required;min(6);" onblur="validateField(this);" />	<p/>
		
		<label>Senha: <spam id="messageError">*</spam></label>
		<input type="password" name="novaSenhaDigitada" size="7" title="Senha" validate="required;min(6);" onblur="validateField(this);" />	<p/>
		  
		<label>Confirmação de Senha: <spam id="messageError">*</spam></label>
		<input type="password" name="usuario.confSenha" size="7" title="Confirmação de Senha" validate="required;equals(novaSenhaDigitada);" onblur="validateField(this);" /> <p/>
			
		<input type="hidden" name="usuario.id" value="${usuario.id}" />
		<input type="hidden" name="usuario.senha" value="${usuario.senha}">	
			
		<input type="submit" class="btn btn-success" value="Salvar" onclick="return isValida();"/>
		<input type="button" onclick="voltar();" value="Mudei de ideia" class="btn btn-inverse" />		
		
		</div>

	</form>
	
	<script type="text/javascript" src="../resource/js/Action.js"></script>
	<script type="text/javascript" src="../resource/js/Validate.js"></script>	

<jsp:include page="../template/footer.jsp"></jsp:include>
