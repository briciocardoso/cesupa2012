package br.com.saldopositivo.business;

import java.util.List;

import br.com.saldopositivo.model.Conta;
import br.com.saldopositivo.model.Lancamento;
import br.com.saldopositivo.model.Usuario;

public interface IContaBusiness 
{
	
	public void save(Conta conta);
	
	public List<Conta> getAllContasPorUsuario(Usuario usuario);
	
	public void apagar(Conta conta);

	public void editar(Conta conta);

	public Conta get(Conta conta);
	
	
//	public void updateSaldoConta(Lancamento lancamento);
//	
//	public void updateSaldoContaPorRemoverLancamento(Lancamento lancamento);
//	
	public void updateSaldoContaPorEdicaoLancamento(Lancamento lancamentoAtual,Lancamento lancamentoAntigo);
	
//	public void realizarTransferencia(Conta contaDebitada,Conta contaCreditada,double valor,Date data);
	
	//public List<Conta> findAllByUsuario(Long idUsuario);
	
	//public Conta findById(Long id);


}
