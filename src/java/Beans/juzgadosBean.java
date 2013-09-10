/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.Despachos.Juzgados.JuzgadosDAO;
import DAO.Despachos.Juzgados.JuzgadosDAOimpl;
import Entidades.Juzgados;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Usuario
 */
@Named(value = "juzgadosBean")
@RequestScoped
public class juzgadosBean {
    
     private Integer idJuzgados;
     private String descripcion;
     private String direccion;
     private int telefono;
     private Integer celular;
     private Juzgados entidadJuzgados;
     
    public juzgadosBean() {
        
        entidadJuzgados = new Juzgados();
    }

    public Integer getIdJuzgados() {
        return idJuzgados;
    }

    public void setIdJuzgados(Integer idJuzgados) {
        this.idJuzgados = idJuzgados;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public Juzgados getEntidadJuzgados() {
        return entidadJuzgados;
    }

    public void setEntidadJuzgados(Juzgados entidadJuzgados) {
        this.entidadJuzgados = entidadJuzgados;
    }
    
    public List<Juzgados> listaJuzgados(){
        return entidadJuzgados.listaJuzgados();
    }
   
    public void guardar(ActionEvent evt) {
    
        String msg;
        entidadJuzgados.setIdJuzgados(this.getIdJuzgados());
        entidadJuzgados.setDescripcion(this.getDescripcion());
        entidadJuzgados.setDireccion(this.getDireccion());
        entidadJuzgados.setTelefono(this.getTelefono());
        entidadJuzgados.setCelular(this.getCelular());
        
        if(entidadJuzgados.GuardarJuzgados(entidadJuzgados)){
            msg = "Registro guardado exitosamente";                    
        } else {
            msg = "Error al insertar los datos";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro de Datos",msg);
        FacesContext.getCurrentInstance().addMessage(null, message);        
    }
    
    public void actualizar(ActionEvent evt){
        String msg;
        
        JuzgadosDAO dao = new JuzgadosDAOimpl();
        
        if(dao.actualizarjuzgados(entidadJuzgados)){
             msg = "Registro Actualizado Exitosamente";
        }else {
            msg = "Error al Actualizar los Datos";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro de Datos",msg);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
