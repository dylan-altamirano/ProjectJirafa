package appProyecto.view;

import appProyecto.model.OrdenServicio;
import appProyecto.model.OrdenServicioDB2;
import appProyecto.model.Servicio;
import appProyecto.model.ServicioDB;
import appProyecto.model.TipoServicio;

import appProyecto.model.TipoServicioDB;

import java.util.LinkedList;
import java.util.List;

import javax.faces.model.SelectItem;

public class beanRegistroOrdenServicio {
    
    private String codigo;
    private String Descripcion;
    private String TipoServicio;
    private String Estado;
    private String Costo;
    private String Nulos;
    
    private LinkedList<TipoServicio> listaTipoServicios;
    private List<SelectItem> tipoServicios = new LinkedList<SelectItem>();
    private String tipoServicioSeleccionado="";
    
    //lista de servicios
    static LinkedList<Servicio> listaServicios = new LinkedList<Servicio>();
    
    private String opcionFiltrado;
    private String valorBuscado;
    
    private Servicio servicio;
    private OrdenServicio ordenServicio;
    private OrdenServicioDB2 ordenServicioDB2;
    
    
    public beanRegistroOrdenServicio() {
    }
    
    /**
     *Consulta la existencia de un servicio en la base de datos
     * @return
     */
    private Servicio obtenerServicio(String codigo){
        Servicio servicio = new Servicio();
        ServicioDB servicioDB = new ServicioDB();
        TipoServicioDB tipoDB = new TipoServicioDB();
        
        try {
            
            servicio = servicioDB.obtenerServicio(codigo);
            //Llena el objeto tipo servicio con la informacion que se encuentra del ID en tipo servicio
            servicio.setTipo(tipoDB.moBuscarTipoServicio(servicio.getTipo().getID()));
            
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        
        return servicio;
    }
    
    /**
     *Consulta la existencia de un servicio en la base de datos
     * @return
     */
    private boolean consultarServicio(String codigo){
        
        boolean bandera = false;
        ServicioDB servicioDB = new ServicioDB();
        try {
            
            bandera = servicioDB.consultarServicio(codigo);
            
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        
        return bandera;
    }
    
    /**
     *Obtiene una lista de servicios filtrados segun ola categoria de filtrado
     * @param valorFiltro
     * @param categoriaFiltrado
     * @return
     */
    private LinkedList<Servicio> obtenerServiciosSegunFiltrado(String valorFiltro, int categoriaFiltrado){
        LinkedList<Servicio> listaServicio = new LinkedList<Servicio>();
        ServicioDB servicioDB = new ServicioDB();
        TipoServicioDB tipoDB = new TipoServicioDB();
        
        switch (categoriaFiltrado) {
        case 2:
            
            try {
                //Obtiene una lista de servicios segun su categoria de filtro
                listaServicio = servicioDB.obtenerServiciosSegunNombre(valorFiltro);
                //recorre el arreglo de servicios y los llena con su respectivo objeto de servicio para cada uno
                for (Servicio servicio1 : listaServicio) {
                    //Llena el objeto tipo servicio con la informacion que se encuentra del ID en tipo servicio
                    servicio1.setTipo(tipoDB.moBuscarTipoServicio(servicio1.getTipo().getID()));
                }
            
            } catch (Exception e) {
                // TODO: Add catch code
                e.printStackTrace();
            }
            
            break;
        case 3:
            
            try {
                //Obtiene una lista de servicios segun su categoria de filtro
                listaServicio = servicioDB.obtenerServiciosSegunTipo(valorFiltro);
                //recorre el arreglo de servicios y los llena con su respectivo objeto de servicio para cada uno
                for (Servicio servicio1 : listaServicio) {
                    //Llena el objeto tipo servicio con la informacion que se encuentra del ID en tipo servicio
                    servicio1.setTipo(tipoDB.moBuscarTipoServicio(servicio1.getTipo().getID()));
                }
            
            } catch (Exception e) {
                // TODO: Add catch code
                e.printStackTrace();
            }
            
            break;
            case 4:
                
                try {
                    //Obtiene una lista de servicios segun su categoria de filtro
                    listaServicio = servicioDB.obtenerServiciosSegunEstado(true);
                    //recorre el arreglo de servicios y los llena con su respectivo objeto de servicio para cada uno
                    for (Servicio servicio1 : listaServicio) {
                        //Llena el objeto tipo servicio con la informacion que se encuentra del ID en tipo servicio
                        servicio1.setTipo(tipoDB.moBuscarTipoServicio(servicio1.getTipo().getID()));
                    }
                
                } catch (Exception e) {
                    // TODO: Add catch code
                    e.printStackTrace();
                }
                
                break;
        default:
        }

        return listaServicio;
    }
    
    /**
     * Llena la lista de filtrado de registros a mostrar cuando estos son consultados.
     */
    public void obtenerLista(){
        
        switch (Integer.parseInt(this.getOpcionFiltrado())) {
        case 1:
            
            if (this.consultarServicio(this.getValorBuscado())) {
                this.getListaServicios().add(this.obtenerServicio(this.getValorBuscado()));
            }
            
            break;
        case 2:
            
            this.setListaServicios(this.obtenerServiciosSegunFiltrado(this.getValorBuscado(), 2));
            
            break;
        case 3:
            
            this.setListaServicios(this.obtenerServiciosSegunFiltrado(this.getValorBuscado(), 3));
            
            break;
        case 4:
            this.setListaServicios(this.obtenerServiciosSegunFiltrado(this.getValorBuscado(), 4));
            
            break;
        default:
        }
        
        
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setTipoServicio(String TipoServicio) {
        this.TipoServicio = TipoServicio;
    }

    public String getTipoServicio() {
        return TipoServicio;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getEstado() {
        return Estado;
    }

    public void setCosto(String Costo) {
        this.Costo = Costo;
    }

    public String getCosto() {
        return Costo;
    }

    public void setNulos(String Nulos) {
        this.Nulos = Nulos;
    }

    public String getNulos() {
        return Nulos;
    }

    public void setListaTipoServicios(LinkedList<TipoServicio> listaTipoServicios) {
        this.listaTipoServicios = listaTipoServicios;
    }

    public LinkedList<TipoServicio> getListaTipoServicios() {
        return listaTipoServicios;
    }

    public void setTipoServicios(List<SelectItem> tipoServicios) {
        this.tipoServicios = tipoServicios;
    }

    public List<SelectItem> getTipoServicios() {
        return tipoServicios;
    }

    public void setTipoServicioSeleccionado(String tipoServicioSeleccionado) {
        this.tipoServicioSeleccionado = tipoServicioSeleccionado;
    }

    public String getTipoServicioSeleccionado() {
        return tipoServicioSeleccionado;
    }

    public static void setListaServicios(LinkedList<Servicio> listaServicios) {
        beanRegistroOrdenServicio.listaServicios = listaServicios;
    }

    public static LinkedList<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setOpcionFiltrado(String opcionFiltrado) {
        this.opcionFiltrado = opcionFiltrado;
    }

    public String getOpcionFiltrado() {
        return opcionFiltrado;
    }

    public void setValorBuscado(String valorBuscado) {
        this.valorBuscado = valorBuscado;
    }

    public String getValorBuscado() {
        return valorBuscado;
    }
}
