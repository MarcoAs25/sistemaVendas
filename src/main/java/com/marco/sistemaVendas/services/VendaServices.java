package com.marco.sistemaVendas.services;


import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marco.sistemaVendas.entities.Cliente;
import com.marco.sistemaVendas.entities.Pagamento;
import com.marco.sistemaVendas.entities.Produto;
import com.marco.sistemaVendas.entities.ProdutoDaVenda;
import com.marco.sistemaVendas.entities.Venda;
import com.marco.sistemaVendas.entities.dto.ProdutoDaVendaDTO;
import com.marco.sistemaVendas.entities.dto.VendaDTO;
import com.marco.sistemaVendas.repositories.ClienteRepositories;
import com.marco.sistemaVendas.repositories.PagamentoRepositories;
import com.marco.sistemaVendas.repositories.ProdutoDaVendaRepositories;
import com.marco.sistemaVendas.repositories.ProdutoRepositories;
import com.marco.sistemaVendas.repositories.VendaRepositories;
import com.marco.sistemaVendas.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;


@Service
public class VendaServices {
	
	@Autowired
	private VendaRepositories repositories;
	
	@Autowired
	private ClienteRepositories clienteRepositories;
	
	@Autowired 
	private ProdutoDaVendaRepositories produtodavendarepositories;
	
	@Autowired 
	private ProdutoRepositories produtorepositories;
	
	@Autowired PagamentoRepositories pagamentoRepositories;
	
	public Venda finById(Long id) {
		Optional<Venda> obj = repositories.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}

	public List<Venda> findAll() {
		return repositories.findAll();
	}
	@Transactional
	public Venda insert(VendaDTO obj) {
		try {
			Cliente cliente = clienteRepositories.findById(obj.getCliente().getId())
					.orElseThrow(()-> new ResourceNotFoundException(obj.getCliente().getId()));
			
			Venda venda = new Venda(cliente,null, Instant.now());
			
			Pagamento pag = new Pagamento(null, Instant.now(), venda);
			pagamentoRepositories.save(pag);
			venda.setPagamento(pag);
			
			repositories.save(venda);
			for(ProdutoDaVendaDTO prod: obj.getItens()) {
				Produto proditem = produtorepositories.findById(prod.getProduto().getId())
						.orElseThrow(()-> new ResourceNotFoundException(prod.getProduto().getId()));
	
				ProdutoDaVenda prodv = new ProdutoDaVenda(proditem, venda, prod.getQuantidade());
				produtodavendarepositories.save(prodv);
				venda.getItens().add(prodv);
			}
			return repositories.save(venda);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(obj);
		}catch (RuntimeException e) {
			throw new IllegalArgumentException("Bad Request");
		}
		
	}
}
