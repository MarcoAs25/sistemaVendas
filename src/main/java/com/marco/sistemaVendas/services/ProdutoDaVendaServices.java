package com.marco.sistemaVendas.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.marco.sistemaVendas.repositories.ProdutoDaVendaRepositories;
import com.marco.sistemaVendas.entities.ProdutoDaVenda;

@Service
public class ProdutoDaVendaServices {
	
	@Autowired
	ProdutoDaVendaRepositories repositories;
	
	public ProdutoDaVenda finById(Long id) {
		Optional<ProdutoDaVenda> obj = repositories.findById(id);
		return obj.get();
	}

	public List<ProdutoDaVenda> findAll() {
		return repositories.findAll();
	}

}
