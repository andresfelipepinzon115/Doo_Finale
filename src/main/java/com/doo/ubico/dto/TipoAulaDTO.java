package com.doo.ubico.dto;


import com.doo.ubico.crosscutting.helpers.TextHelper;

public class TipoAulaDTO {
    private int id;
    private String nombre;

    public TipoAulaDTO(final int id,final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public TipoAulaDTO() {
        setNombre(TextHelper.EMPTY);
    }

    public static final TipoAulaDTO build(){
        return new TipoAulaDTO();
    }

    public final int getId() {
        return id;
    }

    public final TipoAulaDTO setId(final int id) {
        this.id = id;
        return this;
    }

    public final String getNombre() {
        return nombre;
    }

    public final TipoAulaDTO setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }


}
