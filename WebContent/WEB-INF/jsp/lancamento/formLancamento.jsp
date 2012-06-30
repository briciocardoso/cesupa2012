<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../template/head.jsp"></jsp:include>
	
	<h2>Novo Lançamento</h2>
	<hr/>
	
	<div id="messages"></div>
	
	<form action='<c:url value="/lancamento/criarLancamento"/>'  method="post" name="form">
		
			<label>Descrição:</label>
			<input type="text" name="lancamento.descricao" title="Descrição" validate="required;" size="70" />
			
			<br/>
			
			<label>Data:</label>
			<input type="text" name="lancamento.data" title="Data" validate="required;date;" size="10" onkeyup="maskDate(this);"/>
			
			<br/>
			
			<label>Valor:</label>
			<input type="text" name="lancamento.valor" title="Valor" validate="required;number;" size="10" onkeyup="maskNumber(this,'','.');" />
			
			<br/>
			
			<label>Transação</label>
			<input type="radio" name="lancamento.transacao" value="C"/>Crédito
			<input type="radio" name="lancamento.transacao" value="D"/>Débito
			
			
			<label>Categoria:</label>
			<select name="lancamento.categoria.id">
				<option value="0">Selecione</option>
				<c:forEach items="${listaCategoria}" var="categoria"> 
          		   <option value ="${categoria.id}"> 
          		   		${categoria.descricao}
          		    </option>  
    			</c:forEach>
			</select>
			
			<br/>
			
			<input type="hidden" value="${idConta}" name="lancamento.conta.id"/>			
			<input type="submit" value="Salvar" onclick="return isValida();" class="btn-success" />
			<input type="button" value="Voltar" onclick="history.back();" class="btn-inverse" />
						
			
		</form>
		
		<script type="text/javascript" src="/saldopositivo/resource/js/Validate.js"></script>
		<script type="text/javascript" src="/saldopositivo/resource/js/Action.js"></script>
		
	
	
	
<jsp:include page="../template/footer.jsp"></jsp:include>