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
import com.marco.sistemaVendas.entities.Pagamento;
import com.marco.sistemaVendas.entities.Produto;
import com.marco.sistemaVendas.entities.ProdutoDaVenda;
import com.marco.sistemaVendas.entities.Venda;
import com.marco.sistemaVendas.entities.enums.StatusPagamento;
import com.marco.sistemaVendas.repositories.CategoriaRepositories;
import com.marco.sistemaVendas.repositories.ClienteRepositories;
import com.marco.sistemaVendas.repositories.PagamentoRepositories;
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
	
	@Autowired
	private PagamentoRepositories pagamentoRepositories;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Eletronicos");
		categoriaRepositories.save(cat1);
		
		Produto p1 = new Produto(null,"TV 45 polegadas", 2000.0, "Smart TV Amoled");
		p1.getCategorias().add(cat1);
		produtorepositories.save(p1);
		
		Cliente u1 = new Cliente(null, "Marco", "marco@gmail.com", "0293029");
		clientRepository.save(u1);
		
		Venda v1 = new Venda(u1,null, Instant.now());
		Pagamento pag = new Pagamento(null, Instant.now(), v1);
		pagamentoRepositories.save(pag);
		vendaRepositories.save(v1);
		
		ProdutoDaVenda pv1 = new ProdutoDaVenda(p1,v1, 3L);
		produtoDaVendaRepositories.save(pv1);
		
		v1.getItens().add(pv1);
		vendaRepositories.save(v1);
	}
	
	
}
