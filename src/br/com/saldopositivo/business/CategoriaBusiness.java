package br.com.saldopositivo.business;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.saldopositivo.dao.CategoriaDao;
import br.com.saldopositivo.model.Categoria;
import br.com.saldopositivo.model.Usuario;

@Component
public class CategoriaBusiness implements ICategoriaBusiness {

	private CategoriaDao categoriaDao;

	public CategoriaBusiness(CategoriaDao dao) {
		this.categoriaDao = dao;
	}

	@Override
	public void salvar(Categoria categoria) {
		categoriaDao.adicionar(categoria);
	}

	@Override
	public List<Categoria> listaCategoriaPorUsuario(Usuario usuario) {
		return this.categoriaDao.listarCategoriaPorUsuario(usuario);
	}

	@Override
	public void editar(Categoria categoria) {
		categoriaDao.editar(categoria);
	}

	@Override
	public void deletar(Categoria categoria) {
		this.categoriaDao.excluir(categoria);
	}

	@Override
	public Categoria listaCategoriaPorIdEUsuario(Categoria categoria) {
		
		return this.categoriaDao.listaCategoriaPorIdEUsuario(categoria);
		
	}
	
	
	
	

}
