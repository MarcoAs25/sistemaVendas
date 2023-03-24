package com.marco.sistemaVendas.entities;

import java.io.Serializable;

import com.marco.sistemaVendas.entities.pk.ProdutoDaVendaPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;


@Entity
public class ProdutoDaVenda implements Serializable{

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private ProdutoDaVendaPK id;
	
	private Long quantidade;
	private Double valorProduto;
	
	public ProdutoDaVenda() {
		// TODO Auto-generated constructor stub
	}

	public ProdutoDaVenda(Produto produto, Venda venda, Long quantidade) {
		super();
		this.id = new ProdutoDaVendaPK(produto, venda);
		this.quantidade = quantidade;
		this.valorProduto = produto.getValorProduto();
	}


	public void setId(ProdutoDaVendaPK id) {
		this.id = id;
	}
	
	public Produto getProduto() {
		return id.getIdProduto();
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public Double getSubTotal() {
		return quantidade * valorProduto;
	}
	
	@Override
	public String toString() {
		return "ProdutoDaVenda [id=" + id + ", quantidade=" + quantidade + ", valorProduto=" + valorProduto + "]";
	}
	
}
