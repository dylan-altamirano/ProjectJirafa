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
        super();
    }
    
    public void insertar(Cliente cliente) throws SNMPExceptions, SQLException {
        
            StringBuilder strSQL = new StringBuilder();
            try {
            
            for (Telefono telefono : cliente.getArrayTelefonos()) {
                strSQL.append("insert into Telefono values ('"+telefono.getID()+"','"+cliente.getID()+"','"+telefono.getNumero()+"','"+telefono.getTipoTele().toString()+"','"+telefono.isEstado()+"')");
            }
                
                
                //Se ejecuta la sentencia SQL
                accesoDatos.ejecutaMatrizSQL(strSQL.toString());
            
            } catch (SQLException e) {
                throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                        e.getMessage(), e.getErrorCode());
            }catch (Exception e) {
                throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                        e.getMessage());
            } finally {
            
            }
        }
    
    public void actualizar(Telefono telefono, String idCliente) throws SNMPExceptions, SQLException {
        
            String strSQL = "";
            try {
            
                strSQL = "UPDATE Telefono SET numero='"+ telefono.getNumero()+"', tipo="+ telefono.getTipoTele().toString()+", estado='"+ telefono.isEstado()+"' WHERE ID ='"+ telefono.getID()+"' and ID_Cliente="+idCliente;
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
}
