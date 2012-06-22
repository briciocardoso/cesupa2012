package br.com.saldopositivo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Lancamento 
{
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String descricao;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name="idConta")
	private Conta conta;
	
	@ManyToOne
	@JoinColumn(name="idCategoria")
	private Categoria categoria;
	
	@Column
	private String transacao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getTransacao() {
		return transacao;
	}

	public void setTransacao(String transacao) {
		this.transacao = transacao;
	}
	
	public void setTransacaoDebito() {
		this.transacao = "D";
	}
	
	public void setTransacaoCredito() {
		this.transacao = "C";
	}
	
	public boolean isDebito()
	{
		if (this.transacao.equals("D"))
			return true;
		
		return false;
	}
	
	public boolean isCredito()
	{
		if (this.transacao.equals("C"))
			return true;
		
		return false;
	}
}
