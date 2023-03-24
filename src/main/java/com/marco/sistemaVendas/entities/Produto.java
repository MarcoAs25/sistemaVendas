package com.marco.sistemaVendas.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marco.sistemaVendas.entities.dto.ProdutoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double valorProduto;
	private String descricao;
	private String nome;
	
	@ManyToMany
	@JoinTable(name = "tb_produto_categoria",
			joinColumns = @JoinColumn(name = "idProduto"),
			inverseJoinColumns = @JoinColumn(name="idCategoria"))
	private Set<Categoria> categorias = new HashSet<>();
	@JsonIgnore
	@OneToMany(mappedBy = "id.produto")
	private Set<ProdutoDaVenda> produtoDaVenda = new HashSet<>();
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}
	public Produto(ProdutoDTO prod) {
		id = prod.getId();
		valorProduto = prod.getValorProduto();
		descricao = prod.getDescricao();
		nome = prod.getNome();
	}
	public Produto(Long id, String nome, Double valorProduto, String descricao) {
		super();
		this.id = id;
		this.valorProduto = valorProduto;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}
	
	public Set<ProdutoDaVenda> getProdutoDaVenda() {
		return produtoDaVenda;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", valorProduto=" + valorProduto + ", Descricao=" + descricao + ", nome=" + nome
				+ ", categorias=" + categorias + ", produtoDaVenda=" + produtoDaVenda + "]";
	}
	
}
