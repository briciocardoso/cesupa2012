package br.com.saldopositivo.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.saldopositivo.autenticator.UsuarioSession;
import br.com.saldopositivo.business.CategoriaBusiness;
import br.com.saldopositivo.model.Categoria;

@Resource
public class CategoriaController {

	private CategoriaBusiness categoriaBusiness;
	
	private UsuarioSession usuarioSession;
	
	private Result result;

	public CategoriaController(CategoriaBusiness categoriaBusiness,
								UsuarioSession usuarioSession,
								Result result) {

		this.categoriaBusiness = categoriaBusiness;
		this.usuarioSession = usuarioSession;
		this.result = result;
	}
	
	public void formCategoria(){
		result.include("listaCateriaPorUsuario",categoriaBusiness.listaCategoriaPorUsuario(usuarioSession.getUsuario()));
	}

	public void criarCategoria(Categoria categoria) {
		try {
			categoria.setUsuario(this.usuarioSession.getUsuario());
			this.categoriaBusiness.salvar(categoria);
			this.result.include("success","Categoria " + categoria.getDescricao() + " cadastrada com sucesso");
		} catch (Exception e) {
			this.result.include("error","Falha ao cadastrar " + categoria.getDescricao());
			e.printStackTrace();
		}
		this.result.redirectTo(this).formCategoria();
	}
	
	@Path("categoria/formEditaCategoria/{categoria.id}")
	public void formEditaCategoria(Categoria categoria){
		
			categoria.setUsuario(usuarioSession.getUsuario());
						
			Categoria categoriaDoUsuario = this.categoriaBusiness.listaCategoriaPorIdEUsuario(categoria);
			
			if(categoriaDoUsuario != null){
				result.include("categoria",categoriaDoUsuario);
			}
	}
	
	public void editar(Categoria categoria){
		categoria.setUsuario(usuarioSession.getUsuario());
		try {
			categoriaBusiness.editar(categoria);
			this.result.include("success","Categoria " + categoria.getDescricao() + " modificada com sucesso");
		} catch (Exception e) {
			this.result.include("error","Falha ao modificar " + categoria.getDescricao()+".");
			e.printStackTrace();
		}
		result.redirectTo(this).formCategoria();
	}
	
	@Path("categoria/deletar/{categoria.id}")
	public void deleta(Categoria categoria){
		try {
			categoria.setUsuario(usuarioSession.getUsuario());
			Categoria categorialocalizada = categoria;
			categoriaBusiness.deletar(categoria);
			result.include("success","Categoria "+ categorialocalizada.getDescricao()+" excluida");
			result.redirectTo(this).formCategoria();
		} catch (Exception e) {
			result.include("error","Falha ao excluir categoria " + categoria.getDescricao());
			e.printStackTrace();
		}
	}
	
}
