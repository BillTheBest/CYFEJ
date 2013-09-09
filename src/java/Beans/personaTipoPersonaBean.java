/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entidades.PersonaTipopersona;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Tellin
 */
@Named(value = "personaTipoPersonaBean")
@RequestScoped
public class personaTipoPersonaBean {

    private PersonaTipopersona entidad;
    
    public personaTipoPersonaBean() {
    }

    public PersonaTipopersona getEntidad() {
        return entidad;
    }

    public void setEntidad(PersonaTipopersona entidad) {
        this.entidad = entidad;
    }
    
}
