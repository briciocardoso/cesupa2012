package br.com.saldopositivo.controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.saldopositivo.autenticator.UsuarioSession;
import br.com.saldopositivo.dao.ContaDao;
import br.com.saldopositivo.model.Conta;

@Resource
public class ContaController 
{

	private ContaDao contaDao;
	private MoedaController moedaController;
	private Result result;
	private UsuarioSession usuarioSession;

	public ContaController(ContaDao contaDao,Result result,MoedaController moedaController, UsuarioSession usuarioSession)
	{
		this.contaDao = contaDao;
		this.result = result;
		this.moedaController = moedaController;
		this.usuarioSession = usuarioSession;
	}

	public List<Conta> getAllContaUsuario()
	{
		return this.contaDao.selectAllByUsuario(this.usuarioSession.getUsuario());
	}


	public void formConta()
	{
		this.result.include("listaDeMoeda",this.moedaController.listar());
	}

	public void criarConta(Conta conta)
	{
		conta.setUsuario(this.usuarioSession.getUsuario());
		this.contaDao.salvar(conta);
		this.result.include("success","Cadastro Realizada com Sucesso");
		this.result.redirectTo(UsuarioController.class).index();
	}

	public void listaMoeda(){

		this.result.include("listaDeMoeda",this.moedaController.listar());

	}

	@Path("conta/formEditaConta/{conta.id}")
	public void formEditaConta(Conta conta)
	{
		Conta contaDoUsuario = this.contaDao.selectById(conta, this.usuarioSession.getUsuario());

		if (contaDoUsuario != null)
		{
			this.result.include("conta",contaDoUsuario);
			this.listaMoeda();
		}

	}

	public void editarConta(Conta conta)
	{
		conta.setUsuario(this.usuarioSession.getUsuario());
		this.contaDao.editar(conta);
		this.result.include("success","Conta Atualizada com Sucesso");
		this.result.redirectTo(UsuarioController.class).index();
	}

	public List<Conta> listar()
	{
		return null;
	}



}
