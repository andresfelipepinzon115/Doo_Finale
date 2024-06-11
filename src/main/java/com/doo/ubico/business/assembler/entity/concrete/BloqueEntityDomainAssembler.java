package com.doo.ubico.business.assembler.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import com.doo.ubico.business.assembler.entity.EntityDomainAssembler;
import com.doo.ubico.business.domain.BloqueDomain;
import com.doo.ubico.crosscutting.helpers.ObjectHelper;
import com.doo.ubico.dto.BloqueDTO;
import com.doo.ubico.entity.BloqueEntity;

public class BloqueEntityDomainAssembler implements EntityDomainAssembler<BloqueDomain, BloqueEntity>{

	public static final EntityDomainAssembler<BloqueDomain, BloqueEntity> instancia = new BloqueEntityDomainAssembler();
	private BloqueEntityDomainAssembler() {
		super();
	}
	
	public static final EntityDomainAssembler<BloqueDomain, BloqueEntity> obtenerInstancia(){
		return instancia;
	}
	
	@Override
	public final BloqueDomain ensamblarDominio(final BloqueEntity entidad) {
		var bloqueEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, BloqueEntity.build(0));
		return BloqueDomain.crear(bloqueEntityTmp.getId(),bloqueEntityTmp.getNombre());
	}

	@Override
	public final BloqueEntity ensamblarEntidad(final BloqueDomain dominio) {
		var bloqueDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, BloqueDomain.crear());
		return BloqueEntity.build(bloqueDomainTmp.getId(), bloqueDomainTmp.getNombre());
	}

	@Override
	public final List<BloqueDomain> ensamblarListaDominios(final List<BloqueEntity> listEntidades) {
		var listaEntidadesTmp = ObjectHelper.getObjectHelper().getDefault(listEntidades, new ArrayList<BloqueEntity>());
		var resultados = new ArrayList<BloqueDomain>();
		
		for (BloqueEntity bloqueEntity : listaEntidadesTmp) {
			var bloqueDomainTmp = ensamblarDominio(bloqueEntity);
			resultados.add(bloqueDomainTmp);
		}
		return resultados;
	}

}
