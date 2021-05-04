package com.carrito.compras.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrito.compras.api.CartApi;
import com.carrito.compras.api.CartApiUpdate;
import com.carrito.compras.dto.CartDTO;
import com.carrito.compras.enumerator.CartEnum;
import com.carrito.compras.enumerator.CartStatus;
import com.carrito.compras.exception.TransactionException;
import com.carrito.compras.mapper.Mapper;
import com.carrito.compras.model.Cart;
import com.carrito.compras.model.Product;
import com.carrito.compras.repository.CartRepository;
import com.carrito.compras.repository.ProductRepository;
import com.carrito.compras.repository.PromotionRepository;
import com.carrito.compras.repository.UserRepository;
import com.carrito.compras.service.generic.ServiceGeneric;
import com.carrito.compras.utils.Calculates;

@Service
public class CartService implements ServiceGeneric<CartApi, CartDTO> {
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private PromotionRepository promotionRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;

	public void create(String userId) throws TransactionException {
		try {	
			Cart cart = new Cart();
			cart.setStatus(CartStatus.OPEN);
			cart.setDate(LocalDate.now());
			cart.setUserId(Integer.valueOf(userId));
			cartRepository.save(cart);
		} catch (Exception e) {
			throw new TransactionException(CartEnum.CREATE_ERROR.getCode(), CartEnum.CREATE_ERROR.getDescription());
		}
	}
	
	public void createDB(Cart cart) {
		cartRepository.save(cart);
	}

	@Override
	public CartDTO getById(String id) throws TransactionException {
		Cart cart = findById(id);
		return Mapper.mapperToCartDTO(cart);
	}

	public Cart findById(String id) throws TransactionException {

		Optional<Cart> optional = cartRepository.findById(Long.parseLong(id));

		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new TransactionException(CartEnum.GET_ERROR.getCode(), CartEnum.GET_ERROR.getDescription());
		}
	}

	public void updateCart(String userId,String cartId, CartApiUpdate cartApi) throws TransactionException {
			LocalDate starPromotion=promotionRepository.getOne((long) 102).getStartDate();
			LocalDate endPromotion=promotionRepository.getOne((long) 102).getEndDate();
			
		try {
			Cart cart = findById(cartId);
			List<Product> products = productService.findIdProducts(cartApi.getProducts());
			
			if(!cart.getStatus().equals(CartStatus.COMPLETE)) {
				List<Cart> userCarts=cartRepository.findAll().stream().
						filter(p->p.getUserId().equals(Integer.valueOf(userId))).
						filter(p->p.getTotalPrice() !=null).
						filter(p->p.getStatus().equals(CartStatus.COMPLETE)).collect(Collectors.toList());
				if(!userCarts.isEmpty()){
					List<Cart> currentMonthCarts= userCarts.stream().
							filter(p->p.getUserId().equals(Integer.valueOf(userId))).
							filter(p-> p.getDate().isAfter(starPromotion) || p.getDate().equals(starPromotion)).
							filter(p-> p.getDate().isBefore(endPromotion)|| p.getDate().equals(endPromotion)).
							collect(Collectors.toList());
					Double totalSpent=currentMonthCarts.stream().mapToDouble(p->p.getTotalPrice()).sum();
					List<Float> infoPrices = Calculates.totalPricePromotion(products,totalSpent);
					cart.setProducts(products);
					cart.setTotalPrice(infoPrices.get(0));
					cart.setDiscount(infoPrices.get(1).intValue());
				}
				else {
					List<Float> infoPrices = Calculates.totalPrice(products);
					cart.setProducts(products);
					cart.setTotalPrice(infoPrices.get(0));
					cart.setDiscount(infoPrices.get(1).intValue());
				}
			}
			else {
				List<Float> infoPrices = Calculates.totalPrice(products);
				cart.setProducts(products);
				cart.setTotalPrice(infoPrices.get(0));
				cart.setDiscount(infoPrices.get(1).intValue());
			}
			
			cartRepository.save(cart);
			userService.addCart(userId, cartId);
		} catch (Exception e) {
			throw new TransactionException(CartEnum.UPDATE_ERROR.getCode(), CartEnum.UPDATE_ERROR.getDescription());
		}

	}

	@Override
	public void delete(String id) throws TransactionException {
		Cart cart = findById(id);
		if(cart.getProducts()==null) {
			cartRepository.deleteById(Long.valueOf(id));
		}
		else {
			try {
			cart.getProducts().clear();
			userService.cleanCart(cart.getUserId().toString(), cart.getId().toString());
			cartRepository.deleteById(Long.valueOf(id));
			} catch (Exception e) {
			throw new TransactionException(CartEnum.UPDATE_ERROR.getCode(), CartEnum.UPDATE_ERROR.getDescription());
			}
		}
	}

	public List<CartDTO> findAll() {
		return Mapper.mapperToCartsDTO(cartRepository.findAll());
	}

	public void addProducts(String userId,String cartId, CartApiUpdate cartApi) throws TransactionException {

		Cart cart = findById(cartId);
		try {

			List<Product> products = productService.findIdProducts(cartApi.getProducts());
			List<Product> newProductsList = cart.getProducts();
			newProductsList.addAll(products);

			List<Float> infoPrices = Calculates.totalPrice(newProductsList);

			cart.setProducts(newProductsList);
			cart.setTotalPrice(infoPrices.get(0));
			cart.setDiscount(infoPrices.get(1).intValue());

			cartRepository.save(cart);
			userService.updateCart(userId, cartId,cart);
		} catch (Exception e) {
			throw new TransactionException(CartEnum.UPDATE_ERROR.getCode(), CartEnum.UPDATE_ERROR.getDescription());
		}
	}

	public void delProducts(String userId,String cartId, CartApiUpdate cartApi) throws TransactionException {
		Cart cart = findById(cartId);
		try {

			List<Product> productsToDelete = productService.findIdProducts(cartApi.getProducts());
			List<Product> oldProducts = cart.getProducts();
			List<Product> newProducts = oldProducts.stream().filter(p -> productsToDelete.stream().noneMatch(p::equals))
					.collect(Collectors.toList());

			List<Float> infoPrices = Calculates.totalPrice(newProducts);

			cart.setProducts(newProducts);
			cart.setTotalPrice(infoPrices.get(0));
			cart.setDiscount(infoPrices.get(1).intValue());
			cartRepository.save(cart);
			userService.updateCart(userId, cartId,cart);
		} catch (Exception e) {
			throw new TransactionException(CartEnum.UPDATE_ERROR.getCode(), CartEnum.UPDATE_ERROR.getDescription());
		}

	}

	@Override
	public void update(String id, CartApi entity) throws TransactionException {
	}

	@Override
	public void create(CartApi entity) throws TransactionException {
		
	}

	public List<Cart> findAllEntitys() {
		return cartRepository.findAll();
	}

}
