package com.marco.sistemaVendas.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.marco.sistemaVendas.entities.Produto;
import com.marco.sistemaVendas.repositories.ProdutoRepositories;


@Service
public class ProdutoServices {
	
	@Autowired
	ProdutoRepositories repositories;
	
	public Produto finById(Long id) {
		Optional<Produto> obj = repositories.findById(id);
		return obj.get();
	}

	public List<Produto> findAll() {
		return repositories.findAll();
	}

}
