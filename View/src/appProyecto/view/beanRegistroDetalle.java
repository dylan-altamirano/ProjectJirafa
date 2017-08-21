package appProyecto.view;

import appProyecto.model.TipoServicio;
import appProyecto.model.TipoServicioDB;

import java.util.LinkedList;
import java.util.List;

import javax.faces.model.SelectItem;

public class beanRegistroDetalle {
    
    private String horas;
    
    private List<SelectItem> listaHoras = new LinkedList<SelectItem>();
    
    
    public beanRegistroDetalle() {
        cargaComboTipoServicio();
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
}
