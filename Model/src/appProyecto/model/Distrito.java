package appProyecto.model;

public class Distrito {
    private int idDistrito;
    private String descripcion;
    private boolean estado;
    
    public Distrito() {
        
    }

    public Distrito(int CodDistrito, String DescDistrito, boolean logActivo) {
        this.idDistrito = CodDistrito;
        this.descripcion = DescDistrito;
        this.estado = logActivo;
    }

    public void setIdDistrito(int CodDistrito) {
        this.idDistrito = CodDistrito;
    }

    public int getIdDistrito() {
        return idDistrito;
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
