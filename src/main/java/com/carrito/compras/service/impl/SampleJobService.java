package com.carrito.compras.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.carrito.compras.enumerator.CartStatus;
import com.carrito.compras.exception.TransactionException;
import com.carrito.compras.model.Cart;

@Service
public class SampleJobService {
	
	@Autowired
	private CartService cartService;
	
	@Scheduled(cron="0 0/2 * 1/1 * *")//2 minuto
	public void destroyCarts() throws TransactionException {
		
		List<Cart> carts=cartService.findAllEntitys();
		for(Cart cart:carts) {
			if(cart.getStatus().equals(CartStatus.OPEN)) {
				cartService.delete(cart.getId().toString());
			}
		}
	}

}
