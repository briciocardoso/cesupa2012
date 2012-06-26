package br.com.saldopositivo.model;

import java.util.Date;


public class Transferencia {
	private Conta contaDebito;
	private Conta contaCredito;
	private double valor;
	private Date data;
	
	public Conta getContaDebito() {
		return contaDebito;
	}
	public void setContaDebito(Conta contaDebito) {
		this.contaDebito = contaDebito;
	}
	public Conta getContaCredito() {
		return contaCredito;
	}
	public void setContaCredito(Conta contaCredito) {
		this.contaCredito = contaCredito;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}				
	
	
	
}
