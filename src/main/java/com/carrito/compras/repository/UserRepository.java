package com.carrito.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrito.compras.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
