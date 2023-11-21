package com.github.acnaweb.ecommerce.controller.mapper;

import java.time.Instant;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.github.acnaweb.ecommerce.controller.dto.ProdutoCreateDTO;
import com.github.acnaweb.ecommerce.controller.dto.ProdutoDTO;
import com.github.acnaweb.ecommerce.model.Produto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProdutoMapper {

	private final ModelMapper modelMapper;

	public Produto map(ProdutoCreateDTO dto) {
		Produto produto = modelMapper.map(dto, Produto.class);
		produto.setDataCadastro(Instant.now());
		return produto;
	}

	public ProdutoDTO map(Produto produto) {
		ProdutoDTO dto = modelMapper.map(produto, ProdutoDTO.class);
		return dto;
	}
}
