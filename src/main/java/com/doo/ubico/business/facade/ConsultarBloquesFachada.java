package com.doo.ubico.business.facade;

import java.util.List;
import com.doo.ubico.dto.BloqueDTO;

public interface ConsultarBloquesFachada {
	
	List<BloqueDTO> execute(BloqueDTO bloque);

}
