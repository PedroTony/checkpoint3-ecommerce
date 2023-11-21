package com.github.acnaweb.ecommerce.controller.dto;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {
	
	private Long id;
	private String nome;
	private Instant dataCadastro;
}
