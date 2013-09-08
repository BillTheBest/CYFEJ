/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Personas;

import Entidades.Personas;
import Utilidades.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Tellin
 */
public class PersonasDAOimpl implements PersonasDAO{

    @Override
    public List<Personas> findAllPersons() {
        List<Personas> listaPersonas = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String hql = "from Personas";
        try {
            sesion.beginTransaction();
            listaPersonas = sesion.createQuery(hql).list();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        return listaPersonas;
    }

    @Override
    public boolean CreatePersons(Personas entidad) {
        boolean bandera;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.save(entidad);
            sesion.beginTransaction().commit();
            bandera = true;
        } catch (Exception e) {
            bandera = false;
            sesion.beginTransaction().rollback();
        }
        return bandera;
    }

    @Override
    public boolean UpdatePersons(Personas entidad) {
        boolean bandera;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.update(entidad);
            sesion.beginTransaction().commit();
            bandera = true;
        } catch (Exception e) {
            bandera = false;
            sesion.beginTransaction().rollback();
        }
        return bandera;
    }
    
}
