package com.github.acnaweb.ecommerce.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(length = 9)
	private String cep;

	@Column(length = 100)
	private String logradouro;

	@Column(length = 10)
	private String numero;

	@Column(length = 20)
	private String complemento;

	@Column(length = 60)
	private String bairro;

	@Column(length = 60)
	private String municipio;

	@Column(length = 2)
	private String uf;

	@Column(nullable = false)
	private Instant dataCadastro;

	@Column(nullable = false)
	private boolean ativo;

}
