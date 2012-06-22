package br.com.saldopositivo.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.saldopositivo.autenticator.UsuarioSession;
import br.com.saldopositivo.business.CategoriaBusiness;
import br.com.saldopositivo.business.ContaBusiness;
import br.com.saldopositivo.business.ICategoriaBusiness;
import br.com.saldopositivo.business.IContaBusiness;
import br.com.saldopositivo.business.ILancamentoBusiness;
import br.com.saldopositivo.business.LancamentoBusiness;
import br.com.saldopositivo.model.Conta;
import br.com.saldopositivo.model.Lancamento;

@Resource
public class LancamentoController 
{
	
	private ILancamentoBusiness lancamentoBusiness;
	private Result result;
	private UsuarioSession usuarioSession;
	private IContaBusiness contaBusiness;
	private ICategoriaBusiness categoriaBusiness;
	
	public LancamentoController(LancamentoBusiness lancamentoBusiness,Result result,UsuarioSession usuarioSession,ContaBusiness contaBusiness,CategoriaBusiness categoriaBusiness)
	{
		this.lancamentoBusiness = lancamentoBusiness;
		this.result = result;
		this.usuarioSession = usuarioSession;
		this.contaBusiness = contaBusiness;
		this.categoriaBusiness = categoriaBusiness;
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
	
	@Path("lancamento/formEditarLancamento/{id}")
	public void formEditarLancamento(Long id)
	{
		Lancamento lancamento = this.lancamentoBusiness.getById(id);
		
		result.include("listaCategoria",this.categoriaBusiness.listaCategoriaPorUsuario(this.usuarioSession.getUsuario()));
		result.include("lancamento",lancamento);
	}
	
	public void editarLancamento(Lancamento lancamento)
	{
		this.lancamentoBusiness.update(lancamento);
		
		result.redirectTo(LancamentoController.class).index(lancamento.getConta());
	}

}
