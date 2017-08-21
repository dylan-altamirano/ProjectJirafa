package appProyecto.view;

import java.sql.SQLException;

import java.util.LinkedList;

import javax.naming.NamingException;

import appProyecto.model.Cliente;
import appProyecto.model.ClienteDB;

import appProyecto.model.OrdenServicio;
import appProyecto.model.OrdenServicioDB2;

import java.util.List;

import javax.faces.model.SelectItem;

public class beanRegistroOrdenCliente {
    
    private String identificador;
    private String nombre;
    
    private String valorBuscado;
    
    private Cliente cliente;
    private ClienteDB clienteDB;
    private OrdenServicio ordenServicio;
    private OrdenServicioDB2 ordenServicioDB2;
    
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
    
    public void buscarCliente(){
     
     
        if (!this.getValorBuscado().equalsIgnoreCase("")) {
            this.cliente = this.consultarCliente(this.getValorBuscado());
            
            if (this.cliente !=null) {
                
                this.setIdentificador(this.cliente.getID());
                this.setNombre(this.cliente.getNombre());
            }
        }   
    }
    
    /**
     * Crea una orden de servicio en la tabla temporal para comenzar con el flujo
     * de configuracion de la misma
     */
    public void crearOrdenServicio(){
        
        this.ordenServicioDB2 = new OrdenServicioDB2();
        
        try {
            
            //Primero se elimina cualquier dato de la tabla temporal que exista
            this.ordenServicioDB2.eliminarOrdenesServicio();
            
            //se crea el primer registro con el consecutivo requerido
            this.ordenServicioDB2.crearOrdenServicio();
            
            
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }

    }
    
    /**
     *Guarda el ciente en la orden de servicio pre-creada. Es el paso numero del workflow
     * @return
     */
    public String guardar(){
        
        try {
            
            if (!this.getIdentificador().equalsIgnoreCase("")) {
                    
                    //Se crea la orden de servicio primero
                    this.crearOrdenServicio();
                    
                    //se procede a obtener esa orden de servicio
                    ordenServicio = this.ordenServicioDB2.obtenerOrdenServicio();
                    
                    //se procede a guardar el cliente a esa orden de servicio
                    this.ordenServicioDB2.actualizarCliente(ordenServicio.getId(), this.getIdentificador());
                    
                    
                    return "success";
                    
                    }else{
                    return "fail";
                    }
                
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
            
            return "fail";
        }
        
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
