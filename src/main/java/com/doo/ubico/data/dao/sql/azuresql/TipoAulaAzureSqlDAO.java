package com.doo.ubico.data.dao.sql.azuresql;

import com.doo.ubico.crosscutting.exception.custom.DataUbicoException;
import com.doo.ubico.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import com.doo.ubico.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import com.doo.ubico.data.dao.TipoAulaDAO;
import com.doo.ubico.data.dao.sql.SqlConnection;
import com.doo.ubico.entity.TipoAulaEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class TipoAulaAzureSqlDAO extends SqlConnection implements TipoAulaDAO {

    public TipoAulaAzureSqlDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public final void actualizar(final TipoAulaEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("UPDATE TipoAula ");
        sentenciaSql.append("SET Nombre = ? ");
        sentenciaSql.append("WHERE Id = ?");

        try (final PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setString(1, entidad.getNombre());
            sentenciaPreparada.setInt(2, entidad.getId());
            sentenciaPreparada.executeUpdate();
        } catch (final SQLException exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la actualización de la información del TipoAula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, entidad.getNombre());
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la actualización de la información del TipoAula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024, entidad.getNombre());
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        }
    }

    @Override
    public final List<TipoAulaEntity> consultar(final TipoAulaEntity entidad) {
        final var listaTipoAula = new ArrayList<TipoAulaEntity>();
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT Id, Nombre ");
        sentenciaSql.append("FROM TipoAula ");
        sentenciaSql.append("ORDER BY Nombre ASC");

        try (final PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
            try (final ResultSet resultado = sentenciaPreparada.executeQuery()) {
                List<TipoAulaEntity> TipoAula = new ArrayList<>();
                while (resultado.next()) {
                    TipoAulaEntity TipoAulaTmp = TipoAulaEntity.build(resultado.getInt("Id"), resultado.getString("Nombre"));
                    listaTipoAula.add(TipoAulaTmp);
                }
            }
        } catch (final SQLException exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la consulta de los Tipos de aulas. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023);
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final DataUbicoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la consulta de los Tipos de Aulas. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024);
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        }
        return listaTipoAula;
    }

    @Override
    public final void crear(final TipoAulaEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("INSERT INTO TipoAula(Nombre) ");
        sentenciaSql.append("VALUES ('Aula Común'), ('Salon de Informatica'), ('Laboratorio')");

        try (final PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setString(1, entidad.getNombre());
            sentenciaPreparada.executeUpdate();
        } catch (final SQLException exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo TipoAula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, entidad.getNombre());
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo TipoAula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024, entidad.getNombre());
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        }
    }

    @Override
    public final void eliminar(final int id) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("DELETE FROM TipoAula ");
        sentenciaSql.append("WHERE Id = ?");

        try (final PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setInt(1, id);
            sentenciaPreparada.executeUpdate();
        } catch (final SQLException exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la eliminación del TipoAula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, String.valueOf(id));
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la eliminación del TipoAula. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app Ubico";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024, String.valueOf(id));
            throw new DataUbicoException(mensajeTecnico, mensajeUsuario, exception);
        }
    }
}
