/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Abogados;

import Modelos.Abogados;
import Utilidades.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Usuario
 */
public class AbogadosDAOimpl implements AbogadosDAO{

    @Override
    public List<Abogados> findAllAbogados() {
        List<Abogados> listaabogados = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String hql = "from Abogados";
        try {
            sesion.beginTransaction();
            listaabogados = sesion.createQuery(hql).list();
            sesion.beginTransaction().commit();
        }catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        finally{
            sesion.close();
        }
        return listaabogados;
    }

    @Override
    public boolean Crearabogados(Abogados entidad) {
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
    public boolean actualizarabogados(Abogados entidad) {
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
