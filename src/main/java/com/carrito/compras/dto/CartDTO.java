package com.carrito.compras.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDTO {
	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "totalPrice")
	private Float totalPrice;

	@JsonProperty(value = "date")
	private LocalDate date;

	@JsonProperty(value = "status")
	private String status;
	
	@JsonProperty(value = "discount")
	private Integer discount;

	@JsonProperty(value = "products")
	private List<ProductDTO> products;
}
