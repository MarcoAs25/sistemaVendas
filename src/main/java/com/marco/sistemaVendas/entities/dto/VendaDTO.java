package com.marco.sistemaVendas.entities.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class VendaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private ClienteDTO cliente;
	
	private Set<ProdutoDaVendaDTO> itens = new HashSet<>();

	public VendaDTO() {
		// TODO Auto-generated constructor stub
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public Set<ProdutoDaVendaDTO> getItens() {
		return itens;
	}
	
	public void setItens(Set<ProdutoDaVendaDTO> itens) {
		this.itens = itens;
	}
	public Double getValorTotal() {
		Double sum = 0d;
		for(ProdutoDaVendaDTO prod: itens) {
			sum+=prod.getSubTotal();
		}
		return sum;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cliente, itens);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendaDTO other = (VendaDTO) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(itens, other.itens);
	}

}
