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
            "Select  IDDistrito, IDCanton, Descripcion, Estado" +
            "from Distrito where IDCanton = " + codCanton;
            
            //Se ejecuta la sentencia SQL
            ResultSet rsEM = accesoDatos.ejecutaSQLRetornaRS(select);

            while (rsEM.next()) {

                int IDDistrito = rsEM.getInt("IDDistrito");
                int IDCanton = rsEM.getInt("IDCanton");
                String Descripcion = rsEM.getString("Descripcion");
                boolean estado = rsEM.getBoolean("Estado");
                
                
                Distrito dis = new Distrito(IDDistrito,IDCanton,Descripcion,estado);
                
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
        
        return listaDistrito;
    }
    public Distrito obtenerDistrito(int codigoDistrito) throws SNMPExceptions {
        String strSQL = "";
        Distrito distrito = new Distrito();
        try {

            strSQL = 
                    "Select  IDCanton, Descripcion, Estado" +
                "from Distrito where IDDistrito = " + codigoDistrito;
            //Se ejecuta la sentencia SQL
            ResultSet rsEM = accesoDatos.ejecutaSQLRetornaRS(strSQL);
            while (rsEM.next()) {
            
                int IDDistrito = rsEM.getInt("IDDistrito");
                int IDCanton = rsEM.getInt("IDCanton");
                String Descripcion = rsEM.getString("Descripcion");
                boolean estado = rsEM.getBoolean("Estado");
                
                
                Distrito dis = new Distrito(IDDistrito,IDCanton,Descripcion,estado);
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
}
