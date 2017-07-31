package appProyecto.model;

public class Direccion {
    private String ID;
    private Provincia provincia;
    private Canton canton;
    private Distrito distrito;
    private String detalle;
    private boolean estado;
    
    public Direccion() {
        this.ID = "";
        this.provincia = new Provincia();
        this.canton = new Canton();
        this.distrito = new Distrito();
        this.detalle = "";
        this.estado=true;
    }

    public Direccion(String ID, Provincia provincia, Canton canton, Distrito distrito, String detalle) {
        super();
        this.ID = ID;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.detalle = detalle;
    }


    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }

    public Canton getCanton() {
        return canton;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }
}
