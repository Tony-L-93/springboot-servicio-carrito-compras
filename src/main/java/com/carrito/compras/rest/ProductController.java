package com.carrito.compras.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrito.compras.api.ProductApi;
import com.carrito.compras.enumerator.ProductEnum;
import com.carrito.compras.service.impl.ProductService;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
		@Autowired
		private ProductService productService;
		
		@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<ProductEnum> create(@RequestBody @Validated ProductApi productApi ){
			productService.create(productApi);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(ProductEnum.CREATE_OK);
		}
		
		
}
