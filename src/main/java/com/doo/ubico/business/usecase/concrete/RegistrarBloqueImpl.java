package com.doo.ubico.business.usecase.concrete;



import com.doo.ubico.business.assembler.entity.concrete.BloqueEntityDomainAssembler;
import com.doo.ubico.business.domain.BloqueDomain;
import com.doo.ubico.business.usecase.RegistrarBloque;
import com.doo.ubico.data.dao.factory.DAOFactory;


public class RegistrarBloqueImpl implements RegistrarBloque {
	
	private final DAOFactory factory;
	
	public RegistrarBloqueImpl(final DAOFactory factory) {
		this.factory = factory;
		
	}

	@Override
	public final void ejecutar(final BloqueDomain bloque) {
		//1. Validar que los datos sean validos a nivel de tipo de dato, longitud, obligatoriedad
		// formato, rango
		//3. Guardar la informacion de la nueva Aula
		var bloqueEntity = BloqueEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(bloque);
		factory.getBloqueDAO().crear(bloqueEntity);
	}
	


}
