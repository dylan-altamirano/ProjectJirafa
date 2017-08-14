package appProyecto.model;

public class TipoServicio {
    private String ID;
    private String Descripcion;
    private boolean Estado;
    
    public TipoServicio() {
        this.ID = "";
        this.Descripcion = "";
        this.Estado = true;
    }

    public TipoServicio(String ID, String Descripcion, boolean Estado) {
        this.ID = ID;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
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

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public boolean isEstado() {
        return Estado;
    }
}
