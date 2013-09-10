/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.AsuntosJudiciales;

import Entidades.Asuntojudicial;
import java.util.List;

/**
 *
 * @author Tellin
 */
public interface AsuntoJudicialDAO {
    public boolean guardarAsunto(Asuntojudicial entidad);
    public boolean actualizarAsunto(Asuntojudicial entidad);
    public List<Asuntojudicial> listaAsuntos();
}
