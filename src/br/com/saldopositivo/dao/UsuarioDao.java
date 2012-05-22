package br.com.saldopositivo.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.caelum.vraptor.ioc.Component;
import br.com.saldopositivo.model.Usuario;

@Component
public class UsuarioDao {
	private EntityManager entityManager;

	public UsuarioDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void salvar(Usuario usuario) {
		this.getEntityManager().persist(usuario);
	}

	public Usuario selectUsuarioByEmailSenha(Usuario usuario) {
		try {

			Query query = this.entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha");
			query.setParameter("email", usuario.getEmail());
			query.setParameter("senha", usuario.getSenha());
			return (Usuario) query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

}
