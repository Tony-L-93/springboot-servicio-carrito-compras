package com.carrito.compras.api;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
public class CartApiUpdate extends CartApi {

	public CartApiUpdate(LocalDate date, Integer userId, List<Long> products) {
		super(date, userId);
		this.products = products;
	}

	@NotNull(message = "Products cannot be null")
	@JsonProperty(value = "products", required = true)
	private List<Long> products;

}
