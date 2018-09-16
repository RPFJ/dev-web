package com.clientes.repositories.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.clientes.models.Cliente;
import com.clientes.repositories.filters.ClienteFIlter;

public interface ClienteQuery {
	
	public Page<Cliente> listarClientePaginacao(ClienteFIlter clienteFilter, Pageable pageable);
	

}
