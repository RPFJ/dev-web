package com.clientes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clientes.models.Cliente;
import com.clientes.repositories.ClienteRepository;
import com.clientes.services.ClientesService;

@Service
@Transactional
public class ClienteServiceImpl implements ClientesService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<Cliente> buscarTodosClientes() {
		return clienteRepository.findAll();
	}

	@Transactional(readOnly=true)
	@Override
	public Cliente buscarCliente(Long id) {
		return clienteRepository.findOne(id);
	}

	@Override
	public void insertCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	@Override
	public void updateCliente(Cliente cliente) {
		clienteRepository.saveAndFlush(cliente);
	}

	@Override
	public void removeCliente(Long id) {
		Cliente cliente = clienteRepository.findOne(id);
	    clienteRepository.delete(cliente);
	}

}
