package br.com.saldopositivo.business;

import java.util.Date;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.saldopositivo.dao.LancamentoDao;
import br.com.saldopositivo.model.Categoria;
import br.com.saldopositivo.model.Conta;
import br.com.saldopositivo.model.Lancamento;

@Component
public class LancamentoBusiness implements ILancamentoBusiness 
{
	private LancamentoDao lancamentoDao;

	public LancamentoBusiness(LancamentoDao lancamentoDao)
	{
		this.lancamentoDao = lancamentoDao;
	}

	public List<Lancamento> getAllByConta(Conta conta) 
	{
		Lancamento lancamento = new Lancamento();
		lancamento.setConta(conta);

		return this.lancamentoDao.selectAllByConta(lancamento);
	}

	public void criarLancamento(Lancamento lancamento)
	{
		this.save(lancamento);
	}

	public Lancamento factoryLancamentoTransferenciaCredito(Conta conta,double valor,Date data,String descricao)
	{
		Lancamento lancamento = this.getLancamentoTransferencia(conta, valor, data, descricao);
		lancamento.setTransacao(Lancamento.CREDITO);
		
		return lancamento;
	}
	
	private Lancamento getLancamentoTransferencia(Conta conta,double valor,Date data,String descricao)
	{
		Lancamento lancamento = new Lancamento();

		Categoria categoria = new Categoria();
		categoria.setId(Categoria.TRANSFERENCIA);

		lancamento.setConta(conta);
		lancamento.setCategoria(categoria);
		lancamento.setData(data);
		lancamento.setValor(valor);
		lancamento.setDescricao(descricao);
		
		return lancamento;
		
	}
	
	public Lancamento factoryLancamentoTransferenciaDebito(Conta conta,double valor,Date data,String descricao)
	{
		Lancamento lancamento = this.getLancamentoTransferencia(conta, valor, data, descricao);
		lancamento.setTransacao(Lancamento.DEBITO);
		
		return lancamento;
	}
	
	

	public void save(Lancamento lancamento) 
	{
		this.lancamentoDao.save(lancamento);
	}

	public void update(Lancamento lancamentoAtual)
	{
		Lancamento lancamentoAntigo = this.getById(lancamentoAtual.getId());

		//this.contaBusiness.updateSaldoContaPorEdicaoLancamento(lancamentoAtual, lancamentoAntigo);

		this.lancamentoDao.update(lancamentoAtual);
	}

	public void delete(Lancamento lancamento)
	{
		this.lancamentoDao.delete(lancamento);
	}

	public Lancamento getById(Long id)
	{
		return this.lancamentoDao.selectById(id);
	}


	public boolean isDebito(Lancamento lancamento)
	{
		return lancamento.getTransacao().equals(Lancamento.DEBITO);
	}

	public boolean isCredito(Lancamento lancamento)
	{
		return lancamento.getTransacao().equals(Lancamento.CREDITO);
	}



}
