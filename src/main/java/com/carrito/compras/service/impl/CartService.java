package com.carrito.compras.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrito.compras.api.CartApi;
import com.carrito.compras.dto.CartDTO;
import com.carrito.compras.enumerator.CartEnum;
import com.carrito.compras.enumerator.CartStatus;
import com.carrito.compras.exception.TransactionException;
import com.carrito.compras.mapper.Mapper;
import com.carrito.compras.model.Cart;
import com.carrito.compras.model.Product;
import com.carrito.compras.repository.CartRepository;
import com.carrito.compras.service.generic.ServiceGeneric;

@Service
public class CartService implements ServiceGeneric<CartApi, CartDTO> {
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductService productService;

	@Override
	public void create(CartApi cartApi) throws TransactionException {
		try {
			List<Product> products = productService.findIdProducts(cartApi.getProducts());
			List<Float> infoPrices = totalPrice(products);

			Cart cart = Mapper.mapperToCart(cartApi);
			cart.setStatus(CartStatus.OPEN);
			cart.setProducts(products);
			cart.setTotalPrice(infoPrices.get(0));
			cart.setDiscount(infoPrices.get(1).intValue());
			cartRepository.save(cart);
		} catch (Exception e) {
			throw new TransactionException(CartEnum.CREATE_ERROR.getCode(), CartEnum.CREATE_ERROR.getDescription());
		}

	}

	private List<Float> totalPrice(List<Product> products) {
		List<Float> infoPrice = new ArrayList<>();
		float discount = 0;
		float totalPrice = (float) products.stream().mapToDouble(p -> p.getPrice()).sum();
		
		if (products.size() >= 5 && products.size() < 10) {
			totalPrice = (float) (totalPrice * 0.95);
			discount = 95;
		}
		if (products.size() >= 10) {
			totalPrice = (float) (totalPrice * 0.90);
			discount = 90;
		}
		infoPrice.add(totalPrice);
		infoPrice.add(discount);
		return infoPrice;
	}

	@Override
	public CartDTO getById(String id) throws TransactionException {
		Cart cart = findById(id);
		return Mapper.mapperToCartDTO(cart);
	}

	private Cart findById(String id) throws TransactionException {

		Optional<Cart> optional = cartRepository.findById(Long.parseLong(id));

		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new TransactionException(CartEnum.GET_ERROR.getCode(), CartEnum.GET_ERROR.getDescription());
		}
	}

	@Override
	public void update(String cartId, CartApi cartApi) throws TransactionException {
		Cart cart = findById(cartId);
		try {
			
			List<Product> products = productService.findIdProducts(cartApi.getProducts());
			List<Float> infoPrices = totalPrice(products);
			
			cart.setProducts(products);
			cart.setTotalPrice(infoPrices.get(0));
			cart.setDate(cartApi.getDate());
			cart.setDiscount(infoPrices.get(1).intValue());
			

			cartRepository.save(cart);
		} catch (Exception e) {
			throw new TransactionException(CartEnum.UPDATE_ERROR.getCode(), CartEnum.UPDATE_ERROR.getDescription());
		}
		

	}

	@Override
	public void delete(String id) throws TransactionException {
		Cart cart=findById(id);
		try {
			cart.getProducts().clear();			
			cartRepository.save(cart);
			cartRepository.deleteById(Long.valueOf(id));
		} catch (Exception e) {
			throw new TransactionException(CartEnum.UPDATE_ERROR.getCode(), CartEnum.UPDATE_ERROR.getDescription());
		}
	}

	public List<CartDTO> findAll() {
		return Mapper.mapperToCartsDTO(cartRepository.findAll());
	}

	public void addProducts(String cartId, CartApi cartApi) throws TransactionException {
		
		Cart cart = findById(cartId);
		try {
			
			List<Product> products = productService.findIdProducts(cartApi.getProducts());
			List<Product> newProductsList=cart.getProducts();
			newProductsList.addAll(products);
			
			List<Float> infoPrices = totalPrice(newProductsList);
			
			cart.setProducts(newProductsList);
			cart.setTotalPrice(infoPrices.get(0));
			cart.setDate(cartApi.getDate());
			cart.setDiscount(infoPrices.get(1).intValue());		

			cartRepository.save(cart);
		} catch (Exception e) {
			throw new TransactionException(CartEnum.UPDATE_ERROR.getCode(), CartEnum.UPDATE_ERROR.getDescription());
		}	
	}

	public void delProducts(String cartId, CartApi cartApi) throws TransactionException {
		Cart cart = findById(cartId);
		try {
		
			List<Product> productsToDelete = productService.findIdProducts(cartApi.getProducts());
			List<Product> oldProducts=cart.getProducts();
			List<Product> newProducts=oldProducts.stream().filter(p ->productsToDelete.stream().noneMatch(p::equals)).collect(Collectors.toList());
			
			List<Float> infoPrices = totalPrice(newProducts);
			
			cart.setProducts(newProducts);
			cart.setTotalPrice(infoPrices.get(0));
			cart.setDate(cartApi.getDate());
			cart.setDiscount(infoPrices.get(1).intValue());		

			cartRepository.save(cart);
		} catch (Exception e) {
			throw new TransactionException(CartEnum.UPDATE_ERROR.getCode(), CartEnum.UPDATE_ERROR.getDescription());
		}	
		
	}

}
