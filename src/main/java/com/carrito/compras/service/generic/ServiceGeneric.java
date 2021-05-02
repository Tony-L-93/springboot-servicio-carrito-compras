package com.carrito.compras.service.generic;

import com.carrito.compras.exception.TransactionException;

public interface ServiceGeneric<T, S> {

	public void create(T entity) throws TransactionException;

	public S getById(String id) throws TransactionException;


	public void delete(String id) throws TransactionException;

	public void update(String id,T entity) throws TransactionException;
}