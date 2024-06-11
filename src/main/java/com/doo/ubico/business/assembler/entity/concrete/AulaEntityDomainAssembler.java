package com.doo.ubico.business.assembler.entity.concrete;

import java.util.List;

import com.doo.ubico.business.assembler.entity.EntityDomainAssembler;
import com.doo.ubico.business.domain.AulaDomain;
import com.doo.ubico.business.domain.BloqueDomain;
import com.doo.ubico.business.domain.TipoAulaDomain;
import com.doo.ubico.crosscutting.helpers.ObjectHelper;
import com.doo.ubico.entity.AulaEntity;
import com.doo.ubico.entity.BloqueEntity;
import com.doo.ubico.entity.TipoAulaEntity;

public class AulaEntityDomainAssembler implements EntityDomainAssembler<AulaDomain, AulaEntity>{
	
	private static final EntityDomainAssembler<AulaDomain, AulaEntity> instancia = new AulaEntityDomainAssembler();
	private AulaEntityDomainAssembler() {
		super();
	}
	
	public static final  EntityDomainAssembler<AulaDomain, AulaEntity> obtenerInstancia(){
		return instancia;
	}

	private static final EntityDomainAssembler<TipoAulaDomain, TipoAulaEntity> TipoAulaAssembler = TipoAulaEntityDomainAssembler.obtenerInstancia();
	private static final EntityDomainAssembler<BloqueDomain, BloqueEntity> BloqueAssembler = BloqueEntityDomainAssembler.obtenerInstancia();
	@Override
	
	public final AulaDomain ensamblarDominio(final AulaEntity entidad) {
		var AulaEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, AulaEntity.build(0));
		var tipoAulaDominio = TipoAulaAssembler.ensamblarDominio(AulaEntityTmp.getTipoAula());
		var bloqueDominio = BloqueAssembler.ensamblarDominio(AulaEntityTmp.getBloque());
		return AulaDomain.crear(AulaEntityTmp.getId(),AulaEntityTmp.getNombre(), AulaEntityTmp.getCapacidad(), bloqueDominio, tipoAulaDominio);
	}

	@Override
	public final AulaEntity ensamblarEntidad(final AulaDomain dominio) {
		var AulaDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, AulaDomain.crear());
		var tipoAulaEntity = TipoAulaAssembler.ensamblarEntidad(AulaDomainTmp.getTipoAula());
		var bloqueEntity = BloqueAssembler.ensamblarEntidad(AulaDomainTmp.getBloque());
		return AulaEntity.build(AulaDomainTmp.getId(), AulaDomainTmp.getNombre(), AulaDomainTmp.getCapacidad(), tipoAulaEntity, bloqueEntity);
		
	}

	@Override
	public List<AulaDomain> ensamblarListaDominios(List<AulaEntity> listEntidades) {
		// TODO Auto-generated method stub
		return null;
	}

}
