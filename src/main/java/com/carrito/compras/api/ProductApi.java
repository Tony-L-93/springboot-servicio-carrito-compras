package com.carrito.compras.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
public class ProductApi {

	@NotBlank(message = "Title cannot be null")
	@JsonProperty(value = "title", required = true)
	private String title;

	@NotBlank(message = "Description cannot be null")
	@JsonProperty(value = "description", required = true)
	private String description;

	@NotNull(message = "Price cannot be null")
	@JsonProperty(value = "price", required = true)
	private Float price;
}
