<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../template/head.jsp"></jsp:include>
	
	<h2>Novo Lançamento</h2>
	
	<form action='<c:url value="/lancamento/criarLancamento"/>'  method="post" name="form">
		
			<label>Descrição:</label>
			<input type="text" name="lancamento.descricao" title="Descrição" validate="required;" size="70" />
			
			<br/>
			
			<label>Data:</label>
			<input type="text" name="lancamento.data" title="Data" validate="required;date;" size="10"  />
			
			<br/>
			
			<label>Valor:</label>
			<input type="text" name="lancamento.valor" title="Valor" validate="required;number;" size="10" />
			
			<br/>
			
			<label>Transação</label>
			<input type="radio" name="lancamento.transacao" value="C"/>Crédito
			<input type="radio" name="lancamento.transacao" value="D"/>Débito
			
			
			<label>Categoria:</label>
			<select name="lancamento.categoria.id">
				<c:forEach items="${listaCategoria}" var="categoria"> 
          		   <option value ="${categoria.id}"> 
          		   		${categoria.descricao}
          		    </option>  
    			</c:forEach>
			</select>
			
			<br/>
			
			<br/>
			
			<input type="hidden" value="${idConta}" name="lancamento.conta.id"/>			
			
			
			<input type="submit" value="Salvar" onclick="return isValida();" class="btn-success" />			
			
		</form>
		
		<script type="text/javascript" src="/saldopositivo/resource/js/Validate.js"></script>
	
	
	
<jsp:include page="../template/footer.jsp"></jsp:include>