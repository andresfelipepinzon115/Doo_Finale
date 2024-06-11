package com.doo.ubico.crosscutting.exception.messagecatalog;

import 	com.doo.ubico.crosscutting.exception.messagecatalog.data.*;

public interface MessageCatalog {

	void inicializar();

	String obtenerContenidoMensaje(final CodigoMensaje codigo, String... parametros);

	Mensaje obtenerMensaje(final CodigoMensaje codigo, String... parametros);
}