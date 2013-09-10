/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.AsuntosJudiciales;

import Entidades.Asuntojudicial;
import Utilidades.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Tellin
 */
public class AsuntoJudicialDAOimpl implements AsuntoJudicialDAO{

    @Override
    public List<Asuntojudicial> listaAsuntos() {
        List<Asuntojudicial> listaAsuntoJudicial = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String hql = "from Asuntojudicial aj left join fetch aj.tipoasunto";
        try {
            sesion.beginTransaction();
            listaAsuntoJudicial = sesion.createQuery(hql).list();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        return listaAsuntoJudicial;
    }

    @Override
    public boolean guardarAsunto(Asuntojudicial entidad) {
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
    public boolean actualizarAsunto(Asuntojudicial entidad) {
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
