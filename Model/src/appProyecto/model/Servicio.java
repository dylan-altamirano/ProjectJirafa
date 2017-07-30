package appProyecto.model;

public class Servicio {
   public String ID;
   public String Descripcion;
   public TipoServicio tipo;
   public double precioPorHora;
   public boolean estado;
   
    public Servicio() {
    
    }

    public Servicio(String ID, String Descripcion, TipoServicio tipo, double precioPorHora, boolean estado) {
        this.ID = ID;
        this.Descripcion = Descripcion;
        this.tipo = tipo;
        this.precioPorHora = precioPorHora;
        this.estado = estado;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }

    public TipoServicio getTipo() {
        return tipo;
    }

    public void setPrecioPorHora(double precioPorHora) {
        this.precioPorHora = precioPorHora;
    }

    public double getPrecioPorHora() {
        return precioPorHora;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }
}
