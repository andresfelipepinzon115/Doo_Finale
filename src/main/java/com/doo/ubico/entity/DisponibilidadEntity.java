package com.doo.ubico.entity;


import com.doo.ubico.crosscutting.helpers.NumericHelper;
import com.doo.ubico.crosscutting.helpers.ObjectHelper;
import com.doo.ubico.crosscutting.helpers.TextHelper;

import java.time.LocalDateTime;

public  final class DisponibilidadEntity {
    private  int id;
    private LocalDateTime fecha;
    private String HoraInicio;
    private String HoraFin;
    private AulaEntity aula;
    private  MotivoNoDisponibilidadEntity motivo;

    private DisponibilidadEntity(final int id) {
        setId(id);
        setFecha(LocalDateTime.now());
        setHoraInicio(LocalDateTime.now());
        setHoraFin(LocalDateTime.now());
    }

    public DisponibilidadEntity(final int id, final String nombre) {


    }

    public static final DisponibilidadEntity build(final int id){
        return new DisponibilidadEntity(id);
    }

    public static final DisponibilidadEntity build(final int id, final String nombre){
        return new DisponibilidadEntity(id,nombre);
    }

    protected static final DisponibilidadEntity build(){
        return new DisponibilidadEntity(NumericHelper.ZERO);
    }

    public final AulaEntity getAula() {
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


    private final  AulaEntity setAula( final AulaEntity aula) {
        this.aula = ObjectHelper.getObjectHelper().getDefault(aula, AulaEntity.build());
        return aula;
    }

    private final  LocalDateTime setFecha(LocalDateTime fecha) {
        this.fecha = LocalDateTime.now();
        return fecha;
    }

    private final  String setHoraFin(LocalDateTime horaFin) {
        HoraFin = TextHelper.getHour();
        return HoraFin;
    }

    private final  String setHoraInicio(LocalDateTime horaInicio) {
        HoraInicio = TextHelper.getHour();
        return HoraInicio;
    }

    private final  int setId(int id) {
        this.id = id;
        return id;
    }
 }

