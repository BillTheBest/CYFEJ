/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Abogados;

import Modelos.Abogados;
import Modelos.AbogadoTipoabogado;
import Modelos.Tipoabogado;
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
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String hql = "from Abogados a left join fetch a.ata";
        try {
            sesion.beginTransaction();
            listaabogados = sesion.createQuery(hql).list();
            sesion.beginTransaction().commit();
        }catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        return listaabogados;
    }

    @Override
    public boolean Crearabogados(Abogados entidad, Long idTipoAbogado, boolean Activo) {
        boolean bandera;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            sesion.beginTransaction();
            Tipoabogado ta = (Tipoabogado) sesion.get(Tipoabogado.class, idTipoAbogado);
            AbogadoTipoabogado ata = new AbogadoTipoabogado();            
            ata.setAbogados(entidad);
            ata.setTipoabogado(ta);
            ata.setActivo(Activo);
            entidad.getata().add(ata);
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
    public boolean actualizarabogados(Abogados entidad, Long idTipoAbogado, boolean Activo) {
         boolean bandera;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            Tipoabogado ta = (Tipoabogado) sesion.get(Tipoabogado.class, idTipoAbogado);
            AbogadoTipoabogado ata = new AbogadoTipoabogado();
            ata.setAbogados(entidad);
            ata.setTipoabogado(ta);
            ata.setActivo(Activo);
            entidad.getata().add(ata);
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
