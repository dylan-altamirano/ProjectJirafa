package appProyecto.model;

import appProyecto.AccesoDatos;
import appProyecto.SNMPExceptions;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;

import javax.naming.NamingException;

public class TipoServicioDB {
    private AccesoDatos accesoDatos = new AccesoDatos();
    
    public TipoServicioDB() {
     
    }
    
    public void mvAgregarTipoServicio(TipoServicio servicio) throws SNMPExceptions {
        String strSQL = "";
        try {
            //Se obtienen los valores del objeto Empresa
           TipoServicio tips = new TipoServicio();
            tips = servicio;
            strSQL = 
                    "insert into TipoServicio (ID,descripcion,estado) VALUES " +
                    "('" + tips.getID() + "','" + tips.getDescripcion() + "'," +  
                    tips.isEstado() + ")";
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
    public void mvActualizarTipoServicio(TipoServicio servicio) throws SNMPExceptions, SQLException, NamingException {
        TipoServicio tips = new TipoServicio();
         tips = servicio;
            
        String id = tips.getID();
        String descripcion = tips.getDescripcion();
        int estado = tips.isEstado();
        
        
        //Se crea la sentencia de actualización
        String update = 
                "UPDATE TipoServicio SET estado = " + estado + 
                ", descripcion= '" + descripcion + 
                "' where ID = " + id;
        //Se ejecuta la sentencia SQL
        accesoDatos.ejecutaSQL(update);
    }
    public TipoServicio moBuscarTipoServicio(String codigo) throws SNMPExceptions, SQLException {

        String strSQL = "";
        TipoServicio ts = new TipoServicio();
        try {

            strSQL = 
                    "Select ID, Descripcion, estado from TipoServicio where ID ='" + codigo+"'";
            //Se ejecuta la sentencia SQL
            ResultSet rsEM = accesoDatos.ejecutaSQLRetornaRS(strSQL);
            while (rsEM.next()) {
            
                String ID = rsEM.getString("ID");
                String descripcion = rsEM.getString("descripcion");
                int estado = rsEM.getInt("estado");
                
                ts.setID(ID);
                ts.setDescripcion(descripcion);
                ts.setEstado(estado);
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
        return ts;
    }
    
    public  LinkedList<TipoServicio> moCargarTipoServicioSegunEstado(boolean bandera) throws SNMPExceptions, SQLException {
          String select = "";
          LinkedList<TipoServicio> listaTipoServicio = new LinkedList<TipoServicio>();
          
          try {

              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
              select = 
                      "SELECT ID, descripcion, estado FROM TipoServicio where estado='"+bandera+"'";
              
              //Se ejecuta la sentencia SQL
              ResultSet rsEM = accesoDatos.ejecutaSQLRetornaRS(select);

              while (rsEM.next()) {

                  String ID = rsEM.getString("ID");
                  String descripcion = rsEM.getString("Descripcion");
                  int estado = rsEM.getInt("estado");
                  
                  
                  TipoServicio tipoServicio = new TipoServicio(ID,descripcion,estado);
                  
                  listaTipoServicio.add(tipoServicio);
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
         
          return listaTipoServicio;
      }
    public void eliminarTipoServicio(String cod)throws SNMPExceptions, SQLException{
        
        try {
            
            String strSQL = 
                    "Update TipoServicio set estado=0 where ID='"+cod+"'";
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
