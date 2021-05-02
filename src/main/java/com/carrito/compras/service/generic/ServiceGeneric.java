package com.carrito.compras.service.generic;

public interface ServiceGeneric <T, S>{

	public void create(T entity);
	
	public S getById(String id);
	
	public void update(T entity);
	
	public void delete(String id);
}