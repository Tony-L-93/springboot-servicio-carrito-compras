package com.carrito.compras.enumerator;

public enum UserEnum {
	CREATE_OK("CREATED_OK", "Se creó el usuario correctamente"),
	CREATE_ERROR("CREATE_ERROR", "No se pudo crear el usuario correctamente"),
	UPDATE_OK("UPDATE_OK", "Se modificó el usuario correctamente"),
	UPDATE_ERROR("UPDATE_ERROR", "No se pudo modificar el usuario correctamente"),
	DELETE_OK("DELETE_OK", "Se eliminó el usuario correctamente"),
	DELETE_ERROR("DELETE_ERROR", "No se pudo eliminar el usuario correctamente"),
	ALREADY_EXIST("ALREADY_EXIST", "Ya existe el usuario"), 
	GET_ERROR("GET_ERROR", "El usuario no existe");

	private String code;
	private String description;

	UserEnum(String code, String description) {
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
