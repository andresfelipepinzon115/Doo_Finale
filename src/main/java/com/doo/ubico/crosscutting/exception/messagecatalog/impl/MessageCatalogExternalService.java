
package com.doo.ubico.crosscutting.exception.messagecatalog.impl;


import com.doo.ubico.crosscutting.exception.custom.CrosscuttingUbicoException;
import com.doo.ubico.crosscutting.exception.messagecatalog.MessageCatalog;
import com.doo.ubico.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import com.doo.ubico.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import com.doo.ubico.crosscutting.exception.messagecatalog.data.Mensaje;
import com.doo.ubico.crosscutting.helpers.ObjectHelper;


import java.util.HashMap;
import java.util.Map;

public final class MessageCatalogExternalService implements MessageCatalog {

	private final Map<String, Mensaje> mensajes = new HashMap<>();

	@Override
	public final void inicializar() {
		mensajes.clear();
		mensajes.put(CodigoMensaje.M000023.getIdentificador(),
				new Mensaje(CodigoMensaje.M000023, "Se ha presentado un error implementando un insert del bloque \"${1}\" en la tabla de \"bloque\" de la base de datos postgreSQL..."));
		mensajes.put(CodigoMensaje.M000024.getIdentificador(),
				new Mensaje(CodigoMensaje.M000024, "Se ha presentado un error tratando de realizar un insert del bloque \"${1}\" en la tabla de \"bloque\" de la base de datos postgreSQL..."));
	}

	@Override
	public final String obtenerContenidoMensaje(final CodigoMensaje codigo, final String... parametros) {
		return obtenerMensaje(codigo, parametros).getContenido();
	}

	@Override
	public final Mensaje obtenerMensaje(CodigoMensaje codigo, final String... parametros) {

		if (ObjectHelper.getObjectHelper().isNull(codigo)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00001);


		}

		if (codigo.isBase()) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00005,
					codigo.getIdentificador());


		}

		if (!mensajes.containsKey(codigo.getIdentificador())) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00006,
					codigo.getIdentificador());


			throw new CrosscuttingUbicoException(mensajeTecnico, mensajeUsuario);
		}



		return mensajes.get(codigo.getIdentificador());
	}

}