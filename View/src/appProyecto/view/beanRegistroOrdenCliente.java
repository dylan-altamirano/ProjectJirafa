package appProyecto.view;

import java.sql.SQLException;

import java.util.LinkedList;

import javax.naming.NamingException;

import appProyecto.model.Cliente;
import appProyecto.model.ClienteDB;

import appProyecto.model.OrdenServicioDB;

import java.util.List;

import javax.faces.model.SelectItem;

public class beanRegistroOrdenCliente {
    
    private String identificador;
    private String nombre;
    
    private String valorBuscado;
    
    private Cliente cliente;
    private ClienteDB clienteDB;
    private OrdenServicioDB ordenServicioDB;
    
    public beanRegistroOrdenCliente() {
        
        this.clienteDB = new ClienteDB();
    }
    
    public Cliente consultarCliente(String id){
        
        cliente = new Cliente();
        
        
        try {
            
            if (this.clienteDB.consultarCliente(id)) {
                
                cliente = this.clienteDB.obtenerCliente(id);
                
            }

        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        
        return cliente;
    }
    
    public String buscarCliente(){
     
     
        if (!this.getValorBuscado().equalsIgnoreCase("")) {
            this.cliente = this.consultarCliente(this.getValorBuscado());
            
            if (this.cliente !=null) {
                
                this.setIdentificador(this.cliente.getID());
                this.setNombre(this.cliente.getNombre());
            }
        }   

        return "";
    }
    
    public String guardar(){
        
        try {
            
            if (this.cliente != null) {
                
                
            }
            
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        
        return "";
    }
    
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setValorBuscado(String valorBuscado) {
        this.valorBuscado = valorBuscado;
    }

    public String getValorBuscado() {
        return valorBuscado;
    }
}
