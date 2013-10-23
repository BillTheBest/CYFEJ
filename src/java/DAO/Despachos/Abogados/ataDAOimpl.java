/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Despachos.Abogados;

import Modelos.AbogadoTipoabogado;
import Modelos.Abogados;
import Modelos.Tipoabogado;
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

    @Override
    public boolean guardarATAbogado(Abogados abogados, Long idTipoAbogado) {
        boolean bandera;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        try {
            sesion.beginTransaction();
            Tipoabogado ta = (Tipoabogado) sesion.get(Tipoabogado.class, idTipoAbogado);
            AbogadoTipoabogado ata = new AbogadoTipoabogado();
            ata.setAbogados(abogados);
            ata.setTipoabogado(ta);
            sesion.save(ata);
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
