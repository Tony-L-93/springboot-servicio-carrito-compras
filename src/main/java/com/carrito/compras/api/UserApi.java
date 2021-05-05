package com.carrito.compras.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_EMPTY)
@SuperBuilder
public class UserApi {
	
	@NotBlank(message = "Name cannot be empty")
	@Size(max = 50, message = "Name must be 50 characters")
	@JsonProperty(value = "name", required = true)
	private String name;

	@NotBlank(message = "Surname cannot be empty")
	@Size(max = 50, message = "surname must be 50 characters")
	@JsonProperty(value = "surname", required = true)
	private String surname;

	@NotBlank(message = "Email cannot be empty")
	@JsonProperty(value = "email", required = true)
	private String email;

	@NotBlank(message = "Cell phone cannot be empty")
	@JsonProperty(value = "cellPhone", required = true)
	private String cellPhone;

}
