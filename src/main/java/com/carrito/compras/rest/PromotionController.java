package com.carrito.compras.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.carrito.compras.model.Promotion;
import com.carrito.compras.service.impl.PromotionService;

@RestController
@RequestMapping(path = "/promotion")
public class PromotionController {
	@Autowired
	private PromotionService promotionService;

	@GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Promotion>> getAll() {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(promotionService.findAll());
	}


}
