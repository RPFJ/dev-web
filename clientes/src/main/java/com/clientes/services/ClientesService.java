package com.clientes.services;

import java.util.List;

import com.clientes.models.Cliente;

public interface ClientesService {
	
	public List<Cliente> buscarTodosClientes();
	public Cliente buscarCliente(Long id);
	public void insertCliente(Cliente cliente);
	public void updateCliente(Cliente cliente);
	public void removeCliente(Long id);

}
