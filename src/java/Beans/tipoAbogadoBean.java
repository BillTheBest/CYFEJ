/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelos.Tipoabogado;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Usuario
 */
@Named(value = "tipoAbogadoBean")
@RequestScoped
public class tipoAbogadoBean {

    private Tipoabogado entidad;
    private List<SelectItem> listaAbogados;
    
    public tipoAbogadoBean() {
        entidad = new Tipoabogado();
    }
     public List<SelectItem> getListaAbogados() {
        listaAbogados = new ArrayList<SelectItem>();
        List<Tipoabogado> lista = entidad.listaTipoabogados();
        for (Tipoabogado tipoabogado : lista) {
            SelectItem item = new SelectItem(tipoabogado.getIdTipoAbogado(), tipoabogado.getDescripcion());
            listaAbogados.add(item);
        }
        return listaAbogados;
    }
}
