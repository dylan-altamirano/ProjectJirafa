package appProyecto.view;

public class beanIngreso {
    public String Usuario;
    public String Rol;
    public String Clave;
    public String Nulos;
    public beanIngreso() {
    }
    
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
