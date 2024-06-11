package com.doo.ubico.api.response;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {
	
	private List<String> mensajes = new ArrayList<>();
	private List<T> datos;
	public List<String> getMensajes() {
		return mensajes;
	}
	public void setMensajes(List<String> mensajes) {
		this.mensajes = mensajes;
	}
	public List<T> getDatos() {
		return datos;
	}
	public void setDatos(List<T> datos) {
		this.datos = datos;
	}
	
	
	

}
