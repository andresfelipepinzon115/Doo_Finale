package com.doo.ubico.dto;

import com.doo.ubico.crosscutting.helpers.ObjectHelper;
import com.doo.ubico.crosscutting.helpers.TextHelper;
import com.doo.ubico.entity.AulaEntity;

import java.time.LocalDateTime;

public class ExcepcionDTO {

    private int id;
    private String nombre;
    private MotivoNoDisponibilidadDTO motivo;
    private LocalDateTime fecha;
    private String HoraInicio;
    private String HoraFin;
    private AulaDTO aula;


    public ExcepcionDTO(final int id, final String nombre, final MotivoNoDisponibilidadDTO motivo, final LocalDateTime fecha, final String HoraInicio, final String HoraFin, final AulaDTO aula) {
        setId(id);
        setMotivo(motivo);
        setFecha(fecha);
        setHoraInicio(HoraInicio);
        setHoraFin(HoraFin);
        setAula(aula);
    }

    public ExcepcionDTO() {
        setId(id);
        setMotivo(MotivoNoDisponibilidadDTO.build());
        setFecha(LocalDateTime.now());
        setHoraInicio(HoraInicio);
        setHoraFin(HoraFin);

    }

    public final AulaDTO getAula() {
        return aula;
    }

    public final LocalDateTime getFecha() {
        return fecha;
    }

    public final  String getHoraFin() {
        return HoraFin;
    }

    public final String getHoraInicio() {
        return HoraInicio;
    }

    public final int getId() {
        return id;
    }

    public final MotivoNoDisponibilidadDTO getMotivo() {
        return motivo;
    }

    private final  ExcepcionDTO setAula( final AulaDTO aula) {
        this.aula = ObjectHelper.getObjectHelper().getDefault(aula, AulaDTO.build());
        return this;
    }

    private final  LocalDateTime setFecha(LocalDateTime fecha) {
        this.fecha = LocalDateTime.now();
        return fecha;
    }

    private final  String setHoraFin(String horaFin) {
        HoraFin = TextHelper.getHour();
        return HoraFin;
    }

    private final  String setHoraInicio(String horaInicio) {
        HoraInicio = TextHelper.getHour();
        return HoraInicio;
    }

    private final  int setId(int id) {
        this.id = id;
        return id;
    }

    private final ExcepcionDTO setMotivo(final MotivoNoDisponibilidadDTO motivo) {
        this.motivo = ObjectHelper.getObjectHelper().getDefault(motivo, MotivoNoDisponibilidadDTO.build());
        return this;
    }

}
