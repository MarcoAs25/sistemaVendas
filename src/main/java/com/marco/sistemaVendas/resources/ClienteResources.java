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

import com.marco.sistemaVendas.entities.Cliente;
import com.marco.sistemaVendas.entities.dto.ClienteDTO;
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
	
	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody ClienteDTO obj){
		Cliente cli = services.insert(obj);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{id}").
				buildAndExpand(cli.getId()).toUri();
		return ResponseEntity.created(uri).body(cli);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = {"/{id}"})
	public ResponseEntity<Cliente> update(@PathVariable Long id,@RequestBody ClienteDTO obj){
		Cliente cli = services.update(id, obj);
		return ResponseEntity.ok().body(cli);
	}
}
