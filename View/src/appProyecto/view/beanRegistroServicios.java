package appProyecto.view;

public class beanRegistroServicios {
    public String Descripcion;
    public String TipoServicio;
    public String Estado;
    public String Costo;
    public String Nulos;
    
    public beanRegistroServicios() {
    }
    public String validaNulos(){
        if(this.getDescripcion().equalsIgnoreCase("") 
           || this.getTipoServicio().equalsIgnoreCase("")
           ||this.getCosto().equalsIgnoreCase("")){
            
            if(this.getDescripcion().equalsIgnoreCase("") ){
             this.setNulos("Debe completar la descripcion");   
            }
            if(this.getTipoServicio().equalsIgnoreCase("")){
             this.setNulos("Debe completar el tipo de servicio");   
            }
            if(this.getCosto().equalsIgnoreCase("")){
             this.setNulos("Debe completar el costo");   
            }
           }else{
                this.setNulos("");
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
