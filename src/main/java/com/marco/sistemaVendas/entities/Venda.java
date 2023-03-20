package com.marco.sistemaVendas.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataVenda;
	
	@ManyToOne
    @JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "id.venda")
	private Set<ProdutoDaVenda> items = new HashSet<>();
	
	
	
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
		for(ProdutoDaVenda prodv: items) {
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

	@Override
	public String toString() {
		return "Venda [id=" + id + ", valorTotal=" + valorTotal + ", dataVenda=" + dataVenda + ", cliente=" + cliente
				+ ", produtoDaVenda=" + items + "]";
	}

	public Set<ProdutoDaVenda> getItems() {
		return items;
	}
	
}
