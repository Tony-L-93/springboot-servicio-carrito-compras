package com.carrito.compras.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
	@JsonProperty(value = "id")
	private String id;

	@JsonProperty(value = "title")
	private String title;

	@JsonProperty(value = "description")
	private String description;

	@JsonProperty(value = "price")
	private String price;
}
