package com.carrito.compras.enumerator;

public enum ProductEnum {
	CREATE_OK("CREATED_OK", "Se creó el producto correctamente"),
	CREATE_ERROR("CREATE_ERROR", "No se pudo crear el producto correctamente"),
	UPDATE_OK("UPDATE_OK", "Se modificó el producto correctamente"),
	UPDATE_ERROR("UPDATE_ERROR", "No se pudo modificar el producto correctamente"),
	DELETE_OK("DELETE_OK", "Se eliminó el producto correctamente"),
	DELETE_ERRO("DELETE_ERROR", "No se pudo eliminar el producto correctamente"),
	ALREADY_EXIST("ALREADY_EXIST", "Ya existe el producto"), 
	GET_ERROR("GET_ERROR", "El producto que se intenta buscar no existe");

	private String code;
	private String description;

	ProductEnum(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
}
