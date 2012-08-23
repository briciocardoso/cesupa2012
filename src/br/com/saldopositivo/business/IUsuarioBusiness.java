package br.com.saldopositivo.business;

import br.com.saldopositivo.model.Usuario;

public interface IUsuarioBusiness {
	
	public void salvar(Usuario usuario);
	
	public void editar(Usuario usuario);
	
	public Usuario autenticarUsuario(Usuario usuario);
	
	public Usuario buscaUsuarioPorEmail(String email);
	
	public boolean isUsuarioExiste(Usuario usuario);
	
}
