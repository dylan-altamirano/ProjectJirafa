package appProyecto.model;

import appProyecto.AccesoDatos;
import appProyecto.SNMPExceptions;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;

import javax.naming.NamingException;

public class UsuarioDB {
    private AccesoDatos accesoDatos = new AccesoDatos();
    public UsuarioDB() {
        super();
    }
    public void mvAgregarUsuario(Usuario u) throws SNMPExceptions {
        String strSQL = "";
        try {
            //Se obtienen los valores del objeto Empresa
           Usuario usu = new Usuario();
            usu = u;
            strSQL = 
                    "INSERT INTO Usuario (id,clave,estado) VALUES " +
                    "(" + usu.getId() + ",'" + usu.getClave() + "'," +  
                    usu.getEstado()+ "')";
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
    public void mvActualizarUsuario(Usuario u) throws SNMPExceptions, SQLException, NamingException {
            Usuario us = new Usuario();
         us = u;
            
        String id = us.getId();
        String clave = us.getClave();
        boolean estado = us.getEstado();
        
        
        //Se crea la sentencia de actualización
        String update = 
                "UPDATE TipoFeriado SET estado = " + estado + 
                ", clave = '" + clave + 
                "' where id = " + id;
        //Se ejecuta la sentencia SQL
        accesoDatos.ejecutaSQL(update);
    }
    public Usuario moBuscarUsuario(String id, String clave) throws SNMPExceptions, SQLException {

        String strSQL = "";
        Usuario usu = new Usuario();
        try {

            strSQL = 
                    "Select estado from Usuario where id =" +id + "&&" + "clave = " + clave;
            //Se ejecuta la sentencia SQL
            ResultSet rsEM = accesoDatos.ejecutaSQLRetornaRS(strSQL);
            while (rsEM.next()) {
            
                String idUsuario = rsEM.getString("id");
                String claveUsuario = rsEM.getString("clave");
                boolean estado = rsEM.getBoolean("estado");
                
            
                /*Usuario usuario2 = new Usuario(idUsuario, claveUsuario, estado);
                usu = usuario2;*/
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
        return usu;
    }
    
    public  LinkedList<Usuario> moCargarUsuarios() throws SNMPExceptions, SQLException {
          String select = "";
          LinkedList<Usuario> listaUsuarios = new LinkedList<Usuario>();
          
          try {

              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
              select = 
                      "SELECT * FROM Usuario";
              
              //Se ejecuta la sentencia SQL
              ResultSet rsEM = accesoDatos.ejecutaSQLRetornaRS(select);

              while (rsEM.next()) {

                  String idUsuario = rsEM.getString("id");
                  String claveUsuario = rsEM.getString("clave");
                  boolean estado = rsEM.getBoolean("estado");
                  
                  
                  /*Usuario usuario2 = new Usuario(idUsuario, claveUsuario, estado);
                  usu = usuario2;
                  listaUsuarios.add(usuario2);*/
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
         
          return listaUsuarios;
      }
}
