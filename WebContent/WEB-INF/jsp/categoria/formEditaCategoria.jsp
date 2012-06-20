<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../template/head.jsp"></jsp:include>

	<h1>Edite sua categoria</h1><br/>
	<hr/>
	
	<form action="../editar" method="post" >
	
		<label >Descrição: </label>
		<input id="inp-descricao" type="text" name="categoria.descricao" value="${categoria.descricao}" size="70" />
		
		<input type="hidden" name="categoria.id" value="${categoria.id}"/>
		<input type="hidden" name="categoria.usuario.id" value="${categoria.usuario.id}"/>
		
		<input type="submit" value="Editar">
	
	</form>
	
	

<jsp:include page="../template/footer.jsp"></jsp:include>
