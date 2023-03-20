package com.marco.sistemaVendas.entities.pk;

import java.io.Serializable;
import java.util.Objects;

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
	private Produto idProduto;
	@ManyToOne
	@JoinColumn(name = "idVenda")
	private Venda idVenda;
	
	public ProdutoDaVendaPK() {
		// TODO Auto-generated constructor stub
	}

	public ProdutoDaVendaPK(Produto idProduto, Venda idVenda) {
		super();
		this.idProduto = idProduto;
		this.idVenda = idVenda;
	}

	public Produto getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Produto idProduto) {
		this.idProduto = idProduto;
	}

	public Venda getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Venda idVenda) {
		this.idVenda = idVenda;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProduto, idVenda);
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
		return Objects.equals(idProduto, other.idProduto) && Objects.equals(idVenda, other.idVenda);
	}

	
}
