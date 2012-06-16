package br.com.saldopositivo.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.saldopositivo.autenticator.UsuarioSession;
import br.com.saldopositivo.business.ContaBusiness;
import br.com.saldopositivo.business.IContaBusiness;
import br.com.saldopositivo.business.ILancamentoBusiness;
import br.com.saldopositivo.business.LancamentoBusiness;
import br.com.saldopositivo.model.Conta;

@Resource
public class LancamentoController 
{
	
	private ILancamentoBusiness lancamentoBusiness;
	private Result result;
	private UsuarioSession usuarioSession;
	private IContaBusiness contaBusiness;
	
	public LancamentoController(LancamentoBusiness lancamentoBusiness,Result result,UsuarioSession usuarioSession,ContaBusiness contaBusiness)
	{
		this.lancamentoBusiness = lancamentoBusiness;
		this.result = result;
		this.usuarioSession = usuarioSession;
		this.contaBusiness = contaBusiness;
	}
	
	@Path("lancamento/index/{conta.id}")
	public void index(Conta conta)
	{
		this.result.include("listaLancamento",this.lancamentoBusiness.getAllByConta(conta));
		conta.setUsuario(this.usuarioSession.getUsuario());
		this.result.include("conta",this.contaBusiness.get(conta));
	}
	
	@Path("lancamento/formLancamento/{conta.id}")
	public void formLancamento(Conta conta)
	{
		this.result.include("idConta",conta.getId());
	}

}
