package com.carrito.compras.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrito.compras.dto.UserDTO;
import com.carrito.compras.mapper.Mapper;
import com.carrito.compras.service.impl.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<UserDTO>> getAll() {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(Mapper.mapperToUsersApi(userService.findAll()));
	}


}
