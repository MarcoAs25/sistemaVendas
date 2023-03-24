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

import com.marco.sistemaVendas.entities.Categoria;
import com.marco.sistemaVendas.entities.dto.CategoriaDTO;
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
	
	@PostMapping
	public ResponseEntity<Categoria> insert(@RequestBody CategoriaDTO obj){
		Categoria cat = services.insert(obj);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{id}").
				buildAndExpand(cat.getId()).toUri();
		return ResponseEntity.created(uri).body(cat);
	}

	@PutMapping(value = {"/{id}"})
	public ResponseEntity<Categoria> update(@PathVariable Long id,@RequestBody CategoriaDTO obj){
		Categoria cat = services.update(id, obj);
		return ResponseEntity.ok().body(cat);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
}
