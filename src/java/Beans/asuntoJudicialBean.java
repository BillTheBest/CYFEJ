/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelos.Asuntojudicial;
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
@Named(value = "asuntoJudicialBean")
@RequestScoped
public class asuntoJudicialBean {

    private Long idAsuntoJudicial;
    private String descripcion;
    private boolean activo;
    private Asuntojudicial entidadAsuntojudicial;
    
    public asuntoJudicialBean() {
        entidadAsuntojudicial = new Asuntojudicial();
    }

    public Long getIdAsuntoJudicial() {
        return idAsuntoJudicial;
    }

    public void setIdAsuntoJudicial(Long idAsuntoJudicial) {
        this.idAsuntoJudicial = idAsuntoJudicial;
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

    public Asuntojudicial getEntidadAsuntojudicial() {
        return entidadAsuntojudicial;
    }

    public void setEntidadAsuntojudicial(Asuntojudicial entidadAsuntojudicial) {
        this.entidadAsuntojudicial = entidadAsuntojudicial;
    }
    
    public List<Asuntojudicial> listaAsunto(){
        return entidadAsuntojudicial.listaAsunto();
    }
    
    public void guardar(ActionEvent evt){
        
        String msg;
        entidadAsuntojudicial.setIdAsuntoJudicial(idAsuntoJudicial);
        entidadAsuntojudicial.setDescripcion(descripcion);
        entidadAsuntojudicial.setActivo(activo);

        if(entidadAsuntojudicial.guardarAsunto(entidadAsuntojudicial)){
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

        if(entidadAsuntojudicial.actualizarAsunto(entidadAsuntojudicial)){
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
