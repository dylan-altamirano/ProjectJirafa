package appProyecto.model;

public class Servicio {
   private String ID;
   private String Descripcion;
   private TipoServicio tipo;
   private double precioPorHora;
   private boolean estado;
   
    public Servicio() {
        this.ID = "";
        this.Descripcion = "";
        this.tipo = new TipoServicio();
        this.precioPorHora = 0.0;
        this.estado = true;
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
