package com.doo.ubico.data.dao;

import com.doo.ubico.data.dao.general.ActualizarDAO;
import com.doo.ubico.data.dao.general.ConsultarDAO;
import com.doo.ubico.data.dao.general.CrearDAO;
import com.doo.ubico.data.dao.general.EliminarDAO;
import com.doo.ubico.entity.TipoAulaEntity;

public interface TipoAulaDAO extends ConsultarDAO<TipoAulaEntity>, CrearDAO<TipoAulaEntity>, ActualizarDAO<TipoAulaEntity>, EliminarDAO {
}
