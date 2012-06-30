<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="../template/head.jsp"></jsp:include>

	<h2>Transferências entre Contas</h2>
	<hr/>
	
	<div id="messages"></div>
	
	<c:if test="${empty(listaDeConta)}">
		<div class="alert alert-error">
			Não Existem Contas Cadastradas para a realização de Transferência.
		</div>
	</c:if>
	
	<c:if test="${!empty(listaDeConta)}">
	
	<form  action='<c:url value="/conta/criarTransferencia"/>' method="post" name="form">
		 
		<label>Conta Debito</label>
			<select name="transferencia.contaDebito.id" title="Conta Débito" validate="required;">
				<c:forEach items="${listaDeConta}" var="conta"> 
          		   <option value ="${conta.id}"> 
          		   		${conta.nome}
          		    </option>  
    			</c:forEach>
			</select>
			
			<br/>
			
		<label>Conta Credito</label>
			<select name="transferencia.contaCredito.id" title="Conta Crédito" validate="required;">
				<c:forEach items="${listaDeConta}" var="conta"> 
          		   <option value ="${conta.id}"> 
          		   		${conta.nome}
          		    </option>  
    			</c:forEach>
			</select>
		<br/>
		
		<label>Valor:</label>
		<input type="text" name="transferencia.valor" size="10" title="Valor" validate="required;number;"  />
		<br/>
		<label>Data</label>
		<input type="text" name="transferencia.data" size="10" title="Data" validate="required;" />
		
		<br/>
		
		<input type="submit" value="Salvar" class="btn btn-success" onclick="return isValida();"/>
		<input type="button" value="Voltar" class="btn btn-inverse" onclick="window.back();"/>
		
	
	</form>
	
	
	</c:if>

<script type="text/javascript" src="/saldopositivo/resource/js/Validate.js"></script>
<jsp:include page="../template/footer.jsp"></jsp:include>