package appProyecto.view;



import appProyecto.model.Rol;

import appProyecto.model.RolDB;

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
    public boolean validaNulos(){
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
            return true;
        }
        return false;
    }
    
    /**
     *Método que valida la veracidad de las credenciales de un usuario en
     * específico. 
     * @return
     */
    public String validarUsuario(){
        
        Usuario usuario = new Usuario();
        UsuarioDB usuarioDb = new UsuarioDB();
        LinkedList<Rol> roles = new LinkedList<Rol>();
        RolDB rolDb = new RolDB();
        
        //Valida que los campos no esten nulos
        if (this.validaNulos()) {
            
            try {
                //Obtiene primero el usuario del repositorio de datos
                usuario = usuarioDb.moBuscarUsuario(this.getUsuario(), this.getClave());
                //Obtiene el rol del respositorio de datos segun el usuario
                roles = rolDb.moBuscarRolesSegunUsuario(this.getUsuario());
                
                if (usuario!=null) {
                //Agrega el rol al usuario    
                usuario.setArrayRoles(roles);
                //Por ultimo se revisa que el rol seleccionado se encuentre de los roles que el posee el usuario 
                for (Rol rol : roles) {
                    if (rol.getDescripcion().equalsIgnoreCase(this.getRol())) {
                            return "correcto";           
                        }        
                }
                 
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
