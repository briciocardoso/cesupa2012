<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../template/head.jsp"></jsp:include>

<h2>Conta: ${conta.nome} - Saldo ${conta.saldo}</h2>


<a href="<c:url value="/lancamento/formLancamento/${conta.id}"/>" class="btn">Novo Lançamento</a>

<table class="table table-striped">
	<thead>
		<tr>
			<th>Data</th>
			<th>Descrição</th>
			<th>Valor</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaLancamento}" var="lancamento">
		<tr>
			<td>${lancamento.data}</td>		
			<td>${lancamento.descricao}</td>		
			<td>${lancamento.valor}</td>
			<td><a href="<c:url value="/lancamento/formEditarLancamento/${lancamento.id}"/>">Editar</a></td>
			<td><a href="<c:url value="/lancamento/excluirLancamento/${lancamento.id}"/>">Excluir</a></td>
					
		</tr>
		</c:forEach>
	</tbody>
</table>



<jsp:include page="../template/footer.jsp"></jsp:include>