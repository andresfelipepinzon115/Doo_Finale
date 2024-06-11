package com.doo.ubico.api.response;

import com.doo.ubico.dto.BloqueDTO;

import java.util.ArrayList;
import java.util.List;

public class BloqueResponse extends Response<BloqueDTO> {

    public BloqueResponse() {
        setMensajes(new ArrayList<>());
        setDatos(new ArrayList<>());
    }

}
