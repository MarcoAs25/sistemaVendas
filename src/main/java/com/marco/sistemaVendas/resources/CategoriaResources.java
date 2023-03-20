package com.marco.sistemaVendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marco.sistemaVendas.entities.Categoria;
import com.marco.sistemaVendas.services.CategoriaServices;


@RequestMapping(value = "/categorias")
@RestController
public class CategoriaResources {
	@Autowired
	private CategoriaServices services;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		System.out.println("oi");
		Categoria obj = services.finById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll(){
		List<Categoria> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}
}
