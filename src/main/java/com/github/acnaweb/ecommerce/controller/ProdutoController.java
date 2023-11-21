package com.github.acnaweb.ecommerce.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.acnaweb.ecommerce.controller.dto.ProdutoCreateDTO;
import com.github.acnaweb.ecommerce.controller.dto.ProdutoDTO;
import com.github.acnaweb.ecommerce.controller.mapper.ProdutoMapper;
import com.github.acnaweb.ecommerce.model.Produto;
import com.github.acnaweb.ecommerce.repository.ProdutoRepository;
import com.github.acnaweb.ecommerce.service.ProdutoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {
	private final ProdutoService produtoService;
	private final ProdutoMapper produtoMapper;
	private final ProdutoRepository produtoRepository;
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> getAll() {
		List<ProdutoDTO> result = produtoService.getAll().stream().map(produtoMapper::map).collect(Collectors.toList());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<ProdutoDTO> findById(@PathVariable long id) {
		if (!produtoService.exists(id)) {
			return ResponseEntity.notFound().build();
		}
		ProdutoDTO dto = produtoMapper.map(produtoService.findById(id));
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> create(@Valid @RequestBody ProdutoCreateDTO requestDto) {
		Produto produto = produtoMapper.map(requestDto);
		Produto produtoSaved = produtoService.save(produto);
		ProdutoDTO responseDto = produtoMapper.map(produtoSaved);
		return new ResponseEntity<>(responseDto, HttpStatus.CREATED);			
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ProdutoDTO> update(@Valid @RequestBody ProdutoCreateDTO requestDto, @PathVariable long id) {
		boolean produtoExists = produtoService.exists(id);
		if(produtoExists) {
			Produto produto = produtoMapper.map(requestDto);
			produto.setId(id);
			Produto produtoSaved = produtoService.save(produto);
			ProdutoDTO responseDto = produtoMapper.map(produtoSaved);
			return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
		}else {	
			return ResponseEntity.notFound().build();	
		}	
	}
	
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Long id) {
		produtoRepository.deleteById(id);		
	}

	
}
