/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.Despachos.Personas.PersonasDAO;
import DAO.Despachos.Personas.PersonasDAOimpl;
import Entidades.Personas;
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

    private Integer idPersona;
    private String nombrePersona;
    private String primerApellidoPersona;
    private String segundoApellidoPersona;
    private String cedulaPersona;
    private String direccionPersona;
    private int telefonoPersona;
    private int celularPersona;
    private String emailPersona;
    private String observaciones;
    private Personas entidadPersonas;
    
    public personasBean() {
        entidadPersonas = new Personas();
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
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
    
    public Personas getEntidadPersonas() {
        return entidadPersonas;
    }

    public void setEntidadPersonas(Personas entidadPersonas) {
        this.entidadPersonas = entidadPersonas;
    }
    
    public List<Personas> listaPersonas(){
        return entidadPersonas.listaPersonas();
    }
    
    public void guardar(ActionEvent evt){
        
        String msg;
        entidadPersonas.setIdPersona(this.getIdPersona());
        entidadPersonas.setNombrePersona(this.getNombrePersona());
        entidadPersonas.setPrimerApellidoPersona(this.getPrimerApellidoPersona());
        entidadPersonas.setSegundoApellidoPersona(this.getSegundoApellidoPersona());
        entidadPersonas.setCedulaPersona(this.getCedulaPersona());
        entidadPersonas.setDireccionPersona(this.getDireccionPersona());
        entidadPersonas.setTelefonoPersona(this.getTelefonoPersona());
        entidadPersonas.setCelularPersona(this.getCelularPersona());
        entidadPersonas.setEmailPersona(this.getEmailPersona());
        entidadPersonas.setObservaciones(this.getObservaciones());

        if(entidadPersonas.GuardarPersona(entidadPersonas)){
            msg = "Registro Guardado Exitosamente";
        } else {
            msg = "Error al Insertar los Datos";
        }
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro de Datos",msg);
        FacesContext.getCurrentInstance().addMessage(null, message);
        
    }
    
    public void actualizar(ActionEvent evt){
        
        String msg;
        PersonasDAO dao = new PersonasDAOimpl();
        
        if(dao.UpdatePersons(entidadPersonas)){
            msg = "Registro Actualizado Exitosamente";
        } else {
            msg = "Error al Actualizar los Datos";
        }
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro de Datos",msg);
        FacesContext.getCurrentInstance().addMessage(null, message);
        
    }
    
}
