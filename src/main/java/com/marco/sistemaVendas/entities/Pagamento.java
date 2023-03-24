package com.marco.sistemaVendas.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marco.sistemaVendas.entities.enums.StatusPagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Pagamento implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momentoGeracao;
	
	private Integer statusPagamento;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	private Venda venda;
	
	public Pagamento() {
		// TODO Auto-generated constructor stub
	}

	public Pagamento(Long id,Instant momentoGeracao, Venda venda) {
		super();
		this.id = id;
		this.venda = venda;
		this.momentoGeracao = momentoGeracao;
		statusPagamento = StatusPagamento.AGUARDANDO_PAGAMENTO.getCodigo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Instant getMomentoGeracao() {
		return momentoGeracao;
	}

	public void setMomentoGeracao(Instant momentoGeracao) {
		this.momentoGeracao = momentoGeracao;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public StatusPagamento getStatusPagamento() {
		return StatusPagamento.valueOf(this.statusPagamento);
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento.getCodigo();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		return Objects.equals(id, other.id);
	}
	
}
