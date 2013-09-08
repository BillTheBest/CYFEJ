/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tellin
 */
public class AuthorizationListener implements PhaseListener{

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext context = event.getFacesContext();
        String pagActual = context.getViewRoot().getViewId();
        boolean isLoginPage = (pagActual.lastIndexOf("login.xhtml") > -1) ? true : false;
        HttpSession sesion = (HttpSession) context.getExternalContext().getSession(true);
        Object usuario = sesion.getAttribute("usuario");
        
        if(!isLoginPage && usuario == null){
            NavigationHandler nh = context.getApplication().getNavigationHandler();
            nh.handleNavigation(context, null, "/login.xhtml");
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
}
