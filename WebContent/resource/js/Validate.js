function isValida()
{
	hiddenMessage();

	var elements = document.form.elements;

	for ( var i = 0; i < elements.length; i++)
	{
		if (!validateField(elements[i]))
			return false;
	}
	return true;
}

function validateField(element)
{
	if (isTypeValidate(element.type))
	{
		var validate = element.getAttribute('validate');

		if (validate != null)
		{
			var validacao = "";
			var itemValidacao = new Array();
			var totalValidacao = 0;

			for ( var x = 0; x < validate.length; x++)
			{
				if (validate.charAt(x) != ";")
					validacao += validate.charAt(x);
				else
				{
					itemValidacao[totalValidacao++] = validacao;
					validacao = "";
				}
			}

			for ( var j = 0; j < itemValidacao.length; j++)
			{
				if (trataValidate(itemValidacao[j], element))
					return false;
			}
		}
	}
	
	return true;
}

function trataValidate(validate,campo,label)
{
	if (isValidateComParametro(validate))
		return trataValidateFunction(validate, campo);

	switch (validate) 
	{
	case "required": 
	{
		if (isSelect(campo))
			return isNotSelected(campo, label);
		else if (isCheckBox(campo))
		{
			return isNotCheckedCampo(campo, label);
		}else
			return isEmpty(campo, label);
	}
	case "number": return isNotNumber(campo, label);
	case "notZero": return isNumeroIgualZero(campo,label);
	case "date": return isNotDate(campo,label);
	case "cpf": return isNotCPF(campo, label);
	case "email": return isNotEmail(campo,label);
	case "integer": return isNumeroInteiro(campo,label);
	default: return false;
	}
}

function isNotCheckedCampo(campo,label)
{
	var elements = document.form.elements;

	var checked = 0;

	for ( var i in elements)
	{
		if (isCheckBox(elements[i]))
			if (elements[i].name == campo.name)
				if (elements[i].checked)
					checked++;
	}

	if (checked == 0)
	{
		if (label == null)
			label = campo.title;

		alert("Atenção: Deve ser marcado pelo menos um "+ label);
		campo.focus();
		return true;
	}

	return false;

}

function isCheckBox(campo)
{
	if (campo.type == "checkbox")
		return true;

	return false;
}

function isValidateComParametro(validate)
{
	if (validate.indexOf("(",0) != -1)
		return true;

	return false;
}

function trataValidateFunction(validate,campo)
{
	switch (getNameFunctionValidateComParametro(validate)) 
	{
	case "max":
	{
		return isNotLimitMaxLength(campo,getValorEntreParentese(validate));
	}
	case "min":
	{
		return isNotLimitMinLength(campo,getValorEntreParentese(validate));
	}
	case "equals":
	{
		var campoValidate = document.getElementById(getValorEntreParentese(validate));

		if (campoValidate.value != campo.value)
		{
			showError(campo,"Atençao: O campo "+ campo.title + " deve ser igual ao campo "+ campoValidate.title);
			return true;
		}
		return false;
	}

	default: return false;
	}
}

function getNameFunctionValidateComParametro(validate)
{
	return validate.substr(0,validate.indexOf("(",0)); 
}

function getValorEntreParentese(string)
{
	var posicaoParentese = string.indexOf("(",0);

	var parametro = string.substr(posicaoParentese,string.length);
	parametro = parametro.replace("(","");
	parametro = parametro.replace(")","");

	return parametro;
}

function showError(campo,mensagem)
{
	var element = getElementMessage();
	element.setAttribute("class","alert alert-error");
	element.innerHTML = mensagem;
	element.setAttribute("style","visibility:visible");
	campo.focus();
}

function hiddenMessage()
{
	var element = getElementMessage();
	element.setAttribute("style","visibility:hidden");
}

function getElementMessage()
{
	return document.getElementById('messages');
}

function isSelect(campo)
{
	if (campo.type == "select-one")
		return true;

	return false;
}

function isTypeValidate(type)
{
	switch (type) {
	case "text": return true;
	case "select-one": return true;
	case "textarea": return true;
	case "checkbox": return true;
	case "password": return true;

	default: return false;
	}

}

function Trim(str)
{
	return str.replace(/^\s+|\s+$/g,"");
}

function isEmpty(campo,label)
{
	if (Trim(campo.value) == '')
	{
		if (label == null)
			label = campo.title;

		showError(campo, "Atenção: O campo "+label+" é Obrigatório");

		campo.value = '';
		return true;
	}
	return false;
}

function isNotNumber(campo,label)
{
	if(isNaN(campo.value))
	{
		if (label == null)
			label = campo.title;

		showError(campo, "Atenção: O campo "+label+" deve conter apenas números");
		return true;
	}
	return false;
}


function isNotSelected(campo,label)
{
	if (campo.value == '0')
	{
		if (label == null)
			label = campo.title;

		showError(campo,"Atenção: O campo "+label+" deve ser selecionado");
		campo.focus();
		return true;
	}
	return false;
}


function isNotLimitMaxLength(campo,limit,label)
{
	if (campo.value.length > limit)
	{
		if (label == null)
			label = campo.title;

		alert("Atenção: O campo "+label+" deve conter no máximo "+limit+" caracteres");
		campo.focus();
		return true;
	}
	return false;
}

function isNotLimitMinLength(campo,limit,label)
{
	if (campo.value.length < limit)
	{
		if (label == null)
			label = campo.title;

		showError(campo, "Atenção: O campo "+label+" deve conter no mínimo "+limit+" caracteres");
		return true;
	}
	return false;
}



function isNumeroInteiro(campo,label)
{
	if((isNaN(campo.value)) || (campo.value.indexOf(".") != -1 ))
	{
		if (label == null)
			label = campo.title;

		alert("Atenção: O campo "+label+" deve conter apenas números inteiros.");
		campo.focus();
		return true;
	}
	return false;
}

function isNumeroIgualZero(campo,label)
{
	var numero = parseFloat(campo.value);

	if(numero == 0)
	{
		if (label == null)
			label = campo.title;

		alert("Atenção: O campo "+label+" não pode ser zero");
		campo.focus();
		return true;
	}
	return false;
}

function isNotEmail(campo,label)
{

	if ( campo.value.indexOf("@") < 1 || campo.value.indexOf(".",campo.value.indexOf("@")) < 5)
	{
		if (label == null)
			label = campo.title;


		showError(campo,'Atenção: O campo '+label+' é inválido');

		campo.focus();
		return true;
	}

	return false;
}

function isNotDate(str,label) 
{
	dia = (str.value.substring(0,2));
	mes = (str.value.substring(3,5));
	ano = (str.value.substring(6,10));

	cons = true;
	// verifica se foram digitados n�meros
//	if (isNaN(dia) || isNaN(mes) || isNaN(ano)){
//	alert("Preencha a data somente com n�meros.");
//	str.value = "";
//	str.focus();
//	return false;
//	}

	// verifica o dia valido para cada mes
	if ((dia < 01)||(dia < 01 || dia > 30) && (mes == 04 || mes == 06 || mes == 09 || mes == 11 ) || dia > 31) {
		cons = false;
	}

	// verifica se o mes e valido
	if (mes < 01 || mes > 12 ) {
		cons = false;
	}

	// verifica se e ano bissexto
	if (mes == 2 && ( dia < 01 || dia > 29 || ( dia > 28 && (parseInt(ano / 4) != ano / 4)))) {
		cons = false;
	}

	if (cons == false) 
	{
		if (label == null)
			label = str.title;

		alert("Atenção: O campo "+label+" é inválida");
		str.value = "";
		str.focus();
		return true;
	}
	return false;
}


function isNumeroNotNull(campo,label)
{
	if(isNaN(campo.value)==0 )
	{
		if (label == null)
			label = campo.title;

		alert("Atenção: O campo "+label+ " deve conter numero maior que zero");
		campo.focus();
		return true;
	}
	return false;
}

function isNotCPF(Objcpf, label)
{
	var cpf = Objcpf.value;
	exp = /\D/g
		cpf = cpf.toString().replace( exp, "" );
	var digitoDigitado = eval(cpf.charAt(9)+cpf.charAt(10));
	var soma1=0, soma2=0;
	var vlr =11;

	if(cpf.length<vlr)
	{
		var digitoGerado = null;
	}

	for(i=0;i<9;i++){
		soma1+=eval(cpf.charAt(i)*(vlr-1));
		soma2+=eval(cpf.charAt(i)*vlr);
		vlr--;
	}   
	soma1 = (((soma1*10)%11)==10 ? 0:((soma1*10)%11));
	soma2 = (((soma2+(2*soma1))*10)%11);

	if(cpf == "11111111111" || cpf == "22222222222" || cpf ==
		"33333333333" || cpf == "44444444444" || cpf == "55555555555" || cpf ==
			"66666666666" || cpf == "77777777777" || cpf == "88888888888" || cpf ==
				"99999999999" || cpf == "00000000000" )
	{
		var digitoGerado = null;
	}
	else
	{
		var digitoGerado = (soma1*10) + soma2;
	}

	if(digitoGerado != digitoDigitado)
	{
		if (label == null)
			label = Objcpf.title;

		alert("Atenção: O campo "+label+" é inválido");
		Objcpf.value = null;
		Objcpf.focus();
		return true;
	}
	return false;
} 