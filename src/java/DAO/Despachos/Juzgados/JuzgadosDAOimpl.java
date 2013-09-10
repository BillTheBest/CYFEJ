/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Juzgados;

import Entidades.Juzgados;
import Utilidades.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Usuario
 */
public class JuzgadosDAOimpl implements JuzgadosDAO{

    @Override
    public boolean actualizarjuzgados(Juzgados entidad) {
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
    public List<Juzgados> findAllJuzgados() {
        List<Juzgados> listaJuzgados = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String hql = "from Juzgados";
        try {
            sesion.beginTransaction();
            listaJuzgados = sesion.createQuery(hql).list();
            sesion.beginTransaction().commit();
        }catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        return listaJuzgados;
    }

    @Override
    public boolean CrearJuzgados(Juzgados entidad) {
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
