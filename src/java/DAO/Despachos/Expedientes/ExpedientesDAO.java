/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Expedientes;

import Modelos.Expediente;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ExpedientesDAO {

    public List<Expediente> findAllExpedientes();

    public boolean actualizarexpedientes(Expediente entidadExpedientes);

    public boolean Crearexpediente(Expediente entidad);
}
