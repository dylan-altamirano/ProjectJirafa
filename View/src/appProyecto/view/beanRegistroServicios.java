package appProyecto.view;

import java.sql.SQLException;

import java.util.LinkedList;

import javax.naming.NamingException;

import appProyecto.model.Servicio;
import appProyecto.model.ServicioDB;
import appProyecto.model.TipoServicio;
import appProyecto.model.TipoServicioDB;

public class beanRegistroServicios {
    private String codigo;
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
    private boolean consultarServicio(String codigo){
        
        boolean bandera = false;
        ServicioDB servicioDB = new ServicioDB();
        try {
            
            bandera = servicioDB.consultarServicio(codigo);
            
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        
        return bandera;
    }
    
    /**
     *valida que los datos sean correctos y guarda o modifica los registros segun la necesidad
     * @return
     */
    public String validar(){
        
        if (this.validaNulos()) {
            
            if (consultarServicio(this.getCodigo())) {
                
                Servicio servicio = new Servicio();
                
                TipoServicioDB tipoDB = new TipoServicioDB();
                TipoServicio tipo = new TipoServicio();
                
                try {
                    
                    tipo = tipoDB.moBuscarTipoServicio(this.getTipoServicio());
                    
                } catch (Exception e) {
                    // TODO: Add catch code
                    e.printStackTrace();
                }
                
                //construimos el objeto servicio
                servicio.setDescripcion(this.getDescripcion());
                servicio.setID(this.getCodigo());
                servicio.setEstado(Boolean.getBoolean(this.getEstado()));
                servicio.setPrecioPorHora(Double.parseDouble(this.getCosto()));
                servicio.setTipo(tipo);
                
                //actualizamos el servicio ya que existe en la base de datos
                this.actualizarServicio(servicio);
            }else{
                Servicio servicio = new Servicio();
                
                TipoServicioDB tipoDB = new TipoServicioDB();
                TipoServicio tipo = new TipoServicio();
                
                try {
                    
                    tipo = tipoDB.moBuscarTipoServicio(this.getTipoServicio());
                    
                } catch (Exception e) {
                    // TODO: Add catch code
                    e.printStackTrace();
                }
                
                //construimos el objeto servicio
                servicio.setDescripcion(this.getDescripcion());
                servicio.setID(this.getCodigo());
                servicio.setEstado(Boolean.getBoolean(this.getEstado()));
                servicio.setPrecioPorHora(Double.parseDouble(this.getCosto()));
                servicio.setTipo(tipo);
                //guardamos el objeto servicio ya que este no existe en la base de datos
                this.insertarServicio(servicio);
            }
            
            
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

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
