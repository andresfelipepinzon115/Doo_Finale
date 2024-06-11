package com.doo.ubico.business.usecase;

import java.util.List;

import com.doo.ubico.business.domain.AulaDomain;
import com.doo.ubico.business.domain.BloqueDomain;

public interface ConsultarBloque{
	
	List<BloqueDomain> ejecutar(BloqueDomain bloque);

}
