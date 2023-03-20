package com.marco.sistemaVendas.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marco.sistemaVendas.entities.pk.ProdutoDaVendaPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.criteria.Order;


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
		this.id = new ProdutoDaVendaPK();
		this.id.setIdProduto(produto);
		this.id.setIdVenda(venda);
		this.quantidade = quantidade;
		this.valorProduto = produto.getValorProduto();
	}

	public Double getSubTotal() {
		return valorProduto * quantidade;
	}

	public Venda geVenda() {
		return id.getIdVenda();
	}

	public void setVenda(Venda venda) {
		this.id.setIdVenda(venda);
	}

	public void setProduto(Produto produto) {
		this.id.setIdProduto(produto);
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

	@Override
	public String toString() {
		return "ProdutoDaVenda [id=" + id + ", quantidade=" + quantidade + ", valorProduto=" + valorProduto + "]";
	}

	public Produto getProduto() {
		return id.getIdProduto();
	}
	@JsonIgnore
	public Venda getVenda() {
		return id.getIdVenda();
	}
}
