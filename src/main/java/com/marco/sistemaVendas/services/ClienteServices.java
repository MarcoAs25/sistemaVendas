package com.marco.sistemaVendas.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.marco.sistemaVendas.entities.Cliente;
import com.marco.sistemaVendas.repositories.ClienteRepositories;


@Service
public class ClienteServices {
	
	@Autowired
	ClienteRepositories repositories;
	
	public Cliente finById(Long id) {
		Optional<Cliente> obj = repositories.findById(id);
		return obj.get();
	}

	public List<Cliente> findAll() {
		return repositories.findAll();
	}

}
