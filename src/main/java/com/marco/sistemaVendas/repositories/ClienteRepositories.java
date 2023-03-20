package com.marco.sistemaVendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marco.sistemaVendas.entities.Cliente;

public interface ClienteRepositories extends JpaRepository<Cliente, Long>{

}
