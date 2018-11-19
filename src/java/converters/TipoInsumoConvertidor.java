/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import dao.TiposInsumosFacade;
import entities.TiposInsumos;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

/**
 *
 * @author WilfredoFlamenco
 */
@Named(value = "tipoInsumoConvertidor")
@ManagedBean
@ViewScoped
public class TipoInsumoConvertidor implements Converter{

    @EJB
    private TiposInsumosFacade tiposInsumosFacade;
    
    public TipoInsumoConvertidor() {
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("") || value.trim().equals("Seleccione uno...")) {
            return null;
        } else {
            try {
                int id = Integer.parseInt(value);
                TiposInsumos tipo = getTiposInsumosFacade().find(id);
                return tipo;
            } catch (Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "Seleccione una unidad de medida."));
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof TiposInsumos)) {
            return null;
        }
        return String.valueOf(((TiposInsumos) value).getTipoinsumoId());
    }

    public TiposInsumosFacade getTiposInsumosFacade() {
        return tiposInsumosFacade;
    }
    
}
