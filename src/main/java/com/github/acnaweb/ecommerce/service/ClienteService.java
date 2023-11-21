package com.github.acnaweb.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.acnaweb.ecommerce.model.Cliente;
import com.github.acnaweb.ecommerce.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public List<Cliente> getAll() {
		return clienteRepository.findAll();
	}

	public boolean exists(long id) {
		return clienteRepository.existsById(id);
	}

	public Cliente findById(long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);		
	}
}
