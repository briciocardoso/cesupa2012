function AJAX(Url,Div,Met)
{
	var req = null; 
	var setDiv = Div;
	
	document.getElementById(setDiv).innerHTML = "Carregando...";

	if(window.XMLHttpRequest)
	{
		req = new XMLHttpRequest();
		if (req.overrideMimeType) 
		{
			req.overrideMimeType('text/xml');
		}
	} 
	else if (window.ActiveXObject) 
	{
		try {
			req = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e)
		{
			try {
				req = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {}
		}
	}


	req.onreadystatechange = function(){

		document.getElementById(setDiv).innerHTML = "Carregando...";

		if(req.readyState == 4){//Request foi aceito
			if(req.status == 200){//encontrou dados
				document.getElementById(setDiv).innerHTML = req.responseText;
			}else{ //Não encotra os dados
				document.getElementById(setDiv).innerHTML = "Error: returned status code " + req.status + " " + req.statusText;
			}	
		} 
	}; 


	req.open("GET", Url, true); 
	req.send(null); 

} 
