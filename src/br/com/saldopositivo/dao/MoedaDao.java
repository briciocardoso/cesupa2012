package br.com.saldopositivo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.caelum.vraptor.ioc.Component;
import br.com.saldopositivo.model.Moeda;

@Component
public class MoedaDao 
{
	private EntityManager entityManager;
	
	public MoedaDao(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	
	
	public List<Moeda> selectAll()
	{
		Query query = this.entityManager.createQuery("SELECT m FROM Moeda m", Moeda.class);
		return query.getResultList();
	}
	
	public Moeda selectById(Long id)
	{
		return entityManager.find(Moeda.class,id);
	}

}
