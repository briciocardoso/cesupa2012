package br.com.saldopositivo.autenticator;

import java.io.Serializable;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.saldopositivo.model.Usuario;

@Component
@SessionScoped
public class UsuarioSession implements Serializable
{

	private transient Usuario usuario;

	public boolean isLogado()
	{
		return (this.getUsuario() != null);
	}
	
	public void sair()
	{
		this.setUsuario(null);
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuarioSession) {
		this.usuario = usuarioSession;
	}
	
	
}
