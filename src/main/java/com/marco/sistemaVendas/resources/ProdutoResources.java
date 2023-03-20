package com.marco.sistemaVendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marco.sistemaVendas.entities.Produto;
import com.marco.sistemaVendas.services.ProdutoServices;


@RequestMapping(value = "/produtos")
@RestController
public class ProdutoResources {
	@Autowired
	private ProdutoServices services;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		System.out.println("oi");
		Produto obj = services.finById(id);
		System.out.println(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}
}
