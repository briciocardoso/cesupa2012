<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../template/head.jsp"></jsp:include>
		
		<h2>Crie sua conta</h2>
		<hr/>
		
		<div id="messages"></div>
		
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
			
			<input type="submit" value="Salvar" onclick="return isValida();" class="btn btn-success" />
			<input type="button" value="Voltar" onclick="window.back();" class="btn btn-inverse" />
						
			
		</form>
		
		<script type="text/javascript" src="/saldopositivo/resource/js/Validate.js"></script>

<jsp:include page="../template/footer.jsp"></jsp:include>