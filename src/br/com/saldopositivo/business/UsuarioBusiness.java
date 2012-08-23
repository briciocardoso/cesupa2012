package br.com.saldopositivo.business;

import java.util.Random;

import br.com.caelum.vraptor.ioc.Component;
import br.com.saldopositivo.dao.UsuarioDao;
import br.com.saldopositivo.model.Usuario;

@Component
public class UsuarioBusiness implements IUsuarioBusiness {

	private UsuarioDao usuarioDao;

	private String novaSenha;

	public UsuarioBusiness(UsuarioDao usuarioDao) {
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

	// Não tive que por na Interface(Lembrar o Vtr da discur em sala)
	public String gerarNovaSenhaMd5() {
		Random ran = new Random();
		String[] letras = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
				"m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
				"y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
				"W", "X", "Y", "Z" };
		String senha = "";
		// Numero de caractes que a senha vai conter
		int num = 8;
		for (int i = 0; i < num; i++) {
			int a = ran.nextInt(letras.length);
			senha += letras[a];
		}
		return senha;
	}

	public void trocaSenha(Usuario usuario) {
		usuario.setSenha(gerarNovaSenhaMd5());
		usuarioDao.tracaSenha(usuario);
		setNovaSenha(usuario.getSenha());
	}

	@Override
	public Usuario buscaUsuarioPorEmail(String email) {
		return usuarioDao.buscaUsuarioPorEmail(email);
	}

	public boolean isUsuarioExiste(Usuario usuario) {
		
		Usuario usuarioLocalizado = this.buscaUsuarioPorEmail(usuario.getEmail());
		
		if(usuarioLocalizado != null)
			return true;

		return false;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

}
