package com.doo.ubico.entity;

import com.doo.ubico.crosscutting.helpers.NumericHelper;
import com.doo.ubico.crosscutting.helpers.TextHelper;

public final class TipoAulaEntity {
	private int id;
	private String nombre;

	public TipoAulaEntity(final int id, final String nombre) {
		setId(id);
		setNombre(TextHelper.EMPTY);

	}

	private TipoAulaEntity(final int id) {
		this.id = id;
		setNombre(TextHelper.EMPTY);
	}

	public static final TipoAulaEntity build(final int id) {
		return new TipoAulaEntity(id);
	}

	public static final TipoAulaEntity build(final int id, final String nombre) {
		return new TipoAulaEntity(id, nombre);
	}

	protected static final TipoAulaEntity build() {
		return new TipoAulaEntity(NumericHelper.ZERO);
	}

	public static final TipoAulaEntity build(String nombre) {
		return new TipoAulaEntity(NumericHelper.ZERO, nombre);
	}

	public final int getId() {
		return id;
	}

	public final String getNombre() {
		return nombre;
	}

	private final void setId(final int id) {
		this.id = id;
	}

	private final void setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}
}
