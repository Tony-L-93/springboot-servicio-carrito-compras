package com.carrito.compras.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.carrito.compras.api.ProductApi;
import com.carrito.compras.dto.ProductDTO;
import com.carrito.compras.model.Product;

@Component
public class Mapper {
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static Product mapperToProduct(ProductApi productApi) {
		return modelMapper.map(productApi, Product.class);
	}
	
	public static Product mapperToProduct(ProductDTO productDTO) {
		return modelMapper.map(productDTO, Product.class);
	}

}
