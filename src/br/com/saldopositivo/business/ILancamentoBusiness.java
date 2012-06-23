package br.com.saldopositivo.business;

import java.util.Date;
import java.util.List;

import br.com.saldopositivo.model.Conta;
import br.com.saldopositivo.model.Lancamento;

public interface ILancamentoBusiness 
{
	List<Lancamento> getAllByConta(Conta conta);
	
	void save(Lancamento lancamento);

	void update(Lancamento lancamento);
	
	void delete(Lancamento lancamento);
	
	void criarLancamentoDebito(Conta conta,double valor,Date data,String descricao);
	
	void criarLancamentoCredito(Conta conta,double valor,Date data,String descricao);
	
	Lancamento getById(Long id);
	
	boolean isDebito(Lancamento lancamento);
	
	boolean isCredito(Lancamento lancamento);	
	
}
