package appProyecto.view;

import appProyecto.model.OrdenServicio;
import appProyecto.model.OrdenServicioDB2;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.faces.model.SelectItem;

public class beanRegistroDetalle {
    
    private String horas;
    private String fecha;
    private String detalle;
    private String observaciones;
    
    private List<SelectItem> listaHoras = new LinkedList<SelectItem>();
    private String mensaje;
    
    private OrdenServicio ordenServicio;
    private OrdenServicioDB2 ordenDB2;
    
    
    public beanRegistroDetalle() {
        cargaComboTipoServicio();
        
        this.horas ="";
        this.fecha = "";
        this.detalle ="";
        this.observaciones = "";
    }
    
    /**
     * Combo cargar de horas
     */
    public void cargaComboTipoServicio(){
        
               try {
                 

                   for (int i=1;i<=24;i++) {

                       this.listaHoras.add(new SelectItem(i, String.valueOf(i)));
                   }


               } catch (Exception e) {
                   // TODO: Add catch code
                   e.printStackTrace();
               } 
    }
    
    public boolean validarNulos(){
        
        if (this.getHoras().equalsIgnoreCase("")|| this.getHoras().equalsIgnoreCase("")) {
            return false;
        }
        
        if (this.getDetalle().equalsIgnoreCase("") || this.getObservaciones().equalsIgnoreCase("")) {
            return false;
        }
        
        
        return true;
    }
    
    
    /**
     *Guarda el detalle en la base de datos
     * @return
     */
    public String guardar(){
        
        this.ordenServicio = new OrdenServicio();
        this.ordenDB2 = new OrdenServicioDB2();
        
        if (this.validarNulos()) {
            
            try {
                
                //se procede a obtener esa orden de servicio
                ordenServicio = this.ordenDB2.obtenerOrdenServicio();
                
                ordenServicio.setFecha(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(this.getFecha()+" 00:00:00"));
                ordenServicio.setEstimacion_horas(Integer.parseInt(this.getHoras()));
                ordenServicio.setDetalle(this.getDetalle());
                ordenServicio.setObservaciones(this.getObservaciones());
                
                //actualizamos la orden de servicio con los detalles faltantes
                this.ordenDB2.actualizarOrdenSevicio(ordenServicio);
                
                
            } catch (Exception e) {
                // TODO: Add catch code
                e.printStackTrace();
                return "fail";
            }
            
            
        }else{
            this.setMensaje("No puede dejar ningun espacio en blanco");
        }
        
        
        return "success";
    }
    

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getHoras() {
        return horas;
    }

    public void setListaHoras(List<SelectItem> listaHoras) {
        this.listaHoras = listaHoras;
    }

    public List<SelectItem> getListaHoras() {
        return listaHoras;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
