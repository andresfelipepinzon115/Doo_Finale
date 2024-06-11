package com.doo.ubico.dto;

import com.doo.ubico.crosscutting.helpers.TextHelper;

public class MotivoNoDisponibilidadDTO {
	private int id;
	private String nombre;

	public MotivoNoDisponibilidadDTO(final int id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}

	public MotivoNoDisponibilidadDTO() {
		setNombre(TextHelper.EMPTY);
	}

	public static final MotivoNoDisponibilidadDTO build() {
		return new MotivoNoDisponibilidadDTO();
	}

	public final int getId() {
		return id;
	}

	public final MotivoNoDisponibilidadDTO setId(final int id) {
		this.id = id;
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final MotivoNoDisponibilidadDTO setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

}
