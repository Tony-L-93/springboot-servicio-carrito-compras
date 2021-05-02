package com.carrito.compras.api;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
public class CartApi {
	
	@JsonProperty(value = "id", required = false)
	private Long id;

	@JsonProperty(value = "totalPrice", required = false)
	private Float totalPrice;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonProperty(value = "date", required = true)
	private LocalDate date;


	@JsonProperty(value = "status", required = false)
	private String status;
	
	@JsonProperty(value = "products", required = true)
	private List<Long> products;

}
