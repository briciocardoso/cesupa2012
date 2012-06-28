<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../template/head.jsp"></jsp:include>

<h3>Edite seus dados</h3>

	<form action="../usuario/editar" method="post">
		<label>Nome: </label>
		<input type="text" name="usuario.nome" value="${usuario.nome}" size="10" />
		<p/>
		<label>Email:</label>
		<input type="text" name="usuario.email" value="${usuario.email}" size="10" />
		<p/>
		<label>Senha:</label>
		<input type="password" name="usuario.senha" value="${usuario.senha}"/>
		<p/>
		
		<input type="hidden" name="usuario.id" value="${usuario.id}" /> 
		<input type="submit" value="Editar"/>		
	</form>

<jsp:include page="../template/footer.jsp"></jsp:include>