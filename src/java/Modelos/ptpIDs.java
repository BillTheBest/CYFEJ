/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author Tellin
 */
@Embeddable
public class ptpIDs implements java.io.Serializable {
    
    private Persona persona;
    private TipoPersona tipoPersona;

    @ManyToOne
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @ManyToOne
    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
 
        ptpIDs that = (ptpIDs) o;
 
        if (persona != null ? !persona.equals(that.persona) : that.persona != null) {
            return false;
        }
        if (tipoPersona != null ? !tipoPersona.equals(that.tipoPersona) : that.tipoPersona != null) {
            return false;
        }
 
        return true;
    }
 
    @Override
    public int hashCode() {
        int result;
        result = (persona != null ? persona.hashCode() : 0);
        result = 31 * result + (tipoPersona != null ? tipoPersona.hashCode() : 0);
        return result;
    }
    
}
