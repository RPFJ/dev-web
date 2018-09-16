package com.clientes.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.clientes.models.Cliente;
import com.clientes.repositories.filters.ClienteFIlter;

public interface ClientesService {
	
	public List<Cliente> buscarTodosClientes();
	public Cliente buscarCliente(Long id);
	public void insertCliente(Cliente cliente);
	public void updateCliente(Cliente cliente);
	public void removeCliente(Long id);
	public Page<Cliente> listarClientePaginacao(ClienteFIlter clienteFilter, Pageable pageable);

}
