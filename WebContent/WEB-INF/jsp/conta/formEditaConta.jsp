<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../template/head.jsp"></jsp:include>

	<h2>Editar Conta</h2>
	<hr />
			
	<div id="messages"></div>

	<form action="../editarConta" method="post" name="form">

	<label>Nome:</label>
	 <input type="text" name="conta.nome" title="Nome" value="${conta.nome}" validate="required;" size="70" />

	<label>Limite:</label>
	<input type="text" name="conta.limite" title="Limite" value="${conta.limite}" validate="required;number;" size="10" />
	
	<label>Saldo Inicial: </label>
	<input type="text" name="conta.saldoInicial" title="Saldo Inicial" value="${conta.saldoInicial}" validate="required;number;" size="10" />

	<label>Moeda: </label>
	 <select name="conta.moeda.id">
		<c:forEach items="${listaDeMoeda}" var="moeda">
			<option value="${moeda.id}">${moeda.descricao}</option>
		</c:forEach>
	</select> 

	<input type="hidden" name="conta.usuario.id" value="${conta.usuario.id}" /> 
	<input type="hidden" name="conta.id" value="${conta.id}" /> 
	
	<br/>
	
	<input class="btn btn-success" type="submit" value="Salvar"	onclick="return isValida();" />
	<input class="btn btn-inverse" type="button" value="Voltar"	onclick="window.back();" />

</form>

	<script type="text/javascript" src="/saldopositivo/resource/js/Validate.js"></script>
<jsp:include page="../template/footer.jsp"></jsp:include>