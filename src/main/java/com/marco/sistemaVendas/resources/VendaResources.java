package com.marco.sistemaVendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.marco.sistemaVendas.entities.Venda;
import com.marco.sistemaVendas.services.VendaServices;


@RequestMapping(value = "/vendas")
@RestController
public class VendaResources {
	@Autowired
	private VendaServices services;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Venda> findById(@PathVariable Long id){
		System.out.println("=========================================================");
		Venda obj = services.finById(id);
		System.out.println(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Venda>> findAll(){
		List<Venda> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}
}
