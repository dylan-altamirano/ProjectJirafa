package appProyecto.model;

import appProyecto.AccesoDatos;
import appProyecto.SNMPExceptions;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;

import javax.naming.NamingException;

public class ServicioDB {
    
    private AccesoDatos accesoDatos = new AccesoDatos();
    
    public ServicioDB() {
    }
    
    public void mvAgregarServicio(Servicio ser) throws SNMPExceptions {
        String strSQL = "";
        try {
            //Se obtienen los valores del objeto Empresa
           Servicio servicio = new Servicio();
            servicio = ser;
            strSQL = 
                    "INSERT INTO Servicio (id,descripcion,tipoServicio, PrecioPorHora, estado) VALUES " +
                    "(" + servicio.getID() + ",'" + servicio.getDescripcion() + "'," +  
                    servicio.getTipo().getID() + ",'" + servicio.getPrecioPorHora() + "','" 
                    + servicio.isEstado() + "')";
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
    public void mvActualizarServicio(Servicio ser) throws SNMPExceptions, SQLException, NamingException {
        Servicio servicio = new Servicio();
         servicio = ser;
            
        String id = servicio.getID();
        String descripcion = servicio.getDescripcion();
        double precioPorHora = servicio.getPrecioPorHora();
        String tipo = servicio.getTipo().getID();
        boolean estado = servicio.isEstado();
        
        //Se crea la sentencia de actualización
        String update = 
                "UPDATE Servicio SET precioPorHora = " + precioPorHora + 
                ", descripcion = '" + descripcion + 
                "', tipo = '" + tipo +
                "', estado = '" + estado  +
                "' where id = " + id;
        //Se ejecuta la sentencia SQL
        accesoDatos.ejecutaSQL(update);
    }
    public Servicio moBuscarServicio(String codigo) throws SNMPExceptions, SQLException {

        String strSQL = "";
        Servicio servicio = new Servicio();
        try {

            strSQL = 
                    "Select id, descripcion, tipoServicio, precioPorHora, estado from Servicio where id =" + codigo;
            //Se ejecuta la sentencia SQL
            ResultSet rsEM = accesoDatos.ejecutaSQLRetornaRS(strSQL);
            while (rsEM.next()) {
            
                String id = rsEM.getString("id");
                String descripcion = rsEM.getString("descripcion");
                
                String tipoServicioID = rsEM.getString("tipoServicio");
                TipoServicioDB db = new TipoServicioDB();
                TipoServicio tipo = db.moBuscarTipoServicio(tipoServicioID);
                double precioPorHora = rsEM.getDouble("precioPorHora");
                boolean estado = rsEM.getBoolean("estado");
                
            
                Servicio ser2 = new Servicio(id, descripcion, tipo, precioPorHora,estado);
                servicio = ser2;
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
        return servicio;
    }
    
    public  LinkedList<Servicio> moCargarServicios() throws SNMPExceptions, SQLException {
          String select = "";
          LinkedList<Servicio> listaServicios = new LinkedList<Servicio>();
          
          try {

              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
              select = 
                      "SELECT * FROM Servicio";
              
              //Se ejecuta la sentencia SQL
              ResultSet rsEM = accesoDatos.ejecutaSQLRetornaRS(select);

              while (rsEM.next()) {

                  String id = rsEM.getString("id");
                  String descripcion = rsEM.getString("descripcion");
                  
                  String tipoServicioID = rsEM.getString("tipoServicio");
                  TipoServicioDB db = new TipoServicioDB();
                  TipoServicio tipo = db.moBuscarTipoServicio(tipoServicioID);
                  double precioPorHora = rsEM.getDouble("precioPorHora");
                  boolean estado = rsEM.getBoolean("estado");
                  
                  
                  Servicio ser2 = new Servicio(id, descripcion, tipo, precioPorHora,estado);
                  
                  listaServicios.add(ser2);
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
         
          return listaServicios;
      }
    public  LinkedList<Servicio> moCargarServiciosPorEstado(boolean estados) throws SNMPExceptions, SQLException {
          String select = "";
          LinkedList<Servicio> listaServicios = new LinkedList<Servicio>();
          
          try {

              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
              select = 
                      "SELECT * FROM Servicio where estado = " + estados;
              
              //Se ejecuta la sentencia SQL
              ResultSet rsEM = accesoDatos.ejecutaSQLRetornaRS(select);

              while (rsEM.next()) {

                  String id = rsEM.getString("id");
                  String descripcion = rsEM.getString("descripcion");
                  
                  String tipoServicioID = rsEM.getString("tipoServicio");
                  TipoServicioDB db = new TipoServicioDB();
                  TipoServicio tipo = db.moBuscarTipoServicio(tipoServicioID);
                  double precioPorHora = rsEM.getDouble("precioPorHora");
                  boolean estado = rsEM.getBoolean("estado");
                  
                  
                  Servicio ser2 = new Servicio(id, descripcion, tipo, precioPorHora,estado);
                  
                  listaServicios.add(ser2);
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
         
          return listaServicios;
      }
}
