function voltar()
{
	window.back(-1);
}

function maskDate(val)
{
	 var pass = val.value;
	 
	 var expr = /[0123456789]/;
	
	 for(var i=0; i<pass.length; i++){
		 // charAt -> retorna o caractere posicionado no Ìndice especificado
		 var lchar = val.value.charAt(i);
		 var nchar = val.value.charAt(i+1);
	
		 if(i==0){
			 // search -> retorna um valor inteiro, indicando a posiÁ„o do inicio da primeira
			 // ocorrÍncia de expReg dentro de instStr. Se nenhuma ocorrencia for encontrada o mÈtodo retornara -1
			 // instStr.search(expReg);
			 if ((lchar.search(expr) != 0) || (lchar>3)){
				 val.value = "";
			 }
		
		 }else if(i==1){
		
			 if(lchar.search(expr) != 0){
				 // substring(indice1,indice2)
				 // indice1, indice2 -> ser· usado para delimitar a string
				 var tst1 = val.value.substring(0,(i));
				 val.value = tst1;
				 continue;
			 }
		
			 if ((nchar != '/') && (nchar != '')){
				 var tst1 = val.value.substring(0, (i)+1);
		
				 if(nchar.search(expr) != 0)
					 var tst2 = val.value.substring(i+2, pass.length);
				 else
					 var tst2 = val.value.substring(i+1, pass.length);
		
				 val.value = tst1 + '/' + tst2;
			 }
		
		 }else if(i==4){
		
			 if(lchar.search(expr) != 0){
				 var tst1 = val.value.substring(0, (i));
				 val.value = tst1;
				 continue;
			 }
		
			 if ((nchar != '/') && (nchar != '')){
				 var tst1 = val.value.substring(0, (i)+1);
		
				 if(nchar.search(expr) != 0)
					 var tst2 = val.value.substring(i+2, pass.length);
				 else
					 var tst2 = val.value.substring(i+1, pass.length);
		
				 val.value = tst1 + '/' + tst2;
			 }
		 }
		
		 if(i>=6){
			 if(lchar.search(expr) != 0) {
				 var tst1 = val.value.substring(0, (i));
				 val.value = tst1;
			 }
		 }
	 }
	
	 if(pass.length==10) {
		 return validaData(val);
	 }
	 
	 if(pass.length>10)
		val.value = val.value.substring(0, 10);
	
}

function maskNumber(fld, milSep, decSep) 
{
	len = fld.value.length;
	var strCheck = '0123456789';
	for(var i = 0; i < len; i++)
		if ((fld.value.charAt(i) != '0') && (fld.value.charAt(i) != decSep)) break;
	aux = '';
	for(; i < len; i++)
		if (strCheck.indexOf(fld.value.charAt(i))!=-1) aux += fld.value.charAt(i);
	len = aux.length;
	if (len == 0) fld.value = '';
	if (len == 1) fld.value = '0'+ decSep + '0' + aux;
	if (len == 2) fld.value = '0'+ decSep + aux;
	if (len > 2) {
		aux2 = '';
		for (j = 0, i = len - 3; i >= 0; i--) {
			if (j == 3) {
				aux2 += milSep;
				j = 0;
			}
			aux2 += aux.charAt(i);
			j++;
		}
		fld.value = '';
		len2 = aux2.length;
		for (i = len2 - 1; i >= 0; i--)
			fld.value += aux2.charAt(i);
		fld.value += decSep + aux.substr(len - 2, len);
	}
}
