package br.com.saldopositivo.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.saldopositivo.dao.MoedaDao;
import br.com.saldopositivo.model.Moeda;

@Resource
public class MoedaController 
{
	private MoedaDao moedaDao;
	private Result result;
	
	public MoedaController(MoedaDao moedaDao, Result result)
	{
		this.moedaDao = moedaDao;
		this.result = result;
	}
	
	public List<Moeda> listar()
	{
		//this.result.include("listaMoeda",this.moedaDao.selectAll());
		return this.moedaDao.selectAll();
	}

}
