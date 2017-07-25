package appProyecto.view;

public class beanRegistroTipoServicios {
    public String Identificador;
    public String Descripcion;
    public String Estado;
    public String Nulos;
    
    public beanRegistroTipoServicios() {
    }
    
    public String ValidaNulos(){
        if(this.getIdentificador().equalsIgnoreCase("")
           || this.getDescripcion().equalsIgnoreCase("")
           || this.getEstado().equalsIgnoreCase("")){
            
            if(this.getIdentificador().equalsIgnoreCase("")){
               this.setNulos("Debe completar el espacio de identificacion"); 
            }
            if(this.getDescripcion().equalsIgnoreCase("")){
               this.setNulos("Debe completar el espacio de descripción"); 
            }
        }
        else{
            this.setNulos("");
        }
        return "";
    }

    public void setIdentificador(String Identificador) {
        this.Identificador = Identificador;
    }

    public String getIdentificador() {
        return Identificador;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getEstado() {
        return Estado;
    }

    public void setNulos(String Nulos) {
        this.Nulos = Nulos;
    }

    public String getNulos() {
        return Nulos;
    }
}
