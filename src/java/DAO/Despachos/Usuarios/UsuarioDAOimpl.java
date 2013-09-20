/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Usuarios;

import Modelos.Usuarios;
import Utilidades.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Tellin
 */
public class UsuarioDAOimpl implements UsuarioDAO{

    @Override
    public Usuarios findByUsuarios(Usuarios usuario) {
        Usuarios entidad = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Usuarios where alias = '"+usuario.getAlias()+"'";
        try {
            sesion.beginTransaction();
            entidad = (Usuarios) sesion.createQuery(hql).uniqueResult();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        return entidad;
    }

    @Override
    public Usuarios login(Usuarios usuario) {
        Usuarios entidad = findByUsuarios(usuario);
        if(entidad != null){
            if(!usuario.getContrasena().equals(entidad.getContrasena())){
                entidad = null;
            }
        }
        return  entidad;
    }
    
}
