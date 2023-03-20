package com.marco.sistemaVendas.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.marco.sistemaVendas.entities.Venda;
import com.marco.sistemaVendas.repositories.VendaRepositories;


@Service
public class VendaServices {
	
	@Autowired
	VendaRepositories repositories;
	
	public Venda finById(Long id) {
		Optional<Venda> obj = repositories.findById(id);
		return obj.get();
	}

	public List<Venda> findAll() {
		return repositories.findAll();
	}

}
