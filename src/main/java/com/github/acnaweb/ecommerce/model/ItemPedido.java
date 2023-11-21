package com.github.acnaweb.ecommerce.model;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(optional = false)
	private Pedido pedido;
	
	@ManyToOne(optional = false)
	private Produto produto;
	
	@Column(nullable = false)
	private BigDecimal quantidade;
	
	@Column(nullable = false)
	private BigDecimal valorUnitario;
		
	@Column(nullable = false)
	private BigDecimal valorTotal;
		
}
