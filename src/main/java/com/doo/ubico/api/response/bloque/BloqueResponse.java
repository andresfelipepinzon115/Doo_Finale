package com.doo.ubico.api.response.bloque;

import java.util.ArrayList;
import java.util.List;

import com.doo.ubico.api.response.Response;
import com.doo.ubico.dto.AulaDTO;
import com.doo.ubico.dto.BloqueDTO;



public final class BloqueResponse extends Response<BloqueDTO> {
	
	public static final BloqueResponse  build(List<String> mensaje, final List<BloqueDTO> datos) {
		BloqueResponse  instance = new BloqueResponse();
		instance.setMensajes(mensaje);
		instance.setDatos(datos);
		
		return instance;
	}
	
	public static final BloqueResponse build(final List<BloqueDTO> datos) {
		BloqueResponse instance = new BloqueResponse();
		instance.setDatos(datos);
		
		return instance;
	}
	
	public static final BloqueResponse build() {
		BloqueResponse instance = new BloqueResponse();
		instance.setMensajes(new ArrayList<>());
		instance.setDatos(new ArrayList<>());
		
		return instance;
	}

	


}
