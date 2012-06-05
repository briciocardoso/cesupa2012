package br.com.saldopositivo.dao;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;
import br.com.saldopositivo.model.Categoria;

@Component
public class CategoriaDao {

	private EntityManager entityManager;

	public CategoriaDao(EntityManager entityManager) {

		this.entityManager = entityManager;

	}
	
	public void adicionar(Categoria categoria){
		
		try {

			this.entityManager.persist(categoria);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	public void listar() {

	}

	public void editar() {

	}

	public void excluir() {

	}
}
