/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Personas;

import Entidades.Tipopersona;
import Utilidades.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Tellin
 */
public class TipoPersonasDAOimpl implements TipoPersonasDAO{

    @Override
    public List<Tipopersona> findAllTipoPersonas() {
        List<Tipopersona> listaTipoPersonas = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String hql = "from Tipopersona";
        try {
            sesion.beginTransaction();
            listaTipoPersonas = sesion.createQuery(hql).list();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        return listaTipoPersonas;
    }
    
}
