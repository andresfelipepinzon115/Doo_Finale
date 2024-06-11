package com.doo.ubico.dto;

import com.doo.ubico.crosscutting.helpers.TextHelper;

public class BloqueDTO {
    private int id;
    private String nombre;

    public BloqueDTO(final int id,final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public BloqueDTO() {
        setNombre(TextHelper.EMPTY);
    }

    public static final BloqueDTO build(){
        return new BloqueDTO();
    }

    public final int getId() {
        return id;
    }

    public final BloqueDTO setId(final int id) {
        this.id = id;
        return this;
    }

    public final String getNombre() {
        return nombre;
    }

    public final BloqueDTO setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }


}
