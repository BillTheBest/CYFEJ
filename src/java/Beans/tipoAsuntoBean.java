/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.Tipoasunto;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Tellin
 */
@Named(value = "tipoAsuntoBean")
@RequestScoped
public class tipoAsuntoBean {

    private Integer idTipoAsunto;
    private String descripcion;
    private boolean activo;
    private Tipoasunto entidad;
    
    public tipoAsuntoBean() {
        entidad = new Tipoasunto();
    }

    public Integer getIdTipoAsunto() {
        return idTipoAsunto;
    }

    public void setIdTipoAsunto(Integer idTipoAsunto) {
        this.idTipoAsunto = idTipoAsunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Tipoasunto getEntidad() {
        return entidad;
    }

    public void setEntidad(Tipoasunto entidad) {
        this.entidad = entidad;
    }
    
    public List<Tipoasunto> listaTipoAsunto(){
        return entidad.listaTipoAsunto();
    }
    
    public void guardar(ActionEvent evt){
        
        String msg;
        entidad.setIdTipoAsunto(idTipoAsunto);
        entidad.setDescripcion(descripcion);
        entidad.setActivo(activo);

        if(entidad.guardarTipoAsunto(entidad)){
            msg = "Registro Guardado Exitosamente";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro de Datos",msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al Insertar los Datos";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Registro de Datos",msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
    }
    
    public void actualizar(ActionEvent evt){
        
        String msg;

        if(entidad.actualizarTipoAsunto(entidad)){
            msg = "Registro Guardado Exitosamente";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro de Datos",msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al Insertar los Datos";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Registro de Datos",msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
    }
    
}
