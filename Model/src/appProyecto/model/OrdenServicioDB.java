package appProyecto.model;

import appProyecto.AccesoDatos;

import appProyecto.SNMPExceptions;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.LinkedList;

public class OrdenServicioDB {

    private AccesoDatos accesoDatos = new AccesoDatos();

    public OrdenServicioDB() {
        super();
    }

    public void insertar(OrdenServicio OrdenServicio) throws SNMPExceptions, SQLException {
    
        SimpleDateFormat smp = new SimpleDateFormat("dd/MM/yyyy");
    
        String strSQL = "";
        try {

            strSQL =
                    "INSERT INTO OrdenServicio VALUES ('" + OrdenServicio.getId() + "','" + OrdenServicio.getCliente().getID() +
                    "','" + OrdenServicio.getServicio().getID() + "','" + OrdenServicio.getUsuario().getId() +"','" + smp.format(OrdenServicio.getFecha()) + "','" +
                    OrdenServicio.getEstimacion_horas() + "','" + OrdenServicio.getDetalle() + "','" +
                    OrdenServicio.getEstado() + "','" +
                    OrdenServicio.getObservaciones() + "','" + OrdenServicio.getDescuentoAplicado() + "')";
            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(strSQL) /*, sqlBitacora*/;

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
    }


    public OrdenServicio obtenerOrdenServicio(String codigo) throws SNMPExceptions, SQLException {
        //  ResultSet rsPA = null;
        String strSQL = "";
        OrdenServicio OrdenServicio = null;
        try {
            //  open();
            strSQL =
                    "Select ID_Solicitud, ID_Cliente, ID_Servicio, fecha_ejecucion, estimacion_horas, detalle, estado, costos_variable, observacion, descuento_aplicado, ID_Usuario  from OrdenServicio where ID=" +
                    codigo;
            //Se ejecuta la sentencia SQL
            ResultSet rsOrdenServicio = accesoDatos.ejecutaSQLRetornaRS(strSQL);
            while (rsOrdenServicio.next()) {

                OrdenServicio = new OrdenServicio();

                OrdenServicio.setId(codigo);
                OrdenServicio.getCliente().setID(rsOrdenServicio.getString("ID_Cliente"));
                OrdenServicio.getServicio().setID(rsOrdenServicio.getString("ID_Servicio")); //Solo se trae el ID del tipo OrdenServicio para adjuntarle el objeto completo despues
                OrdenServicio.setFecha(rsOrdenServicio.getDate("fecha_ejecucion"));
                OrdenServicio.setEstimacion_horas(rsOrdenServicio.getInt("estimacion_horas"));
                OrdenServicio.setDetalle(rsOrdenServicio.getString("detalle"));
                OrdenServicio.setEstado(rsOrdenServicio.getString("estado"));
                OrdenServicio.setObservaciones(rsOrdenServicio.getString("observacion"));
                OrdenServicio.setDescuentoAplicado(rsOrdenServicio.getDouble("descuento_aplicado"));
                OrdenServicio.getUsuario().setId(rsOrdenServicio.getString("ID_Usuario"));
            }
            rsOrdenServicio.close();

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {
            //  accesoDatos.closeResultSet(rsPA);
            // close();
        }
        return OrdenServicio;
    }


    public LinkedList<OrdenServicio> obtenerOrdenServiciosSegunEstado(String estado) throws SNMPExceptions,
                                                                                             SQLException {
        //  ResultSet rsPA = null;
        String strSQL = "";
        OrdenServicio OrdenServicio;
        LinkedList<OrdenServicio> listaOrdenServicios = new LinkedList<OrdenServicio>();

        try {
            strSQL =
                    "Select ID_Solicitud, ID_Cliente, ID_Servicio, fecha_ejecucion, estimacion_horas, detalle, estado, costos_variable, observacion, descuento_aplicado, ID_Usuario  from OrdenServicio where estado='" +
                    estado+"'";
            //Se ejecuta la sentencia SQL
            ResultSet rsOrdenServicio = accesoDatos.ejecutaSQLRetornaRS(strSQL);
            while (rsOrdenServicio.next()) {

                OrdenServicio = new OrdenServicio();

                OrdenServicio.setId(rsOrdenServicio.getString("ID"));
                OrdenServicio.getCliente().setID(rsOrdenServicio.getString("ID_Cliente"));
                OrdenServicio.getServicio().setID(rsOrdenServicio.getString("ID_Servicio")); //Solo se trae el ID del tipo OrdenServicio para adjuntarle el objeto completo despues
                OrdenServicio.setFecha(rsOrdenServicio.getDate("fecha_ejecucion"));
                OrdenServicio.setEstimacion_horas(rsOrdenServicio.getInt("estimacion_horas"));
                OrdenServicio.setDetalle(rsOrdenServicio.getString("detalle"));
                OrdenServicio.setEstado(rsOrdenServicio.getString("estado"));
                OrdenServicio.setObservaciones(rsOrdenServicio.getString("observacion"));
                OrdenServicio.setDescuentoAplicado(rsOrdenServicio.getDouble("descuento_aplicado"));
                OrdenServicio.getUsuario().setId(rsOrdenServicio.getString("ID"));


                listaOrdenServicios.add(OrdenServicio);

            }
            rsOrdenServicio.close();

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {
            //  accesoDatos.closeResultSet(rsPA);
            // close();
        }
        return listaOrdenServicios;
    }

    /**
     *Desabilita el registro en la base de datos haciendolo inactivo. No lo elimina físicamente del
     * repositorio de datos.
     * @param cod
     * @throws SNMPExceptions
     * @throws SQLException
     */
    public void eliminarOrdenServicio(String  cod) throws SNMPExceptions, SQLException {

        try {

            String strSQL = "Update OrdenServicio set estado='INACTIVO' where ID='" + cod+"'";
            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(strSQL) /*, sqlBitacora*/;

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {
            //  accesoDatos.closeResultSet(rsPA);
            // close();
        }
    }

    /**
     *Consulta la existencia de un registro dentro del repositorio de datos.
     * @param codigo
     * @return
     * @throws SNMPExceptions
     * @throws SQLException
     */
    public boolean consultarOrdenServicio(String codigo) throws SNMPExceptions, SQLException {
        ResultSet rsOrdenServicio = null;
        String select = "";
        try {
            //  open();
            boolean existe = false;
            select = "Select ID from OrdenServicio where ID ='" + codigo+"'";


            //Se ejecuta la sentencia SQL
            rsOrdenServicio = accesoDatos.ejecutaSQLRetornaRS(select);

            if (rsOrdenServicio.next()) {
                existe = true;
            }
            return existe;
        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {
            accesoDatos.closeResultSet(rsOrdenServicio);
            // close();
        }
    }
}
