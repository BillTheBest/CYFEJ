/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import DAO.Despachos.Personas.ptpDAO;
import DAO.Despachos.Personas.ptpDAOimpl;
import java.util.List;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Tellin
 */
@Entity
@Table(name = "personatipopersona")
@AssociationOverrides({
    @AssociationOverride(name = "ids.persona", joinColumns =
    @JoinColumn(name = "idPersona")),
    @AssociationOverride(name = "ids.tipoPersona", joinColumns =
    @JoinColumn(name = "idTipoPersona"))})
public class PersonaTipoPersona implements java.io.Serializable {

    private ptpIDs ids = new ptpIDs();
    private ptpDAO dao;

    public PersonaTipoPersona() {
        dao = new ptpDAOimpl();
    }

    @EmbeddedId
    public ptpIDs getIds() {
        return ids;
    }

    public void setIds(ptpIDs ids) {
        this.ids = ids;
    }

    @Transient
    public Persona getPersona() {
        return getIds().getPersona();
    }

    public void setPersona(Persona persona) {
        getIds().setPersona(persona);
    }

    @Transient
    public TipoPersona getTipoPersona() {
        return getIds().getTipoPersona();
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        getIds().setTipoPersona(tipoPersona);
    }
    
    public List<PersonaTipoPersona> listaPTP(){
        return dao.listaPTP();
    }

    public boolean SavePTPersons(Persona persona, Long idTipoPersona){
        return  dao.SavePTPersons(persona,idTipoPersona);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PersonaTipoPersona that = (PersonaTipoPersona) o;

        if (getIds() != null ? !getIds().equals(that.getIds())
                : that.getIds() != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return (getIds() != null ? getIds().hashCode() : 0);
    }
    
}
