package br.com.saldopositivo.dao;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;
import br.com.saldopositivo.model.Conta;

@Component
public class ContaDao 
{
	private EntityManager entityManager;
	
	public ContaDao(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	
	public void salvar(Conta conta)
	{
		this.entityManager.persist(conta);
	}
	
	
	
	

}
