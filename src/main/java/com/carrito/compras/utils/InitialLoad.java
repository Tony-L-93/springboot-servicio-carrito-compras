package com.carrito.compras.utils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.carrito.compras.enumerator.CartStatus;
import com.carrito.compras.model.Cart;
import com.carrito.compras.model.Product;
import com.carrito.compras.model.Promotion;
import com.carrito.compras.model.User;

public class InitialLoad {

	public static List<Product> createProduct() {
		Product product1 = Product.builder().title("Coca Cola").description("Coca Cola 1.5 lts").price((float) 90)
				.build();
		Product product2 = Product.builder().title("Sprite").description("Sprite 1.5 lts").price((float) 80).build();
		Product product3 = Product.builder().title("Potato Crisps")
				.description("Papas fritas en tubo sabor crema y cebolla").price((float) 150).build();
		Product product4 = Product.builder().title("Potato Crisps").description("Papas fritas en tubo sabor babarcoa")
				.price((float) 150).build();
		Product product5 = Product.builder().title("Potato Crisps").description("Papas fritas en tubo sabor original")
				.price((float) 150).build();
		Product product6 = Product.builder().title("Manaos").description("Manaos Manzana 2 lts").price((float) 60)
				.build();
		Product product7 = Product.builder().title("Fernet Branca").description("Branca de 750 ml").price((float) 400)
				.build();
		Product product8 = Product.builder().title("Gancia").description("Gancia Americano 1l").price((float) 260)
				.build();
		Product product9 = Product.builder().title("Churros").description("12 unidades").price((float) 330).build();
		Product product10 = Product.builder().title("Facturas").description("12 unidades").price((float) 250).build();
		Product product11 = Product.builder().title("Shampoo").description("Head&Shoulder").price((float) 350).build();
		Product product12 = Product.builder().title("Crema de Enjuage").description("Head&Shoulder").price((float) 350)
				.build();

		return Arrays.asList(product1, product2, product3, product4, product5, product6, product7, product8, product9,
				product10, product11, product12);
	}

	public static List<User> createUser() {
		User user1 = User.builder().name("Tony").surname("Liendro").email("tony@gmail.com").cellPhone("1578962589")
				.build();
		User user2 = User.builder().name("Sole").surname("Leyes").email("sole@gmail.com").cellPhone("157895283")
				.build();
		User user3 = User.builder().name("Matias").surname("Gomez").email("matias@gmail.com").cellPhone("158895283")
				.build();

		return Arrays.asList(user1, user2, user3);
	}

	public static List<Promotion> createPromotion() {
		Promotion promotion = Promotion.builder().startDate(LocalDate.of(2021, 5, 1)).endDate(LocalDate.of(2021, 5, 30))
				.build();

		return Arrays.asList(promotion);

	}

	public static List<Cart> createCart() {
		Cart cart1 = Cart.builder().date(LocalDate.of(2021, 5, 1)).status(CartStatus.COMPLETE).userId(1000).build();

		Cart cart2 = Cart.builder().date(LocalDate.of(2021, 5, 2)).status(CartStatus.COMPLETE).userId(1000).build();
		Cart cart3 = Cart.builder().date(LocalDate.of(2021, 4, 1)).status(CartStatus.COMPLETE).userId(1000).build();
		Cart cart4 = Cart.builder().date(LocalDate.of(2021, 3, 25)).status(CartStatus.COMPLETE).userId(1000).build();
		Cart cart5 = Cart.builder().date(LocalDate.of(2021, 5, 4)).status(CartStatus.COMPLETE).userId(1000).build();

		return Arrays.asList(cart1, cart2, cart3, cart4, cart5);
	}

}
