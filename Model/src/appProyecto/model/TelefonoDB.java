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
    
    /**
     *Inserta varios numeros de clientes basados en el arreglo el cliente tiene en su 
     * cartera de numeros a utilizar.
     * @param cliente
     * @throws SNMPExceptions
     * @throws SQLException
     */
    public void insertar(Cliente cliente) throws SNMPExceptions, SQLException {
        
            StringBuilder strSQL = new StringBuilder();
            try {
            
            for (Telefono telefono : cliente.getArrayTelefonos()) {
                strSQL.append("insert into Telefono values ('"+telefono.getID()+"','"+cliente.getID()+"','"+telefono.getNumero()+"','"+telefono.getTipoTele().toString()+"','"+telefono.isEstado()+"')");
            }
                
                
                //Se ejecuta la sentencia SQL
                int i= accesoDatos.ejecutaMatrizSQL(strSQL.toString());
            
            } catch (Exception e) {
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
    
    public Telefono obtenerTelefono(String codigo, String idCliente) throws SNMPExceptions, SQLException {
         //  ResultSet rsPA = null;
           String strSQL = "";
           Telefono telefono=null;
           try {
           //  open();
               strSQL = 
                       "Select ID, numero, tipo, estado from telefono where ID='"+codigo+"' and IDCliente='"+idCliente+"'";
               //Se ejecuta la sentencia SQL
               ResultSet rstelefono = accesoDatos.ejecutaSQLRetornaRS(strSQL);
               while (rstelefono.next()) {
                   
                telefono = new Telefono();
               
                telefono.setID(codigo);
                telefono.setNumero(rstelefono.getString("numero"));
                telefono.setTipoTele(TipoTelefono.valueOf(rstelefono.getString("tipo"))); //Solo se trae el ID del tipo telefono para adjuntarle el objeto completo despues  
                telefono.setEstado(rstelefono.getBoolean("estado"));   
               
               }
               rstelefono.close();
               
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
           return telefono;
       }
    
    public LinkedList<Telefono> obtenerTelefonosPorCliente(String idCliente) throws SNMPExceptions, SQLException {
         //  ResultSet rsPA = null;
           String strSQL = "";
           Telefono telefono=null;
           LinkedList<Telefono> listaTelefono = new LinkedList<Telefono>();
           try {
           //  open();
               strSQL = 
                       "Select ID, numero, tipo, estado from telefono where IDCliente="+idCliente;
               //Se ejecuta la sentencia SQL
               ResultSet rstelefono = accesoDatos.ejecutaSQLRetornaRS(strSQL);
               while (rstelefono.next()) {
                   
                telefono = new Telefono();
               
                telefono.setID(rstelefono.getString("ID"));
                telefono.setNumero(rstelefono.getString("numero"));
                telefono.setTipoTele(TipoTelefono.valueOf(rstelefono.getString("tipo"))); //Solo se trae el ID del tipo telefono para adjuntarle el objeto completo despues  
                telefono.setEstado(rstelefono.getBoolean("estado"));   
                   
                listaTelefono.add(telefono);   
               
               }
               rstelefono.close();
               
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
           return listaTelefono;
       }
    
    /**
     *Consulta la existencia de un registro dentro del repositorio de datos.
     * @param numero
     * @return
     * @throws SNMPExceptions
     * @throws SQLException
     */
    public boolean consultarTelefono(int numero) throws SNMPExceptions, SQLException {
           ResultSet rsTelefono = null;
           String select = "";
           try {
            //  open();
               boolean existe = false;
               select = 
               "Select ID, numero, tipo, estado where ID ="+numero;

               
               //Se ejecuta la sentencia SQL
               rsTelefono = accesoDatos.ejecutaSQLRetornaRS(select);

               if (rsTelefono.next()) {
                   existe = true;
               }
               return existe;
           } catch (SQLException e) {
               throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                       e.getMessage(), e.getErrorCode());
           }catch (Exception e) {
               throw new SNMPExceptions(SNMPExceptions.SQL_EXCEPTION, 
                                       e.getMessage());
           } finally {
               accesoDatos.closeResultSet(rsTelefono);
             // close(); 
           }
       }
}
