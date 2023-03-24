package com.marco.sistemaVendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marco.sistemaVendas.entities.Pagamento;

public interface PagamentoRepositories extends JpaRepository<Pagamento, Long>{

}
