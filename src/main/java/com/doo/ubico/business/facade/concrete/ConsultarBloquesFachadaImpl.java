package com.doo.ubico.business.facade.concrete;

import java.util.List;

import com.doo.ubico.business.assembler.dto.concrete.AulaDTODomainAssembler;
import com.doo.ubico.business.assembler.dto.concrete.BloqueDTODomainAssembler;
import com.doo.ubico.business.facade.ConsultarBloquesFachada;
import com.doo.ubico.business.usecase.ConsultarBloque;
import com.doo.ubico.business.usecase.concrete.ConsultarBloqueImpl;
import com.doo.ubico.crosscutting.exception.UbicoException;
import com.doo.ubico.crosscutting.exception.custom.BusinessUbicoException;
import com.doo.ubico.data.dao.factory.DAOFactory;
import com.doo.ubico.data.dao.factory.enums.Factory;
import com.doo.ubico.dto.AulaDTO;
import com.doo.ubico.dto.BloqueDTO;

public final class ConsultarBloquesFachadaImpl implements ConsultarBloquesFachada{
	
private DAOFactory factory;
	
	public ConsultarBloquesFachadaImpl() {
		factory= DAOFactory.getFactory(Factory.AZURE_SQL);
	}
	

	@Override
	public final List<BloqueDTO> execute(final BloqueDTO bloque) {
		try {
			var bloqueDomain = BloqueDTODomainAssembler.obtenerInstancia().ensamblarDominio(bloque);
			
			final ConsultarBloque useCase = new ConsultarBloqueImpl(factory);
			var resultados = useCase.ejecutar(bloqueDomain);
			
			return BloqueDTODomainAssembler.obtenerInstancia().ensamblarListaDTO(resultados);
			
			
		}catch (UbicoException excepcion) {
			throw excepcion;
			
		}catch(final Exception excepcion) {

			var mensajeUsuario = "Se ha presentado un problema tratando de consultar la nueva informacion de los Bloques...";
			var mensajeTecnico = "Se ha presentado un problema tratando de consultar la informacion de los Bloques en el metodo Ejecutar de la clase RegistrarAulaFachadaImpl, porfavor siga la traza completa del problema...";
			
			throw new BusinessUbicoException(mensajeTecnico,mensajeUsuario);
		}finally {
			factory.cerrarConexion();
		}
		
	}
}
	

	

