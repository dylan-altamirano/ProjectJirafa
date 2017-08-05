package appProyecto.view;

import appProyecto.SNMPExceptions;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.naming.NamingException;
import appProyecto.model.UsuarioDB;
import appProyecto.model.Usuario;

/**
 * Bean encargado de manejar la parte de ingreso al sistema.
 */
public class beanIngreso {
    public String Usuario;
    public String Rol;
    public String Clave;
    public String Nulos;
    public beanIngreso() {
    }
    
    /**
     *Este método valida que los campos de ingreso al sistema no queden vacíos.
     * @return
     */
    public String validaNulos(){
        if(this.getUsuario().equalsIgnoreCase("") || 
           this.getRol().equalsIgnoreCase("") || this.getClave().equalsIgnoreCase("")){
        if(this.getUsuario().equalsIgnoreCase("")){
            this.setNulos("Debe completar el espacio de usuario");
            
        }
        if(this.getRol().equalsIgnoreCase("")){
            this.setNulos("Debe completar el espacio de rol");
         
        }
        if( this.getClave().equalsIgnoreCase("")){
            this.setNulos("Debe completar la clave");
            
        }
        }
        else{
            return "bien";
        }
        return "";
    }
    
    /**
     *Método que valida la veracidad de las credenciales de un usuario en
     * específico. 
     * @return
     */
    public String validarUsuario(){
        
        Usuario usuario = new Usuario();
        UsuarioDB usuarioDb = new UsuarioDB();
        
        if (this.validaNulos()) {
            
            try {
                
                usuario = usuarioDb.moBuscarUsuario(this.getUsuario(), this.getClave());
                
                if (usuario!=null) {
                    return "correcto";
                }
                
                
            } catch (Exception e) {
                
                e.printStackTrace();
                return "falso";
            }
            
        }
        
        
        
        return "falso";
    }
    
    public void setUsuario(String Nombre) {
        this.Usuario = Nombre;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public String getRol() {
        return Rol;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getClave() {
        return Clave;
    }

    public void setNulos(String Nulos) {
        this.Nulos = Nulos;
    }

    public String getNulos() {
        return Nulos;
    }
}
