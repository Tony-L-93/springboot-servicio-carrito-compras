package com.carrito.compras.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "promotion")
@Entity
public class Promotion {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

	@Column(name = "start_date", nullable = false, columnDefinition = "DATETIME")
	private LocalDate startDate;
	
	@Column(name = "end_date", nullable = false, columnDefinition = "DATETIME")
	private LocalDate endDate;

	
}
