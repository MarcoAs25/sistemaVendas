package com.marco.sistemaVendas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.marco.sistemaVendas.entities.Cliente;
import com.marco.sistemaVendas.entities.dto.ClienteDTO;
import com.marco.sistemaVendas.repositories.ClienteRepositories;
import com.marco.sistemaVendas.services.exceptions.ResourceNotFoundException;
import com.marco.sistemaVendas.services.exceptions.DatabaseException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;


@Service
public class ClienteServices {
	
	@Autowired
	private ClienteRepositories repositories;
	
	public Cliente finById(Long id) {
		Optional<Cliente> obj = repositories.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));	
	}

	public List<Cliente> findAll() {
		return repositories.findAll();
	}
	@Transactional
	public Cliente insert(ClienteDTO obj) {
		Cliente cli = new Cliente(obj);
		return repositories.save(cli);
	}
	@Transactional
	public void delete(Long id) {
		if(repositories.existsById(id)) {
			try {
				if(repositories.findById(id).get().getVendas().size() > 0) {
					throw new DatabaseException("Cannot delete or update a parent row");
				}
				repositories.deleteById(id);
			} catch (DataIntegrityViolationException e) {
				throw new DatabaseException(e.getMessage());
			}
			
		}else {
			throw new ResourceNotFoundException(id);
		}
	}
	@Transactional
	public Cliente update(Long id, ClienteDTO obj) {
		try {
			Cliente entity = repositories.getReferenceById(id);
			updateData(entity, obj);
			return repositories.save(entity);	
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Cliente entity, ClienteDTO obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
	}
}
