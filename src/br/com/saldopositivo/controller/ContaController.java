package br.com.saldopositivo.controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.saldopositivo.autenticator.UsuarioSession;
import br.com.saldopositivo.business.ContaBusiness;
import br.com.saldopositivo.business.IContaBusiness;
import br.com.saldopositivo.business.IMoedaBusiness;
import br.com.saldopositivo.business.MoedaBusiness;
import br.com.saldopositivo.model.Conta;

@Resource
public class ContaController 
{

	private IContaBusiness contaBusiness;
	private IMoedaBusiness moedaBusiness;
	private Result result;
	private UsuarioSession usuarioSession;

	public ContaController(ContaBusiness contaBusiness,Result result,MoedaBusiness moedaBusiness, UsuarioSession usuarioSession)
	{
		this.contaBusiness = contaBusiness;
		this.result = result;
		this.moedaBusiness = moedaBusiness;
		this.usuarioSession = usuarioSession;
	}

	public List<Conta> getAllContaUsuario()
	{
		return this.contaBusiness.getAllContasPorUsuario(this.usuarioSession.getUsuario());
	}

	public void formConta()
	{
		this.result.include("listaDeMoeda",this.moedaBusiness.getAllMoeda());
	}

	public void criarConta(Conta conta)
	{
		try {
			conta.setUsuario(this.usuarioSession.getUsuario());
			this.contaBusiness.save(conta);
			this.result.include("success","Cadastro Realizada com Sucesso");
			
		} catch (Exception e) {
			this.result.include("error","Falha no cadastro da Conta");
		}
		
		this.result.redirectTo(UsuarioController.class).index();
	}

	public void listaMoeda()
	{
		this.result.include("listaDeMoeda",this.moedaBusiness.getAllMoeda());
	}

	@Path("conta/formEditaConta/{conta.id}")
	public void formEditaConta(Conta conta)
	{
		conta.setUsuario(this.usuarioSession.getUsuario());
		
		Conta contaDoUsuario = this.contaBusiness.get(conta);

		if (contaDoUsuario != null)
		{
			this.result.include("conta",contaDoUsuario);
			this.listaMoeda();
		}
	}
	
	@Path("conta/excluir/{conta.id}")
	public void excluir(Conta conta)
	{
		conta.setUsuario(this.usuarioSession.getUsuario());
		
		if (conta != null)
		{
			this.contaBusiness.apagar(conta);
			this.result.include("success","Exclusão da Conta Realizado com Sucesso");
			this.result.redirectTo(UsuarioController.class).index();
		}
	}

	public void editarConta(Conta conta)
	{
		conta.setUsuario(this.usuarioSession.getUsuario());
		
		this.contaBusiness.editar(conta);
		
		this.result.include("success","Conta Atualizada com Sucesso");
		this.result.redirectTo(UsuarioController.class).index();
	}

	public List<Conta> listar()
	{
		return null;
	}



}
