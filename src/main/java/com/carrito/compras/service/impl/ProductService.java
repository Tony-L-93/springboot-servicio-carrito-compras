package com.carrito.compras.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrito.compras.api.ProductApi;
import com.carrito.compras.dto.ProductDTO;
import com.carrito.compras.mapper.Mapper;
import com.carrito.compras.model.Product;
import com.carrito.compras.repository.ProductRepository;
import com.carrito.compras.service.generic.ProductServiceGeneric;

@Service
public class ProductService implements ProductServiceGeneric<ProductApi, ProductDTO> {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void create(ProductApi productApi) {
		Product product = Mapper.mapperToProduct(productApi);
		productRepository.save(product);

	}
	
	public List<ProductDTO> findAll() {
		return Mapper.mapperToProductsDTO(productRepository.findAll());
	}

	public List<Product> findIdProducts(List<Long> products) {
		List<Product> productList = new ArrayList<>();
		for (Long id : products) {
			productList.add(productRepository.findById(id).get());
		}

		return productList;
	}

}
