package com.marco.sistemaVendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marco.sistemaVendas.entities.ProdutoDaVenda;
import com.marco.sistemaVendas.entities.Venda;
import com.marco.sistemaVendas.services.ProdutoDaVendaServices;
import com.marco.sistemaVendas.services.VendaServices;



@RestController
public class ProdutoVendaResources {
	@Autowired
	private ProdutoDaVendaServices services;
	
	public ResponseEntity<ProdutoDaVenda> findById(@PathVariable Long id){
		System.out.println("oi");
		ProdutoDaVenda obj = services.finById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	public ResponseEntity<List<ProdutoDaVenda>> findAll(){
		List<ProdutoDaVenda> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}
}
