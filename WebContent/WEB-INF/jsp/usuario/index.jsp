<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../template/head.jsp"></jsp:include>
	
	<div class="grid_12">
	<h1>Bem Vindo ao Saldo Positivo</h1>
	<hr/>
	Usuário: ${usuarioSession.usuario.email}
	</div>
	
	<div class="grid_12">
		<a href='<c:url value="/conta/formConta"/>' class="btn"> Crie sua conta </a>
	</div>
	
	<h2>Suas contas</h2>
	
	<c:forEach items="${listaContas}" var="conta">
	
	<h4>${conta.nome}</h4>
	<div>Saldo: ${conta.saldo}</div>
	<a href="<c:url value="/conta/formEditaConta/${conta.id}"/>">Editar Conta</a>
	<br/>
	
	</c:forEach>

	
<jsp:include page="../template/footer.jsp"></jsp:include>
	