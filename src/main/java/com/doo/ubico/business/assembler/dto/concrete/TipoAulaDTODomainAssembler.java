package com.doo.ubico.business.assembler.dto.concrete;

import com.doo.ubico.dto.TipoAulaDTO;

import java.util.List;

import com.doo.ubico.business.assembler.dto.DTODomainAssembler;
import com.doo.ubico.business.domain.TipoAulaDomain;
import com.doo.ubico.crosscutting.helpers.ObjectHelper;


public class TipoAulaDTODomainAssembler implements DTODomainAssembler<TipoAulaDomain, TipoAulaDTO> {

    private static final DTODomainAssembler<TipoAulaDomain, TipoAulaDTO> instancia = new TipoAulaDTODomainAssembler();

    private TipoAulaDTODomainAssembler() {
        super();
    }

    public static final DTODomainAssembler<TipoAulaDomain, TipoAulaDTO> obtenerInstancia() {
        return instancia;
    }

    @Override
    public final TipoAulaDomain ensamblarDominio(final TipoAulaDTO dto) {
        var tipoAulaDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new TipoAulaDTO());
        return TipoAulaDomain.crear(tipoAulaDtoTmp.getId(), tipoAulaDtoTmp.getNombre());
    }

    @Override
    public final TipoAulaDTO ensamblarDTO(final TipoAulaDomain dominio) {
        var tipoAulaDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, TipoAulaDomain.crear());
        return TipoAulaDTO.build().setId(tipoAulaDomainTmp.getId()).setNombre(tipoAulaDomainTmp.getNombre());
    }

    @Override
    public List<TipoAulaDTO> ensamblarListaDTO(List<TipoAulaDomain> listDominios) {
        // TODO Auto-generated method stub
        return null;
    }

}
