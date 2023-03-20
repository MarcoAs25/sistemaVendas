package com.marco.sistemaVendas.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marco.sistemaVendas.entities.Produto;
import com.marco.sistemaVendas.entities.Venda;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Embeddable
public class ProdutoDaVendaPK implements Serializable{

	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "idProduto")
	private Produto produto;
	@ManyToOne
	@JoinColumn(name = "idVenda")
	private Venda venda;
	
	public ProdutoDaVendaPK() {
		// TODO Auto-generated constructor stub
	}

	public ProdutoDaVendaPK(Produto idProduto, Venda idVenda) {
		super();
		this.produto = idProduto;
		this.venda = idVenda;
	}

	public Produto getIdProduto() {
		return produto;
	}

	public void setIdProduto(Produto idProduto) {
		this.produto = idProduto;
	}
	@JsonIgnore
	public Venda getIdVenda() {
		return venda;
	}

	public void setIdVenda(Venda idVenda) {
		this.venda = idVenda;
	}

	@Override
	public int hashCode() {
		return Objects.hash(produto, venda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoDaVendaPK other = (ProdutoDaVendaPK) obj;
		return Objects.equals(produto, other.produto) && Objects.equals(venda, other.venda);
	}

	
}
