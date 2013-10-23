/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelos.AbogadoTipoabogado;
import Modelos.Abogados;
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

    private Long idAbogado;
    private Long idTipoAbogado;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String noCarne;
    private String cedula;
    private String direccion;
    private int telefono;
    private int celular;
    private String email;
    private boolean activo;
    private Abogados entidadAbogados;  
    private AbogadoTipoabogado entidadata;
    
    public abogadosBean() {
        entidadAbogados = new Abogados();
        entidadata = new AbogadoTipoabogado();
    }

    public Long getIdTipoAbogado() {
        return idTipoAbogado;
    }

    public void setIdTipoAbogado(Long idTipoAbogado) {
        this.idTipoAbogado = idTipoAbogado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public Long getIdAbogado() {
        return idAbogado;
    }

    public void setIdAbogado(Long idAbogado) {
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

      public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
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
        return entidadAbogados.listaabogados();
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
        
        if(entidadAbogados.GuardarAbogados(entidadAbogados, getIdTipoAbogado(), isActivo())) {
            msg = "Registro guardado exitosamente";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro de Datos",msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al insertar los datos";
               FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Registro de Datos",msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }    
    }
    
    public void actualizar(ActionEvent evt){
        String msg;            
        
        if(entidadAbogados.actualizarAbogados(entidadAbogados, getIdTipoAbogado(), isActivo())){
             msg = "Registro Actualizado Exitosamente";
             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro de Datos",msg);
             FacesContext.getCurrentInstance().addMessage(null, message);
        }else {
            msg = "Error al Actualizar los Datos";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro de Datos",msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }      
    }
    
     public void guardarATA(ActionEvent evt){
        String msg;
        
        if(entidadata.guardarATAbogado(entidadAbogados, getIdTipoAbogado())){
            msg = "Registro Guardado Exitosamente";
            entidadAbogados = null;
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro de Datos",msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        else{
            msg = "Error al Insertar los Datos";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Registro de Datos",msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
