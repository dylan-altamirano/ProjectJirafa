package appProyecto.model;

import appProyecto.AccesoDatos;

import appProyecto.SNMPExceptions;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.LinkedList;

public class OrdenServicioDB2 {

    private AccesoDatos accesoDatos = new AccesoDatos();

    public OrdenServicioDB2() {
        super();
    }
    
    /**
     *Crea una orden de servicio en la tabla temporal
     * @throws SNMPExceptions
     * @throws SQLException
     */
    public void crearOrdenServicio() throws SNMPExceptions, SQLException{
        
        try {

            String strSQL = "insert into OrdenServicio_Temporal values(CAST((next value for serial_ordenes) as varchar(50)),'unknown','unknown','unknown',GETDATE(),0,'unspecified','PENDIENTE','unspecified',0.0)";
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
    
    
    public void insertar(OrdenServicio OrdenServicio) throws SNMPExceptions, SQLException {

        String strSQL = "";
        try {

            strSQL =
                    "INSERT INTO OrdenServicio_Temporal VALUES ('" + OrdenServicio.getId() + "','" + OrdenServicio.getCliente().getID() +
                    "','" + OrdenServicio.getServicio().getID() + "','" + OrdenServicio.getFecha() + "','" +
                    OrdenServicio.getEstimacion_horas() + "','" + OrdenServicio.getDetalle() + "','" +
                    OrdenServicio.getEstado() + "','" + OrdenServicio.montoTotalCostosVariables() + "','" +
                    OrdenServicio.getObservaciones() + "','" + OrdenServicio.getDescuentoAplicado() + "','" +
                    OrdenServicio.getUsuario().getId() + "')";
            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(strSQL) /*, sqlBitacora*/;

        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage(), e.getErrorCode());
        } catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, e.getMessage());
        } finally {

        }
    }
    
    public void actualizarCliente(String idOrden, String  idCliente)throws SNMPExceptions, SQLException{
        
        String strSQL = "";
        try {
        
            strSQL = "UPDATE  OrdenServicio_Temporal set ID_Cliente ='"+idCliente+"' where ID='"+idOrden+"'";
            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(strSQL/*, sqlBitacora*/);
        
        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                    e.getMessage(), e.getErrorCode());
        }catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                    e.getMessage());
        } finally {
        
        }
        
    }
    
    public void actualizarServicio(String idOrden, String  idServicio)throws SNMPExceptions, SQLException{
        
        String strSQL = "";
        try {
        
            strSQL = "UPDATE  OrdenServicio_Temporal set ID_Servicio ='"+idServicio+"' where ID='"+idOrden+"'";
            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(strSQL/*, sqlBitacora*/);
        
        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                    e.getMessage(), e.getErrorCode());
        }catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                    e.getMessage());
        } finally {
        
        }
    }
        
    public void actualizarUsuario(String idOrden, String  idUsuario)throws SNMPExceptions, SQLException{
            
            String strSQL = "";
            try {
            
                strSQL = "UPDATE  OrdenServicio_Temporal set ID_Usuario ='"+idUsuario+"' where ID='"+idOrden+"'";
                //Se ejecuta la sentencia SQL
                accesoDatos.ejecutaSQL(strSQL/*, sqlBitacora*/);
            
            } catch (SQLException e) {
                throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                        e.getMessage(), e.getErrorCode());
            }catch (Exception e) {
                throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                        e.getMessage());
            } finally {
            
            }

    }
    
    /**
     *Actualiza los detalles de la solicitud.
     * @param orden
     * @throws SNMPExceptions
     * @throws SQLException
     */
    public void actualizarOrdenSevicio(OrdenServicio orden)throws SNMPExceptions, SQLException{
        
        SimpleDateFormat smp = new SimpleDateFormat("dd/MM/yyyy");
        
        String strSQL = "";
        try {
        
            strSQL = "UPDATE OrdenServicio_Temporal set fecha_ejecucion='"+smp.format(orden.getFecha())+"', estimacion_horas="+orden.getEstimacion_horas()+", detalle='"+orden.getDetalle()+"', estado='"+orden.getEstado()+"', observaciones='"+orden.getObservaciones()+"' where ID='"+orden.getId()+"'";
            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(strSQL/*, sqlBitacora*/);
        
        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                    e.getMessage(), e.getErrorCode());
        }catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                    e.getMessage());
        } finally {
        
        }
        
        
    }


    /**
     *Obtiene siempre el unico registro que exista en la tabla temporal
     * @return
     * @throws SNMPExceptions
     * @throws SQLException
     */
    public OrdenServicio obtenerOrdenServicio() throws SNMPExceptions, SQLException {
        //  ResultSet rsPA = null;
        String strSQL = "";
        OrdenServicio OrdenServicio = null;
        try {
            //  open();
            strSQL =
                    "Select top 1 ID, ID_Cliente, ID_Servicio, fecha_ejecucion, estimacion_horas, detalle, estado, observaciones, descuento_aplicado, ID_Usuario  from OrdenServicio_Temporal";
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
                OrdenServicio.setObservaciones(rsOrdenServicio.getString("observaciones"));
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


    public LinkedList<OrdenServicio> obtenerOrdenServiciosSegunEstado(boolean estado) throws SNMPExceptions,
                                                                                             SQLException {
        //  ResultSet rsPA = null;
        String strSQL = "";
        OrdenServicio OrdenServicio;
        LinkedList<OrdenServicio> listaOrdenServicios = new LinkedList<OrdenServicio>();

        try {
            strSQL =
                    "Select ID, ID_Cliente, ID_Servicio, fecha_ejecucion, estimacion_horas, detalle, estado, costos_variable, observacion, descuento_aplicado, ID_Usuario  from OrdenServicio_Temporal where estado=" +
                    estado;
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
                OrdenServicio.setObservaciones(rsOrdenServicio.getString("observaciones"));
                OrdenServicio.setDescuentoAplicado(rsOrdenServicio.getDouble("descuento_aplicado"));
                OrdenServicio.getUsuario().setId(rsOrdenServicio.getString("ID_Usuario"));


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
    public void eliminarOrdenServicio(String cod) throws SNMPExceptions, SQLException {

        try {

            String strSQL = "Update OrdenServicio_Temporal set estado='Inactivo' where ID='" + cod+"'";
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
     *Borra la tabla de orden de servicio
     * @throws SNMPExceptions
     * @throws SQLException
     */
    public void eliminarOrdenesServicio() throws SNMPExceptions, SQLException {

        try {

            String strSQL = "delete from OrdenServicio_Temporal";
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
            select = "Select ID from OrdenServicio_Temporal where ID ='" + codigo+"'";


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
