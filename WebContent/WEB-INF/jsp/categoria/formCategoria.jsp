<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../template/head.jsp"></jsp:include>

	<h2>Categoria</h2>
	<hr/>
	
	<form action='<c:url value="/categoria/criarCategoria" />' method="post">
		<label>Descrição: </label>
		<input type="text" name="categoria.descricao" size="70" />
		<input type="submit" class="btn-success" value="Salvar">
	</form>
	
	<h3>Minhas Categorias:</h3>
	
	<c:if test="${empty(listaCateriaPorUsuario)}">
		<div class="alert alert-error">
			Não Existem Categorias Cadastradas.
		</div>
	</c:if>
	
	<c:forEach items="${listaCateriaPorUsuario}" var="categoria" >
	
		<div class="well">
			<div>${categoria.descricao}</div>
			<a href="<c:url value="/categoria/formEditaCategoria/${categoria.id}"/>">Editar</a> - 
			<a href='<c:url value="/categoria/deletar/${categoria.id}"/>' onclick="return confirm('Confirma exclusão da categoria?')">Excluir</a>
		</div>
	
	</c:forEach>
	
<jsp:include page="../template/footer.jsp"></jsp:include>