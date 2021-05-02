package com.carrito.compras;

import java.awt.GraphicsEnvironment;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.carrito.compras.mapper.Mapper;
import com.carrito.compras.service.impl.ProductService;
import com.carrito.compras.utils.InitialLoad;

@SpringBootApplication
public class SpringbootServicioCarritocomprasApplication {

	@Value("${database.url")
	private String url;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioCarritocomprasApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init(final ProductService productService) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				String[] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
				System.out.println(Arrays.toString(fontNames));
				
				System.out.println("Url *****"+url);
				if(productService.findAll().size()==0) {
					InitialLoad.createProduct().stream().forEach(p->productService.create(Mapper.mapperToProductApi(p)));
				}
				
			}
		};
	}

}
