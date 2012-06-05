<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../template/head.jsp"></jsp:include>
	
	<h1>Bem Vindo ao Saldo Positivo</h1>
	<hr/>
	Usuário: ${usuarioSession.usuario.email}
	
	<a href='<c:url value="/conta/formConta"/>' class="btn"> Crie sua conta </a>
	
	<h2>Suas contas</h2>
	
	<c:forEach items="${listaContas}" var="conta">
	
		<div class="boxConta">
	
		<h4>${conta.nome}</h4>
		<div>Saldo: ${conta.saldo}</div>
		<a href="<c:url value="/conta/formEditaConta/${conta.id}"/>">Editar Conta</a> - 
		<a href="<c:url value="/conta/excluir/${conta.id}"/>" onclick="return confirm('Confirma exclusão da Conta ?')">Excluir Conta</a>
		<br/>

		</div>
	
	</c:forEach>

	
<jsp:include page="../template/footer.jsp"></jsp:include>
	