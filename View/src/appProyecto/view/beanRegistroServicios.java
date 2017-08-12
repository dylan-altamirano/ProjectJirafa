package appProyecto.view;

import java.sql.SQLException;

import java.util.LinkedList;

import javax.naming.NamingException;

import appProyecto.model.Servicio;
import appProyecto.model.ServicioDB;
import appProyecto.model.TipoServicio;
import appProyecto.model.TipoServicioDB;

public class beanRegistroServicios {
    private String Descripcion;
    private String TipoServicio;
    private String Estado;
    private String Costo;
    private String Nulos;
    
    public beanRegistroServicios() {
    }
    
    /**
     *Método que valida que los campos no queden nulos
     * @return
     */
    public boolean validaNulos(){
        if(this.getDescripcion().equalsIgnoreCase("") 
           || this.getTipoServicio().equalsIgnoreCase("")
           ||this.getCosto().equalsIgnoreCase("")){
        
            
            if(this.getDescripcion().equalsIgnoreCase("") ){
             this.setNulos("Debe completar la descripcion");  
             return false;
            }
            if(this.getTipoServicio().equalsIgnoreCase("")){
             this.setNulos("Debe completar el tipo de servicio");   
             return false;
            }
            if(this.getCosto().equalsIgnoreCase("")){
             this.setNulos("Debe completar el costo");   
             return false;
            }
           }else{
                this.setNulos("");
            return true;
            }
        
        return true;
    }
    
    /**
     *Inserta un servicio en la base de datos
     * @param servicio
     */
    private void insertarServicio(Servicio servicio){
        
        ServicioDB servicioDB = new ServicioDB();
        //TipoServicioDB tipoDB = new TipoServicioDB();
        
        try {
            //Inserta el servicio especifico
            servicioDB.insertar(servicio);
            //Inserta el tipo de servicio asociado con el objeto
            //tipoDB.mvAgregarTipoServicio(servicio.getTipo());
            
        } catch (Exception e) {
            // TODO: Add catch code
            this.setNulos("Ha ocurrido un error al guardar el servicio. Por favor vea el detalle del error aca: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     *Actualizar el servicio espeficicado
     * @param servicio
     */
    private void actualizarServicio(Servicio servicio){
        
        ServicioDB servicioDB = new ServicioDB();
        TipoServicioDB tipoDB = new TipoServicioDB();
        
        try {
            //Inserta el servicio especifico
            servicioDB.actualizar(servicio);
            //Inserta el tipo de servicio asociado con el objeto
            tipoDB.mvActualizarTipoServicio(servicio.getTipo());
            
        } catch (Exception e) {
            // TODO: Add catch code
            this.setNulos("Ha ocurrido un error al actualizar el servicio. Por favor vea el detalle del error aca: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     *Consulta la existencia de un servicio en la base de datos
     * @return
     */
    private boolean consultarServicio(){
        
        boolean bandera = false;
        ServicioDB servicioDB = new ServicioDB();
        try {
            
            bandera = servicioDB.consultarServicio("");
            
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        
        return bandera;
    }

    public String validar(){
        
        if (this.validaNulos()) {
            
            
            
            
        }
        
        
        return "";
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setTipoServicio(String TipoServicio) {
        this.TipoServicio = TipoServicio;
    }

    public String getTipoServicio() {
        return TipoServicio;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getEstado() {
        return Estado;
    }

    public void setCosto(String Costo) {
        this.Costo = Costo;
    }

    public String getCosto() {
        return Costo;
    }

    public void setNulos(String Nulos) {
        this.Nulos = Nulos;
    }

    public String getNulos() {
        return Nulos;
    }
}
