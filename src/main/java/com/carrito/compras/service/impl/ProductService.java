package com.carrito.compras.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrito.compras.api.ProductApi;
import com.carrito.compras.dto.ProductDTO;
import com.carrito.compras.mapper.Mapper;
import com.carrito.compras.model.Product;
import com.carrito.compras.repository.ProductRepository;
import com.carrito.compras.service.generic.ServiceGeneric;

@Service
public class ProductService implements ServiceGeneric<ProductApi, ProductDTO> {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void create(ProductApi productApi) {
		Product product = Mapper.mapperToProduct(productApi);
		productRepository.save(product);

	}

	@Override
	public ProductDTO getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ProductApi entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

}
