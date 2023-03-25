package com.marco.sistemaVendas.resources;

import java.net.URI;
import java.util.List;

import org.springdoc.core.annotations.RouterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marco.sistemaVendas.entities.Cliente;
import com.marco.sistemaVendas.entities.Venda;
import com.marco.sistemaVendas.entities.dto.VendaDTO;
import com.marco.sistemaVendas.services.VendaServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.ParameterIn;


@RequestMapping(value = "/vendas")
@RestController
public class VendaResources {
	@Autowired
	private VendaServices services;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Venda> findById(@PathVariable Long id){
		Venda obj = services.finById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Venda>> findAll(){
		List<Venda> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Venda> insert(@RequestBody VendaDTO obj){
		Venda vend = services.insert(obj);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{id}").
				buildAndExpand(vend.getId()).toUri();
		return ResponseEntity.created(uri).body(vend);
	}
}
