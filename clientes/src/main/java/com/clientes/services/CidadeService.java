package com.clientes.services;

import java.util.List;

import com.clientes.models.Cidade;

public interface CidadeService {
	
	public List<Cidade> buscarTodosCidade();
	public Cidade buscarCidade(Long id);
	public void insertCidade(Cidade cidade);
	public void updateCidade(Cidade cidade);
	public void removeCidade(Long id);

}
