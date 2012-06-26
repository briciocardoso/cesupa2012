package br.com.saldopositivo.business;

import br.com.caelum.vraptor.ioc.Component;
import br.com.saldopositivo.dao.UsuarioDao;
import br.com.saldopositivo.model.Usuario;

@Component
public class UsuarioBusiness implements IUsuarioBusiness {
	
	private UsuarioDao usuarioDao;
	
	public UsuarioBusiness(UsuarioDao usuarioDao){
		this.usuarioDao = usuarioDao;
	}

	@Override
	public void salvar(Usuario usuario) {
		this.usuarioDao.salvar(usuario);
	}

	@Override
	public void editar(Usuario usuario) {
		this.usuarioDao.editar(usuario);		
	}

	@Override
	public Usuario autenticarUsuario(Usuario usuario) {		
		return this.usuarioDao.selectUsuarioByEmailSenha(usuario);
	}
	
}
