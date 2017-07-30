package appProyecto.model;

public class Canton {
    private int ID;
    private String Descripcion;
    private boolean Estado;
    
    public Canton() {
    }

    public Canton(int ID, String Descripcion, boolean Estado) {
        super();
        this.ID = ID;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }


    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
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
