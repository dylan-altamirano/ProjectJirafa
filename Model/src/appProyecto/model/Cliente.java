package appProyecto.model;

import java.util.ArrayList;

public class Cliente {
    private String ID;
    private String Nombre;
    private String Correo;
    private String Fax;
    private double DescAplicable;
    private Direccion direccion;
    private String Estado;
    
    private ArrayList<Telefono> arrayTelefonos;
    

    public Cliente() {
        
    }

    public Cliente(String ID, String Nombre, String Correo, String Fax, double DescAplicable, Direccion direccion,
                   String Estado, ArrayList<Telefono> arrayTelefonos) {
        super();
        this.ID = ID;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Fax = Fax;
        this.DescAplicable = DescAplicable;
        this.direccion = direccion;
        this.Estado = Estado;
        this.arrayTelefonos = arrayTelefonos;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    public String getFax() {
        return Fax;
    }

    public void setDescAplicable(double DescAplicable) {
        this.DescAplicable = DescAplicable;
    }

    public double getDescAplicable() {
        return DescAplicable;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getEstado() {
        return Estado;
    }

    public void setArrayTelefonos(ArrayList<Telefono> arrayTelefonos) {
        this.arrayTelefonos = arrayTelefonos;
    }

    public ArrayList<Telefono> getArrayTelefonos() {
        return arrayTelefonos;
    }
}
