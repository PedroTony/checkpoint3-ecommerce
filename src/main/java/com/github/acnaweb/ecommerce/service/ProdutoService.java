package com.github.acnaweb.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.acnaweb.ecommerce.model.Produto;
import com.github.acnaweb.ecommerce.repository.ProdutoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {
	
	public final ProdutoRepository produtoRepository;
	
	public List<Produto> getAll() {
		return produtoRepository.findAll();
	}

	public boolean exists(long id) {
		return produtoRepository.existsById(id);
	}

	public Produto findById(long id) {
		return produtoRepository.findById(id).orElse(null);
	}

	public Produto save(Produto produto) {
		return produtoRepository.save(produto);		
	}
}
