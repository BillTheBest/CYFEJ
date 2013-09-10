/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Juzgados;

import Entidades.Juzgados;
import java.util.List;

public interface JuzgadosDAO {

    public boolean CrearJuzgados(Juzgados entidad);
    public boolean actualizarjuzgados(Juzgados entidad);
    public List<Juzgados> findAllJuzgados();
}
