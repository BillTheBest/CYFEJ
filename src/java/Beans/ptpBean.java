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
@Named(value = "ptpBean")
@RequestScoped
public class ptpBean {

    private PersonaTipoPersona entidadPTP;
    private Persona entidadPersona;
    private Long idTipoPersona;
    private Long idPersona;
    
    public ptpBean() {
        entidadPTP = new PersonaTipoPersona();
    }

    public Persona getEntidadPersona() {
        return entidadPersona;
    }

    public void setEntidadPersona(Persona entidadPersona) {
        this.entidadPersona = entidadPersona;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Long getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(Long idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }
    
    public List<PersonaTipoPersona> listaPTP(){
        return entidadPTP.listaPTP();
    }
    
    public void guardar(ActionEvent evt){
        
//        String msg;
//        
//        if(entidadPTP.SavePTPersons(getIdPersona(), getIdTipoPersona())){
//            msg = "Registro Actualizado Exitosamente";
//            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro de Datos",msg);
//            FacesContext.getCurrentInstance().addMessage(null, message);
//        } else {
//            msg = "Error al Actualizar los Datos";
//            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Registro de Datos",msg);
//            FacesContext.getCurrentInstance().addMessage(null, message);
//        }
        
    }
}
