package com.clientes.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.clientes.models.Cliente;
import com.clientes.repositories.filters.ClienteFIlter;
import com.clientes.repositories.query.ClienteQuery;

public class ClientesRepositoryImpl implements ClienteQuery {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Page<Cliente> listarClientePaginacao(ClienteFIlter clienteFilter, Pageable pageable) {
		
		List<Cliente> listaClientes = new ArrayList<>();
		List<Predicate> listaPredicates = new ArrayList<>();
		TypedQuery<Cliente> query = null;
		
		int registrosPorPaginas = pageable.getPageSize();
		int paginaAtual = pageable.getPageNumber();
		int primeiroRegistro = paginaAtual * registrosPorPaginas; 
		
		
		CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);
		Root<Cliente> rootFromCliente = criteriaQuery.from(Cliente.class);
		
		listaPredicates = FilterPredicate(clienteFilter, criteriaBuilder, rootFromCliente);
		
		if(listaPredicates.size() != -1) {
			criteriaQuery.where(criteriaBuilder.and(listaPredicates.toArray(new Predicate[listaPredicates.size()])));
			query = this.getEntityManager().createQuery(criteriaQuery);
		} else {
			query = this.getEntityManager().createQuery(criteriaQuery);
		}
		
		query.setFirstResult(primeiroRegistro);
		query.setMaxResults(registrosPorPaginas);
		listaClientes = query.getResultList(); 

		
		return new PageImpl<>(listaClientes, pageable, totalRegistros(listaPredicates));
	}
	private Long totalRegistros(List<Predicate> listaPredicates) {
		
		TypedQuery<Long> query = null;
		
		CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Cliente> rootFromCliente = criteriaQuery.from(Cliente.class);
		criteriaQuery.select(criteriaBuilder.count(rootFromCliente));		
		
		if(listaPredicates.size() != -1) {
			criteriaQuery.where(criteriaBuilder.and(listaPredicates.toArray(new Predicate[listaPredicates.size()])));
			query = this.getEntityManager().createQuery(criteriaQuery);
		} else {
			query = this.getEntityManager().createQuery(criteriaQuery);
		}
		
		Long result = query.getSingleResult();
		
		return result;
	}
	private List<Predicate> FilterPredicate(ClienteFIlter clienteFilter, CriteriaBuilder criteriaBuilder,
			Root<Cliente> rootFromCliente) {
		
		List<Predicate> listaPredicates = new ArrayList<>();
		
		if(!StringUtils.isEmpty(clienteFilter.getNome())) {
			listaPredicates.add(criteriaBuilder.like(criteriaBuilder.lower(
					rootFromCliente.get("cliente_nome")), clienteFilter.getNome()));
		} else if(!StringUtils.isEmpty(clienteFilter.getNome())) {
			listaPredicates.add(criteriaBuilder.like(criteriaBuilder.lower(
					rootFromCliente.get("cliente_cpf")), clienteFilter.getCpf()));
		}else if(!StringUtils.isEmpty(clienteFilter.getNome())) {
			listaPredicates.add(criteriaBuilder.like(criteriaBuilder.lower(
					rootFromCliente.get("cliente_cnpj")), clienteFilter.getCnpj()));
		}
		
		return listaPredicates;
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	

}
