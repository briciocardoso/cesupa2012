package br.com.saldopositivo.business;

import java.util.List;

import br.com.saldopositivo.model.Categoria;
import br.com.saldopositivo.model.Usuario;


public interface ICategoriaBusiness {
	
	public void salvar(Categoria categoria);
	
	public List<Categoria> listaCategoriaPorUsuario(Usuario usuario);
	
	public void editar(Categoria categoria);
	
	public void deletar(Categoria categoria);
	
	public Categoria listaCategoriaPorIdEUsuario(Categoria categoria);
}
