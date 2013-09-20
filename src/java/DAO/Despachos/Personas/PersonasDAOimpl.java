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
public class PersonasDAOimpl implements PersonasDAO{

    @Override
    public List<Persona> findAllPersons() {
        List<Persona> listaPersonas = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String hql = "from Persona p left join fetch p.ptp";
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
    public boolean CreatePersons(Persona entidad, Long idTipoPersona, boolean activo) {
        boolean bandera;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            sesion.beginTransaction();
            TipoPersona tp = (TipoPersona) sesion.get(TipoPersona.class, idTipoPersona);
            PersonaTipoPersona ptp = new PersonaTipoPersona();
            ptp.setPersona(entidad);
            ptp.setTipoPersona(tp);
            ptp.setActivo(activo);
            entidad.getPtp().add(ptp);
            sesion.save(entidad);
            sesion.beginTransaction().commit();
            sesion.close();
            bandera = true;
        } catch (Exception e) {
            bandera = false;
            sesion.beginTransaction().rollback();
        }
        return bandera;
    }

    @Override
    public boolean UpdatePersons(Persona entidad, Long idTipoPersona, boolean activo) {
        boolean bandera;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            TipoPersona tp = (TipoPersona) sesion.get(TipoPersona.class, idTipoPersona);
            PersonaTipoPersona ptp = new PersonaTipoPersona();
            ptp.setPersona(entidad);
            ptp.setTipoPersona(tp);
            ptp.setActivo(activo);
            entidad.getPtp().add(ptp);
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
