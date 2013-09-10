/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.Despachos.Expedientes.ExpedientesDAO;
import DAO.Despachos.Expedientes.ExpedientesDAOimpl;
import Entidades.Expediente;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Usuario
 */
@Named(value = "expedientesBean")
@RequestScoped
public class expedientesBean {

     private Integer idExpediente;
     private String descripcion;
     private Date fechaAlta;
     private Date fechaBaja;
     private int anio;
     private int idAsuntoJudicial;
     private int idJuzgados;
     private int idUsuarios;
     private Set estadoexpedientes = new HashSet(0);
     private Expediente entidadExpedientes;
     
    public expedientesBean() {
        entidadExpedientes = new Expediente();
    }

    public Integer getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(Integer idExpediente) {
        this.idExpediente = idExpediente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Expediente getEntidadExpedientes() {
        return entidadExpedientes;
    }

    public void setEntidadExpedientes(Expediente entidadExpedientes) {
        this.entidadExpedientes = entidadExpedientes;
    }
   
    public List<Expediente> listaExpedientes(){
        return entidadExpedientes.listaExpedientes();
    }
  
    public void guardar(ActionEvent evt){
        String msg;
        entidadExpedientes.setIdExpediente(this.getIdExpediente());
        entidadExpedientes.setDescripcion(this.getDescripcion());
        entidadExpedientes.setFechaAlta(this.fechaAlta);
        entidadExpedientes.setFechaBaja(this.getFechaBaja());
        entidadExpedientes.setAnio(this.getAnio());
        
        if(entidadExpedientes.GuardarExpediente(entidadExpedientes) ){
            msg = "Registro guardado exitosamente";                    
        } else {
            msg = "Error al insertar los datos";
        }
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro de Datos",msg);
        FacesContext.getCurrentInstance().addMessage(null, message);        
    
    }
   
     public void actualizar(ActionEvent evt){
        String msg;
        
            ExpedientesDAO dao = new ExpedientesDAOimpl();
           
        
        if(dao.actualizarexpedientes(entidadExpedientes)){
             msg = "Registro Actualizado Exitosamente";
        }else {
            msg = "Error al Actualizar los Datos";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro de Datos",msg);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
