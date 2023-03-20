package com.marco.sistemaVendas.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.marco.sistemaVendas.entities.Categoria;
import com.marco.sistemaVendas.repositories.CategoriaRepositories;


@Service
public class CategoriaServices {
	
	@Autowired
	CategoriaRepositories repositories;
	
	public Categoria finById(Long id) {
		Optional<Categoria> obj = repositories.findById(id);
		return obj.get();
	}

	public List<Categoria> findAll() {
		return repositories.findAll();
	}

}
