/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Expedientes;

import Entidades.Expediente;
import Utilidades.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class ExpedientesDAOimpl implements ExpedientesDAO{
    private Object entidad;

    @Override
    public List<Expediente> findAllExpedientes() {
        List<Expediente> listaExpedientes = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String hql = "from expediente";
        try {
            sesion.beginTransaction();
            listaExpedientes = sesion.createQuery(hql).list();
            sesion.beginTransaction().commit();
        }catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        return listaExpedientes;
    }

    @Override
    public boolean actualizarexpedientes(Expediente entidadExpedientes) {
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

    @Override
    public boolean Crearexpediente(Expediente entidad) {
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
    
}
