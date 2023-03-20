package com.marco.sistemaVendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marco.sistemaVendas.entities.Cliente;
import com.marco.sistemaVendas.services.ClienteServices;


@RequestMapping(value = "/clientes")
@RestController
public class ClienteResources {
	@Autowired
	private ClienteServices services;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id){
		System.out.println("oi");
		Cliente obj = services.finById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}
}
