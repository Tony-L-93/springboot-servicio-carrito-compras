package com.carrito.compras.api;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
public class ProductApi {

	@JsonProperty(value = "id", required = false)
	private String id;

	@NotBlank(message = "Title cannot be null")
	@JsonProperty(value = "title", required = true)
	private String title;

	@NotBlank(message = "Description cannot be null")
	@JsonProperty(value = "description", required = true)
	private String description;

	@NotBlank(message = "Price cannot be null")
	@JsonProperty(value = "price", required = true)
	private String price;
}
