package com.doo.ubico.data.dao.factory;


import com.doo.ubico.data.dao.AulaDAO;
import com.doo.ubico.data.dao.BloqueDAO;
import com.doo.ubico.data.dao.TipoAulaDAO;
import com.doo.ubico.data.dao.factory.enums.Factory;
import com.doo.ubico.data.dao.factory.sql.azuresql.AzureSQLDAOFactory;

public interface DAOFactory {


    static DAOFactory getFactory(Factory azureSql) {
        return new AzureSQLDAOFactory();
    }

    void cerrarConexion();

    void iniciarTransaccion();

    void confirmarTransaccion();

    void cancelarTransaccion();

    public abstract AulaDAO getAulaDAO();

    public abstract TipoAulaDAO getTipoAulaDAO();

    public abstract BloqueDAO getBloqueDAO();

//    public static void main(String[] args) {
//        DAOFactory.getFactory(Factory.AZURE_SQL).getAulaDAO().crear(null);
//        DAOFactory.getFactory(Factory.AZURE_SQL).getAulaDAO().actualizar(null);
//        DAOFactory.getFactory(Factory.AZURE_SQL).getAulaDAO().eliminar(0);
//        // List<AulaAzureSqlDAO> AulaAzureSql = new ArrayList<AulaAzureSqlDAO>();
//    }

}

