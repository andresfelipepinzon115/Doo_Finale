package com.doo.ubico.api.controller;

import com.doo.ubico.api.response.BloqueResponse;
import com.doo.ubico.business.facade.concrete.ConsultarBloquesFachadaImpl;
import com.doo.ubico.business.facade.concrete.RegistrarBloqueFachadaImpl;
import com.doo.ubico.crosscutting.exception.UbicoException;
import com.doo.ubico.dto.BloqueDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/blocks")
public final class BloqueController {

    @GetMapping
    public ResponseEntity<BloqueResponse> consultar() {
        var httpStatusCode = HttpStatus.ACCEPTED;
        var bloqueResponse = new BloqueResponse();

        try {
            var bloquesDto = BloqueDTO.build();
            var facade = new ConsultarBloquesFachadaImpl();
            bloqueResponse.setDatos(facade.execute(bloquesDto));
            bloqueResponse.getMensajes().add("Bloques consultados exitosamente");
        } catch (final UbicoException exception) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            bloqueResponse.getMensajes().add(exception.getMensajeUsuario());
            exception.printStackTrace();
        } catch (final Exception exception) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar los bloques";
            bloqueResponse.getMensajes().add(mensajeUsuario);
            exception.printStackTrace();
        }

        return new ResponseEntity<>(bloqueResponse, httpStatusCode);
    }

    @PostMapping
    public ResponseEntity<BloqueResponse> crear(@RequestBody BloqueDTO bloque) {
        var httpStatusCode = HttpStatus.ACCEPTED;
        var bloqueResponse = new BloqueResponse();

        try {
            var facade = new RegistrarBloqueFachadaImpl();
            facade.ejecutar(bloque);
            bloqueResponse.getMensajes().add("Bloque creado exitosamente");
        } catch (final UbicoException exception) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            bloqueResponse.getMensajes().add(exception.getMensajeUsuario());
            exception.printStackTrace();
        } catch (final Exception exception) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            var mensajeUsuario = "Se ha presentado un problema tratando de registrar el nuevo bloque";
            bloqueResponse.getMensajes().add(mensajeUsuario);
            exception.printStackTrace();
        }

        return new ResponseEntity<>(bloqueResponse, httpStatusCode);
    }

    
}

