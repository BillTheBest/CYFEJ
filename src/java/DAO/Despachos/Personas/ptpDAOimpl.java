/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Personas;

import Modelos.PersonaTipoPersona;
import Utilidades.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Tellin
 */
public class ptpDAOimpl implements ptpDAO{

    @Override
    public List<PersonaTipoPersona> listaPTP() {
        List<PersonaTipoPersona> ptplist = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String hql = "from PersonaTipoPersona ptp ";
        try {
            sesion.beginTransaction();
            ptplist = sesion.createQuery(hql).list();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        return ptplist;
    }
    
}
