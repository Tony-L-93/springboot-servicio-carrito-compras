package com.carrito.compras.enumerator;

public enum CartEnum {
	CREATE_OK("CREATED_OK", "Se creó el carrito correctamente"),
	CREATE_ERROR("CREATE_ERROR", "No se pudo crear el carrito correctamente"),
	UPDATE_OK("UPDATE_OK", "Se modificó el carrito correctamente"),
	UPDATE_ERROR("UPDATE_ERROR", "No se pudo modificar el carrito correctamente"),
	DELETE_OK("DELETE_OK", "Se eliminó el carrito correctamente"),
	DELETE_ERROR("DELETE_ERROR", "No se pudo eliminar el carrito correctamente"),
	ALREADY_EXIST("ALREADY_EXIST", "Ya existe el carrito"), 
	GET_ERROR("GET_ERROR", "El carrito no existe");

	private String code;
	private String description;

	CartEnum(String code, String description) {
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
