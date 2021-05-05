package com.carrito.compras.service.generic;

import com.carrito.compras.exception.TransactionException;

public interface CartServiceGeneric<T, S> {

	public void create(String userId) throws TransactionException;

	public S getById(String id) throws TransactionException;

	public void delete(String id) throws TransactionException;

	public void update(String userId, String cartId, T entity) throws TransactionException;
}