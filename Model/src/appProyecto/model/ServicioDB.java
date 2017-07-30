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
                        "INSERT INTO Servicio VALUES ('" + servicio.getID() +"','" +servicio.getDescripcion()+ "','" + servicio.getPrecioPorHora() +"','" + servicio.isEstado() +"')";
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
           Servicio servicio;
           try {
           //  open();
               strSQL = 
                       "Select descripcion, IDTipo_Servicio, precio_por_hora, estado from Servicio where ID="+codigo;
               //Se ejecuta la sentencia SQL
               ResultSet rsSERVICIO = accesoDatos.ejecutaSQLRetornaRS(strSQL);
               while (rsSERVICIO.next()) {
                   
                servicio = new Servicio();
               
                servicio.setID(codigo);
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
        
        
    public LinkedList<Servicio> consultarServiciosSegunEstado(boolean estado) throws SNMPExceptions, SQLException {
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
               
               listaServicio.add(servicio);
               
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
           return listaServicio;
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
}
