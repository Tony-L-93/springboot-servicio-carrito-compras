package com.carrito.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrito.compras.model.Cart;

public interface CartRepository extends JpaRepository<Cart,Long>{

}
