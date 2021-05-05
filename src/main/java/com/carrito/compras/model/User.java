package com.carrito.compras.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator")
	private Long id;

	@Column(name = "name", nullable = false)
	@NotBlank(message = "El nombre no puede estar vacío")
	private String name;

	@Column(name = "surname", nullable = false)
	@NotBlank(message = "El apellido no puede estar vacío")
	private String surname;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "cell_phone", nullable = false)
	private String cellPhone;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cart")
	private List<Cart> cart;

}
