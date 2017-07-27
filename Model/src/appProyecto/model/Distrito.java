package appProyecto.model;

public class Distrito {
    public int idDistrito;
    public int idCanton;
    public String descripcion;
    public boolean estado;
    
    public Distrito() {
        
    }

    public Distrito(int CodDistrito, int CodCanton, String DescDistrito, boolean logActivo) {
        this.idDistrito = CodDistrito;
        this.idCanton = CodCanton;
        this.descripcion = DescDistrito;
        this.estado = logActivo;
    }

    public void setIdDistrito(int CodDistrito) {
        this.idDistrito = CodDistrito;
    }

    public int getIdDistrito() {
        return idDistrito;
    }
    public void setIdCanton(int CodCanton) {
        this.idCanton = CodCanton;
    }

    public int getIdCanton() {
        return idCanton;
    }

    public void setDescripcion(String DescDistrito) {
        this.descripcion = DescDistrito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setEstado(boolean logActivo) {
        this.estado = logActivo;
    }

    public boolean isEstado() {
        return estado;
    }
}
