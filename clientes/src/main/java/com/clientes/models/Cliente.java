package com.clientes.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_CLIENTE")
public class Cliente implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cliente_id")
	private long cliente_id;
	
	@Column(length=45,nullable=false)
	private String cliente_nome;
	
	@Column(nullable=false)
	private long endereco_id;
	
	@Column(nullable=false)
	private long tipo_pessoa_id;
	
	@Column(length=45,nullable=false)
	private String cliente_cpf;
	
	@Column(length=45,nullable=false)
	private String cliente_cnpj;
	
	@Column(length=45,nullable=false)
	private String cliente_inscricao_estadual;
	
	@Column(length=45,nullable=false)
	private String cliente_rg;
	
	@Column(nullable=false)
	private long contato_id;
	
	

	public Cliente() {
	}


	public Cliente(long cliente_id, String cliente_nome, long endereco_id, long tipo_pessoa_id, String cliente_cpf,
			String cliente_cnpj, String cliente_inscricao_estadual, String cliente_rg, long contato_id) {
		super();
		this.cliente_id = cliente_id;
		this.cliente_nome = cliente_nome;
		this.endereco_id = endereco_id;
		this.tipo_pessoa_id = tipo_pessoa_id;
		this.cliente_cpf = cliente_cpf;
		this.cliente_cnpj = cliente_cnpj;
		this.cliente_inscricao_estadual = cliente_inscricao_estadual;
		this.cliente_rg = cliente_rg;
		this.contato_id = contato_id;
	}


	@Override
	public String toString() {
		return "Cliente [cliente_id=" + cliente_id + ", cliente_nome=" + cliente_nome + ", endereco_id=" + endereco_id
				+ ", tipo_pessoa_id=" + tipo_pessoa_id + ", cliente_cpf=" + cliente_cpf + ", cliente_cnpj="
				+ cliente_cnpj + ", cliente_inscricao_estadual=" + cliente_inscricao_estadual + ", cliente_rg="
				+ cliente_rg + ", contato_id=" + contato_id + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente_cnpj == null) ? 0 : cliente_cnpj.hashCode());
		result = prime * result + ((cliente_cpf == null) ? 0 : cliente_cpf.hashCode());
		result = prime * result + (int) (cliente_id ^ (cliente_id >>> 32));
		result = prime * result + ((cliente_inscricao_estadual == null) ? 0 : cliente_inscricao_estadual.hashCode());
		result = prime * result + ((cliente_nome == null) ? 0 : cliente_nome.hashCode());
		result = prime * result + ((cliente_rg == null) ? 0 : cliente_rg.hashCode());
		result = prime * result + (int) (contato_id ^ (contato_id >>> 32));
		result = prime * result + (int) (endereco_id ^ (endereco_id >>> 32));
		result = prime * result + (int) (tipo_pessoa_id ^ (tipo_pessoa_id >>> 32));
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
		Cliente other = (Cliente) obj;
		if (cliente_cnpj == null) {
			if (other.cliente_cnpj != null)
				return false;
		} else if (!cliente_cnpj.equals(other.cliente_cnpj))
			return false;
		if (cliente_cpf == null) {
			if (other.cliente_cpf != null)
				return false;
		} else if (!cliente_cpf.equals(other.cliente_cpf))
			return false;
		if (cliente_id != other.cliente_id)
			return false;
		if (cliente_inscricao_estadual == null) {
			if (other.cliente_inscricao_estadual != null)
				return false;
		} else if (!cliente_inscricao_estadual.equals(other.cliente_inscricao_estadual))
			return false;
		if (cliente_nome == null) {
			if (other.cliente_nome != null)
				return false;
		} else if (!cliente_nome.equals(other.cliente_nome))
			return false;
		if (cliente_rg == null) {
			if (other.cliente_rg != null)
				return false;
		} else if (!cliente_rg.equals(other.cliente_rg))
			return false;
		if (contato_id != other.contato_id)
			return false;
		if (endereco_id != other.endereco_id)
			return false;
		if (tipo_pessoa_id != other.tipo_pessoa_id)
			return false;
		return true;
	}


	public long getCliente_id() {
		return cliente_id;
	}


	public void setCliente_id(long cliente_id) {
		this.cliente_id = cliente_id;
	}


	public String getCliente_nome() {
		return cliente_nome;
	}


	public void setCliente_nome(String cliente_nome) {
		this.cliente_nome = cliente_nome;
	}


	public long getEndereco_id() {
		return endereco_id;
	}


	public void setEndereco_id(long endereco_id) {
		this.endereco_id = endereco_id;
	}


	public long getTipo_pessoa_id() {
		return tipo_pessoa_id;
	}


	public void setTipo_pessoa_id(long tipo_pessoa_id) {
		this.tipo_pessoa_id = tipo_pessoa_id;
	}


	public String getCliente_cpf() {
		return cliente_cpf;
	}


	public void setCliente_cpf(String cliente_cpf) {
		this.cliente_cpf = cliente_cpf;
	}


	public String getCliente_cnpj() {
		return cliente_cnpj;
	}


	public void setCliente_cnpj(String cliente_cnpj) {
		this.cliente_cnpj = cliente_cnpj;
	}


	public String getCliente_inscricao_estadual() {
		return cliente_inscricao_estadual;
	}


	public void setCliente_inscricao_estadual(String cliente_inscricao_estadual) {
		this.cliente_inscricao_estadual = cliente_inscricao_estadual;
	}


	public String getCliente_rg() {
		return cliente_rg;
	}


	public void setCliente_rg(String cliente_rg) {
		this.cliente_rg = cliente_rg;
	}


	public long getContato_id() {
		return contato_id;
	}


	public void setContato_id(long contato_id) {
		this.contato_id = contato_id;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = -2911221295340433179L;

}
