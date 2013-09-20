/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.AsuntosJudiciales;

import Modelos.Tipoasunto;
import java.util.List;

/**
 *
 * @author Tellin
 */
public interface TipoAsuntoDAO {
    public List<Tipoasunto> findAllTipoAsunto();
    public boolean guardarTipoAsunto(Tipoasunto entidad);
    public boolean actualizarTipoAsunto(Tipoasunto entidad);
}
