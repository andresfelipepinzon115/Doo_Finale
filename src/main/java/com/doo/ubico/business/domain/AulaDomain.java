package com.doo.ubico.business.domain;

import com.doo.ubico.crosscutting.helpers.ObjectHelper;
import com.doo.ubico.crosscutting.helpers.TextHelper;



public class AulaDomain {
	
	private int id;
	private String nombre;
	private int Capacidad;
	private BloqueDomain bloque;
	private TipoAulaDomain tipoAula;
	
	
	private AulaDomain(final int id, final String nombre, final int capacidad, final BloqueDomain bloque, final TipoAulaDomain tipoAula) {
		setId(id);
		setNombre(nombre);
		setCapacidad(capacidad);
		setBloque(bloque);
		setTipoAula(tipoAula);

	}
	
	private AulaDomain() {
    	setNombre(TextHelper.EMPTY);
    	setBloque(BloqueDomain.crear());
    	setTipoAula(TipoAulaDomain.crear());
    }
    
   public static final AulaDomain crear(final int id, final String nombre, final int capacidad, final BloqueDomain bloque, final TipoAulaDomain tipoAula) {
    	return new AulaDomain(id,nombre,capacidad,bloque,tipoAula);
    }
   
   public static final AulaDomain crear() {
   	return new AulaDomain();
   }
	
	private void setId(int id) {
		this.id = id;
	}
	private void setNombre(final String nombre) {
		 this.nombre = TextHelper.applyTrim(nombre);
	}
	private void setCapacidad(final int capacidad) {
		Capacidad = capacidad;
	}
	private void setBloque(final BloqueDomain bloque) {
		this.bloque = ObjectHelper.getObjectHelper().getDefault(bloque, BloqueDomain.crear());
	}
	private void setTipoAula(final TipoAulaDomain tipoAula) {
		this.tipoAula = ObjectHelper.getObjectHelper().getDefault(tipoAula, TipoAulaDomain.crear());
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public int getCapacidad() {
		return Capacidad;
	}
	public BloqueDomain getBloque() {
		return bloque;
	}
	public TipoAulaDomain getTipoAula() {
		return tipoAula;
	}
	
	

}
