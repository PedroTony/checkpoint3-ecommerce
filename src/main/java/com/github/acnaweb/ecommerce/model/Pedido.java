package com.github.acnaweb.ecommerce.model;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(optional = false)	
	private Cliente cliente;

	@Column(nullable = false)
	private Instant dataPedido;

	@Column(nullable = false)
	private Instant dataEntrega;

	private BigDecimal valorTotal;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private SituacaoPedidoEnum situacao;

}
