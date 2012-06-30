<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="../template/head.jsp"></jsp:include>

	<h2>Categoria</h2>
	<hr/>
	
	<div id="messages"></div>
	
	<form action='<c:url value="/categoria/criarCategoria" />' method="post" name="form">
		<label>Descrição: </label>
		<input type="text" name="categoria.descricao" size="70" title="Descrição da Categoria" validate="required;" />
		<input type="submit" class="btn-success" value="Salvar" onclick="return isValida();">
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
			<div class="btn-group">
			<a class="btn-mini btn-inverse" href="<c:url value="/categoria/formEditaCategoria/${categoria.id}"/>">Editar</a>
			<a class="btn-mini btn-danger" href='<c:url value="/categoria/deletar/${categoria.id}"/>' onclick="return confirm('Confirma exclusão da categoria?')">Excluir</a>
			</div>
		</div>
	
	</c:forEach>
	
	<script type="text/javascript" src="../resource/js/Validate.js"></script>
<jsp:include page="../template/footer.jsp"></jsp:include>