/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Personas;

import Modelos.Persona;
import Utilidades.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Tellin
 */
public class PersonasDAOimpl implements PersonasDAO{

    @Override
    public List<Persona> findAllPersons() {
        List<Persona> listaPersonas = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Persona";
        try {
            sesion.beginTransaction();
            listaPersonas = sesion.createQuery(hql).list();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        finally{
            sesion.close();
        }
        return listaPersonas;
    }

    @Override
    public boolean CreatePersons(Persona entidad) {
        boolean bandera;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            sesion.beginTransaction();
            sesion.save(entidad);
            sesion.beginTransaction().commit();
            bandera = true;
        } catch (Exception e) {
            bandera = false;
            sesion.beginTransaction().rollback();
        }
        finally{
            sesion.close();
        }
        return bandera;
    }

    @Override
    public boolean UpdatePersons(Persona entidad) {
        boolean bandera;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            sesion.beginTransaction();
            sesion.update(entidad);
            sesion.beginTransaction().commit();
            bandera = true;
        } catch (Exception e) {
            bandera = false;
            sesion.beginTransaction().rollback();
        }
        finally{
            sesion.close();
        }
        return bandera;
    }
    
}
