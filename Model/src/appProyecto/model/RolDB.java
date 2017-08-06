package appProyecto.model;

import appProyecto.AccesoDatos;

import appProyecto.SNMPExceptions;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;

import javax.naming.NamingException;

public class RolDB {
    private AccesoDatos accesoDatos = new AccesoDatos();
    public RolDB() {

    }
    public void mvAgregarRol(Rol r) throws SNMPExceptions {
        String strSQL = "";
        try {
            //Se obtienen los valores del objeto Empresa
           Rol rol = new Rol();
            rol = r;
            strSQL = 
                    "INSERT INTO rol VALUES " +
                    "(" + rol.getId() + ",'" + rol.getDescripcion() + "'," +  
                    rol.isEstado() + "')";
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
    public void mvActualizarRol(Rol r) throws SNMPExceptions, SQLException, NamingException {
        Rol rol = new Rol();
         rol = r;
            
        String id = rol.getId();
        String descripcion = rol.getDescripcion();
        boolean estado = rol.isEstado();
        
        //Se crea la sentencia de actualización
        String update = 
                "UPDATE rol SET estado = " + estado + 
                ", descripcion= '" + descripcion +
                "' where ID = " + id;
        //Se ejecuta la sentencia SQL
        accesoDatos.ejecutaSQL(update);
    }
    public Rol moBuscarRol(String codigo) throws SNMPExceptions, SQLException {

        String strSQL = "";
        Rol rol = new Rol();
        try {

            strSQL = 
                    "Select ID, descripcion, estado from Rol where ID =" + codigo;
            //Se ejecuta la sentencia SQL
            ResultSet rsEM = accesoDatos.ejecutaSQLRetornaRS(strSQL);
            while (rsEM.next()) {
            
                String id = rsEM.getString("ID");
                String descripcion = rsEM.getString("descripcion");
                boolean estado = rsEM.getBoolean("estado");
                
            
                Rol roll = new Rol(id, descripcion, estado);
                rol = roll;
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
        return rol;
    }
    
    /**
     *Método que busca roles específicos para un usuario.
     * @param idUsuario
     * @return
     * @throws SNMPExceptions
     * @throws SQLException
     */
    public LinkedList<Rol> moBuscarRolesSegunUsuario(String idUsuario) throws SNMPExceptions, SQLException {

        String strSQL = "";
        Rol rol = null;
        LinkedList<Rol> listaRoles = new LinkedList<Rol>();
        
        try {

            strSQL = 
                    "select rol.ID, rol.descripcion, rol.estado from usuarioRol join usuario on usuario.ID = usuarioRol.IDUsuario join rol on rol.ID= usuarioRol.IDRol where usuario.ID ='" + idUsuario+"'";
            //Se ejecuta la sentencia SQL
            ResultSet rsEM = accesoDatos.ejecutaSQLRetornaRS(strSQL);
            while (rsEM.next()) {
            
                String id = rsEM.getString("ID");
                String descripcion = rsEM.getString("descripcion");
                boolean estado = rsEM.getBoolean("estado");
                
                rol = new Rol();
                
                rol.setId(id);
                rol.setDescripcion(descripcion);
                rol.setEstado(estado);
                
                listaRoles.add(rol);    
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
        return listaRoles;
    }    
    
    public  LinkedList<Rol> moCargarRolesSegunEstado(boolean estado) throws SNMPExceptions, SQLException {
          String select = "";
          LinkedList<Rol> listaRoles = new LinkedList<Rol>();
          
          try {

              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
              select = 
                      "SELECT * FROM rol where estado="+estado;
              
              //Se ejecuta la sentencia SQL
              ResultSet rsEM = accesoDatos.ejecutaSQLRetornaRS(select);

              while (rsEM.next()) {

                  String id = rsEM.getString("ID");
                  String descripcion = rsEM.getString("descripcion");
                  boolean est = rsEM.getBoolean("estado");
                  
                  
                  Rol roll = new Rol(id, descripcion, est);
                  
                  listaRoles.add(roll);
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
         
          return listaRoles;
      }
}
