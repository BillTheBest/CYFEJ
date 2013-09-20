/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Personas;

import Modelos.Persona;
import java.util.List;

public interface PersonasDAO {
    public List<Persona> findAllPersons();
    public boolean CreatePersons(Persona entidad, Long idTipoPersona, boolean activo);
    public boolean UpdatePersons(Persona entidad, Long idTipoPersona, boolean activo);
}
