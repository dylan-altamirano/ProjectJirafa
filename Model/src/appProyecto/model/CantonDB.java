package appProyecto.model;

import appProyecto.AccesoDatos;
import appProyecto.SNMPExceptions;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;

import javax.naming.NamingException;

public class CantonDB {
    
    private AccesoDatos accesoDatos = new AccesoDatos();
    LinkedList<Canton> listaCanton= new LinkedList<Canton>();
    
    public CantonDB() {
        
    }
    
    public Canton obtenerCanton(String codigo) throws SNMPExceptions, SQLException {
         //  ResultSet rsPA = null;
           String strSQL = "";
           Canton Canton=null;
           try {
           //  open();
               strSQL = 
                       "Select descripcion, estado from Canton where ID="+codigo;
               //Se ejecuta la sentencia SQL
               ResultSet rsCanton = accesoDatos.ejecutaSQLRetornaRS(strSQL);
               while (rsCanton.next()) {
                   
                Canton = new Canton();
               
                Canton.setID(codigo);
                Canton.setDescripcion(rsCanton.getString("descripcion"));
                Canton.setEstado(rsCanton.getBoolean("estado"));   
               
               }
               rsCanton.close();
               
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
           return Canton;
       }
    
    public LinkedList<Canton> cargarCantonesPorProvincia(String codigoProvincia) throws SNMPExceptions, SQLException {
         //  ResultSet rsPA = null;
           String strSQL = "";
           Canton Canton=null;
           LinkedList<Canton> listaCantones = new LinkedList<Canton>();
           try {
           //  open();
               strSQL = 
                       "Select ID, descripcion, estado from Canton where IDProvincia="+codigoProvincia;
               //Se ejecuta la sentencia SQL
               ResultSet rsCanton = accesoDatos.ejecutaSQLRetornaRS(strSQL);
               while (rsCanton.next()) {
                   
                Canton = new Canton();
               
                Canton.setID(rsCanton.getString("ID"));
                Canton.setDescripcion(rsCanton.getString("descripcion"));
                Canton.setEstado(rsCanton.getBoolean("estado"));   
               
                   listaCantones.add(Canton);
               }
               rsCanton.close();
               
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
           return listaCantones;
       }
    
    /**
     *Obtiene el canton relacionado a la direccion de un cliente en especifico
     * @param codigoCliente
     * @return
     * @throws SNMPExceptions
     * @throws SQLException
     */
    public Canton obtenerCantonPorCliente(String codigoCliente) throws SNMPExceptions, SQLException {
         //  ResultSet rsPA = null;
           String strSQL = "";
           Canton Canton=null;
           try {
           //  open();
               strSQL = 
                       "select Canton.ID, Canton.descripcion, Canton.estado from Direccion join Distrito on Distrito.ID = Direccion.IDDistrito join Canton on Canton.ID = Distrito.IDCanton join Provincia on Provincia.ID = Canton.IDProvincia where IDCliente ="+codigoCliente;
               //Se ejecuta la sentencia SQL
               ResultSet rsCanton = accesoDatos.ejecutaSQLRetornaRS(strSQL);
               while (rsCanton.next()) {
                   
                Canton = new Canton();
               
                Canton.setID("ID");
                Canton.setDescripcion(rsCanton.getString("descripcion"));
                Canton.setEstado(rsCanton.getBoolean("estado"));   
               
               }
               rsCanton.close();
               
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
           return Canton;
       }
}
