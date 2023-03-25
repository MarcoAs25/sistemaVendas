package com.marco.sistemaVendas.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marco.sistemaVendas.entities.Produto;
import com.marco.sistemaVendas.entities.dto.ProdutoDTO;
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
	
	@PostMapping
	public ResponseEntity<Produto> insert(@RequestBody ProdutoDTO obj){
		Produto prod = services.insert(obj);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{id}").
				buildAndExpand(prod.getId()).toUri();
		return ResponseEntity.created(uri).body(prod);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = {"/{id}"})
	public ResponseEntity<Produto> update(@PathVariable Long id,@RequestBody ProdutoDTO obj){
		Produto prod = services.update(id, obj);
		return ResponseEntity.ok().body(prod);
	}
}
