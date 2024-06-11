package com.doo.ubico.business.facade.concrete;

import com.doo.ubico.business.assembler.dto.concrete.BloqueDTODomainAssembler;
import com.doo.ubico.business.facade.RegistrarBloqueFachada;
import com.doo.ubico.business.usecase.RegistrarBloque;
import com.doo.ubico.business.usecase.concrete.RegistrarBloqueImpl;
import com.doo.ubico.crosscutting.exception.UbicoException;
import com.doo.ubico.crosscutting.exception.custom.BusinessUbicoException;
import com.doo.ubico.data.dao.factory.DAOFactory;
import com.doo.ubico.data.dao.factory.enums.Factory;
import com.doo.ubico.dto.BloqueDTO;

public class RegistrarBloqueFachadaImpl implements RegistrarBloqueFachada{
	
	private DAOFactory factory;
	
	public RegistrarBloqueFachadaImpl() {
		factory= DAOFactory.getFactory(Factory.AZURE_SQL);
	}
	
	

	@Override
	public final void ejecutar(final BloqueDTO bloque) {
		try {
			factory .iniciarTransaccion();
			
			var bloqueDomain = BloqueDTODomainAssembler.obtenerInstancia().ensamblarDominio(bloque);
			
			final RegistrarBloque useCase = new RegistrarBloqueImpl(factory);
			useCase.ejecutar(bloqueDomain);
			
			factory.confirmarTransaccion();
		}catch (UbicoException excepcion) {
			factory.cancelarTransaccion();
			throw excepcion;
			
		}catch(final Exception excepcion) {
			factory.cancelarTransaccion();
			var mensajeUsuario = "Se ha presentado un problema tratando de registrar la nueva informacion del bloque";
			var mensajeTecnico = "Se ha presentado un problema tratando de registar la informacion de la nueva bloque en el metodo Ejecutar de la clase RegistrarbloqueFachadaImpl, porfavor siga la traza completa del problema...";
			
			throw new BusinessUbicoException(mensajeTecnico,mensajeUsuario);
		}finally {
			factory.cerrarConexion();
		}
		
	}
	}






