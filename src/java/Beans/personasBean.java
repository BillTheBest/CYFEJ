/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelos.Persona;
import Modelos.PersonaTipoPersona;
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
@Named(value = "personasBean")
@RequestScoped
public class personasBean {

    private Long idPersona;
    private Long idTipoPersona;
    private String nombrePersona;
    private String primerApellidoPersona;
    private String segundoApellidoPersona;
    private String cedulaPersona;
    private String direccionPersona;
    private int telefonoPersona;
    private int celularPersona;
    private String emailPersona;
    private String observaciones;
    private boolean activo;
    private Persona entidadPersonas;
    private PersonaTipoPersona entidadptp;
            
    public personasBean() {
        entidadPersonas = new Persona();
        entidadptp = new PersonaTipoPersona();
    }

    public Long getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(Long idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getPrimerApellidoPersona() {
        return primerApellidoPersona;
    }

    public void setPrimerApellidoPersona(String primerApellidoPersona) {
        this.primerApellidoPersona = primerApellidoPersona;
    }

    public String getSegundoApellidoPersona() {
        return segundoApellidoPersona;
    }

    public void setSegundoApellidoPersona(String segundoApellidoPersona) {
        this.segundoApellidoPersona = segundoApellidoPersona;
    }

    public String getCedulaPersona() {
        return cedulaPersona;
    }

    public void setCedulaPersona(String cedulaPersona) {
        this.cedulaPersona = cedulaPersona;
    }

    public String getDireccionPersona() {
        return direccionPersona;
    }

    public void setDireccionPersona(String direccionPersona) {
        this.direccionPersona = direccionPersona;
    }

    public int getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(int telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    public int getCelularPersona() {
        return celularPersona;
    }

    public void setCelularPersona(int celularPersona) {
        this.celularPersona = celularPersona;
    }

    public String getEmailPersona() {
        return emailPersona;
    }

    public void setEmailPersona(String emailPersona) {
        this.emailPersona = emailPersona;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public Persona getEntidadPersonas() {
        return entidadPersonas;
    }

    public void setEntidadPersonas(Persona entidadPersonas) {
        this.entidadPersonas = entidadPersonas;
    }
    
    public List<Persona> listaPersonas(){
        return entidadPersonas.listaPersonas();
        //return null;
    }
    
    public void guardar(ActionEvent evt){
        
        String msg;
        entidadPersonas.setIdPersona(this.getIdPersona());
        entidadPersonas.setNombrePersona(this.getNombrePersona());
        entidadPersonas.setPrimerApellido(this.getPrimerApellidoPersona());
        entidadPersonas.setSegundoApellido(this.getSegundoApellidoPersona());
        entidadPersonas.setCedulaPersona(this.getCedulaPersona());
        entidadPersonas.setDireccion(this.getDireccionPersona());
        entidadPersonas.setTelefono(this.getTelefonoPersona());
        entidadPersonas.setCelular(this.getCelularPersona());
        entidadPersonas.setEmail(this.getEmailPersona());
        entidadPersonas.setActivo(isActivo());
        entidadPersonas.setObservaciones(this.getObservaciones());

        if(entidadPersonas.GuardarPersona(entidadPersonas)){
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
        
        if(entidadPersonas.actualizarPersona(entidadPersonas)){
            msg = "Registro Actualizado Exitosamente";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro de Datos",msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al Actualizar los Datos";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Registro de Datos",msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
    }
    
    public void guardarPTP(ActionEvent evt){
        String msg;
        
        if(entidadptp.SavePTPersons(entidadPersonas, getIdTipoPersona())){
            msg = "Registro Guardado Exitosamente";
            entidadPersonas = null;
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro de Datos",msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        else{
            msg = "Error al Insertar los Datos";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Registro de Datos",msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
