package br.com.saldopositivo.controller;

import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.saldopositivo.autenticator.Public;
import br.com.saldopositivo.autenticator.UsuarioSession;
import br.com.saldopositivo.business.UsuarioBusiness;
import br.com.saldopositivo.helper.EnvioDeEmail;
import br.com.saldopositivo.model.Usuario;

@Resource
public class UsuarioController {

	private UsuarioBusiness usuarioBusiness;
	private UsuarioSession usuarioSession;
	private Result result;
	private ContaController contaController;
	private EnvioDeEmail envioDeEmail;

	UsuarioController(UsuarioBusiness usuarioBusiness,
					  Result result,
					  UsuarioSession usuarioSession,
					  ContaController contaController,
					  EnvioDeEmail envioDeEmail) {
		this.usuarioBusiness = usuarioBusiness;
		this.result = result;
		this.usuarioSession = usuarioSession;
		this.contaController = contaController;
		this.envioDeEmail = envioDeEmail;
	}
	
	@Public
	public void formCriarAcesso() {

	}
	
	@Public
	public void formSenha(){
		
	}
	
	public void formEdita(){
		
		Usuario usuario = usuarioSession.getUsuario();
		result.include("usuario", usuario);
	}
	
	public void editar(Usuario usuario){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + usuario.getNome());
		this.usuarioBusiness.editar(usuario);
		this.usuarioSession.setUsuario(usuario);
		result.redirectTo(this).index();
	}
	
	@Public
	public void sendEmailSenha(String email){
		
		Usuario usuarioLocalizado = usuarioBusiness.buscaUsuarioPorEmail(email);
		
		usuarioBusiness.trocaSenha(usuarioLocalizado);
		
		this.envioDeEmail.eviaEmail(usuarioLocalizado.getEmail(),usuarioBusiness.getNovaSenha());
	}

	public void index() {
		result.include("listaContas", this.contaController.getAllContaUsuario());
	}
	
	@Public
	public void login() {

	}

	@Public
	public void realizarLogin(Usuario usuario) {

		Usuario usuarioAutenticado = this.usuarioBusiness.autenticarUsuario(usuario);

		if (usuarioAutenticado != null) {
			this.usuarioSession.setUsuario(usuarioAutenticado);
			this.result.redirectTo(UsuarioController.class).index();
		} else
			this.result.redirectTo(UsuarioController.class).login();
	}
	
	@Public
	public void criarAcesso(Usuario usuario) {
		this.usuarioBusiness.salvar(usuario);
		result.include("mensagem", "Bem vindo ao Saldo");
		result.redirectTo(UsuarioController.class).login();
	}

	public void sair() {
		this.usuarioSession.sair();
		this.result.redirectTo(UsuarioController.class).login();
	}

}
