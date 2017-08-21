package appProyecto.view;

import appProyecto.model.Cliente;
import appProyecto.model.ClienteDB;
import appProyecto.model.Costo_Variable;
import appProyecto.model.Costo_VariableDB;
import appProyecto.model.OrdenServicio;
import appProyecto.model.OrdenServicioDB;
import appProyecto.model.OrdenServicioDB2;
import appProyecto.model.Servicio;
import appProyecto.model.ServicioDB;
import appProyecto.model.TipoServicio;
import appProyecto.model.TipoServicioDB;

import appProyecto.model.Usuario;

import java.text.SimpleDateFormat;

import java.util.Date;

public class beanFacturacion {
    
    private String codigoSolicitud;
    private String fechaRegistro;
    private String fecEjecucion;
    private String estimacionHoras;
    private String estado;
    
    //cliente
    private String idCliente;
    private String nombreCliente;
    private String correoCliente;
    
    //Servicio
    private String idServicio;
    private String nombreServicio;
    private String tipoServicio;
    
    //detalles
    private String costoHora;
    private String subtotal;
    private String total;
    private String deascuentoAplicado;
    private String detalles;
    private String observaciones;
    
    //Orden
    private OrdenServicio orden = new OrdenServicio();
    private OrdenServicioDB ordenDB = new OrdenServicioDB();
    private OrdenServicioDB2 ordenDB2 = new OrdenServicioDB2();
    
    private Cliente cliente = new Cliente();
    private ClienteDB clienteDB = new ClienteDB();
    
    private Servicio servicio = new Servicio();
    private ServicioDB servicioDB = new ServicioDB();
    
    private TipoServicio tipoServ = new TipoServicio();
    private TipoServicioDB tipoServDB = new TipoServicioDB();
    
    private Costo_Variable costo = new Costo_Variable();
    private Costo_VariableDB costoDB = new Costo_VariableDB();
    
    public beanFacturacion() {
    }
    
    /**
     * Obtiene la orden de la base de datos
     */
    public void obtenerOrden(){
                
        try {

                //se procede a obtener esa orden de servicio
                orden = this.ordenDB2.obtenerOrdenServicio();

            
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
            
            //return "fail";
        }

        
    }
    
    /**
     * Obtiene el cliente y se lo agrega a la orden
     */
    private void obtenerCliente(){
        
        try {

               String idCliente = orden.getCliente().getID();
            
               cliente = clienteDB.obtenerCliente(idCliente);
            
               orden.setCliente(cliente); 

            
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
            
            //return "fail";
        }
        
    }
    
    /**
     * Obtiene el servicio y se lo agrega a la orden
     */
    private void obtenerServicio(){
        
        try {

               String idServiciop = orden.getServicio().getID();
                
               servicio = servicioDB.obtenerServicio(idServiciop);
               
               //Obtener el tipo para el servicio
                tipoServ = tipoServDB.moBuscarTipoServicio(servicio.getTipo().getID());
               //Le agrega el tipo al servicio 
               servicio.setTipo(tipoServ);
                //guarda el servicio completo en la orden
               orden.setServicio(servicio); 
               
               
            
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
            
            //return "fail";
        }
        
    }
    
    /**
     * Obtiene los costos variables  y se lo agrega a la orden
     */
    private void obtenerCostosVariables(){
        
        try {

               String idOrden = orden.getId();
                
                orden.setArrayCostos_Variables(costoDB.obtenerCosto_VariablesSegunOrdenServicioTemporal(idOrden));
            
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
            
            //return "fail";
        }
        
    }
    
    private void mostrarOrden(){
        
        Date date = new Date();
        SimpleDateFormat smp = new SimpleDateFormat("dd/MM/yyyy");
        
        this.setCodigoSolicitud(orden.getId());
        this.setFechaRegistro(smp.format(date));
        this.setFecEjecucion(smp.format(orden.getFecha()));   
        this.setEstimacionHoras(String.valueOf(orden.getEstimacion_horas()));
        this.setEstado(orden.getEstado());
        
        //Cliente
        this.setIdCliente(orden.getCliente().getID());
        this.setNombreCliente(orden.getCliente().getNombre());
        this.setCorreoCliente(orden.getCliente().getCorreo());
        
        //servicio
        this.setIdServicio(orden.getServicio().getID());
        this.setNombreServicio(orden.getServicio().getDescripcion());
        this.setTipoServicio(orden.getServicio().getTipo().getDescripcion());
        
        //costos del servicio
        this.setCostoHora(String.valueOf(orden.getServicio().getPrecioPorHora()));
        this.setSubtotal(String.valueOf(orden.calculaPrecioParcial()));
        this.setTotal(String.valueOf(orden.calculaPrecioTotal()));
        this.setDeascuentoAplicado(String.valueOf(orden.calculaDescuento()));
        
        //Mas Detalles
        this.setDetalles(orden.getDetalle());
        this.setObservaciones(orden.getObservaciones());
        
        //Usuario
        orden.setUsuario(new Usuario("administrador","",true,null));
        
    }
    
    /**
     *Formaliza la solicitud del servicio
     * @return
     */
    public String formalizar(){
        
        if (orden != null) {
            
            try {
                
                //guardamos la orden dentro de la base de datos
                ordenDB.insertar(orden);
                
                if (orden.getArrayCostos_Variables().size()>0) {
                    //Insertamos los costos variables
                    for (Costo_Variable costo_Variable : orden.getArrayCostos_Variables()) {
                        
                        costoDB.insertar(costo_Variable, orden.getId());
                        
                        
                    }
                }

            } catch (Exception e) {
                // TODO: Add catch code
                e.printStackTrace();
                return "fail";
            }
            
            
        }
        
        return "success";
    }
    
    
    public void setCodigoSolicitud(String codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }

    public String getCodigoSolicitud() {
        return codigoSolicitud;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFecEjecucion(String fecEjecucion) {
        this.fecEjecucion = fecEjecucion;
    }

    public String getFecEjecucion() {
        return fecEjecucion;
    }

    public void setEstimacionHoras(String estimacionHoras) {
        this.estimacionHoras = estimacionHoras;
    }

    public String getEstimacionHoras() {
        return estimacionHoras;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setCostoHora(String costoHora) {
        this.costoHora = costoHora;
    }

    public String getCostoHora() {
        return costoHora;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal() {
        return total;
    }

    public void setDeascuentoAplicado(String deascuentoAplicado) {
        this.deascuentoAplicado = deascuentoAplicado;
    }

    public String getDeascuentoAplicado() {
        return deascuentoAplicado;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setOrden(OrdenServicio orden) {
        this.orden = orden;
    }

    public OrdenServicio getOrden() {
        return orden;
    }

    public void setOrdenDB(OrdenServicioDB ordenDB) {
        this.ordenDB = ordenDB;
    }

    public OrdenServicioDB getOrdenDB() {
        return ordenDB;
    }

    public void setOrdenDB2(OrdenServicioDB2 ordenDB2) {
        this.ordenDB2 = ordenDB2;
    }

    public OrdenServicioDB2 getOrdenDB2() {
        return ordenDB2;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setClienteDB(ClienteDB clienteDB) {
        this.clienteDB = clienteDB;
    }

    public ClienteDB getClienteDB() {
        return clienteDB;
    }

    public void setTipoServ(TipoServicio tipoServ) {
        this.tipoServ = tipoServ;
    }

    public TipoServicio getTipoServ() {
        return tipoServ;
    }

    public void setTipoServDB(TipoServicioDB tipoServDB) {
        this.tipoServDB = tipoServDB;
    }

    public TipoServicioDB getTipoServDB() {
        return tipoServDB;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicioDB(ServicioDB servicioDB) {
        this.servicioDB = servicioDB;
    }

    public ServicioDB getServicioDB() {
        return servicioDB;
    }
}
