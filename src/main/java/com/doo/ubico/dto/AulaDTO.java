package com.doo.ubico.dto;

import com.doo.ubico.crosscutting.helpers.ObjectHelper;
import com.doo.ubico.crosscutting.helpers.TextHelper;

public class AulaDTO {

	private int id;
	private String nombre;
	private int capacidad;
	private BloqueDTO bloque;
	private TipoAulaDTO tipoAula;

	public AulaDTO() {
		setNombre(TextHelper.EMPTY);

	}

	public static final AulaDTO build() {
		return new AulaDTO();
	}

	public AulaDTO(final int id, final String nombre, final int capacidad, final BloqueDTO bloque,
			final TipoAulaDTO tipoAula) {
		setId(id);
		setNombre(nombre);
		setBloque(bloque);
		setCapacidad(capacidad);
		setTipoAula(tipoAula);
	}

	public final int getId() {
		return id;
	}

	public final AulaDTO setId(int id) {
		this.id = id;
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public AulaDTO setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

	public final BloqueDTO getBloque() {
		return bloque;
	}

	public AulaDTO setBloque(BloqueDTO bloque) {
		this.bloque = ObjectHelper.getObjectHelper().getDefault(bloque, BloqueDTO.build());
		return this;

	}

	public final int getCapacidad() {
		return id;
	}

	public final AulaDTO setCapacidad(int capacidad) {
		this.capacidad = capacidad;
		return this;
	}

	public final TipoAulaDTO getTipoAula() {
		return tipoAula;
	}

	public AulaDTO setTipoAula(TipoAulaDTO tipoAula) {
		this.tipoAula = ObjectHelper.getObjectHelper().getDefault(tipoAula, TipoAulaDTO.build());
		return this;

	}

}
