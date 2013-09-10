/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.AsuntosJudiciales;

import Entidades.Tipoasunto;
import Utilidades.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Tellin
 */
public class TipoAsuntoDAOimpl implements TipoAsuntoDAO{

    @Override
    public List<Tipoasunto> findAllTipoAsunto() {
        List<Tipoasunto> listaTipoAsunto = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String hql = "from Tipoasunto";
        try {
            sesion.beginTransaction();
            listaTipoAsunto = sesion.createQuery(hql).list();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        return listaTipoAsunto;
    }

    @Override
    public boolean guardarTipoAsunto(Tipoasunto entidad) {
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
    public boolean actualizarTipoAsunto(Tipoasunto entidad) {
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
