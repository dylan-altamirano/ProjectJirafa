package appProyecto.view;

public class beanRegistroClientes {
    public String ID;
    public String Nombre;
    public String Correo;
    public String Fax;
    public String DescAplicable;
    public String Provincia;
    public String Canton;
    public String Distrito;
    public String Estado;
    public String Telefono;

    public String Nulos;
    
    public beanRegistroClientes() {
    }
    
    public String validaTelefono(){
        if(this.getTelefono().equalsIgnoreCase("")){
           this.setNulos("Debe completar el telefono"); 
        }
        else{
            this.setNulos("");
        }
        return "";
    }
    
    public String validaNulos(){
        if(this.getID().equalsIgnoreCase("") || this.getNombre().equalsIgnoreCase("") ||
        this.getCorreo().equalsIgnoreCase("") || this.getFax().equalsIgnoreCase("") ||
        this.getDescAplicable().equalsIgnoreCase("") || this.getProvincia().equalsIgnoreCase("")
        || this.getCanton().equalsIgnoreCase("") || this.getDistrito().equalsIgnoreCase("") ||
        this.getTelefono().equalsIgnoreCase("") || this.getEstado().equalsIgnoreCase("")){
        if(this.getID().equalsIgnoreCase("")){
           this.setNulos("Debe completar la identificacion"); 
        }
        if(this.getNombre().equalsIgnoreCase("")){
           this.setNulos("Debe completar el nombre"); 
        }
        if(this.getCorreo().equalsIgnoreCase("")){
           this.setNulos("Debe completar el correo"); 
        }
        if(this.getFax().equalsIgnoreCase("")){
           this.setNulos("Debe completar el fax"); 
        }
        if(this.getDescAplicable().equalsIgnoreCase("")){
           this.setNulos("Debe completar el descuento aplicable"); 
        }
        if(this.getProvincia().equalsIgnoreCase("")){
           this.setNulos("Debe completar la provincia"); 
        }
        if(this.getCanton().equalsIgnoreCase("")){
           this.setNulos("Debe completar el canton"); 
        }
        if(this.getDistrito().equalsIgnoreCase("")){
           this.setNulos("Debe completar el distrito"); 
        }
        if(this.getTelefono().equalsIgnoreCase("")){
           this.setNulos("Debe completar el telefono"); 
        }
        if(this.getEstado().equalsIgnoreCase("")){
           this.setNulos("Debe completar el estado"); 
        }
        }else{
            this.setNulos("");
        }
        
        return "";
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    public String getFax() {
        return Fax;
    }

    public void setDescAplicable(String DescAplicable) {
        this.DescAplicable = DescAplicable;
    }

    public String getDescAplicable() {
        return DescAplicable;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setCanton(String Canton) {
        this.Canton = Canton;
    }

    public String getCanton() {
        return Canton;
    }

    public void setDistrito(String Distrito) {
        this.Distrito = Distrito;
    }

    public String getDistrito() {
        return Distrito;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getEstado() {
        return Estado;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setNulos(String Nulos) {
        this.Nulos = Nulos;
    }

    public String getNulos() {
        return Nulos;
    }
}
