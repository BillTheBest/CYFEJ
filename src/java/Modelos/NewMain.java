/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Utilidades.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Tellin
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        /*
         Creacion de Roles y usuarios
         */
//        Rol rol = new Rol();
//        rol.setNombreRol("Administrador");
//        sesion.save(rol);
//
//        Usuarios usuario = new Usuarios();
//        usuario.setAlias("admin");
//        usuario.setContrasena("admin");
//        usuario.setActivo(true);
//        usuario.setRoles(rol);
//        rol.getUsuario().add(usuario);
//        sesion.save(usuario);
//        /*
//         Creacion de Tipos de Asuntos Judiciales
//         */
//        Tipoasunto ta = new Tipoasunto();
//        
//        ta.setActivo(true);
//        ta.setDescripcion("Familiar");
//        sesion.save(ta);
//        
//        Asuntojudicial aj = new Asuntojudicial();
//        
//        aj.setActivo(true);
//        aj.setDescripcion("Demanda Alimenticia");
//        
//        aj.setTipoasunto(ta); 
//        ta.getAsuntojudiciales().add(aj);
        
        /*Creacion Departamentos*/
        Departamento dep = new Departamento();
        
        dep.setNombreDepartamento("Boaco");
        sesion.save(dep);
        
        
//        sesion.save(aj);
//        Persona persona1 = new Persona();
//        
//        persona1.setNombrePersona("Francis");
//        persona1.setPrimerApellido("Castillo");
//        persona1.setSegundoApellido("Salgado");
//        persona1.setCedulaPersona("001-230389-0064X" );
//        persona1.setDireccion("Loma Linda");
//        persona1.setTelefono(22222222);
//        persona1.setCelular(88888888);
//        persona1.setEmail("dalila@gmail.com");
//        persona1.setObservaciones("ninguna");
//        
//        TipoPersona tp = new TipoPersona();
//        tp.setDescripcion("Demandante");
//        sesion.save(tp);
//        
//        PersonaTipoPersona ptp = new PersonaTipoPersona();
//        ptp.setPersona(persona1);
//        ptp.setTipoPersona(tp);
//        ptp.setActivo(true);
//        
//        persona1.getPtp().add(ptp);
//                
//        sesion.save(persona1);
        
        sesion.beginTransaction().commit();
        sesion.close();

    }
}
