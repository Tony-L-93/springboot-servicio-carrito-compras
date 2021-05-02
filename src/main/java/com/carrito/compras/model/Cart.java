package com.carrito.compras.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

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

	    @Column(name = "total_price")
	    private Float totalPrice;

	    @Column(name = "date")
	    private LocalDate date;

	    /*@Enumerated(EnumType.STRING)
	    @Column(name = "status")
	    private CartStatus status;*/

	    @OneToMany(mappedBy = "cart")
	    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	    private Set<Product> products = new HashSet<>();

	   /* @ManyToOne
	    @JsonIgnoreProperties(value = "carts", allowSetters = true)
	    private Customer customer;*/
}
