package appProyecto.model;

import appProyecto.AccesoDatos;

import appProyecto.SNMPExceptions;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;

public class DistritoDB {
    private AccesoDatos accesoDatos = new AccesoDatos();
    LinkedList<Distrito> listaDistrito= new LinkedList<Distrito>();
      
    public DistritoDB() {
        super();
    }
    public LinkedList<Distrito> cargarDistritoPorCanton(int codCanton)throws SNMPExceptions, SQLException{
        String select = "";
        LinkedList<Distrito> listaDistritosPorCanton = new LinkedList<Distrito>();
        
        try {

            AccesoDatos accesoDatos = new AccesoDatos();  

            //Se crea la sentencia de búsqueda
            select = 
            "Select  ID, descripcion, estado" +
            "from Distrito where IDCanton = " + codCanton;
            
            //Se ejecuta la sentencia SQL
            ResultSet rsEM = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsEM.next()) {

                String IDDistrito = rsEM.getString("ID");
                String Descripcion = rsEM.getString("descripcion");
                boolean estado = rsEM.getBoolean("estado");
                
                
                Distrito dis = new Distrito(IDDistrito,Descripcion,estado);
                
                listaDistritosPorCanton.add(dis);
            }
            rsEM.close();
        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                    e.getMessage(), e.getErrorCode());
        }catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                    e.getMessage());
        } finally {
            
        }
        
        return listaDistritosPorCanton;
        
    }
    public Distrito obtenerDistrito(int codigoDistrito) throws SNMPExceptions {
        String strSQL = "";
        Distrito distrito = new Distrito();
        try {

            strSQL = 
                    "Select  descripcion, dstado" +
                "from Distrito where ID = " + codigoDistrito;
            //Se ejecuta la sentencia SQL
            ResultSet rsEM = accesoDatos.ejecutaSQLRetornaRS(strSQL);
            while (rsEM.next()) {
            
                String IDDistrito = rsEM.getString("ID");
                String Descripcion = rsEM.getString("descripcion");
                boolean estado = rsEM.getBoolean("estado");
                
                
                Distrito dis = new Distrito(IDDistrito,Descripcion,estado);
                distrito = dis;
            }
            rsEM.close();
            
        } catch (SQLException e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                    e.getMessage(), e.getErrorCode());
        }catch (Exception e) {
            throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                    e.getMessage());
        } finally {
        }
        return distrito;
    }
    
    /**
     *Obtiene el Provincia relacionado a la direccion de un cliente en especifico
     * @param codigoCliente
     * @return
     * @throws SNMPExceptions
     * @throws SQLException
     */
    public Distrito obtenerDistritoPorCliente(String codigoCliente) throws SNMPExceptions, SQLException {
         //  ResultSet rsPA = null;
           String strSQL = "";
           Distrito distrito=null;
           try {
           //  open();
               strSQL = 
                       "select Distrito.ID, Distrito.descripcion, Distrito.estado from Direccion join Distrito on Distrito.ID = Direccion.IDDistrito join Canton on Canton.ID = Distrito.IDCanton join Provincia on Provincia.ID = Canton.IDProvincia where IDCliente ="+codigoCliente;
               //Se ejecuta la sentencia SQL
               ResultSet rsDistrito = accesoDatos.ejecutaSQLRetornaRS(strSQL);
               while (rsDistrito.next()) {
                   
                 distrito = new Distrito();
               
                distrito.setIdDistrito("ID");
                distrito.setDescripcion(rsDistrito.getString("descripcion"));
                distrito.setEstado(rsDistrito.getBoolean("estado"));   
               
               }
               rsDistrito.close();
               
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
           return distrito;
       }
    
}
