<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Crie sua conta</title>
	</head>
<body>
		
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
			
			<input type="submit" value="Salvar" onclick="return isValida();" />			
			
		</form>
		
		<script type="text/javascript" src="../resource/js/Validate.js"></script>
</body>

</html>