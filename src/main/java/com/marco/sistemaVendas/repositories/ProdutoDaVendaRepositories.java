package com.marco.sistemaVendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marco.sistemaVendas.entities.Produto;
import com.marco.sistemaVendas.entities.ProdutoDaVenda;

public interface ProdutoDaVendaRepositories extends JpaRepository<ProdutoDaVenda, Long>{

}
