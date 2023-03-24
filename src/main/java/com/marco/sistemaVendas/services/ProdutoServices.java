package com.marco.sistemaVendas.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.marco.sistemaVendas.entities.Categoria;
import com.marco.sistemaVendas.entities.Produto;
import com.marco.sistemaVendas.entities.dto.CategoriaDTO;
import com.marco.sistemaVendas.entities.dto.ProdutoDTO;
import com.marco.sistemaVendas.repositories.CategoriaRepositories;
import com.marco.sistemaVendas.repositories.ProdutoRepositories;
import com.marco.sistemaVendas.services.exceptions.ResourceNotFoundException;
import com.marco.sistemaVendas.services.exceptions.DatabaseException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;


@Service
public class ProdutoServices {
	
	@Autowired
	private ProdutoRepositories repositories;
	
	@Autowired
	private CategoriaRepositories categoriaRepositories;
	
	public Produto finById(Long id) {
		Optional<Produto> obj = repositories.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}

	public List<Produto> findAll() {
		return repositories.findAll();
	}
	@Transactional
	public Produto insert(ProdutoDTO obj) {
		Produto prod = new Produto(obj);
		
		for(CategoriaDTO categoria: obj.getCategorias()) {
			Categoria cat = categoriaRepositories.findById(categoria.getId()).orElseThrow(()-> new ResourceNotFoundException(categoria.getId()));
			prod.getCategorias().add(cat);
		}
		
		return repositories.save(prod);
	}
	@Transactional
	public void delete(Long id) {
		if(repositories.existsById(id)) {
			try {
				repositories.deleteById(id);
			} catch (DataIntegrityViolationException e) {
				throw new DatabaseException(e.getMessage());
			}
			
		}else {
			throw new ResourceNotFoundException(id);
		}
	}
	@Transactional
	public Produto update(Long id, ProdutoDTO obj) {
		try {
			Produto entity = repositories.getReferenceById(id);
			updateData(entity, obj);
			return repositories.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}
	
	private void updateData(Produto entity, ProdutoDTO obj) {
		Produto prod = new Produto(obj);
		entity.setNome(prod.getNome());
		entity.setDescricao(prod.getDescricao());
		entity.setValorProduto(prod.getValorProduto());
		entity.getCategorias().clear();
		for(CategoriaDTO cat : obj.getCategorias()) {
			Categoria category = categoriaRepositories.findById(cat.getId()).orElseThrow(()-> new ResourceNotFoundException(cat.getId()));
			System.out.println(category.getNome());
			entity.getCategorias().add(
					category
					);
		}
	}
}
