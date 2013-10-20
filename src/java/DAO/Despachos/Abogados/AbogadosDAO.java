/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Abogados;

import Modelos.Abogados;
import java.util.List;

public interface AbogadosDAO {    
    public List<Abogados> findAllAbogados();
    public boolean Crearabogados(Abogados entidad, Long idTipoAbogado, boolean Activo);
    public boolean actualizarabogados(Abogados entidad, Long idTipoAbogado, boolean Activo);
}
