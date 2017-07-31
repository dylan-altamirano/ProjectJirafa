package appProyecto.model;

import appProyecto.AccesoDatos;
import appProyecto.SNMPExceptions;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;

import javax.naming.NamingException;

public class DireccionDB {
    
    private AccesoDatos accesoDatos = new AccesoDatos();
    
    public DireccionDB() {
        super();
    }
    
    public void insertar(Direccion direccion, String idCliente) throws SNMPExceptions, SQLException {
        
            String strSQL = "";
            try {
            
                strSQL = 
                        "INSERT INTO Direccion VALUES ('" + direccion.getID() +"','" +idCliente+ "','" + direccion.getDistrito().getIdDistrito() +"','" + direccion.isEstado() +"')";
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
    
    public void actualizar(Direccion direccion, String idCliente) throws SNMPExceptions, SQLException {
        
            String strSQL = "";
            try {
            
                strSQL = "UPDATE Direccion SET IDDistrito='"+ direccion.getDistrito().getIdDistrito()+"', estado="+ direccion.isEstado()+" WHERE ID ='"+ direccion.getID()+"' and IDCliente="+idCliente;
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
     *Obtiene un objeto direccion correpondiente a un cliente en especifico.
     * Este objeto se comprondrá de la provincia, canton y distrito.
     * @param idCliente
     * @return
     * @throws SNMPExceptions
     * @throws SQLException
     */
    public Direccion obtenerDireccionPSegunCliente(String idCliente) throws SNMPExceptions, SQLException {
         //  ResultSet rsPA = null;
           String strSQL = "";
           
           //Se crean los objetos de las provincias, cantones y distritos primero
           ProvinciaDB provincia= new ProvinciaDB();
           CantonDB cantonDB = new CantonDB();
           DistritoDB distrito = new DistritoDB();
           
           //Se precrea un objeto direccion que contendrá la dirección del cliente
           Direccion direccion = new Direccion();
           
           //Se traen estos datos consultando la base de datos por el id del cliente
           direccion.setProvincia(provincia.obtenerProvinciaPorCliente(idCliente));
           direccion.setCanton(cantonDB.obtenerCantonPorCliente(idCliente));
           direccion.setDistrito(distrito.obtenerDistritoPorCliente(idCliente));
           
           //Se procede a consultar ahora sí los datos específicos de la tabla de dirección
           try {
           //  open();
               strSQL = 
                       "Select ID, detalle, estado from Direccion where IDCliente="+idCliente;
               //Se ejecuta la sentencia SQL
               ResultSet rsDIRECCION = accesoDatos.ejecutaSQLRetornaRS(strSQL);
               while (rsDIRECCION.next()) {
                   
                
               direccion.setID(rsDIRECCION.getString("ID"));
               direccion.setDetalle(rsDIRECCION.getString("detalle")); 
               direccion.setEstado(rsDIRECCION.getBoolean("estado"));
               
               
               }
               rsDIRECCION.close();
               
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
           //Se devuelve el objeto completo
           return direccion;
       }
    
}
