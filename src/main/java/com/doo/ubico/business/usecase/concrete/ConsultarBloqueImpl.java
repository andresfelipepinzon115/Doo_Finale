package com.doo.ubico.business.usecase.concrete;

import java.util.List;

import com.doo.ubico.business.assembler.entity.concrete.BloqueEntityDomainAssembler;
import com.doo.ubico.business.domain.AulaDomain;
import com.doo.ubico.business.domain.BloqueDomain;
import com.doo.ubico.business.usecase.ConsultarBloque;
import com.doo.ubico.data.dao.factory.DAOFactory;

public final class ConsultarBloqueImpl implements ConsultarBloque{
	
private final DAOFactory factory;
	
	public ConsultarBloqueImpl(final DAOFactory factory) {
		this.factory = factory;
	}

	@Override
	public final List<BloqueDomain> ejecutar(final BloqueDomain bloque) {
		var BloqueEntity = BloqueEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(bloque);
		var resultados = factory.getBloqueDAO().consultar(BloqueEntity);
		
		
		return BloqueEntityDomainAssembler.obtenerInstancia().ensamblarListaDominios(resultados);
	}



}
