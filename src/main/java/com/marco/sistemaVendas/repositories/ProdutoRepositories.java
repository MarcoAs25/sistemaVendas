package com.marco.sistemaVendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marco.sistemaVendas.entities.Produto;

public interface ProdutoRepositories extends JpaRepository<Produto, Long>{

}
