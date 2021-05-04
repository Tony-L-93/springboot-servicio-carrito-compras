package com.carrito.compras;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.carrito.compras.exception.TransactionException;
import com.carrito.compras.mapper.Mapper;
import com.carrito.compras.service.impl.CartService;
import com.carrito.compras.service.impl.ProductService;
import com.carrito.compras.service.impl.PromotionService;
import com.carrito.compras.service.impl.UserService;
import com.carrito.compras.utils.InitialLoad;

@SpringBootApplication
@EnableScheduling
public class SpringbootServicioCarritocomprasApplication {

	@Value(value = "")
	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioCarritocomprasApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init(final ProductService productService, final UserService userService, final PromotionService promotionService,final CartService cartService) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				
				if(productService.findAll().size()==0) {
					InitialLoad.createProduct().stream().forEach(p->productService.create(Mapper.mapperToProductApi(p)));
				}
	
				if(userService.findAll().size()==0) {
					InitialLoad.createUser().stream().forEach(p->userService.create(Mapper.mapperToUserApi(p)));
				}
				
				if(promotionService.findAll().size()==0) {
					InitialLoad.createPromotion().stream().forEach(p->promotionService.create(Mapper.mapperToPromotion(p)));
				}

				if(cartService.findAll().size()==0) {
					InitialLoad.createCart().stream().forEach(p->cartService.createDB(p));
				}
				
			}
		};
	}

}
