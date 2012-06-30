<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:include page="../template/head.jsp"></jsp:include>
	
	<h1>Bem Vindo ao Saldo Positivo</h1>
	<hr/>
	
	<a href='<c:url value="/conta/formConta"/>' class="btn btn-small btn-primary">
	<i class="icon-plus"></i> Crie sua conta 
	</a>
	
	<h2>Minhas contas</h2>
	
	<c:if test="${empty(listaContas)}">
		<div class="alert alert-error">
			Não Existem Contas Cadastradas.
		</div>
	</c:if>
	
	<c:forEach items="${listaContas}" var="conta">
	
		<div class="well">
	
		<h4>${conta.nome}</h4>
		<div>Saldo Atual: <span class="${(conta.saldo >= 0)? "positivo" : "negativo"}"><fmt:formatNumber minFractionDigits="2" type="number" value="${conta.saldo}"/></span></div>
		<hr/>
		<div class="btn-group">
		<a class="btn-mini btn-inverse" href="<c:url value="/conta/formEditaConta/${conta.id}"/>">
		<i class="icon-edit"></i> Editar Conta
		</a> 
		<a class="btn-mini btn-danger" href="<c:url value="/conta/excluir/${conta.id}"/>" onclick="return confirm('Confirma exclusão da Conta ?')">
		<i class="icon-remove"></i> Excluir Conta
		</a> 
		<a class="btn-mini btn-inverse" href="<c:url value="/lancamento/index/${conta.id}"/>">
		<i class="icon-share-alt"></i>Lançamentos</a>
		</div>

		</div>
	
	</c:forEach>


	
<jsp:include page="../template/footer.jsp"></jsp:include>
	
