<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../template/head.jsp"></jsp:include>

	<h1>Categoria</h1>
	
	<br/>
	
	<form action='<c:url value="/categoria/criarCategoria" />' method="post"> 
		<label>Descrição: </label>
		<input type="text" name="categoria.descricao" size="70" />
		<input type="submit" value="Criar">
	</form>
	
	<h3>Suas categorias:</h3>
	
	<c:forEach items="${listaCateriaPorUsuario}" var="categoria" >
	
		<div class="boxCategoria">
			<div>${categoria.descricao}</div>
			<a href="<c:url value="/categoria/formEditaCategoria/${categoria.id}"/>">Editar</a> - 
			<a href='<c:url value="/categoria/deletar/${categoria.id}"/>' onclick="return confirm('Confirma exclusão da categoria?')">Excluir</a>
		</div>

		<br/>
	
	</c:forEach>
	
<jsp:include page="../template/footer.jsp"></jsp:include>