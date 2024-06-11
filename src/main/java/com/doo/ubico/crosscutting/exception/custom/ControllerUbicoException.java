package com.doo.ubico.crosscutting.exception.custom;

import com.doo.ubico.crosscutting.exception.UbicoException;
import com.doo.ubico.crosscutting.exception.enums.Lugar;

public final class ControllerUbicoException extends UbicoException {

	private static final long serialVersionUID = 1L;
	private static final Lugar lugar = Lugar.CONTROLLER;

	public ControllerUbicoException(final String mensajeUsuario) {
		super(mensajeUsuario, lugar);
	}

	public ControllerUbicoException(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, lugar);
	}

	public ControllerUbicoException(final String mensajeTecnico, final String mensajeUsuario,
			final Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
	}
}
