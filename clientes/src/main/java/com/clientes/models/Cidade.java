package com.clientes.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="TAB_CIDADE")
public class Cidade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -539439119624140308L;



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cidade_id")
	private long cidade_id;
	
	

	@Column(length=45,nullable=false)
	private String cidade_nome;

	@Column(length=4, nullable=false)
	private String cidade_ddd;
	
	@Column(nullable=false)
	private long estado_id;
	
	@Override
	public String toString() {
		return "Cidade [cidade_id=" + cidade_id + ", cidade_nome=" + cidade_nome + ", cidade_ddd=" + cidade_ddd
				+ ", estado_id=" + estado_id + "]";
	}
	

	public Cidade() {
	}


	public Cidade(long cidade_id, String cidade_nome, String cidade_ddd, long estado_id) {
		super();
		this.cidade_id = cidade_id;
		this.cidade_nome = cidade_nome;
		this.cidade_ddd = cidade_ddd;
		this.estado_id = estado_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cidade_id ^ (cidade_id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (cidade_id != other.cidade_id)
			return false;
		return true;
	}

	public long getCidade_id() {
		return cidade_id;
	}

	public void setCidade_id(long cidade_id) {
		this.cidade_id = cidade_id;
	}

	public String getCidade_nome() {
		return cidade_nome;
	}

	public void setCidade_nome(String cidade_nome) {
		this.cidade_nome = cidade_nome;
	}

	public String getCidade_ddd() {
		return cidade_ddd;
	}

	public void setCidade_ddd(String estado_ddd) {
		this.cidade_ddd = estado_ddd;
	}

	public long getEstado_id() {
		return estado_id;
	}

	public void setEstado_id(long estado_id) {
		this.estado_id = estado_id;
	}
	
}
