/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Personas;

import Entidades.PersonaTipopersona;

/**
 *
 * @author Tellin
 */
public interface PersonaTipoPersonaDAO {
    public boolean createPTP(PersonaTipopersona entidad);
    public boolean updatePTP(PersonaTipopersona entidad);
}
