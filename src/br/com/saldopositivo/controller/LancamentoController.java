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
		result.include("listaCategoria",this.categoriaBusiness.listaCategoriaPorUsuario(this.usuarioSession.getUsuario()));
		this.result.include("idConta",conta.getId());
	}
	
	@Path("lancamento/formEditarLancamento/{lancamento.id}")
	public void formEditarLancamento(Lancamento lancamento)
	{
		Lancamento lancamentoAtual = this.lancamentoBusiness.getById(lancamento.getId());
		
		result.include("listaCategoria",this.categoriaBusiness.listaCategoriaPorUsuario(this.usuarioSession.getUsuario()));
		result.include("lancamento",lancamentoAtual);
	}
	
	public void criarLancamento(Lancamento lancamento)
	{
		try {
			this.lancamentoBusiness.save(lancamento);
			this.contaBusiness.updateSaldoConta(lancamento);
			this.result.include("success","Cadastro Realizada com Sucesso");
			
			Conta contaAtualizada = new Conta();
			contaAtualizada.setId(lancamento.getConta().getId());
			contaAtualizada.setUsuario(this.usuarioSession.getUsuario());
			
			this.result.redirectTo(LancamentoController.class).index(contaAtualizada);
		} catch (Exception e) {
			this.result.include("error","Falha no cadastro do Lancamento");
		}
	}
	
	public void editarLancamento(Lancamento lancamento)
	{
		try {
			Lancamento lancamentoAntigo = this.lancamentoBusiness.getById(lancamento.getId());
			this.contaBusiness.updateSaldoContaPorEdicaoLancamento(lancamento, lancamentoAntigo);
			this.lancamentoBusiness.update(lancamento);
			result.include("success","Atualização realizada com Sucesso");
			result.redirectTo(LancamentoController.class).index(lancamento.getConta());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Path("lancamento/excluirLancamento/{lancamento.id}")
	public void excluirLancamento(Lancamento lancamento)
	{
		Lancamento lancamentoAtual = this.lancamentoBusiness.getById(lancamento.getId());

		try {
			
			this.lancamentoBusiness.delete(lancamentoAtual);
			this.contaBusiness.updateSaldoContaPorRemoverLancamento(lancamentoAtual);
			this.result.include("success","Exclusão realizada com Sucesso");
			this.result.redirectTo(LancamentoController.class).index(lancamentoAtual.getConta());

		} catch (Exception e) {
			this.result.include("error","Falha na Exclusão do Lançamento");
			this.result.redirectTo(LancamentoController.class).index(lancamentoAtual.getConta());
		}
		
	}

}
