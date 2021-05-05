package com.carrito.compras.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrito.compras.api.CartApiUpdate;
import com.carrito.compras.dto.CartDTO;
import com.carrito.compras.enumerator.CartEnum;
import com.carrito.compras.exception.TransactionException;
import com.carrito.compras.service.impl.CartService;

@RestController
@RequestMapping(path = "/carrito")
public class CartController {
	@Autowired
	private CartService cartService;

	@GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<CartDTO>> getAll() {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(cartService.findAll());
	}

	@PostMapping(value = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CartEnum> create(@PathVariable("userId") String userId) throws TransactionException {
		cartService.create(userId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CartEnum.CREATE_OK);
	}

	@PutMapping(value = "/{cartId}/user/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CartEnum> update(@PathVariable("cartId") String cartId, @PathVariable("userId") String userId,
			@RequestBody @Validated CartApiUpdate cartApi) throws TransactionException {
		cartService.update(userId, cartId, cartApi);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CartEnum.UPDATE_OK);
	}

	@PutMapping(value = "/add/{cartId}/user/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CartEnum> addProducts(@PathVariable("cartId") String cartId,
			@PathVariable("userId") String userId, @RequestBody @Validated CartApiUpdate cartApi)
			throws TransactionException {
		cartService.addProducts(userId, cartId, cartApi);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CartEnum.UPDATE_OK);
	}

	@PutMapping(value = "/del/{cartId}/user/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CartEnum> delProducts(@PathVariable("cartId") String cartId,
			@PathVariable("userId") String userId, @RequestBody @Validated CartApiUpdate cartApi)
			throws TransactionException {
		cartService.delProducts(userId, cartId, cartApi);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CartEnum.UPDATE_OK);
	}
	
	@PutMapping(value = "/pay/{cartId}/user/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CartEnum> paidCart(@PathVariable("cartId") String cartId,
			@PathVariable("userId") String userId)
			throws TransactionException {
		cartService.updateStatus(userId, cartId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CartEnum.UPDATE_OK);
	}

	@DeleteMapping(value = "/{cartId}")
	public ResponseEntity<CartEnum> delete(@PathVariable("cartId") String cartId) throws TransactionException {
		cartService.delete(cartId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CartEnum.DELETE_OK);
	}

}
