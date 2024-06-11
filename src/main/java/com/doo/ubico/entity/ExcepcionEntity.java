package com.doo.ubico.entity;

import java.time.LocalDateTime;

import com.doo.ubico.crosscutting.helpers.NumericHelper;
import com.doo.ubico.crosscutting.helpers.ObjectHelper;

public final class ExcepcionEntity {
	private int id;
	private LocalDateTime fecha;
	private LocalDateTime HoraInicio;
	private LocalDateTime HoraFin;
	private AulaEntity aula;
	private MotivoNoDisponibilidadEntity motivo;

	private ExcepcionEntity(final int id) {
		setId(id);
		setMotivo(MotivoNoDisponibilidadEntity.build());
		setFecha(LocalDateTime.now());
		setHoraInicio(LocalDateTime.now());
		setHoraFin(LocalDateTime.now());
	}

	public ExcepcionEntity(final int id, final String nombre) {

	}

	public static final ExcepcionEntity build(final int id) {
		return new ExcepcionEntity(id);
	}

	public static final ExcepcionEntity build(final int id, final String nombre) {
		return new ExcepcionEntity(id, nombre);
	}

	protected static final ExcepcionEntity build() {
		return new ExcepcionEntity(NumericHelper.ZERO);
	}

	public final AulaEntity getAula() {
		return aula;
	}

	public final LocalDateTime getFecha() {
		return fecha;
	}

	public final LocalDateTime getHoraFin() {
		return HoraFin;
	}

	public final LocalDateTime getHoraInicio() {
		return HoraInicio;
	}

	public final int getId() {
		return id;
	}

	public final MotivoNoDisponibilidadEntity getMotivo() {
		return motivo;
	}

	private final AulaEntity setAula(final AulaEntity aula) {
		this.aula = ObjectHelper.getObjectHelper().getDefault(aula, AulaEntity.build());
		return aula;
	}

	private final LocalDateTime setFecha(LocalDateTime fecha) {
		this.fecha = LocalDateTime.now();
		return fecha;
	}

	private final LocalDateTime setHoraFin(LocalDateTime horaFin) {
		// HoraFin = TextHelper.getHour(horaFin);
		return null;
	}

	private final LocalDateTime setHoraInicio(LocalDateTime horaInicio) {
//		HoraInicio = TextHelper.getHoraDefecto();
//		return HoraInicio;
		return null;
	}

	private final int setId(int id) {
		this.id = id;
		return id;
	}

	private final MotivoNoDisponibilidadEntity setMotivo(final MotivoNoDisponibilidadEntity motivo) {
		this.motivo = ObjectHelper.getObjectHelper().getDefault(motivo, MotivoNoDisponibilidadEntity.build());
		return motivo;
	}

}
