package appProyecto.view;

import java.sql.SQLException;

import java.util.LinkedList;

import javax.naming.NamingException;

import appProyecto.model.Cliente;
import appProyecto.model.ClienteDB;

import java.util.List;

import javax.faces.model.SelectItem;

public class beanRegistroOrdenCliente {
    
    private String identificador;
    private String nombre;
    
    private Cliente cliente;
    private ClienteDB clienteDB;
    
    public beanRegistroOrdenCliente() {
        
        this.clienteDB = new ClienteDB();
    }
    
    private boolean consultarCliente(String id){
        
        cliente = new Cliente();
        
        
        try {
            
            if (this.clienteDB.consultarCliente(id)) {
                
                cliente = this.clienteDB.obtenerCliente(id);
                
            }

        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        
        return false;
    }
}
