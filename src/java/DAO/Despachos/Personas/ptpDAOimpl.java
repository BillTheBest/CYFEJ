/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Personas;

import Modelos.Persona;
import Modelos.PersonaTipoPersona;
import Modelos.TipoPersona;
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
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String hql = "from PersonaTipoPersona ptp";
        try {
            sesion.beginTransaction();
            ptplist = sesion.createQuery(hql).list();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        finally{
            sesion.close();
        }
        return ptplist;
    }

    @Override
    public boolean SavePTPersons(Persona persona, Long idTipoPersona) {
        boolean bandera;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            sesion.beginTransaction();
            TipoPersona tp = (TipoPersona) sesion.get(TipoPersona.class, idTipoPersona);
            PersonaTipoPersona ptp = new PersonaTipoPersona();
            ptp.setPersona(persona);
            ptp.setTipoPersona(tp);
            sesion.save(ptp);
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
