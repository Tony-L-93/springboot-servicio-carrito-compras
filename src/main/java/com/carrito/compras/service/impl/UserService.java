package com.carrito.compras.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrito.compras.api.UserApi;
import com.carrito.compras.enumerator.UserEnum;
import com.carrito.compras.exception.TransactionException;
import com.carrito.compras.mapper.Mapper;
import com.carrito.compras.model.Cart;
import com.carrito.compras.model.Product;
import com.carrito.compras.model.User;
import com.carrito.compras.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartService cartService;

	public void create(UserApi userApi) {
		User user = Mapper.mapperToUser(userApi);
		userRepository.save(user);
	}

	public void addCart(String userId, String cartId) throws TransactionException {
		
		User user = findById(userId);
		List<Cart> carts=user.getCart();
		carts.add(cartService.findById(cartId));
		user.setCart(carts);
		
		userRepository.save(user);
	}

	public User findById(String id) throws TransactionException {

		Optional<User> optional = userRepository.findById(Long.valueOf(id));

		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new TransactionException(UserEnum.GET_ERROR.getCode(), UserEnum.GET_ERROR.getDescription());
		}

	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public void updateCart(String userId, String cartId, Cart cart) throws TransactionException {
		User user = findById(userId);
		List<Cart> carts=user.getCart();
		if(!carts.isEmpty()) {
			user.getCart().clear();
			carts.stream().filter(p -> Long.valueOf(cartId).equals(p)).forEach(p-> user.getCart().remove(p));
			carts.add(cart);
		}
		else {
			carts.add(cart);
		}
		user.setCart(carts);
		userRepository.save(user);
	}
	
	public void cleanCart(String userId, String cartId) throws TransactionException {
		User user = findById(userId);
		List<Cart> carts=user.getCart();
		carts.removeIf(p -> Long.valueOf(cartId).equals(p));
		user.getCart().removeIf(p->p.getId().equals(Long.valueOf(cartId)));
		user.setCart(carts);
		userRepository.save(user);
	}

}
