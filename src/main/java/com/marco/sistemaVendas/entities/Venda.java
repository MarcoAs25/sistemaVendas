package com.marco.sistemaVendas.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marco.sistemaVendas.entities.enums.Pagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Venda implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double valorTotal;
	private Instant dataVenda;
	
	@ManyToOne
    @JoinColumn(name="id_cliente")
	@JsonIgnore
	private Cliente cliente;
	
	@OneToMany(mappedBy = "id.idVenda")
	private Set<ProdutoDaVenda> produtoDaVenda = new HashSet<>();
	
	
	
	public Venda() {
		// TODO Auto-generated constructor stub
	}

	public Venda(Cliente cliente, Long id, Instant dataVenda) {
		super();
		this.id = id;
		this.dataVenda = dataVenda;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValorTotal() {
		Double sum = 0.0;
		for(ProdutoDaVenda prodv: produtoDaVenda) {
			sum+= prodv.getSubTotal();
		}
		return sum;
	}
	
	Instant getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Instant dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Set<ProdutoDaVenda> getProdutos() {
		return produtoDaVenda;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dataVenda, id, valorTotal);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		return Objects.equals(dataVenda, other.dataVenda) && Objects.equals(id, other.id)
				&& Objects.equals(valorTotal, other.valorTotal);
	}
}
