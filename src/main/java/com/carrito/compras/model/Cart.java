package com.carrito.compras.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.carrito.compras.enumerator.CartStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "cart")
@Entity
public class Cart {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
	private Long id;

	@Column(name = "total_price", nullable = true)
	private Float totalPrice;

	@Column(name = "date", nullable = true, columnDefinition = "DATETIME")
	private LocalDate date;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private CartStatus status;
	
	@Column(name = "discount")
	private Integer discount;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_product")
	private List<Product> products;
	
	@Column(name = "user_id", nullable = true)
	private Integer userId;
}
