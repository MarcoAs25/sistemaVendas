package com.marco.sistemaVendas.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.marco.sistemaVendas.entities.Categoria;
import com.marco.sistemaVendas.entities.dto.CategoriaDTO;
import com.marco.sistemaVendas.repositories.CategoriaRepositories;
import com.marco.sistemaVendas.services.exceptions.ResourceNotFoundException;
import com.marco.sistemaVendas.services.exceptions.DatabaseException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;


@Service
public class CategoriaServices {
	
	@Autowired
	private CategoriaRepositories repositories;
	
	public Categoria finById(Long id) {
		Optional<Categoria> obj = repositories.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}

	public List<Categoria> findAll() {
		return repositories.findAll();
	}
	@Transactional
	public Categoria insert(CategoriaDTO obj) {
		Categoria cat = new Categoria(obj);
		return repositories.save(cat);
	}
	@Transactional
	public Categoria update(Long id, CategoriaDTO obj) {
		try {
			Categoria entity = repositories.getReferenceById(id);
			updateData(entity, obj);
			return repositories.save(entity);	
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Categoria entity, CategoriaDTO obj) {
		entity.setNome(obj.getNome());
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
}
