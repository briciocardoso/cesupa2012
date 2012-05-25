<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../template/head.jsp"></jsp:include>

			<h1>Atualizar Conta</h1>
			<hr />

			<form action="../editarConta" method="post" name="form">

				<label>Nome:</label> <input type="text" name="conta.nome"
					title="Nome" value="${conta.nome}" validate="required;" size="70" />

				<br /> <label>Limite:</label> <input type="text" name="conta.limite"
					title="Limite" value="${conta.limite}" validate="required;number;"
					size="10" /> <br /> <label>Saldo Inicial: </label> <input
					type="text" name="conta.saldoInicial" title="Saldo Inicial"
					value="${conta.saldoInicial}" validate="required;number;" size="10" />

				<br /> <label>Moeda: </label> <select name="conta.moeda.id">
					<c:forEach items="${listaDeMoeda}" var="moeda">
						<option value="${moeda.id}">${moeda.descricao}</option>
					</c:forEach>
				</select> <br /> <input type="hidden" name="conta.usuario.id"
					value="${conta.usuario.id}" /> <input type="hidden" name="conta.id"
					value="${conta.id}" /> <input type="submit" value="Salvar"
					onclick="return isValida();" />

			</form>

	<script type="text/javascript" src="../resource/js/Validate.js"></script>
<jsp:include page="../template/footer.jsp"></jsp:include>