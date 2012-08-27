<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:include page="../template/head.jsp"></jsp:include>
	
	<h1>Bem Vindo ao Saldo Positivo</h1>
	<hr/>
	
	<a href='<c:url value="/conta/formConta"/>' class="btn btn-small btn-primary">
	<i class="icon-plus"></i> Crie sua conta 
	</a>
	
	<c:if test="${!empty(listaUltimosLancamento)}">
	<h2>Próximos 5 Lançamentos</h2>
	<table class="table">
		<thead>
			<tr>
				<th>Data</th>
				<th>Conta</th>
				<th>Lançamento</th>
				<th>Valor</th>
			</tr>
		</thead>
		<c:forEach items="${listaUltimosLancamento}" var="lancamento">
		<tr>
			<td><fmt:formatDate value="${lancamento.data}" pattern="dd/MM/yyyy" /></td>
			<td>${lancamento.conta.nome}</td>
			<td>${lancamento.descricao}</td>
			<td class="${(lancamento.transacao == 'C')? "positivo" : "negativo"}"><fmt:formatNumber minFractionDigits="2" type="number" value="${lancamento.valor}"/></td>
		</tr>
	</c:forEach>
	</table>
	</c:if>

	<h2>Minhas contas</h2>
	<c:if test="${empty(listaContas)}">
		<div class="alert alert-error">
			Não Existem Contas Cadastradas.
		</div>
	</c:if>
	
	<div class="row-fluid">
	
	<c:forEach items="${listaContas}" var="conta">
	
	<div class="span6" style="margin-left: 4px;">
		<div class="well">
	
		<h4>${conta.nome}</h4>
		<div class="destaque">Saldo Atual: <span id="destaqueSaldo" class="${(conta.saldo >= 0)? "positivo" : "negativo"}"><fmt:formatNumber minFractionDigits="2" type="number" value="${conta.saldo}"/></span></div>
		<hr/>
		<a class="btn btn-mini btn-inverse" href="<c:url value="/conta/formEditaConta/${conta.id}"/>">
		<i class="icon-edit"></i> Editar Conta
		</a> 
		<a class="btn btn-mini btn-danger" href="<c:url value="/conta/excluir/${conta.id}"/>" onclick="return confirm('Confirma exclusão da Conta ?')">
		<i class="icon-remove"></i> Excluir Conta
		</a> 
		<a class="btn btn-mini btn-inverse" href="<c:url value="/lancamento/index/${conta.id}"/>">
		<i class="icon-share-alt"></i>Lançamentos</a>

		</div>
	</div>
	
	</c:forEach>
		</div>
	

<jsp:include page="../template/footer.jsp"></jsp:include>