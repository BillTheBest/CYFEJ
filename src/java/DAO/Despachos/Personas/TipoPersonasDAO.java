/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Personas;

import Entidades.Tipopersona;
import java.util.List;

/**
 *
 * @author Tellin
 */
public interface TipoPersonasDAO {
    
    public List<Tipopersona> findAllTipoPersonas();
    
}
