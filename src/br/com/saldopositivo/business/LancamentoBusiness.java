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
	private IContaBusiness contaBusiness;
	
	public LancamentoBusiness(LancamentoDao lancamentoDao,ContaBusiness contaBusiness)
	{
		this.lancamentoDao = lancamentoDao;
		this.contaBusiness = contaBusiness;
	}
	
	
	public List<Lancamento> getAllByConta(Conta conta) 
	{
		Lancamento lancamento = new Lancamento();
		lancamento.setConta(conta);
		
		return this.lancamentoDao.selectAllByConta(lancamento);
	}

	public void criarLancamentoDebito(Conta conta,double valor,Date data,String descricao)
	{
		Lancamento lancamento = new Lancamento();
		
		Categoria categoria = new Categoria();
		categoria.setId((long) 3);

		lancamento.setCategoria(categoria);
		lancamento.setConta(conta);
		lancamento.setData(data);
		lancamento.setValor(valor);
		lancamento.setDescricao(descricao);
		lancamento.setTransacaoDebito();
		
		this.save(lancamento);
	}

	public void criarLancamentoCredito(Conta conta,double valor,Date data,String descricao)
	{
		Lancamento lancamento = new Lancamento();
		
		Categoria categoria = new Categoria();
		categoria.setId((long) 3);
		
		lancamento.setConta(conta);
		lancamento.setCategoria(categoria);
		lancamento.setData(data);
		lancamento.setValor(valor);
		lancamento.setDescricao(descricao);
		lancamento.setTransacaoCredito();
		
		this.save(lancamento);
	}

	public void save(Lancamento lancamento) 
	{
		//contaEJB.updateSaldoConta(lancamento);
		//em.persist(lancamento);
	}

	public void update(Lancamento lancamentoAtual)
	{
		Lancamento lancamentoAntigo = this.getById(lancamentoAtual.getId());

		this.contaBusiness.updateSaldoContaPorEdicaoLancamento(lancamentoAtual, lancamentoAntigo);

		this.lancamentoDao.update(lancamentoAtual);
	}

	public void delete(Long id)
	{
	//	Lancamento lancamento = em.find(Lancamento.class, id);
	//  em.remove(lancamento);
    //	contaEJB.updateSaldoContaPorRemoverLancamento(lancamento);
	}
	
	public Lancamento getById(Long id)
	{
		return this.lancamentoDao.selectById(id);
	}



}
