package appProyecto.view;

import java.sql.SQLException;

import java.util.LinkedList;

import javax.naming.NamingException;

import appProyecto.model.Servicio;
import appProyecto.model.ServicioDB;
import appProyecto.model.TipoServicio;
import appProyecto.model.TipoServicioDB;

import java.util.List;

import javax.faces.model.SelectItem;

public class beanRegistroServicios {
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
    
    //mensaje
    private String mensajeConfirmacion;
    
    public beanRegistroServicios() {
        cargaComboTipoServicio();
    }
    
    /**
     * Combo cargar tipos de servicios
     */
    public void cargaComboTipoServicio(){
        
        TipoServicioDB tipoDB = new TipoServicioDB();

               try {
                   this.listaTipoServicios = tipoDB.moCargarTipoServicioSegunEstado(true);

                   for (TipoServicio tipo : listaTipoServicios) {

                       this.tipoServicios.add(new SelectItem(tipo.getID(), tipo.getDescripcion()));
                   }


               } catch (Exception e) {
                   // TODO: Add catch code
                   e.printStackTrace();
               } 
    }
    
    
    /**
     *M�todo que valida que los campos no queden nulos
     * @return
     */
    public boolean validaNulos(){
        if(this.getDescripcion().equalsIgnoreCase("") 
           || this.getTipoServicio().equalsIgnoreCase("")
           ||this.getCosto().equalsIgnoreCase("")){
        
            
            if(this.getDescripcion().equalsIgnoreCase("") ){
             this.setNulos("Debe completar la descripcion");  
             return false;
            }
            if(this.getTipoServicio().equalsIgnoreCase("")){
             this.setNulos("Debe completar el tipo de servicio");   
             return false;
            }
            if(this.getCosto().equalsIgnoreCase("")){
             this.setNulos("Debe completar el costo");   
             return false;
            }
           }else{
                this.setNulos("");
            return true;
            }
        
        return true;
    }
    
    /**
     *Inserta un servicio en la base de datos
     * @param servicio
     */
    private void insertarServicio(Servicio servicio){
        
        ServicioDB servicioDB = new ServicioDB();
        //TipoServicioDB tipoDB = new TipoServicioDB();
        
        try {
            //Inserta el servicio especifico
            servicioDB.insertar(servicio);
            //Inserta el tipo de servicio asociado con el objeto
            //tipoDB.mvAgregarTipoServicio(servicio.getTipo());
            
        } catch (Exception e) {
            // TODO: Add catch code
            this.setNulos("Ha ocurrido un error al guardar el servicio. Por favor vea el detalle del error aca: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     *Actualizar el servicio espeficicado
     * @param servicio
     */
    private void actualizarServicio(Servicio servicio){
        
        ServicioDB servicioDB = new ServicioDB();
        TipoServicioDB tipoDB = new TipoServicioDB();
        
        try {
            //Inserta el servicio especifico
            servicioDB.actualizar(servicio);
            //Inserta el tipo de servicio asociado con el objeto
            tipoDB.mvActualizarTipoServicio(servicio.getTipo());
            
        } catch (Exception e) {
            // TODO: Add catch code
            this.setNulos("Ha ocurrido un error al actualizar el servicio. Por favor vea el detalle del error aca: "+e.getMessage());
            e.printStackTrace();
        }
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
     *Valida que los datos sean correctos y guarda o modifica los registros segun la necesidad
     * @return
     */
    public String validar(){
        
        this.setTipoServicio(this.getTipoServicioSeleccionado());
        
        if (this.validaNulos()) {
            
            if (consultarServicio(this.getCodigo())) {
                
                Servicio servicio = new Servicio();
                
                TipoServicioDB tipoDB = new TipoServicioDB();
                TipoServicio tipo = new TipoServicio();
                
                try {
                    
                    tipo = tipoDB.moBuscarTipoServicio(this.getTipoServicio());
                    
                } catch (Exception e) {
                    // TODO: Add catch code
                    e.printStackTrace();
                }
                
                //construimos el objeto servicio
                servicio.setDescripcion(this.getDescripcion());
                servicio.setID(this.getCodigo());
                servicio.setEstado(this.getEstado().equalsIgnoreCase("1")?true:false);
                servicio.setPrecioPorHora(Double.parseDouble(this.getCosto()));
                servicio.setTipo(tipo);
                
                //actualizamos el servicio ya que existe en la base de datos
                this.actualizarServicio(servicio);
                
                this.setMensajeConfirmacion("Se ha actualizado el registro con exito");
                
                this.limpiarControles();
            }else{
                Servicio servicio = new Servicio();
                
                TipoServicioDB tipoDB = new TipoServicioDB();
                TipoServicio tipo = new TipoServicio();
                
                try {
                    
                    tipo = tipoDB.moBuscarTipoServicio(this.getTipoServicio());
                    
                } catch (Exception e) {
                    // TODO: Add catch code
                    e.printStackTrace();
                }
                
                //construimos el objeto servicio
                servicio.setDescripcion(this.getDescripcion());
                servicio.setID(this.getCodigo());
                servicio.setEstado(this.getEstado().equalsIgnoreCase("1")?true:false);
                servicio.setPrecioPorHora(Double.parseDouble(this.getCosto()));
                servicio.setTipo(tipo);
                //guardamos el objeto servicio ya que este no existe en la base de datos
                this.insertarServicio(servicio);
                
                this.setMensajeConfirmacion("Se ha guardado el registro con exito");
                
               this.limpiarControles();
            }
            
            
        }
        
        
        return "";
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
        default:
        }
        
        
    }
    /**
     *Metodo encargado de "eliminar" el registro de la base de datos.
     * @param id
     * @return
     */
    public void eliminar(String id){
        
        ServicioDB servicioDB = new ServicioDB();
        
        try {
            
            servicioDB.eliminarServicio(id);
            
            this.setMensajeConfirmacion("Se ha eliminiado el registro solicitado");
            
        } catch (Exception e) {
            // TODO: Add catch code
            this.setMensajeConfirmacion("No se ha podido eliminar el registro solicitado");
            e.printStackTrace();
        }
        
    }
    
    /**
     *Llama al m�todo para eliminar el registro que se presente 
     * para suprimir.
     * @return
     */
    public String eliminarDatos(){
        
        this.setTipoServicio(this.getTipoServicioSeleccionado());
        
        if (this.validaNulos()) {
            this.eliminar(this.getCodigo());
        }
        
        
        return "";
    }
    
    public void limpiarControles(){
        this.setCodigo("");
        this.setCosto("");
        this.setDescripcion("");
        this.setEstado("");
        this.listaServicios = new LinkedList<Servicio>();
        this.setOpcionFiltrado("");
        
        
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

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
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

    public void setOpcionFiltrado(String opcionFiltrado) {
        this.opcionFiltrado = opcionFiltrado;
    }

    public String getOpcionFiltrado() {
        return opcionFiltrado;
    }

    public static void setListaServicios(LinkedList<Servicio> listaServicios) {
        beanRegistroServicios.listaServicios = listaServicios;
    }

    public static LinkedList<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setValorBuscado(String valorBuscado) {
        this.valorBuscado = valorBuscado;
    }

    public String getValorBuscado() {
        return valorBuscado;
    }

    public void setMensajeConfirmacion(String mensajeConfirmacion) {
        this.mensajeConfirmacion = mensajeConfirmacion;
    }

    public String getMensajeConfirmacion() {
        return mensajeConfirmacion;
    }
}
