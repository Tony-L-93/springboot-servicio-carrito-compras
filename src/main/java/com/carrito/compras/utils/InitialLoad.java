package com.carrito.compras.utils;

import java.util.Arrays;
import java.util.List;

import com.carrito.compras.model.Product;
import com.carrito.compras.model.User;

public class InitialLoad {

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

		product1.setId(1L);
		product1.setTitle("Coca Cola");
		product1.setDescription("Coca Cola 1.5 lts");
		product1.setPrice((float) 75.25);

		product2.setId(2L);
		product2.setTitle("Sprite");
		product2.setDescription("Sprite 1.5 lts");
		product2.setPrice((float) 75.25);

		product3.setId(3L);
		product3.setTitle("Potato Crisps");
		product3.setDescription("Papas fritas en tubo sabor crema y cebolla");
		product3.setPrice((float) 150);

		product4.setId(4L);
		product4.setTitle("Potato Crisps");
		product4.setDescription("Papas fritas en tubo sabor babarcoa");
		product4.setPrice((float) 150);

		product5.setId(5L);
		product5.setTitle("Potato Crisps");
		product5.setDescription("Papas fritas en tubo sabor original");
		product5.setPrice((float) 150);

		product6.setId(6L);
		product6.setTitle("Manaos");
		product6.setDescription("Manaos Manzana 2 lts");
		product6.setPrice((float) 60);

		product7.setId(7L);
		product7.setTitle("Fernet Branca");
		product7.setDescription("Brnca de 750 ml");
		product7.setPrice((float) 380.50);

		product8.setId(8L);
		product8.setTitle("Gancia");
		product8.setDescription("Gancia Americano 1l");
		product8.setPrice((float) 250);

		product9.setId(9L);
		product9.setTitle("Churros");
		product9.setDescription("12 unidades");
		product9.setPrice((float) 250);

		product10.setId(10L);
		product10.setTitle("Facturas");
		product10.setDescription("12 unidades");
		product10.setPrice((float) 180);

		product11.setId(11L);
		product11.setTitle("Champiñones");
		product11.setDescription("150 grs");
		product11.setPrice((float) 150);

		product12.setId(12L);
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
		
		user1.setId(100L);
		user1.setName("Tony");
		user1.setSurname("Liendro");
		user1.setEmail("tony@gmail.com");
		user1.setCellPhone("1578962589");
		
		user2.setId(101L);
		user2.setName("Sole");
		user2.setSurname("Leyes");
		user2.setEmail("sole@gmail.com");
		user2.setCellPhone("1578962698");
		
		user3.setId(102L);
		user3.setName("Matias");
		user3.setSurname("Gomez");
		user3.setEmail("matias@gmail.com");
		user3.setCellPhone("1578961587");
		
		
		return Arrays.asList(user1,user2,user3);
	}
	

}
