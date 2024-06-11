package com.doo.ubico.data.dao.sql;



import java.sql.Connection;

import com.doo.ubico.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import com.doo.ubico.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import com.doo.ubico.crosscutting.helpers.SQLHelper;
import com.doo.ubico.crosscutting.exception.custom.DataUbicoException;

public class SqlConnection {

    private Connection conexion;

    protected SqlConnection(final Connection conexion) {
        setConexion(conexion);
    }

    protected SqlConnection() {
        super();
    }
    protected final Connection getConexion() {
        return conexion;
    }

    protected final void setConexion(final Connection conexion) {
        if (!SQLHelper.isOpen(conexion)) {
            var mensajeUsuario=MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico="No es posible crear el DAO deseado con una conexión cerrada";
            throw new DataUbicoException(mensajeTecnico,mensajeUsuario);
        }
        this.conexion = conexion;
    }
}