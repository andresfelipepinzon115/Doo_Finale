package com.doo.ubico.business.domain;

import com.doo.ubico.crosscutting.helpers.TextHelper;

public class TipoAulaDomain {
	private int id;
    private String nombre;

    
    private TipoAulaDomain(final int id, final String nombre){
    	setId(id);
        setNombre(nombre);
    }
    
    private TipoAulaDomain() {
    	setNombre(TextHelper.EMPTY);
    }
    
    public static final TipoAulaDomain crear(final int id, final String nombre) {
    	return new TipoAulaDomain(id,nombre);
    }
    
    
    public static final TipoAulaDomain crear() {
    	return new TipoAulaDomain();
    }
    

    public final int getId() {
        return id;
    }

    public final String getNombre() {
        return nombre;
    }

    private void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }

    private void setId(final int id) {
        this.id = id;
    }
}


