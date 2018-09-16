package com.clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clientes.models.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
	//public Clientes findByCliente_nome(String nome);
	

}
