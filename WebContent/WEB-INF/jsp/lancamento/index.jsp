<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../template/head.jsp"></jsp:include>

<h2>Conta: ${conta.nome}</h2>

<a href="<c:url value="/lancamento/formLancamento/${conta.id}"/>" class="btn">Novo Lan�amento</a>

<table class="table table-striped">
	<thead>
		<tr>
			<th>Data</th>
			<th>Descri��o</th>
			<th>Valor</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaLancamento}" var="lancamento">
		<tr>
			<td>${lancamento.data}</td>		
			<td>${lancamento.descricao}</td>		
			<td>${lancamento.valor}</td>		
		</tr>
		</c:forEach>
	</tbody>
</table>



<jsp:include page="../template/footer.jsp"></jsp:include>