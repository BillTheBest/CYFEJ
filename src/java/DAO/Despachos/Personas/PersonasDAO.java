/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Personas;

import Entidades.Personas;
import java.util.List;

public interface PersonasDAO {
    public List<Personas> findAllPersons();
    public boolean CreatePersons(Personas entidad);
    public boolean UpdatePersons(Personas entidad);
}
