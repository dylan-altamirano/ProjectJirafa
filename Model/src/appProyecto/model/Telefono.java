package appProyecto.model;

public class Telefono {
    public String ID;
    public String numero;
    public TipoTelefono tipoTele;
    public boolean Estado;
    
    public Telefono() {
       
    }
    public Telefono(String ID, String numero, TipoTelefono tipoTele, boolean Estado) {
        this.ID = ID;
        this.numero = numero;
        this.tipoTele = tipoTele;
        this.Estado = Estado;
    }
  

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setTipoTele(TipoTelefono tipoTele) {
        this.tipoTele = tipoTele;
    }

    public TipoTelefono getTipoTele() {
        return tipoTele;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }
}
