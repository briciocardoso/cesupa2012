package br.com.saldopositivo.business;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.saldopositivo.dao.MoedaDao;
import br.com.saldopositivo.model.Moeda;

@Component
public class MoedaBusiness implements IMoedaBusiness
{
	private MoedaDao moedaDao;
	
	public MoedaBusiness(MoedaDao moedaDao)
	{
		this.moedaDao = moedaDao;
	}

	public List<Moeda> getAllMoeda() 
	{
		return this.moedaDao.selectAll();
	}
	
	public Moeda getById(Long id)
	{
		return this.moedaDao.selectById(id);
	}
	

}
