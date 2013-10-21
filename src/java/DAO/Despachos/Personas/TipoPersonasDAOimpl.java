/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Personas;

import Modelos.TipoPersona;
import Utilidades.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Tellin
 */
public class TipoPersonasDAOimpl implements TipoPersonasDAO{

    @Override
    public List<TipoPersona> findAllTipoPersonas() {
        List<TipoPersona> listaTipoPersonas = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String hql = "from TipoPersona";
        try {
            sesion.beginTransaction();
            listaTipoPersonas = sesion.createQuery(hql).list();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        finally{
            sesion.close();
        }
        return listaTipoPersonas;
    }

    @Override
    public TipoPersona findbyID(Long id) {
        TipoPersona tipoPersona = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String hql = "from TipoPersona tp where tp.idTipoPersona = "+id;
        try {
            sesion.beginTransaction();
            tipoPersona = (TipoPersona) sesion.createQuery(hql).uniqueResult();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        finally{
            sesion.close();
        }
        return tipoPersona;
    }
    
}
