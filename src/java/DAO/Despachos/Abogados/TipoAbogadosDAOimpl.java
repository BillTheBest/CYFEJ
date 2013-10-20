/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Abogados;

import Modelos.Tipoabogado;
import Utilidades.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Usuario
 */
public class TipoAbogadosDAOimpl implements TipoAbogadosDAO {
  
    @Override
    public List<Tipoabogado> findAllTipoabogados() {
         List<Tipoabogado> listaTipoabogados = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String hql = "from Tipoabogado";
        try {
            sesion.beginTransaction();
            listaTipoabogados = sesion.createQuery(hql).list();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        return listaTipoabogados;
    }
    @Override
    public Tipoabogado findbyID(Long id) {
        Tipoabogado tipoabogado = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String hql = "from TipoAbogado ta where ta.idTipoAbogado = "+id;
        try {
            sesion.beginTransaction();
            tipoabogado = (Tipoabogado) sesion.createQuery(hql).uniqueResult();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        return tipoabogado;
    }

}
