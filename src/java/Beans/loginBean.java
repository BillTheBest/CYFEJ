/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.Despachos.Usuarios.UsuarioDAO;
import DAO.Despachos.Usuarios.UsuarioDAOimpl;
import Modelos.Usuarios;
import Utilidades.MyUtil;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Tellin
 */
@Named(value="loginBean")
@SessionScoped
public class loginBean implements Serializable{

    private Usuarios entidad;
    private UsuarioDAO dao;
    
    public loginBean() {
        dao = new UsuarioDAOimpl();
        if(entidad == null){
            entidad = new Usuarios();
        }
    }

    public Usuarios getEntidad() {
        return entidad;
    }

    public void setEntidad(Usuarios entidad) {
        this.entidad = entidad;
    }
    
    public void login(ActionEvent actionEvent) {  
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg;  
        boolean loggedIn;
        String ruta = "";
        entidad = dao.login(entidad);
          
        if(entidad != null) {  
            loggedIn = true;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",entidad.getAlias());
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", entidad.getAlias());
            ruta = MyUtil.URLBaseLogin()+"Catalogos/inicio.xhtml";
        } else {  
            loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Usuario y/o Clave incorrecto");
            if(entidad == null){
                entidad = new Usuarios();
            }
        }  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);
        context.addCallbackParam("ruta", ruta);
    }
    
    public void logout(){
        String ruta = MyUtil.URLBaseLogin()+"login.xhtml";
        RequestContext reqContext = RequestContext.getCurrentInstance();
        FacesContext facContext = FacesContext.getCurrentInstance();
        
        HttpSession sesion = (HttpSession) facContext.getExternalContext().getSession(false);
        sesion.invalidate();
        
        reqContext.addCallbackParam("loggedOut", true);
        reqContext.addCallbackParam("ruta", ruta);
    }
    
}
