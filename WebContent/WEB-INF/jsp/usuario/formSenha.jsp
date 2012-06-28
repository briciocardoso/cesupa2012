<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../template/head.jsp"></jsp:include>

	<h1>Recuperação de senha</h1>
	<hr/>
	
	<div id="infoRecuperaSenha">
		<p>Informe seu email cadastrado para que possamamos enviar uma nova senha para você.</p>
	</div>
	
	<form action='<c:url value="/usuario/sendEmailSenha" />' method="post">
		<label>Email:</label>
		<p/>
		<input type="text" name="email" size="70" /><br/>
		<input type="submit" value="Recuperar senha">
	</form>

<jsp:include page="../template/footer.jsp"></jsp:include>