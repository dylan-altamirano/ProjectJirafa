package appProyecto.model;

import appProyecto.AccesoDatos;
import appProyecto.SNMPExceptions;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;

import javax.naming.NamingException;

public class ProvinciaDB {
    private AccesoDatos accesoDatos = new AccesoDatos();
    
    public ProvinciaDB() {
        
    }
    
    public Provincia obtenerProvincia(String codigo) throws SNMPExceptions, SQLException {
         //  ResultSet rsPA = null;
           String strSQL = "";
           Provincia Provincia=null;
           try {
           //  open();
               strSQL = 
                       "Select descripcion, estado from Provincia where ID="+codigo;
               //Se ejecuta la sentencia SQL
               ResultSet rsProvincia = accesoDatos.ejecutaSQLRetornaRS(strSQL);
               while (rsProvincia.next()) {
                   
                Provincia = new Provincia();
               
                Provincia.setID(codigo);
                Provincia.setDescripcion(rsProvincia.getString("descripcion"));
                Provincia.setEstado(rsProvincia.getBoolean("estado"));   
               
               }
               rsProvincia.close();
               
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
           return Provincia;
       }
    
    public LinkedList<Provincia> cargarProvinciasSegunEstado(boolean estado) throws SNMPExceptions, SQLException {
         //  ResultSet rsPA = null;
           String strSQL = "";
           Provincia Provincia=null;
           LinkedList<Provincia> listaProvincias = new LinkedList<Provincia>();
           try {
           //  open();
               strSQL = 
                       "Select ID, descripcion, estado from Provincia where estado="+estado;
               //Se ejecuta la sentencia SQL
               ResultSet rsProvincia = accesoDatos.ejecutaSQLRetornaRS(strSQL);
               while (rsProvincia.next()) {
                   
                Provincia = new Provincia();
               
                Provincia.setID(rsProvincia.getString("ID"));
                Provincia.setDescripcion(rsProvincia.getString("descripcion"));
                Provincia.setEstado(rsProvincia.getBoolean("estado"));   
               
                   listaProvincias.add(Provincia);
               }
               rsProvincia.close();
               
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
           return listaProvincias;
       }
    
    /**
     *Obtiene el Provincia relacionado a la direccion de un cliente en especifico
     * @param codigoCliente
     * @return
     * @throws SNMPExceptions
     * @throws SQLException
     */
    public Provincia obtenerProvinciaPorCliente(String codigoCliente) throws SNMPExceptions, SQLException {
         //  ResultSet rsPA = null;
           String strSQL = "";
           Provincia Provincia=null;
           try {
           //  open();
               strSQL = 
                       "select Provincia.ID, Provincia.descripcion, Provincia.estado from Direccion join Distrito on Distrito.ID = Direccion.IDDistrito join Canton on Canton.ID = Distrito.IDCanton join Provincia on Provincia.ID = Canton.IDProvincia where IDCliente ="+codigoCliente;
               //Se ejecuta la sentencia SQL
               ResultSet rsProvincia = accesoDatos.ejecutaSQLRetornaRS(strSQL);
               while (rsProvincia.next()) {
                   
                Provincia = new Provincia();
               
                Provincia.setID("ID");
                Provincia.setDescripcion(rsProvincia.getString("descripcion"));
                Provincia.setEstado(rsProvincia.getBoolean("estado"));   
               
               }
               rsProvincia.close();
               
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
           return Provincia;
       }
}
