/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Usuarios;

import Entidades.Usuarios;

/**
 *
 * @author Tellin
 */
public interface UsuarioDAO {
    public Usuarios findByUsuarios(Usuarios usuario);
    public Usuarios login(Usuarios usuario);
}
