package appProyecto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class OrdenServicio {
    
    private String id;
    private Cliente cliente;
    private Servicio servicio;
    private Date fecha;
    private int estimacion_horas;
    private Direccion lugarEjecucion;
    private String detalle;
    private String estado;
    private static LinkedList<Costo_Variable> arrayCostos_Variables  = new LinkedList<Costo_Variable>();;
    private double descuentoAplicado;
    private String observaciones;
    private Usuario usuario;
    
    public OrdenServicio() {
        this.id = "";
        this.cliente = new Cliente();
        this.servicio = new Servicio();
        this.fecha = new Date();
        this.estimacion_horas = 0;
        this.lugarEjecucion = new Direccion();
        this.detalle = "";
        this.estado = "PENDIENTE";
        this.descuentoAplicado = 0.0;
        this.observaciones = "";
        this.usuario = new Usuario();
        this.usuario.setId("administrador");
    }

    public OrdenServicio(String id, Cliente cliente, Servicio servicio, Date fecha, int estimacion_horas,
                         Direccion lugarEjecucion, String detalle, String estado,
                         LinkedList<Costo_Variable> arrayCostos_Variables, double descuentoAplicado,
                         String observaciones, Usuario usuario) {
       
        this.id = id;
        this.cliente = cliente;
        this.servicio = servicio;
        this.fecha = fecha;
        this.estimacion_horas = estimacion_horas;
        this.lugarEjecucion = lugarEjecucion;
        this.detalle = detalle;
        this.estado = estado;
        this.arrayCostos_Variables = arrayCostos_Variables;
        this.descuentoAplicado = descuentoAplicado;
        this.observaciones = observaciones;
        this.usuario = usuario;
    }

//Metodos
    /**
     *Calcula el total del monto a pagar por los costos variables de la orden
     * de servicio. Retorna un valor que sera almacenado como total.
     * @return
     */
    public double montoTotalCostosVariables(){
      
      double monto=0.0;  
        
        for (Costo_Variable costo_Variable : arrayCostos_Variables) {
            monto += costo_Variable.getMonto();
        }
        
        return monto;
    }
    /**
     *Agrega un costo variable al array de costos variables
     * @param costo
     */
    public void agregarCostoVariable(Costo_Variable costo){
        this.arrayCostos_Variables.add(costo);
    }
    
    /**
     *Calcula el descuento del servicio deacuerdo al cliente
     * @return
     */
    public double calculaDescuento(){
        
        double monto = 0.0;
        
        monto =+ this.calculaPrecioParcial()*(this.cliente.getDescAplicable()/100);
        
        return monto;
    }
    
    /**
     *Calcula el precio parcial del servicio
     * @return
     */
    public double calculaPrecioParcial(){
        
        return (this.servicio.getPrecioPorHora()*this.getEstimacion_horas())+this.montoTotalCostosVariables();
    }
    
    /**
     *Calcula el precio total, incluyendo el descuento aplicable del cliente al servicio contratado
     * @return
     */
    public double calculaPrecioTotal(){
        
        return this.calculaPrecioParcial()-this.calculaDescuento();
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setEstimacion_horas(int estimacion_horas) {
        this.estimacion_horas = estimacion_horas;
    }

    public int getEstimacion_horas() {
        return estimacion_horas;
    }

    public void setLugarEjecucion(Direccion lugarEjecucion) {
        this.lugarEjecucion = lugarEjecucion;
    }

    public Direccion getLugarEjecucion() {
        return lugarEjecucion;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setArrayCostos_Variables(LinkedList<Costo_Variable> arrayCostos_Variables) {
        this.arrayCostos_Variables = arrayCostos_Variables;
    }

    public LinkedList<Costo_Variable> getArrayCostos_Variables() {
        return arrayCostos_Variables;
    }

    public void setDescuentoAplicado(double descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    public double getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
