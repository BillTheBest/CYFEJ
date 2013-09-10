/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.Despachos.Abogados.AbogadosDAO;
import DAO.Despachos.Abogados.AbogadosDAOimpl;
import Entidades.Abogados;
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
@Named(value = "abogadosBean")
@RequestScoped
public class abogadosBean {

    private Integer idAbogado;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String noCarne;
    private String cedula;
    private String direccion;
    private Integer telefono;
    private Integer celular;
    private String email;
    private Abogados entidadAbogados;    
    
    public abogadosBean() {
        
        entidadAbogados = new Abogados();
    }

    public Integer getIdAbogado() {
        
        return idAbogado;
    }

    public void setIdAbogado(Integer idAbogado) {
        this.idAbogado = idAbogado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNoCarne() {
        return noCarne;
    }

    public void setNoCarne(String noCarne) {
        this.noCarne = noCarne;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Abogados getEntidadAbogados() {
        return entidadAbogados;
    }

    public void setEntidadAbogados(Abogados entidadAbogados) {
        this.entidadAbogados = entidadAbogados;
    }
    
    public List<Abogados> listaAbogados(){
    
        return entidadAbogados.listaAbogados();
    }
   
    public void guardar(ActionEvent evt) {
    
        String msg;
        entidadAbogados.setIdAbogado(this.getIdAbogado());
        entidadAbogados.setNombre(this.getNombre());
        entidadAbogados.setPrimerApellido(this.getPrimerApellido());
        entidadAbogados.setSegundoApellido(this.getPrimerApellido());
        entidadAbogados.setNoCarne(this.getNoCarne());
        entidadAbogados.setCedula(this.getCedula());
        entidadAbogados.setDireccion(this.getDireccion());
        entidadAbogados.setTelefono(this.getTelefono());
        entidadAbogados.setCelular(this.getCelular());       
        entidadAbogados.setEmail(this.getEmail());
        
        if(entidadAbogados.GuardarAbogados(entidadAbogados)) {
            msg = "Registro guardado exitosamente";                    
        } else {
            msg = "Error al insertar los datos";
        }
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro de Datos",msg);
        FacesContext.getCurrentInstance().addMessage(null, message);        
    }
    
    public void actualizar(ActionEvent evt){
        String msg;
            AbogadosDAO dao = new AbogadosDAOimpl();
        
        if(dao.actualizarabogados(entidadAbogados)){
             msg = "Registro Actualizado Exitosamente";
        }else {
            msg = "Error al Actualizar los Datos";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro de Datos",msg);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
