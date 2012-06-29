<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../template/head.jsp"></jsp:include>

	<h2>Transferências entre Contas</h2>
	<hr/>
	
	<c:if test="${empty(listaDeConta)}">
		<div class="alert alert-error">
			Não Existem Contas Cadastradas para a realização de Transferência.
		</div>
	</c:if>
	
	<c:if test="${!empty(listaDeConta)}">
	
	<form  action='<c:url value="/conta/criarTransferencia"/>' method="post">
		 
		<label>Conta Debito</label>
			<select name="transferencia.contaDebito.id">
				<c:forEach items="${listaDeConta}" var="conta"> 
          		   <option value ="${conta.id}"> 
          		   		${conta.nome}
          		    </option>  
    			</c:forEach>
			</select>
			
			<br/>
			
		<label>Conta Credito</label>
			<select name="transferencia.contaCredito.id">
				<c:forEach items="${listaDeConta}" var="conta"> 
          		   <option value ="${conta.id}"> 
          		   		${conta.nome}
          		    </option>  
    			</c:forEach>
			</select>
		<br/>
		
		<label>Valor:</label>
		<input type="text" name="transferencia.valor" size="10"  />
		<br/>
		<label>Data</label>
		<input type="text" name="transferencia.data" size="10" />
		
		<br/>
		
		<input type="submit" value="Salvar" />
	
	</form>
	
	</c:if>

<jsp:include page="../template/footer.jsp"></jsp:include>