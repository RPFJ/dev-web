package com.clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clientes.models.Cliente;
import com.clientes.repositories.query.ClienteQuery;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>, ClienteQuery{
	
	//public Clientes findByCliente_nome(String nome);
	

}
