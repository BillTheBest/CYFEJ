/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelos.PersonaTipoPersona;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Tellin
 */
@Named(value = "ptpBean")
@RequestScoped
public class ptpBean {

    private PersonaTipoPersona entidadPTP;
    
    public ptpBean() {
        entidadPTP = new PersonaTipoPersona();
    }

    public PersonaTipoPersona getEntidadPTP() {
        return entidadPTP;
    }

    public void setEntidadPTP(PersonaTipoPersona entidadPTP) {
        this.entidadPTP = entidadPTP;
    }
    
    public List<PersonaTipoPersona> listaPTP(){
        return entidadPTP.listaPTP();
    }    
}
