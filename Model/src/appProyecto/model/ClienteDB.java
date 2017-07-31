package appProyecto.model;

import appProyecto.AccesoDatos;
import appProyecto.SNMPExceptions;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;

import javax.naming.NamingException;

public class ClienteDB {
    private AccesoDatos accesoDatos = new AccesoDatos();
    
    public ClienteDB() {
        super();
    }
    
    public void insertar(Cliente Cliente) throws SNMPExceptions, SQLException {
        
            String strSQL = "";
            try {
            
                strSQL = 
                        "INSERT INTO Cliente VALUES ('" + Cliente.getID() +"','" +Cliente.getNombre()+ "','" + Cliente.getFax() +"','" + Cliente.getCorreo() +"','" + Cliente.getDescAplicable() +"','" + Cliente.getEstado()+"')";
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
    
    public void actualizar(Cliente Cliente) throws SNMPExceptions, SQLException {
        
            String strSQL = "";
            try {
            
                strSQL = "UPDATE Cliente SET nombre='"+ Cliente.getNombre()+"', fax="+ Cliente.getFax()+", correo_electronico='"+ Cliente.getCorreo()+"', estado='"+ Cliente.getEstado()+"' WHERE ID ="+ Cliente.getID();
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
    
    public Cliente obtenerCliente(String codigo) throws SNMPExceptions, SQLException {
         //  ResultSet rsPA = null;
           String strSQL = "";
           Cliente Cliente=null;
           try {
           //  open();
               strSQL = 
                       "Select ID, nombre, fax, correo_electronico, descuento_aplicable, estado from Cliente where ID="+codigo;
               //Se ejecuta la sentencia SQL
               ResultSet rsCliente = accesoDatos.ejecutaSQLRetornaRS(strSQL);
               while (rsCliente.next()) {
                   
                Cliente = new Cliente();
               
                Cliente.setID(codigo);
                Cliente.setNombre(rsCliente.getString("descripcion"));
                Cliente.setFax(rsCliente.getString("fax")); //Solo se trae el ID del tipo Cliente para adjuntarle el objeto completo despues  
                Cliente.setCorreo(rsCliente.getString("correo_electronico"));
                Cliente.setDescAplicable(rsCliente.getDouble("descuento_aplicable"));   
                Cliente.setEstado(rsCliente.getBoolean("estado"));   
               
               }
               rsCliente.close();
               
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
           return Cliente;
       }
        
        
    public LinkedList<Cliente> obtenerClientesSegunEstado(boolean estado) throws SNMPExceptions, SQLException {
         //  ResultSet rsPA = null;
           String strSQL = "";
           Cliente Cliente;
           LinkedList<Cliente> listaClientes = new LinkedList<Cliente>();
           
           try {
           //  open();
            strSQL =
                    "Select ID, nombre, fax, correo_electronico, descuento_aplicable, estado from Cliente where estado=" + estado;
            //Se ejecuta la sentencia SQL
            ResultSet rsCliente = accesoDatos.ejecutaSQLRetornaRS(strSQL);
            while (rsCliente.next()) {

                Cliente = new Cliente();

                Cliente.setID(rsCliente.getString("ID"));
                Cliente.setNombre(rsCliente.getString("descripcion"));
                Cliente.setFax(rsCliente.getString("fax")); //Solo se trae el ID del tipo Cliente para adjuntarle el objeto completo despues
                Cliente.setCorreo(rsCliente.getString("correo_electronico"));
                Cliente.setDescAplicable(rsCliente.getDouble("descuento_aplicable"));
                Cliente.setEstado(rsCliente.getBoolean("estado"));

                listaClientes.add(Cliente);
               
               }
               rsCliente.close();
               
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
           return listaClientes;
       }
    
    /**
     *Desabilita el registro en la base de datos haciendolo inactivo. No lo elimina físicamente del
     * repositorio de datos.
     * @param cod
     * @throws SNMPExceptions
     * @throws SQLException
     */
    public void eliminarCliente(int cod)throws SNMPExceptions, SQLException{
        
        try {
            
            String strSQL = 
                    "Update Cliente set estado=0 where ID="+cod;
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
    public boolean consultarCliente(int codigo) throws SNMPExceptions, SQLException {
           ResultSet rsCliente = null;
           String select = "";
           try {
            //  open();
               boolean existe = false;
               select = 
               "Select ID, nombre, fax, correo_electronico, descuento_aplicable, estado where ID ="+codigo;

               
               //Se ejecuta la sentencia SQL
               rsCliente = accesoDatos.ejecutaSQLRetornaRS(select);

               if (rsCliente.next()) {
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
               accesoDatos.closeResultSet(rsCliente);
             // close(); 
           }
       }
    
}
