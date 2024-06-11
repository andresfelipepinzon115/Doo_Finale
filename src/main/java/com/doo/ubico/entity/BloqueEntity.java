package com.doo.ubico.entity;

import com.doo.ubico.crosscutting.helpers.NumericHelper;
import com.doo.ubico.crosscutting.helpers.TextHelper;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
@NoArgsConstructor
@Table(name = "Bloque")
public final class BloqueEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre", nullable = false, length = 100)
	@Size(min = 5, max = 100, message = "El nombre debe tener entre 5 y 100 caracteres")
	private String nombre;

	public BloqueEntity(final int id, final String nombre) {
		setId(id);
		setNombre(TextHelper.EMPTY);
	}

	private BloqueEntity(final int id) {
		this.id = id;
		setNombre(TextHelper.EMPTY);
	}

	public static BloqueEntity build(final int id) {
		return new BloqueEntity(id);
	}

	public static BloqueEntity build(final int id, final String nombre) {
		return new BloqueEntity(id, nombre);
	}

	public static BloqueEntity build(String nombre) {
		return new BloqueEntity(NumericHelper.ZERO, nombre);
	}

	static BloqueEntity build() {
		return new BloqueEntity(NumericHelper.ZERO);
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
