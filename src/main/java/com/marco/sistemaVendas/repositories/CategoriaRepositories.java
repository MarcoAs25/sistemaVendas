package com.marco.sistemaVendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marco.sistemaVendas.entities.Categoria;

public interface CategoriaRepositories extends JpaRepository<Categoria, Long>{

}
