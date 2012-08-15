package br.com.saldopositivo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.vraptor.ioc.Component;
import br.com.saldopositivo.model.Conta;
import br.com.saldopositivo.model.Lancamento;
import br.com.saldopositivo.model.Usuario;

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
		TypedQuery<Lancamento> query = this.entityManager.createQuery("SELECT l FROM Lancamento l WHERE l.conta.id = :idConta ORDER BY l.data ASC",Lancamento.class); 
		query.setParameter("idConta", lancamento.getConta().getId());

		return query.getResultList();
	}
	
	public List<Lancamento> selectAllByContaMesAtual(Lancamento lancamento)
	{
		TypedQuery<Lancamento> query = this.entityManager.createQuery("SELECT l FROM Lancamento l WHERE l.conta.id = :idConta AND MONTH(l.data) = MONTH(NOW()) AND YEAR(l.data) = YEAR(NOW()) ORDER BY l.data",Lancamento.class); 
		query.setParameter("idConta", lancamento.getConta().getId());

		return query.getResultList();
	}
	
	public List<Lancamento> selectAllByContaAteHoje(Conta conta)
	{
		TypedQuery<Lancamento> query = this.entityManager.createQuery("SELECT l FROM Lancamento l WHERE l.conta.id = :idConta AND l.data <= NOW()",Lancamento.class); 
		query.setParameter("idConta", conta.getId());

		return query.getResultList();
	}
	
	public List<Lancamento> selectAllByContaProximoDias(Usuario usuario)
	{
		TypedQuery<Lancamento> query = this.entityManager.createQuery("SELECT l FROM Lancamento l WHERE l.conta.usuario.id = :idUsuario AND l.data > NOW() ORDER BY l.conta.nome,l.data",Lancamento.class); 
		query.setParameter("idUsuario", usuario.getId());
		query.setMaxResults(5);

		return query.getResultList();
	}
	
	public List<Lancamento> selectAllByContaMesesAnteriores(Conta conta)
	{
		TypedQuery<Lancamento> query = this.entityManager.createQuery("SELECT l FROM Lancamento l WHERE l.conta.id = :idConta AND l.data <= (LAST_DAY(SUBDATE(NOW(),INTERVAL 1 MONTH)))",Lancamento.class); 
		query.setParameter("idConta", conta.getId());
		query.setParameter("mes",1);

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
	
	public void save(Lancamento lancamento)
	{
		this.entityManager.persist(lancamento);
	}
	
	public void delete(Lancamento lancamento)
	{
		this.entityManager.remove(lancamento);
	}

}
