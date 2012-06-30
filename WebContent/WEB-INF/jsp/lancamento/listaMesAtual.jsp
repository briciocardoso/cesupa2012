<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  


<jsp:include page="../template/head.jsp"></jsp:include>

<h2>Conta: ${conta.nome} - Saldo <span class="${(conta.saldo >=0)? "positivo" : "negativo" }">${conta.saldo}</span></h2>

<a href="<c:url value="/lancamento/formLancamento/${conta.id}"/>" class="btn btn-small btn-primary">
<i class="icon-plus"></i> Novo Lançamento</a>

<hr/>

<c:if test="${empty(listaLancamento)}">
	<div class="alert alert-error">
			Não Existem Lançamentos Cadastradas.
	</div>
</c:if>

<c:if test="${!empty(listaLancamento)}">

<a class="btn-inverse btn-small" href="<c:url value="/lancamento/listaMesAtual/${conta.id}"/>">Mês Atual</a> 
<a class="btn-inverse btn-small" href="<c:url value="/lancamento/index/${conta.id}"/>">Todos Lançamentos</a>

<c:set var="saldoLancamento" value="0" scope="page"></c:set>

<table class="table table-striped">
	<thead>
		<tr>
			<th>Data</th>
			<th>Descrição</th>
			<th>Categoria</th>
			<th>Valor</th>
			<th>Saldo</th>
		</tr>
	</thead>
	<tbody>
		
		<c:forEach items="${listaLancamento}" var="lancamento">
		<tr>
			<c:if test="${lancamento.transacao == 'C'}">
				<c:set var="saldoLancamento" value="${saldoLancamento + lancamento.valor}"></c:set>
			</c:if>
			<c:if test="${lancamento.transacao == 'D'}">
				<c:set var="saldoLancamento" value="${saldoLancamento - lancamento.valor}"></c:set>
			</c:if>
			
			
			<td><fmt:formatDate value="${lancamento.data}" pattern="dd/MM/yyyy" /></td>
			<td>${lancamento.descricao}</td>	
			<td>${lancamento.categoria.descricao}</td>	
			<td class="${(lancamento.transacao == 'C')? "positivo" : "negativo"}">${lancamento.valor}</td>
			<td class="${(saldoLancamento >= 0)? "positivo" : "negativo"}"">${saldoLancamento}</td>
			<td><a class="btn btn-inverse btn-mini" href="<c:url value="/lancamento/formEditarLancamento/${lancamento.id}"/>">Editar</a></td>
			<td><a class="btn btn-danger btn-mini" href="<c:url value="/lancamento/excluirLancamento/${lancamento.id}"/>" onclick="return confirm('Confirma a Exclusão do Lançamento ?')">Excluir</a></td>
					
		</tr>
		</c:forEach>
	</tbody>
</table>

</c:if>



<jsp:include page="../template/footer.jsp"></jsp:include>