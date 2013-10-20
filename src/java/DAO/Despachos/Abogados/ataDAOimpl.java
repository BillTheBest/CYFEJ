/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Abogados;

import Modelos.AbogadoTipoabogado;
import Utilidades.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Usuario
 */
public class ataDAOimpl implements ataDAO{           

    @Override
    public List<AbogadoTipoabogado> listaATA() {
        List<AbogadoTipoabogado> atalist = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String hql = "from AbogadoTipoabogado ata ";
        try {
            sesion.beginTransaction();
            atalist = sesion.createQuery(hql).list();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        return atalist;
    }
    
}
