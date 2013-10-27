/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelos.Abogados;
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
     private Abogados entidadAbogados;
     private Long idTipoAbogado;
     private Long idAbogado;
     
    public ataBean() {
       entidadATA = new AbogadoTipoabogado();
    }

    public Abogados getEntidadAbogados() {
        return entidadAbogados;
    }

    public void setEntidadAbogados(Abogados entidadAbogados) {
        this.entidadAbogados = entidadAbogados;
    }

    public Long getIdTipoAbogado() {
        return idTipoAbogado;
    }

    public void setIdTipoAbogado(Long idTipoAbogado) {
        this.idTipoAbogado = idTipoAbogado;
    }

    public Long getIdAbogado() {
        return idAbogado;
    }

    public void setIdAbogado(Long idAbogado) {
        this.idAbogado = idAbogado;
    }

    public List<AbogadoTipoabogado> listaATA(){
        return entidadATA.listaATA();
    }
}
