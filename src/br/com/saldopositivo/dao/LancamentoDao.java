package br.com.saldopositivo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.vraptor.ioc.Component;
import br.com.saldopositivo.model.Lancamento;

@Component
public class LancamentoDao 
{
	private EntityManager entityManager;
	
	public LancamentoDao(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	
	public List<Lancamento> selectAllByConta(Lancamento lancamento)
	{
		TypedQuery<Lancamento> query = this.entityManager.createQuery("SELECT l FROM Lancamento l WHERE l.conta.id = :idConta ORDER BY l.data",Lancamento.class); 
		query.setParameter("idConta", lancamento.getConta().getId());

		return query.getResultList();
	}
	
	public Lancamento selectById(Long id)
	{
		TypedQuery<Lancamento> query = this.entityManager.createQuery("SELECT l FROM Lancamento l WHERE l.id = :id",Lancamento.class); 
		query.setParameter("id",id);
		
		return query.getSingleResult();
	}
	
	public void update(Lancamento lancamento)
	{
		this.entityManager.merge(lancamento);
	}

}
