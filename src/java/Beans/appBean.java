/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Utilidades.MyUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author Tellin
 */
@ManagedBean
@ApplicationScoped
public class appBean {

    public appBean() {
    }
    
    public String urlBase(){
        return MyUtil.URLBase();
    }
    
    public String urlPath(){
        return MyUtil.basePath();
    }
    
}
