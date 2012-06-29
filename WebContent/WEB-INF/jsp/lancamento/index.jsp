<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  


<jsp:include page="../template/head.jsp"></jsp:include>

<h2>Conta: ${conta.nome} - Saldo <span class="${(conta.saldo >=0)? "positivo" : "negativo" }">${conta.saldo}</span></h2>

<a href="<c:url value="/lancamento/formLancamento/${conta.id}"/>" class="btn">Novo Lançamento</a>

<hr/>

<c:if test="${empty(listaLancamento)}">
	<div class="alert alert-error">
			Não Existem Lançamentos Cadastradas.
	</div>
</c:if>

<c:if test="${!empty(listaLancamento)}">

<table class="table table-striped">
	<thead>
		<tr>
			<th>Data</th>
			<th>Descrição</th>
			<th>Categoria</th>
			<th>Valor</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaLancamento}" var="lancamento">
		<tr>
			<td><fmt:formatDate value="${lancamento.data}" pattern="dd/MM/yyyy" /></td>
			<td>${lancamento.descricao}</td>	
			<td>${lancamento.categoria.descricao}</td>	
			<td class="${(lancamento.valor == 'C')? "positivo" : "negativo"}">${lancamento.valor}</td>
			<td><a href="<c:url value="/lancamento/formEditarLancamento/${lancamento.id}"/>">Editar</a></td>
			<td><a href="<c:url value="/lancamento/excluirLancamento/${lancamento.id}"/>">Excluir</a></td>
					
		</tr>
		</c:forEach>
	</tbody>
</table>

</c:if>



<jsp:include page="../template/footer.jsp"></jsp:include>