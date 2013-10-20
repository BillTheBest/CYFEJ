/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelos.AbogadoTipoabogado;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Usuario
 */
@Named(value = "ataBean")
@RequestScoped
public class ataBean {

     private AbogadoTipoabogado entidadATA;
     
    public ataBean() {
       entidadATA = new AbogadoTipoabogado();
    }

    public AbogadoTipoabogado getEntidadATA() {
        return entidadATA;
    }

    public void setEntidadATA(AbogadoTipoabogado entidadATA) {
        this.entidadATA = entidadATA;
    }
    
    public List<AbogadoTipoabogado> listaATA(){
        return entidadATA.listaATA();
    }
}
