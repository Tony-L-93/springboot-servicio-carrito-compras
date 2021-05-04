package com.carrito.compras.utils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.carrito.compras.enumerator.CartStatus;
import com.carrito.compras.model.Cart;
import com.carrito.compras.model.Product;
import com.carrito.compras.model.Promotion;
import com.carrito.compras.model.User;
import com.carrito.compras.repository.UserRepository;


public class InitialLoad {
	
	@Autowired
	private static UserRepository userRepository;

	public static List<Product> createProduct() {
		Product product1 = new Product();
		Product product2 = new Product();
		Product product3 = new Product();
		Product product4 = new Product();
		Product product5 = new Product();
		Product product6 = new Product();
		Product product7 = new Product();
		Product product8 = new Product();
		Product product9 = new Product();
		Product product10 = new Product();
		Product product11 = new Product();
		Product product12 = new Product();

		product1.setTitle("Coca Cola");
		product1.setDescription("Coca Cola 1.5 lts");
		product1.setPrice((float) 75.25);

		product2.setTitle("Sprite");
		product2.setDescription("Sprite 1.5 lts");
		product2.setPrice((float) 75.25);

		product3.setTitle("Potato Crisps");
		product3.setDescription("Papas fritas en tubo sabor crema y cebolla");
		product3.setPrice((float) 150);

		product4.setTitle("Potato Crisps");
		product4.setDescription("Papas fritas en tubo sabor babarcoa");
		product4.setPrice((float) 150);

		product5.setTitle("Potato Crisps");
		product5.setDescription("Papas fritas en tubo sabor original");
		product5.setPrice((float) 150);

		product6.setTitle("Manaos");
		product6.setDescription("Manaos Manzana 2 lts");
		product6.setPrice((float) 60);

		product7.setTitle("Fernet Branca");
		product7.setDescription("Brnca de 750 ml");
		product7.setPrice((float) 380.50);

		product8.setTitle("Gancia");
		product8.setDescription("Gancia Americano 1l");
		product8.setPrice((float) 250);

		product9.setTitle("Churros");
		product9.setDescription("12 unidades");
		product9.setPrice((float) 250);

		product10.setTitle("Facturas");
		product10.setDescription("12 unidades");
		product10.setPrice((float) 180);

		product11.setTitle("Champiñones");
		product11.setDescription("150 grs");
		product11.setPrice((float) 150);

		product12.setTitle("Lomito");
		product12.setDescription("100 grs");
		product12.setPrice((float) 90);

		return Arrays.asList(product1, product2, product3, product4, product5, product6, product7, product8, product9,
				product10, product11, product12);
	}
	
	public static List<User> createUser() {
		User user1=new User();
		User user2=new User();
		User user3=new User();
		
		
		user1.setName("Tony");
		user1.setSurname("Liendro");
		user1.setEmail("tony@gmail.com");
		user1.setCellPhone("1578962589");
		
		
		user2.setName("Sole");
		user2.setSurname("Leyes");
		user2.setEmail("sole@gmail.com");
		user2.setCellPhone("1578962698");
		
		
		user3.setName("Matias");
		user3.setSurname("Gomez");
		user3.setEmail("matias@gmail.com");
		user3.setCellPhone("1578961587");
		
		
		return Arrays.asList(user1,user2,user3);
	}
	
	public static List<Promotion> createPromotion() {
		Promotion promotion=new Promotion();
		
		promotion.setId(Long.valueOf(1000));
		promotion.setStartDate(LocalDate.of(2021, 5, 1));
		promotion.setEndDate(LocalDate.of(2021, 5, 30));
		
		return Arrays.asList(promotion);
		
	}
	
	public static List<Cart> createCart() {
		Cart cart1=new Cart();
		Cart cart2=new Cart();
		Cart cart3=new Cart();
		Cart cart4=new Cart();
		Cart cart5=new Cart();
		
		cart1.setDate(LocalDate.of(2021, 5, 1));
		cart1.setStatus(CartStatus.COMPLETE);
		cart1.setUserId(52);
		
		cart2.setDate(LocalDate.of(2021, 5, 2));
		cart2.setStatus(CartStatus.COMPLETE);
		cart2.setUserId(52);
		
		cart3.setDate(LocalDate.of(2021, 4, 2));
		cart3.setStatus(CartStatus.COMPLETE);
		cart3.setUserId(53);
		
		cart4.setDate(LocalDate.of(2021, 5, 4));
		cart4.setStatus(CartStatus.COMPLETE);
		cart4.setUserId(53);
		
		cart5.setDate(LocalDate.of(2021, 3, 4));
		cart5.setStatus(CartStatus.COMPLETE);
		cart5.setUserId(52);
		
		return Arrays.asList(cart1,cart2,cart3,cart4,cart5);
		
	}

}
