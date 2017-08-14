package appProyecto.model;

import appProyecto.AccesoDatos;
import appProyecto.SNMPExceptions;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;

import javax.naming.NamingException;

public class ServicioDB {
    
    private AccesoDatos accesoDatos = new AccesoDatos();
    LinkedList<Servicio> listaServicio= new LinkedList<Servicio>();
    
    public ServicioDB() {
        super();
    }
    
    public void insertar(Servicio servicio) throws SNMPExceptions, SQLException {
        
            String strSQL = "";
            try {
            
                strSQL = 
                        "INSERT INTO Servicio VALUES ('" + servicio.getID() +"','" +servicio.getDescripcion()+ "','" +servicio.getTipo().getID()+ "','" + servicio.getPrecioPorHora() +"','" + servicio.isEstado() +"')";
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
    
    public void actualizar(Servicio servicio) throws SNMPExceptions, SQLException {
        
            String strSQL = "";
            try {
            
                strSQL = "UPDATE Servicio SET descripcion='"+ servicio.getDescripcion()+"', IDTipoServicio="+ servicio.getTipo().getID()+", precio_por_hora='"+ servicio.getPrecioPorHora()+"', estado='"+ servicio.isEstado()+"' WHERE ID ="+ servicio.getID();
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
    
    public Servicio obtenerServicio(String codigo) throws SNMPExceptions, SQLException {
         //  ResultSet rsPA = null;
           String strSQL = "";
           Servicio servicio=null;
           try {
           //  open();
               strSQL = 
                       "Select ID, descripcion, IDTipo_Servicio, precio_por_hora, estado from servicio where ID='"+codigo+"'";
               //Se ejecuta la sentencia SQL
               ResultSet rsSERVICIO = accesoDatos.ejecutaSQLRetornaRS(strSQL);
               while (rsSERVICIO.next()) {
                   
                servicio = new Servicio();
               
                servicio.setID(rsSERVICIO.getString("ID"));
                servicio.setDescripcion(rsSERVICIO.getString("descripcion"));
                servicio.getTipo().setID(rsSERVICIO.getString("IDTipo_Servicio")); //Solo se trae el ID del tipo servicio para adjuntarle el objeto completo despues  
                servicio.setPrecioPorHora(rsSERVICIO.getDouble("precio_por_hora"));
                servicio.setEstado(rsSERVICIO.getBoolean("estado"));   
               
               }
               rsSERVICIO.close();
               
           } catch (SQLException e) {
               throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                       e.getMessage(), e.getErrorCode());
           }catch (Exception e) {
               throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                       e.getMessage());
           } finally {
            //  accesoDatos.closeResultSet(rsPA);
          // close();
           }
           return servicio;
       }
        
    /**
     *Obtiene los registros de los servicios que se encuentran activos.
     * @param estado
     * @return
     * @throws SNMPExceptions
     * @throws SQLException
     */
    public LinkedList<Servicio> obtenerServiciosSegunEstado(boolean estado) throws SNMPExceptions, SQLException {
         //  ResultSet rsPA = null;
           String strSQL = "";
           Servicio servicio;
           LinkedList<Servicio> listaServicios = new LinkedList<Servicio>();
           
           try {
           //  open();
               strSQL = 
                       "Select ID, descripcion, IDTipo_Servicio, precio_por_hora, estado from Servicio where estado="+estado;
               //Se ejecuta la sentencia SQL
               ResultSet rsSERVICIO = accesoDatos.ejecutaSQLRetornaRS(strSQL);
               while (rsSERVICIO.next()) {
                   
                servicio = new Servicio();
               
                servicio.setID(rsSERVICIO.getString("ID"));
                servicio.setDescripcion(rsSERVICIO.getString("descripcion"));
                servicio.getTipo().setID(rsSERVICIO.getString("IDTipo_Servicio")); //Solo se trae el ID del tipo servicio para adjuntarle el objeto completo despues  
                servicio.setPrecioPorHora(rsSERVICIO.getDouble("precio_por_hora"));
                servicio.setEstado(rsSERVICIO.getBoolean("estado"));   
               
               listaServicios.add(servicio);
               
               }
               rsSERVICIO.close();
               
           } catch (SQLException e) {
               throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                       e.getMessage(), e.getErrorCode());
           }catch (Exception e) {
               throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                       e.getMessage());
           } finally {
            //  accesoDatos.closeResultSet(rsPA);
          // close();
           }
           return listaServicios;
       }
    
    /**
     *Obtiene una lista de registros de servicios por nombre
     * @param nombre
     * @return
     * @throws SNMPExceptions
     * @throws SQLException
     */
    public LinkedList<Servicio> obtenerServiciosSegunNombre(String nombre) throws SNMPExceptions, SQLException {
         //  ResultSet rsPA = null;
           String strSQL = "";
           Servicio servicio;
           LinkedList<Servicio> listaServicios = new LinkedList<Servicio>();
           
           try {
           //  open();
               strSQL = 
                       "Select ID, descripcion, IDTipo_Servicio, precio_por_hora, estado from servicio where descripcion='"+nombre+"'";
               //Se ejecuta la sentencia SQL
               ResultSet rsSERVICIO = accesoDatos.ejecutaSQLRetornaRS(strSQL);
               while (rsSERVICIO.next()) {
                   
                servicio = new Servicio();
               
                servicio.setID(rsSERVICIO.getString("ID"));
                servicio.setDescripcion(rsSERVICIO.getString("descripcion"));
                servicio.getTipo().setID(rsSERVICIO.getString("IDTipo_Servicio")); //Solo se trae el ID del tipo servicio para adjuntarle el objeto completo despues  
                servicio.setPrecioPorHora(rsSERVICIO.getDouble("precio_por_hora"));
                servicio.setEstado(rsSERVICIO.getBoolean("estado"));   
               
               listaServicios.add(servicio);
               
               }
               rsSERVICIO.close();
               
           } catch (SQLException e) {
               throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                       e.getMessage(), e.getErrorCode());
           }catch (Exception e) {
               throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                       e.getMessage());
           } finally {
            //  accesoDatos.closeResultSet(rsPA);
          // close();
           }
           return listaServicios;
       }
    /**
     *Obtiene una lista de registros de servicios por tipo
     * @param tipo
     * @return
     * @throws SNMPExceptions
     * @throws SQLException
     */
    public LinkedList<Servicio> obtenerServiciosSegunTipo(String tipo) throws SNMPExceptions, SQLException {
         //  ResultSet rsPA = null;
           String strSQL = "";
           Servicio servicio;
           LinkedList<Servicio> listaServicios = new LinkedList<Servicio>();
           
           try {
           //  open();
               strSQL = 
                       "select servicio.ID, servicio.descripcion, servicio.IDTipo_Servicio, precio_por_hora, servicio.estado from servicio join TipoServicio on servicio.IDTipo_Servicio = TipoServicio.ID where TipoServicio.descripcion ='"+tipo+"'";
               //Se ejecuta la sentencia SQL
               ResultSet rsSERVICIO = accesoDatos.ejecutaSQLRetornaRS(strSQL);
               while (rsSERVICIO.next()) {
                   
                servicio = new Servicio();
               
                servicio.setID(rsSERVICIO.getString("ID"));
                servicio.setDescripcion(rsSERVICIO.getString("descripcion"));
                servicio.getTipo().setID(rsSERVICIO.getString("IDTipo_Servicio")); //Solo se trae el ID del tipo servicio para adjuntarle el objeto completo despues  
                servicio.setPrecioPorHora(rsSERVICIO.getDouble("precio_por_hora"));
                servicio.setEstado(rsSERVICIO.getBoolean("estado"));   
               
               listaServicios.add(servicio);
               
               }
               rsSERVICIO.close();
               
           } catch (SQLException e) {
               throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                       e.getMessage(), e.getErrorCode());
           }catch (Exception e) {
               throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                       e.getMessage());
           } finally {
            //  accesoDatos.closeResultSet(rsPA);
          // close();
           }
           return listaServicios;
       }
    
    
    /**
     *Desabilita el registro en la base de datos haciendolo inactivo. No lo elimina físicamente del
     * repositorio de datos.
     * @param cod
     * @throws SNMPExceptions
     * @throws SQLException
     */
    public void eliminarServicio(int cod)throws SNMPExceptions, SQLException{
        
        try {
            
            String strSQL = 
                    "Update Servicio set estado=0 where ID="+cod;
            //Se ejecuta la sentencia SQL
            accesoDatos.ejecutaSQL(strSQL/*, sqlBitacora*/);
        
        } catch (SQLException e) {
               throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                       e.getMessage(), e.getErrorCode());
           }catch (Exception e) {
               throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                       e.getMessage());
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
    public boolean consultarServicio(String codigo) throws SNMPExceptions, SQLException {
           ResultSet rsSERVICIO = null;
           String select = "";
           try {
            //  open();
               boolean existe = false;
               select = 
               "Select ID, descripcion, IDTipo_Servicio, precio_por_hora, estado from servicio where ID ='"+codigo+"'";

               
               //Se ejecuta la sentencia SQL
               rsSERVICIO = accesoDatos.ejecutaSQLRetornaRS(select);

               if (rsSERVICIO.next()) {
                   existe = true;
               }
               return existe;
           } catch (SQLException e) {
               throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                       e.getMessage(), e.getErrorCode());
           }catch (Exception e) {
               throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                       e.getMessage());
           } finally {
               accesoDatos.closeResultSet(rsSERVICIO);
             // close(); 
           }
       }
}
