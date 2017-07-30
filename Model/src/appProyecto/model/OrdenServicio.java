package appProyecto.model;

import java.util.ArrayList;
import java.util.Date;

public class OrdenServicio {
    
    private String id;
    private Cliente cliente;
    private Servicio servicio;
    private Date fecha;
    private int estimacion_horas;
    private Direccion lugarEjecucion;
    private String detalle;
    private boolean estado;
    private ArrayList<Costo_Variable> arrayCostos_Variables;
    private double descuentoAplicado;
    private String observaciones;
    private Usuario usuario;
    
    public OrdenServicio() {
        super();
    }

    public OrdenServicio(String id, Cliente cliente, Servicio servicio, Date fecha, int estimacion_horas,
                         Direccion lugarEjecucion, String detalle, boolean estado,
                         ArrayList<Costo_Variable> arrayCostos_Variables, double descuentoAplicado,
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

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setArrayCostos_Variables(ArrayList<Costo_Variable> arrayCostos_Variables) {
        this.arrayCostos_Variables = arrayCostos_Variables;
    }

    public ArrayList<Costo_Variable> getArrayCostos_Variables() {
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
