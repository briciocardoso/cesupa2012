<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../template/head.jsp"></jsp:include>
		
		<h1>Crie sua conta</h1>
		<hr/>
		
		<form action='<c:url value="/conta/criarConta"/>'  method="post" name="form">
		
			<label>Nome:</label>
			<input type="text" name="conta.nome" title="Nome" validate="required;" size="70" />
			
			<br/>
			
			<label>Limite:</label>
			<input type="text" name="conta.limite" title="Limite" validate="required;number;" size="10"  />
			
			<br/>
			
			<label>Saldo Inicial: </label>
			<input type="text" name="conta.saldoInicial" title="Saldo Inicial" validate="required;number;" size="10" />
			
			<br/>
			
			<label>Moeda: </label>
			<select name="conta.moeda.id">
				<c:forEach items="${listaDeMoeda}" var="moeda"> 
          		   <option value ="${moeda.id}"> 
          		   		${moeda.descricao}
          		    </option>  
    			</c:forEach>
			</select>
			
			<br/>
			
			<input type="submit" value="Salvar" onclick="return isValida();" class="btn-success" />			
			
		</form>
		
		<script type="text/javascript" src="/saldopositivo/resource/js/Validate.js"></script>

<jsp:include page="../template/footer.jsp"></jsp:include>