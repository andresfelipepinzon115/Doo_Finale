package com.doo.ubico.entity;


import com.doo.ubico.crosscutting.helpers.NumericHelper;
import com.doo.ubico.crosscutting.helpers.TextHelper;




public final  class MotivoNoDisponibilidadEntity {
    private  int id;
    private String nombre;

    public MotivoNoDisponibilidadEntity(final int id, final String nombre) {
        setId(id);
        setNombre(TextHelper.EMPTY);

    }

    private MotivoNoDisponibilidadEntity(final int id) {
        this.id = id;
        setNombre(TextHelper.EMPTY);
    }



    public static final MotivoNoDisponibilidadEntity build(final int id){
        return new MotivoNoDisponibilidadEntity(id);
    }

    public static final MotivoNoDisponibilidadEntity build(final int id, final String nombre){
        return new MotivoNoDisponibilidadEntity(id,nombre);
    }

    protected static final MotivoNoDisponibilidadEntity build(){
        return new MotivoNoDisponibilidadEntity(NumericHelper.ZERO);
    }
    
    public static final MotivoNoDisponibilidadEntity build(String nombre){
        return new MotivoNoDisponibilidadEntity(NumericHelper.ZERO,nombre);
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

