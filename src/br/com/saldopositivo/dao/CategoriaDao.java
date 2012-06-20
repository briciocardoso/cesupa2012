package br.com.saldopositivo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;
import br.com.saldopositivo.model.Categoria;
import br.com.saldopositivo.model.Usuario;

@Component
public class CategoriaDao {

	private EntityManager entityManager;

	public CategoriaDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void adicionar(Categoria categoria) {

		try {
			this.entityManager.persist(categoria);
		} catch (Exception e) {
			this.entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public List<Categoria> listarCategoriaPorUsuario(Usuario usuario) {
		try {
			Query query = this.entityManager.createQuery("Select c From Categoria c Where c.usuario.id = :idUsuario",Categoria.class);
			query.setParameter("idUsuario", usuario.getId());
			return query.getResultList();
		} catch (NoResultException nre) {
			this.entityManager.getTransaction().rollback();
			throw new RuntimeException("Não foram encontradas categorias para o usuário");
		} catch (Exception re) {
			re.getMessage();
			re.printStackTrace();
		}
		return null;
	}
	
	public Categoria listaCategoriaPorIdEUsuario(Categoria categoria){
		try {
			Query query = this.entityManager.createQuery("Select c From Categoria c Where c.usuario.id = :idUsuario And c.id = :idCategoria ",Categoria.class);
			query.setParameter("idCategoria", categoria.getId());
			query.setParameter("idUsuario", categoria.getUsuario().getId());
			return (Categoria)query.getSingleResult();
		} catch (NoResultException nre) {
			entityManager.getTransaction().rollback();
			throw new RuntimeException("Não foram encontradas categorias por usuario");
		}catch(Exception e){
			e.getMessage();
			e.printStackTrace();
		}
		return null;
	}

	public void editar(Categoria categoria) {
		try {
			this.entityManager.merge(categoria);
		} catch (Exception e) {
			this.entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void excluir(Categoria categoria) {
		try {
			this.entityManager.remove(this.entityManager.merge(categoria));
		} catch (Exception e) {
			this.entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	
}
