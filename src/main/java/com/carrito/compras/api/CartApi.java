package com.carrito.compras.api;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CartApi {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonProperty(value = "date", required = false)
	private LocalDate date;

	@JsonProperty(value = "userId", required = false)
	private Integer userId;

}
