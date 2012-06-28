package br.com.saldopositivo.autenticator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//  Essa é uma anotação, foi criada para realizar a funcionalidade de login e senha.

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Public {
	
}
