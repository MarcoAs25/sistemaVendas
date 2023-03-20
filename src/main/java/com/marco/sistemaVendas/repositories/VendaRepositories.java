package com.marco.sistemaVendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marco.sistemaVendas.entities.Venda;

public interface VendaRepositories extends JpaRepository<Venda, Long>{

}
