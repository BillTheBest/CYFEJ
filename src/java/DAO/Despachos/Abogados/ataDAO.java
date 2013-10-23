/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Abogados;

import Modelos.AbogadoTipoabogado;
import Modelos.Abogados;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ataDAO {
    public List<AbogadoTipoabogado> listaATA();
    public boolean guardarATAbogado(Abogados abogados, Long idTipoAbogado);
}
