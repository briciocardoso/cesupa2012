package br.com.saldopositivo.autenticator;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.saldopositivo.controller.UsuarioController;

@Intercepts
public class LoginInterceptor implements Interceptor {
	
	private Result result;
	private UsuarioSession usuarioSession;
	
	public LoginInterceptor(Result result, UsuarioSession usuarioSession){
		this.result = result;
		this.usuarioSession = usuarioSession;
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		
		return !(method.getMethod().isAnnotationPresent(Public.class) ||
		method.getResource().getType().isAnnotationPresent(Public.class));
	}
	
	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance)
			throws InterceptionException {
		
			if(usuarioSession.isLogado()){
				stack.next(method, resourceInstance);
			}else{
				result.redirectTo(UsuarioController.class).login();
			}
	}

}
