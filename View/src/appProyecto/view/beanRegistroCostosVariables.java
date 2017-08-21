package appProyecto.view;

import appProyecto.model.Costo_Variable;

import appProyecto.model.Costo_VariableDB;

import appProyecto.model.OrdenServicio;
import appProyecto.model.OrdenServicioDB;
import appProyecto.model.OrdenServicioDB2;
import appProyecto.model.TipoCosto;

import java.util.LinkedList;
import java.util.List;

import javax.faces.model.SelectItem;

public class beanRegistroCostosVariables {
    
    private String identificador;
    private String idOrden;
    private String tipo;
    private String monto;
    
    private List<SelectItem> tipoCosto = new LinkedList<SelectItem>();
    private String mensaje;
    
    private Costo_Variable costo;
    private Costo_VariableDB costoDB;
    private OrdenServicio ordenServicio;
    private OrdenServicioDB2 ordenDB2;
    
    private LinkedList<Costo_Variable> listaCostos = new LinkedList<Costo_Variable>();
    
    
    public beanRegistroCostosVariables() {
        cargarComboTipos();
        obtenerOrden();
    }
    
    /**
     * Cargar el combo de tipos de costos variables
     */
    public void cargarComboTipos(){
        
        for (TipoCosto tipoCosto : TipoCosto.values()) {
            this.tipoCosto.add(new SelectItem(tipoCosto.toString(),tipoCosto.toString()));
        }
        
    }
    
    /**
     * Obtiene la orden que se encuentra de manera temporal en la base de datos
     */
    public void obtenerOrden(){
        
        this.ordenServicio = new OrdenServicio();
        this.ordenDB2 = new OrdenServicioDB2();
        
        try {
            
            this.ordenServicio = this.ordenDB2.obtenerOrdenServicio();
            
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }   
    }
    
    /**
     *Valida que no exista valores nulos que se vayan a ingresar
     * @return
     */
    public boolean validarNulos(){
        
        if (this.getTipo().equalsIgnoreCase("")||this.getMonto().equalsIgnoreCase("")) {
            return false;
        }
        
        return true;
    }
    
    public void agregarCosto(){
        
        this.costoDB = new Costo_VariableDB();
        this.setIdOrden(this.ordenServicio.getId());
        
        if (this.validarNulos()) {
            
            this.costo = new Costo_Variable();
             
             //construimos el objeto costo
            this.costo.setId("");
            this.costo.setTipo(TipoCosto.valueOf(this.getTipo()));
            this.costo.setMonto(Double.parseDouble(this.getMonto()));
                            
            
            
            try {
                //Ingresamos el costo en la base de datos
                this.costoDB.insertarRegistoTemporal(costo, this.getIdOrden());

                
            } catch (Exception e) {
                // TODO: Add catch code
                e.printStackTrace();
            }
            
        }
        
    }
    
    
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdOrden(String idOrden) {
        this.idOrden = idOrden;
    }

    public String getIdOrden() {
        return idOrden;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getMonto() {
        return monto;
    }

    public void setTipoCosto(List<SelectItem> tipoCosto) {
        this.tipoCosto = tipoCosto;
    }

    public List<SelectItem> getTipoCosto() {
        return tipoCosto;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setCosto(Costo_Variable costo) {
        this.costo = costo;
    }

    public Costo_Variable getCosto() {
        return costo;
    }

    public void setCostoDB(Costo_VariableDB costoDB) {
        this.costoDB = costoDB;
    }

    public Costo_VariableDB getCostoDB() {
        return costoDB;
    }
}
