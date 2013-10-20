/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Abogados;

import Modelos.Tipoabogado;
import java.util.List;
/**
 *
 * @author Usuario
 */
public interface TipoAbogadosDAO {
    public List<Tipoabogado> findAllTipoabogados();
    public Tipoabogado findbyID(Long id);
}
