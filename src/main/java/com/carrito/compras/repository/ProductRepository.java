package com.carrito.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrito.compras.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
