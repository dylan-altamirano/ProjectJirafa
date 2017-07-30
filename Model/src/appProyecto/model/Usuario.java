package appProyecto.model;

import java.util.ArrayList;

public class Usuario {
    public String id;
    public String clave;
    public boolean estado;
    public ArrayList<Rol> arrayRoles;
    
    public Usuario() {
        
    }
    public Usuario(String id, String clave, boolean estado, ArrayList<Rol> arrayRoles) {
        
        this.id = id;
        this.clave = clave;
        this.estado = estado;
        this.arrayRoles = arrayRoles;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setArrayRoles(ArrayList<Rol> arrayRoles) {
        this.arrayRoles = arrayRoles;
    }

    public ArrayList<Rol> getArrayRoles() {
        return arrayRoles;
    }
}
