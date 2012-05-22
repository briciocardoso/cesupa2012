package br.com.saldopositivo.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.saldopositivo.dao.ContaDao;
import br.com.saldopositivo.model.Conta;

@Resource
public class ContaController 
{
	
	private ContaDao contaDao;
	private MoedaController moedaController;
	private Result result;
	
	public ContaController(ContaDao contaDao,Result result,MoedaController moedaController)
	{
		this.contaDao = contaDao;
		this.result = result;
		this.moedaController = moedaController;
	}
	
	
	public void formConta(){
		
		this.result.include("listaDeMoeda",this.moedaController.listar());
		
	}
	
	public void criarConta(Conta conta)
	{
		this.contaDao.salvar(conta);
		this.result.redirectTo(ContaController.class).listar();
	}
	
	public void listaMoeda(){
		
		this.result.include("listaDeMoeda",this.moedaController.listar());
		
	}
	
	public List<Conta> listar()
	{
		return null;
	}
	
	

}
