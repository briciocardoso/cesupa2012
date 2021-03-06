package br.com.saldopositivo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class Usuario  
{
	public Usuario() {
	}

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String nome;

	@Column
	private String email;

	@Column
	private String senha;
	
	@Transient
	private String confSenha;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getConfSenha(){
		return confSenha;
	}
	
	public void setConfSenha(String confSenha){
		this.confSenha = confSenha;
	}
	
}
