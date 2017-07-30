package appProyecto.model;

public class Provincia {
    private String ID;
    private String Descripcion;
    private boolean Estado;
    
    public Provincia() {
        super();
    }

    public Provincia(String ID, String Descripcion, boolean Estado) {
        super();
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
