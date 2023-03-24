package com.marco.sistemaVendas.entities.dto;

import java.io.Serializable;
import java.util.Objects;


public class ProdutoDaVendaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private ProdutoDTO produto;
	private Long quantidade;
	
	public ProdutoDaVendaDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public Double getSubTotal() {
		return quantidade * produto.getValorProduto();
	}

	@Override
	public int hashCode() {
		return Objects.hash(produto, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoDaVendaDTO other = (ProdutoDaVendaDTO) obj;
		return Objects.equals(produto, other.produto) && Objects.equals(quantidade, other.quantidade);
	}
	
}
