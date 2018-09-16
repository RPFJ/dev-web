package com.clientes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clientes.models.Cidade;
import com.clientes.repositories.CidadeRepository;
import com.clientes.services.CidadeService;

@Service
@Transactional
public class CidadeServiceImpl implements CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Cidade> buscarTodosCidade() {
		return cidadeRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Cidade buscarCidade(Long id) {
		return cidadeRepository.findOne(id);
	}

	@Override
	public void insertCidade(Cidade cidade) {
		cidadeRepository.save(cidade);
	}

	@Override
	public void updateCidade(Cidade cidade) {
		cidadeRepository.saveAndFlush(cidade);
	}

	@Override
	public void removeCidade(Long id) {
		Cidade cidade = cidadeRepository.findOne(id);
		cidadeRepository.delete(cidade);
	}

}
