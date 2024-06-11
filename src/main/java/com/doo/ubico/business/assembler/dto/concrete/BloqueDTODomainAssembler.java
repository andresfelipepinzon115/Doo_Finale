package com.doo.ubico.business.assembler.dto.concrete;

import com.doo.ubico.dto.BloqueDTO;

import java.util.ArrayList;
import java.util.List;

import com.doo.ubico.business.assembler.dto.DTODomainAssembler;
import com.doo.ubico.business.domain.BloqueDomain;
import com.doo.ubico.crosscutting.helpers.ObjectHelper;


public final class BloqueDTODomainAssembler implements DTODomainAssembler<BloqueDomain, BloqueDTO>{
	
	private static final  DTODomainAssembler<BloqueDomain, BloqueDTO> instancia = new BloqueDTODomainAssembler();

	private BloqueDTODomainAssembler() {
		super();
	}
	
	public static final  DTODomainAssembler<BloqueDomain, BloqueDTO> obtenerInstancia(){
		return instancia;
	}
	
	@Override
	public final BloqueDomain ensamblarDominio(final BloqueDTO dto) {
		var bloqueDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new BloqueDTO());
		return BloqueDomain.crear(bloqueDtoTmp.getId(), bloqueDtoTmp.getNombre());
	}

	@Override
	public final BloqueDTO ensamblarDTO(final BloqueDomain dominio) {
		var bloqueDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, BloqueDomain.crear());
		return BloqueDTO.build().setId(bloqueDomainTmp.getId()).setNombre(bloqueDomainTmp.getNombre());
	}

	@Override
	public List<BloqueDTO> ensamblarListaDTO(final List<BloqueDomain> listDominios) {
		var listaDominiosTmp = ObjectHelper.getObjectHelper().getDefault(listDominios, new ArrayList<BloqueDomain>());
		var resultados = new ArrayList<BloqueDTO>();
		
		for (BloqueDomain bloqueDomain : listaDominiosTmp) {
			var bloqueDtoTmp = ensamblarDTO(bloqueDomain);
			resultados.add(bloqueDtoTmp);
		}
		return resultados;
	}

}


