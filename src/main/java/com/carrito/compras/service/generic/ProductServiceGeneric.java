package com.carrito.compras.service.generic;

import com.carrito.compras.exception.TransactionException;

public interface ProductServiceGeneric<T, S> {

	public void create(T productApi) throws TransactionException;

}