package appProyecto.model;

import appProyecto.AccesoDatos;

import appProyecto.SNMPExceptions;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;

import javax.naming.NamingException;

public class TelefonoDB {
    private AccesoDatos accesoDatos = new AccesoDatos();
    public TelefonoDB() {
        
    }
    public void mvAgregarTelefono(Telefono t) throws SNMPExceptions {
        String strSQL = "";
        try {
            //Se obtienen los valores del objeto Empresa
           Telefono tele = new Telefono();
            tele = t;
            strSQL = 
                    "INSERT INTO Telefono (ID,numero,tipoTelefono, estado) VALUES " +
                    "(" + tele.getID() + ",'" + tele.getNumero() + "'," +  
                    tele.getTipoTele() + ",'" + tele.isEstado() + "')";
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
    public void mvActualizarTelefono(Telefono t) throws SNMPExceptions, SQLException, NamingException {
        Telefono tele = new Telefono();
         tele = t;
            
        String id = tele.getID();
        String numero = tele.getNumero();
        TipoTelefono tipoTelefono = tele.getTipoTele();
        boolean estado = tele.isEstado();
        
        
        //Se crea la sentencia de actualización
        String update = 
                "UPDATE Telefono SET TipoTelefono = " + tipoTelefono + 
                ", Numero = '" + numero + 
                "', estado= '" + estado +
                "' where id = " + id;
        //Se ejecuta la sentencia SQL
        accesoDatos.ejecutaSQL(update);
    }
    public Telefono moBuscarTelefono(String codigo) throws SNMPExceptions, SQLException {

        String strSQL = "";
        Telefono tele = new Telefono();
        try {

            strSQL = 
                    "Select ID, numero, TipoTelefono, estado from Telefono where id =" + codigo;
            //Se ejecuta la sentencia SQL
            ResultSet rsEM = accesoDatos.ejecutaSQLRetornaRS(strSQL);
            while (rsEM.next()) {
            
                String ID = rsEM.getString("ID");
                String numero = rsEM.getString("numero");
                String tipoTelefono = rsEM.getString("TipoTelefono");
                TipoTelefono tipo = TipoTelefono.valueOf(tipoTelefono);
                boolean estado = rsEM.getBoolean("Estado");
            
                Telefono t2 = new Telefono(ID,numero,tipo,estado);
                tele = t2;
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
        return tele;
    }
    
    public  LinkedList<Telefono> moCargarTelefonos() throws SNMPExceptions, SQLException {
          String select = "";
          LinkedList<Telefono> listaTelefonos = new LinkedList<Telefono>();
          
          try {

              AccesoDatos accesoDatos = new AccesoDatos();  

              //Se crea la sentencia de búsqueda
              select = 
                      "SELECT * FROM Telefonos";
              
              //Se ejecuta la sentencia SQL
              ResultSet rsEM = accesoDatos.ejecutaSQLRetornaRS(select);

              while (rsEM.next()) {

                  int ID = rsEM.getInt("ID");
                  String numero = rsEM.getString("numero");
                  String tipoTelefono = rsEM.getString("TipoTelefono");
                  TipoTelefono tipo = TipoTelefono.valueOf(tipoTelefono);
                  boolean estado = rsEM.getBoolean("Estado");
                  
                  Telefono t2 = new Telefono(ID,numero,tipo,estado);
                  
                  listaTelefonos.add(t2);
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
         
          return listaTelefonos;
      }
}
