package br.com.saldopositivo.business;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.saldopositivo.dao.ContaDao;
import br.com.saldopositivo.model.Conta;
import br.com.saldopositivo.model.Usuario;

@Component
public class ContaBusiness implements IContaBusiness
{
	private ContaDao dao;

	public ContaBusiness(ContaDao dao)
	{
		this.dao = dao;
	}

	public void save(Conta conta) 
	{
		conta.setSaldo(conta.getSaldoInicial());
		this.dao.salvar(conta);
	}
	
	public List<Conta> getAllContasPorUsuario(Usuario usuario)
	{
		return this.dao.selectAllByUsuario(usuario);
	}

	public void editar(Conta conta) 
	{
		Conta contaAntiga = this.dao.selectById(conta);
		
		double saldo = 0;
		
		if (conta.getSaldoInicial() < contaAntiga.getSaldoInicial())
		{
			saldo = conta.getSaldoInicial() - contaAntiga.getSaldoInicial();
		}else if (conta.getSaldoInicial() > contaAntiga.getSaldoInicial())
		{
			saldo = conta.getSaldoInicial() - contaAntiga.getSaldoInicial();
		}
		
		saldo += contaAntiga.getSaldo();
		
		conta.setSaldo(saldo);

		this.dao.update(conta);
	}
//	
//	public void updateSaldoConta(Lancamento lancamento)
//	{
//		Conta conta = this.findById(lancamento.getConta().getId());
//		
//		double saldoAtual = 0;
//		
//		if (lancamento.isDebito())
//			saldoAtual = conta.getSaldo() - lancamento.getValor();
//		else if (lancamento.isCredito())
//			saldoAtual = conta.getSaldo() + lancamento.getValor();
//
//		conta.setSaldo(saldoAtual);
//
//		this.update(conta);
//	}
//	
//	public void updateSaldoContaPorRemoverLancamento(Lancamento lancamento)
//	{
//		Conta conta = this.findById(lancamento.getConta().getId());
//		
//		double saldoAtual = 0;
//		
//		if (lancamento.isDebito())
//			saldoAtual = conta.getSaldo() + lancamento.getValor();
//		else if (lancamento.isCredito())
//			saldoAtual = conta.getSaldo() - lancamento.getValor();
//		
//		conta.setSaldo(saldoAtual);
//
//		this.update(conta);	
//	}
//	
//	public void updateSaldoContaPorEdicaoLancamento(Lancamento lancamentoAtual,Lancamento lancamentoAntigo)
//	{
//		Conta conta = this.findById(lancamentoAtual.getConta().getId());
//		
//		double saldoAtual = conta.getSaldo();
//		double diferenca = 0;
//		
//		if (lancamentoAtual.isCredito())
//		{
//			if (lancamentoAntigo.isDebito())
//				diferenca = lancamentoAntigo.getValor() + lancamentoAtual.getValor();
//			else
//				diferenca = lancamentoAtual.getValor() - lancamentoAntigo.getValor();
//		}else if (lancamentoAtual.isDebito())
//		{
//			if (lancamentoAntigo.isCredito())
//				diferenca = - (lancamentoAntigo.getValor() + lancamentoAtual.getValor());
//			else
//				diferenca = lancamentoAntigo.getValor() - lancamentoAtual.getValor();
//		}
//		
//		conta.setSaldo(saldoAtual+diferenca);
//
//		this.update(conta);	
//	}
	
//	public void realizarTransferencia(Conta contaDebitada,Conta contaCreditada,double valor,Date data)
//	{
//		contaDebitada = findById(contaDebitada.getId());
//		contaCreditada = findById(contaCreditada.getId());
//		
//		String descricaoLancamentoDebito = "TransferÍncia para Conta: " + contaCreditada.getNome();
//		String descricaoLancamentoCredito = "TransferÍncia da Conta: " + contaDebitada.getNome();
//		
//		lancamentoEJB.criarLancamentoDebito(contaDebitada, valor, data,descricaoLancamentoDebito);
//		lancamentoEJB.criarLancamentoCredito(contaCreditada, valor, data,descricaoLancamentoCredito);
//	}
	

//	public List<Conta> findAllByUsuario(Long idUsuario) 
//	{
//		TypedQuery<Conta> query = em.createQuery("SELECT c FROM Conta c WHERE c.usuario.id = :usuario", Conta.class);
//		query.setParameter("usuario", idUsuario);
//		
//		return query.getResultList();
//	}
	
	
	
//	public Conta findById(Long id)
//	{
//		TypedQuery<Conta> query = em.createQuery("SELECT c FROM Conta c WHERE c.id = :idConta", Conta.class);
//		query.setParameter("idConta", id);
//		
//		return query.getSingleResult();
//	}
	
	public void apagar(Conta conta)
	{
		Conta contaRemovida = this.dao.selectById(conta);
		this.dao.delete(contaRemovida);
	}

	public Conta get(Conta conta) 
	{
		return this.dao.selectById(conta);
	}
	
	
	
}
