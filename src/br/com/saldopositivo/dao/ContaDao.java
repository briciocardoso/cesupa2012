package br.com.saldopositivo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;
import br.com.saldopositivo.model.Conta;
import br.com.saldopositivo.model.Usuario;

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
	
	public void editar(Conta conta)
	{
		this.entityManager.merge(conta);
	}
	
	@SuppressWarnings("unchecked")
	public List<Conta> selectAllByUsuario(Usuario usuario)
	{
		Query query = this.entityManager.createQuery("SELECT c FROM Conta c WHERE c.usuario.id = :idUsuario", Conta.class);
		query.setParameter("idUsuario",usuario.getId());
		return query.getResultList();
	}
	
	public Conta selectById(Conta conta,Usuario usuario)
	{
		Query query = this.entityManager.createQuery("SELECT c FROM Conta c WHERE c.usuario.id = :idUsuario AND c.id = :idConta", Conta.class);
		query.setParameter("idUsuario",usuario.getId());
		query.setParameter("idConta",conta.getId());
		
		return (Conta) query.getSingleResult();
	}
	
	
	
	

}
