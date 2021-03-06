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
        
        
        //Se crea la sentencia de actualizaci�n
        String update = 
                "UPDATE TipoFeriado SET estado = " + estado + 
                ", clave = '" + clave + 
                "' where id = " + id;
        //Se ejecuta la sentencia SQL
        accesoDatos.ejecutaSQL(update);
    }
    public Usuario moBuscarUsuario(String id, String clave) throws SNMPExceptions, SQLException {

        String strSQL = "";
        Usuario usu = null;
        try {

            strSQL = 
                    "Select ID, clave, estado from usuario where ID ='" +id + "' and " + "clave = '" + clave+"'";
            //Se ejecuta la sentencia SQL
            ResultSet rsEM = accesoDatos.ejecutaSQLRetornaRS(strSQL);
            while (rsEM.next()) {
            
                String idUsuario = rsEM.getString("ID");
                String claveUsuario = rsEM.getString("clave");
                boolean estado = rsEM.getBoolean("estado");
                
                usu = new Usuario();
                
                usu.setId(idUsuario);
                usu.setClave(claveUsuario);
                usu.setEstado(estado);
            
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
    
    public  LinkedList<Usuario> moCargarUsuariosPorEstado(boolean bandera) throws SNMPExceptions, SQLException {
          String select = "";
          LinkedList<Usuario> listaUsuarios = new LinkedList<Usuario>();
          
          try {

              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de b�squeda
              select = 
                      "SELECT * FROM Usuario where estado="+bandera;
              
              //Se ejecuta la sentencia SQL
              ResultSet rsEM = accesoDatos.ejecutaSQLRetornaRS(select);

              while (rsEM.next()) {

                  String idUsuario = rsEM.getString("id");
                  String claveUsuario = rsEM.getString("clave");
                  boolean estado = rsEM.getBoolean("estado");
                  
                  
                  Usuario usuario = new Usuario();
                  
                  usuario.setId(idUsuario);
                  usuario.setClave(claveUsuario);
                  usuario.setEstado(estado);
                  
                  listaUsuarios.add(usuario);
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
