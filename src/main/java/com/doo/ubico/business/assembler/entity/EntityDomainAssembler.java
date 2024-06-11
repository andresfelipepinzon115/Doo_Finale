package com.doo.ubico.business.assembler.entity;

import java.util.List;

import com.doo.ubico.business.domain.BloqueDomain;
import com.doo.ubico.entity.BloqueEntity;

public interface EntityDomainAssembler<D, E> {
	
	D ensamblarDominio(E entidad);
	E ensamblarEntidad(D dominio);
	List<D> ensamblarListaDominios(List<E> listEntidades);


	
}
