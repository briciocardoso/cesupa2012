<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../template/head.jsp"></jsp:include>

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
		<input type="t" name="transferencia.data" size="10" />
		
		<br/>
		
		<input type="submit" value="Salvar" />
	
	</form>

<jsp:include page="../template/footer.jsp"></jsp:include>