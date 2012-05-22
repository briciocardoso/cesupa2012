package br.com.saldopositivo.controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.saldopositivo.autenticator.UsuarioSession;
import br.com.saldopositivo.dao.UsuarioDao;
import br.com.saldopositivo.model.Usuario;

@Resource
public class UsuarioController {

	private UsuarioDao usuarioDao;
	private UsuarioSession usuarioSession;
	private Result result;

	UsuarioController(UsuarioDao usuarioDao, Result result,UsuarioSession usuarioSession)
	{
		this.usuarioDao = usuarioDao;
		this.result = result;
		this.usuarioSession = usuarioSession;
	}

	// Existe apenas mostrar o jsp
	public void formCriarAcesso() {

	}

	public void index() {

	}

	public void login() {

	}

	public void realizarLogin(Usuario usuario) {
		
		Usuario usuarioAutenticado = this.usuarioDao.selectUsuarioByEmailSenha(usuario);

		if (usuarioAutenticado != null)
		{
			this.usuarioSession.setUsuario(usuarioAutenticado);
			this.result.redirectTo(UsuarioController.class).index();
		}
		else
			this.result.redirectTo(UsuarioController.class).login();
	}

	public void criarAcesso(Usuario usuario) {
		this.usuarioDao.salvar(usuario);
		result.include("mensagem", "Bem vindo ao Saldo");
		result.redirectTo(UsuarioController.class).index();
	}

}
