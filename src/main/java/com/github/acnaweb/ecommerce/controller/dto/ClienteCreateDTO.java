package com.github.acnaweb.ecommerce.controller.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteCreateDTO {

	@Size(min = 5, message = "O nome deve ter no mínimo 5 caracteres")
	@Size(max = 100, message = "Tamanho máximo permitido 100")
	@NotNull
	private String nome;
	private String cep;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String municipio;
	private String uf;
	private boolean ativo;
}
