/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Abogados;

import Entidades.Abogados;
import java.util.List;

public interface AbogadosDAO {
    
    public List<Abogados> findAllAbogados();
    public boolean Crearabogados(Abogados entidad);
    public boolean actualizarabogados(Abogados entidad);
    
}
