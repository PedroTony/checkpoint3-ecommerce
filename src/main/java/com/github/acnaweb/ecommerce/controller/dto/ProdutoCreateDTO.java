package com.github.acnaweb.ecommerce.controller.dto;

import java.time.Instant;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoCreateDTO {
	
	@NotNull
	private String nome;
	@NotNull
	private Instant dataCadastro;
}
