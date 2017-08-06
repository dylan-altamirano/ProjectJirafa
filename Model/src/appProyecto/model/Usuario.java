package appProyecto.model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Usuario {
    public String id;
    public String clave;
    public boolean estado;
    public LinkedList<Rol> arrayRoles;
    
    public Usuario() {
        
    }
    public Usuario(String id, String clave, boolean estado, LinkedList<Rol> arrayRoles) {
        
        this.id = id;
        this.clave = clave;
        this.estado = estado;
        this.arrayRoles = arrayRoles;
    }
    
    /**
     *Agrega un rol al array de roles de usuario.
     * @param rol
     */
    public void agregarRol(Rol rol){
        this.arrayRoles.add(rol);
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

    public void setArrayRoles(LinkedList<Rol> arrayRoles) {
        this.arrayRoles = arrayRoles;
    }

    public LinkedList<Rol> getArrayRoles() {
        return arrayRoles;
    }
}
