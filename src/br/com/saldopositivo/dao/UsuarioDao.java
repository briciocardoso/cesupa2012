package br.com.saldopositivo.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

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
	
	public void editar(Usuario usuario){
		
		try {
			this.getEntityManager().merge(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void tracaSenha(Usuario usuario){
		try {
			this.entityManager.merge(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Usuario buscaUsuarioPorEmail(String email){
		
		try {
			Query query = entityManager.createQuery("Select u From Usuario u Where u.email = :email");
			query.setParameter("email", email);
			return (Usuario)query.getSingleResult();
		} catch (NoResultException nre) {
			this.getEntityManager().getTransaction().rollback();
			nre.printStackTrace();
			throw new RuntimeException("Usuario não encontrado para esse email descrito");
		}catch(RuntimeException re){
			re.getMessage();
			re.printStackTrace();
		}
		return null;
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
