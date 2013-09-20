/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelos.TipoPersona;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Tellin
 */
@Named(value = "tipoPersonaBean")
@RequestScoped
public class tipoPersonaBean {

    private TipoPersona entidad;
    private List<SelectItem> listaPersonas;
    
    public tipoPersonaBean() {
        entidad = new TipoPersona();
    }

    public List<SelectItem> getListaPersonas() {
        listaPersonas = new ArrayList<SelectItem>();
        List<TipoPersona> lista = entidad.listaTipoPersona();
        for (TipoPersona tipopersona : lista) {
            SelectItem item = new SelectItem(tipopersona.getIdTipoPersona(), tipopersona.getDescripcion());
            listaPersonas.add(item);
        }
        return listaPersonas;
    }
    
}
