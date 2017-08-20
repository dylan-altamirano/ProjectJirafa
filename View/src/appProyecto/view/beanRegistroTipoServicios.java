package appProyecto.view;

import appProyecto.SNMPExceptions;

import appProyecto.model.TipoServicio;
import appProyecto.model.TipoServicioDB;

import java.sql.SQLException;

import javax.naming.NamingException;

public class beanRegistroTipoServicios {
    public String Identificador;
    public String Descripcion;
    public String Estado;
    public String Nulos;

    public TipoServicio ts;
    public TipoServicioDB tsDB;

    public beanRegistroTipoServicios() {
        tsDB = new TipoServicioDB();
    }
    public String eliminarDatos(){
        try {
            tsDB.eliminarTipoServicio(this.getIdentificador());
            this.setNulos("Datos eliminados correctamente");
        } catch (SNMPExceptions e) {
        } catch (SQLException e) {
        }
        return "";
    }
    public String editarDatos() {
        try {
           /*Me está dando error*/ 
            String idTipo = this.getIdentificador();
            ts = tsDB.moBuscarTipoServicio(idTipo);
            if(ts == null){
                this.setNulos("Datos NO encontrados correctamente");
            }
            if(ts != null){
           this.setDescripcion(ts.getDescripcion()); 
            if(ts.isEstado() == 1){
               this.setEstado("true");
            }
            if(ts.isEstado() == 0){
               this.setEstado("false");
            }
            ts.setDescripcion(this.getDescripcion());
               int estadoTipo = 0;
                if(this.getEstado().equalsIgnoreCase("true")){
                    estadoTipo = 1;
                }
            ts.setEstado(estadoTipo);
            tsDB.mvActualizarTipoServicio(ts);
                
                this.setNulos("Datos editados correctamente");
            }
           
        } catch (SNMPExceptions e) {
            this.setNulos("Hubo un error al editar los tipos de servicio" + e.getMensajeParaDesarrollador());
        } catch (SQLException e) {
            this.setNulos("Hubo un error al editar los tipos de servicio" + e.getErrorCode());
        }  catch (NamingException e) {
                }
        return "";
    }
    public String ingresaDatos() {
        try {
            String idTipo = this.getIdentificador();
            String descTipo = this.getDescripcion();
            int estadoTipo = 0;
            if(this.getEstado().equalsIgnoreCase("true")){
                estadoTipo = 1;
            }
            
            ts = new TipoServicio(idTipo, descTipo, estadoTipo);

            tsDB.mvAgregarTipoServicio(ts);
            this.setNulos("Se agrego correctamente");

        } catch (SNMPExceptions e) {
            this.setNulos("Hubo un error al ingresar los tipos de servicio" + e.getMensajeParaDesarrollador());
        }
        return "";
    }
    
    public String buscarDatos() {
        try {
            String idTipo = this.getIdentificador();
            ts = tsDB.moBuscarTipoServicio(idTipo);
            if(ts == null){
                this.setNulos("Datos NO encontrados correctamente");
            }
            if(ts != null){
           this.setDescripcion(ts.getDescripcion()); 
            if(ts.isEstado() == 1){
               this.setEstado("true");
            }
            if(ts.isEstado() == 0){
               this.setEstado("false");
            }
            this.setNulos("Datos encontrados correctamente");
            }
           
        } catch (SNMPExceptions e) {
            this.setNulos("Hubo un error al buscar los tipos de servicio" + e.getMensajeParaDesarrollador());
        } catch (SQLException e) {
            this.setNulos("Hubo un error al buscar los tipos de servicio" + e);
        } 
        return "";
    }

    public String ValidaNulos() {
        if (this.getIdentificador().equalsIgnoreCase("") || this.getDescripcion().equalsIgnoreCase("") ||
            this.getEstado().equalsIgnoreCase("")) {

            if (this.getIdentificador().equalsIgnoreCase("")) {
                this.setNulos("Debe completar el espacio de identificacion");
            }
            if (this.getDescripcion().equalsIgnoreCase("")) {
                this.setNulos("Debe completar el espacio de descripción");
            }
        } else {
            this.setNulos("");
        }
        return "";
    }

    public void setIdentificador(String Identificador) {
        this.Identificador = Identificador;
    }

    public String getIdentificador() {
        return Identificador;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getEstado() {
        return Estado;
    }

    public void setNulos(String Nulos) {
        this.Nulos = Nulos;
    }

    public String getNulos() {
        return Nulos;
    }
}
