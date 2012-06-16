package br.com.saldopositivo.dao;

import java.util.List;

import javax.persistence.EntityManager;
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
		this.entityManager.persist(categoria);
	}

	public List<Categoria> listar(Usuario usuario) {
		Query query =  this.entityManager.createQuery("Select c From Categoria c Where c.usuario.id = :idUsuario",Categoria.class);
		query.setParameter("idUsuario", usuario.getId());
		return query.getResultList();
	}

	public void editar() {

	}

	public void excluir() {

	}
}
