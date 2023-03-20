package com.marco.sistemaVendas.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marco.sistemaVendas.entities.Categoria;
import com.marco.sistemaVendas.entities.Cliente;
import com.marco.sistemaVendas.entities.Produto;
import com.marco.sistemaVendas.entities.ProdutoDaVenda;
import com.marco.sistemaVendas.entities.Venda;
import com.marco.sistemaVendas.repositories.CategoriaRepositories;
import com.marco.sistemaVendas.repositories.ClienteRepositories;
import com.marco.sistemaVendas.repositories.ProdutoDaVendaRepositories;
import com.marco.sistemaVendas.repositories.ProdutoRepositories;
import com.marco.sistemaVendas.repositories.VendaRepositories;



@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private ClienteRepositories clientRepository;
	
	@Autowired 
	private CategoriaRepositories categoriaRepositories;
	
	@Autowired
	private ProdutoRepositories produtorepositories;
	
	@Autowired
	private VendaRepositories vendaRepositories;
	
	@Autowired
	private ProdutoDaVendaRepositories produtoDaVendaRepositories;
	
	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Eletronicos");
		Categoria cat2 = new Categoria(null, "Alimentos");
		Categoria cat3 = new Categoria(null, "Vestiveis");
		
		categoriaRepositories.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		Produto p1 = new Produto(null,"produto3cat", 200.0, "jksdfj");
		Produto p2 = new Produto(null,"produto1cat1", 200.0, "jksdfj");
		Produto p3 = new Produto(null,"produto1cat2", 200.0, "jksdfj");
		
		p1.getCategorias().add(cat3);
		p1.getCategorias().add(cat2);
		p1.getCategorias().add(cat1);
		
		p2.getCategorias().add(cat2);
		p3.getCategorias().add(cat1);
		
		produtorepositories.saveAll(Arrays.asList(p1,p2,p3));
		
		
		Cliente u1 = new Cliente(null, "Marco1", "marco@gmail.com", "0293029");
		Cliente u2 = new Cliente(null, "Joaquim", "Joaquim@gmail.com", "345345");
		Cliente u3 = new Cliente(null, "Jose", "Jose@gmail.com", "567575");
		Cliente u4 = new Cliente(null, "Franciele", "Franciele@gmail.com", "029234243029");
		clientRepository.saveAll(Arrays.asList(u1,u2,u3,u4));
		
		/*
		Optional<Cliente> u1 = clientRepository.findById(1L);
		Optional<Cliente> u2 = clientRepository.findById(2L);
		Optional<Cliente> u3 = clientRepository.findById(3L);
		*/
		Venda v1 = new Venda(u1,null, Instant.now());
		Venda v2 = new Venda(u2,null, Instant.now());
		Venda v3 = new Venda(u3,null, Instant.now());
		
		vendaRepositories.saveAll(Arrays.asList(v1,v2,v3));
		
		/*Optional<Produto> p1 = produtorepositories.findById(1L);
		Optional<Produto> p2 = produtorepositories.findById(2L);
		Optional<Produto> p3 = produtorepositories.findById(3L);
		*/
		ProdutoDaVenda pv1 = new ProdutoDaVenda(p1,v1, 3L);
		ProdutoDaVenda pv2 = new ProdutoDaVenda(p2,v1, 3L);
		
		ProdutoDaVenda pv3 = new ProdutoDaVenda(p3,v2, 3L);
		ProdutoDaVenda pv4 = new ProdutoDaVenda(p1,v3, 3L);

		produtoDaVendaRepositories.saveAll(Arrays.asList(pv1,pv2,pv3, pv4));
		v1.getProdutos().add(pv1);
		v1.getProdutos().add(pv2);
		
		v2.getProdutos().add(pv3);
		v3.getProdutos().add(pv1);
		
		vendaRepositories.saveAll(Arrays.asList(v1,v2,v3));
	}
	
	
}
