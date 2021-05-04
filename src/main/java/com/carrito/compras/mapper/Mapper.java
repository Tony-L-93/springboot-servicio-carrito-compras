package com.carrito.compras.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.carrito.compras.api.CartApi;
import com.carrito.compras.api.ProductApi;
import com.carrito.compras.api.PromotionApi;
import com.carrito.compras.api.UserApi;
import com.carrito.compras.dto.CartDTO;
import com.carrito.compras.dto.ProductDTO;
import com.carrito.compras.dto.UserDTO;
import com.carrito.compras.enumerator.CartStatus;
import com.carrito.compras.model.Cart;
import com.carrito.compras.model.Product;
import com.carrito.compras.model.Promotion;
import com.carrito.compras.model.User;

@Component
public class Mapper {
	private static ModelMapper modelMapper = new ModelMapper();

	public static Product mapperToProduct(ProductApi productApi) {
		return modelMapper.map(productApi, Product.class);
	}

	public static Product mapperToProduct(ProductDTO productDTO) {
		return modelMapper.map(productDTO, Product.class);
	}

	private static ProductDTO mapperToProductDTO(Product product) {
		return modelMapper.map(product, ProductDTO.class);
	}

	public static ProductApi mapperToProductApi(Product product) {
		return modelMapper.map(product, ProductApi.class);
	}

	public static CartDTO mapperToCartDTO(Cart cart) {
		CartDTO cartDTO = modelMapper.map(cart, CartDTO.class);
		cartDTO.setStatus(cart.getStatus().toString());
		cartDTO.setProducts(mapperToProductsDTO(cart.getProducts()));
		return cartDTO;
	}

	public static Cart mapperToCart(CartApi cartApi) {
		Cart cart = modelMapper.map(cartApi, Cart.class);
		return cart;
	}

	private static CartStatus mapperToEnum(String status) {
		return modelMapper.map(CartStatus.valueOf(status), CartStatus.class);
	}

	public static List<ProductDTO> mapperToProductsDTO(List<Product> products) {
		List<ProductDTO> productDTOList = new ArrayList<>();
		products.stream().forEach(p -> productDTOList.add(mapperToProductDTO(p)));
		return productDTOList;
	}

	public static List<CartDTO> mapperToCartsDTO(List<Cart> carts) {
		List<CartDTO> cartDTOList = new ArrayList<>();
		carts.stream().forEach(p -> cartDTOList.add(mapperToCartDTO(p)));
		return cartDTOList;
	}

	public static User mapperToUser(UserApi userApi) {
		User user=modelMapper.map(userApi, User.class);
		return user;
	}

	public static UserApi mapperToUserApi(User user) {
		UserApi userApi=modelMapper.map(user, UserApi.class);
		return userApi;
	}

	public static List<UserDTO> mapperToUsersApi(List<User> users) {
		List<UserDTO> userDTOList = new ArrayList<>();
		users.stream().forEach(p -> userDTOList.add(mapperToUsertDTO(p)));
		return userDTOList;
	}

	public static UserDTO mapperToUsertDTO(User user) {
		UserDTO userDTO = modelMapper.map(user, UserDTO.class);
		userDTO.setCart(mapperToCartsDTO(user.getCart()));
		return userDTO;
	}

	public static Promotion mapperToPromotion(PromotionApi promotionApi) {
		return modelMapper.map(promotionApi, Promotion.class);
	}
	
}
