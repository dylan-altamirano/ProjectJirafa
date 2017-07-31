package appProyecto.model;

import appProyecto.AccesoDatos;
import appProyecto.SNMPExceptions;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;

import javax.naming.NamingException;

public class Costo_VariableDB {
    private AccesoDatos accesoDatos = new AccesoDatos();
    public Costo_VariableDB() {
        super();
    }
    
    public void insertar(Costo_Variable costoVariable, String idOrden) throws SNMPExceptions, SQLException {
        
            String strSQL = "";
            try {
            
                strSQL = 
                        "INSERT INTO Costo_Variable VALUES ('" + costoVariable.getId() +"','" +idOrden+ "','" + costoVariable.getTipo().toString() +"','" + costoVariable.getMonto() +"')";
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
    
    public LinkedList<Costo_Variable> obtenerCosto_VariablesSegunOrdenServicio(String idOrden) throws SNMPExceptions, SQLException {
         //  ResultSet rsPA = null;
           String strSQL = "";
           Costo_Variable Costo_Variable;
           LinkedList<Costo_Variable> listaCosto_Variables = new LinkedList<Costo_Variable>();
           
           try {
           //  open();
               strSQL = 
                       "Select ID, IDOrdenServicio, tipo, monto from Costo_Variable where IDOrdenServicio="+idOrden;
               //Se ejecuta la sentencia SQL
               ResultSet rsCosto_Variable = accesoDatos.ejecutaSQLRetornaRS(strSQL);
               while (rsCosto_Variable.next()) {
                   
                Costo_Variable = new Costo_Variable();
               
                Costo_Variable.setId(rsCosto_Variable.getString("ID"));
                Costo_Variable.setTipo(TipoCosto.valueOf(rsCosto_Variable.getString("tipo")));
                Costo_Variable.setMonto(rsCosto_Variable.getDouble("monto")); //Solo se trae el ID del tipo Costo_Variable para adjuntarle el objeto completo despues   
               
               listaCosto_Variables.add(Costo_Variable);
               
               }
               rsCosto_Variable.close();
               
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
           return listaCosto_Variables;
       }
}
