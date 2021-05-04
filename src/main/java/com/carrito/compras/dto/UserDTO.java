package com.carrito.compras.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	@JsonProperty(value = "id")
	private String id;

	@JsonProperty(value = "name")
	 private String name;


	@JsonProperty(value = "surname")
	private String surname;

	@JsonProperty(value = "email")
	 private String email;
	
	@JsonProperty(value = "cellPhone")
	 private String cellPhone;
	
	@JsonProperty(value = "cart")
	private List<CartDTO> cart;
}
