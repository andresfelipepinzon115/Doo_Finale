package com.doo.ubico.crosscutting.exception.messagecatalog;

import com.doo.ubico.crosscutting.exception.UbicoException;
import com.doo.ubico.crosscutting.exception.custom.CrosscuttingUbicoException;
import com.doo.ubico.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import com.doo.ubico.crosscutting.exception.messagecatalog.data.Mensaje;
import com.doo.ubico.crosscutting.exception.messagecatalog.impl.MessageCatalogBase;
import com.doo.ubico.crosscutting.exception.messagecatalog.impl.MessageCatalogExternalService;
import com.doo.ubico.crosscutting.helpers.ObjectHelper;

public final class MessageCatalogStrategy {

	private static final MessageCatalog base = new MessageCatalogBase();
	private static final MessageCatalog externalService = new MessageCatalogExternalService();

	static {
		inicializar();
	}

	private MessageCatalogStrategy() {
		super();
	}

	public static void inicializar() {
		base.inicializar();
		externalService.inicializar();
	}

	private static final MessageCatalog getStrategy(final boolean isBase) {
		return isBase ? base : externalService;
	}

	public static final Mensaje getMensaje(final CodigoMensaje codigo, final String... parametros) {

		if (ObjectHelper.getObjectHelper().isNull(codigo)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00001);
			throw new CrosscuttingUbicoException(mensajeTecnico, mensajeUsuario);
		}
		
		return getStrategy(codigo.isBase()).obtenerMensaje(codigo, parametros);
	}

	public static final String getContenidoMensaje(final CodigoMensaje codigo, final String... parametros) {
		return getMensaje(codigo, parametros).getContenido();
	}

	public static void main(String[] args) {
		// System.out.println(getContenidoMensaje(CodigoMensaje.M00008));
	}

}
