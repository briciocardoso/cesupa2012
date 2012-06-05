package br.com.saldopositivo.business;

import java.util.List;

import br.com.saldopositivo.model.Moeda;

public interface IMoedaBusiness 
{
	public List<Moeda> getAllMoeda();
	
	public Moeda getById(Long id);

}
